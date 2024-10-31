package kotlinx.coroutines;

import kotlin.coroutines.c;
import kotlin.coroutines.e;

/* compiled from: CoroutineDispatcher.kt */
/* renamed from: kotlinx.coroutines.o */
/* loaded from: classes3.dex */
public abstract class AbstractC2546o extends kotlin.coroutines.a implements kotlin.coroutines.c {
    public AbstractC2546o() {
        super(kotlin.coroutines.c.f28514c);
    }

    @Override // kotlin.coroutines.c
    public void a(kotlin.coroutines.b<?> bVar) {
        kotlin.jvm.internal.h.b(bVar, "continuation");
        c.a.a(this, bVar);
    }

    public abstract void a(kotlin.coroutines.e eVar, Runnable runnable);

    @Override // kotlin.coroutines.c
    public final <T> kotlin.coroutines.b<T> b(kotlin.coroutines.b<? super T> bVar) {
        kotlin.jvm.internal.h.b(bVar, "continuation");
        return new A(this, bVar);
    }

    public boolean b(kotlin.coroutines.e eVar) {
        kotlin.jvm.internal.h.b(eVar, com.umeng.analytics.pro.b.Q);
        return true;
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.e.b, kotlin.coroutines.e
    public <E extends e.b> E get(e.c<E> cVar) {
        kotlin.jvm.internal.h.b(cVar, "key");
        return (E) c.a.a(this, cVar);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.e
    public kotlin.coroutines.e minusKey(e.c<?> cVar) {
        kotlin.jvm.internal.h.b(cVar, "key");
        return c.a.b(this, cVar);
    }

    public String toString() {
        return C2553w.a(this) + '@' + C2553w.b(this);
    }
}
