package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.AbstractC2407f;
import io.grpc.AbstractC2408g;
import io.grpc.AbstractC2513n;
import io.grpc.C2406e;
import io.grpc.InterfaceC2409h;
import io.grpc.MethodDescriptor;
import io.grpc.P;
import io.grpc.Status;
import io.grpc.aa;
import io.opencensus.trace.NetworkEvent;
import io.opencensus.trace.Span;
import io.opencensus.trace.g;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CensusTracingModule.java */
/* loaded from: classes3.dex */
public final class J {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f27369a = Logger.getLogger(J.class.getName());

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private static final AtomicIntegerFieldUpdater<a> f27370b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private static final AtomicIntegerFieldUpdater<c> f27371c;

    /* renamed from: d, reason: collision with root package name */
    private final io.opencensus.trace.p f27372d;

    /* renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    final P.e<io.opencensus.trace.i> f27373e;

    /* renamed from: f, reason: collision with root package name */
    private final e f27374f = new e();

    /* renamed from: g, reason: collision with root package name */
    private final d f27375g = new d();

    /* compiled from: CensusTracingModule.java */
    /* loaded from: classes3.dex */
    private static final class b extends AbstractC2513n {

        /* renamed from: a, reason: collision with root package name */
        private final Span f27380a;

        b(Span span) {
            Preconditions.a(span, "span");
            this.f27380a = span;
        }

        @Override // io.grpc.ea
        public void a(int i, long j, long j2) {
            J.b(this.f27380a, NetworkEvent.Type.RECV, i, j, j2);
        }

        @Override // io.grpc.ea
        public void b(int i, long j, long j2) {
            J.b(this.f27380a, NetworkEvent.Type.SENT, i, j, j2);
        }
    }

