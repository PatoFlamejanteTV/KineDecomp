package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: InflaterSource.java */
/* loaded from: classes3.dex */
public final class o implements z {

    /* renamed from: a, reason: collision with root package name */
    private final i f29256a;

    /* renamed from: b, reason: collision with root package name */
    private final Inflater f29257b;

    /* renamed from: c, reason: collision with root package name */
    private int f29258c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f29259d;

    public o(z zVar, Inflater inflater) {
        this(s.a(zVar), inflater);
    }

    public final boolean a() throws IOException {
        if (!this.f29257b.needsInput()) {
            return false;
        }
        b();
        if (this.f29257b.getRemaining() == 0) {
            if (this.f29256a.l()) {
                return true;
            }
            w wVar = this.f29256a.d().f29243b;
            int i = wVar.f29274c;
            int i2 = wVar.f29273b;
            this.f29258c = i - i2;
            this.f29257b.setInput(wVar.f29272a, i2, this.f29258c);
            return false;
        }
        throw new IllegalStateException("?");
    }

    @Override // okio.z
    public long b(g gVar, long j) throws IOException {
        boolean a2;
        if (j >= 0) {
            if (this.f29259d) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return 0L;
            }
            do {
                a2 = a();
                try {
                    w b2 = gVar.b(1);
                    int inflate = this.f29257b.inflate(b2.f29272a, b2.f29274c, (int) Math.min(j, 8192 - b2.f29274c));
                    if (inflate > 0) {
                        b2.f29274c += inflate;
                        long j2 = inflate;
                        gVar.f29244c += j2;
                        return j2;
                    }
                    if (!this.f29257b.finished() && !this.f29257b.needsDictionary()) {
                    }
                    b();
                    if (b2.f29273b != b2.f29274c) {
                        return -1L;
                    }
                    gVar.f29243b = b2.b();
                    x.a(b2);
                    return -1L;
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            } while (!a2);
            throw new EOFException("source exhausted prematurely");
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // okio.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f29259d) {
            return;
        }
        this.f29257b.end();
        this.f29259d = true;
        this.f29256a.close();
    }

    @Override // okio.z
    public B e() {
        return this.f29256a.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(i iVar, Inflater inflater) {
        if (iVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater != null) {
            this.f29256a = iVar;
            this.f29257b = inflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }

    private void b() throws IOException {
        int i = this.f29258c;
        if (i == 0) {
            return;
        }
        int remaining = i - this.f29257b.getRemaining();
        this.f29258c -= remaining;
        this.f29256a.skip(remaining);
    }
}
