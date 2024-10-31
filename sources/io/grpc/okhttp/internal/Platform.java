package io.grpc.okhttp.internal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* loaded from: classes3.dex */
public class Platform {

    /* renamed from: a */
    public static final Logger f27867a = Logger.getLogger(Platform.class.getName());

    /* renamed from: b */
    private static final String[] f27868b = {"com.google.android.gms.org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLProvider", "org.apache.harmony.xnet.provider.jsse.OpenSSLProvider"};

    /* renamed from: c */
    private static final Platform f27869c = d();

    /* renamed from: d */
    private final Provider f27870d;

    /* loaded from: classes3.dex */
    public enum TlsExtensionType {
        ALPN_AND_NPN,
        NPN,
        NONE
    }

    /* loaded from: classes3.dex */
    public static class a extends Platform {

        /* renamed from: e */
        private final e<Socket> f27871e;

        /* renamed from: f */
        private final e<Socket> f27872f;

        /* renamed from: g */
        private final Method f27873g;

        /* renamed from: h */
        private final Method f27874h;
        private final e<Socket> i;
        private final e<Socket> j;
        private final TlsExtensionType k;

        public a(e<Socket> eVar, e<Socket> eVar2, Method method, Method method2, e<Socket> eVar3, e<Socket> eVar4, Provider provider, TlsExtensionType tlsExtensionType) {
            super(provider);
            this.f27871e = eVar;
            this.f27872f = eVar2;
            this.f27873g = method;
            this.f27874h = method2;
            this.i = eVar3;
            this.j = eVar4;
            this.k = tlsExtensionType;
        }

        @Override // io.grpc.okhttp.internal.Platform
        public void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
            if (str != null) {
                this.f27871e.c(sSLSocket, true);
                this.f27872f.c(sSLSocket, str);
            }
            if (this.j.a((e<Socket>) sSLSocket)) {
                this.j.d(sSLSocket, Platform.a(list));
            }
        }

        @Override // io.grpc.okhttp.internal.Platform
        public String b(SSLSocket sSLSocket) {
            byte[] bArr;
            if (this.i.a((e<Socket>) sSLSocket) && (bArr = (byte[]) this.i.d(sSLSocket, new Object[0])) != null) {
                return new String(bArr, i.f27961c);
            }
            return null;
        }

        @Override // io.grpc.okhttp.internal.Platform
        public TlsExtensionType c() {
            return this.k;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends Platform {

        /* renamed from: e */
        private final Method f27875e;

        /* renamed from: f */
        private final Method f27876f;

        /* synthetic */ b(Provider provider, Method method, Method method2, f fVar) {
            this(provider, method, method2);
        }

        @Override // io.grpc.okhttp.internal.Platform
        public void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            ArrayList arrayList = new ArrayList(list.size());
            for (Protocol protocol : list) {
                if (protocol != Protocol.HTTP_1_0) {
                    arrayList.add(protocol.toString());
                }
            }
            try {
                this.f27875e.invoke(sSLParameters, arrayList.toArray(new String[arrayList.size()]));
                sSLSocket.setSSLParameters(sSLParameters);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3);
            }
        }

