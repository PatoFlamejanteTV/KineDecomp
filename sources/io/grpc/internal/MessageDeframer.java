package io.grpc.internal;

import com.facebook.share.internal.ShareConstants;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.InterfaceC2514o;
import io.grpc.InterfaceC2527w;
import io.grpc.Status;
import io.grpc.internal.Oc;
import java.io.Closeable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.DataFormatException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* loaded from: classes3.dex */
public class MessageDeframer implements Closeable, InterfaceC2436ga {

    /* renamed from: a */
    private a f27440a;

    /* renamed from: b */
    private int f27441b;

    /* renamed from: c */
    private final Mc f27442c;

    /* renamed from: d */
    private final Rc f27443d;

    /* renamed from: e */
    private InterfaceC2527w f27444e;

    /* renamed from: f */
    private GzipInflatingBuffer f27445f;

    /* renamed from: g */
    private byte[] f27446g;

    /* renamed from: h */
    private int f27447h;
    private boolean k;
    private C2420ca l;
    private long n;
    private int q;
    private State i = State.HEADER;
    private int j = 5;
    private C2420ca m = new C2420ca();
    private boolean o = false;
    private int p = -1;
    private boolean r = false;
    private volatile boolean s = false;

    /* loaded from: classes3.dex */
    public enum State {
        HEADER,
        BODY
    }

    /* loaded from: classes3.dex */
    public interface a {
        void a(Oc.a aVar);

        void a(Throwable th);

        void a(boolean z);

        void c(int i);
    }

    /* loaded from: classes3.dex */
    public static class b implements Oc.a {

        /* renamed from: a */
        private InputStream f27448a;

        /* synthetic */ b(InputStream inputStream, Ob ob) {
            this(inputStream);
        }

        @Override // io.grpc.internal.Oc.a
        @Nullable
        public InputStream next() {
            InputStream inputStream = this.f27448a;
            this.f27448a = null;
            return inputStream;
        }

        private b(InputStream inputStream) {
            this.f27448a = inputStream;
        }
    }

    public MessageDeframer(a aVar, InterfaceC2527w interfaceC2527w, int i, Mc mc, Rc rc) {
        Preconditions.a(aVar, "sink");
        this.f27440a = aVar;
        Preconditions.a(interfaceC2527w, "decompressor");
        this.f27444e = interfaceC2527w;
        this.f27441b = i;
        Preconditions.a(mc, "statsTraceCtx");
        this.f27442c = mc;
        Preconditions.a(rc, "transportTracer");
        this.f27443d = rc;
    }

    private void c() {
        if (this.o) {
            return;
        }
        this.o = true;
        while (true) {
            try {
                if (this.s || this.n <= 0 || !y()) {
                    break;
                }
                int i = Ob.f27461a[this.i.ordinal()];
                if (i == 1) {
                    x();
                } else if (i == 2) {
                    w();
                    this.n--;
                } else {
                    throw new AssertionError("Invalid state: " + this.i);
                }
            } finally {
                this.o = false;
            }
        }
        if (this.s) {
            close();
            return;
        }
        if (this.r && v()) {
            close();
        }
    }

