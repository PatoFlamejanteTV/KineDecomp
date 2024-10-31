package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RealBufferedSource.java */
/* loaded from: classes3.dex */
public final class v implements i {

    /* renamed from: a, reason: collision with root package name */
    public final g f29269a = new g();

    /* renamed from: b, reason: collision with root package name */
    public final z f29270b;

    /* renamed from: c, reason: collision with root package name */
    boolean f29271c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(z zVar) {
        if (zVar != null) {
            this.f29270b = zVar;
            return;
        }
        throw new NullPointerException("source == null");
    }

    @Override // okio.i
    public long a(y yVar) throws IOException {
        if (yVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long j = 0;
        while (this.f29270b.b(this.f29269a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
            long b2 = this.f29269a.b();
            if (b2 > 0) {
                j += b2;
                yVar.a(this.f29269a, b2);
            }
        }
        if (this.f29269a.size() <= 0) {
            return j;
        }
        long size = j + this.f29269a.size();
        g gVar = this.f29269a;
        yVar.a(gVar, gVar.size());
        return size;
    }

    @Override // okio.z
    public long b(g gVar, long j) throws IOException {
        if (gVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j >= 0) {
            if (!this.f29271c) {
                g gVar2 = this.f29269a;
                if (gVar2.f29244c == 0 && this.f29270b.b(gVar2, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1L;
                }
                return this.f29269a.b(gVar, Math.min(j, this.f29269a.f29244c));
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // okio.i
    public void c(long j) throws IOException {
        if (!d(j)) {
            throw new EOFException();
        }
    }

    @Override // okio.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f29271c) {
            return;
        }
        this.f29271c = true;
        this.f29270b.close();
        this.f29269a.a();
    }

    @Override // okio.i, okio.h
    public g d() {
        return this.f29269a;
    }

    @Override // okio.i
    public ByteString e(long j) throws IOException {
        c(j);
        return this.f29269a.e(j);
    }

    @Override // okio.i
    public String h() throws IOException {
        return a(Long.MAX_VALUE);
    }

    @Override // okio.i
    public short i() throws IOException {
        c(2L);
        return this.f29269a.i();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f29271c;
    }

    @Override // okio.i
    public long j() throws IOException {
        c(8L);
        return this.f29269a.j();
    }

    @Override // okio.i
    public byte[] k() throws IOException {
        this.f29269a.a(this.f29270b);
        return this.f29269a.k();
    }

    @Override // okio.i
    public boolean l() throws IOException {
        if (this.f29271c) {
            throw new IllegalStateException("closed");
        }
        return this.f29269a.l() && this.f29270b.b(this.f29269a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
    }

    @Override // okio.i
    public long m() throws IOException {
        byte g2;
        c(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!d(i2)) {
                break;
            }
            g2 = this.f29269a.g(i);
            if ((g2 < 48 || g2 > 57) && !(i == 0 && g2 == 45)) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(g2)));
        }
        return this.f29269a.m();
    }

    @Override // okio.i
    public int n() throws IOException {
        c(4L);
        return this.f29269a.n();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:            if (r1 == 0) goto L21;     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:            throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));     */
    @Override // okio.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long o() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.c(r0)
            r0 = 0
            r1 = 0
        L7:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.d(r3)
            if (r3 == 0) goto L4a
            okio.g r3 = r6.f29269a
            long r4 = (long) r1
            byte r3 = r3.g(r4)
            r4 = 48
            if (r3 < r4) goto L1f
            r4 = 57
            if (r3 <= r4) goto L30
        L1f:
            r4 = 97
            if (r3 < r4) goto L27
            r4 = 102(0x66, float:1.43E-43)
            if (r3 <= r4) goto L30
        L27:
            r4 = 65
            if (r3 < r4) goto L32
            r4 = 70
            if (r3 <= r4) goto L30
            goto L32
        L30:
            r1 = r2
            goto L7
        L32:
            if (r1 == 0) goto L35
            goto L4a
        L35:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L4a:
            okio.g r0 = r6.f29269a
            long r0 = r0.o()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.v.o():long");
    }

