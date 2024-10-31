package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: RealBufferedSource.java */
/* loaded from: classes3.dex */
class u extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f29268a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(v vVar) {
        this.f29268a = vVar;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        v vVar = this.f29268a;
        if (!vVar.f29271c) {
            return (int) Math.min(vVar.f29269a.f29244c, 2147483647L);
        }
        throw new IOException("closed");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f29268a.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        v vVar = this.f29268a;
        if (!vVar.f29271c) {
            g gVar = vVar.f29269a;
            if (gVar.f29244c == 0 && vVar.f29270b.b(gVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1;
            }
            return this.f29268a.f29269a.readByte() & 255;
        }
        throw new IOException("closed");
    }

    public String toString() {
        return this.f29268a + ".inputStream()";
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f29268a.f29271c) {
            C.a(bArr.length, i, i2);
            v vVar = this.f29268a;
            g gVar = vVar.f29269a;
            if (gVar.f29244c == 0 && vVar.f29270b.b(gVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1;
            }
            return this.f29268a.f29269a.a(bArr, i, i2);
        }
        throw new IOException("closed");
    }
}