    private InputStream r() {
        InterfaceC2527w interfaceC2527w = this.f27444e;
        if (interfaceC2527w != InterfaceC2514o.b.f27821a) {
            try {
                return new c(interfaceC2527w.a(C2434fc.a((InterfaceC2426dc) this.l, true)), this.f27441b, this.f27442c);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
        throw Status.p.b("Can't decode compressed gRPC message as compression not configured").c();
    }

    private InputStream s() {
        this.f27442c.a(this.l.B());
        return C2434fc.a((InterfaceC2426dc) this.l, true);
    }

    private boolean u() {
        return isClosed() || this.r;
    }

    private boolean v() {
        GzipInflatingBuffer gzipInflatingBuffer = this.f27445f;
        if (gzipInflatingBuffer != null) {
            return gzipInflatingBuffer.r();
        }
        return this.m.B() == 0;
    }

    private void w() {
        this.f27442c.a(this.p, this.q, -1L);
        this.q = 0;
        InputStream r = this.k ? r() : s();
        this.l = null;
        this.f27440a.a(new b(r, null));
        this.i = State.HEADER;
        this.j = 5;
    }

    private void x() {
        int readUnsignedByte = this.l.readUnsignedByte();
        if ((readUnsignedByte & 254) == 0) {
            this.k = (readUnsignedByte & 1) != 0;
            this.j = this.l.a();
            int i = this.j;
            if (i >= 0 && i <= this.f27441b) {
                this.p++;
                this.f27442c.a(this.p);
                this.f27443d.d();
                this.i = State.BODY;
                return;
            }
            throw Status.k.b(String.format("gRPC message exceeds maximum size %d: %d", Integer.valueOf(this.f27441b), Integer.valueOf(this.j))).c();
        }
        throw Status.p.b("gRPC frame header malformed: reserved bits not zero").c();
    }

    private boolean y() {
        Throwable th;
        int i;
        int i2;
        try {
            if (this.l == null) {
                this.l = new C2420ca();
            }
            i = 0;
            i2 = 0;
            while (true) {
                try {
                    int B = this.j - this.l.B();
                    if (B <= 0) {
                        if (i > 0) {
                            this.f27440a.c(i);
                            if (this.i == State.BODY) {
                                if (this.f27445f != null) {
                                    this.f27442c.b(i2);
                                    this.q += i2;
                                } else {
                                    this.f27442c.b(i);
                                    this.q += i;
                                }
                            }
                        }
                        return true;
                    }
                    if (this.f27445f != null) {
                        try {
                            try {
                                if (this.f27446g == null || this.f27447h == this.f27446g.length) {
                                    this.f27446g = new byte[Math.min(B, 2097152)];
                                    this.f27447h = 0;
                                }
                                int b2 = this.f27445f.b(this.f27446g, this.f27447h, Math.min(B, this.f27446g.length - this.f27447h));
                                i += this.f27445f.a();
                                i2 += this.f27445f.b();
                                if (b2 == 0) {
                                    if (i > 0) {
                                        this.f27440a.c(i);
                                        if (this.i == State.BODY) {
                                            if (this.f27445f != null) {
                                                this.f27442c.b(i2);
                                                this.q += i2;
                                            } else {
                                                this.f27442c.b(i);
                                                this.q += i;
                                            }
                                        }
                                    }
                                    return false;
                                }
                                this.l.a(C2434fc.a(this.f27446g, this.f27447h, b2));
                                this.f27447h += b2;
                            } catch (IOException e2) {
                                throw new RuntimeException(e2);
                            }
                        } catch (DataFormatException e3) {
                            throw new RuntimeException(e3);
                        }
                    } else {
                        if (this.m.B() == 0) {
                            if (i > 0) {
                                this.f27440a.c(i);
                                if (this.i == State.BODY) {
                                    if (this.f27445f != null) {
                                        this.f27442c.b(i2);
                                        this.q += i2;
                                    } else {
                                        this.f27442c.b(i);
                                        this.q += i;
                                    }
                                }
                            }
                            return false;
                        }
                        int min = Math.min(B, this.m.B());
                        i += min;
                        this.l.a(this.m.g(min));
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (i > 0) {
                        this.f27440a.c(i);
                        if (this.i == State.BODY) {
                            if (this.f27445f != null) {
                                this.f27442c.b(i2);
                                this.q += i2;
                            } else {
                                this.f27442c.b(i);
                                this.q += i;
                            }
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            i = 0;
            i2 = 0;
        }
    }

    public void a(a aVar) {
        this.f27440a = aVar;
    }

    @Override // io.grpc.internal.InterfaceC2436ga
    public void b(int i) {
        this.f27441b = i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, io.grpc.internal.InterfaceC2436ga
    public void close() {
        if (isClosed()) {
            return;
        }
        C2420ca c2420ca = this.l;
        boolean z = c2420ca != null && c2420ca.B() > 0;
        try {
            if (this.f27445f != null) {
                if (!z && !this.f27445f.c()) {
                    z = false;
                    this.f27445f.close();
                }
                z = true;
                this.f27445f.close();
            }
            if (this.m != null) {
                this.m.close();
            }
            if (this.l != null) {
                this.l.close();
            }
            this.f27445f = null;
            this.m = null;
            this.l = null;
            this.f27440a.a(z);
        } catch (Throwable th) {
            this.f27445f = null;
            this.m = null;
            this.l = null;
            throw th;
        }
    }

    public boolean isClosed() {
        return this.m == null && this.f27445f == null;
    }

    @Override // io.grpc.internal.InterfaceC2436ga
    public void a(InterfaceC2527w interfaceC2527w) {
        Preconditions.b(this.f27445f == null, "Already set full stream decompressor");
        Preconditions.a(interfaceC2527w, "Can't pass an empty decompressor");
        this.f27444e = interfaceC2527w;
    }

    public void b() {
        this.s = true;
    }

    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static final class c extends FilterInputStream {

        /* renamed from: a */
        private final int f27449a;

        /* renamed from: b */
        private final Mc f27450b;

        /* renamed from: c */
        private long f27451c;

        /* renamed from: d */
        private long f27452d;

        /* renamed from: e */
        private long f27453e;

        c(InputStream inputStream, int i, Mc mc) {
            super(inputStream);
            this.f27453e = -1L;
            this.f27449a = i;
            this.f27450b = mc;
        }

        private void a() {
            long j = this.f27452d;
            long j2 = this.f27451c;
            if (j > j2) {
                this.f27450b.a(j - j2);
                this.f27451c = this.f27452d;
            }
        }

        private void b() {
            long j = this.f27452d;
            int i = this.f27449a;
            if (j > i) {
                throw Status.k.b(String.format("Compressed gRPC message exceeds maximum size %d: %d bytes read", Integer.valueOf(i), Long.valueOf(this.f27452d))).c();
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i) {
            ((FilterInputStream) this).in.mark(i);
            this.f27453e = this.f27452d;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = ((FilterInputStream) this).in.read();
            if (read != -1) {
                this.f27452d++;
            }
            b();
            a();
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            if (!((FilterInputStream) this).in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.f27453e != -1) {
                ((FilterInputStream) this).in.reset();
                this.f27452d = this.f27453e;
            } else {
                throw new IOException("Mark not set");
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
            long skip = ((FilterInputStream) this).in.skip(j);
            this.f27452d += skip;
            b();
            a();
            return skip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = ((FilterInputStream) this).in.read(bArr, i, i2);
            if (read != -1) {
                this.f27452d += read;
            }
            b();
            a();
            return read;
        }
    }

    @Override // io.grpc.internal.InterfaceC2436ga
    public void a(GzipInflatingBuffer gzipInflatingBuffer) {
        Preconditions.b(this.f27444e == InterfaceC2514o.b.f27821a, "per-message decompressor already set");
        Preconditions.b(this.f27445f == null, "full stream decompressor already set");
        Preconditions.a(gzipInflatingBuffer, "Can't pass a null full stream decompressor");
        this.f27445f = gzipInflatingBuffer;
        this.m = null;
    }

    @Override // io.grpc.internal.InterfaceC2436ga
    public void a(int i) {
        Preconditions.a(i > 0, "numMessages must be > 0");
        if (isClosed()) {
            return;
        }
        this.n += i;
        c();
    }

    @Override // io.grpc.internal.InterfaceC2436ga
    public void a(InterfaceC2426dc interfaceC2426dc) {
        Preconditions.a(interfaceC2426dc, ShareConstants.WEB_DIALOG_PARAM_DATA);
        boolean z = true;
        try {
            if (!u()) {
                if (this.f27445f != null) {
                    this.f27445f.a(interfaceC2426dc);
                } else {
                    this.m.a(interfaceC2426dc);
                }
                z = false;
                c();
            }
        } finally {
            if (z) {
                interfaceC2426dc.close();
            }
        }
    }

    @Override // io.grpc.internal.InterfaceC2436ga
    public void a() {
        if (isClosed()) {
            return;
        }
        if (v()) {
            close();
        } else {
            this.r = true;
        }
    }
}
