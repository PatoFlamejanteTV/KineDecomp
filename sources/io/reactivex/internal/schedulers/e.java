package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.r;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: NewThreadWorker.java */
/* loaded from: classes3.dex */
public class e extends r.b implements io.reactivex.disposables.b {

    /* renamed from: a */
    private final ScheduledExecutorService f28436a;

    /* renamed from: b */
    volatile boolean f28437b;

    public e(ThreadFactory threadFactory) {
        this.f28436a = h.a(threadFactory);
    }

    @Override // io.reactivex.r.b
    public io.reactivex.disposables.b a(Runnable runnable) {
        return a(runnable, 0L, null);
    }

    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(io.reactivex.f.a.a(runnable));
        try {
            if (j <= 0) {
                schedule = this.f28436a.submit(scheduledDirectTask);
            } else {
                schedule = this.f28436a.schedule(scheduledDirectTask, j, timeUnit);
            }
            scheduledDirectTask.setFuture(schedule);
            return scheduledDirectTask;
        } catch (RejectedExecutionException e2) {
            io.reactivex.f.a.b(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (this.f28437b) {
            return;
        }
        this.f28437b = true;
        this.f28436a.shutdownNow();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f28437b;
    }

    @Override // io.reactivex.r.b
    public io.reactivex.disposables.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (this.f28437b) {
            return EmptyDisposable.INSTANCE;
        }
        return a(runnable, j, timeUnit, null);
    }

    public ScheduledRunnable a(Runnable runnable, long j, TimeUnit timeUnit, io.reactivex.internal.disposables.a aVar) {
        Future<?> schedule;
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(io.reactivex.f.a.a(runnable), aVar);
        if (aVar != null && !aVar.b(scheduledRunnable)) {
            return scheduledRunnable;
        }
        try {
            if (j <= 0) {
                schedule = this.f28436a.submit((Callable) scheduledRunnable);
            } else {
                schedule = this.f28436a.schedule((Callable) scheduledRunnable, j, timeUnit);
            }
            scheduledRunnable.setFuture(schedule);
        } catch (RejectedExecutionException e2) {
            if (aVar != null) {
                aVar.a(scheduledRunnable);
            }
            io.reactivex.f.a.b(e2);
        }
        return scheduledRunnable;
    }

    public void b() {
        if (this.f28437b) {
            return;
        }
        this.f28437b = true;
        this.f28436a.shutdown();
    }
}
