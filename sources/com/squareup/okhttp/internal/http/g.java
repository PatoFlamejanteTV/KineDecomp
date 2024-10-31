package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.E;
import com.squareup.okhttp.H;
import com.squareup.okhttp.I;
import com.squareup.okhttp.x;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.B;
import okio.y;
import okio.z;

/* compiled from: Http1xStream.java */
/* loaded from: classes3.dex */
public final class g implements o {

    /* renamed from: a, reason: collision with root package name */
    private final w f25423a;

    /* renamed from: b, reason: collision with root package name */
    private final okio.i f25424b;

    /* renamed from: c, reason: collision with root package name */
    private final okio.h f25425c;

    /* renamed from: d, reason: collision with root package name */
    private m f25426d;

    /* renamed from: e, reason: collision with root package name */
    private int f25427e = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1xStream.java */
    /* loaded from: classes3.dex */
    public abstract class a implements z {

        /* renamed from: a, reason: collision with root package name */
        protected final okio.m f25428a;

        /* renamed from: b, reason: collision with root package name */
        protected boolean f25429b;

        private a() {
            this.f25428a = new okio.m(g.this.f25424b.e());
        }

        protected final void a() throws IOException {
            if (g.this.f25427e != 5) {
                throw new IllegalStateException("state: " + g.this.f25427e);
            }
            g.this.a(this.f25428a);
            g.this.f25427e = 6;
            if (g.this.f25423a != null) {
                g.this.f25423a.a(g.this);
            }
        }

        protected final void b() {
            if (g.this.f25427e == 6) {
                return;
            }
            g.this.f25427e = 6;
            if (g.this.f25423a != null) {
                g.this.f25423a.c();
                g.this.f25423a.a(g.this);
            }
        }

        @Override // okio.z
        public B e() {
            return this.f25428a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1xStream.java */
    /* loaded from: classes3.dex */
    public final class b implements y {

        /* renamed from: a, reason: collision with root package name */
        private final okio.m f25431a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f25432b;

        private b() {
            this.f25431a = new okio.m(g.this.f25425c.e());
        }

        @Override // okio.y
        public void a(okio.g gVar, long j) throws IOException {
            if (this.f25432b) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            g.this.f25425c.f(j);
            g.this.f25425c.a("\r\n");
            g.this.f25425c.a(gVar, j);
            g.this.f25425c.a("\r\n");
        }

        @Override // okio.y, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.f25432b) {
                return;
            }
            this.f25432b = true;
            g.this.f25425c.a("0\r\n\r\n");
            g.this.a(this.f25431a);
            g.this.f25427e = 3;
        }

        @Override // okio.y
        public B e() {
            return this.f25431a;
        }

        @Override // okio.y, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.f25432b) {
                return;
            }
            g.this.f25425c.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1xStream.java */
    /* loaded from: classes3.dex */
    public class c extends a {

        /* renamed from: d, reason: collision with root package name */
        private long f25434d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f25435e;

        /* renamed from: f, reason: collision with root package name */
        private final m f25436f;

        c(m mVar) throws IOException {
            super();
            this.f25434d = -1L;
            this.f25435e = true;
            this.f25436f = mVar;
        }

        private void c() throws IOException {
            if (this.f25434d != -1) {
                g.this.f25424b.h();
            }
            try {
                this.f25434d = g.this.f25424b.o();
                String trim = g.this.f25424b.h().trim();
                if (this.f25434d < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f25434d + trim + "\"");
                }
                if (this.f25434d == 0) {
                    this.f25435e = false;
                    this.f25436f.a(g.this.e());
                    a();
                }
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }

