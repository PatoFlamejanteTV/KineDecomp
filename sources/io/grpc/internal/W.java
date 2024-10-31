package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.AbstractC2408g;
import io.grpc.C2406e;
import io.grpc.C2522q;
import io.grpc.C2524t;
import io.grpc.C2526v;
import io.grpc.C2528x;
import io.grpc.Context;
import io.grpc.InterfaceC2514o;
import io.grpc.InterfaceC2521p;
import io.grpc.J;
import io.grpc.MethodDescriptor;
import io.grpc.P;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.Oc;
import java.nio.charset.Charset;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ClientCallImpl.java */
/* loaded from: classes3.dex */
public final class W<ReqT, RespT> extends AbstractC2408g<ReqT, RespT> {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f27519a = Logger.getLogger(W.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f27520b = "gzip".getBytes(Charset.forName("US-ASCII"));

    /* renamed from: c, reason: collision with root package name */
    private final MethodDescriptor<ReqT, RespT> f27521c;

    /* renamed from: d, reason: collision with root package name */
    private final Executor f27522d;

    /* renamed from: e, reason: collision with root package name */
    private final C f27523e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f27524f;

    /* renamed from: g, reason: collision with root package name */
    private volatile ScheduledFuture<?> f27525g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f27526h;
    private final C2406e i;
    private final boolean j;
    private X k;
    private volatile boolean l;
    private boolean m;
    private boolean n;
    private final b o;
    private ScheduledExecutorService q;
    private boolean r;
    private final Context.b p = new c();
    private C2528x s = C2528x.c();
    private C2522q t = C2522q.a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ClientCallImpl.java */
    /* loaded from: classes3.dex */
    public class a implements ClientStreamListener {

        /* renamed from: a, reason: collision with root package name */
        private final AbstractC2408g.a<RespT> f27527a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f27528b;

        public a(AbstractC2408g.a<RespT> aVar) {
            Preconditions.a(aVar, "observer");
            this.f27527a = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Status status, io.grpc.P p) {
            this.f27528b = true;
            W.this.l = true;
            try {
                W.this.a(this.f27527a, status, p);
            } finally {
                W.this.c();
                W.this.f27523e.a(status.g());
            }
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void a(io.grpc.P p) {
            W.this.f27522d.execute(new S(this, p));
        }

        @Override // io.grpc.internal.Oc
        public void a(Oc.a aVar) {
            W.this.f27522d.execute(new T(this, aVar));
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void a(Status status, io.grpc.P p) {
            a(status, ClientStreamListener.RpcProgress.PROCESSED, p);
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void a(Status status, ClientStreamListener.RpcProgress rpcProgress, io.grpc.P p) {
            C2526v b2 = W.this.b();
            if (status.e() == Status.Code.CANCELLED && b2 != null && b2.a()) {
                status = Status.f27133f;
                p = new io.grpc.P();
            }
            W.this.f27522d.execute(new U(this, status, p));
        }

        @Override // io.grpc.internal.Oc
        public void a() {
            W.this.f27522d.execute(new V(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClientCallImpl.java */
    /* loaded from: classes3.dex */
    public interface b {
        Y a(J.d dVar);

        <ReqT> wc<ReqT> a(MethodDescriptor<ReqT, ?> methodDescriptor, C2406e c2406e, io.grpc.P p, Context context);
    }

    /* compiled from: ClientCallImpl.java */
    /* loaded from: classes3.dex */
    private final class c implements Context.b {
        private c() {
        }

        @Override // io.grpc.Context.b
        public void a(Context context) {
            W.this.k.a(C2524t.a(context));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ClientCallImpl.java */
    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final long f27531a;

        d(long j) {
            this.f27531a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            W.this.k.a(Status.f27133f.a(String.format("deadline exceeded after %dns", Long.valueOf(this.f27531a))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public W(MethodDescriptor<ReqT, RespT> methodDescriptor, Executor executor, C2406e c2406e, b bVar, ScheduledExecutorService scheduledExecutorService, C c2, boolean z) {
        Executor dc;
        this.f27521c = methodDescriptor;
        if (executor == MoreExecutors.a()) {
            dc = new Bc();
        } else {
            dc = new Dc(executor);
        }
        this.f27522d = dc;
        this.f27523e = c2;
        this.f27524f = Context.s();
        this.f27526h = methodDescriptor.d() == MethodDescriptor.MethodType.UNARY || methodDescriptor.d() == MethodDescriptor.MethodType.SERVER_STREAMING;
        this.i = c2406e;
        this.o = bVar;
        this.q = scheduledExecutorService;
        this.j = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public C2526v b() {
        return a(this.i.d(), this.f27524f.u());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f27524f.a(this.p);
        ScheduledFuture<?> scheduledFuture = this.f27525g;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public W<ReqT, RespT> a(boolean z) {
        this.r = z;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public W<ReqT, RespT> a(C2528x c2528x) {
        this.s = c2528x;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public W<ReqT, RespT> a(C2522q c2522q) {
        this.t = c2522q;
        return this;
    }

    @VisibleForTesting
    static void a(io.grpc.P p, C2528x c2528x, InterfaceC2521p interfaceC2521p, boolean z) {
        p.a(GrpcUtil.f27341e);
        if (interfaceC2521p != InterfaceC2514o.b.f27821a) {
            p.a((P.e<P.e<String>>) GrpcUtil.f27341e, (P.e<String>) interfaceC2521p.a());
        }
        p.a(GrpcUtil.f27342f);
        byte[] a2 = io.grpc.E.a(c2528x);
        if (a2.length != 0) {
            p.a((P.e<P.e<byte[]>>) GrpcUtil.f27342f, (P.e<byte[]>) a2);
        }
        p.a(GrpcUtil.f27343g);
        p.a(GrpcUtil.f27344h);
        if (z) {
            p.a((P.e<P.e<byte[]>>) GrpcUtil.f27344h, (P.e<byte[]>) f27520b);
        }
    }

    @Override // io.grpc.AbstractC2408g
    public void a(AbstractC2408g.a<RespT> aVar, io.grpc.P p) {
        InterfaceC2521p interfaceC2521p;
        boolean z = false;
        Preconditions.b(this.k == null, "Already started");
        Preconditions.b(!this.m, "call was cancelled");
        Preconditions.a(aVar, "observer");
        Preconditions.a(p, "headers");
        if (this.f27524f.v()) {
            this.k = Tb.f27506a;
            this.f27522d.execute(new P(this, aVar));
            return;
        }
        String b2 = this.i.b();
        if (b2 != null) {
            interfaceC2521p = this.t.a(b2);
            if (interfaceC2521p == null) {
                this.k = Tb.f27506a;
                this.f27522d.execute(new Q(this, aVar, b2));
                return;
            }
        } else {
            interfaceC2521p = InterfaceC2514o.b.f27821a;
        }
        a(p, this.s, interfaceC2521p, this.r);
        C2526v b3 = b();
        if (b3 != null && b3.a()) {
            z = true;
        }
        if (!z) {
            a(b3, this.i.d(), this.f27524f.u(), p);
            if (this.j) {
                this.k = this.o.a(this.f27521c, this.i, p, this.f27524f);
            } else {
                Y a2 = this.o.a(new Yb(this.f27521c, p, this.i));
                Context b4 = this.f27524f.b();
                try {
                    this.k = a2.a(this.f27521c, p, this.i);
                } finally {
                    this.f27524f.b(b4);
                }
            }
        } else {
            this.k = new Ja(Status.f27133f.b("deadline exceeded: " + b3));
        }
        if (this.i.a() != null) {
            this.k.a(this.i.a());
        }
        if (this.i.f() != null) {
            this.k.b(this.i.f().intValue());
        }
        if (this.i.g() != null) {
            this.k.c(this.i.g().intValue());
        }
        this.k.a(interfaceC2521p);
        this.k.a(this.r);
        this.k.a(this.s);
        this.f27523e.b();
        this.k.a(new a(aVar));
        this.f27524f.a(this.p, MoreExecutors.a());
        if (b3 != null && this.f27524f.u() != b3 && this.q != null) {
            this.f27525g = a(b3);
        }
        if (this.l) {
            c();
        }
    }

    private static void a(@Nullable C2526v c2526v, @Nullable C2526v c2526v2, @Nullable C2526v c2526v3, io.grpc.P p) {
        p.a(GrpcUtil.f27340d);
        if (c2526v == null) {
            return;
        }
        long max = Math.max(0L, c2526v.a(TimeUnit.NANOSECONDS));
        p.a((P.e<P.e<Long>>) GrpcUtil.f27340d, (P.e<Long>) Long.valueOf(max));
        a(max, c2526v, c2526v3, c2526v2);
    }

    private static void a(long j, C2526v c2526v, @Nullable C2526v c2526v2, @Nullable C2526v c2526v3) {
        if (f27519a.isLoggable(Level.FINE) && c2526v2 == c2526v) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("Call timeout set to '%d' ns, due to context deadline.", Long.valueOf(j)));
            if (c2526v3 == null) {
                sb.append(" Explicit call timeout was not set.");
            } else {
                sb.append(String.format(" Explicit call timeout was '%d' ns.", Long.valueOf(c2526v3.a(TimeUnit.NANOSECONDS))));
            }
            f27519a.fine(sb.toString());
        }
    }

    private ScheduledFuture<?> a(C2526v c2526v) {
        long a2 = c2526v.a(TimeUnit.NANOSECONDS);
        return this.q.schedule(new RunnableC2488tb(new d(a2)), a2, TimeUnit.NANOSECONDS);
    }

    @Nullable
    private static C2526v a(@Nullable C2526v c2526v, @Nullable C2526v c2526v2) {
        return c2526v == null ? c2526v2 : c2526v2 == null ? c2526v : c2526v.c(c2526v2);
    }

    @Override // io.grpc.AbstractC2408g
    public void a(int i) {
        Preconditions.b(this.k != null, "Not started");
        Preconditions.a(i >= 0, "Number requested must be non-negative");
        this.k.a(i);
    }

    @Override // io.grpc.AbstractC2408g
    public void a(@Nullable String str, @Nullable Throwable th) {
        Status b2;
        if (str == null && th == null) {
            th = new CancellationException("Cancelled without a message or cause");
            f27519a.log(Level.WARNING, "Cancelling without a message or cause is suboptimal", th);
        }
        if (this.m) {
            return;
        }
        this.m = true;
        try {
            if (this.k != null) {
                Status status = Status.f27130c;
                if (str != null) {
                    b2 = status.b(str);
                } else {
                    b2 = status.b("Call cancelled without message");
                }
                if (th != null) {
                    b2 = b2.b(th);
                }
                this.k.a(b2);
            }
        } finally {
            c();
        }
    }

    @Override // io.grpc.AbstractC2408g
    public void a() {
        Preconditions.b(this.k != null, "Not started");
        Preconditions.b(!this.m, "call was cancelled");
        Preconditions.b(!this.n, "call already half-closed");
        this.n = true;
        this.k.a();
    }

    @Override // io.grpc.AbstractC2408g
    public void a(ReqT reqt) {
        Preconditions.b(this.k != null, "Not started");
        Preconditions.b(!this.m, "call was cancelled");
        Preconditions.b(!this.n, "call was half-closed");
        try {
            if (this.k instanceof wc) {
                ((wc) this.k).a((wc) reqt);
            } else {
                this.k.a(this.f27521c.a((MethodDescriptor<ReqT, RespT>) reqt));
            }
            if (this.f27526h) {
                return;
            }
            this.k.flush();
        } catch (Error e2) {
            this.k.a(Status.f27130c.b("Client sendMessage() failed with Error"));
            throw e2;
        } catch (RuntimeException e3) {
            this.k.a(Status.f27130c.b(e3).b("Failed to stream message"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbstractC2408g.a<RespT> aVar, Status status, io.grpc.P p) {
        aVar.a(status, p);
    }
}
