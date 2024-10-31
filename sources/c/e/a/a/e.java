package c.e.a.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ImageWorker.java */
/* loaded from: classes.dex */
class e implements ThreadFactory {

    /* renamed from: a */
    private final AtomicInteger f3900a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AsyncTask #" + this.f3900a.getAndIncrement());
    }
}
