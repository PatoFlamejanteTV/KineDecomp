package com.squareup.okhttp.a;

import com.squareup.okhttp.Protocol;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: Platform.java */
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static final l f25197a = c();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Platform.java */
    /* loaded from: classes3.dex */
    public static class b extends l {

        /* renamed from: b, reason: collision with root package name */
        private final Class<?> f25205b;

        public b(Class<?> cls) {
            this.f25205b = cls;
        }

        @Override // com.squareup.okhttp.a.l
        public X509TrustManager a(SSLSocketFactory sSLSocketFactory) {
            Object a2 = l.a(sSLSocketFactory, this.f25205b, com.umeng.analytics.pro.b.Q);
            if (a2 == null) {
                return null;
            }
            return (X509TrustManager) l.a(a2, X509TrustManager.class, "trustManager");
        }
    }

    /* compiled from: Platform.java */
    /* loaded from: classes3.dex */
    private static class d implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        private final List<String> f25211a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f25212b;

        /* renamed from: c, reason: collision with root package name */
        private String f25213c;

        public d(List<String> list) {
            this.f25211a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = o.f25218b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f25212b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f25211a;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                List list = (List) objArr[0];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (this.f25211a.contains(list.get(i))) {
                        String str = (String) list.get(i);
                        this.f25213c = str;
                        return str;
                    }
                }
                String str2 = this.f25211a.get(0);
                this.f25213c = str2;
                return str2;
            }
            if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                this.f25213c = (String) objArr[0];
                return null;
            }
            return method.invoke(this, objArr);
        }
    }

    public static l a() {
        return f25197a;
    }

    private static l c() {
        Class<?> cls;
        Method method;
        Method method2;
        k kVar;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                try {
                    Class<?> cls2 = Class.forName("sun.security.ssl.SSLContextImpl");
                    try {
                        Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN");
                        Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
                        return new c(cls2, cls3.getMethod("put", SSLSocket.class, cls4), cls3.getMethod("get", SSLSocket.class), cls3.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
                    } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                        return new b(cls2);
                    }
                } catch (ClassNotFoundException unused3) {
                    return new l();
                }
            }
        } catch (ClassNotFoundException unused4) {
            cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
        }
        Class<?> cls5 = cls;
        k kVar2 = null;
        k kVar3 = new k(null, "setUseSessionTickets", Boolean.TYPE);
        k kVar4 = new k(null, "setHostname", String.class);
        try {
            Class<?> cls6 = Class.forName("android.net.TrafficStats");
            method2 = cls6.getMethod("tagSocket", Socket.class);
            try {
                method = cls6.getMethod("untagSocket", Socket.class);
                try {
                    Class.forName("android.net.Network");
                    kVar = new k(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                    try {
                        kVar2 = new k(null, "setAlpnProtocols", byte[].class);
                    } catch (ClassNotFoundException | NoSuchMethodException unused5) {
                    }
                } catch (ClassNotFoundException | NoSuchMethodException unused6) {
                    kVar = null;
                }
            } catch (ClassNotFoundException | NoSuchMethodException unused7) {
                method = null;
                kVar = null;
            }
        } catch (ClassNotFoundException | NoSuchMethodException unused8) {
            method = null;
            method2 = null;
            kVar = null;
        }
        return new a(cls5, kVar3, kVar4, method2, method, kVar, kVar2);
    }

    public X509TrustManager a(SSLSocketFactory sSLSocketFactory) {
        return null;
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
    }

    public String b() {
        return "OkHttp";
    }

    public String b(SSLSocket sSLSocket) {
        return null;
    }

    public void a(String str) {
        System.out.println(str);
    }

    public com.squareup.okhttp.a.b.f a(X509TrustManager x509TrustManager) {
        return new com.squareup.okhttp.a.b.e(x509TrustManager.getAcceptedIssuers());
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    static byte[] a(List<Protocol> list) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Platform.java */
    /* loaded from: classes3.dex */
    public static class a extends l {

        /* renamed from: b, reason: collision with root package name */
        private final Class<?> f25198b;

        /* renamed from: c, reason: collision with root package name */
        private final k<Socket> f25199c;

        /* renamed from: d, reason: collision with root package name */
        private final k<Socket> f25200d;

        /* renamed from: e, reason: collision with root package name */
        private final Method f25201e;

        /* renamed from: f, reason: collision with root package name */
        private final Method f25202f;

        /* renamed from: g, reason: collision with root package name */
        private final k<Socket> f25203g;

        /* renamed from: h, reason: collision with root package name */
        private final k<Socket> f25204h;

        public a(Class<?> cls, k<Socket> kVar, k<Socket> kVar2, Method method, Method method2, k<Socket> kVar3, k<Socket> kVar4) {
            this.f25198b = cls;
            this.f25199c = kVar;
            this.f25200d = kVar2;
            this.f25201e = method;
            this.f25202f = method2;
            this.f25203g = kVar3;
            this.f25204h = kVar4;
        }

        @Override // com.squareup.okhttp.a.l
        public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
            try {
                socket.connect(inetSocketAddress, i);
            } catch (AssertionError e2) {
                if (!o.a(e2)) {
                    throw e2;
                }
                throw new IOException(e2);
            } catch (SecurityException e3) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e3);
                throw iOException;
            }
        }

        @Override // com.squareup.okhttp.a.l
        public String b(SSLSocket sSLSocket) {
            byte[] bArr;
            k<Socket> kVar = this.f25203g;
            if (kVar == null || !kVar.a((k<Socket>) sSLSocket) || (bArr = (byte[]) this.f25203g.d(sSLSocket, new Object[0])) == null) {
                return null;
            }
            return new String(bArr, o.f25219c);
        }

        @Override // com.squareup.okhttp.a.l
        public X509TrustManager a(SSLSocketFactory sSLSocketFactory) {
            Object a2 = l.a(sSLSocketFactory, this.f25198b, "sslParameters");
            if (a2 == null) {
                try {
                    a2 = l.a(sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
                } catch (ClassNotFoundException unused) {
                    return null;
                }
            }
            X509TrustManager x509TrustManager = (X509TrustManager) l.a(a2, X509TrustManager.class, "x509TrustManager");
            return x509TrustManager != null ? x509TrustManager : (X509TrustManager) l.a(a2, X509TrustManager.class, "trustManager");
        }

        @Override // com.squareup.okhttp.a.l
        public com.squareup.okhttp.a.b.f a(X509TrustManager x509TrustManager) {
            com.squareup.okhttp.a.b.f a2 = com.squareup.okhttp.a.b.a.a(x509TrustManager);
            return a2 != null ? a2 : super.a(x509TrustManager);
        }

        @Override // com.squareup.okhttp.a.l
        public void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
            if (str != null) {
                this.f25199c.c(sSLSocket, true);
                this.f25200d.c(sSLSocket, str);
            }
            k<Socket> kVar = this.f25204h;
            if (kVar == null || !kVar.a((k<Socket>) sSLSocket)) {
                return;
            }
            this.f25204h.d(sSLSocket, l.a(list));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Platform.java */
    /* loaded from: classes3.dex */
    public static class c extends b {

        /* renamed from: c, reason: collision with root package name */
        private final Method f25206c;

        /* renamed from: d, reason: collision with root package name */
        private final Method f25207d;

        /* renamed from: e, reason: collision with root package name */
        private final Method f25208e;

        /* renamed from: f, reason: collision with root package name */
        private final Class<?> f25209f;

        /* renamed from: g, reason: collision with root package name */
        private final Class<?> f25210g;

        public c(Class<?> cls, Method method, Method method2, Method method3, Class<?> cls2, Class<?> cls3) {
            super(cls);
            this.f25206c = method;
            this.f25207d = method2;
            this.f25208e = method3;
            this.f25209f = cls2;
            this.f25210g = cls3;
        }

        @Override // com.squareup.okhttp.a.l
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
                this.f25206c.invoke(null, sSLSocket, Proxy.newProxyInstance(l.class.getClassLoader(), new Class[]{this.f25209f, this.f25210g}, new d(arrayList)));
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw new AssertionError(e2);
            }
        }

        @Override // com.squareup.okhttp.a.l
        public String b(SSLSocket sSLSocket) {
            try {
                d dVar = (d) Proxy.getInvocationHandler(this.f25207d.invoke(null, sSLSocket));
                if (dVar.f25212b || dVar.f25213c != null) {
                    if (dVar.f25212b) {
                        return null;
                    }
                    return dVar.f25213c;
                }
                h.f25191a.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                return null;
            } catch (IllegalAccessException | InvocationTargetException unused) {
                throw new AssertionError();
            }
        }

        @Override // com.squareup.okhttp.a.l
        public void a(SSLSocket sSLSocket) {
            try {
                this.f25208e.invoke(null, sSLSocket);
            } catch (IllegalAccessException | InvocationTargetException unused) {
                throw new AssertionError();
            }
        }
    }

    static <T> T a(Object obj, Class<T> cls, String str) {
        Object a2;
        for (Class<?> cls2 = obj.getClass(); cls2 != Object.class; cls2 = cls2.getSuperclass()) {
            try {
                Field declaredField = cls2.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (obj2 != null && cls.isInstance(obj2)) {
                    return cls.cast(obj2);
                }
                return null;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (NoSuchFieldException unused2) {
            }
        }
        if (str.equals("delegate") || (a2 = a(obj, (Class<Object>) Object.class, "delegate")) == null) {
            return null;
        }
        return (T) a(a2, cls, str);
    }
}
