package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.r;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TrampolineScheduler.java */
/* loaded from: classes3.dex */
public final class j extends r {

    /* renamed from: b, reason: collision with root package name */
    private static final j f28451b = new j();

    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes3.dex */
    static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Runnable f28452a;

        /* renamed from: b, reason: collision with root package name */
        private final c f28453b;

        /* renamed from: c, reason: collision with root package name */
        private final long f28454c;

        a(Runnable runnable, c cVar, long j) {
            this.f28452a = runnable;
            this.f28453b = cVar;
            this.f28454c = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f28453b.f28462d) {
                return;
            }
            long a2 = this.f28453b.a(TimeUnit.MILLISECONDS);
            long j = this.f28454c;
            if (j > a2) {
                try {
                    Thread.sleep(j - a2);
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    io.reactivex.f.a.b(e2);
                    return;
                }
            }
            if (this.f28453b.f28462d) {
                return;
            }
            this.f28452a.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes3.dex */
    public static final class b implements Comparable<b> {

        /* renamed from: a, reason: collision with root package name */
        final Runnable f28455a;

        /* renamed from: b, reason: collision with root package name */
        final long f28456b;

        /* renamed from: c, reason: collision with root package name */
        final int f28457c;

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f28458d;

        b(Runnable runnable, Long l, int i) {
            this.f28455a = runnable;
            this.f28456b = l.longValue();
            this.f28457c = i;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            int a2 = io.reactivex.d.a.b.a(this.f28456b, bVar.f28456b);
            return a2 == 0 ? io.reactivex.d.a.b.a(this.f28457c, bVar.f28457c) : a2;
        }
    }

    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes3.dex */
    static final class c extends r.b implements io.reactivex.disposables.b {

        /* renamed from: a, reason: collision with root package name */
        final PriorityBlockingQueue<b> f28459a = new PriorityBlockingQueue<>();

        /* renamed from: b, reason: collision with root package name */
        private final AtomicInteger f28460b = new AtomicInteger();

        /* renamed from: c, reason: collision with root package name */
        final AtomicInteger f28461c = new AtomicInteger();

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f28462d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TrampolineScheduler.java */
        /* loaded from: classes3.dex */
        public final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final b f28463a;

            a(b bVar) {
                this.f28463a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = this.f28463a;
                bVar.f28458d = true;
                c.this.f28459a.remove(bVar);
            }
        }

        c() {
        }

        @Override // io.reactivex.r.b
        public io.reactivex.disposables.b a(Runnable runnable) {
            return a(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f28462d = true;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f28462d;
        }

        @Override // io.reactivex.r.b
        public io.reactivex.disposables.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            long a2 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return a(new a(runnable, this, a2), a2);
        }

        io.reactivex.disposables.b a(Runnable runnable, long j) {
            if (this.f28462d) {
                return EmptyDisposable.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j), this.f28461c.incrementAndGet());
            this.f28459a.add(bVar);
            if (this.f28460b.getAndIncrement() == 0) {
                int i = 1;
                while (!this.f28462d) {
                    b poll = this.f28459a.poll();
                    if (poll == null) {
                        i = this.f28460b.addAndGet(-i);
                        if (i == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                    } else if (!poll.f28458d) {
                        poll.f28455a.run();
                    }
                }
                this.f28459a.clear();
                return EmptyDisposable.INSTANCE;
            }
            return io.reactivex.disposables.c.a(new a(bVar));
        }
    }

    j() {
    }

    public static j b() {
        return f28451b;
    }

    @Override // io.reactivex.r
    public r.b a() {
        return new c();
    }

    @Override // io.reactivex.r
    public io.reactivex.disposables.b a(Runnable runnable) {
        io.reactivex.f.a.a(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.r
    public io.reactivex.disposables.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            io.reactivex.f.a.a(runnable).run();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            io.reactivex.f.a.b(e2);
        }
        return EmptyDisposable.INSTANCE;
    }
}
