package io.reactivex;

import java.util.concurrent.TimeUnit;

/* compiled from: Scheduler.java */
/* loaded from: classes3.dex */
public abstract class r {

    /* renamed from: a */
    static final long f28488a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* compiled from: Scheduler.java */
    /* loaded from: classes3.dex */
    public static final class a implements io.reactivex.disposables.b, Runnable, io.reactivex.g.a {

        /* renamed from: a */
        final Runnable f28489a;

        /* renamed from: b */
        final b f28490b;

        /* renamed from: c */
        Thread f28491c;

        a(Runnable runnable, b bVar) {
            this.f28489a = runnable;
            this.f28490b = bVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f28491c == Thread.currentThread()) {
                b bVar = this.f28490b;
                if (bVar instanceof io.reactivex.internal.schedulers.e) {
                    ((io.reactivex.internal.schedulers.e) bVar).b();
                    return;
                }
            }
            this.f28490b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f28490b.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f28491c = Thread.currentThread();
            try {
                this.f28489a.run();
            } finally {
                dispose();
                this.f28491c = null;
            }
        }
    }

    /* compiled from: Scheduler.java */
    /* loaded from: classes3.dex */
    public static abstract class b implements io.reactivex.disposables.b {
        public io.reactivex.disposables.b a(Runnable runnable) {
            return a(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract io.reactivex.disposables.b a(Runnable runnable, long j, TimeUnit timeUnit);

        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public io.reactivex.disposables.b a(Runnable runnable) {
        return a(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public abstract b a();

    public io.reactivex.disposables.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        b a2 = a();
        a aVar = new a(io.reactivex.f.a.a(runnable), a2);
        a2.a(aVar, j, timeUnit);
        return aVar;
    }
}
