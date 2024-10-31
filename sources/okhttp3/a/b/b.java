package okhttp3.a.b;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.B;
import okhttp3.I;
import okhttp3.M;
import okio.s;
import okio.y;

/* compiled from: CallServerInterceptor.java */
/* loaded from: classes3.dex */
public final class b implements B {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f28873a;

    /* compiled from: CallServerInterceptor.java */
    /* loaded from: classes3.dex */
    static final class a extends okio.k {

        /* renamed from: b, reason: collision with root package name */
        long f28874b;

        a(y yVar) {
            super(yVar);
        }

        @Override // okio.k, okio.y
        public void a(okio.g gVar, long j) throws IOException {
            super.a(gVar, j);
            this.f28874b += j;
        }
    }

    public b(boolean z) {
        this.f28873a = z;
    }

    @Override // okhttp3.B
    public M a(B.a aVar) throws IOException {
        M a2;
        h hVar = (h) aVar;
        c h2 = hVar.h();
        okhttp3.internal.connection.f i = hVar.i();
        okhttp3.internal.connection.c cVar = (okhttp3.internal.connection.c) hVar.f();
        I a3 = hVar.a();
        long currentTimeMillis = System.currentTimeMillis();
        hVar.g().d(hVar.e());
        h2.a(a3);
        hVar.g().a(hVar.e(), a3);
        M.a aVar2 = null;
        if (g.b(a3.e()) && a3.a() != null) {
            if ("100-continue".equalsIgnoreCase(a3.a("Expect"))) {
                h2.b();
                hVar.g().f(hVar.e());
                aVar2 = h2.a(true);
            }
            if (aVar2 == null) {
                hVar.g().c(hVar.e());
                a aVar3 = new a(h2.a(a3, a3.a().a()));
                okio.h a4 = s.a(aVar3);
                a3.a().a(a4);
                a4.close();
                hVar.g().a(hVar.e(), aVar3.f28874b);
            } else if (!cVar.c()) {
                i.e();
            }
        }
        h2.a();
        if (aVar2 == null) {
            hVar.g().f(hVar.e());
            aVar2 = h2.a(false);
        }
        aVar2.a(a3);
        aVar2.a(i.c().b());
        aVar2.b(currentTimeMillis);
        aVar2.a(System.currentTimeMillis());
        M a5 = aVar2.a();
        int c2 = a5.c();
        if (c2 == 100) {
            M.a a6 = h2.a(false);
            a6.a(a3);
            a6.a(i.c().b());
            a6.b(currentTimeMillis);
            a6.a(System.currentTimeMillis());
            a5 = a6.a();
            c2 = a5.c();
        }
        hVar.g().a(hVar.e(), a5);
        if (this.f28873a && c2 == 101) {
            M.a w = a5.w();
            w.a(okhttp3.a.e.f28956c);
            a2 = w.a();
        } else {
            M.a w2 = a5.w();
            w2.a(h2.a(a5));
            a2 = w2.a();
        }
        if ("close".equalsIgnoreCase(a2.z().a("Connection")) || "close".equalsIgnoreCase(a2.e("Connection"))) {
            i.e();
        }
        if ((c2 != 204 && c2 != 205) || a2.a().b() <= 0) {
            return a2;
        }
        throw new ProtocolException("HTTP " + c2 + " had non-zero Content-Length: " + a2.a().b());
    }
}
