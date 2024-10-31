package io.grpc.okhttp;

import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.widget.ActivityChooserView;
import com.facebook.internal.AnalyticsEvents;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.SettableFuture;
import com.squareup.okhttp.E;
import com.squareup.okhttp.HttpUrl;
import io.grpc.C2403b;
import io.grpc.C2406e;
import io.grpc.MethodDescriptor;
import io.grpc.P;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.internal.C2421cb;
import io.grpc.internal.C2422cc;
import io.grpc.internal.C2492ub;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.Dc;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.InterfaceC2424da;
import io.grpc.internal.Kc;
import io.grpc.internal.KeepAliveManager;
import io.grpc.internal.Mc;
import io.grpc.internal.Nb;
import io.grpc.internal.Rc;
import io.grpc.internal.X;
import io.grpc.internal.Y;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.HeadersMode;
import io.grpc.okhttp.internal.framed.a;
import io.grpc.okhttp.s;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okio.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OkHttpClientTransport.java */
/* loaded from: classes3.dex */
public class w implements InterfaceC2424da {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<ErrorCode, Status> f28001a = f();

    /* renamed from: b, reason: collision with root package name */
    private static final Logger f28002b = Logger.getLogger(w.class.getName());

    /* renamed from: c, reason: collision with root package name */
    private static final s[] f28003c = new s[0];
    private boolean A;
    private SSLSocketFactory B;
    private HostnameVerifier C;
    private Socket D;
    private final io.grpc.okhttp.internal.b G;
    private io.grpc.okhttp.internal.framed.b H;
    private ScheduledExecutorService I;
    private KeepAliveManager J;
    private boolean K;
    private long L;
    private long M;
    private boolean N;
    private final Runnable O;
    private final Rc P;

    @VisibleForTesting
    @Nullable
    final C2422cc Q;
    Runnable R;
    SettableFuture<Void> S;

    /* renamed from: d, reason: collision with root package name */
    private final InetSocketAddress f28004d;

    /* renamed from: e, reason: collision with root package name */
    private final String f28005e;

    /* renamed from: f, reason: collision with root package name */
    private final String f28006f;

    /* renamed from: h, reason: collision with root package name */
    private final Supplier<Stopwatch> f28008h;
    private Nb.a i;
    private io.grpc.okhttp.internal.framed.a j;
    private l k;
    private E l;
    private int o;
    private final Executor q;
    private final Dc r;
    private final int s;
    private int t;
    private a u;
    private Status w;
    private boolean x;
    private C2421cb y;
    private boolean z;

    /* renamed from: g, reason: collision with root package name */
    private final Random f28007g = new Random();
    private final Object m = new Object();
    private final C2492ub n = C2492ub.a(w.class.getName());
    private final Map<Integer, s> p = new HashMap();
    private C2403b v = C2403b.f27155a;
    private int E = 0;
    private LinkedList<s> F = new LinkedList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(InetSocketAddress inetSocketAddress, String str, @Nullable String str2, Executor executor, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, io.grpc.okhttp.internal.b bVar, int i, @Nullable C2422cc c2422cc, Runnable runnable, Rc rc) {
        Preconditions.a(inetSocketAddress, "address");
        this.f28004d = inetSocketAddress;
        this.f28005e = str;
        this.s = i;
        Preconditions.a(executor, "executor");
        this.q = executor;
        this.r = new Dc(executor);
        this.o = 3;
        this.B = sSLSocketFactory;
        this.C = hostnameVerifier;
        Preconditions.a(bVar, "connectionSpec");
        this.G = bVar;
        this.f28008h = GrpcUtil.u;
        this.f28006f = GrpcUtil.a("okhttp", str2);
        this.Q = c2422cc;
        Preconditions.a(runnable, "tooManyPingsRunnable");
        this.O = runnable;
        Preconditions.a(rc);
        this.P = rc;
        h();
    }

    @Override // io.grpc.internal.InterfaceC2424da
    public C2403b getAttributes() {
        return this.v;
    }

    public String toString() {
        return a() + "(" + this.f28004d + ")";
    }

