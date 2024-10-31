package kotlin.coroutines;

import kotlin.TypeCastException;
import kotlin.coroutines.e;
import kotlin.jvm.internal.h;

/* compiled from: ContinuationInterceptor.kt */
/* loaded from: classes3.dex */
public interface c extends e.b {

    /* renamed from: c */
    public static final b f28514c = b.f28515a;

    /* compiled from: ContinuationInterceptor.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public static <E extends e.b> E a(c cVar, e.c<E> cVar2) {
            h.b(cVar2, "key");
            if (cVar2 != c.f28514c) {
                return null;
            }
            if (cVar != null) {
                return cVar;
            }
            throw new TypeCastException("null cannot be cast to non-null type E");
        }

        public static void a(c cVar, kotlin.coroutines.b<?> bVar) {
            h.b(bVar, "continuation");
        }

        public static e b(c cVar, e.c<?> cVar2) {
            h.b(cVar2, "key");
            return cVar2 == c.f28514c ? EmptyCoroutineContext.INSTANCE : cVar;
        }
    }

    /* compiled from: ContinuationInterceptor.kt */
    /* loaded from: classes3.dex */
    public static final class b implements e.c<c> {

        /* renamed from: a */
        static final /* synthetic */ b f28515a = new b();

        private b() {
        }
    }

    void a(kotlin.coroutines.b<?> bVar);

    <T> kotlin.coroutines.b<T> b(kotlin.coroutines.b<? super T> bVar);
}
