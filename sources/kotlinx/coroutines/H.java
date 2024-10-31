package kotlinx.coroutines;

import com.facebook.internal.FacebookRequestErrorClassification;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.TypeCastException;

/* compiled from: EventLoop.kt */
/* loaded from: classes3.dex */
public abstract class H extends G implements InterfaceC2556z {

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f28588e = AtomicReferenceFieldUpdater.newUpdater(H.class, Object.class, "_queue");

    /* renamed from: f, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f28589f = AtomicReferenceFieldUpdater.newUpdater(H.class, Object.class, "_delayed");
    private volatile boolean isCompleted;
    private volatile Object _queue = null;
    private volatile Object _delayed = null;

    private final void M() {
        boolean z = this.isCompleted;
        if (kotlin.l.f28546a && !z) {
            throw new AssertionError("Assertion failed");
        }
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (f28588e.compareAndSet(this, null, I.a())) {
                    return;
                }
            } else {
                if (obj instanceof kotlinx.coroutines.internal.m) {
                    ((kotlinx.coroutines.internal.m) obj).a();
                    return;
                }
                if (obj == I.a()) {
                    return;
                }
                kotlinx.coroutines.internal.m mVar = new kotlinx.coroutines.internal.m(8, true);
                if (obj != null) {
                    mVar.a((kotlinx.coroutines.internal.m) obj);
                    if (f28588e.compareAndSet(this, obj, mVar)) {
                        return;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            }
        }
    }

    private final Runnable N() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof kotlinx.coroutines.internal.m) {
                if (obj != null) {
                    kotlinx.coroutines.internal.m mVar = (kotlinx.coroutines.internal.m) obj;
                    Object e2 = mVar.e();
                    if (e2 != kotlinx.coroutines.internal.m.f28647c) {
                        return (Runnable) e2;
                    }
                    f28588e.compareAndSet(this, obj, mVar.d());
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                }
            } else {
                if (obj == I.a()) {
                    return null;
                }
                if (f28588e.compareAndSet(this, obj, null)) {
                    if (obj != null) {
                        return (Runnable) obj;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            }
        }
    }

    private final void O() {
        a aVar;
        while (true) {
            kotlinx.coroutines.internal.t tVar = (kotlinx.coroutines.internal.t) this._delayed;
            if (tVar == null || (aVar = (a) tVar.d()) == null) {
                return;
            } else {
                aVar.e();
            }
        }
    }

    private final void P() {
        Thread y = y();
        if (Thread.currentThread() != y) {
            ia.a().a(y);
        }
    }

    private final int b(a aVar) {
        if (this.isCompleted) {
            return 1;
        }
        kotlinx.coroutines.internal.t<a> tVar = (kotlinx.coroutines.internal.t) this._delayed;
        if (tVar == null) {
            f28589f.compareAndSet(this, null, new kotlinx.coroutines.internal.t());
            Object obj = this._delayed;
            if (obj == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            tVar = (kotlinx.coroutines.internal.t) obj;
        }
        return aVar.a(tVar, this);
    }

    private final boolean c(a aVar) {
        kotlinx.coroutines.internal.t tVar = (kotlinx.coroutines.internal.t) this._delayed;
        return (tVar != null ? (a) tVar.c() : null) == aVar;
    }

    public long A() {
        Object obj;
        if (x()) {
            return u();
        }
        kotlinx.coroutines.internal.t tVar = (kotlinx.coroutines.internal.t) this._delayed;
        if (tVar != null && !tVar.b()) {
            long b2 = ia.a().b();
            do {
                synchronized (tVar) {
                    kotlinx.coroutines.internal.u a2 = tVar.a();
                    if (a2 != null) {
                        a aVar = (a) a2;
                        obj = aVar.a(b2) ? b((Runnable) aVar) : false ? tVar.a(0) : null;
                    }
                }
            } while (((a) obj) != null);
        }
        Runnable N = N();
        if (N != null) {
            N.run();
        }
        return u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void L() {
        this._queue = null;
        this._delayed = null;
    }

    @Override // kotlinx.coroutines.G
    protected void shutdown() {
        ga.f28622b.b();
        this.isCompleted = true;
        M();
        do {
        } while (A() <= 0);
        O();
    }

    @Override // kotlinx.coroutines.G
    protected long u() {
        a aVar;
        long a2;
        if (super.u() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof kotlinx.coroutines.internal.m)) {
                return obj == I.a() ? Long.MAX_VALUE : 0L;
            }
            if (!((kotlinx.coroutines.internal.m) obj).c()) {
                return 0L;
            }
        }
        kotlinx.coroutines.internal.t tVar = (kotlinx.coroutines.internal.t) this._delayed;
        if (tVar == null || (aVar = (a) tVar.c()) == null) {
            return Long.MAX_VALUE;
        }
        a2 = kotlin.c.h.a(aVar.f28592c - ia.a().b(), 0L);
        return a2;
    }

    protected abstract Thread y();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean z() {
        if (!w()) {
            return false;
        }
        kotlinx.coroutines.internal.t tVar = (kotlinx.coroutines.internal.t) this._delayed;
        if (tVar != null && !tVar.b()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof kotlinx.coroutines.internal.m) {
                return ((kotlinx.coroutines.internal.m) obj).c();
            }
            if (obj != I.a()) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlinx.coroutines.AbstractC2546o
    public final void a(kotlin.coroutines.e eVar, Runnable runnable) {
        kotlin.jvm.internal.h.b(eVar, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(runnable, "block");
        a(runnable);
    }

    /* compiled from: EventLoop.kt */
    /* loaded from: classes3.dex */
    public static abstract class a implements Runnable, Comparable<a>, E, kotlinx.coroutines.internal.u {