    private static Map<ErrorCode, Status> f() {
        EnumMap enumMap = new EnumMap(ErrorCode.class);
        enumMap.put((EnumMap) ErrorCode.NO_ERROR, (ErrorCode) Status.p.b("No error: A GRPC status of OK should have been sent"));
        enumMap.put((EnumMap) ErrorCode.PROTOCOL_ERROR, (ErrorCode) Status.p.b("Protocol error"));
        enumMap.put((EnumMap) ErrorCode.INTERNAL_ERROR, (ErrorCode) Status.p.b("Internal error"));
        enumMap.put((EnumMap) ErrorCode.FLOW_CONTROL_ERROR, (ErrorCode) Status.p.b("Flow control error"));
        enumMap.put((EnumMap) ErrorCode.STREAM_CLOSED, (ErrorCode) Status.p.b("Stream closed"));
        enumMap.put((EnumMap) ErrorCode.FRAME_TOO_LARGE, (ErrorCode) Status.p.b("Frame too large"));
        enumMap.put((EnumMap) ErrorCode.REFUSED_STREAM, (ErrorCode) Status.q.b("Refused stream"));
        enumMap.put((EnumMap) ErrorCode.CANCEL, (ErrorCode) Status.f27130c.b(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED));
        enumMap.put((EnumMap) ErrorCode.COMPRESSION_ERROR, (ErrorCode) Status.p.b("Compression error"));
        enumMap.put((EnumMap) ErrorCode.CONNECT_ERROR, (ErrorCode) Status.p.b("Connect error"));
        enumMap.put((EnumMap) ErrorCode.ENHANCE_YOUR_CALM, (ErrorCode) Status.k.b("Enhance your calm"));
        enumMap.put((EnumMap) ErrorCode.INADEQUATE_SECURITY, (ErrorCode) Status.i.b("Inadequate security"));
        return Collections.unmodifiableMap(enumMap);
    }

    private Throwable g() {
        synchronized (this.m) {
            if (this.w != null) {
                return this.w.b();
            }
            return Status.q.b("Connection closed").b();
        }
    }

