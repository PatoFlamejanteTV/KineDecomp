package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RealBufferedSink.java */
/* loaded from: classes3.dex */
public final class t implements h {

    /* renamed from: a, reason: collision with root package name */
    public final g f29265a = new g();

    /* renamed from: b, reason: collision with root package name */
    public final y f29266b;

    /* renamed from: c, reason: collision with root package name */
    boolean f29267c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(y yVar) {
        if (yVar != null) {
            this.f29266b = yVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    @Override // okio.y
    public void a(g gVar, long j) throws IOException {
        if (!this.f29267c) {
            this.f29265a.a(gVar, j);
            g();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f29267c) {
            return;
        }
        try {
            if (this.f29265a.f29244c > 0) {
                this.f29266b.a(this.f29265a, this.f29265a.f29244c);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f29266b.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f29267c = true;
        if (th == null) {
            return;
        }
        C.a(th);
        throw null;
    }

    @Override // okio.h
    public g d() {
        return this.f29265a;
    }

    @Override // okio.y
    public B e() {
        return this.f29266b.e();
    }

    @Override // okio.h
    public h f(long j) throws IOException {
        if (!this.f29267c) {
            this.f29265a.f(j);
            g();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.h, okio.y, java.io.Flushable
    public void flush() throws IOException {
        if (!this.f29267c) {
            g gVar = this.f29265a;
            long j = gVar.f29244c;
            if (j > 0) {
                this.f29266b.a(gVar, j);
            }
            this.f29266b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.h
    public h g() throws IOException {
        if (!this.f29267c) {
            long b2 = this.f29265a.b();
            if (b2 > 0) {
                this.f29266b.a(this.f29265a, b2);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f29267c;
    }

    public String toString() {
        return "buffer(" + this.f29266b + ")";
    }

    @Override // okio.h
    public h write(byte[] bArr) throws IOException {
        if (!this.f29267c) {
            this.f29265a.write(bArr);
            g();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.h
    public h writeByte(int i) throws IOException {
        if (!this.f29267c) {
            this.f29265a.writeByte(i);
            g();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.h
    public h writeInt(int i) throws IOException {
        if (!this.f29267c) {
            this.f29265a.writeInt(i);
            g();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.h
    public h writeShort(int i) throws IOException {
        if (!this.f29267c) {
            this.f29265a.writeShort(i);
            g();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.h
    public h d(long j) throws IOException {
        if (!this.f29267c) {
            this.f29265a.d(j);
            g();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.h
    public h a(ByteString byteString) throws IOException {
        if (!this.f29267c) {
            this.f29265a.a(byteString);
            g();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.h
    public h f() throws IOException {
        if (!this.f29267c) {
            long size = this.f29265a.size();
            if (size > 0) {
                this.f29266b.a(this.f29265a, size);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.h
    public h write(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f29267c) {
            this.f29265a.write(bArr, i, i2);
            g();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.h
    public h a(String str) throws IOException {
        if (!this.f29267c) {
            this.f29265a.a(str);
            g();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f29267c) {
            int write = this.f29265a.write(byteBuffer);
            g();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.h
    public long a(z zVar) throws IOException {
        if (zVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long b2 = zVar.b(this.f29265a, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (b2 == -1) {
                return j;
            }
            j += b2;
            g();
        }
    }
}
