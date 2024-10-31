package kotlin.coroutines;

import kotlin.coroutines.e;
import kotlin.jvm.internal.h;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes3.dex */
public abstract class a implements e.b {

    /* renamed from: a */
    private final e.c<?> f28513a;

    public a(e.c<?> cVar) {
        h.b(cVar, "key");
        this.f28513a = cVar;
    }

    @Override // kotlin.coroutines.e
    public <R> R fold(R r, kotlin.jvm.a.c<? super R, ? super e.b, ? extends R> cVar) {
        h.b(cVar, "operation");
        return (R) e.b.a.a(this, r, cVar);
    }

    @Override // kotlin.coroutines.e.b, kotlin.coroutines.e
    public <E extends e.b> E get(e.c<E> cVar) {
        h.b(cVar, "key");
        return (E) e.b.a.a(this, cVar);
    }

    @Override // kotlin.coroutines.e.b
    public e.c<?> getKey() {
        return this.f28513a;
    }

    @Override // kotlin.coroutines.e
    public e minusKey(e.c<?> cVar) {
        h.b(cVar, "key");
        return e.b.a.b(this, cVar);
    }

    @Override // kotlin.coroutines.e
    public e plus(e eVar) {
        h.b(eVar, com.umeng.analytics.pro.b.Q);
        return e.b.a.a(this, eVar);
    }
}