    private void h() {
        synchronized (this.m) {
            this.P.a(new t(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        return this.f28004d == null;
    }

    private void j() {
        if (this.A && this.F.isEmpty() && this.p.isEmpty()) {
            this.A = false;
            this.i.a(false);
            KeepAliveManager keepAliveManager = this.J;
            if (keepAliveManager != null) {
                keepAliveManager.c();
            }
        }
    }

    private void k() {
        if (this.A) {
            return;
        }
        this.A = true;
        this.i.a(true);
        KeepAliveManager keepAliveManager = this.J;
        if (keepAliveManager != null) {
            keepAliveManager.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l() {
        boolean z = false;
        while (!this.F.isEmpty() && this.p.size() < this.E) {
            c(this.F.poll());
            z = true;
        }
        return z;
    }

    private void m() {
        if (this.w == null || !this.p.isEmpty() || !this.F.isEmpty() || this.z) {
            return;
        }
        this.z = true;
        KeepAliveManager keepAliveManager = this.J;
        if (keepAliveManager != null) {
            keepAliveManager.e();
            this.I = (ScheduledExecutorService) Kc.a(GrpcUtil.t, this.I);
        }
        C2421cb c2421cb = this.y;
        if (c2421cb != null) {
            c2421cb.a(g());
            this.y = null;
        }
        if (!this.x) {
            this.x = true;
            this.k.a(0, ErrorCode.NO_ERROR, new byte[0]);
        }
        this.k.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public String d() {
        URI a2 = GrpcUtil.a(this.f28005e);
        if (a2.getHost() != null) {
            return a2.getHost();
        }
        return this.f28005e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public int e() {
        URI a2 = GrpcUtil.a(this.f28005e);
        if (a2.getPort() != -1) {
            return a2.getPort();
        }
        return this.f28004d.getPort();
    }

    static /* synthetic */ int b(w wVar, int i) {
        int i2 = wVar.t + i;
        wVar.t = i2;
        return i2;
    }

    private void c(s sVar) {
        Preconditions.b(sVar.k() == -1, "StreamId already assigned");
        this.p.put(Integer.valueOf(this.o), sVar);
        k();
        sVar.d().e(this.o);
        if ((sVar.j() != MethodDescriptor.MethodType.UNARY && sVar.j() != MethodDescriptor.MethodType.SERVER_STREAMING) || sVar.l()) {
            this.k.flush();
        }
        int i = this.o;
        if (i >= 2147483645) {
            this.o = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            a(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ErrorCode.NO_ERROR, Status.q.b("Stream ids exhausted"));
        } else {
            this.o = i + 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(s sVar) {
        synchronized (this.m) {
            if (this.w != null) {
                sVar.d().a(this.w, true, new P());
            } else if (this.p.size() >= this.E) {
                this.F.add(sVar);
                k();
            } else {
                c(sVar);
            }
        }
    }

    @Override // io.grpc.internal.Y
    public /* bridge */ /* synthetic */ X a(MethodDescriptor methodDescriptor, P p, C2406e c2406e) {
        return a((MethodDescriptor<?, ?>) methodDescriptor, p, c2406e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z, long j, long j2, boolean z2) {
        this.K = z;
        this.L = j;
        this.M = j2;
        this.N = z2;
    }

    @Override // io.grpc.internal.Nb
    public void b(Status status) {
        synchronized (this.m) {
            if (this.w != null) {
                return;
            }
            this.w = status;
            this.i.a(this.w);
            m();
        }
    }

    @Override // io.grpc.internal.Y
    public void a(Y.a aVar, Executor executor) {
        C2421cb c2421cb;
        boolean z = true;
        Preconditions.b(this.k != null);
        long j = 0;
        synchronized (this.m) {
            if (this.z) {
                C2421cb.a(aVar, executor, g());
                return;
            }
            if (this.y != null) {
                c2421cb = this.y;
                z = false;
            } else {
                j = this.f28007g.nextLong();
                Stopwatch stopwatch = this.f28008h.get();
                stopwatch.d();
                c2421cb = new C2421cb(j, stopwatch);
                this.y = c2421cb;
                this.P.b();
            }
            if (z) {
                this.k.a(false, (int) (j >>> 32), (int) j);
            }
            c2421cb.a(aVar, executor);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OkHttpClientTransport.java */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public class a implements a.InterfaceC0159a, Runnable {

        /* renamed from: a, reason: collision with root package name */
        io.grpc.okhttp.internal.framed.a f28009a;

        /* renamed from: b, reason: collision with root package name */
        boolean f28010b = true;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(io.grpc.okhttp.internal.framed.a aVar) {
            this.f28009a = aVar;
        }

        @Override // io.grpc.okhttp.internal.framed.a.InterfaceC0159a
        public void a(int i, int i2, int i3, boolean z) {
        }

        @Override // io.grpc.okhttp.internal.framed.a.InterfaceC0159a
        public void a(boolean z, int i, okio.i iVar, int i2) throws IOException {
            s a2 = w.this.a(i);
            if (a2 == null) {
                if (w.this.b(i)) {
                    w.this.k.a(i, ErrorCode.INVALID_STREAM);
                    iVar.skip(i2);
                } else {
                    w.this.a(ErrorCode.PROTOCOL_ERROR, "Received data for unknown stream: " + i);
                    return;
                }
            } else {
                long j = i2;
                iVar.c(j);
                okio.g gVar = new okio.g();
                gVar.a(iVar.d(), j);
                synchronized (w.this.m) {
                    a2.d().a(gVar, z);
                }
            }
            w.b(w.this, i2);
            if (w.this.t >= 32767) {
                w.this.k.a(0, w.this.t);
                w.this.t = 0;
            }
        }

        @Override // io.grpc.okhttp.internal.framed.a.InterfaceC0159a
        public void b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String name = Thread.currentThread().getName();
            if (!GrpcUtil.f27339c) {
                Thread.currentThread().setName("OkHttpClientTransport");
            }
            while (this.f28009a.a(this)) {
                try {
                    try {
                        if (w.this.J != null) {
                            w.this.J.a();
                        }
                    } catch (Throwable th) {
                        try {
                            this.f28009a.close();
                        } catch (IOException e2) {
                            w.f28002b.log(Level.INFO, "Exception closing frame reader", (Throwable) e2);
                        }
                        w.this.i.b();
                        if (GrpcUtil.f27339c) {
                            throw th;
                        }
                        Thread.currentThread().setName(name);
                        throw th;
                    }
                } catch (Throwable th2) {
                    w.this.a(0, ErrorCode.PROTOCOL_ERROR, Status.q.b("error in frame handler").b(th2));
                    try {
                        this.f28009a.close();
                    } catch (IOException e3) {
                        w.f28002b.log(Level.INFO, "Exception closing frame reader", (Throwable) e3);
                    }
                    w.this.i.b();
                    if (GrpcUtil.f27339c) {
                        return;
                    }
                }
            }
            w.this.a(0, ErrorCode.INTERNAL_ERROR, Status.q.b("End of stream or IOException"));
            try {
                this.f28009a.close();
            } catch (IOException e4) {
                w.f28002b.log(Level.INFO, "Exception closing frame reader", (Throwable) e4);
            }
            w.this.i.b();
            if (GrpcUtil.f27339c) {
                return;
            }
            Thread.currentThread().setName(name);
        }

        @Override // io.grpc.okhttp.internal.framed.a.InterfaceC0159a
        public void a(boolean z, boolean z2, int i, int i2, List<io.grpc.okhttp.internal.framed.c> list, HeadersMode headersMode) {
            boolean z3;
            synchronized (w.this.m) {
                s sVar = (s) w.this.p.get(Integer.valueOf(i));
                if (sVar == null) {
                    if (w.this.b(i)) {
                        w.this.k.a(i, ErrorCode.INVALID_STREAM);
                    } else {
                        z3 = true;
                    }
                } else {
                    sVar.d().a(list, z2);
                }
                z3 = false;
            }
            if (z3) {
                w.this.a(ErrorCode.PROTOCOL_ERROR, "Received header for unknown stream: " + i);
            }
        }

        @Override // io.grpc.okhttp.internal.framed.a.InterfaceC0159a
        public void a(int i, ErrorCode errorCode) {
            Status a2 = w.a(errorCode).a("Rst Stream");
            w.this.a(i, a2, errorCode == ErrorCode.REFUSED_STREAM ? ClientStreamListener.RpcProgress.REFUSED : ClientStreamListener.RpcProgress.PROCESSED, a2.e() == Status.Code.CANCELLED || a2.e() == Status.Code.DEADLINE_EXCEEDED, null, null);
        }

        @Override // io.grpc.okhttp.internal.framed.a.InterfaceC0159a
        public void a(boolean z, io.grpc.okhttp.internal.framed.g gVar) {
            synchronized (w.this.m) {
                if (z.b(gVar, 4)) {
                    w.this.E = z.a(gVar, 4);
                }
                if (z.b(gVar, 7)) {
                    w.this.l.a(z.a(gVar, 7));
                }
                if (this.f28010b) {
                    w.this.i.a();
                    this.f28010b = false;
                }
                w.this.l();
            }
            w.this.k.a(gVar);
        }

        @Override // io.grpc.okhttp.internal.framed.a.InterfaceC0159a
        public void a(boolean z, int i, int i2) {
            C2421cb c2421cb;
            if (!z) {
                w.this.k.a(true, i, i2);
                return;
            }
            long j = (i << 32) | (i2 & 4294967295L);
            synchronized (w.this.m) {
                if (w.this.y == null) {
                    w.f28002b.warning("Received unexpected ping ack. No ping outstanding");
                } else if (w.this.y.b() == j) {
                    c2421cb = w.this.y;
                    w.this.y = null;
                } else {
                    w.f28002b.log(Level.WARNING, String.format("Received unexpected ping ack. Expecting %d, got %d", Long.valueOf(w.this.y.b()), Long.valueOf(j)));
                }
                c2421cb = null;
            }
            if (c2421cb != null) {
                c2421cb.a();
            }
        }

        @Override // io.grpc.okhttp.internal.framed.a.InterfaceC0159a
        public void a(int i, ErrorCode errorCode, ByteString byteString) {
            if (errorCode == ErrorCode.ENHANCE_YOUR_CALM) {
                String utf8 = byteString.utf8();
                w.f28002b.log(Level.WARNING, String.format("%s: Received GOAWAY with ENHANCE_YOUR_CALM. Debug data: %s", this, utf8));
                if ("too_many_pings".equals(utf8)) {
                    w.this.O.run();
                }
            }
            Status a2 = GrpcUtil.Http2Error.statusForCode(errorCode.httpCode).a("Received Goaway");
            if (byteString.size() > 0) {
                a2 = a2.a(byteString.utf8());
            }
            w.this.a(i, (ErrorCode) null, a2);
        }

        @Override // io.grpc.okhttp.internal.framed.a.InterfaceC0159a
        public void a(int i, int i2, List<io.grpc.okhttp.internal.framed.c> list) throws IOException {
            w.this.k.a(i, ErrorCode.PROTOCOL_ERROR);
        }

        @Override // io.grpc.okhttp.internal.framed.a.InterfaceC0159a
        public void a(int i, long j) {
            if (j == 0) {
                if (i == 0) {
                    w.this.a(ErrorCode.PROTOCOL_ERROR, "Received 0 flow control window increment.");
                    return;
                } else {
                    w.this.a(i, Status.p.b("Received 0 flow control window increment."), ClientStreamListener.RpcProgress.PROCESSED, false, ErrorCode.PROTOCOL_ERROR, null);
                    return;
                }
            }
            boolean z = false;
            synchronized (w.this.m) {
                if (i == 0) {
                    w.this.l.a(null, (int) j);
                    return;
                }
                s sVar = (s) w.this.p.get(Integer.valueOf(i));
                if (sVar != null) {
                    w.this.l.a(sVar, (int) j);
                } else if (!w.this.b(i)) {
                    z = true;
                }
                if (z) {
                    w.this.a(ErrorCode.PROTOCOL_ERROR, "Received window_update for unknown stream: " + i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s[] c() {
        s[] sVarArr;
        synchronized (this.m) {
            sVarArr = (s[]) this.p.values().toArray(f28003c);
        }
        return sVarArr;
    }

    boolean b(int i) {
        boolean z;
        synchronized (this.m) {
            z = true;
            if (i >= this.o || (i & 1) != 1) {
                z = false;
            }
        }
        return z;
    }

    @Override // io.grpc.internal.Y
    public s a(MethodDescriptor<?, ?> methodDescriptor, P p, C2406e c2406e) {
        Preconditions.a(methodDescriptor, "method");
        Preconditions.a(p, "headers");
        return new s(methodDescriptor, p, this.k, this, this.l, this.m, this.s, this.f28005e, this.f28006f, Mc.a(c2406e, p), this.P);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(s sVar) {
        this.F.remove(sVar);
        j();
    }

    @Override // io.grpc.internal.Nb
    public Runnable a(Nb.a aVar) {
        Preconditions.a(aVar, "listener");
        this.i = aVar;
        if (this.K) {
            this.I = (ScheduledExecutorService) Kc.a(GrpcUtil.t);
            this.J = new KeepAliveManager(new KeepAliveManager.a(this), this.I, this.L, this.M, this.N);
            this.J.d();
        }
        this.k = new l(this, this.r);
        this.l = new E(this, this.k);
        this.r.execute(new v(this));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Socket a(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, String str, String str2) throws IOException, StatusException {
        Socket socket;
        try {
            if (inetSocketAddress2.getAddress() != null) {
                socket = new Socket(inetSocketAddress2.getAddress(), inetSocketAddress2.getPort());
            } else {
                socket = new Socket(inetSocketAddress2.getHostName(), inetSocketAddress2.getPort());
            }
            socket.setTcpNoDelay(true);
            okio.z b2 = okio.s.b(socket);
            okio.h a2 = okio.s.a(okio.s.a(socket));
            com.squareup.okhttp.E a3 = a(inetSocketAddress, str, str2);
            HttpUrl d2 = a3.d();
            a2.a(String.format("CONNECT %s:%d HTTP/1.1", d2.g(), Integer.valueOf(d2.j()))).a("\r\n");
            int b3 = a3.c().b();
            for (int i = 0; i < b3; i++) {
                a2.a(a3.c().a(i)).a(": ").a(a3.c().b(i)).a("\r\n");
            }
            a2.a("\r\n");
            a2.flush();
            com.squareup.okhttp.internal.http.v a4 = com.squareup.okhttp.internal.http.v.a(a(b2));
            do {
            } while (!a(b2).equals(""));
            if (a4.f25496b >= 200 && a4.f25496b < 300) {
                return socket;
            }
            okio.g gVar = new okio.g();
            try {
                socket.shutdownOutput();
                b2.b(gVar, PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
            } catch (IOException e2) {
                gVar.a("Unable to read body: " + e2.toString());
            }
            try {
                socket.close();
            } catch (IOException unused) {
            }
            throw Status.q.b(String.format("Response returned from proxy was not successful (expected 2xx, got %d %s). Response body:\n%s", Integer.valueOf(a4.f25496b), a4.f25497c, gVar.s())).b();
        } catch (IOException e3) {
            throw Status.q.b("Failed trying to connect with proxy").b(e3).b();
        }
    }

    private com.squareup.okhttp.E a(InetSocketAddress inetSocketAddress, String str, String str2) {
        HttpUrl.Builder builder = new HttpUrl.Builder();
        builder.c("https");
        builder.b(inetSocketAddress.getHostName());
        builder.a(inetSocketAddress.getPort());
        HttpUrl a2 = builder.a();
        E.a aVar = new E.a();
        aVar.a(a2);
        aVar.b("Host", a2.g() + ":" + a2.j());
        aVar.b(io.fabric.sdk.android.services.common.a.HEADER_USER_AGENT, this.f28006f);
        if (str != null && str2 != null) {
            aVar.b("Proxy-Authorization", com.squareup.okhttp.r.a(str, str2));
        }
        return aVar.a();
    }

    private static String a(okio.z zVar) throws IOException {
        okio.g gVar = new okio.g();
        while (zVar.b(gVar, 1L) != -1) {
            if (gVar.g(gVar.size() - 1) == 10) {
                return gVar.h();
            }
        }
        throw new EOFException("\\n not found: " + gVar.q().hex());
    }

    @Override // io.grpc.internal.Sc
    public C2492ub a() {
        return this.n;
    }

    @Override // io.grpc.internal.Nb
    public void a(Status status) {
        b(status);
        synchronized (this.m) {
            Iterator<Map.Entry<Integer, s>> it = this.p.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, s> next = it.next();
                it.remove();
                next.getValue().d().a(status, false, new P());
            }
            Iterator<s> it2 = this.F.iterator();
            while (it2.hasNext()) {
                it2.next().d().a(status, true, new P());
            }
            this.F.clear();
            j();
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Throwable th) {
        Preconditions.a(th, "failureCause");
        a(0, ErrorCode.INTERNAL_ERROR, Status.q.b(th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ErrorCode errorCode, String str) {
        a(0, errorCode, a(errorCode).a(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ErrorCode errorCode, Status status) {
        synchronized (this.m) {
            if (this.w == null) {
                this.w = status;
                this.i.a(status);
            }
            if (errorCode != null && !this.x) {
                this.x = true;
                this.k.a(0, errorCode, new byte[0]);
            }
            Iterator<Map.Entry<Integer, s>> it = this.p.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, s> next = it.next();
                if (next.getKey().intValue() > i) {
                    it.remove();
                    next.getValue().d().a(status, ClientStreamListener.RpcProgress.REFUSED, false, new P());
                }
            }
            Iterator<s> it2 = this.F.iterator();
            while (it2.hasNext()) {
                it2.next().d().a(status, ClientStreamListener.RpcProgress.REFUSED, true, new P());
            }
            this.F.clear();
            j();
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, @Nullable Status status, ClientStreamListener.RpcProgress rpcProgress, boolean z, @Nullable ErrorCode errorCode, @Nullable P p) {
        synchronized (this.m) {
            s remove = this.p.remove(Integer.valueOf(i));
            if (remove != null) {
                if (errorCode != null) {
                    this.k.a(i, ErrorCode.CANCEL);
                }
                if (status != null) {
                    s.c d2 = remove.d();
                    if (p == null) {
                        p = new P();
                    }
                    d2.a(status, rpcProgress, z, p);
                }
                if (!l()) {
                    m();
                    j();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s a(int i) {
        s sVar;
        synchronized (this.m) {
            sVar = this.p.get(Integer.valueOf(i));
        }
        return sVar;
    }

    @VisibleForTesting
    static Status a(ErrorCode errorCode) {
        Status status = f28001a.get(errorCode);
        if (status != null) {
            return status;
        }
        return Status.f27131d.b("Unknown http2 error code: " + errorCode.httpCode);
    }
}
