package okio;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Okio.java */
/* loaded from: classes3.dex */
public final class q implements z {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ B f29262a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ InputStream f29263b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(B b2, InputStream inputStream) {
        this.f29262a = b2;
        this.f29263b = inputStream;
    }

    @Override // okio.z
    public long b(g gVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return 0L;
        }
        try {
            this.f29262a.e();
            w b2 = gVar.b(1);
            int read = this.f29263b.read(b2.f29272a, b2.f29274c, (int) Math.min(j, 8192 - b2.f29274c));
            if (read == -1) {
                return -1L;
            }
            b2.f29274c += read;
            long j2 = read;
            gVar.f29244c += j2;
            return j2;
        } catch (AssertionError e2) {
            if (s.a(e2)) {
                throw new IOException(e2);
            }
            throw e2;
        }
    }

    @Override // okio.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f29263b.close();
    }

    @Override // okio.z
    public B e() {
        return this.f29262a;
    }

    public String toString() {
        return "source(" + this.f29263b + ")";
    }
}
