package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Status;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class KeepAliveManager {

    /* renamed from: a */
    private static final c f27408a = new c(null);

    /* renamed from: b */
    private static final long f27409b = TimeUnit.SECONDS.toNanos(10);

    /* renamed from: c */
    private static final long f27410c = TimeUnit.MILLISECONDS.toNanos(10);

    /* renamed from: d */
    private final ScheduledExecutorService f27411d;

    /* renamed from: e */
    private final d f27412e;

    /* renamed from: f */
    private final b f27413f;

    /* renamed from: g */
    private final boolean f27414g;

    /* renamed from: h */
    private State f27415h;
    private long i;
    private ScheduledFuture<?> j;
    private ScheduledFuture<?> k;
    private final Runnable l;
    private final Runnable m;
    private long n;
    private long o;

    /* loaded from: classes3.dex */
    public enum State {
        IDLE,
        PING_SCHEDULED,
        PING_DELAYED,
        PING_SENT,
        IDLE_AND_PING_SENT,
        DISCONNECTED
    }

    /* loaded from: classes3.dex */
    public static final class a implements b {

        /* renamed from: a */
        private final InterfaceC2424da f27416a;

        public a(InterfaceC2424da interfaceC2424da) {
            this.f27416a = interfaceC2424da;
        }

        @Override // io.grpc.internal.KeepAliveManager.b
        public void b() {
            this.f27416a.a(Status.q.b("Keepalive failed. The connection is likely gone"));
        }

        @Override // io.grpc.internal.KeepAliveManager.b
        public void a() {
            this.f27416a.a(new C2484sb(this), MoreExecutors.a());
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c extends d {
        private c() {
        }

        @Override // io.grpc.internal.KeepAliveManager.d
        public long a() {
            return System.nanoTime();
        }

        /* synthetic */ c(RunnableC2477qb runnableC2477qb) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class d {
        d() {
        }

        public abstract long a();
    }

    public KeepAliveManager(b bVar, ScheduledExecutorService scheduledExecutorService, long j, long j2, boolean z) {
        this(bVar, scheduledExecutorService, f27408a, j, j2, z);
    }

    @VisibleForTesting
    KeepAliveManager(b bVar, ScheduledExecutorService scheduledExecutorService, d dVar, long j, long j2, boolean z) {
        this.f27415h = State.IDLE;
        this.l = new RunnableC2488tb(new RunnableC2477qb(this));
        this.m = new RunnableC2488tb(new RunnableC2480rb(this));
        Preconditions.a(bVar, "keepAlivePinger");
        this.f27413f = bVar;
        Preconditions.a(scheduledExecutorService, "scheduler");
        this.f27411d = scheduledExecutorService;
        Preconditions.a(dVar, "ticker");
        this.f27412e = dVar;
        this.n = j;
        this.o = j2;
        this.f27414g = z;
        this.i = dVar.a() + j;
    }

    public synchronized void c() {
        if (this.f27414g) {
            return;
        }
        if (this.f27415h == State.PING_SCHEDULED || this.f27415h == State.PING_DELAYED) {
            this.f27415h = State.IDLE;
        }
        if (this.f27415h == State.PING_SENT) {
            this.f27415h = State.IDLE_AND_PING_SENT;
        }
    }

    public synchronized void d() {
        if (this.f27414g) {
            b();
        }
    }

    public synchronized void e() {
        if (this.f27415h != State.DISCONNECTED) {
            this.f27415h = State.DISCONNECTED;
            if (this.j != null) {
                this.j.cancel(false);
            }
            if (this.k != null) {
                this.k.cancel(false);
                this.k = null;
            }
        }
    }

    public synchronized void b() {
        if (this.f27415h == State.IDLE) {
            this.f27415h = State.PING_SCHEDULED;
            if (this.k == null) {
                this.k = this.f27411d.schedule(this.m, this.i - this.f27412e.a(), TimeUnit.NANOSECONDS);
            }
        } else if (this.f27415h == State.IDLE_AND_PING_SENT) {
            this.f27415h = State.PING_SENT;
        }
    }

    public synchronized void a() {
        this.i = this.f27412e.a() + this.n;
        if (this.f27415h == State.PING_SCHEDULED) {
            this.f27415h = State.PING_DELAYED;
        } else if (this.f27415h == State.PING_SENT || this.f27415h == State.IDLE_AND_PING_SENT) {
            if (this.j != null) {
                this.j.cancel(false);
            }
            if (this.f27415h == State.IDLE_AND_PING_SENT) {
                this.f27415h = State.IDLE;
            } else {
                this.f27415h = State.PING_SCHEDULED;
                Preconditions.b(this.k == null, "There should be no outstanding pingFuture");
                this.k = this.f27411d.schedule(this.m, this.n, TimeUnit.NANOSECONDS);
            }
        }
    }
}
