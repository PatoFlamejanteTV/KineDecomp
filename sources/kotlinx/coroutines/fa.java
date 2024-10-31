package kotlinx.coroutines;

import kotlin.coroutines.e;

/* compiled from: ThreadContextElement.kt */
/* loaded from: classes3.dex */
public interface fa<S> extends e.b {

    /* compiled from: ThreadContextElement.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public static <S, R> R a(fa<S> faVar, R r, kotlin.jvm.a.c<? super R, ? super e.b, ? extends R> cVar) {
            kotlin.jvm.internal.h.b(cVar, "operation");
            return (R) e.b.a.a(faVar, r, cVar);
        }

        public static <S, E extends e.b> E a(fa<S> faVar, e.c<E> cVar) {
            kotlin.jvm.internal.h.b(cVar, "key");
            return (E) e.b.a.a(faVar, cVar);
        }

        public static <S> kotlin.coroutines.e a(fa<S> faVar, kotlin.coroutines.e eVar) {
            kotlin.jvm.internal.h.b(eVar, com.umeng.analytics.pro.b.Q);
            return e.b.a.a(faVar, eVar);
        }

        public static <S> kotlin.coroutines.e b(fa<S> faVar, e.c<?> cVar) {
            kotlin.jvm.internal.h.b(cVar, "key");
            return e.b.a.b(faVar, cVar);
        }
    }

    S a(kotlin.coroutines.e eVar);

    void a(kotlin.coroutines.e eVar, S s);
}
