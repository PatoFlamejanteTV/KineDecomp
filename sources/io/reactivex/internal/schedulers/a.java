package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.r;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ComputationScheduler.java */
/* loaded from: classes3.dex */
public final class a extends r implements g {

    /* renamed from: b, reason: collision with root package name */
    static final b f28401b;

    /* renamed from: c, reason: collision with root package name */
    static final RxThreadFactory f28402c;

    /* renamed from: d, reason: collision with root package name */
    static final int f28403d = a(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* renamed from: e, reason: collision with root package name */
    static final c f28404e = new c(new RxThreadFactory("RxComputationShutdown"));

    /* renamed from: f, reason: collision with root package name */
    final ThreadFactory f28405f;

    /* renamed from: g, reason: collision with root package name */
    final AtomicReference<b> f28406g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ComputationScheduler.java */
    /* loaded from: classes3.dex */
    public static final class b implements g {

        /* renamed from: a, reason: collision with root package name */
        final int f28412a;

        /* renamed from: b, reason: collision with root package name */
        final c[] f28413b;

        /* renamed from: c, reason: collision with root package name */
        long f28414c;

        b(int i, ThreadFactory threadFactory) {
            this.f28412a = i;
            this.f28413b = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f28413b[i2] = new c(threadFactory);
            }
        }

        public c a() {
            int i = this.f28412a;
            if (i == 0) {
                return a.f28404e;
            }
            c[] cVarArr = this.f28413b;
            long j = this.f28414c;
            this.f28414c = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void b() {
            for (c cVar : this.f28413b) {
                cVar.dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ComputationScheduler.java */
    /* loaded from: classes3.dex */
    public static final class c extends e {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        f28404e.dispose();
        f28402c = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f28401b = new b(0, f28402c);
        f28401b.b();
    }

    public a() {
        this(f28402c);
    }

    static int a(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    @Override // io.reactivex.r
    public r.b a() {
        return new C0163a(this.f28406g.get().a());
    }

    public void b() {
        b bVar = new b(f28403d, this.f28405f);
        if (this.f28406g.compareAndSet(f28401b, bVar)) {
            return;
        }
        bVar.b();
    }

    public a(ThreadFactory threadFactory) {
        this.f28405f = threadFactory;
        this.f28406g = new AtomicReference<>(f28401b);
        b();
    }

    @Override // io.reactivex.r
    public io.reactivex.disposables.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.f28406g.get().a().b(runnable, j, timeUnit);
    }

    /* compiled from: ComputationScheduler.java */
    /* renamed from: io.reactivex.internal.schedulers.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static final class C0163a extends r.b {

        /* renamed from: a, reason: collision with root package name */
        private final io.reactivex.internal.disposables.b f28407a = new io.reactivex.internal.disposables.b();

        /* renamed from: b, reason: collision with root package name */
        private final io.reactivex.disposables.a f28408b = new io.reactivex.disposables.a();

        /* renamed from: c, reason: collision with root package name */
        private final io.reactivex.internal.disposables.b f28409c = new io.reactivex.internal.disposables.b();

        /* renamed from: d, reason: collision with root package name */
        private final c f28410d;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f28411e;

        C0163a(c cVar) {
            this.f28410d = cVar;
            this.f28409c.b(this.f28407a);
            this.f28409c.b(this.f28408b);
        }

        @Override // io.reactivex.r.b
        public io.reactivex.disposables.b a(Runnable runnable) {
            if (this.f28411e) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f28410d.a(runnable, 0L, TimeUnit.MILLISECONDS, this.f28407a);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f28411e) {
                return;
            }
            this.f28411e = true;
            this.f28409c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f28411e;
        }

        @Override // io.reactivex.r.b
        public io.reactivex.disposables.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f28411e) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f28410d.a(runnable, j, timeUnit, this.f28408b);
        }
    }
}