        /* renamed from: a, reason: collision with root package name */
        private Object f28590a;

        /* renamed from: b, reason: collision with root package name */
        private int f28591b;

        /* renamed from: c, reason: collision with root package name */
        public final long f28592c;

        @Override // kotlinx.coroutines.internal.u
        public void a(kotlinx.coroutines.internal.t<?> tVar) {
            if (this.f28590a != I.b()) {
                this.f28590a = tVar;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.");
        }

        @Override // kotlinx.coroutines.internal.u
        public kotlinx.coroutines.internal.t<?> d() {
            Object obj = this.f28590a;
            if (!(obj instanceof kotlinx.coroutines.internal.t)) {
                obj = null;
            }
            return (kotlinx.coroutines.internal.t) obj;
        }

        public final void e() {
            RunnableC2554x.f28729h.a(this);
        }

        @Override // kotlinx.coroutines.internal.u
        public void setIndex(int i) {
            this.f28591b = i;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f28592c + ']';
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            kotlin.jvm.internal.h.b(aVar, FacebookRequestErrorClassification.KEY_OTHER);
            long j = this.f28592c - aVar.f28592c;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }

        public final boolean a(long j) {
            return j - this.f28592c >= 0;
        }

        public final synchronized int a(kotlinx.coroutines.internal.t<a> tVar, H h2) {
            int i;
            kotlin.jvm.internal.h.b(tVar, "delayed");
            kotlin.jvm.internal.h.b(h2, "eventLoop");
            if (this.f28590a == I.b()) {
                return 2;
            }
            synchronized (tVar) {
                if (!h2.isCompleted) {
                    tVar.a((kotlinx.coroutines.internal.t<a>) this);
                    i = 1;
                } else {
                    i = 0;
                }
            }
            return i ^ 1;
        }
    }

    public final void a(Runnable runnable) {
        kotlin.jvm.internal.h.b(runnable, "task");
        if (b(runnable)) {
            P();
        } else {
            RunnableC2554x.f28729h.a(runnable);
        }
    }

    public final void a(a aVar) {
        kotlin.jvm.internal.h.b(aVar, "delayedTask");
        int b2 = b(aVar);
        if (b2 == 0) {
            if (c(aVar)) {
                P();
            }
        } else if (b2 == 1) {
            RunnableC2554x.f28729h.a(aVar);
        } else if (b2 != 2) {
            throw new IllegalStateException("unexpected result");
        }
    }

    private final boolean b(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (this.isCompleted) {
                return false;
            }
            if (obj == null) {
                if (f28588e.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof kotlinx.coroutines.internal.m) {
                if (obj != null) {
                    kotlinx.coroutines.internal.m mVar = (kotlinx.coroutines.internal.m) obj;
                    int a2 = mVar.a((kotlinx.coroutines.internal.m) runnable);
                    if (a2 == 0) {
                        return true;
                    }
                    if (a2 == 1) {
                        f28588e.compareAndSet(this, obj, mVar.d());
                    } else if (a2 == 2) {
                        return false;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                }
            } else {
                if (obj == I.a()) {
                    return false;
                }
                kotlinx.coroutines.internal.m mVar2 = new kotlinx.coroutines.internal.m(8, true);
                if (obj != null) {
                    mVar2.a((kotlinx.coroutines.internal.m) obj);
                    mVar2.a((kotlinx.coroutines.internal.m) runnable);
                    if (f28588e.compareAndSet(this, obj, mVar2)) {
                        return true;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            }
        }
    }
}
