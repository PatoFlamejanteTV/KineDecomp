package kotlinx.coroutines;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: CommonPool.kt */
/* renamed from: kotlinx.coroutines.h */
/* loaded from: classes3.dex */
final class ThreadFactoryC2539h implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ AtomicInteger f28623a;

    public ThreadFactoryC2539h(AtomicInteger atomicInteger) {
        this.f28623a = atomicInteger;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "CommonPool-worker-" + this.f28623a.incrementAndGet());
        thread.setDaemon(true);
        return thread;
    }
}
