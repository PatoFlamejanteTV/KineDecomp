package io.grpc.okhttp;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.okhttp.internal.Platform;
import io.grpc.okhttp.internal.Protocol;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

/* compiled from: OkHttpProtocolNegotiator.java */
/* loaded from: classes3.dex */
public class x {

    /* renamed from: a */
    private static final Logger f28012a = Logger.getLogger(x.class.getName());

    /* renamed from: b */
    private static final Platform f28013b = Platform.a();

    /* renamed from: c */
    private static x f28014c = a(x.class.getClassLoader());

    /* renamed from: d */
    protected final Platform f28015d;

    @VisibleForTesting
    x(Platform platform) {
        Preconditions.a(platform, "platform");
        this.f28015d = platform;
    }

    public static x a() {
        return f28014c;
    }

    public String b(SSLSocket sSLSocket, String str, @Nullable List<Protocol> list) throws IOException {
        if (list != null) {
            a(sSLSocket, str, list);
        }
        try {
            sSLSocket.startHandshake();
            String a2 = a(sSLSocket);
            if (a2 != null) {
                return a2;
            }
            throw new RuntimeException("protocol negotiation failed");
        } finally {
            this.f28015d.a(sSLSocket);
        }
    }

    @VisibleForTesting
    static x a(ClassLoader classLoader) {
        boolean z;
        try {
            classLoader.loadClass("com.android.org.conscrypt.OpenSSLSocketImpl");
        } catch (ClassNotFoundException e2) {
            f28012a.log(Level.FINE, "Unable to find Conscrypt. Skipping", (Throwable) e2);
            try {
                classLoader.loadClass("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
            } catch (ClassNotFoundException e3) {
                f28012a.log(Level.FINE, "Unable to find any OpenSSLSocketImpl. Skipping", (Throwable) e3);
                z = false;
            }
        }
        z = true;
        if (z) {
            return new a(f28013b);
        }
        return new x(f28013b);
    }

    /* compiled from: OkHttpProtocolNegotiator.java */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static final class a extends x {

        /* renamed from: e */
        private static final io.grpc.okhttp.internal.e<Socket> f28016e = new io.grpc.okhttp.internal.e<>(null, "setUseSessionTickets", Boolean.TYPE);

        /* renamed from: f */
        private static final io.grpc.okhttp.internal.e<Socket> f28017f = new io.grpc.okhttp.internal.e<>(null, "setHostname", String.class);

        /* renamed from: g */
        private static final io.grpc.okhttp.internal.e<Socket> f28018g = new io.grpc.okhttp.internal.e<>(byte[].class, "getAlpnSelectedProtocol", new Class[0]);

        /* renamed from: h */
        private static final io.grpc.okhttp.internal.e<Socket> f28019h = new io.grpc.okhttp.internal.e<>(null, "setAlpnProtocols", byte[].class);
        private static final io.grpc.okhttp.internal.e<Socket> i = new io.grpc.okhttp.internal.e<>(byte[].class, "getNpnSelectedProtocol", new Class[0]);
        private static final io.grpc.okhttp.internal.e<Socket> j = new io.grpc.okhttp.internal.e<>(null, "setNpnProtocols", byte[].class);

        a(Platform platform) {
            super(platform);
        }

        @Override // io.grpc.okhttp.x
        protected void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
            if (str != null) {
                f28016e.c(sSLSocket, true);
                f28017f.c(sSLSocket, str);
            }
            Object[] objArr = {Platform.a(list)};
            if (this.f28015d.c() == Platform.TlsExtensionType.ALPN_AND_NPN) {
                f28019h.d(sSLSocket, objArr);
            }
            if (this.f28015d.c() != Platform.TlsExtensionType.NONE) {
                j.d(sSLSocket, objArr);
                return;
            }
            throw new RuntimeException("We can not do TLS handshake on this Android version, please install the Google Play Services Dynamic Security Provider to use TLS");
        }

        @Override // io.grpc.okhttp.x
        public String b(SSLSocket sSLSocket, String str, List<Protocol> list) throws IOException {
            String a2 = a(sSLSocket);
            return a2 == null ? super.b(sSLSocket, str, list) : a2;
        }

        @Override // io.grpc.okhttp.x
        public String a(SSLSocket sSLSocket) {
            if (this.f28015d.c() == Platform.TlsExtensionType.ALPN_AND_NPN) {
                try {
                    byte[] bArr = (byte[]) f28018g.d(sSLSocket, new Object[0]);
                    if (bArr != null) {
                        return new String(bArr, io.grpc.okhttp.internal.i.f27961c);
                    }
                } catch (Exception unused) {
                }
            }
            if (this.f28015d.c() == Platform.TlsExtensionType.NONE) {
                return null;
            }
            try {
                byte[] bArr2 = (byte[]) i.d(sSLSocket, new Object[0]);
                if (bArr2 != null) {
                    return new String(bArr2, io.grpc.okhttp.internal.i.f27961c);
                }
                return null;
            } catch (Exception unused2) {
                return null;
            }
        }
    }

    protected void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        this.f28015d.a(sSLSocket, str, list);
    }

    public String a(SSLSocket sSLSocket) {
        return this.f28015d.b(sSLSocket);
    }
}
