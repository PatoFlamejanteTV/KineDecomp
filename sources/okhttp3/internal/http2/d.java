package okhttp3.internal.http2;

import com.facebook.stetho.server.http.HttpHeaders;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.B;
import okhttp3.F;
import okhttp3.I;
import okhttp3.M;
import okhttp3.O;
import okhttp3.Protocol;
import okhttp3.z;
import okio.ByteString;
import okio.y;
import okio.z;

/* compiled from: Http2Codec.java */
/* loaded from: classes3.dex */
public final class d implements okhttp3.a.b.c {

    /* renamed from: a, reason: collision with root package name */
    private static final List<String> f29053a = okhttp3.a.e.a("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* renamed from: b, reason: collision with root package name */
    private static final List<String> f29054b = okhttp3.a.e.a("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: c, reason: collision with root package name */
    private final B.a f29055c;

    /* renamed from: d, reason: collision with root package name */
    final okhttp3.internal.connection.f f29056d;

    /* renamed from: e, reason: collision with root package name */
    private final k f29057e;

    /* renamed from: f, reason: collision with root package name */
    private q f29058f;

    /* renamed from: g, reason: collision with root package name */
    private final Protocol f29059g;

    /* compiled from: Http2Codec.java */
    /* loaded from: classes3.dex */
    class a extends okio.l {

        /* renamed from: b, reason: collision with root package name */
        boolean f29060b;

        /* renamed from: c, reason: collision with root package name */
        long f29061c;

        a(z zVar) {
            super(zVar);
            this.f29060b = false;
            this.f29061c = 0L;
        }

        private void a(IOException iOException) {
            if (this.f29060b) {
                return;
            }
            this.f29060b = true;
            d dVar = d.this;
            dVar.f29056d.a(false, dVar, this.f29061c, iOException);
        }

        @Override // okio.l, okio.z
        public long b(okio.g gVar, long j) throws IOException {
            try {
                long b2 = a().b(gVar, j);
                if (b2 > 0) {
                    this.f29061c += b2;
                }
                return b2;
            } catch (IOException e2) {
                a(e2);
                throw e2;
            }
        }

        @Override // okio.l, okio.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            a(null);
        }
    }

    public d(F f2, B.a aVar, okhttp3.internal.connection.f fVar, k kVar) {
        Protocol protocol;
        this.f29055c = aVar;
        this.f29056d = fVar;
        this.f29057e = kVar;
        if (f2.r().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        } else {
            protocol = Protocol.HTTP_2;
        }
        this.f29059g = protocol;
    }

    @Override // okhttp3.a.b.c
    public y a(I i, long j) {
        return this.f29058f.d();
    }

    @Override // okhttp3.a.b.c
    public void b() throws IOException {
        this.f29057e.flush();
    }

    @Override // okhttp3.a.b.c
    public void cancel() {
        q qVar = this.f29058f;
        if (qVar != null) {
            qVar.b(ErrorCode.CANCEL);
        }
    }

    public static List<okhttp3.internal.http2.a> b(I i) {
        okhttp3.z c2 = i.c();
        ArrayList arrayList = new ArrayList(c2.b() + 4);
        arrayList.add(new okhttp3.internal.http2.a(okhttp3.internal.http2.a.f29025c, i.e()));
        arrayList.add(new okhttp3.internal.http2.a(okhttp3.internal.http2.a.f29026d, okhttp3.a.b.j.a(i.g())));
        String a2 = i.a("Host");
        if (a2 != null) {
            arrayList.add(new okhttp3.internal.http2.a(okhttp3.internal.http2.a.f29028f, a2));
        }
        arrayList.add(new okhttp3.internal.http2.a(okhttp3.internal.http2.a.f29027e, i.g().n()));
        int b2 = c2.b();
        for (int i2 = 0; i2 < b2; i2++) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(c2.a(i2).toLowerCase(Locale.US));
            if (!f29053a.contains(encodeUtf8.utf8())) {
                arrayList.add(new okhttp3.internal.http2.a(encodeUtf8, c2.b(i2)));
            }
        }
        return arrayList;
    }

    @Override // okhttp3.a.b.c
    public void a(I i) throws IOException {
        if (this.f29058f != null) {
            return;
        }
        this.f29058f = this.f29057e.a(b(i), i.a() != null);
        this.f29058f.h().a(this.f29055c.b(), TimeUnit.MILLISECONDS);
        this.f29058f.l().a(this.f29055c.c(), TimeUnit.MILLISECONDS);
    }

    @Override // okhttp3.a.b.c
    public void a() throws IOException {
        this.f29058f.d().close();
    }

    @Override // okhttp3.a.b.c
    public M.a a(boolean z) throws IOException {
        M.a a2 = a(this.f29058f.j(), this.f29059g);
        if (z && okhttp3.a.a.f28854a.a(a2) == 100) {
            return null;
        }
        return a2;
    }

    public static M.a a(okhttp3.z zVar, Protocol protocol) throws IOException {
        z.a aVar = new z.a();
        int b2 = zVar.b();
        okhttp3.a.b.l lVar = null;
        for (int i = 0; i < b2; i++) {
            String a2 = zVar.a(i);
            String b3 = zVar.b(i);
            if (a2.equals(":status")) {
                lVar = okhttp3.a.b.l.a("HTTP/1.1 " + b3);
            } else if (!f29054b.contains(a2)) {
                okhttp3.a.a.f28854a.a(aVar, a2, b3);
            }
        }
        if (lVar != null) {
            M.a aVar2 = new M.a();
            aVar2.a(protocol);
            aVar2.a(lVar.f28897b);
            aVar2.a(lVar.f28898c);
            aVar2.a(aVar.a());
            return aVar2;
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // okhttp3.a.b.c
    public O a(M m) throws IOException {
        okhttp3.internal.connection.f fVar = this.f29056d;
        fVar.f29019f.e(fVar.f29018e);
        return new okhttp3.a.b.i(m.e(HttpHeaders.CONTENT_TYPE), okhttp3.a.b.f.a(m), okio.s.a(new a(this.f29058f.e())));
    }
}
