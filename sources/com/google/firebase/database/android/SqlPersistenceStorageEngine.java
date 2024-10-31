package com.google.firebase.database.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.UserWriteRecord;
import com.google.firebase.database.core.persistence.PersistenceStorageEngine;
import com.google.firebase.database.core.persistence.PruneForest;
import com.google.firebase.database.core.persistence.TrackedQuery;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.NodeSizeEstimator;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.util.JsonMapper;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class SqlPersistenceStorageEngine implements PersistenceStorageEngine {

    /* renamed from: a, reason: collision with root package name */
    private static final Charset f16659a = Charset.forName("UTF-8");

    /* renamed from: b, reason: collision with root package name */
    private final SQLiteDatabase f16660b;

    /* renamed from: c, reason: collision with root package name */
    private final LogWrapper f16661c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f16662d;

    /* renamed from: e, reason: collision with root package name */
    private long f16663e = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public static class a extends SQLiteOpenHelper {
        public a(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 2);
        }

        private void a(SQLiteDatabase sQLiteDatabase, String str) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE serverCache (path TEXT PRIMARY KEY, value BLOB);");
            sQLiteDatabase.execSQL("CREATE TABLE writes (id INTEGER, path TEXT, type TEXT, part INTEGER, node BLOB, UNIQUE (id, part));");
            sQLiteDatabase.execSQL("CREATE TABLE trackedQueries (id INTEGER PRIMARY KEY, path TEXT, queryParams TEXT, lastUse INTEGER, complete INTEGER, active INTEGER);");
            sQLiteDatabase.execSQL("CREATE TABLE trackedKeys (id INTEGER, key TEXT);");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i <= 1) {
                a(sQLiteDatabase, "serverCache");
                sQLiteDatabase.execSQL("CREATE TABLE serverCache (path TEXT PRIMARY KEY, value BLOB);");
                a(sQLiteDatabase, "complete");
                sQLiteDatabase.execSQL("CREATE TABLE trackedKeys (id INTEGER, key TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE trackedQueries (id INTEGER PRIMARY KEY, path TEXT, queryParams TEXT, lastUse INTEGER, complete INTEGER, active INTEGER);");
                return;
            }
            throw new AssertionError("We don't handle upgrading to " + i2);
        }
    }

    public SqlPersistenceStorageEngine(Context context, com.google.firebase.database.core.Context context2, String str) {
        try {
            String encode = URLEncoder.encode(str, "utf-8");
            this.f16661c = context2.a("Persistence");
            this.f16660b = a(context, encode);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void C() {
        Utilities.a(!this.f16662d, "runInTransaction called when an existing transaction is already in progress.");
        if (this.f16661c.a()) {
            this.f16661c.a("Starting transaction.", new Object[0]);
        }
        this.f16660b.beginTransaction();
        this.f16662d = true;
        this.f16663e = System.currentTimeMillis();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void E() {
        this.f16660b.setTransactionSuccessful();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void F() {
        this.f16660b.endTransaction();
        this.f16662d = false;
        long currentTimeMillis = System.currentTimeMillis() - this.f16663e;
        if (this.f16661c.a()) {
            this.f16661c.a(String.format("Transaction completed. Elapsed: %dms", Long.valueOf(currentTimeMillis)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void a(Path path, Node node, long j) {
        d();
        long currentTimeMillis = System.currentTimeMillis();
        a(path, j, "o", a(node.a(true)));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f16661c.a()) {
            this.f16661c.a(String.format("Persisted user overwrite in %dms", Long.valueOf(currentTimeMillis2)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void b(Path path, Node node) {
        d();
        a(path, node, false);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public List<TrackedQuery> c() {
        long currentTimeMillis = System.currentTimeMillis();
        Cursor query = this.f16660b.query("trackedQueries", new String[]{"id", "path", "queryParams", "lastUse", "complete", "active"}, null, null, null, null, "id");
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                try {
                    arrayList.add(new TrackedQuery(query.getLong(0), QuerySpec.a(new Path(query.getString(1)), JsonMapper.a(query.getString(2))), query.getLong(3), query.getInt(4) != 0, query.getInt(5) != 0));
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            } finally {
                query.close();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f16661c.a()) {
            this.f16661c.a(String.format("Loaded %d tracked queries in %dms", Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2)), new Object[0]);
        }
        return arrayList;
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public Set<ChildKey> d(long j) {
        return a(Collections.singleton(Long.valueOf(j)));
    }

    private void d() {
        Utilities.a(this.f16662d, "Transaction expected to already be in progress.");
    }

    private void d(Path path, Node node) {
        byte[] a2 = a(node.a(true));
        if (a2.length >= 262144) {
            List<byte[]> a3 = a(a2, 262144);
            if (this.f16661c.a()) {
                this.f16661c.a("Saving huge leaf node with " + a3.size() + " parts.", new Object[0]);
            }
            for (int i = 0; i < a3.size(); i++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("path", a(path, i));
                contentValues.put("value", a3.get(i));
                this.f16660b.insertWithOnConflict("serverCache", null, contentValues, 5);
            }
            return;
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("path", c(path));
        contentValues2.put("value", a2);
        this.f16660b.insertWithOnConflict("serverCache", null, contentValues2, 5);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public long b() {
        Cursor rawQuery = this.f16660b.rawQuery(String.format("SELECT sum(length(%s) + length(%s)) FROM %s", "value", "path", "serverCache"), null);
        try {
            if (rawQuery.moveToFirst()) {
                return rawQuery.getLong(0);
            }
            throw new IllegalStateException("Couldn't read database result!");
        } finally {
            rawQuery.close();
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void a(Path path, CompoundWrite compoundWrite, long j) {
        d();
        long currentTimeMillis = System.currentTimeMillis();
        a(path, j, "m", a(compoundWrite.a(true)));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f16661c.a()) {
            this.f16661c.a(String.format("Persisted user merge in %dms", Long.valueOf(currentTimeMillis2)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void b(long j) {
        d();
        String valueOf = String.valueOf(j);
        this.f16660b.delete("trackedQueries", "id = ?", new String[]{valueOf});
        this.f16660b.delete("trackedKeys", "id = ?", new String[]{valueOf});
    }

    private Node b(Path path) {
        long j;
        long j2;
        Path path2;
        int i;
        Node node;
        int i2;
        Path path3;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor b2 = b(path, new String[]{"path", "value"});
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        long currentTimeMillis3 = System.currentTimeMillis();
        while (b2.moveToNext()) {
            try {
                arrayList.add(b2.getString(0));
                arrayList2.add(b2.getBlob(1));
            } catch (Throwable th) {
                b2.close();
                throw th;
            }
        }
        b2.close();
        long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
        long currentTimeMillis5 = System.currentTimeMillis();
        EmptyNode e2 = EmptyNode.e();
        HashMap hashMap = new HashMap();
        Node node2 = e2;
        int i3 = 0;
        boolean z = false;
        while (i3 < arrayList2.size()) {
            if (arrayList.get(i3).endsWith(".part-0000")) {
                j2 = currentTimeMillis4;
                Path path4 = new Path(arrayList.get(i3).substring(0, r8.length() - 10));
                int a2 = a(path4, arrayList, i3);
                if (this.f16661c.a()) {
                    LogWrapper logWrapper = this.f16661c;
                    StringBuilder sb = new StringBuilder();
                    path3 = path4;
                    sb.append("Loading split node with ");
                    sb.append(a2);
                    sb.append(" parts.");
                    j = currentTimeMillis2;
                    logWrapper.a(sb.toString(), new Object[0]);
                } else {
                    path3 = path4;
                    j = currentTimeMillis2;
                }
                int i4 = a2 + i3;
                node = a(a(arrayList2.subList(i3, i4)));
                i = i4 - 1;
                path2 = path3;
            } else {
                j = currentTimeMillis2;
                j2 = currentTimeMillis4;
                Node a3 = a((byte[]) arrayList2.get(i3));
                path2 = new Path(arrayList.get(i3));
                i = i3;
                node = a3;
            }
            if (path2.d() != null && path2.d().i()) {
                hashMap.put(path2, node);
            } else if (path2.g(path)) {
                Utilities.a(!z, "Descendants of path must come after ancestors.");
                node2 = node.a(Path.a(path2, path));
            } else if (path.g(path2)) {
                node2 = node2.a(Path.a(path, path2), node);
                i2 = 1;
                z = true;
                i3 = i + i2;
                currentTimeMillis4 = j2;
                currentTimeMillis2 = j;
            } else {
                throw new IllegalStateException(String.format("Loading an unrelated row with path %s for %s", path2, path));
            }
            i2 = 1;
            i3 = i + i2;
            currentTimeMillis4 = j2;
            currentTimeMillis2 = j;
        }
        long j3 = currentTimeMillis2;
        long j4 = currentTimeMillis4;
        Node node3 = node2;
        for (Map.Entry entry : hashMap.entrySet()) {
            node3 = node3.a(Path.a(path, (Path) entry.getKey()), (Node) entry.getValue());
        }
        long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis5;
        long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f16661c.a()) {
            this.f16661c.a(String.format("Loaded a total of %d rows for a total of %d nodes at %s in %dms (Query: %dms, Loading: %dms, Serializing: %dms)", Integer.valueOf(arrayList2.size()), Integer.valueOf(NodeSizeEstimator.b(node3)), path, Long.valueOf(currentTimeMillis7), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(currentTimeMillis6)), new Object[0]);
        }
        return node3;
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void a(long j) {
        d();
        long currentTimeMillis = System.currentTimeMillis();
        int delete = this.f16660b.delete("writes", "id = ?", new String[]{String.valueOf(j)});
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f16661c.a()) {
            this.f16661c.a(String.format("Deleted %d write(s) with writeId %d in %dms", Integer.valueOf(delete), Long.valueOf(j), Long.valueOf(currentTimeMillis2)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void c(long j) {
        d();
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("active", (Boolean) false);
        contentValues.put("lastUse", Long.valueOf(j));
        this.f16660b.updateWithOnConflict("trackedQueries", contentValues, "active = 1", new String[0], 5);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f16661c.a()) {
            this.f16661c.a(String.format("Reset active tracked queries in %dms", Long.valueOf(currentTimeMillis2)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public List<UserWriteRecord> a() {
        byte[] a2;
        UserWriteRecord userWriteRecord;
        int i = 3;
        long currentTimeMillis = System.currentTimeMillis();
        Cursor query = this.f16660b.query("writes", new String[]{"id", "path", "type", "part", "node"}, null, null, null, null, "id, part");
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                try {
                    long j = query.getLong(0);
                    Path path = new Path(query.getString(1));
                    String string = query.getString(2);
                    if (query.isNull(i)) {
                        a2 = query.getBlob(4);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        do {
                            arrayList2.add(query.getBlob(4));
                            if (!query.moveToNext()) {
                                break;
                            }
                        } while (query.getLong(0) == j);
                        query.moveToPrevious();
                        a2 = a((List<byte[]>) arrayList2);
                    }
                    Object b2 = JsonMapper.b(new String(a2, f16659a));
                    if ("o".equals(string)) {
                        userWriteRecord = new UserWriteRecord(j, path, NodeUtilities.a(b2), true);
                    } else if ("m".equals(string)) {
                        userWriteRecord = new UserWriteRecord(j, path, CompoundWrite.b((Map<String, Object>) b2));
                    } else {
                        throw new IllegalStateException("Got invalid write type: " + string);
                    }
                    arrayList.add(userWriteRecord);
                    i = 3;
                } catch (IOException e2) {
                    throw new RuntimeException("Failed to load writes", e2);
                }
            } finally {
                query.close();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f16661c.a()) {
            this.f16661c.a(String.format("Loaded %d writes in %dms", Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2)), new Object[0]);
        }
        return arrayList;
    }

    private int c(Path path, Node node) {
        long a2 = NodeSizeEstimator.a(node);
        if ((node instanceof ChildrenNode) && a2 > PlaybackStateCompat.ACTION_PREPARE) {
            int i = 0;
            if (this.f16661c.a()) {
                this.f16661c.a(String.format("Node estimated serialized size at path %s of %d bytes exceeds limit of %d bytes. Splitting up.", path, Long.valueOf(a2), 16384), new Object[0]);
            }
            for (NamedNode namedNode : node) {
                i += c(path.d(namedNode.c()), namedNode.d());
            }
            if (!node.getPriority().isEmpty()) {
                d(path.d(ChildKey.f()), node.getPriority());
                i++;
            }
            d(path, EmptyNode.e());
            return i + 1;
        }
        d(path, node);
        return 1;
    }

    private static String c(Path path) {
        if (path.isEmpty()) {
            return "/";
        }
        return path.toString() + "/";
    }

    private void a(Path path, long j, String str, byte[] bArr) {
        d();
        this.f16660b.delete("writes", "id = ?", new String[]{String.valueOf(j)});
        if (bArr.length >= 262144) {
            List<byte[]> a2 = a(bArr, 262144);
            for (int i = 0; i < a2.size(); i++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", Long.valueOf(j));
                contentValues.put("path", c(path));
                contentValues.put("type", str);
                contentValues.put("part", Integer.valueOf(i));
                contentValues.put("node", a2.get(i));
                this.f16660b.insertWithOnConflict("writes", null, contentValues, 5);
            }
            return;
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("id", Long.valueOf(j));
        contentValues2.put("path", c(path));
        contentValues2.put("type", str);
        contentValues2.put("part", (Integer) null);
        contentValues2.put("node", bArr);
        this.f16660b.insertWithOnConflict("writes", null, contentValues2, 5);
    }

    private Cursor b(Path path, String[] strArr) {
        String c2 = c(path);
        String a2 = a(c2);
        String[] strArr2 = new String[path.size() + 3];
        String str = a(path, strArr2) + " OR (path > ? AND path < ?)";
        strArr2[path.size() + 1] = c2;
        strArr2[path.size() + 2] = a2;
        return this.f16660b.query("serverCache", strArr, str, strArr2, null, null, "path");
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public Node a(Path path) {
        return b(path);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void a(Path path, Node node) {
        d();
        a(path, node, true);
    }

    private void a(Path path, Node node, boolean z) {
        int i;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        if (!z) {
            i = a("serverCache", path);
            i2 = c(path, node);
        } else {
            i = 0;
            int i3 = 0;
            for (NamedNode namedNode : node) {
                i += a("serverCache", path.d(namedNode.c()));
                i3 += c(path.d(namedNode.c()), namedNode.d());
            }
            i2 = i3;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f16661c.a()) {
            this.f16661c.a(String.format("Persisted a total of %d rows and deleted %d rows for a set at %s in %dms", Integer.valueOf(i2), Integer.valueOf(i), path.toString(), Long.valueOf(currentTimeMillis2)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void a(Path path, CompoundWrite compoundWrite) {
        d();
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<Map.Entry<Path, Node>> it = compoundWrite.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            Map.Entry<Path, Node> next = it.next();
            i += a("serverCache", path.e(next.getKey()));
            i2 += c(path.e(next.getKey()), next.getValue());
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f16661c.a()) {
            this.f16661c.a(String.format("Persisted a total of %d rows and deleted %d rows for a merge at %s in %dms", Integer.valueOf(i2), Integer.valueOf(i), path.toString(), Long.valueOf(currentTimeMillis2)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void a(TrackedQuery trackedQuery) {
        d();
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf(trackedQuery.f17024a));
        contentValues.put("path", c(trackedQuery.f17025b.c()));
        contentValues.put("queryParams", trackedQuery.f17025b.b().o());
        contentValues.put("lastUse", Long.valueOf(trackedQuery.f17026c));
        contentValues.put("complete", Boolean.valueOf(trackedQuery.f17027d));
        contentValues.put("active", Boolean.valueOf(trackedQuery.f17028e));
        this.f16660b.insertWithOnConflict("trackedQueries", null, contentValues, 5);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f16661c.a()) {
            this.f16661c.a(String.format("Saved new tracked query in %dms", Long.valueOf(currentTimeMillis2)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void a(long j, Set<ChildKey> set) {
        d();
        long currentTimeMillis = System.currentTimeMillis();
        this.f16660b.delete("trackedKeys", "id = ?", new String[]{String.valueOf(j)});
        for (ChildKey childKey : set) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Long.valueOf(j));
            contentValues.put("key", childKey.a());
            this.f16660b.insertWithOnConflict("trackedKeys", null, contentValues, 5);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f16661c.a()) {
            this.f16661c.a(String.format("Set %d tracked query keys for tracked query %d in %dms", Integer.valueOf(set.size()), Long.valueOf(j), Long.valueOf(currentTimeMillis2)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void a(long j, Set<ChildKey> set, Set<ChildKey> set2) {
        d();
        long currentTimeMillis = System.currentTimeMillis();
        String valueOf = String.valueOf(j);
        Iterator<ChildKey> it = set2.iterator();
        while (it.hasNext()) {
            this.f16660b.delete("trackedKeys", "id = ? AND key = ?", new String[]{valueOf, it.next().a()});
        }
        for (ChildKey childKey : set) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Long.valueOf(j));
            contentValues.put("key", childKey.a());
            this.f16660b.insertWithOnConflict("trackedKeys", null, contentValues, 5);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f16661c.a()) {
            this.f16661c.a(String.format("Updated tracked query keys (%d added, %d removed) for tracked query id %d in %dms", Integer.valueOf(set.size()), Integer.valueOf(set2.size()), Long.valueOf(j), Long.valueOf(currentTimeMillis2)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public Set<ChildKey> a(Set<Long> set) {
        long currentTimeMillis = System.currentTimeMillis();
        Cursor query = this.f16660b.query(true, "trackedKeys", new String[]{"key"}, "id IN (" + a((Collection<Long>) set) + ")", null, null, null, null, null);
        HashSet hashSet = new HashSet();
        while (query.moveToNext()) {
            try {
                hashSet.add(ChildKey.a(query.getString(0)));
            } finally {
                query.close();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f16661c.a()) {
            this.f16661c.a(String.format("Loaded %d tracked queries keys for tracked queries %s in %dms", Integer.valueOf(hashSet.size()), set.toString(), Long.valueOf(currentTimeMillis2)), new Object[0]);
        }
        return hashSet;
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void a(Path path, PruneForest pruneForest) {
        int i;
        int i2;
        if (pruneForest.a()) {
            d();
            long currentTimeMillis = System.currentTimeMillis();
            Cursor b2 = b(path, new String[]{"rowid", "path"});
            ImmutableTree<Long> immutableTree = new ImmutableTree<>(null);
            ImmutableTree<Long> immutableTree2 = new ImmutableTree<>(null);
            while (b2.moveToNext()) {
                long j = b2.getLong(0);
                Path path2 = new Path(b2.getString(1));
                if (!path.g(path2)) {
                    this.f16661c.b("We are pruning at " + path + " but we have data stored higher up at " + path2 + ". Ignoring.");
                } else {
                    Path a2 = Path.a(path, path2);
                    if (pruneForest.d(a2)) {
                        immutableTree = immutableTree.a(a2, (Path) Long.valueOf(j));
                    } else if (pruneForest.c(a2)) {
                        immutableTree2 = immutableTree2.a(a2, (Path) Long.valueOf(j));
                    } else {
                        this.f16661c.b("We are pruning at " + path + " and have data at " + path2 + " that isn't marked for pruning or keeping. Ignoring.");
                    }
                }
            }
            if (immutableTree.isEmpty()) {
                i = 0;
                i2 = 0;
            } else {
                ArrayList arrayList = new ArrayList();
                a(path, Path.e(), immutableTree, immutableTree2, pruneForest, arrayList);
                Collection<Long> e2 = immutableTree.e();
                this.f16660b.delete("serverCache", "rowid IN (" + a(e2) + ")", null);
                for (Pair<Path, Node> pair : arrayList) {
                    c(path.e(pair.a()), pair.b());
                }
                i = e2.size();
                i2 = arrayList.size();
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (this.f16661c.a()) {
                this.f16661c.a(String.format("Pruned %d rows with %d nodes resaved in %dms", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(currentTimeMillis2)), new Object[0]);
            }
        }
    }

    private void a(Path path, Path path2, ImmutableTree<Long> immutableTree, ImmutableTree<Long> immutableTree2, PruneForest pruneForest, List<Pair<Path, Node>> list) {
        if (immutableTree.getValue() != null) {
            int intValue = ((Integer) pruneForest.a(0, new h(this, immutableTree2))).intValue();
            if (intValue > 0) {
                Path e2 = path.e(path2);
                if (this.f16661c.a()) {
                    this.f16661c.a(String.format("Need to rewrite %d nodes below path %s", Integer.valueOf(intValue), e2), new Object[0]);
                }
                pruneForest.a(null, new i(this, immutableTree2, list, path2, b(e2)));
                return;
            }
            return;
        }
        Iterator<Map.Entry<ChildKey, ImmutableTree<Long>>> it = immutableTree.d().iterator();
        while (it.hasNext()) {
            Map.Entry<ChildKey, ImmutableTree<Long>> next = it.next();
            ChildKey key = next.getKey();
            a(path, path2.d(key), next.getValue(), immutableTree2.d(key), pruneForest.a(next.getKey()), list);
        }
    }

    private SQLiteDatabase a(Context context, String str) {
        try {
            SQLiteDatabase writableDatabase = new a(context, str).getWritableDatabase();
            writableDatabase.rawQuery("PRAGMA locking_mode = EXCLUSIVE", null).close();
            writableDatabase.beginTransaction();
            writableDatabase.endTransaction();
            return writableDatabase;
        } catch (SQLiteException e2) {
            if (e2 instanceof SQLiteDatabaseLockedException) {
                throw new DatabaseException("Failed to gain exclusive lock to Firebase Database's offline persistence. This generally means you are using Firebase Database from multiple processes in your app. Keep in mind that multi-process Android apps execute the code in your Application class in all processes, so you may need to avoid initializing FirebaseDatabase in your Application class. If you are intentionally using Firebase Database from multiple processes, you can only enable offline persistence (i.e. call setPersistenceEnabled(true)) in one of them.", e2);
            }
            throw e2;
        }
    }

    private String a(Path path, int i) {
        return c(path) + String.format(".part-%04d", Integer.valueOf(i));
    }

    private int a(Path path, List<String> list, int i) {
        int i2 = i + 1;
        String c2 = c(path);
        if (list.get(i).startsWith(c2)) {
            while (i2 < list.size() && list.get(i2).equals(a(path, i2 - i))) {
                i2++;
            }
            if (i2 < list.size()) {
                if (list.get(i2).startsWith(c2 + ".part-")) {
                    throw new IllegalStateException("Run did not finish with all parts");
                }
            }
            return i2 - i;
        }
        throw new IllegalStateException("Extracting split nodes needs to start with path prefix");
    }

    private static String a(String str) {
        return str.substring(0, str.length() - 1) + '0';
    }

    private static String a(Path path, String[] strArr) {
        int i = 0;
        StringBuilder sb = new StringBuilder("(");
        while (!path.isEmpty()) {
            sb.append("path");
            sb.append(" = ? OR ");
            strArr[i] = c(path);
            path = path.getParent();
            i++;
        }
        sb.append("path");
        sb.append(" = ?)");
        strArr[i] = c(Path.e());
        return sb.toString();
    }

    private int a(String str, Path path) {
        String c2 = c(path);
        return this.f16660b.delete(str, "path >= ? AND path < ?", new String[]{c2, a(c2)});
    }

    private static List<byte[]> a(byte[] bArr, int i) {
        int length = ((bArr.length - 1) / i) + 1;
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * i;
            int min = Math.min(i, bArr.length - i3);
            byte[] bArr2 = new byte[min];
            System.arraycopy(bArr, i3, bArr2, 0, min);
            arrayList.add(bArr2);
        }
        return arrayList;
    }

    private byte[] a(List<byte[]> list) {
        Iterator<byte[]> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().length;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (byte[] bArr2 : list) {
            System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
            i2 += bArr2.length;
        }
        return bArr;
    }

    private byte[] a(Object obj) {
        try {
            return JsonMapper.a(obj).getBytes(f16659a);
        } catch (IOException e2) {
            throw new RuntimeException("Could not serialize leaf node", e2);
        }
    }

    private Node a(byte[] bArr) {
        try {
            return NodeUtilities.a(JsonMapper.b(new String(bArr, f16659a)));
        } catch (IOException e2) {
            throw new RuntimeException("Could not deserialize node: " + new String(bArr, f16659a), e2);
        }
    }

    private String a(Collection<Long> collection) {
        StringBuilder sb = new StringBuilder();
        Iterator<Long> it = collection.iterator();
        boolean z = true;
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            if (!z) {
                sb.append(",");
            }
            z = false;
            sb.append(longValue);
        }
        return sb.toString();
    }
}
