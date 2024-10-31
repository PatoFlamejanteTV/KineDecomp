package io.fabric.sdk.android.services.concurrency;

import android.annotation.TargetApi;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: PriorityThreadPoolExecutor.java */
/* loaded from: classes3.dex */
public class o extends ThreadPoolExecutor {

    /* renamed from: a */
    private static final int f26959a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b */
    private static final int f26960b;

    /* renamed from: c */
    private static final int f26961c;

    /* compiled from: PriorityThreadPoolExecutor.java */
    /* loaded from: classes3.dex */
    public static final class a implements ThreadFactory {

        /* renamed from: a */
        private final int f26962a;

        public a(int i) {
            this.f26962a = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(this.f26962a);
            thread.setName("Queue");
            return thread;
        }
    }

    static {
        int i = f26959a;
        f26960b = i + 1;
        f26961c = (i * 2) + 1;
    }

    <T extends Runnable & g & p & m> o(int i, int i2, long j, TimeUnit timeUnit, DependencyPriorityBlockingQueue<T> dependencyPriorityBlockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, dependencyPriorityBlockingQueue, threadFactory);
        prestartAllCoreThreads();
    }

    public static <T extends Runnable & g & p & m> o a(int i, int i2) {
        return new o(i, i2, 1L, TimeUnit.SECONDS, new DependencyPriorityBlockingQueue(), new a(10));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        p pVar = (p) runnable;
        pVar.setFinished(true);
        pVar.setError(th);
        getQueue().recycleBlockedQueue();
        super.afterExecute(runnable, th);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    @TargetApi(9)
    public void execute(Runnable runnable) {
        if (n.isProperDelegate(runnable)) {
            super.execute(runnable);
        } else {
            super.execute(newTaskFor(runnable, null));
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new l(runnable, t);
    }

    public static o a() {
        return a(f26960b, f26961c);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public DependencyPriorityBlockingQueue getQueue() {
        return (DependencyPriorityBlockingQueue) super.getQueue();
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new l(callable);
    }
}
