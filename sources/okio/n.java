package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* compiled from: GzipSource.java */
/* loaded from: classes3.dex */
public final class n implements z {

    /* renamed from: b, reason: collision with root package name */
    private final i f29252b;

    /* renamed from: c, reason: collision with root package name */
    private final Inflater f29253c;

    /* renamed from: d, reason: collision with root package name */
    private final o f29254d;

    /* renamed from: a, reason: collision with root package name */
    private int f29251a = 0;

    /* renamed from: e, reason: collision with root package name */
    private final CRC32 f29255e = new CRC32();

    public n(z zVar) {
        if (zVar != null) {
            this.f29253c = new Inflater(true);
            this.f29252b = s.a(zVar);
            this.f29254d = new o(this.f29252b, this.f29253c);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    private void a() throws IOException {
        this.f29252b.c(10L);
        byte g2 = this.f29252b.d().g(3L);
        boolean z = ((g2 >> 1) & 1) == 1;
        if (z) {
            a(this.f29252b.d(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.f29252b.readShort());
        this.f29252b.skip(8L);
        if (((g2 >> 2) & 1) == 1) {
            this.f29252b.c(2L);
            if (z) {
                a(this.f29252b.d(), 0L, 2L);
            }
            long i = this.f29252b.d().i();
            this.f29252b.c(i);
            if (z) {
                a(this.f29252b.d(), 0L, i);
            }
            this.f29252b.skip(i);
        }
        if (((g2 >> 3) & 1) == 1) {
            long a2 = this.f29252b.a((byte) 0);
            if (a2 != -1) {
                if (z) {
                    a(this.f29252b.d(), 0L, a2 + 1);
                }
                this.f29252b.skip(a2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((g2 >> 4) & 1) == 1) {
            long a3 = this.f29252b.a((byte) 0);
            if (a3 != -1) {
                if (z) {
                    a(this.f29252b.d(), 0L, a3 + 1);
                }
                this.f29252b.skip(a3 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            a("FHCRC", this.f29252b.i(), (short) this.f29255e.getValue());
            this.f29255e.reset();
        }
    }

    @Override // okio.z
    public long b(g gVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return 0L;
        }
        if (this.f29251a == 0) {
            a();
            this.f29251a = 1;
        }
        if (this.f29251a == 1) {
            long j2 = gVar.f29244c;
            long b2 = this.f29254d.b(gVar, j);
            if (b2 != -1) {
                a(gVar, j2, b2);
                return b2;
            }
            this.f29251a = 2;
        }
        if (this.f29251a == 2) {
            b();
            this.f29251a = 3;
            if (!this.f29252b.l()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // okio.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f29254d.close();
    }

    @Override // okio.z
    public B e() {
        return this.f29252b.e();
    }

    private void b() throws IOException {
        a("CRC", this.f29252b.n(), (int) this.f29255e.getValue());
        a("ISIZE", this.f29252b.n(), (int) this.f29253c.getBytesWritten());
    }

    private void a(g gVar, long j, long j2) {
        w wVar = gVar.f29243b;
        while (true) {
            int i = wVar.f29274c;
            int i2 = wVar.f29273b;
            if (j < i - i2) {
                break;
            }
            j -= i - i2;
            wVar = wVar.f29277f;
        }
        while (j2 > 0) {
            int min = (int) Math.min(wVar.f29274c - r7, j2);
            this.f29255e.update(wVar.f29272a, (int) (wVar.f29273b + j), min);
            j2 -= min;
            wVar = wVar.f29277f;
            j = 0;
        }
    }

    private void a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
