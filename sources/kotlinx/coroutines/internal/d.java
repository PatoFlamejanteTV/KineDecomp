package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: Atomic.kt */
/* loaded from: classes3.dex */
public abstract class d<T> extends n {

    /* renamed from: a */
    private static final AtomicReferenceFieldUpdater f28630a = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_consensus");
    private volatile Object _consensus;

    public d() {
        Object obj;
        obj = c.f28629a;
        this._consensus = obj;
    }

    private final Object d(Object obj) {
        return c(obj) ? obj : this._consensus;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.n
    public final Object a(Object obj) {
        Object obj2;
        Object obj3 = this._consensus;
        obj2 = c.f28629a;
        if (obj3 == obj2) {
            obj3 = d(b(obj));
        }
        a(obj, obj3);
        return obj3;
    }

    public abstract void a(T t, Object obj);

    public abstract Object b(T t);

    public final boolean c(Object obj) {
        Object obj2;
        Object obj3;
        obj2 = c.f28629a;
        if (obj != obj2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f28630a;
            obj3 = c.f28629a;
            return atomicReferenceFieldUpdater.compareAndSet(this, obj3, obj);
        }
        throw new IllegalStateException("Check failed.");
    }
}
