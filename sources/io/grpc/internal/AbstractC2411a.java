package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.C2528x;
import io.grpc.InterfaceC2521p;
import io.grpc.Status;
import io.grpc.internal.AbstractC2427e;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.Qb;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: AbstractClientStream.java */
/* renamed from: io.grpc.internal.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2411a extends AbstractC2427e implements X, Qb.c {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f27543a = Logger.getLogger(AbstractC2411a.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private final Rc f27544b;

    /* renamed from: c, reason: collision with root package name */
    private final Ra f27545c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f27546d;

    /* renamed from: e, reason: collision with root package name */
    private io.grpc.P f27547e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f27548f;

    /* compiled from: AbstractClientStream.java */
    /* renamed from: io.grpc.internal.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0157a implements Ra {

        /* renamed from: a, reason: collision with root package name */
        private io.grpc.P f27549a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f27550b;

        /* renamed from: c, reason: collision with root package name */
        private final Mc f27551c;

        /* renamed from: d, reason: collision with root package name */
        private byte[] f27552d;

        public C0157a(io.grpc.P p, Mc mc) {
            Preconditions.a(p, "headers");
            this.f27549a = p;
            Preconditions.a(mc, "statsTraceCtx");
            this.f27551c = mc;
        }

        @Override // io.grpc.internal.Ra
        public Ra a(InterfaceC2521p interfaceC2521p) {
            return this;
        }

        @Override // io.grpc.internal.Ra
        public void a(InputStream inputStream) {
            Preconditions.b(this.f27552d == null, "writePayload should not be called multiple times");
            try {
                this.f27552d = C2465nb.a(inputStream);
                this.f27551c.b(0);
                Mc mc = this.f27551c;
                byte[] bArr = this.f27552d;
                mc.b(0, bArr.length, bArr.length);
                this.f27551c.c(this.f27552d.length);
                this.f27551c.d(this.f27552d.length);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // io.grpc.internal.Ra
        public void c(int i) {
        }

        @Override // io.grpc.internal.Ra
        public void close() {
            this.f27550b = true;
            Preconditions.b(this.f27552d != null, "Lack of request message. GET request is only supported for unary requests");
            AbstractC2411a.this.e().a(this.f27549a, this.f27552d);
            this.f27552d = null;
            this.f27549a = null;
        }

        @Override // io.grpc.internal.Ra
        public void flush() {
        }

        @Override // io.grpc.internal.Ra
        public boolean isClosed() {
            return this.f27550b;
        }
    }

    /* compiled from: AbstractClientStream.java */
    /* renamed from: io.grpc.internal.a$b */
    /* loaded from: classes3.dex */
    protected interface b {
        void a(int i);

        void a(io.grpc.P p, @Nullable byte[] bArr);

        void a(Status status);

        void a(@Nullable Tc tc, boolean z, boolean z2, int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: AbstractClientStream.java */
    /* renamed from: io.grpc.internal.a$c */
    /* loaded from: classes3.dex */
    public static abstract class c extends AbstractC2427e.a {

        /* renamed from: h, reason: collision with root package name */
        private final Mc f27554h;
        private boolean i;
        private ClientStreamListener j;
        private boolean k;
        private C2528x l;
        private boolean m;
        private Runnable n;
        private volatile boolean o;
        private boolean p;

        /* JADX INFO: Access modifiers changed from: protected */
        public c(int i, Mc mc, Rc rc) {
            super(i, mc, rc);
            this.l = C2528x.c();
            this.m = false;
            Preconditions.a(mc, "statsTraceCtx");
            this.f27554h = mc;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(boolean z) {
            this.k = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void g() {
            this.o = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final boolean e() {
            return this.o;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.internal.AbstractC2427e.a
        public final ClientStreamListener b() {
            return this.j;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void b(InterfaceC2426dc interfaceC2426dc) {
            Preconditions.a(interfaceC2426dc, "frame");
            try {
                if (this.p) {
                    AbstractC2411a.f27543a.log(Level.INFO, "Received data on closed stream");
                    interfaceC2426dc.close();
                } else {
                    a(interfaceC2426dc);
                }
            } catch (Throwable th) {
                if (1 != 0) {
                    interfaceC2426dc.close();
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(C2528x c2528x) {
            Preconditions.b(this.j == null, "Already called start");
            Preconditions.a(c2528x, "decompressorRegistry");
            this.l = c2528x;
        }

        @VisibleForTesting
        public final void a(ClientStreamListener clientStreamListener) {
            Preconditions.b(this.j == null, "Already called setListener");
            Preconditions.a(clientStreamListener, "listener");
            this.j = clientStreamListener;
        }

        public void a(boolean z) {
            this.m = true;
            Runnable runnable = this.n;
            if (runnable != null) {
                runnable.run();
                this.n = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:9:0x005a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(io.grpc.P r6) {
            /*
                r5 = this;
                boolean r0 = r5.p
                r1 = 1
                r0 = r0 ^ r1
                java.lang.String r2 = "Received headers on closed stream"
                com.google.common.base.Preconditions.b(r0, r2)
                io.grpc.internal.Mc r0 = r5.f27554h
                r0.a()
                io.grpc.P$e<java.lang.String> r0 = io.grpc.internal.GrpcUtil.f27343g
                java.lang.Object r0 = r6.b(r0)
                java.lang.String r0 = (java.lang.String) r0
                boolean r2 = r5.k
                r3 = 0
                if (r2 == 0) goto L4f
                if (r0 == 0) goto L4f
                java.lang.String r2 = "gzip"
                boolean r2 = r0.equalsIgnoreCase(r2)
                if (r2 == 0) goto L2f
                io.grpc.internal.GzipInflatingBuffer r0 = new io.grpc.internal.GzipInflatingBuffer
                r0.<init>()
                r5.a(r0)
                r0 = 1
                goto L50
            L2f:
                java.lang.String r2 = "identity"
                boolean r2 = r0.equalsIgnoreCase(r2)
                if (r2 != 0) goto L4f
                io.grpc.Status r6 = io.grpc.Status.p
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r1[r3] = r0
                java.lang.String r0 = "Can't find full stream decompressor for %s"
                java.lang.String r0 = java.lang.String.format(r0, r1)
                io.grpc.Status r6 = r6.b(r0)
                io.grpc.StatusRuntimeException r6 = r6.c()
                r5.a(r6)
                return
            L4f:
                r0 = 0
            L50:
                io.grpc.P$e<java.lang.String> r2 = io.grpc.internal.GrpcUtil.f27341e
                java.lang.Object r2 = r6.b(r2)
                java.lang.String r2 = (java.lang.String) r2
                if (r2 == 0) goto L99
                io.grpc.x r4 = r5.l
                io.grpc.w r4 = r4.a(r2)
                if (r4 != 0) goto L7a
                io.grpc.Status r6 = io.grpc.Status.p
                java.lang.Object[] r0 = new java.lang.Object[r1]
                r0[r3] = r2
                java.lang.String r1 = "Can't find decompressor for %s"
                java.lang.String r0 = java.lang.String.format(r1, r0)
                io.grpc.Status r6 = r6.b(r0)
                io.grpc.StatusRuntimeException r6 = r6.c()
                r5.a(r6)
                return
            L7a:
                io.grpc.o r1 = io.grpc.InterfaceC2514o.b.f27821a
                if (r4 == r1) goto L99
                if (r0 == 0) goto L96
                io.grpc.Status r6 = io.grpc.Status.p
                java.lang.Object[] r0 = new java.lang.Object[r3]
                java.lang.String r1 = "Full stream and gRPC message encoding cannot both be set"
                java.lang.String r0 = java.lang.String.format(r1, r0)
                io.grpc.Status r6 = r6.b(r0)
                io.grpc.StatusRuntimeException r6 = r6.c()
                r5.a(r6)
                return
            L96:
                r5.a(r4)
            L99:
                io.grpc.internal.ClientStreamListener r0 = r5.b()
                r0.a(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.AbstractC2411a.c.a(io.grpc.P):void");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void a(io.grpc.P p, Status status) {
            Preconditions.a(status, "status");
            Preconditions.a(p, "trailers");
            if (this.p) {
                AbstractC2411a.f27543a.log(Level.INFO, "Received trailers on closed stream:\n {1}\n {2}", new Object[]{status, p});
            } else {
                a(status, false, p);
            }
        }

        public final void a(Status status, boolean z, io.grpc.P p) {
            a(status, ClientStreamListener.RpcProgress.PROCESSED, z, p);
        }

        public final void a(Status status, ClientStreamListener.RpcProgress rpcProgress, boolean z, io.grpc.P p) {
            Preconditions.a(status, "status");
            Preconditions.a(p, "trailers");
            if (!this.p || z) {
                this.p = true;
                d();
                if (this.m) {
                    this.n = null;
                    a(status, rpcProgress, p);
                } else {
                    this.n = new RunnableC2415b(this, status, rpcProgress, p);
                    b(z);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Status status, ClientStreamListener.RpcProgress rpcProgress, io.grpc.P p) {
            if (this.i) {
                return;
            }
            this.i = true;
            this.f27554h.a(status);
            b().a(status, rpcProgress, p);
            if (a() != null) {
                a().a(status.g());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC2411a(Uc uc, Mc mc, Rc rc, io.grpc.P p, boolean z) {
        Preconditions.a(p, "headers");
        Preconditions.a(rc, "transportTracer");
        this.f27544b = rc;
        this.f27546d = z;
        if (!z) {
            this.f27545c = new Qb(this, uc, mc);
            this.f27547e = p;
        } else {
            this.f27545c = new C0157a(p, mc);
        }
    }

    @Override // io.grpc.internal.X
    public final void a(boolean z) {
        d().c(z);
    }

    @Override // io.grpc.internal.X
    public void b(int i) {
        d().d(i);
    }

    @Override // io.grpc.internal.X
    public void c(int i) {
        this.f27545c.c(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.internal.AbstractC2427e
    public abstract c d();

    protected abstract b e();

    /* JADX INFO: Access modifiers changed from: protected */
    public Rc g() {
        return this.f27544b;
    }

    @Override // io.grpc.internal.X
    public final void a(C2528x c2528x) {
        d().a(c2528x);
    }

    @Override // io.grpc.internal.AbstractC2427e
    protected final Ra c() {
        return this.f27545c;
    }

    @Override // io.grpc.internal.X
    public final void a(ClientStreamListener clientStreamListener) {
        d().a(clientStreamListener);
        if (this.f27546d) {
            return;
        }
        e().a(this.f27547e, null);
        this.f27547e = null;
    }

    @Override // io.grpc.internal.Nc
    public final void a(int i) {
        e().a(i);
    }

    @Override // io.grpc.internal.Qb.c
    public final void a(Tc tc, boolean z, boolean z2, int i) {
        Preconditions.a(tc != null || z, "null frame before EOS");
        e().a(tc, z, z2, i);
    }

    @Override // io.grpc.internal.X
    public final void a() {
        if (d().e()) {
            return;
        }
        d().g();
        b();
    }

    @Override // io.grpc.internal.X
    public final void a(Status status) {
        Preconditions.a(!status.g(), "Should not cancel with OK status");
        this.f27548f = true;
        e().a(status);
    }
}
