package okhttp3.a.d;

import android.os.Build;
import android.util.Log;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidPlatform.java */
/* loaded from: classes3.dex */
public class a extends f {

    /* renamed from: c, reason: collision with root package name */
    private final Class<?> f28926c;

    /* renamed from: d, reason: collision with root package name */
    private final e<Socket> f28927d;

    /* renamed from: e, reason: collision with root package name */
    private final e<Socket> f28928e;

    /* renamed from: f, reason: collision with root package name */
    private final e<Socket> f28929f;

    /* renamed from: g, reason: collision with root package name */
    private final e<Socket> f28930g;

    /* renamed from: h, reason: collision with root package name */
    private final c f28931h = c.a();

    /* compiled from: AndroidPlatform.java */
    /* renamed from: okhttp3.a.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static final class C0167a extends okhttp3.a.f.c {

        /* renamed from: a, reason: collision with root package name */
        private final Object f28932a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f28933b;

        C0167a(Object obj, Method method) {
            this.f28932a = obj;
            this.f28933b = method;
        }

        @Override // okhttp3.a.f.c
        public List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f28933b.invoke(this.f28932a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InvocationTargetException e3) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e3.getMessage());
                sSLPeerUnverifiedException.initCause(e3);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0167a;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* compiled from: AndroidPlatform.java */
    /* loaded from: classes3.dex */
    static final class b implements okhttp3.a.f.e {

        /* renamed from: a, reason: collision with root package name */
        private final X509TrustManager f28934a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f28935b;

        b(X509TrustManager x509TrustManager, Method method) {
            this.f28935b = method;
            this.f28934a = x509TrustManager;
        }

        @Override // okhttp3.a.f.e
        public X509Certificate a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f28935b.invoke(this.f28934a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e2) {
                throw okhttp3.a.e.a("unable to get issues and signature", (Exception) e2);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f28934a.equals(bVar.f28934a) && this.f28935b.equals(bVar.f28935b);
        }

        public int hashCode() {
            return this.f28934a.hashCode() + (this.f28935b.hashCode() * 31);
        }
    }

    a(Class<?> cls, e<Socket> eVar, e<Socket> eVar2, e<Socket> eVar3, e<Socket> eVar4) {
        this.f28926c = cls;
        this.f28927d = eVar;
        this.f28928e = eVar2;
        this.f28929f = eVar3;
        this.f28930g = eVar4;
    }

    public static f d() {
        Class<?> cls;
        e eVar;
        e eVar2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            e eVar3 = new e(null, "setUseSessionTickets", Boolean.TYPE);
            e eVar4 = new e(null, "setHostname", String.class);
            if (e()) {
                e eVar5 = new e(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                eVar2 = new e(null, "setAlpnProtocols", byte[].class);
                eVar = eVar5;
            } else {
                eVar = null;
                eVar2 = null;
            }
            return new a(cls2, eVar3, eVar4, eVar, eVar2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    private static boolean e() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // okhttp3.a.d.f
    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e2) {
            if (!okhttp3.a.e.a(e2)) {
                throw e2;
            }
            throw new IOException(e2);
        } catch (ClassCastException e3) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e3);
                throw iOException;
            }
            throw e3;
        } catch (SecurityException e4) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e4);
            throw iOException2;
        }
    }

    @Override // okhttp3.a.d.f
    @Nullable
    public String b(SSLSocket sSLSocket) {
        byte[] bArr;
        e<Socket> eVar = this.f28929f;
        if (eVar == null || !eVar.a((e<Socket>) sSLSocket) || (bArr = (byte[]) this.f28929f.d(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, okhttp3.a.e.j);
    }

    /* compiled from: AndroidPlatform.java */
    /* loaded from: classes3.dex */
    static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final Method f28936a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f28937b;

        /* renamed from: c, reason: collision with root package name */
        private final Method f28938c;

        c(Method method, Method method2, Method method3) {
            this.f28936a = method;
            this.f28937b = method2;
            this.f28938c = method3;
        }

        Object a(String str) {
            Method method = this.f28936a;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    this.f28937b.invoke(invoke, str);
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        boolean a(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f28938c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        static c a() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new c(method3, method2, method);
        }
    }

    @Override // okhttp3.a.d.f
    public boolean b(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return b(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.b(str);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw okhttp3.a.e.a("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e3) {
            e = e3;
            throw okhttp3.a.e.a("unable to determine cleartext support", e);
        } catch (InvocationTargetException e4) {
            e = e4;
            throw okhttp3.a.e.a("unable to determine cleartext support", e);
        }
    }

    private boolean b(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return a(str, cls, obj);
        }
    }

    @Override // okhttp3.a.d.f
    public void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (str != null) {
            this.f28927d.c(sSLSocket, true);
            this.f28928e.c(sSLSocket, str);
        }
        e<Socket> eVar = this.f28930g;
        if (eVar == null || !eVar.a((e<Socket>) sSLSocket)) {
            return;
        }
        this.f28930g.d(sSLSocket, f.b(list));
    }

    @Override // okhttp3.a.d.f
    public okhttp3.a.f.e b(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.b(x509TrustManager);
        }
    }

    @Override // okhttp3.a.d.f
    public void a(int i, String str, @Nullable Throwable th) {
        int min;
        int i2 = i != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int indexOf = str.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + LicenseErrCode.ERROR_NO_XIAOMI_ACCOUNT);
                Log.println(i2, "OkHttp", str.substring(i3, min));
                if (min >= indexOf) {
                    break;
                } else {
                    i3 = min;
                }
            }
            i3 = min + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000b, code lost:            if (android.os.Build.VERSION.SDK_INT < 22) goto L10;     */
    @Override // okhttp3.a.d.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public javax.net.ssl.SSLContext b() {
        /*
            r3 = this;
            r0 = 1
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.NoClassDefFoundError -> Lf
            r2 = 16
            if (r1 < r2) goto Le
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.NoClassDefFoundError -> Lf
            r2 = 22
            if (r1 >= r2) goto Le
            goto Lf
        Le:
            r0 = 0
        Lf:
            if (r0 == 0) goto L18
            java.lang.String r0 = "TLSv1.2"
            javax.net.ssl.SSLContext r0 = javax.net.ssl.SSLContext.getInstance(r0)     // Catch: java.security.NoSuchAlgorithmException -> L18
            return r0
        L18:
            java.lang.String r0 = "TLS"
            javax.net.ssl.SSLContext r0 = javax.net.ssl.SSLContext.getInstance(r0)     // Catch: java.security.NoSuchAlgorithmException -> L1f
            return r0
        L1f:
            r0 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "No TLS provider"
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.a.d.a.b():javax.net.ssl.SSLContext");
    }

    @Override // okhttp3.a.d.f
    public Object a(String str) {
        return this.f28931h.a(str);
    }

    @Override // okhttp3.a.d.f
    public void a(String str, Object obj) {
        if (this.f28931h.a(obj)) {
            return;
        }
        a(5, str, (Throwable) null);
    }

    private boolean a(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.b(str);
        }
    }

    @Override // okhttp3.a.d.f
    public okhttp3.a.f.c a(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0167a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.a(x509TrustManager);
        }
    }
}
