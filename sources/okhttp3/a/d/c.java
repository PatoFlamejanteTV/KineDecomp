package okhttp3.a.d;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Jdk9Platform.java */
/* loaded from: classes3.dex */
public final class c extends f {

    /* renamed from: c, reason: collision with root package name */
    final Method f28939c;

    /* renamed from: d, reason: collision with root package name */
    final Method f28940d;

    c(Method method, Method method2) {
        this.f28939c = method;
        this.f28940d = method2;
    }

    public static c d() {
        try {
            return new c(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // okhttp3.a.d.f
    public void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> a2 = f.a(list);
            this.f28939c.invoke(sSLParameters, a2.toArray(new String[a2.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw okhttp3.a.e.a("unable to set ssl parameters", (Exception) e2);
        }
    }

    @Override // okhttp3.a.d.f
    @Nullable
    public String b(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f28940d.invoke(sSLSocket, new Object[0]);
            if (str == null) {
                return null;
            }
            if (str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw okhttp3.a.e.a("unable to get selected protocols", (Exception) e2);
        }
    }
}
