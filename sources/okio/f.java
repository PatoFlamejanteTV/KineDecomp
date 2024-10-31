package okio;

import java.io.InputStream;

/* compiled from: Buffer.java */
/* loaded from: classes3.dex */
public class f extends InputStream {

    /* renamed from: a */
    final /* synthetic */ g f29241a;

    public f(g gVar) {
        this.f29241a = gVar;
    }

    @Override // java.io.InputStream
    public int available() {
        return (int) Math.min(this.f29241a.f29244c, 2147483647L);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.InputStream
    public int read() {
        g gVar = this.f29241a;
        if (gVar.f29244c > 0) {
            return gVar.readByte() & 255;
        }
        return -1;
    }

    public String toString() {
        return this.f29241a + ".inputStream()";
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        return this.f29241a.a(bArr, i, i2);
    }
}
