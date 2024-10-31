package com.squareup.okhttp.internal.framed;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okio.C2576c;

/* compiled from: FramedStream.java */
/* loaded from: classes3.dex */
public final class p {

    /* renamed from: b, reason: collision with root package name */
    long f25338b;

    /* renamed from: c, reason: collision with root package name */
    private final int f25339c;

    /* renamed from: d, reason: collision with root package name */
    private final j f25340d;

    /* renamed from: e, reason: collision with root package name */
    private final List<q> f25341e;

    /* renamed from: f, reason: collision with root package name */
    private List<q> f25342f;

    /* renamed from: g, reason: collision with root package name */
    private final b f25343g;

    /* renamed from: h, reason: collision with root package name */
    final a f25344h;

    /* renamed from: a, reason: collision with root package name */
    long f25337a = 0;
    private final c i = new c();
    private final c j = new c();
    private ErrorCode k = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FramedStream.java */
    /* loaded from: classes3.dex */
    public final class a implements okio.y {

        /* renamed from: a, reason: collision with root package name */
        private final okio.g f25345a = new okio.g();

        /* renamed from: b, reason: collision with root package name */
        private boolean f25346b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f25347c;

        a() {
        }

        @Override // okio.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (p.this) {
                if (this.f25346b) {
                    return;
                }
                if (!p.this.f25344h.f25347c) {
                    if (this.f25345a.size() > 0) {
                        while (this.f25345a.size() > 0) {
                            a(true);
                        }
                    } else {
                        p.this.f25340d.a(p.this.f25339c, true, (okio.g) null, 0L);
                    }
                }
                synchronized (p.this) {
                    this.f25346b = true;
                }
                p.this.f25340d.flush();
                p.this.j();
            }
        }

        @Override // okio.y
        public okio.B e() {
            return p.this.j;
        }

        @Override // okio.y, java.io.Flushable
        public void flush() throws IOException {
            synchronized (p.this) {
                p.this.k();
            }
            while (this.f25345a.size() > 0) {
                a(false);
                p.this.f25340d.flush();
            }
        }

        @Override // okio.y
        public void a(okio.g gVar, long j) throws IOException {
            this.f25345a.a(gVar, j);
            while (this.f25345a.size() >= PlaybackStateCompat.ACTION_PREPARE) {
                a(false);
            }
        }

        private void a(boolean z) throws IOException {
            long min;
            synchronized (p.this) {
                p.this.j.h();
                while (p.this.f25338b <= 0 && !this.f25347c && !this.f25346b && p.this.k == null) {
                    try {
                        p.this.l();
                    } finally {
                    }
                }
                p.this.j.k();
                p.this.k();
                min = Math.min(p.this.f25338b, this.f25345a.size());
                p.this.f25338b -= min;
            }
            p.this.j.h();
            try {
                p.this.f25340d.a(p.this.f25339c, z && min == this.f25345a.size(), this.f25345a, min);
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FramedStream.java */
    /* loaded from: classes3.dex */
    public final class b implements okio.z {

        /* renamed from: a, reason: collision with root package name */
        private final okio.g f25349a;

        /* renamed from: b, reason: collision with root package name */
        private final okio.g f25350b;

        /* renamed from: c, reason: collision with root package name */
        private final long f25351c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f25352d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f25353e;

        @Override // okio.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (p.this) {
                this.f25352d = true;
                this.f25350b.a();
                p.this.notifyAll();
            }
            p.this.j();
        }

        @Override // okio.z
        public okio.B e() {
            return p.this.i;
        }

        private b(long j) {
            this.f25349a = new okio.g();
            this.f25350b = new okio.g();
            this.f25351c = j;
        }

        @Override // okio.z
        public long b(okio.g gVar, long j) throws IOException {
            if (j >= 0) {
                synchronized (p.this) {
                    b();
                    a();
                    if (this.f25350b.size() == 0) {
                        return -1L;
                    }
                    long b2 = this.f25350b.b(gVar, Math.min(j, this.f25350b.size()));
                    p.this.f25337a += b2;
                    if (p.this.f25337a >= p.this.f25340d.q.c(65536) / 2) {
                        p.this.f25340d.c(p.this.f25339c, p.this.f25337a);
                        p.this.f25337a = 0L;
                    }
                    synchronized (p.this.f25340d) {
                        p.this.f25340d.o += b2;
                        if (p.this.f25340d.o >= p.this.f25340d.q.c(65536) / 2) {
                            p.this.f25340d.c(0, p.this.f25340d.o);
                            p.this.f25340d.o = 0L;
                        }
                    }
                    return b2;
                }
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        void a(okio.i iVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            while (j > 0) {
                synchronized (p.this) {
                    z = this.f25353e;
                    z2 = true;
                    z3 = this.f25350b.size() + j > this.f25351c;
                }
                if (z3) {
                    iVar.skip(j);
                    p.this.b(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    iVar.skip(j);
                    return;
                }
                long b2 = iVar.b(this.f25349a, j);
                if (b2 != -1) {
                    j -= b2;
                    synchronized (p.this) {
                        if (this.f25350b.size() != 0) {
                            z2 = false;
                        }
                        this.f25350b.a((okio.z) this.f25349a);
                        if (z2) {
                            p.this.notifyAll();
                        }
                    }
                } else {
                    throw new EOFException();
                }
            }
        }

        private void a() throws IOException {
            if (!this.f25352d) {
                if (p.this.k == null) {
                    return;
                }
                throw new IOException("stream was reset: " + p.this.k);
            }
            throw new IOException("stream closed");
        }

        private void b() throws IOException {
            p.this.i.h();
            while (this.f25350b.size() == 0 && !this.f25353e && !this.f25352d && p.this.k == null) {
                try {
                    p.this.l();
                } finally {
                    p.this.i.k();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FramedStream.java */
    /* loaded from: classes3.dex */
    public class c extends C2576c {
        c() {
        }

        @Override // okio.C2576c
        protected IOException b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // okio.C2576c
        protected void j() {
            p.this.b(ErrorCode.CANCEL);
        }

        public void k() throws IOException {
            if (i()) {
                throw b((IOException) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(int i, j jVar, boolean z, boolean z2, List<q> list) {
        if (jVar == null) {
            throw new NullPointerException("connection == null");
        }
        if (list != null) {
            this.f25339c = i;
            this.f25340d = jVar;
            this.f25338b = jVar.r.c(65536);
            this.f25343g = new b(jVar.q.c(65536));
            this.f25344h = new a();
            this.f25343g.f25353e = z2;
            this.f25344h.f25347c = z;
            this.f25341e = list;
            return;
        }
        throw new NullPointerException("requestHeaders == null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() throws IOException {
        boolean z;
        boolean f2;
        synchronized (this) {
            z = !this.f25343g.f25353e && this.f25343g.f25352d && (this.f25344h.f25347c || this.f25344h.f25346b);
            f2 = f();
        }
        if (z) {
            a(ErrorCode.CANCEL);
        } else {
            if (f2) {
                return;
            }
            this.f25340d.b(this.f25339c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() throws IOException {
        if (!this.f25344h.f25346b) {
            if (!this.f25344h.f25347c) {
                if (this.k == null) {
                    return;
                }
                throw new IOException("stream was reset: " + this.k);
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    public okio.B i() {
        return this.j;
    }

    public int a() {
        return this.f25339c;
    }

    public synchronized List<q> b() throws IOException {
        this.i.h();
        while (this.f25342f == null && this.k == null) {
            try {
                l();
            } catch (Throwable th) {
                this.i.k();
                throw th;
            }
        }
        this.i.k();
        if (this.f25342f == null) {
            throw new IOException("stream was reset: " + this.k);
        }
        return this.f25342f;
    }

    public okio.y c() {
        synchronized (this) {
            if (this.f25342f == null && !e()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f25344h;
    }

    public okio.z d() {
        return this.f25343g;
    }

    public boolean e() {
        return this.f25340d.f25315c == ((this.f25339c & 1) == 1);
    }

    public synchronized boolean f() {
        if (this.k != null) {
            return false;
        }
        if ((this.f25343g.f25353e || this.f25343g.f25352d) && (this.f25344h.f25347c || this.f25344h.f25346b)) {
            if (this.f25342f != null) {
                return false;
            }
        }
        return true;
    }

    public okio.B g() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        boolean f2;
        synchronized (this) {
            this.f25343g.f25353e = true;
            f2 = f();
            notifyAll();
        }
        if (f2) {
            return;
        }
        this.f25340d.b(this.f25339c);
    }

    private boolean d(ErrorCode errorCode) {
        synchronized (this) {
            if (this.k != null) {
                return false;
            }
            if (this.f25343g.f25353e && this.f25344h.f25347c) {
                return false;
            }
            this.k = errorCode;
            notifyAll();
            this.f25340d.b(this.f25339c);
            return true;
        }
    }

    public void a(ErrorCode errorCode) throws IOException {
        if (d(errorCode)) {
            this.f25340d.b(this.f25339c, errorCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<q> list, HeadersMode headersMode) {
        ErrorCode errorCode = null;
        boolean z = true;
        synchronized (this) {
            if (this.f25342f == null) {
                if (headersMode.failIfHeadersAbsent()) {
                    errorCode = ErrorCode.PROTOCOL_ERROR;
                } else {
                    this.f25342f = list;
                    z = f();
                    notifyAll();
                }
            } else if (headersMode.failIfHeadersPresent()) {
                errorCode = ErrorCode.STREAM_IN_USE;
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f25342f);
                arrayList.addAll(list);
                this.f25342f = arrayList;
            }
        }
        if (errorCode != null) {
            b(errorCode);
        } else {
            if (z) {
                return;
            }
            this.f25340d.b(this.f25339c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c(ErrorCode errorCode) {
        if (this.k == null) {
            this.k = errorCode;
            notifyAll();
        }
    }

    public void b(ErrorCode errorCode) {
        if (d(errorCode)) {
            this.f25340d.c(this.f25339c, errorCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(okio.i iVar, int i) throws IOException {
        this.f25343g.a(iVar, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.f25338b += j;
        if (j > 0) {
            notifyAll();
        }
    }
}
