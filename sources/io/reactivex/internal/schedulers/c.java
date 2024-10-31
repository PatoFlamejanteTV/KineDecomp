package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.r;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: IoScheduler.java */
/* loaded from: classes3.dex */
public final class c extends r {

    /* renamed from: b, reason: collision with root package name */
    static final RxThreadFactory f28416b;

    /* renamed from: c, reason: collision with root package name */
    static final RxThreadFactory f28417c;

    /* renamed from: g, reason: collision with root package name */
    static final a f28421g;

    /* renamed from: h, reason: collision with root package name */
    final ThreadFactory f28422h;
    final AtomicReference<a> i;

    /* renamed from: e, reason: collision with root package name */
    private static final TimeUnit f28419e = TimeUnit.SECONDS;

    /* renamed from: d, reason: collision with root package name */
    private static final long f28418d = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    /* renamed from: f, reason: collision with root package name */
    static final C0164c f28420f = new C0164c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoScheduler.java */
    /* loaded from: classes3.dex */
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final long f28423a;

        /* renamed from: b, reason: collision with root package name */
        private final ConcurrentLinkedQueue<C0164c> f28424b;

        /* renamed from: c, reason: collision with root package name */
        final io.reactivex.disposables.a f28425c;

        /* renamed from: d, reason: collision with root package name */
        private final ScheduledExecutorService f28426d;

        /* renamed from: e, reason: collision with root package name */
        private final Future<?> f28427e;

        /* renamed from: f, reason: collision with root package name */
        private final ThreadFactory f28428f;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            this.f28423a = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f28424b = new ConcurrentLinkedQueue<>();
            this.f28425c = new io.reactivex.disposables.a();
            this.f28428f = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, c.f28417c);
                long j2 = this.f28423a;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f28426d = scheduledExecutorService;
            this.f28427e = scheduledFuture;
        }

        void a(C0164c c0164c) {
            c0164c.a(d() + this.f28423a);
            this.f28424b.offer(c0164c);
        }

        void b() {
            if (this.f28424b.isEmpty()) {
                return;
            }
            long d2 = d();
            Iterator<C0164c> it = this.f28424b.iterator();
            while (it.hasNext()) {
                C0164c next = it.next();
                if (next.c() > d2) {
                    return;
                }
                if (this.f28424b.remove(next)) {
                    this.f28425c.a(next);
                }
            }
        }

        C0164c c() {
            if (this.f28425c.isDisposed()) {
                return c.f28420f;
            }
            while (!this.f28424b.isEmpty()) {
                C0164c poll = this.f28424b.poll();
                if (poll != null) {
                    return poll;
                }
            }
            C0164c c0164c = new C0164c(this.f28428f);
            this.f28425c.b(c0164c);
            return c0164c;
        }

        long d() {
            return System.nanoTime();
        }

        void e() {
            this.f28425c.dispose();
            Future<?> future = this.f28427e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f28426d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            b();
        }
    }

    /* compiled from: IoScheduler.java */
    /* loaded from: classes3.dex */
    static final class b extends r.b {

        /* renamed from: b, reason: collision with root package name */
        private final a f28430b;

        /* renamed from: c, reason: collision with root package name */
        private final C0164c f28431c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicBoolean f28432d = new AtomicBoolean();

        /* renamed from: a, reason: collision with root package name */
        private final io.reactivex.disposables.a f28429a = new io.reactivex.disposables.a();

        b(a aVar) {
            this.f28430b = aVar;
            this.f28431c = aVar.c();
        }

        @Override // io.reactivex.r.b
        public io.reactivex.disposables.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f28429a.isDisposed()) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f28431c.a(runnable, j, timeUnit, this.f28429a);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f28432d.compareAndSet(false, true)) {
                this.f28429a.dispose();
                this.f28430b.a(this.f28431c);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f28432d.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoScheduler.java */
    /* renamed from: io.reactivex.internal.schedulers.c$c, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0164c extends e {

        /* renamed from: c, reason: collision with root package name */
        private long f28433c;

        C0164c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f28433c = 0L;
        }

        public void a(long j) {
            this.f28433c = j;
        }

        public long c() {
            return this.f28433c;
        }
    }

    static {
        f28420f.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        f28416b = new RxThreadFactory("RxCachedThreadScheduler", max);
        f28417c = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        f28421g = new a(0L, null, f28416b);
        f28421g.e();
    }

    public c() {
        this(f28416b);
    }

    @Override // io.reactivex.r
    public r.b a() {
        return new b(this.i.get());
    }

    public void b() {
        a aVar = new a(f28418d, f28419e, this.f28422h);
        if (this.i.compareAndSet(f28421g, aVar)) {
            return;
        }
        aVar.e();
    }

    public c(ThreadFactory threadFactory) {
        this.f28422h = threadFactory;
        this.i = new AtomicReference<>(f28421g);
        b();
    }
}
