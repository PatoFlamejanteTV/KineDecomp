package kotlinx.coroutines;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/* compiled from: CoroutineExceptionHandlerImpl.kt */
/* renamed from: kotlinx.coroutines.p, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2547p {

    /* renamed from: a, reason: collision with root package name */
    private static final List<CoroutineExceptionHandler> f28673a;

    static {
        List<CoroutineExceptionHandler> e2;
        ServiceLoader load = ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader());
        kotlin.jvm.internal.h.a((Object) load, "ServiceLoader.load(servi…serviceClass.classLoader)");
        e2 = kotlin.collections.t.e(load);
        f28673a = e2;
    }

    public static final void a(kotlin.coroutines.e eVar, Throwable th) {
        kotlin.jvm.internal.h.b(eVar, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(th, "exception");
        Iterator<CoroutineExceptionHandler> it = f28673a.iterator();
        while (it.hasNext()) {
            try {
                it.next().a(eVar, th);
            } catch (Throwable th2) {
                Thread currentThread = Thread.currentThread();
                kotlin.jvm.internal.h.a((Object) currentThread, "currentThread");
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, C2548q.a(th, th2));
            }
        }
        Thread currentThread2 = Thread.currentThread();
        kotlin.jvm.internal.h.a((Object) currentThread2, "currentThread");
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }
}
