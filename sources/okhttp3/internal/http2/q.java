package okhttp3.internal.http2;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.http2.a;
import okhttp3.z;
import okio.B;
import okio.C2576c;
import okio.y;

/* compiled from: Http2Stream.java */
/* loaded from: classes3.dex */
public final class q {

    /* renamed from: b, reason: collision with root package name */
    long f29124b;

    /* renamed from: c, reason: collision with root package name */
    final int f29125c;

    /* renamed from: d, reason: collision with root package name */
    final k f29126d;

    /* renamed from: f, reason: collision with root package name */
    private a.InterfaceC0168a f29128f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f29129g;

    /* renamed from: h, reason: collision with root package name */
    private final b f29130h;
    final a i;

    /* renamed from: a, reason: collision with root package name */
    long f29123a = 0;

    /* renamed from: e, reason: collision with root package name */
    private final Deque<z> f29127e = new ArrayDeque();
    final c j = new c();
    final c k = new c();
    ErrorCode l = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http2Stream.java */
    /* loaded from: classes3.dex */
    public final class b implements okio.z {

        /* renamed from: a, reason: collision with root package name */
        private final okio.g f29135a = new okio.g();

        /* renamed from: b, reason: collision with root package name */
        private final okio.g f29136b = new okio.g();

        /* renamed from: c, reason: collision with root package name */
        private final long f29137c;

        /* renamed from: d, reason: collision with root package name */
        boolean f29138d;

        /* renamed from: e, reason: collision with root package name */
        boolean f29139e;

        b(long j) {
            this.f29137c = j;
        }

        private void d(long j) {
            q.this.f29126d.g(j);
        }

