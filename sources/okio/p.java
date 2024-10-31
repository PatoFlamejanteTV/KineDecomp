package okio;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Okio.java */
/* loaded from: classes3.dex */
public final class p implements y {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ B f29260a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ OutputStream f29261b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(B b2, OutputStream outputStream) {
        this.f29260a = b2;
        this.f29261b = outputStream;
    }

    @Override // okio.y
    public void a(g gVar, long j) throws IOException {
        C.a(gVar.f29244c, 0L, j);
        while (j > 0) {
            this.f29260a.e();
            w wVar = gVar.f29243b;
            int min = (int) Math.min(j, wVar.f29274c - wVar.f29273b);
            this.f29261b.write(wVar.f29272a, wVar.f29273b, min);
            wVar.f29273b += min;
            long j2 = min;
            j -= j2;
            gVar.f29244c -= j2;
            if (wVar.f29273b == wVar.f29274c) {
                gVar.f29243b = wVar.b();
                x.a(wVar);
            }
        }
    }

    @Override // okio.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f29261b.close();
    }

    @Override // okio.y
    public B e() {
        return this.f29260a;
    }

    @Override // okio.y, java.io.Flushable
    public void flush() throws IOException {
        this.f29261b.flush();
    }

    public String toString() {
        return "sink(" + this.f29261b + ")";
    }
}