        @Override // okio.z
        public long b(okio.g gVar, long j) throws IOException {
            if (j >= 0) {
                if (!this.f25429b) {
                    if (!this.f25435e) {
                        return -1L;
                    }
                    long j2 = this.f25434d;
                    if (j2 == 0 || j2 == -1) {
                        c();
                        if (!this.f25435e) {
                            return -1L;
                        }
                    }
                    long b2 = g.this.f25424b.b(gVar, Math.min(j, this.f25434d));
                    if (b2 != -1) {
                        this.f25434d -= b2;
                        return b2;
                    }
                    b();
                    throw new ProtocolException("unexpected end of stream");
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        @Override // okio.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f25429b) {
                return;
            }
            if (this.f25435e && !com.squareup.okhttp.a.o.a(this, 100, TimeUnit.MILLISECONDS)) {
                b();
            }
            this.f25429b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1xStream.java */
    /* loaded from: classes3.dex */
    public final class d implements y {

        /* renamed from: a, reason: collision with root package name */
        private final okio.m f25438a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f25439b;

        /* renamed from: c, reason: collision with root package name */
        private long f25440c;

        @Override // okio.y
        public void a(okio.g gVar, long j) throws IOException {
            if (!this.f25439b) {
                com.squareup.okhttp.a.o.a(gVar.size(), 0L, j);
                if (j <= this.f25440c) {
                    g.this.f25425c.a(gVar, j);
                    this.f25440c -= j;
                    return;
                }
                throw new ProtocolException("expected " + this.f25440c + " bytes but received " + j);
            }
            throw new IllegalStateException("closed");
        }

        @Override // okio.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f25439b) {
                return;
            }
            this.f25439b = true;
            if (this.f25440c <= 0) {
                g.this.a(this.f25438a);
                g.this.f25427e = 3;
                return;
            }
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // okio.y
        public B e() {
            return this.f25438a;
        }

        @Override // okio.y, java.io.Flushable
        public void flush() throws IOException {
            if (this.f25439b) {
                return;
            }
            g.this.f25425c.flush();
        }

        private d(long j) {
            this.f25438a = new okio.m(g.this.f25425c.e());
            this.f25440c = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1xStream.java */
    /* loaded from: classes3.dex */
    public class e extends a {

        /* renamed from: d, reason: collision with root package name */
        private long f25442d;

        public e(long j) throws IOException {
            super();
            this.f25442d = j;
            if (this.f25442d == 0) {
                a();
            }
        }

        @Override // okio.z
        public long b(okio.g gVar, long j) throws IOException {
            if (j >= 0) {
                if (this.f25429b) {
                    throw new IllegalStateException("closed");
                }
                if (this.f25442d == 0) {
                    return -1L;
                }
                long b2 = g.this.f25424b.b(gVar, Math.min(this.f25442d, j));
                if (b2 != -1) {
                    this.f25442d -= b2;
                    if (this.f25442d == 0) {
                        a();
                    }
                    return b2;
                }
                b();
                throw new ProtocolException("unexpected end of stream");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        @Override // okio.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f25429b) {
                return;
            }
            if (this.f25442d != 0 && !com.squareup.okhttp.a.o.a(this, 100, TimeUnit.MILLISECONDS)) {
                b();
            }
            this.f25429b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1xStream.java */
    /* loaded from: classes3.dex */
    public class f extends a {

        /* renamed from: d, reason: collision with root package name */
        private boolean f25444d;

        private f() {
            super();
        }

        @Override // okio.z
        public long b(okio.g gVar, long j) throws IOException {
            if (j >= 0) {
                if (!this.f25429b) {
                    if (this.f25444d) {
                        return -1L;
                    }
                    long b2 = g.this.f25424b.b(gVar, j);
                    if (b2 != -1) {
                        return b2;
                    }
                    this.f25444d = true;
                    a();
                    return -1L;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        @Override // okio.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f25429b) {
                return;
            }
            if (!this.f25444d) {
                b();
            }
            this.f25429b = true;
        }
    }

    public g(w wVar, okio.i iVar, okio.h hVar) {
        this.f25423a = wVar;
        this.f25424b = iVar;
        this.f25425c = hVar;
    }

    public x e() throws IOException {
        x.a aVar = new x.a();
        while (true) {
            String h2 = this.f25424b.h();
            if (h2.length() != 0) {
                com.squareup.okhttp.a.h.f25192b.a(aVar, h2);
            } else {
                return aVar.a();
            }
        }
    }

    public H.a f() throws IOException {
        v a2;
        H.a aVar;
        int i = this.f25427e;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.f25427e);
        }
        do {
            try {
                a2 = v.a(this.f25424b.h());
                aVar = new H.a();
                aVar.a(a2.f25495a);
                aVar.a(a2.f25496b);
                aVar.a(a2.f25497c);
                aVar.a(e());
            } catch (EOFException e2) {
                IOException iOException = new IOException("unexpected end of stream on " + this.f25423a);
                iOException.initCause(e2);
                throw iOException;
            }
        } while (a2.f25496b == 100);
        this.f25427e = 4;
        return aVar;
    }

    @Override // com.squareup.okhttp.internal.http.o
    public H.a b() throws IOException {
        return f();
    }

    public y c() {
        if (this.f25427e == 1) {
            this.f25427e = 2;
            return new b();
        }
        throw new IllegalStateException("state: " + this.f25427e);
    }

    public z d() throws IOException {
        if (this.f25427e == 4) {
            w wVar = this.f25423a;
            if (wVar != null) {
                this.f25427e = 5;
                wVar.c();
                return new f();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.f25427e);
    }

    private z b(H h2) throws IOException {
        if (!m.a(h2)) {
            return b(0L);
        }
        if ("chunked".equalsIgnoreCase(h2.a("Transfer-Encoding"))) {
            return b(this.f25426d);
        }
        long a2 = q.a(h2);
        if (a2 != -1) {
            return b(a2);
        }
        return d();
    }

    @Override // com.squareup.okhttp.internal.http.o
    public void a(m mVar) {
        this.f25426d = mVar;
    }

    @Override // com.squareup.okhttp.internal.http.o
    public y a(E e2, long j) throws IOException {
        if ("chunked".equalsIgnoreCase(e2.a("Transfer-Encoding"))) {
            return c();
        }
        if (j != -1) {
            return a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // com.squareup.okhttp.internal.http.o
    public void a(E e2) throws IOException {
        this.f25426d.h();
        a(e2.c(), s.a(e2, this.f25426d.c().getRoute().b().type()));
    }

    public z b(long j) throws IOException {
        if (this.f25427e == 4) {
            this.f25427e = 5;
            return new e(j);
        }
        throw new IllegalStateException("state: " + this.f25427e);
    }

    @Override // com.squareup.okhttp.internal.http.o
    public I a(H h2) throws IOException {
        return new r(h2.g(), okio.s.a(b(h2)));
    }

    public z b(m mVar) throws IOException {
        if (this.f25427e == 4) {
            this.f25427e = 5;
            return new c(mVar);
        }
        throw new IllegalStateException("state: " + this.f25427e);
    }

    @Override // com.squareup.okhttp.internal.http.o
    public void a() throws IOException {
        this.f25425c.flush();
    }

    public void a(x xVar, String str) throws IOException {
        if (this.f25427e == 0) {
            this.f25425c.a(str).a("\r\n");
            int b2 = xVar.b();
            for (int i = 0; i < b2; i++) {
                this.f25425c.a(xVar.a(i)).a(": ").a(xVar.b(i)).a("\r\n");
            }
            this.f25425c.a("\r\n");
            this.f25427e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f25427e);
    }

    public y a(long j) {
        if (this.f25427e == 1) {
            this.f25427e = 2;
            return new d(j);
        }
        throw new IllegalStateException("state: " + this.f25427e);
    }

    @Override // com.squareup.okhttp.internal.http.o
    public void a(t tVar) throws IOException {
        if (this.f25427e == 1) {
            this.f25427e = 3;
            tVar.a(this.f25425c);
        } else {
            throw new IllegalStateException("state: " + this.f25427e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(okio.m mVar) {
        B g2 = mVar.g();
        mVar.a(B.f29225a);
        g2.a();
        g2.b();
    }
}