        void a(okio.i iVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            while (j > 0) {
                synchronized (q.this) {
                    z = this.f29139e;
                    z2 = true;
                    z3 = this.f29136b.size() + j > this.f29137c;
                }
                if (z3) {
                    iVar.skip(j);
                    q.this.b(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    iVar.skip(j);
                    return;
                }
                long b2 = iVar.b(this.f29135a, j);
                if (b2 != -1) {
                    j -= b2;
                    synchronized (q.this) {
                        if (this.f29136b.size() != 0) {
                            z2 = false;
                        }
                        this.f29136b.a((okio.z) this.f29135a);
                        if (z2) {
                            q.this.notifyAll();
                        }
                    }
                } else {
                    throw new EOFException();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x00cb, code lost:            if (r11 == (-1)) goto L43;     */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00cd, code lost:            d(r11);     */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00d0, code lost:            return r11;     */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00d1, code lost:            if (r0 != null) goto L45;     */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00d3, code lost:            return -1;     */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00d9, code lost:            throw new okhttp3.internal.http2.StreamResetException(r0);     */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00e1, code lost:            throw new java.io.IOException("stream closed");     */
        @Override // okio.z
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long b(okio.g r18, long r19) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 263
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.q.b.b(okio.g, long):long");
        }

        @Override // okio.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            ArrayList arrayList;
            a.InterfaceC0168a interfaceC0168a;
            synchronized (q.this) {
                this.f29138d = true;
                size = this.f29136b.size();
                this.f29136b.a();
                arrayList = null;
                if (q.this.f29127e.isEmpty() || q.this.f29128f == null) {
                    interfaceC0168a = null;
                } else {
                    arrayList = new ArrayList(q.this.f29127e);
                    q.this.f29127e.clear();
                    interfaceC0168a = q.this.f29128f;
                }
                q.this.notifyAll();
            }
            if (size > 0) {
                d(size);
            }
            q.this.a();
            if (interfaceC0168a != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    interfaceC0168a.a((z) it.next());
                }
            }
        }

        @Override // okio.z
        public B e() {
            return q.this.j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Stream.java */
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
            q.this.b(ErrorCode.CANCEL);
        }

        public void k() throws IOException {
            if (i()) {
                throw b((IOException) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(int i, k kVar, boolean z, boolean z2, @Nullable z zVar) {
        if (kVar != null) {
            this.f29125c = i;
            this.f29126d = kVar;
            this.f29124b = kVar.p.c();
            this.f29130h = new b(kVar.o.c());
            this.i = new a();
            this.f29130h.f29139e = z2;
            this.i.f29133c = z;
            if (zVar != null) {
                this.f29127e.add(zVar);
            }
            if (f() && zVar != null) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            }
            if (!f() && zVar == null) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
            return;
        }
        throw new NullPointerException("connection == null");
    }

    public int c() {
        return this.f29125c;
    }

    public y d() {
        synchronized (this) {
            if (!this.f29129g && !f()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.i;
    }

    public okio.z e() {
        return this.f29130h;
    }

    public boolean f() {
        return this.f29126d.f29085b == ((this.f29125c & 1) == 1);
    }

    public synchronized boolean g() {
        if (this.l != null) {
            return false;
        }
        if ((this.f29130h.f29139e || this.f29130h.f29138d) && (this.i.f29133c || this.i.f29132b)) {
            if (this.f29129g) {
                return false;
            }
        }
        return true;
    }

    public B h() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        boolean g2;
        synchronized (this) {
            this.f29130h.f29139e = true;
            g2 = g();
            notifyAll();
        }
        if (g2) {
            return;
        }
        this.f29126d.c(this.f29125c);
    }

    public synchronized z j() throws IOException {
        this.j.h();
        while (this.f29127e.isEmpty() && this.l == null) {
            try {
                k();
            } catch (Throwable th) {
                this.j.k();
                throw th;
            }
        }
        this.j.k();
        if (!this.f29127e.isEmpty()) {
        } else {
            throw new StreamResetException(this.l);
        }
        return this.f29127e.removeFirst();
    }

    void k() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public B l() {
        return this.k;
    }

    public void a(ErrorCode errorCode) throws IOException {
        if (d(errorCode)) {
            this.f29126d.b(this.f29125c, errorCode);
        }
    }

    public void b(ErrorCode errorCode) {
        if (d(errorCode)) {
            this.f29126d.c(this.f29125c, errorCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c(ErrorCode errorCode) {
        if (this.l == null) {
            this.l = errorCode;
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Stream.java */
    /* loaded from: classes3.dex */
    public final class a implements y {

        /* renamed from: a, reason: collision with root package name */
        private final okio.g f29131a = new okio.g();

        /* renamed from: b, reason: collision with root package name */
        boolean f29132b;

        /* renamed from: c, reason: collision with root package name */
        boolean f29133c;

        a() {
        }

        @Override // okio.y
        public void a(okio.g gVar, long j) throws IOException {
            this.f29131a.a(gVar, j);
            while (this.f29131a.size() >= PlaybackStateCompat.ACTION_PREPARE) {
                a(false);
            }
        }

        @Override // okio.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (q.this) {
                if (this.f29132b) {
                    return;
                }
                if (!q.this.i.f29133c) {
                    if (this.f29131a.size() > 0) {
                        while (this.f29131a.size() > 0) {
                            a(true);
                        }
                    } else {
                        q qVar = q.this;
                        qVar.f29126d.a(qVar.f29125c, true, (okio.g) null, 0L);
                    }
                }
                synchronized (q.this) {
                    this.f29132b = true;
                }
                q.this.f29126d.flush();
                q.this.a();
            }
        }

        @Override // okio.y
        public B e() {
            return q.this.k;
        }

        @Override // okio.y, java.io.Flushable
        public void flush() throws IOException {
            synchronized (q.this) {
                q.this.b();
            }
            while (this.f29131a.size() > 0) {
                a(false);
                q.this.f29126d.flush();
            }
        }

        private void a(boolean z) throws IOException {
            long min;
            synchronized (q.this) {
                q.this.k.h();
                while (q.this.f29124b <= 0 && !this.f29133c && !this.f29132b && q.this.l == null) {
                    try {
                        q.this.k();
                    } finally {
                    }
                }
                q.this.k.k();
                q.this.b();
                min = Math.min(q.this.f29124b, this.f29131a.size());
                q.this.f29124b -= min;
            }
            q.this.k.h();
            try {
                q.this.f29126d.a(q.this.f29125c, z && min == this.f29131a.size(), this.f29131a, min);
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<okhttp3.internal.http2.a> list) {
        boolean g2;
        synchronized (this) {
            this.f29129g = true;
            this.f29127e.add(okhttp3.a.e.b(list));
            g2 = g();
            notifyAll();
        }
        if (g2) {
            return;
        }
        this.f29126d.c(this.f29125c);
    }

    void b() throws IOException {
        a aVar = this.i;
        if (!aVar.f29132b) {
            if (!aVar.f29133c) {
                ErrorCode errorCode = this.l;
                if (errorCode != null) {
                    throw new StreamResetException(errorCode);
                }
                return;
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    private boolean d(ErrorCode errorCode) {
        synchronized (this) {
            if (this.l != null) {
                return false;
            }
            if (this.f29130h.f29139e && this.i.f29133c) {
                return false;
            }
            this.l = errorCode;
            notifyAll();
            this.f29126d.c(this.f29125c);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(okio.i iVar, int i) throws IOException {
        this.f29130h.a(iVar, i);
    }

    void a() throws IOException {
        boolean z;
        boolean g2;
        synchronized (this) {
            z = !this.f29130h.f29139e && this.f29130h.f29138d && (this.i.f29133c || this.i.f29132b);
            g2 = g();
        }
        if (z) {
            a(ErrorCode.CANCEL);
        } else {
            if (g2) {
                return;
            }
            this.f29126d.c(this.f29125c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.f29124b += j;
        if (j > 0) {
            notifyAll();
        }
    }
}
