package kotlin.coroutines;

import java.io.Serializable;
import kotlin.coroutines.e;
import kotlin.jvm.internal.h;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes3.dex */
public final class EmptyCoroutineContext implements e, Serializable {
    public static final EmptyCoroutineContext INSTANCE = new EmptyCoroutineContext();
    private static final long serialVersionUID = 0;

    private EmptyCoroutineContext() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // kotlin.coroutines.e
    public <R> R fold(R r, kotlin.jvm.a.c<? super R, ? super e.b, ? extends R> cVar) {
        h.b(cVar, "operation");
        return r;
    }

    @Override // kotlin.coroutines.e
    public <E extends e.b> E get(e.c<E> cVar) {
        h.b(cVar, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // kotlin.coroutines.e
    public e minusKey(e.c<?> cVar) {
        h.b(cVar, "key");
        return this;
    }

    @Override // kotlin.coroutines.e
    public e plus(e eVar) {
        h.b(eVar, com.umeng.analytics.pro.b.Q);
        return eVar;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
