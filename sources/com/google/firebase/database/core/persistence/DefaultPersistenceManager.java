package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Context;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.UserWriteRecord;
import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.core.utilities.DefaultClock;
import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class DefaultPersistenceManager implements PersistenceManager {

    /* renamed from: a, reason: collision with root package name */
    private final PersistenceStorageEngine f17012a;

    /* renamed from: b, reason: collision with root package name */
    private final TrackedQueryManager f17013b;

    /* renamed from: c, reason: collision with root package name */
    private final LogWrapper f17014c;

    /* renamed from: d, reason: collision with root package name */
    private final CachePolicy f17015d;

    /* renamed from: e, reason: collision with root package name */
    private long f17016e;

    public DefaultPersistenceManager(Context context, PersistenceStorageEngine persistenceStorageEngine, CachePolicy cachePolicy) {
        this(context, persistenceStorageEngine, cachePolicy, new DefaultClock());
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void a(Path path, Node node, long j) {
        this.f17012a.a(path, node, j);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void b(Path path, CompoundWrite compoundWrite) {
        this.f17012a.a(path, compoundWrite);
        b();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void c(QuerySpec querySpec) {
        this.f17013b.f(querySpec);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void d(QuerySpec querySpec) {
        if (querySpec.e()) {
            this.f17013b.d(querySpec.c());
        } else {
            this.f17013b.e(querySpec);
        }
    }

    public DefaultPersistenceManager(Context context, PersistenceStorageEngine persistenceStorageEngine, CachePolicy cachePolicy, Clock clock) {
        this.f17016e = 0L;
        this.f17012a = persistenceStorageEngine;
        this.f17014c = context.a("Persistence");
        this.f17013b = new TrackedQueryManager(this.f17012a, this.f17014c, clock);
        this.f17015d = cachePolicy;
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void a(Path path, CompoundWrite compoundWrite, long j) {
        this.f17012a.a(path, compoundWrite, j);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void a(long j) {
        this.f17012a.a(j);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void b(QuerySpec querySpec) {
        this.f17013b.d(querySpec);
    }

    private void b() {
        this.f17016e++;
        if (this.f17015d.a(this.f17016e)) {
            if (this.f17014c.a()) {
                this.f17014c.a("Reached prune check threshold.", new Object[0]);
            }
            this.f17016e = 0L;
            boolean z = true;
            long b2 = this.f17012a.b();
            if (this.f17014c.a()) {
                this.f17014c.a("Cache size: " + b2, new Object[0]);
            }
            while (z && this.f17015d.a(b2, this.f17013b.b())) {
                PruneForest a2 = this.f17013b.a(this.f17015d);
                if (a2.a()) {
                    this.f17012a.a(Path.e(), a2);
                } else {
                    z = false;
                }
                b2 = this.f17012a.b();
                if (this.f17014c.a()) {
                    this.f17014c.a("Cache size after prune: " + b2, new Object[0]);
                }
            }
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void a(Path path, Node node) {
        if (this.f17013b.c(path)) {
            return;
        }
        this.f17012a.b(path, node);
        this.f17013b.a(path);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void a(Path path, CompoundWrite compoundWrite) {
        Iterator<Map.Entry<Path, Node>> it = compoundWrite.iterator();
        while (it.hasNext()) {
            Map.Entry<Path, Node> next = it.next();
            a(path.e(next.getKey()), next.getValue());
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public List<UserWriteRecord> a() {
        return this.f17012a.a();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public CacheNode a(QuerySpec querySpec) {
        Set<ChildKey> b2;
        boolean z;
        if (this.f17013b.b(querySpec)) {
            TrackedQuery a2 = this.f17013b.a(querySpec);
            b2 = (querySpec.e() || a2 == null || !a2.f17027d) ? null : this.f17012a.d(a2.f17024a);
            z = true;
        } else {
            b2 = this.f17013b.b(querySpec.c());
            z = false;
        }
        Node a3 = this.f17012a.a(querySpec.c());
        if (b2 != null) {
            Node e2 = EmptyNode.e();
            for (ChildKey childKey : b2) {
                e2 = e2.a(childKey, a3.a(childKey));
            }
            return new CacheNode(IndexedNode.a(e2, querySpec.a()), z, true);
        }
        return new CacheNode(IndexedNode.a(a3, querySpec.a()), z, false);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void a(QuerySpec querySpec, Node node) {
        if (querySpec.e()) {
            this.f17012a.b(querySpec.c(), node);
        } else {
            this.f17012a.a(querySpec.c(), node);
        }
        d(querySpec);
        b();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void a(QuerySpec querySpec, Set<ChildKey> set) {
        this.f17012a.a(this.f17013b.a(querySpec).f17024a, set);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void a(QuerySpec querySpec, Set<ChildKey> set, Set<ChildKey> set2) {
        this.f17012a.a(this.f17013b.a(querySpec).f17024a, set, set2);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public <T> T a(Callable<T> callable) {
        this.f17012a.C();
        try {
            try {
                T call = callable.call();
                this.f17012a.E();
                return call;
            } catch (Throwable th) {
                this.f17014c.a("Caught Throwable.", th);
                throw new RuntimeException(th);
            }
        } finally {
            this.f17012a.F();
        }
    }
}
