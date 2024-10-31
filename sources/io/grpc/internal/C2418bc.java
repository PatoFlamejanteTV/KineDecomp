package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: ProxyDetectorImpl.java */
/* renamed from: io.grpc.internal.bc */
/* loaded from: classes3.dex */
class C2418bc implements Zb {

    /* renamed from: a */
    private static final Logger f27568a = Logger.getLogger(C2418bc.class.getName());

    /* renamed from: b */
    private static final a f27569b = new _b();

    /* renamed from: c */
    private static final Supplier<ProxySelector> f27570c = new C2414ac();

    /* renamed from: d */
    private final Supplier<ProxySelector> f27571d;

    /* renamed from: e */
    private final a f27572e;

    /* renamed from: f */
    private final C2422cc f27573f;

    /* compiled from: ProxyDetectorImpl.java */
    /* renamed from: io.grpc.internal.bc$a */
    /* loaded from: classes3.dex */
    public interface a {
        PasswordAuthentication a(String str, InetAddress inetAddress, int i, String str2, String str3, String str4);
    }

    public C2418bc() {
        this(f27570c, f27569b, System.getenv("GRPC_PROXY_EXP"));
    }

    @VisibleForTesting
    C2418bc(Supplier<ProxySelector> supplier, a aVar, @Nullable String str) {
        Preconditions.a(supplier);
        this.f27571d = supplier;
        Preconditions.a(aVar);
        this.f27572e = aVar;
        if (str != null) {
            this.f27573f = new C2422cc(a(str), null, null);
        } else {
            this.f27573f = null;
        }
    }

    @Override // io.grpc.internal.Zb
    @Nullable
    public C2422cc a(SocketAddress socketAddress) throws IOException {
        C2422cc c2422cc = this.f27573f;
        if (c2422cc != null) {
            return c2422cc;
        }
        if (socketAddress instanceof InetSocketAddress) {
            return a((InetSocketAddress) socketAddress);
        }
        return null;
    }

    private C2422cc a(InetSocketAddress inetSocketAddress) throws IOException {
        try {
            try {
                List<Proxy> select = this.f27571d.get().select(new URI("https", null, GrpcUtil.a(inetSocketAddress), inetSocketAddress.getPort(), null, null, null));
                if (select.size() > 1) {
                    f27568a.warning("More than 1 proxy detected, gRPC will select the first one");
                }
                Proxy proxy = select.get(0);
                if (proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                InetSocketAddress inetSocketAddress2 = (InetSocketAddress) proxy.address();
                PasswordAuthentication a2 = this.f27572e.a(GrpcUtil.a(inetSocketAddress2), inetSocketAddress2.getAddress(), inetSocketAddress2.getPort(), "https", "", null);
                if (inetSocketAddress2.isUnresolved()) {
                    inetSocketAddress2 = new InetSocketAddress(InetAddress.getByName(inetSocketAddress2.getHostName()), inetSocketAddress2.getPort());
                }
                if (a2 == null) {
                    return new C2422cc(inetSocketAddress2, null, null);
                }
                return new C2422cc(inetSocketAddress2, a2.getUserName(), new String(a2.getPassword()));
            } catch (URISyntaxException e2) {
                f27568a.log(Level.WARNING, "Failed to construct URI for proxy lookup, proceeding without proxy", (Throwable) e2);
                return null;
            }
        } catch (Throwable th) {
            f27568a.log(Level.WARNING, "Failed to get host for proxy lookup, proceeding without proxy", th);
            return null;
        }
    }

    private static InetSocketAddress a(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(":", 2);
        int parseInt = split.length > 1 ? Integer.parseInt(split[1]) : 80;
        f27568a.warning("Detected GRPC_PROXY_EXP and will honor it, but this feature will be removed in a future release. Use the JVM flags \"-Dhttps.proxyHost=HOST -Dhttps.proxyPort=PORT\" to set the https proxy for this JVM.");
        return new InetSocketAddress(split[0], parseInt);
    }
}
