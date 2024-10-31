package okhttp3.a.c;

import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.stetho.server.http.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.A;
import okhttp3.F;
import okhttp3.I;
import okhttp3.M;
import okhttp3.O;
import okhttp3.a.b.j;
import okhttp3.a.b.l;
import okhttp3.z;
import okio.B;
import okio.g;
import okio.h;
import okio.i;
import okio.m;
import okio.s;
import okio.y;
import okio.z;

/* compiled from: Http1Codec.java */
/* loaded from: classes3.dex */
public final class b implements okhttp3.a.b.c {

    /* renamed from: a, reason: collision with root package name */
    final F f28899a;

    /* renamed from: b, reason: collision with root package name */
    final okhttp3.internal.connection.f f28900b;

    /* renamed from: c, reason: collision with root package name */
    final i f28901c;

    /* renamed from: d, reason: collision with root package name */
    final h f28902d;

    /* renamed from: e, reason: collision with root package name */
    int f28903e = 0;

    /* renamed from: f, reason: collision with root package name */
    private long f28904f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: classes3.dex */
    public abstract class a implements z {

        /* renamed from: a, reason: collision with root package name */
        protected final m f28905a;

        /* renamed from: b, reason: collision with root package name */
        protected boolean f28906b;

        /* renamed from: c, reason: collision with root package name */
        protected long f28907c;

        private a() {
            this.f28905a = new m(b.this.f28901c.e());
            this.f28907c = 0L;
        }

        protected final void a(boolean z, IOException iOException) throws IOException {
            b bVar = b.this;
            int i = bVar.f28903e;
            if (i == 6) {
                return;
            }
            if (i == 5) {
                bVar.a(this.f28905a);
                b bVar2 = b.this;
                bVar2.f28903e = 6;
                okhttp3.internal.connection.f fVar = bVar2.f28900b;
                if (fVar != null) {
                    fVar.a(!z, bVar2, this.f28907c, iOException);
                    return;
                }
                return;
            }
            throw new IllegalStateException("state: " + b.this.f28903e);
        }

        @Override // okio.z
        public long b(g gVar, long j) throws IOException {
            try {
                long b2 = b.this.f28901c.b(gVar, j);
                if (b2 > 0) {
                    this.f28907c += b2;
                }
                return b2;
            } catch (IOException e2) {
                a(false, e2);
                throw e2;
            }
        }

        @Override // okio.z
        public B e() {
            return this.f28905a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* renamed from: okhttp3.a.c.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public final class C0166b implements y {

        /* renamed from: a, reason: collision with root package name */
        private final m f28909a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f28910b;

        C0166b() {
            this.f28909a = new m(b.this.f28902d.e());
        }

        @Override // okio.y
        public void a(g gVar, long j) throws IOException {
            if (this.f28910b) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            b.this.f28902d.f(j);
            b.this.f28902d.a("\r\n");
            b.this.f28902d.a(gVar, j);
            b.this.f28902d.a("\r\n");
        }

        @Override // okio.y, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.f28910b) {
                return;
            }
            this.f28910b = true;
            b.this.f28902d.a("0\r\n\r\n");
            b.this.a(this.f28909a);
            b.this.f28903e = 3;
        }

        @Override // okio.y
        public B e() {
            return this.f28909a;
        }

        @Override // okio.y, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.f28910b) {
                return;
            }
            b.this.f28902d.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: classes3.dex */
    public class c extends a {

        /* renamed from: e, reason: collision with root package name */
        private final A f28912e;

        /* renamed from: f, reason: collision with root package name */
        private long f28913f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f28914g;

        c(A a2) {
            super();
            this.f28913f = -1L;
            this.f28914g = true;
            this.f28912e = a2;
        }

        private void a() throws IOException {
            if (this.f28913f != -1) {
                b.this.f28901c.h();
            }
            try {
                this.f28913f = b.this.f28901c.o();
                String trim = b.this.f28901c.h().trim();
                if (this.f28913f < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f28913f + trim + "\"");
                }
                if (this.f28913f == 0) {
                    this.f28914g = false;
                    okhttp3.a.b.f.a(b.this.f28899a.g(), this.f28912e, b.this.e());
                    a(true, null);
                }
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }

