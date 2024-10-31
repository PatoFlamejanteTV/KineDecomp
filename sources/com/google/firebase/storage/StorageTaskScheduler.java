package com.google.firebase.storage;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public class StorageTaskScheduler {

    /* renamed from: a */
    public static StorageTaskScheduler f18112a = new StorageTaskScheduler();

    /* renamed from: b */
    private static BlockingQueue<Runnable> f18113b = new LinkedBlockingQueue();

    /* renamed from: c */
    private static final ThreadPoolExecutor f18114c = new ThreadPoolExecutor(5, 5, 5, TimeUnit.SECONDS, f18113b, new a("Command-"));

    /* renamed from: d */
    private static BlockingQueue<Runnable> f18115d = new LinkedBlockingQueue();

    /* renamed from: e */
    private static final ThreadPoolExecutor f18116e = new ThreadPoolExecutor(2, 2, 5, TimeUnit.SECONDS, f18115d, new a("Upload-"));

    /* renamed from: f */
    private static BlockingQueue<Runnable> f18117f = new LinkedBlockingQueue();

    /* renamed from: g */
    private static final ThreadPoolExecutor f18118g = new ThreadPoolExecutor(3, 3, 5, TimeUnit.SECONDS, f18117f, new a("Download-"));

    /* renamed from: h */
    private static BlockingQueue<Runnable> f18119h = new LinkedBlockingQueue();
    private static final ThreadPoolExecutor i = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, f18119h, new a("Callbacks-"));

    /* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
    /* loaded from: classes2.dex */
    static class a implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f18120a = new AtomicInteger(1);

        /* renamed from: b */
        private final String f18121b;

        a(String str) {
            this.f18121b = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "FirebaseStorage-" + this.f18121b + this.f18120a.getAndIncrement());
            thread.setDaemon(false);
            thread.setPriority(9);
            return thread;
        }
    }

    static {
        f18114c.allowCoreThreadTimeOut(true);
        f18116e.allowCoreThreadTimeOut(true);
        f18118g.allowCoreThreadTimeOut(true);
        i.allowCoreThreadTimeOut(true);
    }

    public static StorageTaskScheduler a() {
        return f18112a;
    }

    public void b(Runnable runnable) {
        f18114c.execute(runnable);
    }

    public void c(Runnable runnable) {
        f18118g.execute(runnable);
    }

    public void d(Runnable runnable) {
        f18116e.execute(runnable);
    }

    public void a(Runnable runnable) {
        i.execute(runnable);
    }
}
