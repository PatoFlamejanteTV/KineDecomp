package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* loaded from: classes3.dex */
public class GzipInflatingBuffer implements Closeable {

    /* renamed from: e */
    private int f27349e;

    /* renamed from: f */
    private int f27350f;

    /* renamed from: g */
    private Inflater f27351g;
    private int j;
    private int k;
    private long l;

    /* renamed from: a */
    private final C2420ca f27345a = new C2420ca();

    /* renamed from: b */
    private final CRC32 f27346b = new CRC32();

    /* renamed from: c */
    private final a f27347c = new a(this, null);

    /* renamed from: d */
    private final byte[] f27348d = new byte[512];

    /* renamed from: h */
    private State f27352h = State.HEADER;
    private boolean i = false;
    private int m = 0;
    private int n = 0;
    private boolean o = true;

    /* loaded from: classes3.dex */
    public enum State {
        HEADER,
        HEADER_EXTRA_LEN,
        HEADER_EXTRA,
        HEADER_NAME,
        HEADER_COMMENT,
        HEADER_CRC,
        INITIALIZE_INFLATER,
        INFLATING,
        INFLATER_NEEDS_INPUT,
        TRAILER
    }

    /* loaded from: classes3.dex */
    public class a {
        private a() {
        }

        /* synthetic */ a(GzipInflatingBuffer gzipInflatingBuffer, Ya ya) {
            this();
        }

        public int b() {
            int readUnsignedByte;
            if (GzipInflatingBuffer.this.f27350f - GzipInflatingBuffer.this.f27349e > 0) {
                readUnsignedByte = GzipInflatingBuffer.this.f27348d[GzipInflatingBuffer.this.f27349e] & 255;
                GzipInflatingBuffer.a(GzipInflatingBuffer.this, 1);
            } else {
                readUnsignedByte = GzipInflatingBuffer.this.f27345a.readUnsignedByte();
            }
            GzipInflatingBuffer.this.f27346b.update(readUnsignedByte);
            GzipInflatingBuffer.b(GzipInflatingBuffer.this, 1);
            return readUnsignedByte;
        }

        public long c() {
            return d() | (d() << 16);
        }

        public int d() {
            return b() | (b() << 8);
        }

        public int e() {
            return (GzipInflatingBuffer.this.f27350f - GzipInflatingBuffer.this.f27349e) + GzipInflatingBuffer.this.f27345a.B();
        }

        public void a(int i) {
            int i2;
            int i3 = GzipInflatingBuffer.this.f27350f - GzipInflatingBuffer.this.f27349e;
            if (i3 > 0) {
                int min = Math.min(i3, i);
                GzipInflatingBuffer.this.f27346b.update(GzipInflatingBuffer.this.f27348d, GzipInflatingBuffer.this.f27349e, min);
                GzipInflatingBuffer.a(GzipInflatingBuffer.this, min);
                i2 = i - min;
            } else {
                i2 = i;
            }
            if (i2 > 0) {
                byte[] bArr = new byte[512];
                int i4 = 0;
                while (i4 < i2) {
                    int min2 = Math.min(i2 - i4, bArr.length);
                    GzipInflatingBuffer.this.f27345a.a(bArr, 0, min2);
                    GzipInflatingBuffer.this.f27346b.update(bArr, 0, min2);
                    i4 += min2;
                }
            }
            GzipInflatingBuffer.b(GzipInflatingBuffer.this, i);
        }

        public boolean a() {
            while (e() > 0) {
                if (b() == 0) {
                    return true;
                }
            }
            return false;
        }
    }

    private boolean A() {
        if ((this.j & 8) != 8) {
            this.f27352h = State.HEADER_COMMENT;
            return true;
        }
        if (!this.f27347c.a()) {
            return false;
        }
        this.f27352h = State.HEADER_COMMENT;
        return true;
    }

    private boolean L() throws ZipException {
        if (this.f27351g != null && this.f27347c.e() <= 18) {
            this.f27351g.end();
            this.f27351g = null;
        }
        if (this.f27347c.e() < 8) {
            return false;
        }
        if (this.f27346b.getValue() == this.f27347c.c() && this.l == this.f27347c.c()) {
            this.f27346b.reset();
            this.f27352h = State.HEADER;
            return true;
        }
        throw new ZipException("Corrupt GZIP trailer");
    }

    private boolean s() {
        Preconditions.b(this.f27351g != null, "inflater is null");
        Preconditions.b(this.f27349e == this.f27350f, "inflaterInput has unconsumed bytes");
        int min = Math.min(this.f27345a.B(), 512);
        if (min == 0) {
            return false;
        }
        this.f27349e = 0;
        this.f27350f = min;
        this.f27345a.a(this.f27348d, this.f27349e, min);
        this.f27351g.setInput(this.f27348d, this.f27349e, min);
        this.f27352h = State.INFLATING;
        return true;
    }

    private boolean u() {
        Inflater inflater = this.f27351g;
        if (inflater == null) {
            this.f27351g = new Inflater(true);
        } else {
            inflater.reset();
        }
        this.f27346b.reset();
        int i = this.f27350f;
        int i2 = this.f27349e;
        int i3 = i - i2;
        if (i3 > 0) {
            this.f27351g.setInput(this.f27348d, i2, i3);
            this.f27352h = State.INFLATING;
        } else {
            this.f27352h = State.INFLATER_NEEDS_INPUT;
        }
        return true;
    }

