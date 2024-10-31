package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.TypeCastException;

/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a */
    static final AtomicReferenceFieldUpdater f28639a = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_next");

    /* renamed from: b */
    static final AtomicReferenceFieldUpdater f28640b = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_prev");

    /* renamed from: c */
    private static final AtomicReferenceFieldUpdater f28641c = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_removedRef");
    volatile Object _next = this;
    volatile Object _prev = this;
    private volatile Object _removedRef = null;

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes3.dex */
    public static abstract class a extends d<k> {

        /* renamed from: b */
        public k f28642b;

        /* renamed from: c */
        public final k f28643c;

        public a(k kVar) {
            kotlin.jvm.internal.h.b(kVar, "newNode");
            this.f28643c = kVar;
        }

        @Override // kotlinx.coroutines.internal.d
        public void a(k kVar, Object obj) {
            kotlin.jvm.internal.h.b(kVar, "affected");
            boolean z = obj == null;
            k kVar2 = z ? this.f28643c : this.f28642b;
            if (kVar2 != null && k.f28639a.compareAndSet(kVar, this, kVar2) && z) {
                k kVar3 = this.f28643c;
                k kVar4 = this.f28642b;
                if (kVar4 != null) {
                    kVar3.b(kVar4);
                } else {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
            }
        }
    }

    private final k i() {
        k kVar = this;
        while (!(kVar instanceof i)) {
            kVar = kVar.c();
            if (!(kVar != this)) {
                throw new IllegalStateException("Cannot loop to this while looking for list head");
            }
        }
        return kVar;
    }

    private final k j() {
        Object obj;
        k kVar;
        do {
            obj = this._prev;
            if (obj instanceof o) {
                return ((o) obj).f28654a;
            }
            if (obj == this) {
                kVar = i();
            } else {
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                }
                kVar = (k) obj;
            }
        } while (!f28640b.compareAndSet(this, obj, kVar.k()));
        return (k) obj;
    }

    private final o k() {
        o oVar = (o) this._removedRef;
        if (oVar != null) {
            return oVar;
        }
        o oVar2 = new o(this);
        f28641c.lazySet(this, oVar2);
        return oVar2;
    }

    public final Object b() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof n)) {
                return obj;
            }
            ((n) obj).a(this);
        }
    }

    public final k c() {
        return j.a(b());
    }

    public final Object d() {
        while (true) {
            Object obj = this._prev;
            if (obj instanceof o) {
                return obj;
            }
            if (obj != null) {
                k kVar = (k) obj;
                if (kVar.b() == this) {
                    return obj;
                }
                a(kVar, (n) null);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        }
    }

    public final k e() {
        return j.a(d());
    }

    public final void f() {
        Object b2;
        k j = j();
        Object obj = this._next;
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
        }
        k kVar = ((o) obj).f28654a;
        while (true) {
            k kVar2 = null;
            while (true) {
                Object b3 = kVar.b();
                if (b3 instanceof o) {
                    kVar.j();
                    kVar = ((o) b3).f28654a;
                } else {
                    b2 = j.b();
                    if (b2 instanceof o) {
                        if (kVar2 != null) {
                            break;
                        } else {
                            j = j.a(j._prev);
                        }
                    } else if (b2 != this) {
                        if (b2 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                        }
                        k kVar3 = (k) b2;
                        if (kVar3 == kVar) {
                            return;
                        }
                        kVar2 = j;
                        j = kVar3;
                    } else if (f28639a.compareAndSet(j, this, kVar)) {
                        return;
                    }
                }
            }
            j.j();
            f28639a.compareAndSet(kVar2, j, ((o) b2).f28654a);
            j = kVar2;
        }
    }

    public final boolean g() {
        return b() instanceof o;
    }

    public boolean h() {
        Object b2;
        k kVar;
        do {
            b2 = b();
            if ((b2 instanceof o) || b2 == this) {
                return false;
            }
            if (b2 != null) {
                kVar = (k) b2;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (!f28639a.compareAndSet(this, b2, kVar.k()));
        c(kVar);
        return true;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    }

    private final void c(k kVar) {
        f();
        kVar.a(j.a(this._prev), (n) null);
    }

    public final boolean a(k kVar) {
        kotlin.jvm.internal.h.b(kVar, "node");
        f28640b.lazySet(kVar, this);
        f28639a.lazySet(kVar, this);
        while (b() == this) {
            if (f28639a.compareAndSet(this, this, kVar)) {
                kVar.b(this);
                return true;
            }
        }
        return false;
    }

    public final void b(k kVar) {
        Object obj;
        do {
            obj = kVar._prev;
            if ((obj instanceof o) || b() != kVar) {
                return;
            }
        } while (!f28640b.compareAndSet(kVar, obj, this));
        if (b() instanceof o) {
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            kVar.a((k) obj, (n) null);
        }
    }

    public final int a(k kVar, k kVar2, a aVar) {
        kotlin.jvm.internal.h.b(kVar, "node");
        kotlin.jvm.internal.h.b(kVar2, "next");
        kotlin.jvm.internal.h.b(aVar, "condAdd");
        f28640b.lazySet(kVar, this);
        f28639a.lazySet(kVar, kVar2);
        aVar.f28642b = kVar2;
        if (f28639a.compareAndSet(this, kVar2, aVar)) {
            return aVar.a(this) == null ? 1 : 2;
        }
        return 0;
    }

    private final k a(k kVar, n nVar) {
        Object obj;
        while (true) {
            k kVar2 = null;
            while (true) {
                obj = kVar._next;
                if (obj == nVar) {
                    return kVar;
                }
                if (obj instanceof n) {
                    ((n) obj).a(kVar);
                } else if (!(obj instanceof o)) {
                    Object obj2 = this._prev;
                    if (obj2 instanceof o) {
                        return null;
                    }
                    if (obj != this) {
                        if (obj == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                        }
                        kVar2 = kVar;
                        kVar = (k) obj;
                    } else {
                        if (obj2 == kVar) {
                            return null;
                        }
                        if (f28640b.compareAndSet(this, obj2, kVar) && !(kVar._prev instanceof o)) {
                            return null;
                        }
                    }
                } else {
                    if (kVar2 != null) {
                        break;
                    }
                    kVar = j.a(kVar._prev);
                }
            }
            kVar.j();
            f28639a.compareAndSet(kVar2, kVar, ((o) obj).f28654a);
            kVar = kVar2;
        }
    }
}
