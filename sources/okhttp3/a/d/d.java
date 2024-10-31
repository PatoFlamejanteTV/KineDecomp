package okhttp3.a.d;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JdkWithJettyBootPlatform.java */
/* loaded from: classes3.dex */
public class d extends f {

    /* renamed from: c, reason: collision with root package name */
    private final Method f28941c;

    /* renamed from: d, reason: collision with root package name */
    private final Method f28942d;

    /* renamed from: e, reason: collision with root package name */
    private final Method f28943e;

    /* renamed from: f, reason: collision with root package name */
    private final Class<?> f28944f;

    /* renamed from: g, reason: collision with root package name */
    private final Class<?> f28945g;

    /* compiled from: JdkWithJettyBootPlatform.java */
    /* loaded from: classes3.dex */
    private static class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        private final List<String> f28946a;

        /* renamed from: b, reason: collision with root package name */
        boolean f28947b;

        /* renamed from: c, reason: collision with root package name */
        String f28948c;

        a(List<String> list) {
            this.f28946a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = okhttp3.a.e.f28955b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f28947b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f28946a;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                List list = (List) objArr[0];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (this.f28946a.contains(list.get(i))) {
                        String str = (String) list.get(i);
                        this.f28948c = str;
                        return str;
                    }
                }
                String str2 = this.f28946a.get(0);
                this.f28948c = str2;
                return str2;
            }
            if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                this.f28948c = (String) objArr[0];
                return null;
            }
            return method.invoke(this, objArr);
        }
    }

    d(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f28941c = method;
        this.f28942d = method2;
        this.f28943e = method3;
        this.f28944f = cls;
        this.f28945g = cls2;
    }

    public static f d() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            return new d(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // okhttp3.a.d.f
    public void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        try {
            this.f28941c.invoke(null, sSLSocket, Proxy.newProxyInstance(f.class.getClassLoader(), new Class[]{this.f28944f, this.f28945g}, new a(f.a(list))));
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw okhttp3.a.e.a("unable to set alpn", (Exception) e2);
        }
    }

    @Override // okhttp3.a.d.f
    @Nullable
    public String b(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f28942d.invoke(null, sSLSocket));
            if (!aVar.f28947b && aVar.f28948c == null) {
                f.a().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            }
            if (aVar.f28947b) {
                return null;
            }
            return aVar.f28948c;
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw okhttp3.a.e.a("unable to get selected protocol", (Exception) e2);
        }
    }

    @Override // okhttp3.a.d.f
    public void a(SSLSocket sSLSocket) {
        try {
            this.f28943e.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw okhttp3.a.e.a("unable to remove alpn", (Exception) e2);
        }
    }
}
