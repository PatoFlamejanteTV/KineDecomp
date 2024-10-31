package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.r;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ExecutorScheduler extends r {

    /* renamed from: b, reason: collision with root package name */
    static final r f28387b = io.reactivex.g.b.c();

    /* renamed from: c, reason: collision with root package name */
    final boolean f28388c;

    /* renamed from: d, reason: collision with root package name */
    final Executor f28389d;

    /* loaded from: classes3.dex */
    static final class DelayedRunnable extends AtomicReference<Runnable> implements Runnable, io.reactivex.disposables.b, io.reactivex.g.a {
        private static final long serialVersionUID = -4101336210206799084L;
        final SequentialDisposable direct;
        final SequentialDisposable timed;

        DelayedRunnable(Runnable runnable) {
            super(runnable);
            this.timed = new SequentialDisposable();
            this.direct = new SequentialDisposable();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (getAndSet(null) != null) {
                this.timed.dispose();
                this.direct.dispose();
            }
        }

        public Runnable getWrappedRunnable() {
            Runnable runnable = get();
            return runnable != null ? runnable : io.reactivex.d.a.a.f28103b;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == null;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = get();
            if (runnable != null) {
                try {
                    runnable.run();
                } finally {
                    lazySet(null);
                    this.timed.lazySet(DisposableHelper.DISPOSED);
                    this.direct.lazySet(DisposableHelper.DISPOSED);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final DelayedRunnable f28399a;

        a(DelayedRunnable delayedRunnable) {
            this.f28399a = delayedRunnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            DelayedRunnable delayedRunnable = this.f28399a;
            delayedRunnable.direct.replace(ExecutorScheduler.this.a(delayedRunnable));
        }
    }

    public ExecutorScheduler(Executor executor, boolean z) {
        this.f28389d = executor;
        this.f28388c = z;
    }

    @Override // io.reactivex.r
    public r.b a() {
        return new ExecutorWorker(this.f28389d, this.f28388c);
    }

    @Override // io.reactivex.r
    public io.reactivex.disposables.b a(Runnable runnable) {
        Runnable a2 = io.reactivex.f.a.a(runnable);
        try {
            if (this.f28389d instanceof ExecutorService) {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(a2);
                scheduledDirectTask.setFuture(((ExecutorService) this.f28389d).submit(scheduledDirectTask));
                return scheduledDirectTask;
            }
            if (this.f28388c) {
                ExecutorWorker.InterruptibleRunnable interruptibleRunnable = new ExecutorWorker.InterruptibleRunnable(a2, null);
                this.f28389d.execute(interruptibleRunnable);
                return interruptibleRunnable;
            }
            ExecutorWorker.BooleanRunnable booleanRunnable = new ExecutorWorker.BooleanRunnable(a2);
            this.f28389d.execute(booleanRunnable);
            return booleanRunnable;
        } catch (RejectedExecutionException e2) {
            io.reactivex.f.a.b(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    /* loaded from: classes3.dex */
    public static final class ExecutorWorker extends r.b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final boolean f28390a;

        /* renamed from: b, reason: collision with root package name */
        final Executor f28391b;

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f28393d;

        /* renamed from: e, reason: collision with root package name */
        final AtomicInteger f28394e = new AtomicInteger();

        /* renamed from: f, reason: collision with root package name */
        final io.reactivex.disposables.a f28395f = new io.reactivex.disposables.a();

        /* renamed from: c, reason: collision with root package name */
        final MpscLinkedQueue<Runnable> f28392c = new MpscLinkedQueue<>();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static final class BooleanRunnable extends AtomicBoolean implements Runnable, io.reactivex.disposables.b {
            private static final long serialVersionUID = -2421395018820541164L;
            final Runnable actual;

            BooleanRunnable(Runnable runnable) {
                this.actual = runnable;
            }

            @Override // io.reactivex.disposables.b
            public void dispose() {
                lazySet(true);
            }

            @Override // io.reactivex.disposables.b
            public boolean isDisposed() {
                return get();
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get()) {
                    return;
                }
                try {
                    this.actual.run();
                } finally {
                    lazySet(true);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static final class InterruptibleRunnable extends AtomicInteger implements Runnable, io.reactivex.disposables.b {
            static final int FINISHED = 2;
            static final int INTERRUPTED = 4;
            static final int INTERRUPTING = 3;
            static final int READY = 0;
            static final int RUNNING = 1;
            private static final long serialVersionUID = -3603436687413320876L;
            final Runnable run;
            final io.reactivex.internal.disposables.a tasks;
            volatile Thread thread;

            InterruptibleRunnable(Runnable runnable, io.reactivex.internal.disposables.a aVar) {
                this.run = runnable;
                this.tasks = aVar;
            }

            void cleanup() {
                io.reactivex.internal.disposables.a aVar = this.tasks;
                if (aVar != null) {
                    aVar.c(this);
                }
            }

            @Override // io.reactivex.disposables.b
            public void dispose() {
                while (true) {
                    int i = get();
                    if (i >= 2) {
                        return;
                    }
                    if (i == 0) {
                        if (compareAndSet(0, 4)) {
                            cleanup();
                            return;
                        }
                    } else if (compareAndSet(1, 3)) {
                        Thread thread = this.thread;
                        if (thread != null) {
                            thread.interrupt();
                            this.thread = null;
                        }
                        set(4);
                        cleanup();
                        return;
                    }
                }
            }

            @Override // io.reactivex.disposables.b
            public boolean isDisposed() {
                return get() >= 2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get() == 0) {
                    this.thread = Thread.currentThread();
                    if (compareAndSet(0, 1)) {
                        try {
                            this.run.run();
                            this.thread = null;
                            if (compareAndSet(1, 2)) {
                                cleanup();
                                return;
                            }
                            while (get() == 3) {
                                Thread.yield();
                            }
                            Thread.interrupted();
                            return;
                        } catch (Throwable th) {
                            this.thread = null;
                            if (!compareAndSet(1, 2)) {
                                while (get() == 3) {
                                    Thread.yield();
                                }
                                Thread.interrupted();
                            } else {
                                cleanup();
                            }
                            throw th;
                        }
                    }
                    this.thread = null;
                }
            }
        }

        /* loaded from: classes3.dex */
        final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final SequentialDisposable f28396a;

            /* renamed from: b, reason: collision with root package name */
            private final Runnable f28397b;

            a(SequentialDisposable sequentialDisposable, Runnable runnable) {
                this.f28396a = sequentialDisposable;
                this.f28397b = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f28396a.replace(ExecutorWorker.this.a(this.f28397b));
            }
        }

        public ExecutorWorker(Executor executor, boolean z) {
            this.f28391b = executor;
            this.f28390a = z;
        }

        @Override // io.reactivex.r.b
        public io.reactivex.disposables.b a(Runnable runnable) {
            io.reactivex.disposables.b booleanRunnable;
            if (this.f28393d) {
                return EmptyDisposable.INSTANCE;
            }
            Runnable a2 = io.reactivex.f.a.a(runnable);
            if (this.f28390a) {
                booleanRunnable = new InterruptibleRunnable(a2, this.f28395f);
                this.f28395f.b(booleanRunnable);
            } else {
                booleanRunnable = new BooleanRunnable(a2);
            }
            this.f28392c.offer(booleanRunnable);
            if (this.f28394e.getAndIncrement() == 0) {
                try {
                    this.f28391b.execute(this);
                } catch (RejectedExecutionException e2) {
                    this.f28393d = true;
                    this.f28392c.clear();
                    io.reactivex.f.a.b(e2);
                    return EmptyDisposable.INSTANCE;
                }
            }
            return booleanRunnable;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f28393d) {
                return;
            }
            this.f28393d = true;
            this.f28395f.dispose();
            if (this.f28394e.getAndIncrement() == 0) {
                this.f28392c.clear();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f28393d;
        }

        @Override // java.lang.Runnable
        public void run() {
            MpscLinkedQueue<Runnable> mpscLinkedQueue = this.f28392c;
            int i = 1;
            while (!this.f28393d) {
                do {
                    Runnable poll = mpscLinkedQueue.poll();
                    if (poll == null) {
                        if (this.f28393d) {
                            mpscLinkedQueue.clear();
                            return;
                        } else {
                            i = this.f28394e.addAndGet(-i);
                            if (i == 0) {
                                return;
                            }
                        }
                    } else {
                        poll.run();
                    }
                } while (!this.f28393d);
                mpscLinkedQueue.clear();
                return;
            }
            mpscLinkedQueue.clear();
        }

        @Override // io.reactivex.r.b
        public io.reactivex.disposables.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (j <= 0) {
                return a(runnable);
            }
            if (this.f28393d) {
                return EmptyDisposable.INSTANCE;
            }
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(new a(sequentialDisposable2, io.reactivex.f.a.a(runnable)), this.f28395f);
            this.f28395f.b(scheduledRunnable);
            Executor executor = this.f28391b;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    scheduledRunnable.setFuture(((ScheduledExecutorService) executor).schedule((Callable) scheduledRunnable, j, timeUnit));
                } catch (RejectedExecutionException e2) {
                    this.f28393d = true;
                    io.reactivex.f.a.b(e2);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                scheduledRunnable.setFuture(new b(ExecutorScheduler.f28387b.a(scheduledRunnable, j, timeUnit)));
            }
            sequentialDisposable.replace(scheduledRunnable);
            return sequentialDisposable2;
        }
    }

    @Override // io.reactivex.r
    public io.reactivex.disposables.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        Runnable a2 = io.reactivex.f.a.a(runnable);
        if (this.f28389d instanceof ScheduledExecutorService) {
            try {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(a2);
                scheduledDirectTask.setFuture(((ScheduledExecutorService) this.f28389d).schedule(scheduledDirectTask, j, timeUnit));
                return scheduledDirectTask;
            } catch (RejectedExecutionException e2) {
                io.reactivex.f.a.b(e2);
                return EmptyDisposable.INSTANCE;
            }
        }
        DelayedRunnable delayedRunnable = new DelayedRunnable(a2);
        delayedRunnable.timed.replace(f28387b.a(new a(delayedRunnable), j, timeUnit));
        return delayedRunnable;
    }
}
