package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.r;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleScheduler.java */
/* loaded from: classes3.dex */
public final class i extends r {

    /* renamed from: b, reason: collision with root package name */
    static final RxThreadFactory f28444b;

    /* renamed from: c, reason: collision with root package name */
    static final ScheduledExecutorService f28445c = Executors.newScheduledThreadPool(0);

    /* renamed from: d, reason: collision with root package name */
    final ThreadFactory f28446d;

    /* renamed from: e, reason: collision with root package name */
    final AtomicReference<ScheduledExecutorService> f28447e;

    /* compiled from: SingleScheduler.java */
    /* loaded from: classes3.dex */
    static final class a extends r.b {

        /* renamed from: a, reason: collision with root package name */
        final ScheduledExecutorService f28448a;

        /* renamed from: b, reason: collision with root package name */
        final io.reactivex.disposables.a f28449b = new io.reactivex.disposables.a();

        /* renamed from: c, reason: collision with root package name */
        volatile boolean f28450c;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.f28448a = scheduledExecutorService;
        }

        @Override // io.reactivex.r.b
        public io.reactivex.disposables.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            Future<?> schedule;
            if (this.f28450c) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(io.reactivex.f.a.a(runnable), this.f28449b);
            this.f28449b.b(scheduledRunnable);
            try {
                if (j <= 0) {
                    schedule = this.f28448a.submit((Callable) scheduledRunnable);
                } else {
                    schedule = this.f28448a.schedule((Callable) scheduledRunnable, j, timeUnit);
                }
                scheduledRunnable.setFuture(schedule);
                return scheduledRunnable;
            } catch (RejectedExecutionException e2) {
                dispose();
                io.reactivex.f.a.b(e2);
                return EmptyDisposable.INSTANCE;
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f28450c) {
                return;
            }
            this.f28450c = true;
            this.f28449b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f28450c;
        }
    }

    static {
        f28445c.shutdown();
        f28444b = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public i() {
        this(f28444b);
    }

    static ScheduledExecutorService a(ThreadFactory threadFactory) {
        return h.a(threadFactory);
    }

    public i(ThreadFactory threadFactory) {
        this.f28447e = new AtomicReference<>();
        this.f28446d = threadFactory;
        this.f28447e.lazySet(a(threadFactory));
    }

    @Override // io.reactivex.r
    public r.b a() {
        return new a(this.f28447e.get());
    }

    @Override // io.reactivex.r
    public io.reactivex.disposables.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(io.reactivex.f.a.a(runnable));
        try {
            if (j <= 0) {
                schedule = this.f28447e.get().submit(scheduledDirectTask);
            } else {
                schedule = this.f28447e.get().schedule(scheduledDirectTask, j, timeUnit);
            }
            scheduledDirectTask.setFuture(schedule);
            return scheduledDirectTask;
        } catch (RejectedExecutionException e2) {
            io.reactivex.f.a.b(e2);
            return EmptyDisposable.INSTANCE;
        }
    }
}
