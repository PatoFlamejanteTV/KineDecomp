package kotlin;

import java.io.Serializable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJVM.kt */
/* loaded from: classes.dex */
public final class SynchronizedLazyImpl<T> implements d<T>, Serializable {
    private volatile Object _value;
    private kotlin.jvm.a.a<? extends T> initializer;
    private final Object lock;

    public SynchronizedLazyImpl(kotlin.jvm.a.a<? extends T> aVar, Object obj) {
        kotlin.jvm.internal.h.b(aVar, "initializer");
        this.initializer = aVar;
        this._value = j.f28533a;
        this.lock = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.d
    public T getValue() {
        T t;
        T t2 = (T) this._value;
        if (t2 != j.f28533a) {
            return t2;
        }
        synchronized (this.lock) {
            t = (T) this._value;
            if (t == j.f28533a) {
                kotlin.jvm.a.a<? extends T> aVar = this.initializer;
                if (aVar != null) {
                    t = aVar.invoke();
                    this._value = t;
                    this.initializer = null;
                } else {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
            }
        }
        return t;
    }

    public boolean isInitialized() {
        return this._value != j.f28533a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ SynchronizedLazyImpl(kotlin.jvm.a.a aVar, Object obj, int i, kotlin.jvm.internal.f fVar) {
        this(aVar, (i & 2) != 0 ? null : obj);
    }
}