        @Override // okhttp3.a.c.b.a, okio.z
        public long b(g gVar, long j) throws IOException {
            if (j >= 0) {
                if (!this.f28906b) {
                    if (!this.f28914g) {
                        return -1L;
                    }
                    long j2 = this.f28913f;
                    if (j2 == 0 || j2 == -1) {
                        a();
                        if (!this.f28914g) {
                            return -1L;
                        }
                    }
                    long b2 = super.b(gVar, Math.min(j, this.f28913f));
                    if (b2 != -1) {
                        this.f28913f -= b2;
                        return b2;
                    }
                    ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                    a(false, protocolException);
                    throw protocolException;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        @Override // okio.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f28906b) {
                return;
            }
            if (this.f28914g && !okhttp3.a.e.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, null);
            }
            this.f28906b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: classes3.dex */
    public final class d implements y {

        /* renamed from: a, reason: collision with root package name */
        private final m f28916a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f28917b;

        /* renamed from: c, reason: collision with root package name */
        private long f28918c;

        d(long j) {
            this.f28916a = new m(b.this.f28902d.e());
            this.f28918c = j;
        }

        @Override // okio.y
        public void a(g gVar, long j) throws IOException {
            if (!this.f28917b) {
                okhttp3.a.e.a(gVar.size(), 0L, j);
                if (j <= this.f28918c) {
                    b.this.f28902d.a(gVar, j);
                    this.f28918c -= j;
                    return;
                }
                throw new ProtocolException("expected " + this.f28918c + " bytes but received " + j);
            }
            throw new IllegalStateException("closed");
        }

        @Override // okio.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f28917b) {
                return;
            }
            this.f28917b = true;
            if (this.f28918c <= 0) {
                b.this.a(this.f28916a);
                b.this.f28903e = 3;
                return;
            }
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // okio.y
        public B e() {
            return this.f28916a;
        }

        @Override // okio.y, java.io.Flushable
        public void flush() throws IOException {
            if (this.f28917b) {
                return;
            }
            b.this.f28902d.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: classes3.dex */
    public class e extends a {

        /* renamed from: e, reason: collision with root package name */
        private long f28920e;

        e(long j) throws IOException {
            super();
            this.f28920e = j;
            if (this.f28920e == 0) {
                a(true, null);
            }
        }

        @Override // okhttp3.a.c.b.a, okio.z
        public long b(g gVar, long j) throws IOException {
            if (j >= 0) {
                if (!this.f28906b) {
                    long j2 = this.f28920e;
                    if (j2 == 0) {
                        return -1L;
                    }
                    long b2 = super.b(gVar, Math.min(j2, j));
                    if (b2 != -1) {
                        this.f28920e -= b2;
                        if (this.f28920e == 0) {
                            a(true, null);
                        }
                        return b2;
                    }
                    ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                    a(false, protocolException);
                    throw protocolException;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        @Override // okio.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f28906b) {
                return;
            }
            if (this.f28920e != 0 && !okhttp3.a.e.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, null);
            }
            this.f28906b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: classes3.dex */
    public class f extends a {

        /* renamed from: e, reason: collision with root package name */
        private boolean f28922e;

        f() {
            super();
        }

        @Override // okhttp3.a.c.b.a, okio.z
        public long b(g gVar, long j) throws IOException {
            if (j >= 0) {
                if (!this.f28906b) {
                    if (this.f28922e) {
                        return -1L;
                    }
                    long b2 = super.b(gVar, j);
                    if (b2 != -1) {
                        return b2;
                    }
                    this.f28922e = true;
                    a(true, null);
                    return -1L;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        @Override // okio.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f28906b) {
                return;
            }
            if (!this.f28922e) {
                a(false, null);
            }
            this.f28906b = true;
        }
    }

    public b(F f2, okhttp3.internal.connection.f fVar, i iVar, h hVar) {
        this.f28899a = f2;
        this.f28900b = fVar;
        this.f28901c = iVar;
        this.f28902d = hVar;
    }

    private String f() throws IOException {
        String a2 = this.f28901c.a(this.f28904f);
        this.f28904f -= a2.length();
        return a2;
    }

    @Override // okhttp3.a.b.c
    public y a(I i, long j) {
        if ("chunked".equalsIgnoreCase(i.a("Transfer-Encoding"))) {
            return c();
        }
        if (j != -1) {
            return a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // okhttp3.a.b.c
    public void b() throws IOException {
        this.f28902d.flush();
    }

    public y c() {
        if (this.f28903e == 1) {
            this.f28903e = 2;
            return new C0166b();
        }
        throw new IllegalStateException("state: " + this.f28903e);
    }

    @Override // okhttp3.a.b.c
    public void cancel() {
        okhttp3.internal.connection.c c2 = this.f28900b.c();
        if (c2 != null) {
            c2.a();
        }
    }

    public z d() throws IOException {
        if (this.f28903e == 4) {
            okhttp3.internal.connection.f fVar = this.f28900b;
            if (fVar != null) {
                this.f28903e = 5;
                fVar.e();
                return new f();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.f28903e);
    }

    public okhttp3.z e() throws IOException {
        z.a aVar = new z.a();
        while (true) {
            String f2 = f();
            if (f2.length() != 0) {
                okhttp3.a.a.f28854a.a(aVar, f2);
            } else {
                return aVar.a();
            }
        }
    }

    public okio.z b(long j) throws IOException {
        if (this.f28903e == 4) {
            this.f28903e = 5;
            return new e(j);
        }
        throw new IllegalStateException("state: " + this.f28903e);
    }

    @Override // okhttp3.a.b.c
    public void a(I i) throws IOException {
        a(i.c(), j.a(i, this.f28900b.c().d().b().type()));
    }

    @Override // okhttp3.a.b.c
    public O a(M m) throws IOException {
        okhttp3.internal.connection.f fVar = this.f28900b;
        fVar.f29019f.e(fVar.f29018e);
        String e2 = m.e(HttpHeaders.CONTENT_TYPE);
        if (!okhttp3.a.b.f.b(m)) {
            return new okhttp3.a.b.i(e2, 0L, s.a(b(0L)));
        }
        if ("chunked".equalsIgnoreCase(m.e("Transfer-Encoding"))) {
            return new okhttp3.a.b.i(e2, -1L, s.a(a(m.z().g())));
        }
        long a2 = okhttp3.a.b.f.a(m);
        if (a2 != -1) {
            return new okhttp3.a.b.i(e2, a2, s.a(b(a2)));
        }
        return new okhttp3.a.b.i(e2, -1L, s.a(d()));
    }

    @Override // okhttp3.a.b.c
    public void a() throws IOException {
        this.f28902d.flush();
    }

    public void a(okhttp3.z zVar, String str) throws IOException {
        if (this.f28903e == 0) {
            this.f28902d.a(str).a("\r\n");
            int b2 = zVar.b();
            for (int i = 0; i < b2; i++) {
                this.f28902d.a(zVar.a(i)).a(": ").a(zVar.b(i)).a("\r\n");
            }
            this.f28902d.a("\r\n");
            this.f28903e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f28903e);
    }

    @Override // okhttp3.a.b.c
    public M.a a(boolean z) throws IOException {
        int i = this.f28903e;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.f28903e);
        }
        try {
            l a2 = l.a(f());
            M.a aVar = new M.a();
            aVar.a(a2.f28896a);
            aVar.a(a2.f28897b);
            aVar.a(a2.f28898c);
            aVar.a(e());
            if (z && a2.f28897b == 100) {
                return null;
            }
            if (a2.f28897b == 100) {
                this.f28903e = 3;
                return aVar;
            }
            this.f28903e = 4;
            return aVar;
        } catch (EOFException e2) {
            IOException iOException = new IOException("unexpected end of stream on " + this.f28900b);
            iOException.initCause(e2);
            throw iOException;
        }
    }

    public y a(long j) {
        if (this.f28903e == 1) {
            this.f28903e = 2;
            return new d(j);
        }
        throw new IllegalStateException("state: " + this.f28903e);
    }

    public okio.z a(A a2) throws IOException {
        if (this.f28903e == 4) {
            this.f28903e = 5;
            return new c(a2);
        }
        throw new IllegalStateException("state: " + this.f28903e);
    }

    void a(m mVar) {
        B g2 = mVar.g();
        mVar.a(B.f29225a);
        g2.a();
        g2.b();
    }
}
