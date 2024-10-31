package com.bumptech.glide.load.engine.c;

import android.support.v7.widget.ActivityChooserView;
import com.facebook.share.internal.ShareConstants;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: GlideExecutor.java */
/* loaded from: classes.dex */
public final class b implements ExecutorService {

    /* renamed from: a */
    private static final long f8870a = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: b */
    private static volatile int f8871b;

    /* renamed from: c */
    private final ExecutorService f8872c;

    /* compiled from: GlideExecutor.java */
    /* loaded from: classes.dex */
    public static final class a implements ThreadFactory {

        /* renamed from: a */
        private final String f8873a;

        /* renamed from: b */
        final InterfaceC0056b f8874b;

        /* renamed from: c */
        final boolean f8875c;

        /* renamed from: d */
        private int f8876d;

        a(String str, InterfaceC0056b interfaceC0056b, boolean z) {
            this.f8873a = str;
            this.f8874b = interfaceC0056b;
            this.f8875c = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            com.bumptech.glide.load.engine.c.a aVar;
            aVar = new com.bumptech.glide.load.engine.c.a(this, runnable, "glide-" + this.f8873a + "-thread-" + this.f8876d);
            this.f8876d = this.f8876d + 1;
            return aVar;
        }
    }

    /* compiled from: GlideExecutor.java */
    /* renamed from: com.bumptech.glide.load.engine.c.b$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0056b {

        /* renamed from: a */
        public static final InterfaceC0056b f8877a = new c();

        /* renamed from: b */
        public static final InterfaceC0056b f8878b = new d();

        /* renamed from: c */
        public static final InterfaceC0056b f8879c = new e();

        /* renamed from: d */
        public static final InterfaceC0056b f8880d = f8878b;

        void a(Throwable th);
    }

    b(ExecutorService executorService) {
        this.f8872c = executorService;
    }

    public static b a(int i, String str, InterfaceC0056b interfaceC0056b) {
        return new b(new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a(str, interfaceC0056b, true)));
    }

    public static b b(int i, String str, InterfaceC0056b interfaceC0056b) {
        return new b(new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a(str, interfaceC0056b, false)));
    }

    public static b c() {
        return a(1, "disk-cache", InterfaceC0056b.f8880d);
    }

    public static b d() {
        return b(a(), ShareConstants.FEED_SOURCE_PARAM, InterfaceC0056b.f8880d);
    }

    public static b e() {
        return new b(new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, f8870a, TimeUnit.MILLISECONDS, new SynchronousQueue(), new a("source-unlimited", InterfaceC0056b.f8880d, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.f8872c.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f8872c.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f8872c.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return (T) this.f8872c.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f8872c.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f8872c.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f8872c.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.f8872c.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.f8872c.submit(runnable);
    }

    public String toString() {
        return this.f8872c.toString();
    }

    public static b a(int i, InterfaceC0056b interfaceC0056b) {
        return new b(new ThreadPoolExecutor(0, i, f8870a, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a("animation", interfaceC0056b, true)));
    }

    public static b b() {
        return a(a() >= 4 ? 2 : 1, InterfaceC0056b.f8880d);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.f8872c.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.f8872c.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.f8872c.submit(runnable, t);
    }

    public static int a() {
        if (f8871b == 0) {
            f8871b = Math.min(4, g.a());
        }
        return f8871b;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.f8872c.submit(callable);
    }
}
