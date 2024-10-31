package io.grpc.okhttp;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.squareup.okhttp.CipherSuite;
import com.squareup.okhttp.TlsVersion;
import com.squareup.okhttp.q;
import io.grpc.C2403b;
import io.grpc.S;
import io.grpc.internal.AbstractC2419c;
import io.grpc.internal.C2422cc;
import io.grpc.internal.C2471p;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.InterfaceC2424da;
import io.grpc.internal.Kc;
import io.grpc.internal.Rc;
import io.grpc.internal.Z;
import io.grpc.okhttp.internal.Platform;
import io.grpc.okhttp.internal.b;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

/* compiled from: OkHttpChannelBuilder.java */
/* loaded from: classes3.dex */
public class q extends AbstractC2419c<q> {

    @Deprecated
    public static final com.squareup.okhttp.q H;

    @VisibleForTesting
    static final io.grpc.okhttp.internal.b I;
    private static final long J;
    private static final Kc.b<ExecutorService> K;
    private Executor L;
    private ScheduledExecutorService M;
    private SSLSocketFactory N;
    private HostnameVerifier O;
    private io.grpc.okhttp.internal.b P;
    private NegotiationType Q;
    private long R;
    private long S;
    private boolean T;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OkHttpChannelBuilder.java */
    /* loaded from: classes3.dex */
    public static final class a implements Z {

        /* renamed from: a, reason: collision with root package name */
        private final Executor f27984a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f27985b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f27986c;

        /* renamed from: d, reason: collision with root package name */
        private final Rc.a f27987d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        private final SSLSocketFactory f27988e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        private final HostnameVerifier f27989f;

        /* renamed from: g, reason: collision with root package name */
        private final io.grpc.okhttp.internal.b f27990g;

        /* renamed from: h, reason: collision with root package name */
        private final int f27991h;
        private final boolean i;
        private final C2471p j;
        private final long k;
        private final boolean l;
        private final ScheduledExecutorService m;
        private boolean n;

        /* synthetic */ a(Executor executor, ScheduledExecutorService scheduledExecutorService, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, io.grpc.okhttp.internal.b bVar, int i, boolean z, long j, long j2, boolean z2, Rc.a aVar, n nVar) {
            this(executor, scheduledExecutorService, sSLSocketFactory, hostnameVerifier, bVar, i, z, j, j2, z2, aVar);
        }

        @Override // io.grpc.internal.Z
        public ScheduledExecutorService I() {
            return this.m;
        }

        @Override // io.grpc.internal.Z
        public InterfaceC2424da a(SocketAddress socketAddress, String str, @Nullable String str2, @Nullable C2422cc c2422cc) {
            if (!this.n) {
                C2471p.a b2 = this.j.b();
                w wVar = new w((InetSocketAddress) socketAddress, str, str2, this.f27984a, this.f27988e, this.f27989f, this.f27990g, this.f27991h, c2422cc, new p(this, b2), this.f27987d.a());
                if (this.i) {
                    wVar.a(true, b2.b(), this.k, this.l);
                }
                return wVar;
            }
            throw new IllegalStateException("The transport factory is closed.");
        }

        @Override // io.grpc.internal.Z, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.n) {
                return;
            }
            this.n = true;
            if (this.f27986c) {
                Kc.a(GrpcUtil.t, this.m);
            }
            if (this.f27985b) {
                Kc.a((Kc.b<ExecutorService>) q.K, (ExecutorService) this.f27984a);
            }
        }

        private a(Executor executor, @Nullable ScheduledExecutorService scheduledExecutorService, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, io.grpc.okhttp.internal.b bVar, int i, boolean z, long j, long j2, boolean z2, Rc.a aVar) {
            this.f27986c = scheduledExecutorService == null;
            this.m = this.f27986c ? (ScheduledExecutorService) Kc.a(GrpcUtil.t) : scheduledExecutorService;
            this.f27988e = sSLSocketFactory;
            this.f27989f = hostnameVerifier;
            this.f27990g = bVar;
            this.f27991h = i;
            this.i = z;
            this.j = new C2471p("keepalive time nanos", j);
            this.k = j2;
            this.l = z2;
            this.f27985b = executor == null;
            Preconditions.a(aVar, "transportTracerFactory");
            this.f27987d = aVar;
            if (this.f27985b) {
                this.f27984a = (Executor) Kc.a(q.K);
            } else {
                this.f27984a = executor;
            }
        }
    }

    static {
        q.a aVar = new q.a(com.squareup.okhttp.q.f25519b);
        aVar.a(CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384);
        aVar.a(TlsVersion.TLS_1_2);
        aVar.a(true);
        H = aVar.a();
        b.a aVar2 = new b.a(io.grpc.okhttp.internal.b.f27885b);
        aVar2.a(io.grpc.okhttp.internal.CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, io.grpc.okhttp.internal.CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, io.grpc.okhttp.internal.CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, io.grpc.okhttp.internal.CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, io.grpc.okhttp.internal.CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, io.grpc.okhttp.internal.CipherSuite.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256, io.grpc.okhttp.internal.CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384, io.grpc.okhttp.internal.CipherSuite.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384);
        aVar2.a(io.grpc.okhttp.internal.TlsVersion.TLS_1_2);
        aVar2.a(true);
        I = aVar2.a();
        J = TimeUnit.DAYS.toNanos(1000L);
        K = new n();
    }

    private q(String str) {
        super(str);
        this.P = I;
        this.Q = NegotiationType.TLS;
        this.R = Long.MAX_VALUE;
        this.S = GrpcUtil.n;
    }

    public static q a(String str) {
        return new q(str);
    }

    @Override // io.grpc.internal.AbstractC2419c
    protected final Z b() {
        return new a(this.L, this.M, h(), this.O, this.P, f(), this.R != Long.MAX_VALUE, this.R, this.S, this.T, this.z, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.internal.AbstractC2419c
    public C2403b e() {
        int i;
        int i2 = o.f27981a[this.Q.ordinal()];
        if (i2 == 1) {
            i = 80;
        } else {
            if (i2 != 2) {
                throw new AssertionError(this.Q + " not handled");
            }
            i = 443;
        }
        C2403b.a b2 = C2403b.b();
        b2.a(S.a.f27127a, Integer.valueOf(i));
        return b2.a();
    }

    @VisibleForTesting
    @Nullable
    SSLSocketFactory h() {
        SSLContext sSLContext;
        int i = o.f27981a[this.Q.ordinal()];
        if (i == 1) {
            return null;
        }
        if (i == 2) {
            try {
                if (this.N == null) {
                    if (GrpcUtil.f27339c) {
                        sSLContext = SSLContext.getInstance("TLS", Platform.a().b());
                        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                        trustManagerFactory.init((KeyStore) null);
                        sSLContext.init(null, trustManagerFactory.getTrustManagers(), SecureRandom.getInstance("SHA1PRNG", Platform.a().b()));
                    } else {
                        sSLContext = SSLContext.getInstance("Default", Platform.a().b());
                    }
                    this.N = sSLContext.getSocketFactory();
                }
                return this.N;
            } catch (GeneralSecurityException e2) {
                throw new RuntimeException("TLS Provider failure", e2);
            }
        }
        throw new RuntimeException("Unknown negotiation type: " + this.Q);
    }
}
