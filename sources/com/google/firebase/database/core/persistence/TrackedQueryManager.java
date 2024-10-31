package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.Predicate;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.QueryParams;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class TrackedQueryManager {

    /* renamed from: a, reason: collision with root package name */
    private static final Predicate<Map<QueryParams, TrackedQuery>> f17029a = new e();

    /* renamed from: b, reason: collision with root package name */
    private static final Predicate<Map<QueryParams, TrackedQuery>> f17030b = new f();

    /* renamed from: c, reason: collision with root package name */
    private static final Predicate<TrackedQuery> f17031c = new g();

    /* renamed from: d, reason: collision with root package name */
    private static final Predicate<TrackedQuery> f17032d = new h();

    /* renamed from: e, reason: collision with root package name */
    private ImmutableTree<Map<QueryParams, TrackedQuery>> f17033e = new ImmutableTree<>(null);

    /* renamed from: f, reason: collision with root package name */
    private final PersistenceStorageEngine f17034f;

    /* renamed from: g, reason: collision with root package name */
    private final LogWrapper f17035g;

    /* renamed from: h, reason: collision with root package name */
    private final Clock f17036h;
    private long i;

    public TrackedQueryManager(PersistenceStorageEngine persistenceStorageEngine, LogWrapper logWrapper, Clock clock) {
        this.i = 0L;
        this.f17034f = persistenceStorageEngine;
        this.f17035g = logWrapper;
        this.f17036h = clock;
        c();
        for (TrackedQuery trackedQuery : this.f17034f.c()) {
            this.i = Math.max(trackedQuery.f17024a + 1, this.i);
            a(trackedQuery);
        }
    }

    private void c() {
        try {
            this.f17034f.C();
            this.f17034f.c(this.f17036h.a());
            this.f17034f.E();
        } finally {
            this.f17034f.F();
        }
    }

    private static void g(QuerySpec querySpec) {
        Utilities.a(!querySpec.e() || querySpec.d(), "Can't have tracked non-default query that loads all data");
    }

    private static QuerySpec h(QuerySpec querySpec) {
        return querySpec.e() ? QuerySpec.a(querySpec.c()) : querySpec;
    }

    public boolean b(QuerySpec querySpec) {
        Map<QueryParams, TrackedQuery> c2;
        if (f(querySpec.c())) {
            return true;
        }
        return !querySpec.e() && (c2 = this.f17033e.c(querySpec.c())) != null && c2.containsKey(querySpec.b()) && c2.get(querySpec.b()).f17027d;
    }

    public void d(QuerySpec querySpec) {
        a(querySpec, true);
    }

    public void e(QuerySpec querySpec) {
        TrackedQuery a2 = a(h(querySpec));
        if (a2 == null || a2.f17027d) {
            return;
        }
        b(a2.a());
    }

    public void f(QuerySpec querySpec) {
        a(querySpec, false);
    }

    private boolean f(Path path) {
        return this.f17033e.a(path, f17029a) != null;
    }

    public void d(Path path) {
        this.f17033e.f(path).a(new i(this));
    }

    public TrackedQuery a(QuerySpec querySpec) {
        QuerySpec h2 = h(querySpec);
        Map<QueryParams, TrackedQuery> c2 = this.f17033e.c(h2.c());
        if (c2 != null) {
            return c2.get(h2.b());
        }
        return null;
    }

    private Set<Long> e(Path path) {
        HashSet hashSet = new HashSet();
        Map<QueryParams, TrackedQuery> c2 = this.f17033e.c(path);
        if (c2 != null) {
            for (TrackedQuery trackedQuery : c2.values()) {
                if (!trackedQuery.f17025b.e()) {
                    hashSet.add(Long.valueOf(trackedQuery.f17024a));
                }
            }
        }
        return hashSet;
    }

    public void c(QuerySpec querySpec) {
        QuerySpec h2 = h(querySpec);
        this.f17034f.b(a(h2).f17024a);
        Map<QueryParams, TrackedQuery> c2 = this.f17033e.c(h2.c());
        c2.remove(h2.b());
        if (c2.isEmpty()) {
            this.f17033e = this.f17033e.e(h2.c());
        }
    }

    private void a(QuerySpec querySpec, boolean z) {
        TrackedQuery trackedQuery;
        QuerySpec h2 = h(querySpec);
        TrackedQuery a2 = a(h2);
        long a3 = this.f17036h.a();
        if (a2 != null) {
            trackedQuery = a2.a(a3).a(z);
        } else {
            long j = this.i;
            this.i = 1 + j;
            trackedQuery = new TrackedQuery(j, h2, a3, false, z);
        }
        b(trackedQuery);
    }

    public Set<ChildKey> b(Path path) {
        HashSet hashSet = new HashSet();
        Set<Long> e2 = e(path);
        if (!e2.isEmpty()) {
            hashSet.addAll(this.f17034f.a(e2));
        }
        Iterator<Map.Entry<ChildKey, ImmutableTree<Map<QueryParams, TrackedQuery>>>> it = this.f17033e.f(path).d().iterator();
        while (it.hasNext()) {
            Map.Entry<ChildKey, ImmutableTree<Map<QueryParams, TrackedQuery>>> next = it.next();
            ChildKey key = next.getKey();
            ImmutableTree<Map<QueryParams, TrackedQuery>> value = next.getValue();
            if (value.getValue() != null && f17029a.evaluate(value.getValue())) {
                hashSet.add(key);
            }
        }
        return hashSet;
    }

    public PruneForest a(CachePolicy cachePolicy) {
        List<TrackedQuery> a2 = a(f17031c);
        long a3 = a(cachePolicy, a2.size());
        PruneForest pruneForest = new PruneForest();
        if (this.f17035g.a()) {
            this.f17035g.a("Pruning old queries.  Prunable: " + a2.size() + " Count to prune: " + a3, new Object[0]);
        }
        Collections.sort(a2, new j(this));
        PruneForest pruneForest2 = pruneForest;
        for (int i = 0; i < a3; i++) {
            TrackedQuery trackedQuery = a2.get(i);
            pruneForest2 = pruneForest2.b(trackedQuery.f17025b.c());
            c(trackedQuery.f17025b);
        }
        for (int i2 = (int) a3; i2 < a2.size(); i2++) {
            pruneForest2 = pruneForest2.a(a2.get(i2).f17025b.c());
        }
        List<TrackedQuery> a4 = a(f17032d);
        if (this.f17035g.a()) {
            this.f17035g.a("Unprunable queries: " + a4.size(), new Object[0]);
        }
        Iterator<TrackedQuery> it = a4.iterator();
        while (it.hasNext()) {
            pruneForest2 = pruneForest2.a(it.next().f17025b.c());
        }
        return pruneForest2;
    }

    public boolean c(Path path) {
        return this.f17033e.c(path, f17030b) != null;
    }

    public long b() {
        return a(f17031c).size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TrackedQuery trackedQuery) {
        a(trackedQuery);
        this.f17034f.a(trackedQuery);
    }

    private static long a(CachePolicy cachePolicy, long j) {
        return j - Math.min((long) Math.floor(((float) j) * (1.0f - cachePolicy.a())), cachePolicy.b());
    }

    public void a(Path path) {
        TrackedQuery a2;
        if (f(path)) {
            return;
        }
        QuerySpec a3 = QuerySpec.a(path);
        TrackedQuery a4 = a(a3);
        if (a4 == null) {
            long j = this.i;
            this.i = 1 + j;
            a2 = new TrackedQuery(j, a3, this.f17036h.a(), true, false);
        } else {
            a2 = a4.a();
        }
        b(a2);
    }

    private void a(TrackedQuery trackedQuery) {
        g(trackedQuery.f17025b);
        Map<QueryParams, TrackedQuery> c2 = this.f17033e.c(trackedQuery.f17025b.c());
        if (c2 == null) {
            c2 = new HashMap<>();
            this.f17033e = this.f17033e.a(trackedQuery.f17025b.c(), (Path) c2);
        }
        TrackedQuery trackedQuery2 = c2.get(trackedQuery.f17025b.b());
        Utilities.a(trackedQuery2 == null || trackedQuery2.f17024a == trackedQuery.f17024a);
        c2.put(trackedQuery.f17025b.b(), trackedQuery);
    }

    private List<TrackedQuery> a(Predicate<TrackedQuery> predicate) {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Path, Map<QueryParams, TrackedQuery>>> it = this.f17033e.iterator();
        while (it.hasNext()) {
            for (TrackedQuery trackedQuery : it.next().getValue().values()) {
                if (predicate.evaluate(trackedQuery)) {
                    arrayList.add(trackedQuery);
                }
            }
        }
        return arrayList;
    }
}
