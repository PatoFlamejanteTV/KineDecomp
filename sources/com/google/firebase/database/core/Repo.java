package com.google.firebase.database.core;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.InternalHelpers;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.connection.HostInfo;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.RangeMerge;
import com.google.firebase.database.connection.RequestResultCallback;
import com.google.firebase.database.core.persistence.NoopPersistenceManager;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.core.utilities.DefaultClock;
import com.google.firebase.database.core.utilities.OffsetClock;
import com.google.firebase.database.core.utilities.Tree;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.EventRaiser;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class Repo implements PersistentConnection.Delegate {

    /* renamed from: a, reason: collision with root package name */
    private final RepoInfo f16903a;

    /* renamed from: c, reason: collision with root package name */
    private PersistentConnection f16905c;

    /* renamed from: d, reason: collision with root package name */
    private SnapshotHolder f16906d;

    /* renamed from: e, reason: collision with root package name */
    private SparseSnapshotTree f16907e;

    /* renamed from: f, reason: collision with root package name */
    private Tree<List<a>> f16908f;

    /* renamed from: h, reason: collision with root package name */
    private final EventRaiser f16910h;
    private final Context i;
    private final LogWrapper j;
    private final LogWrapper k;
    private final LogWrapper l;
    private SyncTree o;
    private SyncTree p;
    private FirebaseDatabase q;

    /* renamed from: b, reason: collision with root package name */
    private final OffsetClock f16904b = new OffsetClock(new DefaultClock(), 0);

    /* renamed from: g, reason: collision with root package name */
    private boolean f16909g = false;
    public long m = 0;
    private long n = 1;
    private boolean r = false;
    private long s = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public enum TransactionStatus {
        INITIALIZING,
        RUN,
        SENT,
        COMPLETED,
        SENT_NEEDS_ABORT,
        NEEDS_ABORT
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public static class a implements Comparable<a> {

        /* renamed from: a, reason: collision with root package name */
        private Path f16911a;

        /* renamed from: b, reason: collision with root package name */
        private Transaction.Handler f16912b;

        /* renamed from: c, reason: collision with root package name */
        private ValueEventListener f16913c;

        /* renamed from: d, reason: collision with root package name */
        private TransactionStatus f16914d;

        /* renamed from: e, reason: collision with root package name */
        private long f16915e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f16916f;

        /* renamed from: g, reason: collision with root package name */
        private int f16917g;

        /* renamed from: h, reason: collision with root package name */
        private DatabaseError f16918h;
        private long i;
        private Node j;
        private Node k;
        private Node l;

        static /* synthetic */ int g(a aVar) {
            int i = aVar.f16917g;
            aVar.f16917g = i + 1;
            return i;
        }

        @Override // java.lang.Comparable
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            long j = this.f16915e;
            long j2 = aVar.f16915e;
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Repo(RepoInfo repoInfo, Context context, FirebaseDatabase firebaseDatabase) {
        this.f16903a = repoInfo;
        this.i = context;
        this.q = firebaseDatabase;
        this.j = this.i.a("RepoOperation");
        this.k = this.i.a("Transaction");
        this.l = this.i.a("DataOperation");
        this.f16910h = new EventRaiser(this.i);
        b(new RunnableC1598n(this));
    }

    @Override // com.google.firebase.database.connection.PersistentConnection.Delegate
    public void onDisconnect() {
        a(Constants.f16839d, (Object) false);
        d();
    }

    public String toString() {
        return this.f16903a.toString();
    }

    private long c() {
        long j = this.n;
        this.n = 1 + j;
        return j;
    }

    private void d() {
        SparseSnapshotTree a2 = ServerValues.a(this.f16907e, ServerValues.a(this.f16904b));
        ArrayList arrayList = new ArrayList();
        a2.a(Path.e(), new C1591g(this, arrayList));
        this.f16907e = new SparseSnapshotTree();
        a(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Tree<List<a>> tree = this.f16908f;
        b(tree);
        c(tree);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        RepoInfo repoInfo = this.f16903a;
        this.f16905c = this.i.a(new HostInfo(repoInfo.f16919a, repoInfo.f16921c, repoInfo.f16920b), this);
        this.i.c().a(new C1602s(this));
        this.f16905c.d();
        PersistenceManager b2 = this.i.b(this.f16903a.f16919a);
        this.f16906d = new SnapshotHolder();
        this.f16907e = new SparseSnapshotTree();
        this.f16908f = new Tree<>();
        this.o = new SyncTree(this.i, new NoopPersistenceManager(), new u(this));
        this.p = new SyncTree(this.i, b2, new w(this));
        a(b2);
        b(Constants.f16838c, (Object) false);
        b(Constants.f16839d, (Object) false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Tree<List<a>> tree) {
        if (tree.b() != null) {
            List<a> a2 = a(tree);
            Boolean bool = true;
            Iterator<a> it = a2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().f16914d != TransactionStatus.RUN) {
                    bool = false;
                    break;
                }
            }
            if (bool.booleanValue()) {
                b(a2, tree.a());
                return;
            }
            return;
        }
        if (tree.c()) {
            tree.a(new C1592h(this));
        }
    }

    private void a(PersistenceManager persistenceManager) {
        List<UserWriteRecord> a2 = persistenceManager.a();
        Map<String, Object> a3 = ServerValues.a(this.f16904b);
        long j = Long.MIN_VALUE;
        for (UserWriteRecord userWriteRecord : a2) {
            x xVar = new x(this, userWriteRecord);
            if (j < userWriteRecord.d()) {
                j = userWriteRecord.d();
                this.n = userWriteRecord.d() + 1;
                if (userWriteRecord.e()) {
                    if (this.j.a()) {
                        this.j.a("Restoring overwrite with id " + userWriteRecord.d(), new Object[0]);
                    }
                    this.f16905c.a(userWriteRecord.c().a(), userWriteRecord.b().a(true), xVar);
                    this.p.a(userWriteRecord.c(), userWriteRecord.b(), ServerValues.a(userWriteRecord.b(), a3), userWriteRecord.d(), true, false);
                } else {
                    if (this.j.a()) {
                        this.j.a("Restoring merge with id " + userWriteRecord.d(), new Object[0]);
                    }
                    this.f16905c.a(userWriteRecord.c().a(), userWriteRecord.a().a(true), (RequestResultCallback) xVar);
                    this.p.a(userWriteRecord.c(), userWriteRecord.a(), ServerValues.a(userWriteRecord.a(), a3), userWriteRecord.d(), false);
                }
            } else {
                throw new IllegalStateException("Write ids were not in order.");
            }
        }
    }

    public void b(Runnable runnable) {
        this.i.n();
        this.i.h().a(runnable);
    }

    public void b(@NotNull EventRegistration eventRegistration) {
        List<Event> b2;
        if (Constants.f16836a.equals(eventRegistration.a().c().f())) {
            b2 = this.o.b(eventRegistration);
        } else {
            b2 = this.p.b(eventRegistration);
        }
        a(b2);
    }

    private void b(ChildKey childKey, Object obj) {
        if (childKey.equals(Constants.f16837b)) {
            this.f16904b.a(((Long) obj).longValue());
        }
        Path path = new Path(Constants.f16836a, childKey);
        try {
            Node a2 = NodeUtilities.a(obj);
            this.f16906d.a(path, a2);
            a(this.o.a(path, a2));
        } catch (DatabaseException e2) {
            this.j.a("Failed to parse info update", e2);
        }
    }

    private void b(List<a> list, Path path) {
        ArrayList arrayList = new ArrayList();
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(it.next().i));
        }
        Node a2 = a(path, arrayList);
        String hash = !this.f16909g ? a2.getHash() : "badhash";
        for (a aVar : list) {
            aVar.f16914d = TransactionStatus.SENT;
            a.g(aVar);
            a2 = a2.a(Path.a(path, aVar.f16911a), aVar.k);
        }
        this.f16905c.a(path.a(), a2.a(true), hash, new C1594j(this, path, list, this));
    }

    public void a(Runnable runnable) {
        this.i.n();
        this.i.e().a(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<? extends Event> list) {
        if (list.isEmpty()) {
            return;
        }
        this.f16910h.a(list);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection.Delegate
    public void a(List<String> list, Object obj, boolean z, Long l) {
        List<? extends Event> a2;
        Path path = new Path(list);
        if (this.j.a()) {
            this.j.a("onDataUpdate: " + path, new Object[0]);
        }
        if (this.l.a()) {
            this.j.a("onDataUpdate: " + path + " " + obj, new Object[0]);
        }
        this.m++;
        try {
            if (l != null) {
                Tag tag = new Tag(l.longValue());
                if (z) {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        hashMap.put(new Path((String) entry.getKey()), NodeUtilities.a(entry.getValue()));
                    }
                    a2 = this.p.a(path, hashMap, tag);
                } else {
                    a2 = this.p.a(path, NodeUtilities.a(obj), tag);
                }
            } else if (z) {
                HashMap hashMap2 = new HashMap();
                for (Map.Entry entry2 : ((Map) obj).entrySet()) {
                    hashMap2.put(new Path((String) entry2.getKey()), NodeUtilities.a(entry2.getValue()));
                }
                a2 = this.p.a(path, hashMap2);
            } else {
                a2 = this.p.a(path, NodeUtilities.a(obj));
            }
            if (a2.size() > 0) {
                b(path);
            }
            a(a2);
        } catch (DatabaseException e2) {
            this.j.a("FIREBASE INTERNAL ERROR", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Tree<List<a>> tree) {
        List<a> b2 = tree.b();
        if (b2 != null) {
            int i = 0;
            while (i < b2.size()) {
                if (b2.get(i).f16914d == TransactionStatus.COMPLETED) {
                    b2.remove(i);
                } else {
                    i++;
                }
            }
            if (b2.size() > 0) {
                tree.a((Tree<List<a>>) b2);
            } else {
                tree.a((Tree<List<a>>) null);
            }
        }
        tree.a(new C1595k(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Path b(Path path) {
        Tree<List<a>> a2 = a(path);
        Path a3 = a2.a();
        a(a(a2), a3);
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DatabaseError b(String str, String str2) {
        if (str != null) {
            return DatabaseError.a(str, str2);
        }
        return null;
    }

    @Override // com.google.firebase.database.connection.PersistentConnection.Delegate
    public void a(List<String> list, List<RangeMerge> list2, Long l) {
        List<? extends Event> a2;
        Path path = new Path(list);
        if (this.j.a()) {
            this.j.a("onRangeMergeUpdate: " + path, new Object[0]);
        }
        if (this.l.a()) {
            this.j.a("onRangeMergeUpdate: " + path + " " + list2, new Object[0]);
        }
        this.m++;
        ArrayList arrayList = new ArrayList(list2.size());
        Iterator<RangeMerge> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.google.firebase.database.snapshot.RangeMerge(it.next()));
        }
        if (l != null) {
            a2 = this.p.a(path, arrayList, new Tag(l.longValue()));
        } else {
            a2 = this.p.a(path, arrayList);
        }
        if (a2.size() > 0) {
            b(path);
        }
        a(a2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(DatabaseReference.CompletionListener completionListener, DatabaseError databaseError, Path path) {
        DatabaseReference a2;
        if (completionListener != null) {
            ChildKey d2 = path.d();
            if (d2 != null && d2.i()) {
                a2 = InternalHelpers.a(this, path.getParent());
            } else {
                a2 = InternalHelpers.a(this, path);
            }
            a(new y(this, completionListener, databaseError, a2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, Path path, DatabaseError databaseError) {
        if (databaseError == null || databaseError.a() != -25) {
            List<? extends Event> a2 = this.p.a(j, !(databaseError == null), true, (Clock) this.f16904b);
            if (a2.size() > 0) {
                b(path);
            }
            a(a2);
        }
    }

    public void a(Path path, CompoundWrite compoundWrite, DatabaseReference.CompletionListener completionListener, Map<String, Object> map) {
        if (this.j.a()) {
            this.j.a("update: " + path, new Object[0]);
        }
        if (this.l.a()) {
            this.l.a("update: " + path + " " + map, new Object[0]);
        }
        if (compoundWrite.isEmpty()) {
            if (this.j.a()) {
                this.j.a("update called with no changes. No-op", new Object[0]);
            }
            a(completionListener, (DatabaseError) null, path);
            return;
        }
        CompoundWrite a2 = ServerValues.a(compoundWrite, ServerValues.a(this.f16904b));
        long c2 = c();
        a(this.p.a(path, compoundWrite, a2, c2, true));
        this.f16905c.a(path.a(), map, (RequestResultCallback) new z(this, path, c2, completionListener));
        Iterator<Map.Entry<Path, Node>> it = compoundWrite.iterator();
        while (it.hasNext()) {
            b(a(path.e(it.next().getKey()), -9));
        }
    }

    @Override // com.google.firebase.database.connection.PersistentConnection.Delegate
    public void a() {
        a(Constants.f16839d, (Object) true);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection.Delegate
    public void a(boolean z) {
        a(Constants.f16838c, Boolean.valueOf(z));
    }

    public void a(ChildKey childKey, Object obj) {
        b(childKey, obj);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection.Delegate
    public void a(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            b(ChildKey.a(entry.getKey()), entry.getValue());
        }
    }

    public void a(@NotNull EventRegistration eventRegistration) {
        List<? extends Event> a2;
        ChildKey f2 = eventRegistration.a().c().f();
        if (f2 != null && f2.equals(Constants.f16836a)) {
            a2 = this.o.a(eventRegistration);
        } else {
            a2 = this.p.a(eventRegistration);
        }
        a(a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Path path, DatabaseError databaseError) {
        if (databaseError == null || databaseError.a() == -1 || databaseError.a() == -25) {
            return;
        }
        this.j.b(str + " at " + path.toString() + " failed: " + databaseError.toString());
    }

    private Node a(Path path, List<Long> list) {
        Node b2 = this.p.b(path, list);
        return b2 == null ? EmptyNode.e() : b2;
    }

    private void a(List<a> list, Path path) {
        int i;
        DatabaseError a2;
        Transaction.Result a3;
        if (list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<Long> arrayList2 = new ArrayList<>();
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(Long.valueOf(it.next().i));
        }
        Iterator<a> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            a next = it2.next();
            Path.a(path, next.f16911a);
            ArrayList arrayList3 = new ArrayList();
            DatabaseError databaseError = null;
            boolean z = true;
            if (next.f16914d == TransactionStatus.NEEDS_ABORT) {
                databaseError = next.f16918h;
                if (databaseError.a() != -25) {
                    arrayList3.addAll(this.p.a(next.i, true, false, (Clock) this.f16904b));
                }
            } else {
                if (next.f16914d == TransactionStatus.RUN) {
                    if (next.f16917g < 25) {
                        Node a4 = a(next.f16911a, arrayList2);
                        next.j = a4;
                        try {
                            a3 = next.f16912b.a(InternalHelpers.a(a4));
                            a2 = null;
                        } catch (Throwable th) {
                            this.j.a("Caught Throwable.", th);
                            a2 = DatabaseError.a(th);
                            a3 = Transaction.a();
                        }
                        if (a3.b()) {
                            Long valueOf = Long.valueOf(next.i);
                            Map<String, Object> a5 = ServerValues.a(this.f16904b);
                            Node a6 = a3.a();
                            Node a7 = ServerValues.a(a6, a5);
                            next.k = a6;
                            next.l = a7;
                            next.i = c();
                            arrayList2.remove(valueOf);
                            arrayList3.addAll(this.p.a(next.f16911a, a6, a7, next.i, next.f16916f, false));
                            arrayList3.addAll(this.p.a(valueOf.longValue(), true, false, (Clock) this.f16904b));
                        } else {
                            arrayList3.addAll(this.p.a(next.i, true, false, (Clock) this.f16904b));
                            databaseError = a2;
                        }
                    } else {
                        databaseError = DatabaseError.a("maxretries");
                        arrayList3.addAll(this.p.a(next.i, true, false, (Clock) this.f16904b));
                    }
                }
                z = false;
            }
            a(arrayList3);
            if (z) {
                next.f16914d = TransactionStatus.COMPLETED;
                DataSnapshot a8 = InternalHelpers.a(InternalHelpers.a(this, next.f16911a), IndexedNode.b(next.j));
                b(new RunnableC1596l(this, next));
                arrayList.add(new RunnableC1597m(this, next, databaseError, a8));
            }
        }
        b(this.f16908f);
        for (i = 0; i < arrayList.size(); i++) {
            a((Runnable) arrayList.get(i));
        }
        e();
    }

    private Tree<List<a>> a(Path path) {
        Tree<List<a>> tree = this.f16908f;
        while (!path.isEmpty() && tree.b() == null) {
            tree = tree.a(new Path(path.f()));
            path = path.g();
        }
        return tree;
    }

    private List<a> a(Tree<List<a>> tree) {
        ArrayList arrayList = new ArrayList();
        a(arrayList, tree);
        Collections.sort(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<a> list, Tree<List<a>> tree) {
        List<a> b2 = tree.b();
        if (b2 != null) {
            list.addAll(b2);
        }
        tree.a(new C1599o(this, list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Path a(Path path, int i) {
        Path a2 = a(path).a();
        if (this.k.a()) {
            this.j.a("Aborting transactions for path: " + path + ". Affected: " + a2, new Object[0]);
        }
        Tree<List<a>> a3 = this.f16908f.a(path);
        a3.a(new C1600p(this, i));
        a(a3, i);
        a3.b(new C1601q(this, i));
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Tree<List<a>> tree, int i) {
        DatabaseError a2;
        List<a> b2 = tree.b();
        ArrayList arrayList = new ArrayList();
        if (b2 != null) {
            ArrayList arrayList2 = new ArrayList();
            if (i == -9) {
                a2 = DatabaseError.a("overriddenBySet");
            } else {
                Utilities.a(i == -25, "Unknown transaction abort reason: " + i);
                a2 = DatabaseError.a(-25);
            }
            int i2 = -1;
            for (int i3 = 0; i3 < b2.size(); i3++) {
                a aVar = b2.get(i3);
                if (aVar.f16914d != TransactionStatus.SENT_NEEDS_ABORT) {
                    if (aVar.f16914d == TransactionStatus.SENT) {
                        aVar.f16914d = TransactionStatus.SENT_NEEDS_ABORT;
                        aVar.f16918h = a2;
                        i2 = i3;
                    } else {
                        b(new ValueEventRegistration(this, aVar.f16913c, QuerySpec.a(aVar.f16911a)));
                        if (i == -9) {
                            arrayList.addAll(this.p.a(aVar.i, true, false, (Clock) this.f16904b));
                        } else {
                            Utilities.a(i == -25, "Unknown transaction abort reason: " + i);
                        }
                        arrayList2.add(new r(this, aVar, a2));
                    }
                }
            }
            if (i2 == -1) {
                tree.a((Tree<List<a>>) null);
            } else {
                tree.a((Tree<List<a>>) b2.subList(0, i2 + 1));
            }
            a(arrayList);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                a((Runnable) it.next());
            }
        }
    }
}
