package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.e;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: Job.kt */
/* loaded from: classes3.dex */
public interface P extends e.b {

    /* renamed from: c */
    public static final b f28600c = b.f28601a;

    /* compiled from: Job.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public static <R> R a(P p, R r, kotlin.jvm.a.c<? super R, ? super e.b, ? extends R> cVar) {
            kotlin.jvm.internal.h.b(cVar, "operation");
            return (R) e.b.a.a(p, r, cVar);
        }

        public static <E extends e.b> E a(P p, e.c<E> cVar) {
            kotlin.jvm.internal.h.b(cVar, "key");
            return (E) e.b.a.a(p, cVar);
        }

        public static kotlin.coroutines.e a(P p, kotlin.coroutines.e eVar) {
            kotlin.jvm.internal.h.b(eVar, com.umeng.analytics.pro.b.Q);
            return e.b.a.a(p, eVar);
        }

        public static /* synthetic */ E a(P p, boolean z, boolean z2, kotlin.jvm.a.b bVar, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                if ((i & 2) != 0) {
                    z2 = true;
                }
                return p.a(z, z2, bVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        public static kotlin.coroutines.e b(P p, e.c<?> cVar) {
            kotlin.jvm.internal.h.b(cVar, "key");
            return e.b.a.b(p, cVar);
        }
    }

    /* compiled from: Job.kt */
    /* loaded from: classes3.dex */
    public static final class b implements e.c<P> {

        /* renamed from: a */
        static final /* synthetic */ b f28601a = new b();

        static {
            CoroutineExceptionHandler.a aVar = CoroutineExceptionHandler.f28578c;
        }

        private b() {
        }
    }

    E a(boolean z, boolean z2, kotlin.jvm.a.b<? super Throwable, kotlin.k> bVar);

    InterfaceC2536e a(InterfaceC2538g interfaceC2538g);

    boolean a(Throwable th);

    CancellationException b();

    boolean isActive();

    boolean start();
}
