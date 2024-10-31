package okhttp3.a.d;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.F;
import okhttp3.Protocol;
import okio.g;

/* compiled from: Platform.java */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a */
    private static final f f28952a = d();

    /* renamed from: b */
    private static final Logger f28953b = Logger.getLogger(F.class.getName());

    public static f a() {
        return f28952a;
    }

    public static byte[] b(List<Protocol> list) {
        g gVar = new g();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                gVar.writeByte(protocol.toString().length());
                gVar.a(protocol.toString());
            }
        }
        return gVar.k();
    }

    public static boolean c() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    private static f d() {
        b d2;
        f d3 = a.d();
        if (d3 != null) {
            return d3;
        }
        if (c() && (d2 = b.d()) != null) {
            return d2;
        }
        c d4 = c.d();
        if (d4 != null) {
            return d4;
        }
        f d5 = d.d();
        return d5 != null ? d5 : new f();
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void a(SSLSocket sSLSocket, @Nullable String str, List<Protocol> list) {
    }

    public void a(SSLSocketFactory sSLSocketFactory) {
    }

    @Nullable
    public String b(SSLSocket sSLSocket) {
        return null;
    }

    public boolean b(String str) {
        return true;
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void a(int i, String str, @Nullable Throwable th) {
        f28953b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object a(String str) {
        if (f28953b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        a(5, str, (Throwable) obj);
    }

    public SSLContext b() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException("No TLS provider", e2);
        }
    }

    public static List<String> a(List<Protocol> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    public okhttp3.a.f.e b(X509TrustManager x509TrustManager) {
        return new okhttp3.a.f.b(x509TrustManager.getAcceptedIssuers());
    }

    public okhttp3.a.f.c a(X509TrustManager x509TrustManager) {
        return new okhttp3.a.f.a(b(x509TrustManager));
    }
}
