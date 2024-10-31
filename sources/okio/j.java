package okio;

import java.io.IOException;
import java.util.zip.Deflater;

/* compiled from: DeflaterSink.java */
/* loaded from: classes3.dex */
public final class j implements y {

    /* renamed from: a, reason: collision with root package name */
    private final h f29245a;

    /* renamed from: b, reason: collision with root package name */
    private final Deflater f29246b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f29247c;

    public j(y yVar, Deflater deflater) {
        this(s.a(yVar), deflater);
    }

    @Override // okio.y
    public void a(g gVar, long j) throws IOException {
        C.a(gVar.f29244c, 0L, j);
        while (j > 0) {
            w wVar = gVar.f29243b;
            int min = (int) Math.min(j, wVar.f29274c - wVar.f29273b);
            this.f29246b.setInput(wVar.f29272a, wVar.f29273b, min);
            a(false);
            long j2 = min;
            gVar.f29244c -= j2;
            wVar.f29273b += min;
            if (wVar.f29273b == wVar.f29274c) {
                gVar.f29243b = wVar.b();
                x.a(wVar);
            }
            j -= j2;
        }
    }

    @Override // okio.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f29247c) {
            return;
        }
        try {
            a();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f29246b.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.f29245a.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f29247c = true;
        if (th == null) {
            return;
        }
        C.a(th);
        throw null;
    }

    @Override // okio.y
    public B e() {
        return this.f29245a.e();
    }

    @Override // okio.y, java.io.Flushable
    public void flush() throws IOException {
        a(true);
        this.f29245a.flush();
    }

    public String toString() {
        return "DeflaterSink(" + this.f29245a + ")";
    }

    j(h hVar, Deflater deflater) {
        if (hVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (deflater != null) {
            this.f29245a = hVar;
            this.f29246b = deflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }

    private void a(boolean z) throws IOException {
        w b2;
        int deflate;
        g d2 = this.f29245a.d();
        while (true) {
            b2 = d2.b(1);
            if (z) {
                Deflater deflater = this.f29246b;
                byte[] bArr = b2.f29272a;
                int i = b2.f29274c;
                deflate = deflater.deflate(bArr, i, 8192 - i, 2);
            } else {
                Deflater deflater2 = this.f29246b;
                byte[] bArr2 = b2.f29272a;
                int i2 = b2.f29274c;
                deflate = deflater2.deflate(bArr2, i2, 8192 - i2);
            }
            if (deflate > 0) {
                b2.f29274c += deflate;
                d2.f29244c += deflate;
                this.f29245a.g();
            } else if (this.f29246b.needsInput()) {
                break;
            }
        }
        if (b2.f29273b == b2.f29274c) {
            d2.f29243b = b2.b();
            x.a(b2);
        }
    }

    void a() throws IOException {
        this.f29246b.finish();
        a(false);
    }
}
