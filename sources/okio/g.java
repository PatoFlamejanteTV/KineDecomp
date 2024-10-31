package okio;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RealBufferedSource.java */
/* loaded from: classes.dex */
public final class g implements d {

    /* renamed from: a, reason: collision with root package name */
    public final b f4933a;
    public final k b;
    private boolean c;

    public g(k kVar, b bVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f4933a = bVar;
        this.b = kVar;
    }

    public g(k kVar) {
        this(kVar, new b());
    }

    @Override // okio.k
    public long b(b bVar, long j) throws IOException {
        if (bVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.f4933a.b == 0 && this.b.b(this.f4933a, 2048L) == -1) {
            return -1L;
        }
        return this.f4933a.b(bVar, Math.min(j, this.f4933a.b));
    }

    @Override // okio.d
    public boolean b() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        return this.f4933a.b() && this.b.b(this.f4933a, 2048L) == -1;
    }

    @Override // okio.d
    public void a(long j) throws IOException {
        if (!c(j)) {
            throw new EOFException();
        }
    }

    public boolean c(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (this.f4933a.b < j) {
            if (this.b.b(this.f4933a, 2048L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.d
    public byte c() throws IOException {
        a(1L);
        return this.f4933a.c();
    }

    @Override // okio.d
    public ByteString b(long j) throws IOException {
        a(j);
        return this.f4933a.b(j);
    }

    @Override // okio.d
    public String a(long j, Charset charset) throws IOException {
        a(j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        return this.f4933a.a(j, charset);
    }

    @Override // okio.d
    public int f() throws IOException {
        a(4L);
        return this.f4933a.f();
    }

    @Override // okio.d
    public long g() throws IOException {
        a(8L);
        return this.f4933a.g();
    }

    @Override // okio.d
    public void d(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.f4933a.b == 0 && this.b.b(this.f4933a, 2048L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.f4933a.a());
            this.f4933a.d(min);
            j -= min;
        }
    }

    @Override // okio.k, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.c) {
            this.c = true;
            this.b.close();
            this.f4933a.j();
        }
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
