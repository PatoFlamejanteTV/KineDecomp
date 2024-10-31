package okhttp3.a.a;

import com.facebook.stetho.server.http.HttpHeaders;
import java.io.IOException;
import okhttp3.B;
import okhttp3.I;
import okhttp3.M;
import okhttp3.O;
import okhttp3.Protocol;
import okhttp3.a.a.d;
import okhttp3.a.b.f;
import okhttp3.a.b.g;
import okhttp3.a.b.i;
import okhttp3.z;
import okio.s;
import okio.y;

/* compiled from: CacheInterceptor.java */
/* loaded from: classes3.dex */
public final class b implements B {

    /* renamed from: a, reason: collision with root package name */
    final e f28860a;

    public b(e eVar) {
        this.f28860a = eVar;
    }

    static boolean b(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    @Override // okhttp3.B
    public M a(B.a aVar) throws IOException {
        e eVar = this.f28860a;
        M b2 = eVar != null ? eVar.b(aVar.a()) : null;
        d a2 = new d.a(System.currentTimeMillis(), aVar.a(), b2).a();
        I i = a2.f28861a;
        M m = a2.f28862b;
        e eVar2 = this.f28860a;
        if (eVar2 != null) {
            eVar2.a(a2);
        }
        if (b2 != null && m == null) {
            okhttp3.a.e.a(b2.a());
        }
        if (i == null && m == null) {
            M.a aVar2 = new M.a();
            aVar2.a(aVar.a());
            aVar2.a(Protocol.HTTP_1_1);
            aVar2.a(504);
            aVar2.a("Unsatisfiable Request (only-if-cached)");
            aVar2.a(okhttp3.a.e.f28956c);
            aVar2.b(-1L);
            aVar2.a(System.currentTimeMillis());
            return aVar2.a();
        }
        if (i == null) {
            M.a w = m.w();
            w.a(a(m));
            return w.a();
        }
        try {
            M a3 = aVar.a(i);
            if (a3 == null && b2 != null) {
            }
            if (m != null) {
                if (a3.c() == 304) {
                    M.a w2 = m.w();
                    w2.a(a(m.s(), a3.s()));
                    w2.b(a3.A());
                    w2.a(a3.y());
                    w2.a(a(m));
                    w2.b(a(a3));
                    M a4 = w2.a();
                    a3.a().close();
                    this.f28860a.a();
                    this.f28860a.a(m, a4);
                    return a4;
                }
                okhttp3.a.e.a(m.a());
            }
            M.a w3 = a3.w();
            w3.a(a(m));
            w3.b(a(a3));
            M a5 = w3.a();
            if (this.f28860a != null) {
                if (f.b(a5) && d.a(a5, i)) {
                    return a(this.f28860a.a(a5), a5);
                }
                if (g.a(i.e())) {
                    try {
                        this.f28860a.a(i);
                    } catch (IOException unused) {
                    }
                }
            }
            return a5;
        } finally {
            if (b2 != null) {
                okhttp3.a.e.a(b2.a());
            }
        }
    }

    private static M a(M m) {
        if (m == null || m.a() == null) {
            return m;
        }
        M.a w = m.w();
        w.a((O) null);
        return w.a();
    }

    private M a(c cVar, M m) throws IOException {
        y body;
        if (cVar == null || (body = cVar.body()) == null) {
            return m;
        }
        a aVar = new a(this, m.a().r(), cVar, s.a(body));
        String e2 = m.e(HttpHeaders.CONTENT_TYPE);
        long b2 = m.a().b();
        M.a w = m.w();
        w.a(new i(e2, b2, s.a(aVar)));
        return w.a();
    }

    private static z a(z zVar, z zVar2) {
        z.a aVar = new z.a();
        int b2 = zVar.b();
        for (int i = 0; i < b2; i++) {
            String a2 = zVar.a(i);
            String b3 = zVar.b(i);
            if ((!"Warning".equalsIgnoreCase(a2) || !b3.startsWith("1")) && (a(a2) || !b(a2) || zVar2.b(a2) == null)) {
                okhttp3.a.a.f28854a.a(aVar, a2, b3);
            }
        }
        int b4 = zVar2.b();
        for (int i2 = 0; i2 < b4; i2++) {
            String a3 = zVar2.a(i2);
            if (!a(a3) && b(a3)) {
                okhttp3.a.a.f28854a.a(aVar, a3, zVar2.b(i2));
            }
        }
        return aVar.a();
    }

    static boolean a(String str) {
        return HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(str);
    }
}
