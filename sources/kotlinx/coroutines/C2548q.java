package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* compiled from: CoroutineExceptionHandler.kt */
/* renamed from: kotlinx.coroutines.q, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2548q {
    public static final void a(kotlin.coroutines.e eVar, Throwable th, P p) {
        kotlin.jvm.internal.h.b(eVar, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(th, "exception");
        if (th instanceof CancellationException) {
            return;
        }
        P p2 = (P) eVar.get(P.f28600c);
        if (p2 == null || p2 == p || !p2.a(th)) {
            a(eVar, th);
        }
    }

    public static final void a(kotlin.coroutines.e eVar, Throwable th) {
        kotlin.jvm.internal.h.b(eVar, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(th, "exception");
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) eVar.get(CoroutineExceptionHandler.f28578c);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.a(eVar, th);
            } else {
                C2547p.a(eVar, th);
            }
        } catch (Throwable th2) {
            C2547p.a(eVar, a(th, th2));
        }
    }

    public static final Throwable a(Throwable th, Throwable th2) {
        kotlin.jvm.internal.h.b(th, "originalException");
        kotlin.jvm.internal.h.b(th2, "thrownException");
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        kotlin.b.a(runtimeException, th);
        return runtimeException;
    }
}