    /* compiled from: CensusTracingModule.java */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    final class d extends aa.a {
        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CensusTracingModule.java */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public final class e implements InterfaceC2409h {
        e() {
        }

        @Override // io.grpc.InterfaceC2409h
        public <ReqT, RespT> AbstractC2408g<ReqT, RespT> a(MethodDescriptor<ReqT, RespT> methodDescriptor, C2406e c2406e, AbstractC2407f abstractC2407f) {
            a a2 = J.this.a(io.opencensus.trace.b.a.f28061a.a(), (MethodDescriptor<?, ?>) methodDescriptor);
            return new L(this, abstractC2407f.a(methodDescriptor, c2406e.a(a2)), a2);
        }
    }

    static {
        AtomicIntegerFieldUpdater<c> atomicIntegerFieldUpdater;
        AtomicIntegerFieldUpdater<a> atomicIntegerFieldUpdater2 = null;
        try {
            AtomicIntegerFieldUpdater<a> newUpdater = AtomicIntegerFieldUpdater.newUpdater(a.class, com.umeng.commonsdk.proguard.e.al);
            atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(c.class, "c");
            atomicIntegerFieldUpdater2 = newUpdater;
        } catch (Throwable th) {
            f27369a.log(Level.SEVERE, "Creating atomic field updaters failed", th);
            atomicIntegerFieldUpdater = null;
        }
        f27370b = atomicIntegerFieldUpdater2;
        f27371c = atomicIntegerFieldUpdater;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(io.opencensus.trace.p pVar, io.opencensus.trace.propagation.b bVar) {
        Preconditions.a(pVar, "censusTracer");
        this.f27372d = pVar;
        Preconditions.a(bVar, "censusPropagationBinaryFormat");
        this.f27373e = P.e.a("grpc-trace-bin", new H(this, bVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InterfaceC2409h d() {
        return this.f27374f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static io.opencensus.trace.g b(Status status, boolean z) {
        g.a a2 = io.opencensus.trace.g.a();
        a2.a(a(status));
        a2.a(z);
        return a2.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CensusTracingModule.java */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public final class a extends AbstractC2513n.a {

        /* renamed from: a, reason: collision with root package name */
        volatile int f27376a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f27377b;

        /* renamed from: c, reason: collision with root package name */
        private final Span f27378c;

        a(@Nullable Span span, MethodDescriptor<?, ?> methodDescriptor) {
            Preconditions.a(methodDescriptor, "method");
            this.f27377b = methodDescriptor.f();
            io.opencensus.trace.h a2 = J.this.f27372d.a(J.a(false, methodDescriptor.a()), span);
            a2.a(true);
            this.f27378c = a2.a();
        }

        @Override // io.grpc.AbstractC2513n.a
        public AbstractC2513n a(C2406e c2406e, io.grpc.P p) {
            p.a(J.this.f27373e);
            p.a((P.e<P.e<io.opencensus.trace.i>>) J.this.f27373e, (P.e<io.opencensus.trace.i>) this.f27378c.a());
            return new b(this.f27378c);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Status status) {
            if (J.f27370b != null) {
                if (J.f27370b.getAndSet(this, 1) != 0) {
                    return;
                }
            } else if (this.f27376a != 0) {
                return;
            } else {
                this.f27376a = 1;
            }
            this.f27378c.a(J.b(status, this.f27377b));
        }
    }

    /* compiled from: CensusTracingModule.java */
    /* loaded from: classes3.dex */
    private final class c extends io.grpc.aa {

        /* renamed from: a, reason: collision with root package name */
        private final Span f27381a;

        /* renamed from: b, reason: collision with root package name */
        volatile boolean f27382b;

        /* renamed from: c, reason: collision with root package name */
        volatile int f27383c;

        @Override // io.grpc.ea
        public void a(Status status) {
            if (J.f27371c != null) {
                if (J.f27371c.getAndSet(this, 1) != 0) {
                    return;
                }
            } else if (this.f27383c != 0) {
                return;
            } else {
                this.f27383c = 1;
            }
            this.f27381a.a(J.b(status, this.f27382b));
        }

        @Override // io.grpc.ea
        public void b(int i, long j, long j2) {
            J.b(this.f27381a, NetworkEvent.Type.SENT, i, j, j2);
        }

        @Override // io.grpc.ea
        public void a(int i, long j, long j2) {
            J.b(this.f27381a, NetworkEvent.Type.RECV, i, j, j2);
        }
    }

    @VisibleForTesting
    a a(@Nullable Span span, MethodDescriptor<?, ?> methodDescriptor) {
        return new a(span, methodDescriptor);
    }

    @VisibleForTesting
    static io.opencensus.trace.Status a(Status status) {
        io.opencensus.trace.Status status2;
        switch (I.f27359a[status.e().ordinal()]) {
            case 1:
                status2 = io.opencensus.trace.Status.f28045b;
                break;
            case 2:
                status2 = io.opencensus.trace.Status.f28046c;
                break;
            case 3:
                status2 = io.opencensus.trace.Status.f28047d;
                break;
            case 4:
                status2 = io.opencensus.trace.Status.f28048e;
                break;
            case 5:
                status2 = io.opencensus.trace.Status.f28049f;
                break;
            case 6:
                status2 = io.opencensus.trace.Status.f28050g;
                break;
            case 7:
                status2 = io.opencensus.trace.Status.f28051h;
                break;
            case 8:
                status2 = io.opencensus.trace.Status.i;
                break;
            case 9:
                status2 = io.opencensus.trace.Status.k;
                break;
            case 10:
                status2 = io.opencensus.trace.Status.l;
                break;
            case 11:
                status2 = io.opencensus.trace.Status.m;
                break;
            case 12:
                status2 = io.opencensus.trace.Status.n;
                break;
            case 13:
                status2 = io.opencensus.trace.Status.o;
                break;
            case 14:
                status2 = io.opencensus.trace.Status.p;
                break;
            case 15:
                status2 = io.opencensus.trace.Status.q;
                break;
            case 16:
                status2 = io.opencensus.trace.Status.r;
                break;
            case 17:
                status2 = io.opencensus.trace.Status.j;
                break;
            default:
                throw new AssertionError("Unhandled status code " + status.e());
        }
        return status.f() != null ? status2.a(status.f()) : status2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Span span, NetworkEvent.Type type, int i, long j, long j2) {
        NetworkEvent.a a2 = NetworkEvent.a(type, i);
        if (j2 != -1) {
            a2.c(j2);
        }
        if (j != -1) {
            a2.a(j);
        }
        span.a(a2.a());
    }

    @VisibleForTesting
    static String a(boolean z, String str) {
        return (z ? "Recv" : "Sent") + "." + str.replace('/', '.');
    }
}
