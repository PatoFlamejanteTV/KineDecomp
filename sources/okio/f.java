package okio;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: Okio.java */
/* loaded from: classes.dex */
final class f implements k {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f4932a;
    final /* synthetic */ InputStream b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(l lVar, InputStream inputStream) {
        this.f4932a = lVar;
        this.b = inputStream;
    }

    @Override // okio.k
    public long b(b bVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        this.f4932a.a();
        h a2 = bVar.a(1);
        int read = this.b.read(a2.f4934a, a2.c, (int) Math.min(j, 2048 - a2.c));
        if (read == -1) {
            return -1L;
        }
        a2.c += read;
        bVar.b += read;
        return read;
    }

    @Override // okio.k, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b.close();
    }

    public String toString() {
        return "source(" + this.b + ")";
    }
}