    @Override // okio.i
    public InputStream p() {
        return new u(this);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        g gVar = this.f29269a;
        if (gVar.f29244c == 0 && this.f29270b.b(gVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.f29269a.read(byteBuffer);
    }

    @Override // okio.i
    public byte readByte() throws IOException {
        c(1L);
        return this.f29269a.readByte();
    }

    @Override // okio.i
    public void readFully(byte[] bArr) throws IOException {
        try {
            c(bArr.length);
            this.f29269a.readFully(bArr);
        } catch (EOFException e2) {
            int i = 0;
            while (true) {
                g gVar = this.f29269a;
                long j = gVar.f29244c;
                if (j <= 0) {
                    throw e2;
                }
                int a2 = gVar.a(bArr, i, (int) j);
                if (a2 == -1) {
                    throw new AssertionError();
                }
                i += a2;
            }
        }
    }

    @Override // okio.i
    public int readInt() throws IOException {
        c(4L);
        return this.f29269a.readInt();
    }

    @Override // okio.i
    public short readShort() throws IOException {
        c(2L);
        return this.f29269a.readShort();
    }

    @Override // okio.i
    public void skip(long j) throws IOException {
        if (this.f29271c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            g gVar = this.f29269a;
            if (gVar.f29244c == 0 && this.f29270b.b(gVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.f29269a.size());
            this.f29269a.skip(min);
            j -= min;
        }
    }

    public String toString() {
        return "buffer(" + this.f29270b + ")";
    }

    public boolean d(long j) throws IOException {
        g gVar;
        if (j >= 0) {
            if (this.f29271c) {
                throw new IllegalStateException("closed");
            }
            do {
                gVar = this.f29269a;
                if (gVar.f29244c >= j) {
                    return true;
                }
            } while (this.f29270b.b(gVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
            return false;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // okio.z
    public B e() {
        return this.f29270b.e();
    }

    @Override // okio.i
    public String a(long j, Charset charset) throws IOException {
        c(j);
        if (charset != null) {
            return this.f29269a.a(j, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // okio.i
    public byte[] b(long j) throws IOException {
        c(j);
        return this.f29269a.b(j);
    }

    @Override // okio.i
    public String a(long j) throws IOException {
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            long a2 = a((byte) 10, 0L, j2);
            if (a2 != -1) {
                return this.f29269a.i(a2);
            }
            if (j2 < Long.MAX_VALUE && d(j2) && this.f29269a.g(j2 - 1) == 13 && d(1 + j2) && this.f29269a.g(j2) == 10) {
                return this.f29269a.i(j2);
            }
            g gVar = new g();
            g gVar2 = this.f29269a;
            gVar2.a(gVar, 0L, Math.min(32L, gVar2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f29269a.size(), j) + " content=" + gVar.q().hex() + (char) 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    @Override // okio.i
    public long a(byte b2) throws IOException {
        return a(b2, 0L, Long.MAX_VALUE);
    }

    public long a(byte b2, long j, long j2) throws IOException {
        if (this.f29271c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long a2 = this.f29269a.a(b2, j, j2);
            if (a2 == -1) {
                g gVar = this.f29269a;
                long j3 = gVar.f29244c;
                if (j3 >= j2 || this.f29270b.b(gVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    break;
                }
                j = Math.max(j, j3);
            } else {
                return a2;
            }
        }
        return -1L;
    }

    @Override // okio.i
    public boolean a(long j, ByteString byteString) throws IOException {
        return a(j, byteString, 0, byteString.size());
    }

    public boolean a(long j, ByteString byteString, int i, int i2) throws IOException {
        if (!this.f29271c) {
            if (j < 0 || i < 0 || i2 < 0 || byteString.size() - i < i2) {
                return false;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                long j2 = i3 + j;
                if (!d(1 + j2) || this.f29269a.g(j2) != byteString.getByte(i + i3)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("closed");
    }
}
