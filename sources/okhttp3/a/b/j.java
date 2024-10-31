package okhttp3.a.b;

import java.net.Proxy;
import okhttp3.A;
import okhttp3.I;

/* compiled from: RequestLine.java */
/* loaded from: classes3.dex */
public final class j {
    public static String a(I i, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(i.e());
        sb.append(' ');
        if (b(i, type)) {
            sb.append(i.g());
        } else {
            sb.append(a(i.g()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(I i, Proxy.Type type) {
        return !i.d() && type == Proxy.Type.HTTP;
    }

    public static String a(A a2) {
        String c2 = a2.c();
        String e2 = a2.e();
        if (e2 == null) {
            return c2;
        }
        return c2 + '?' + e2;
    }
}
