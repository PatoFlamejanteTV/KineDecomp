package okhttp3.a.b;

import com.facebook.stetho.server.http.HttpHeaders;
import java.io.IOException;
import java.util.List;
import okhttp3.B;
import okhttp3.C;
import okhttp3.C2571o;
import okhttp3.I;
import okhttp3.InterfaceC2573q;
import okhttp3.L;
import okhttp3.M;
import okhttp3.z;
import okio.n;
import okio.s;

/* compiled from: BridgeInterceptor.java */
/* loaded from: classes3.dex */
public final class a implements B {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC2573q f28872a;

    public a(InterfaceC2573q interfaceC2573q) {
        this.f28872a = interfaceC2573q;
    }

    @Override // okhttp3.B
    public M a(B.a aVar) throws IOException {
        I a2 = aVar.a();
        I.a f2 = a2.f();
        L a3 = a2.a();
        if (a3 != null) {
            C b2 = a3.b();
            if (b2 != null) {
                f2.b(HttpHeaders.CONTENT_TYPE, b2.toString());
            }
            long a4 = a3.a();
            if (a4 != -1) {
                f2.b(HttpHeaders.CONTENT_LENGTH, Long.toString(a4));
                f2.a("Transfer-Encoding");
            } else {
                f2.b("Transfer-Encoding", "chunked");
                f2.a(HttpHeaders.CONTENT_LENGTH);
            }
        }
        boolean z = false;
        if (a2.a("Host") == null) {
            f2.b("Host", okhttp3.a.e.a(a2.g(), false));
        }
        if (a2.a("Connection") == null) {
            f2.b("Connection", "Keep-Alive");
        }
        if (a2.a("Accept-Encoding") == null && a2.a("Range") == null) {
            z = true;
            f2.b("Accept-Encoding", "gzip");
        }
        List<C2571o> a5 = this.f28872a.a(a2.g());
        if (!a5.isEmpty()) {
            f2.b("Cookie", a(a5));
        }
        if (a2.a(io.fabric.sdk.android.services.common.a.HEADER_USER_AGENT) == null) {
            f2.b(io.fabric.sdk.android.services.common.a.HEADER_USER_AGENT, okhttp3.a.f.a());
        }
        M a6 = aVar.a(f2.a());
        f.a(this.f28872a, a2.g(), a6.s());
        M.a w = a6.w();
        w.a(a2);
        if (z && "gzip".equalsIgnoreCase(a6.e("Content-Encoding")) && f.b(a6)) {
            n nVar = new n(a6.a().r());
            z.a a7 = a6.s().a();
            a7.b("Content-Encoding");
            a7.b(HttpHeaders.CONTENT_LENGTH);
            w.a(a7.a());
            w.a(new i(a6.e(HttpHeaders.CONTENT_TYPE), -1L, s.a(nVar)));
        }
        return w.a();
    }

    private String a(List<C2571o> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            C2571o c2571o = list.get(i);
            sb.append(c2571o.a());
            sb.append('=');
            sb.append(c2571o.b());
        }
        return sb.toString();
    }
}