        @Override // io.grpc.okhttp.internal.Platform
        public String b(SSLSocket sSLSocket) {
            try {
                return (String) this.f27876f.invoke(sSLSocket, new Object[0]);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3);
            }
        }

        @Override // io.grpc.okhttp.internal.Platform
        public TlsExtensionType c() {
            return TlsExtensionType.ALPN_AND_NPN;
        }

        private b(Provider provider, Method method, Method method2) {
            super(provider);
            this.f27875e = method;
            this.f27876f = method2;
        }
    }

    /* loaded from: classes3.dex */
    private static class d implements InvocationHandler {

        /* renamed from: a */
        private final List<String> f27881a;

        /* renamed from: b */
        private boolean f27882b;

        /* renamed from: c */
        private String f27883c;

        public d(List<String> list) {
            this.f27881a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = i.f27960b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f27882b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f27881a;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                List list = (List) objArr[0];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (this.f27881a.contains(list.get(i))) {
                        String str = (String) list.get(i);
                        this.f27883c = str;
                        return str;
                    }
                }
                String str2 = this.f27881a.get(0);
                this.f27883c = str2;
                return str2;
            }
            if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                this.f27883c = (String) objArr[0];
                return null;
            }
            return method.invoke(this, objArr);
        }
    }

    public Platform(Provider provider) {
        this.f27870d = provider;
    }

    public static Platform a() {
        return f27869c;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static io.grpc.okhttp.internal.Platform d() {
        /*
            Method dump skipped, instructions count: 365
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.internal.Platform.d():io.grpc.okhttp.internal.Platform");
    }

    private static Provider e() {
        for (Provider provider : Security.getProviders()) {
            for (String str : f27868b) {
                if (str.equals(provider.getClass().getName())) {
                    f27867a.log(Level.FINE, "Found registered provider {0}", str);
                    return provider;
                }
            }
        }
        f27867a.log(Level.WARNING, "Unable to find Conscrypt");
        return null;
    }

    private static Provider f() {
        try {
            return (Provider) Class.forName("org.conscrypt.OpenSSLProvider").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            throw new RuntimeException("Unable to load conscrypt security provider", th);
        }
    }

    private static boolean g() {
        try {
            Platform.class.getClassLoader().loadClass("android.app.ActivityOptions");
            return true;
        } catch (ClassNotFoundException e2) {
            f27867a.log(Level.FINE, "Can't find class", (Throwable) e2);
            return false;
        }
    }

    private static boolean h() {
        try {
            Platform.class.getClassLoader().loadClass("android.net.Network");
            return true;
        } catch (ClassNotFoundException e2) {
            f27867a.log(Level.FINE, "Can't find class", (Throwable) e2);
            return false;
        }
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
    }

    public String b(SSLSocket sSLSocket) {
        return null;
    }

    public Provider b() {
        return this.f27870d;
    }

    public TlsExtensionType c() {
        return TlsExtensionType.NONE;
    }

    public static byte[] a(List<Protocol> list) {
        okio.g gVar = new okio.g();
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

    /* loaded from: classes3.dex */
    public static class c extends Platform {

        /* renamed from: e */
        private final Method f27877e;

        /* renamed from: f */
        private final Method f27878f;

        /* renamed from: g */
        private final Method f27879g;

        /* renamed from: h */
        private final Class<?> f27880h;
        private final Class<?> i;

        public c(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2, Provider provider) {
            super(provider);
            this.f27877e = method;
            this.f27878f = method2;
            this.f27879g = method3;
            this.f27880h = cls;
            this.i = cls2;
        }

        @Override // io.grpc.okhttp.internal.Platform
        public void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Protocol protocol = list.get(i);
                if (protocol != Protocol.HTTP_1_0) {
                    arrayList.add(protocol.toString());
                }
            }
            try {
                this.f27877e.invoke(null, sSLSocket, Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.f27880h, this.i}, new d(arrayList)));
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InvocationTargetException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // io.grpc.okhttp.internal.Platform
        public String b(SSLSocket sSLSocket) {
            try {
                d dVar = (d) Proxy.getInvocationHandler(this.f27878f.invoke(null, sSLSocket));
                if (dVar.f27882b || dVar.f27883c != null) {
                    if (dVar.f27882b) {
                        return null;
                    }
                    return dVar.f27883c;
                }
                Platform.f27867a.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                return null;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException unused2) {
                throw new AssertionError();
            }
        }

        @Override // io.grpc.okhttp.internal.Platform
        public TlsExtensionType c() {
            return TlsExtensionType.ALPN_AND_NPN;
        }

        @Override // io.grpc.okhttp.internal.Platform
        public void a(SSLSocket sSLSocket) {
            try {
                this.f27879g.invoke(null, sSLSocket);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException unused2) {
            }
        }
    }
}
