package okio;

import java.io.OutputStream;

/* compiled from: Buffer.java */
/* loaded from: classes3.dex */
public class e extends OutputStream {

    /* renamed from: a */
    final /* synthetic */ g f29240a;

    public e(g gVar) {
        this.f29240a = gVar;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }

    public String toString() {
        return this.f29240a + ".outputStream()";
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.f29240a.writeByte((int) ((byte) i));
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.f29240a.write(bArr, i, i2);
    }
}
