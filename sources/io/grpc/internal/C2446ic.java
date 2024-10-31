package io.grpc.internal;

import com.google.common.base.Stopwatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: Rescheduler.java */
/* renamed from: io.grpc.internal.ic */
/* loaded from: classes3.dex */
public final class C2446ic {

    /* renamed from: a */
    private final ScheduledExecutorService f27634a;

    /* renamed from: b */
    private final Executor f27635b;

    /* renamed from: c */
    private final Runnable f27636c;

    /* renamed from: d */
    private final Stopwatch f27637d;

    /* renamed from: e */
    private long f27638e;

    /* renamed from: f */
    private boolean f27639f;

    /* renamed from: g */
    private ScheduledFuture<?> f27640g;

    /* compiled from: Rescheduler.java */
    /* renamed from: io.grpc.internal.ic$a */
    /* loaded from: classes3.dex */
    private final class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C2446ic.this.f27639f) {
                long a2 = C2446ic.this.a();
                if (C2446ic.this.f27638e - a2 <= 0) {
                    C2446ic.this.f27639f = false;
                    C2446ic.this.f27640g = null;
                    C2446ic.this.f27636c.run();
                    return;
                } else {
                    C2446ic c2446ic = C2446ic.this;
                    c2446ic.f27640g = c2446ic.f27634a.schedule(new b(C2446ic.this), C2446ic.this.f27638e - a2, TimeUnit.NANOSECONDS);
                    return;
                }
            }
            C2446ic.this.f27640g = null;
        }

        /* synthetic */ a(C2446ic c2446ic, C2442hc c2442hc) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Rescheduler.java */
    /* renamed from: io.grpc.internal.ic$b */
    /* loaded from: classes3.dex */
    public static final class b implements Runnable {

        /* renamed from: a */
        private final C2446ic f27642a;

        b(C2446ic c2446ic) {
            this.f27642a = c2446ic;
        }

        @Override // java.lang.Runnable
        public void run() {
            Executor executor = this.f27642a.f27635b;
            C2446ic c2446ic = this.f27642a;
            c2446ic.getClass();
            executor.execute(new a());
        }
    }

    public C2446ic(Runnable runnable, Executor executor, ScheduledExecutorService scheduledExecutorService, Stopwatch stopwatch) {
        this.f27636c = runnable;
        this.f27635b = executor;
        this.f27634a = scheduledExecutorService;
        this.f27637d = stopwatch;
        stopwatch.d();
    }

    public void a(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        long a2 = a() + nanos;
        this.f27639f = true;
        if (a2 - this.f27638e < 0 || this.f27640g == null) {
            ScheduledFuture<?> scheduledFuture = this.f27640g;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.f27640g = this.f27634a.schedule(new b(this), nanos, TimeUnit.NANOSECONDS);
        }
        this.f27638e = a2;
    }

    public void a(boolean z) {
        ScheduledFuture<?> scheduledFuture;
        this.f27639f = false;
        if (!z || (scheduledFuture = this.f27640g) == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.f27640g = null;
    }

    public long a() {
        return this.f27637d.a(TimeUnit.NANOSECONDS);
    }
}
