package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;

/* compiled from: TimeSource.kt */
/* renamed from: kotlinx.coroutines.y */
/* loaded from: classes3.dex */
public final class C2555y implements ha {

    /* renamed from: a */
    public static final C2555y f28730a = new C2555y();

    private C2555y() {
    }

    @Override // kotlinx.coroutines.ha
    public Runnable a(Runnable runnable) {
        kotlin.jvm.internal.h.b(runnable, "block");
        return runnable;
    }

    @Override // kotlinx.coroutines.ha
    public void a() {
    }

    @Override // kotlinx.coroutines.ha
    public void a(Object obj, long j) {
        kotlin.jvm.internal.h.b(obj, "blocker");
        LockSupport.parkNanos(obj, j);
    }

    @Override // kotlinx.coroutines.ha
    public long b() {
        return System.nanoTime();
    }

    @Override // kotlinx.coroutines.ha
    public void c() {
    }

    @Override // kotlinx.coroutines.ha
    public void d() {
    }

    @Override // kotlinx.coroutines.ha
    public void e() {
    }

    @Override // kotlinx.coroutines.ha
    public void a(Thread thread) {
        kotlin.jvm.internal.h.b(thread, "thread");
        LockSupport.unpark(thread);
    }
}