    private boolean v() throws ZipException {
        if (this.f27347c.e() < 10) {
            return false;
        }
        if (this.f27347c.d() == 35615) {
            if (this.f27347c.b() == 8) {
                this.j = this.f27347c.b();
                this.f27347c.a(6);
                this.f27352h = State.HEADER_EXTRA_LEN;
                return true;
            }
            throw new ZipException("Unsupported compression method");
        }
        throw new ZipException("Not in GZIP format");
    }

    private boolean w() {
        if ((this.j & 16) != 16) {
            this.f27352h = State.HEADER_CRC;
            return true;
        }
        if (!this.f27347c.a()) {
            return false;
        }
        this.f27352h = State.HEADER_CRC;
        return true;
    }

    private boolean x() throws ZipException {
        if ((this.j & 2) == 2) {
            if (this.f27347c.e() < 2) {
                return false;
            }
            if ((65535 & ((int) this.f27346b.getValue())) == this.f27347c.d()) {
                this.f27352h = State.INITIALIZE_INFLATER;
                return true;
            }
            throw new ZipException("Corrupt GZIP header");
        }
        this.f27352h = State.INITIALIZE_INFLATER;
        return true;
    }

    private boolean y() {
        int e2 = this.f27347c.e();
        int i = this.k;
        if (e2 < i) {
            return false;
        }
        this.f27347c.a(i);
        this.f27352h = State.HEADER_NAME;
        return true;
    }

    private boolean z() {
        if ((this.j & 4) == 4) {
            if (this.f27347c.e() < 2) {
                return false;
            }
            this.k = this.f27347c.d();
            this.f27352h = State.HEADER_EXTRA;
            return true;
        }
        this.f27352h = State.HEADER_NAME;
        return true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.i) {
            return;
        }
        this.i = true;
        this.f27345a.close();
        Inflater inflater = this.f27351g;
        if (inflater != null) {
            inflater.end();
            this.f27351g = null;
        }
    }

    public boolean r() {
        Preconditions.b(!this.i, "GzipInflatingBuffer is closed");
        return this.o;
    }

    static /* synthetic */ int a(GzipInflatingBuffer gzipInflatingBuffer, int i) {
        int i2 = gzipInflatingBuffer.f27349e + i;
        gzipInflatingBuffer.f27349e = i2;
        return i2;
    }

    static /* synthetic */ int b(GzipInflatingBuffer gzipInflatingBuffer, int i) {
        int i2 = gzipInflatingBuffer.m + i;
        gzipInflatingBuffer.m = i2;
        return i2;
    }

    public boolean c() {
        Preconditions.b(!this.i, "GzipInflatingBuffer is closed");
        return (this.f27347c.e() == 0 && this.f27352h == State.HEADER) ? false : true;
    }

    public void a(InterfaceC2426dc interfaceC2426dc) {
        Preconditions.b(!this.i, "GzipInflatingBuffer is closed");
        this.f27345a.a(interfaceC2426dc);
        this.o = false;
    }

    public int b() {
        int i = this.n;
        this.n = 0;
        return i;
    }

    private int c(byte[] bArr, int i, int i2) throws DataFormatException, ZipException {
        Preconditions.b(this.f27351g != null, "inflater is null");
        try {
            int totalIn = this.f27351g.getTotalIn();
            int inflate = this.f27351g.inflate(bArr, i, i2);
            int totalIn2 = this.f27351g.getTotalIn() - totalIn;
            this.m += totalIn2;
            this.n += totalIn2;
            this.f27349e += totalIn2;
            this.f27346b.update(bArr, i, inflate);
            if (this.f27351g.finished()) {
                this.l = this.f27351g.getBytesWritten() & 4294967295L;
                this.f27352h = State.TRAILER;
            } else if (this.f27351g.needsInput()) {
                this.f27352h = State.INFLATER_NEEDS_INPUT;
            }
            return inflate;
        } catch (DataFormatException e2) {
            throw new DataFormatException("Inflater data format exception: " + e2.getMessage());
        }
    }

    public int b(byte[] bArr, int i, int i2) throws DataFormatException, ZipException {
        Preconditions.b(!this.i, "GzipInflatingBuffer is closed");
        boolean z = false;
        boolean z2 = true;
        int i3 = 0;
        while (z2) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                switch (Ya.f27538a[this.f27352h.ordinal()]) {
                    case 1:
                        z2 = v();
                        break;
                    case 2:
                        z2 = z();
                        break;
                    case 3:
                        z2 = y();
                        break;
                    case 4:
                        z2 = A();
                        break;
                    case 5:
                        z2 = w();
                        break;
                    case 6:
                        z2 = x();
                        break;
                    case 7:
                        z2 = u();
                        break;
                    case 8:
                        i3 += c(bArr, i + i3, i4);
                        if (this.f27352h != State.TRAILER) {
                            z2 = true;
                            break;
                        } else {
                            z2 = L();
                            break;
                        }
                    case 9:
                        z2 = s();
                        break;
                    case 10:
                        z2 = L();
                        break;
                    default:
                        throw new AssertionError("Invalid state: " + this.f27352h);
                }
            } else {
                if (z2 || (this.f27352h == State.HEADER && this.f27347c.e() < 10)) {
                    z = true;
                }
                this.o = z;
                return i3;
            }
        }
        if (z2) {
        }
        z = true;
        this.o = z;
        return i3;
    }

    public int a() {
        int i = this.m;
        this.m = 0;
        return i;
    }
}
