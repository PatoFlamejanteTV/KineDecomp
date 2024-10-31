package com.google.android.gms.analytics.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.keyczar.Keyczar;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends zzd implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private static final String f712a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id");
    private static final String b = String.format("SELECT MAX(%s) FROM %s WHERE 1;", "hit_time", "hits2");
    private final a c;
    private final d d;
    private final d e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends SQLiteOpenHelper {
        a(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            Set<String> b = b(sQLiteDatabase, "hits2");
            for (String str : new String[]{"hit_id", "hit_string", "hit_time", "hit_url"}) {
                if (!b.remove(str)) {
                    throw new SQLiteException("Database hits2 is missing required column: " + str);
                }
            }
            boolean z = b.remove("hit_app_id") ? false : true;
            if (!b.isEmpty()) {
                throw new SQLiteException("Database hits2 has extra columns");
            }
            if (z) {
                sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0039  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private boolean a(android.database.sqlite.SQLiteDatabase r11, java.lang.String r12) {
            /*
                r10 = this;
                r8 = 0
                r9 = 0
                java.lang.String r1 = "SQLITE_MASTER"
                r0 = 1
                java.lang.String[] r2 = new java.lang.String[r0]     // Catch: android.database.sqlite.SQLiteException -> L26 java.lang.Throwable -> L36
                r0 = 0
                java.lang.String r3 = "name"
                r2[r0] = r3     // Catch: android.database.sqlite.SQLiteException -> L26 java.lang.Throwable -> L36
                java.lang.String r3 = "name=?"
                r0 = 1
                java.lang.String[] r4 = new java.lang.String[r0]     // Catch: android.database.sqlite.SQLiteException -> L26 java.lang.Throwable -> L36
                r0 = 0
                r4[r0] = r12     // Catch: android.database.sqlite.SQLiteException -> L26 java.lang.Throwable -> L36
                r5 = 0
                r6 = 0
                r7 = 0
                r0 = r11
                android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: android.database.sqlite.SQLiteException -> L26 java.lang.Throwable -> L36
                boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L3d android.database.sqlite.SQLiteException -> L40
                if (r1 == 0) goto L25
                r1.close()
            L25:
                return r0
            L26:
                r0 = move-exception
                r1 = r9
            L28:
                com.google.android.gms.analytics.internal.n r2 = com.google.android.gms.analytics.internal.n.this     // Catch: java.lang.Throwable -> L3d
                java.lang.String r3 = "Error querying for table"
                r2.c(r3, r12, r0)     // Catch: java.lang.Throwable -> L3d
                if (r1 == 0) goto L34
                r1.close()
            L34:
                r0 = r8
                goto L25
            L36:
                r0 = move-exception
            L37:
                if (r9 == 0) goto L3c
                r9.close()
            L3c:
                throw r0
            L3d:
                r0 = move-exception
                r9 = r1
                goto L37
            L40:
                r0 = move-exception
                goto L28
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.n.a.a(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
        }

        private Set<String> b(SQLiteDatabase sQLiteDatabase, String str) {
            HashSet hashSet = new HashSet();
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
            try {
                for (String str2 : rawQuery.getColumnNames()) {
                    hashSet.add(str2);
                }
                return hashSet;
            } finally {
                rawQuery.close();
            }
        }

        private void b(SQLiteDatabase sQLiteDatabase) {
            Set<String> b = b(sQLiteDatabase, "properties");
            for (String str : new String[]{"app_uid", "cid", "tid", NativeProtocol.WEB_DIALOG_PARAMS, "adid", "hits_count"}) {
                if (!b.remove(str)) {
                    throw new SQLiteException("Database properties is missing required column: " + str);
                }
            }
            if (!b.isEmpty()) {
                throw new SQLiteException("Database properties table has extra columns");
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public SQLiteDatabase getWritableDatabase() {
            if (!n.this.e.a(3600000L)) {
                throw new SQLiteException("Database open failed");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e) {
                n.this.e.a();
                n.this.f("Opening the database failed, dropping the table and recreating it");
                n.this.o().getDatabasePath(n.this.G()).delete();
                try {
                    SQLiteDatabase writableDatabase = super.getWritableDatabase();
                    n.this.e.b();
                    return writableDatabase;
                } catch (SQLiteException e2) {
                    n.this.e("Failed to open freshly created database", e2);
                    throw e2;
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            zzx.a(sQLiteDatabase.getPath());
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (Build.VERSION.SDK_INT < 15) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (a(sQLiteDatabase, "hits2")) {
                a(sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL(n.f712a);
            }
            if (a(sQLiteDatabase, "properties")) {
                b(sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(zzf zzfVar) {
        super(zzfVar);
        this.d = new d(n());
        this.e = new d(n());
        this.c = new a(zzfVar.b(), G());
    }

    private void F() {
        int y = q().y();
        long e = e();
        if (e > y - 1) {
            List<Long> a2 = a((e - y) + 1);
            d("Store full, deleting hits to make room, count", Integer.valueOf(a2.size()));
            a(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String G() {
        if (q().a() && !q().b()) {
            return q().B();
        }
        return q().A();
    }

    private long a(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = i().rawQuery(str, strArr);
                if (!rawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                d("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private long a(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            try {
                cursor = i().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    j = cursor.getLong(0);
                } else if (cursor != null) {
                    cursor.close();
                }
                return j;
            } catch (SQLiteException e) {
                d("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private static String a(Map<String, String> map) {
        com.google.android.gms.common.internal.zzx.a(map);
        Uri.Builder builder = new Uri.Builder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        String encodedQuery = builder.build().getEncodedQuery();
        return encodedQuery == null ? "" : encodedQuery;
    }

    private String b(zzab zzabVar) {
        return zzabVar.f() ? q().o() : q().p();
    }

    private static String c(zzab zzabVar) {
        com.google.android.gms.common.internal.zzx.a(zzabVar);
        Uri.Builder builder = new Uri.Builder();
        for (Map.Entry<String, String> entry : zzabVar.b().entrySet()) {
            String key = entry.getKey();
            if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key)) {
                builder.appendQueryParameter(key, entry.getValue());
            }
        }
        String encodedQuery = builder.build().getEncodedQuery();
        return encodedQuery == null ? "" : encodedQuery;
    }

    public long a(long j, String str, String str2) {
        com.google.android.gms.common.internal.zzx.a(str);
        com.google.android.gms.common.internal.zzx.a(str2);
        D();
        m();
        return a("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[]{String.valueOf(j), str, str2}, 0L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0043, code lost:            if (r1.moveToFirst() != false) goto L10;     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0045, code lost:            r9.add(java.lang.Long.valueOf(r1.getLong(0)));     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0055, code lost:            if (r1.moveToNext() != false) goto L33;     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0057, code lost:            if (r1 == null) goto L14;     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:            r1.close();     */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0073: MOVE (r10 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:27:0x0073 */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<java.lang.Long> a(long r14) {
        /*
            r13 = this;
            r10 = 0
            r13.m()
            r13.D()
            r0 = 0
            int r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r0 > 0) goto L12
            java.util.List r0 = java.util.Collections.emptyList()
        L11:
            return r0
        L12:
            android.database.sqlite.SQLiteDatabase r0 = r13.i()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.lang.String r1 = "hits2"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: android.database.sqlite.SQLiteException -> L5e java.lang.Throwable -> L6b
            r3 = 0
            java.lang.String r4 = "hit_id"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L5e java.lang.Throwable -> L6b
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "%s ASC"
            r8 = 1
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch: android.database.sqlite.SQLiteException -> L5e java.lang.Throwable -> L6b
            r11 = 0
            java.lang.String r12 = "hit_id"
            r8[r11] = r12     // Catch: android.database.sqlite.SQLiteException -> L5e java.lang.Throwable -> L6b
            java.lang.String r7 = java.lang.String.format(r7, r8)     // Catch: android.database.sqlite.SQLiteException -> L5e java.lang.Throwable -> L6b
            java.lang.String r8 = java.lang.Long.toString(r14)     // Catch: android.database.sqlite.SQLiteException -> L5e java.lang.Throwable -> L6b
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: android.database.sqlite.SQLiteException -> L5e java.lang.Throwable -> L6b
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteException -> L75
            if (r0 == 0) goto L57
        L45:
            r0 = 0
            long r2 = r1.getLong(r0)     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteException -> L75
            java.lang.Long r0 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteException -> L75
            r9.add(r0)     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteException -> L75
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteException -> L75
            if (r0 != 0) goto L45
        L57:
            if (r1 == 0) goto L5c
            r1.close()
        L5c:
            r0 = r9
            goto L11
        L5e:
            r0 = move-exception
            r1 = r10
        L60:
            java.lang.String r2 = "Error selecting hit ids"
            r13.d(r2, r0)     // Catch: java.lang.Throwable -> L72
            if (r1 == 0) goto L5c
            r1.close()
            goto L5c
        L6b:
            r0 = move-exception
        L6c:
            if (r10 == 0) goto L71
            r10.close()
        L71:
            throw r0
        L72:
            r0 = move-exception
            r10 = r1
            goto L6c
        L75:
            r0 = move-exception
            goto L60
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.n.a(long):java.util.List");
    }

    Map<String, String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                str = "?" + str;
            }
            List<NameValuePair> parse = URLEncodedUtils.parse(new URI(str), Keyczar.DEFAULT_ENCODING);
            HashMap hashMap = new HashMap(parse.size());
            for (NameValuePair nameValuePair : parse) {
                hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
            }
            return hashMap;
        } catch (URISyntaxException e) {
            e("Error parsing hit parameters", e);
            return new HashMap(0);
        }
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void a() {
    }

    public void a(long j, String str) {
        com.google.android.gms.common.internal.zzx.a(str);
        D();
        m();
        int delete = i().delete("properties", "app_uid=? AND cid<>?", new String[]{String.valueOf(j), str});
        if (delete > 0) {
            a("Deleted property records", Integer.valueOf(delete));
        }
    }

    public void a(zzab zzabVar) {
        com.google.android.gms.common.internal.zzx.a(zzabVar);
        m();
        D();
        String c = c(zzabVar);
        if (c.length() > 8192) {
            p().a(zzabVar, "Hit length exceeds the maximum allowed size");
            return;
        }
        F();
        SQLiteDatabase i = i();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", c);
        contentValues.put("hit_time", Long.valueOf(zzabVar.d()));
        contentValues.put("hit_app_id", Integer.valueOf(zzabVar.a()));
        contentValues.put("hit_url", b(zzabVar));
        try {
            long insert = i.insert("hits2", null, contentValues);
            if (insert == -1) {
                f("Failed to insert a hit (got -1)");
            } else {
                b("Hit saved to database. db-id, hit", Long.valueOf(insert), zzabVar);
            }
        } catch (SQLiteException e) {
            e("Error storing a hit", e);
        }
    }

    public void a(zzh zzhVar) {
        com.google.android.gms.common.internal.zzx.a(zzhVar);
        D();
        m();
        SQLiteDatabase i = i();
        String a2 = a(zzhVar.f());
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_uid", Long.valueOf(zzhVar.a()));
        contentValues.put("cid", zzhVar.b());
        contentValues.put("tid", zzhVar.c());
        contentValues.put("adid", Integer.valueOf(zzhVar.d() ? 1 : 0));
        contentValues.put("hits_count", Long.valueOf(zzhVar.e()));
        contentValues.put(NativeProtocol.WEB_DIALOG_PARAMS, a2);
        try {
            if (i.insertWithOnConflict("properties", null, contentValues, 5) == -1) {
                f("Failed to insert/update a property (got -1)");
            }
        } catch (SQLiteException e) {
            e("Error storing a property", e);
        }
    }

    public void a(List<Long> list) {
        com.google.android.gms.common.internal.zzx.a(list);
        m();
        D();
        if (list.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder("hit_id");
        sb.append(" in (");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                sb.append(")");
                String sb2 = sb.toString();
                try {
                    SQLiteDatabase i3 = i();
                    a("Deleting dispatched hits. count", Integer.valueOf(list.size()));
                    int delete = i3.delete("hits2", sb2, null);
                    if (delete != list.size()) {
                        b("Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(delete), sb2);
                        return;
                    }
                    return;
                } catch (SQLiteException e) {
                    e("Error deleting hits", e);
                    throw e;
                }
            }
            Long l = list.get(i2);
            if (l == null || l.longValue() == 0) {
                break;
            }
            if (i2 > 0) {
                sb.append(",");
            }
            sb.append(l);
            i = i2 + 1;
        }
        throw new SQLiteException("Invalid hit id");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0087, code lost:            if (r9.moveToNext() != false) goto L34;     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0089, code lost:            if (r9 == null) goto L12;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x008b, code lost:            r9.close();     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x008e, code lost:            return r10;     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0057, code lost:            if (r9.moveToFirst() != false) goto L8;     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0059, code lost:            r10.add(new com.google.android.gms.analytics.internal.zzab(r13, a(r9.getString(2)), r9.getLong(1), com.google.android.gms.analytics.internal.zzam.d(r9.getString(3)), r9.getLong(0), r9.getInt(4)));     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.google.android.gms.analytics.internal.zzab> b(long r14) {
        /*
            r13 = this;
            r0 = 1
            r1 = 0
            r9 = 0
            r2 = 0
            int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r2 < 0) goto L8f
        L9:
            com.google.android.gms.common.internal.zzx.b(r0)
            r13.m()
            r13.D()
            android.database.sqlite.SQLiteDatabase r0 = r13.i()
            java.lang.String r1 = "hits2"
            r2 = 5
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> La2
            r3 = 0
            java.lang.String r4 = "hit_id"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> La2
            r3 = 1
            java.lang.String r4 = "hit_time"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> La2
            r3 = 2
            java.lang.String r4 = "hit_string"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> La2
            r3 = 3
            java.lang.String r4 = "hit_url"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> La2
            r3 = 4
            java.lang.String r4 = "hit_app_id"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> La2
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "%s ASC"
            r8 = 1
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> La2
            r10 = 0
            java.lang.String r11 = "hit_id"
            r8[r10] = r11     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> La2
            java.lang.String r7 = java.lang.String.format(r7, r8)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> La2
            java.lang.String r8 = java.lang.Long.toString(r14)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> La2
            android.database.Cursor r9 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> La2
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> La4
            r10.<init>()     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> La4
            boolean r0 = r9.moveToFirst()     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> La4
            if (r0 == 0) goto L89
        L59:
            r0 = 0
            long r6 = r9.getLong(r0)     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> La4
            r0 = 1
            long r3 = r9.getLong(r0)     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> La4
            r0 = 2
            java.lang.String r0 = r9.getString(r0)     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> La4
            r1 = 3
            java.lang.String r1 = r9.getString(r1)     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> La4
            r2 = 4
            int r8 = r9.getInt(r2)     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> La4
            java.util.Map r2 = r13.a(r0)     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> La4
            boolean r5 = com.google.android.gms.analytics.internal.zzam.d(r1)     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> La4
            com.google.android.gms.analytics.internal.zzab r0 = new com.google.android.gms.analytics.internal.zzab     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> La4
            r1 = r13
            r0.<init>(r1, r2, r3, r5, r6, r8)     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> La4
            r10.add(r0)     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> La4
            boolean r0 = r9.moveToNext()     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> La4
            if (r0 != 0) goto L59
        L89:
            if (r9 == 0) goto L8e
            r9.close()
        L8e:
            return r10
        L8f:
            r0 = r1
            goto L9
        L92:
            r0 = move-exception
            r1 = r9
        L94:
            java.lang.String r2 = "Error loading hits from the database"
            r13.e(r2, r0)     // Catch: java.lang.Throwable -> L9a
            throw r0     // Catch: java.lang.Throwable -> L9a
        L9a:
            r0 = move-exception
            r9 = r1
        L9c:
            if (r9 == 0) goto La1
            r9.close()
        La1:
            throw r0
        La2:
            r0 = move-exception
            goto L9c
        La4:
            r0 = move-exception
            r1 = r9
            goto L94
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.n.b(long):java.util.List");
    }

    public void b() {
        D();
        i().beginTransaction();
    }

    public void c() {
        D();
        i().setTransactionSuccessful();
    }

    public void c(long j) {
        m();
        D();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        a("Deleting hit, id", Long.valueOf(j));
        a((List<Long>) arrayList);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.c.close();
        } catch (SQLiteException e) {
            e("Sql error closing database", e);
        } catch (IllegalStateException e2) {
            e("Error closing database", e2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0065, code lost:            r6 = r9.getInt(3);        r8 = g(r9.getString(4));     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0078, code lost:            if (android.text.TextUtils.isEmpty(r3) != false) goto L13;     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x007e, code lost:            if (android.text.TextUtils.isEmpty(r4) == false) goto L23;     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x009e, code lost:            r11.add(new com.google.android.gms.analytics.internal.zzh(r14, r3, r4, r5, r6, r8));     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0089, code lost:            if (r9.moveToNext() != false) goto L45;     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0080, code lost:            c("Read property with empty client id or tracker id", r3, r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x009c, code lost:            r5 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008f, code lost:            if (r11.size() < r10) goto L19;     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0091, code lost:            e("Sending hits to too many properties. Campaign report might be incorrect");     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0096, code lost:            if (r9 == null) goto L21;     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0098, code lost:            r9.close();     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009b, code lost:            return r11;     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0051, code lost:            if (r9.moveToFirst() != false) goto L6;     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0053, code lost:            r3 = r9.getString(0);        r4 = r9.getString(1);     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0062, code lost:            if (r9.getInt(2) == 0) goto L22;     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0064, code lost:            r5 = true;     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.google.android.gms.analytics.internal.zzh> d(long r14) {
        /*
            r13 = this;
            r13.D()
            r13.m()
            android.database.sqlite.SQLiteDatabase r0 = r13.i()
            r9 = 0
            r1 = 5
            java.lang.String[] r2 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lba
            r1 = 0
            java.lang.String r3 = "cid"
            r2[r1] = r3     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lba
            r1 = 1
            java.lang.String r3 = "tid"
            r2[r1] = r3     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lba
            r1 = 2
            java.lang.String r3 = "adid"
            r2[r1] = r3     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lba
            r1 = 3
            java.lang.String r3 = "hits_count"
            r2[r1] = r3     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lba
            r1 = 4
            java.lang.String r3 = "params"
            r2[r1] = r3     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lba
            com.google.android.gms.analytics.internal.zzr r1 = r13.q()     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lba
            int r10 = r1.z()     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lba
            java.lang.String r8 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lba
            java.lang.String r3 = "app_uid=?"
            r1 = 1
            java.lang.String[] r4 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lba
            r1 = 0
            java.lang.String r5 = java.lang.String.valueOf(r14)     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lba
            r4[r1] = r5     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lba
            java.lang.String r1 = "properties"
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r9 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lba
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> La8 java.lang.Throwable -> Lb8
            r11.<init>()     // Catch: android.database.sqlite.SQLiteException -> La8 java.lang.Throwable -> Lb8
            boolean r0 = r9.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> La8 java.lang.Throwable -> Lb8
            if (r0 == 0) goto L8b
        L53:
            r0 = 0
            java.lang.String r3 = r9.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> La8 java.lang.Throwable -> Lb8
            r0 = 1
            java.lang.String r4 = r9.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> La8 java.lang.Throwable -> Lb8
            r0 = 2
            int r0 = r9.getInt(r0)     // Catch: android.database.sqlite.SQLiteException -> La8 java.lang.Throwable -> Lb8
            if (r0 == 0) goto L9c
            r5 = 1
        L65:
            r0 = 3
            int r0 = r9.getInt(r0)     // Catch: android.database.sqlite.SQLiteException -> La8 java.lang.Throwable -> Lb8
            long r6 = (long) r0     // Catch: android.database.sqlite.SQLiteException -> La8 java.lang.Throwable -> Lb8
            r0 = 4
            java.lang.String r0 = r9.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> La8 java.lang.Throwable -> Lb8
            java.util.Map r8 = r13.g(r0)     // Catch: android.database.sqlite.SQLiteException -> La8 java.lang.Throwable -> Lb8
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch: android.database.sqlite.SQLiteException -> La8 java.lang.Throwable -> Lb8
            if (r0 != 0) goto L80
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch: android.database.sqlite.SQLiteException -> La8 java.lang.Throwable -> Lb8
            if (r0 == 0) goto L9e
        L80:
            java.lang.String r0 = "Read property with empty client id or tracker id"
            r13.c(r0, r3, r4)     // Catch: android.database.sqlite.SQLiteException -> La8 java.lang.Throwable -> Lb8
        L85:
            boolean r0 = r9.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> La8 java.lang.Throwable -> Lb8
            if (r0 != 0) goto L53
        L8b:
            int r0 = r11.size()     // Catch: android.database.sqlite.SQLiteException -> La8 java.lang.Throwable -> Lb8
            if (r0 < r10) goto L96
            java.lang.String r0 = "Sending hits to too many properties. Campaign report might be incorrect"
            r13.e(r0)     // Catch: android.database.sqlite.SQLiteException -> La8 java.lang.Throwable -> Lb8
        L96:
            if (r9 == 0) goto L9b
            r9.close()
        L9b:
            return r11
        L9c:
            r5 = 0
            goto L65
        L9e:
            com.google.android.gms.analytics.internal.zzh r0 = new com.google.android.gms.analytics.internal.zzh     // Catch: android.database.sqlite.SQLiteException -> La8 java.lang.Throwable -> Lb8
            r1 = r14
            r0.<init>(r1, r3, r4, r5, r6, r8)     // Catch: android.database.sqlite.SQLiteException -> La8 java.lang.Throwable -> Lb8
            r11.add(r0)     // Catch: android.database.sqlite.SQLiteException -> La8 java.lang.Throwable -> Lb8
            goto L85
        La8:
            r0 = move-exception
            r1 = r9
        Laa:
            java.lang.String r2 = "Error loading hits from the database"
            r13.e(r2, r0)     // Catch: java.lang.Throwable -> Lb0
            throw r0     // Catch: java.lang.Throwable -> Lb0
        Lb0:
            r0 = move-exception
            r9 = r1
        Lb2:
            if (r9 == 0) goto Lb7
            r9.close()
        Lb7:
            throw r0
        Lb8:
            r0 = move-exception
            goto Lb2
        Lba:
            r0 = move-exception
            r1 = r9
            goto Laa
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.n.d(long):java.util.List");
    }

    public void d() {
        D();
        i().endTransaction();
    }

    public long e() {
        m();
        D();
        return a("SELECT COUNT(*) FROM hits2", (String[]) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return e() == 0;
    }

    public int g() {
        m();
        D();
        if (!this.d.a(86400000L)) {
            return 0;
        }
        this.d.a();
        b("Deleting stale hits (if any)");
        int delete = i().delete("hits2", "hit_time < ?", new String[]{Long.toString(n().currentTimeMillis() - 2592000000L)});
        a("Deleted stale hits, count", Integer.valueOf(delete));
        return delete;
    }

    Map<String, String> g(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            List<NameValuePair> parse = URLEncodedUtils.parse(new URI("?" + str), Keyczar.DEFAULT_ENCODING);
            HashMap hashMap = new HashMap(parse.size());
            for (NameValuePair nameValuePair : parse) {
                hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
            }
            return hashMap;
        } catch (URISyntaxException e) {
            e("Error parsing property parameters", e);
            return new HashMap(0);
        }
    }

    public long h() {
        m();
        D();
        return a(b, (String[]) null, 0L);
    }

    SQLiteDatabase i() {
        try {
            return this.c.getWritableDatabase();
        } catch (SQLiteException e) {
            d("Error opening database", e);
            throw e;
        }
    }
}
