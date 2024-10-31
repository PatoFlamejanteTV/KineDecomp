package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.stetho.dumpapp.Framer;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* compiled from: Buffer.java */
/* loaded from: classes3.dex */
public final class g implements i, h, Cloneable, ByteChannel {

    /* renamed from: a */
    private static final byte[] f29242a = {48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: b */
    @Nullable
    w f29243b;

    /* renamed from: c */
    long f29244c;

    @Override // okio.h
    public /* bridge */ /* synthetic */ h a(ByteString byteString) throws IOException {
        a(byteString);
        return this;
    }

    public final long b() {
        long j = this.f29244c;
        if (j == 0) {
            return 0L;
        }
        w wVar = this.f29243b.f29278g;
        return (wVar.f29274c >= 8192 || !wVar.f29276e) ? j : j - (r3 - wVar.f29273b);
    }

    public OutputStream c() {
        return new e(this);
    }

    @Override // okio.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // okio.i, okio.h
    public g d() {
        return this;
    }

    @Override // okio.h
    public /* bridge */ /* synthetic */ h d(long j) throws IOException {
        d(j);
        return this;
    }

    @Override // okio.i
    public ByteString e(long j) throws EOFException {
        return new ByteString(b(j));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        long j = this.f29244c;
        if (j != gVar.f29244c) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        w wVar = this.f29243b;
        w wVar2 = gVar.f29243b;
        int i = wVar.f29273b;
        int i2 = wVar2.f29273b;
        while (j2 < this.f29244c) {
            long min = Math.min(wVar.f29274c - i, wVar2.f29274c - i2);
            int i3 = i2;
            int i4 = i;
            int i5 = 0;
            while (i5 < min) {
                int i6 = i4 + 1;
                int i7 = i3 + 1;
                if (wVar.f29272a[i4] != wVar2.f29272a[i3]) {
                    return false;
                }
                i5++;
                i4 = i6;
                i3 = i7;
            }
            if (i4 == wVar.f29274c) {
                wVar = wVar.f29277f;
                i = wVar.f29273b;
            } else {
                i = i4;
            }
            if (i3 == wVar2.f29274c) {
                wVar2 = wVar2.f29277f;
                i2 = wVar2.f29273b;
            } else {
                i2 = i3;
            }
            j2 += min;
        }
        return true;
    }

    @Override // okio.h
    public h f() {
        return this;
    }

    @Override // okio.h
    public /* bridge */ /* synthetic */ h f(long j) throws IOException {
        f(j);
        return this;
    }

    @Override // okio.h, okio.y, java.io.Flushable
    public void flush() {
    }

    @Override // okio.h
    public g g() {
        return this;
    }

    @Override // okio.h
    public /* bridge */ /* synthetic */ h g() throws IOException {
        g();
        return this;
    }

    public String h(long j) throws EOFException {
        return a(j, C.f29229a);
    }

    public int hashCode() {
        w wVar = this.f29243b;
        if (wVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = wVar.f29274c;
            for (int i3 = wVar.f29273b; i3 < i2; i3++) {
                i = (i * 31) + wVar.f29272a[i3];
            }
            wVar = wVar.f29277f;
        } while (wVar != this.f29243b);
        return i;
    }

    @Override // okio.i
    public short i() {
        return C.a(readShort());
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // okio.i
    public long j() {
        return C.a(r());
    }

    @Override // okio.i
    public byte[] k() {
        try {
            return b(this.f29244c);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // okio.i
    public boolean l() {
        return this.f29244c == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ac A[EDGE_INSN: B:47:0x00ac->B:41:0x00ac BREAK  A[LOOP:0: B:4:0x0010->B:46:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a4  */
    @Override // okio.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long m() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.f29244c
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto Lb7
            r5 = -7
            r7 = 0
            r8 = r5
            r5 = 0
            r6 = 0
        L10:
            okio.w r10 = r0.f29243b
            byte[] r11 = r10.f29272a
            int r12 = r10.f29273b
            int r13 = r10.f29274c
        L18:
            if (r12 >= r13) goto L98
            r15 = r11[r12]
            r14 = 48
            if (r15 < r14) goto L6a
            r1 = 57
            if (r15 > r1) goto L6a
            int r14 = r14 - r15
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 < 0) goto L3f
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 != 0) goto L38
            long r1 = (long) r14
            int r16 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r16 >= 0) goto L38
            goto L3f
        L38:
            r1 = 10
            long r3 = r3 * r1
            long r1 = (long) r14
            long r3 = r3 + r1
            goto L74
        L3f:
            okio.g r1 = new okio.g
            r1.<init>()
            r1.d(r3)
            r1.writeByte(r15)
            if (r5 != 0) goto L4f
            r1.readByte()
        L4f:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Number too large: "
            r3.append(r4)
            java.lang.String r1 = r1.s()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L6a:
            r1 = 45
            if (r15 != r1) goto L79
            if (r7 != 0) goto L79
            r1 = 1
            long r8 = r8 - r1
            r5 = 1
        L74:
            int r12 = r12 + 1
            int r7 = r7 + 1
            goto L18
        L79:
            if (r7 == 0) goto L7d
            r6 = 1
            goto L98
        L7d:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r15)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L98:
            if (r12 != r13) goto La4
            okio.w r1 = r10.b()
            r0.f29243b = r1
            okio.x.a(r10)
            goto La6
        La4:
            r10.f29273b = r12
        La6:
            if (r6 != 0) goto Lac
            okio.w r1 = r0.f29243b
            if (r1 != 0) goto L10
        Lac:
            long r1 = r0.f29244c
            long r6 = (long) r7
            long r1 = r1 - r6
            r0.f29244c = r1
            if (r5 == 0) goto Lb5
            goto Lb6
        Lb5:
            long r3 = -r3
        Lb6:
            return r3
        Lb7:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            goto Lc0
        Lbf:
            throw r1
        Lc0:
            goto Lbf
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.g.m():long");
    }

    @Override // okio.i
    public int n() {
        return C.a(readInt());
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a3 A[EDGE_INSN: B:41:0x00a3->B:38:0x00a3 BREAK  A[LOOP:0: B:4:0x000b->B:40:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009b  */
    @Override // okio.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long o() {
        /*
            r15 = this;
            long r0 = r15.f29244c
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Laa
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            okio.w r6 = r15.f29243b
            byte[] r7 = r6.f29272a
            int r8 = r6.f29273b
            int r9 = r6.f29274c
        L13:
            if (r8 >= r9) goto L8f
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L3a
        L22:
            r11 = 97
            if (r10 < r11) goto L2f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2f
            int r11 = r10 + (-97)
        L2c:
            int r11 = r11 + 10
            goto L3a
        L2f:
            r11 = 65
            if (r10 < r11) goto L70
            r11 = 70
            if (r10 > r11) goto L70
            int r11 = r10 + (-65)
            goto L2c
        L3a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L4a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r1 = r1 + 1
            goto L13
        L4a:
            okio.g r0 = new okio.g
            r0.<init>()
            r0.f(r4)
            r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.s()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L70:
            if (r1 == 0) goto L74
            r0 = 1
            goto L8f
        L74:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L8f:
            if (r8 != r9) goto L9b
            okio.w r7 = r6.b()
            r15.f29243b = r7
            okio.x.a(r6)
            goto L9d
        L9b:
            r6.f29273b = r8
        L9d:
            if (r0 != 0) goto La3
            okio.w r6 = r15.f29243b
            if (r6 != 0) goto Lb
        La3:
            long r2 = r15.f29244c
            long r0 = (long) r1
            long r2 = r2 - r0
            r15.f29244c = r2
            return r4
        Laa:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            goto Lb3
        Lb2:
            throw r0
        Lb3:
            goto Lb2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.g.o():long");
    }

    @Override // okio.i
    public InputStream p() {
        return new f(this);
    }

    public ByteString q() {
        return new ByteString(k());
    }

    public long r() {
        long j = this.f29244c;
        if (j >= 8) {
            w wVar = this.f29243b;
            int i = wVar.f29273b;
            int i2 = wVar.f29274c;
            if (i2 - i < 8) {
                return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
            }
            byte[] bArr = wVar.f29272a;
            long j2 = (bArr[i] & 255) << 56;
            long j3 = ((bArr[r11] & 255) << 48) | j2;
            long j4 = j3 | ((bArr[r6] & 255) << 40);
            long j5 = j4 | ((bArr[r11] & 255) << 32) | ((bArr[r6] & 255) << 24);
            long j6 = j5 | ((bArr[r9] & 255) << 16);
            long j7 = j6 | ((bArr[r6] & 255) << 8);
            int i3 = i + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1;
            long j8 = j7 | (bArr[r9] & 255);
            this.f29244c = j - 8;
            if (i3 == i2) {
                this.f29243b = wVar.b();
                x.a(wVar);
            } else {
                wVar.f29273b = i3;
            }
            return j8;
        }
        throw new IllegalStateException("size < 8: " + this.f29244c);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        w wVar = this.f29243b;
        if (wVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), wVar.f29274c - wVar.f29273b);
        byteBuffer.put(wVar.f29272a, wVar.f29273b, min);
        wVar.f29273b += min;
        this.f29244c -= min;
        if (wVar.f29273b == wVar.f29274c) {
            this.f29243b = wVar.b();
            x.a(wVar);
        }
        return min;
    }

    @Override // okio.i
    public byte readByte() {
        long j = this.f29244c;
        if (j != 0) {
            w wVar = this.f29243b;
            int i = wVar.f29273b;
            int i2 = wVar.f29274c;
            int i3 = i + 1;
            byte b2 = wVar.f29272a[i];
            this.f29244c = j - 1;
            if (i3 == i2) {
                this.f29243b = wVar.b();
                x.a(wVar);
            } else {
                wVar.f29273b = i3;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // okio.i
    public void readFully(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int a2 = a(bArr, i, bArr.length - i);
            if (a2 == -1) {
                throw new EOFException();
            }
            i += a2;
        }
    }

    @Override // okio.i
    public int readInt() {
        long j = this.f29244c;
        if (j >= 4) {
            w wVar = this.f29243b;
            int i = wVar.f29273b;
            int i2 = wVar.f29274c;
            if (i2 - i < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = wVar.f29272a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i6 = i4 + 1;
            int i7 = i5 | ((bArr[i4] & 255) << 8);
            int i8 = i6 + 1;
            int i9 = i7 | (bArr[i6] & 255);
            this.f29244c = j - 4;
            if (i8 == i2) {
                this.f29243b = wVar.b();
                x.a(wVar);
            } else {
                wVar.f29273b = i8;
            }
            return i9;
        }
        throw new IllegalStateException("size < 4: " + this.f29244c);
    }

    @Override // okio.i
    public short readShort() {
        long j = this.f29244c;
        if (j >= 2) {
            w wVar = this.f29243b;
            int i = wVar.f29273b;
            int i2 = wVar.f29274c;
            if (i2 - i < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = wVar.f29272a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            this.f29244c = j - 2;
            if (i4 == i2) {
                this.f29243b = wVar.b();
                x.a(wVar);
            } else {
                wVar.f29273b = i4;
            }
            return (short) i5;
        }
        throw new IllegalStateException("size < 2: " + this.f29244c);
    }

    public String s() {
        try {
            return a(this.f29244c, C.f29229a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public final long size() {
        return this.f29244c;
    }

    @Override // okio.i
    public void skip(long j) throws EOFException {
        while (j > 0) {
            if (this.f29243b != null) {
                int min = (int) Math.min(j, r0.f29274c - r0.f29273b);
                long j2 = min;
                this.f29244c -= j2;
                j -= j2;
                w wVar = this.f29243b;
                wVar.f29273b += min;
                if (wVar.f29273b == wVar.f29274c) {
                    this.f29243b = wVar.b();
                    x.a(wVar);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public final ByteString t() {
        long j = this.f29244c;
        if (j <= 2147483647L) {
            return a((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f29244c);
    }

    public String toString() {
        return t().toString();
    }

    @Override // okio.h
    public /* bridge */ /* synthetic */ h write(byte[] bArr) throws IOException {
        write(bArr);
        return this;
    }

    @Override // okio.h
    public /* bridge */ /* synthetic */ h writeByte(int i) throws IOException {
        writeByte(i);
        return this;
    }

    @Override // okio.h
    public /* bridge */ /* synthetic */ h writeInt(int i) throws IOException {
        writeInt(i);
        return this;
    }

    @Override // okio.h
    public /* bridge */ /* synthetic */ h writeShort(int i) throws IOException {
        writeShort(i);
        return this;
    }

    @Override // okio.h
    public /* bridge */ /* synthetic */ h a(String str) throws IOException {
        a(str);
        return this;
    }

    @Override // okio.i
    public void c(long j) throws EOFException {
        if (this.f29244c < j) {
            throw new EOFException();
        }
    }

    public g clone() {
        g gVar = new g();
        if (this.f29244c == 0) {
            return gVar;
        }
        gVar.f29243b = this.f29243b.c();
        w wVar = gVar.f29243b;
        wVar.f29278g = wVar;
        wVar.f29277f = wVar;
        w wVar2 = this.f29243b;
        while (true) {
            wVar2 = wVar2.f29277f;
            if (wVar2 != this.f29243b) {
                gVar.f29243b.f29278g.a(wVar2.c());
            } else {
                gVar.f29244c = this.f29244c;
                return gVar;
            }
        }
    }

    @Override // okio.h
    public g d(long j) {
        if (j == 0) {
            writeByte(48);
            return this;
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                a("-9223372036854775808");
                return this;
            }
            z = true;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        w b2 = b(i);
        byte[] bArr = b2.f29272a;
        int i2 = b2.f29274c + i;
        while (j != 0) {
            i2--;
            bArr[i2] = f29242a[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = Framer.STDIN_FRAME_PREFIX;
        }
        b2.f29274c += i;
        this.f29244c += i;
        return this;
    }

    @Override // okio.z
    public B e() {
        return B.f29225a;
    }

    @Override // okio.h
    public g f(long j) {
        if (j == 0) {
            writeByte(48);
            return this;
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        w b2 = b(numberOfTrailingZeros);
        byte[] bArr = b2.f29272a;
        int i = b2.f29274c;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f29242a[(int) (15 & j)];
            j >>>= 4;
        }
        b2.f29274c += numberOfTrailingZeros;
        this.f29244c += numberOfTrailingZeros;
        return this;
    }

    public final byte g(long j) {
        int i;
        C.a(this.f29244c, j, 1L);
        long j2 = this.f29244c;
        if (j2 - j > j) {
            w wVar = this.f29243b;
            while (true) {
                int i2 = wVar.f29274c;
                int i3 = wVar.f29273b;
                long j3 = i2 - i3;
                if (j < j3) {
                    return wVar.f29272a[i3 + ((int) j)];
                }
                j -= j3;
                wVar = wVar.f29277f;
            }
        } else {
            long j4 = j - j2;
            w wVar2 = this.f29243b;
            do {
                wVar2 = wVar2.f29278g;
                int i4 = wVar2.f29274c;
                i = wVar2.f29273b;
                j4 += i4 - i;
            } while (j4 < 0);
            return wVar2.f29272a[i + ((int) j4)];
        }
    }

    @Override // okio.i
    public String h() throws EOFException {
        return a(Long.MAX_VALUE);
    }

    public String i(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (g(j2) == 13) {
                String h2 = h(j2);
                skip(2L);
                return h2;
            }
        }
        String h3 = h(j);
        skip(1L);
        return h3;
    }

    @Override // okio.h
    public /* bridge */ /* synthetic */ h write(byte[] bArr, int i, int i2) throws IOException {
        write(bArr, i, i2);
        return this;
    }

    @Override // okio.h
    public g writeByte(int i) {
        w b2 = b(1);
        byte[] bArr = b2.f29272a;
        int i2 = b2.f29274c;
        b2.f29274c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f29244c++;
        return this;
    }

    @Override // okio.h
    public g writeInt(int i) {
        w b2 = b(4);
        byte[] bArr = b2.f29272a;
        int i2 = b2.f29274c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        b2.f29274c = i5 + 1;
        this.f29244c += 4;
        return this;
    }

    @Override // okio.h
    public g writeShort(int i) {
        w b2 = b(2);
        byte[] bArr = b2.f29272a;
        int i2 = b2.f29274c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        b2.f29274c = i3 + 1;
        this.f29244c += 2;
        return this;
    }

    public final g a(g gVar, long j, long j2) {
        if (gVar != null) {
            C.a(this.f29244c, j, j2);
            if (j2 == 0) {
                return this;
            }
            gVar.f29244c += j2;
            w wVar = this.f29243b;
            while (true) {
                int i = wVar.f29274c;
                int i2 = wVar.f29273b;
                if (j < i - i2) {
                    break;
                }
                j -= i - i2;
                wVar = wVar.f29277f;
            }
            while (j2 > 0) {
                w c2 = wVar.c();
                c2.f29273b = (int) (c2.f29273b + j);
                c2.f29274c = Math.min(c2.f29273b + ((int) j2), c2.f29274c);
                w wVar2 = gVar.f29243b;
                if (wVar2 == null) {
                    c2.f29278g = c2;
                    c2.f29277f = c2;
                    gVar.f29243b = c2;
                } else {
                    wVar2.f29278g.a(c2);
                }
                j2 -= c2.f29274c - c2.f29273b;
                wVar = wVar.f29277f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public g c(int i) {
        if (i < 128) {
            writeByte(i);
        } else if (i < 2048) {
            writeByte((i >> 6) | 192);
            writeByte((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                writeByte(63);
            } else {
                writeByte((i >> 12) | 224);
                writeByte(((i >> 6) & 63) | 128);
                writeByte((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            writeByte((i >> 18) | 240);
            writeByte(((i >> 12) & 63) | 128);
            writeByte(((i >> 6) & 63) | 128);
            writeByte((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    @Override // okio.h
    public g write(byte[] bArr) {
        if (bArr != null) {
            write(bArr, 0, bArr.length);
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // okio.i
    public byte[] b(long j) throws EOFException {
        C.a(this.f29244c, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    @Override // okio.h
    public g write(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = i2;
            C.a(bArr.length, i, j);
            int i3 = i2 + i;
            while (i < i3) {
                w b2 = b(1);
                int min = Math.min(i3 - i, 8192 - b2.f29274c);
                System.arraycopy(bArr, i, b2.f29272a, b2.f29274c, min);
                i += min;
                b2.f29274c += min;
            }
            this.f29244c += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public w b(int i) {
        if (i >= 1 && i <= 8192) {
            w wVar = this.f29243b;
            if (wVar == null) {
                this.f29243b = x.a();
                w wVar2 = this.f29243b;
                wVar2.f29278g = wVar2;
                wVar2.f29277f = wVar2;
                return wVar2;
            }
            w wVar3 = wVar.f29278g;
            if (wVar3.f29274c + i <= 8192 && wVar3.f29276e) {
                return wVar3;
            }
            w a2 = x.a();
            wVar3.a(a2);
            return a2;
        }
        throw new IllegalArgumentException();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                w b2 = b(1);
                int min = Math.min(i, 8192 - b2.f29274c);
                byteBuffer.get(b2.f29272a, b2.f29274c, min);
                i -= min;
                b2.f29274c += min;
            }
            this.f29244c += remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // okio.i
    public long a(y yVar) throws IOException {
        long j = this.f29244c;
        if (j > 0) {
            yVar.a(this, j);
        }
        return j;
    }

    @Override // okio.z
    public long b(g gVar, long j) {
        if (gVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j >= 0) {
            long j2 = this.f29244c;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            gVar.a(this, j);
            return j;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // okio.i
    public String a(long j, Charset charset) throws EOFException {
        C.a(this.f29244c, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        w wVar = this.f29243b;
        int i = wVar.f29273b;
        if (i + j > wVar.f29274c) {
            return new String(b(j), charset);
        }
        String str = new String(wVar.f29272a, i, (int) j, charset);
        wVar.f29273b = (int) (wVar.f29273b + j);
        this.f29244c -= j;
        if (wVar.f29273b == wVar.f29274c) {
            this.f29243b = wVar.b();
            x.a(wVar);
        }
        return str;
    }

    @Override // okio.i
    public String a(long j) throws EOFException {
        if (j >= 0) {
            long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
            long a2 = a((byte) 10, 0L, j2);
            if (a2 != -1) {
                return i(a2);
            }
            if (j2 < size() && g(j2 - 1) == 13 && g(j2) == 10) {
                return i(j2);
            }
            g gVar = new g();
            a(gVar, 0L, Math.min(32L, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + gVar.q().hex() + (char) 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    public int a(byte[] bArr, int i, int i2) {
        C.a(bArr.length, i, i2);
        w wVar = this.f29243b;
        if (wVar == null) {
            return -1;
        }
        int min = Math.min(i2, wVar.f29274c - wVar.f29273b);
        System.arraycopy(wVar.f29272a, wVar.f29273b, bArr, i, min);
        wVar.f29273b += min;
        this.f29244c -= min;
        if (wVar.f29273b == wVar.f29274c) {
            this.f29243b = wVar.b();
            x.a(wVar);
        }
        return min;
    }

    public final void a() {
        try {
            skip(this.f29244c);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // okio.h
    public g a(ByteString byteString) {
        if (byteString != null) {
            byteString.write(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // okio.h
    public g a(String str) {
        a(str, 0, str.length());
        return this;
    }

    public g a(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        }
        if (i2 >= i) {
            if (i2 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            }
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt < 128) {
                    w b2 = b(1);
                    byte[] bArr = b2.f29272a;
                    int i3 = b2.f29274c - i;
                    int min = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) charAt;
                    while (i4 < min) {
                        char charAt2 = str.charAt(i4);
                        if (charAt2 >= 128) {
                            break;
                        }
                        bArr[i4 + i3] = (byte) charAt2;
                        i4++;
                    }
                    int i5 = b2.f29274c;
                    int i6 = (i3 + i4) - i5;
                    b2.f29274c = i5 + i6;
                    this.f29244c += i6;
                    i = i4;
                } else {
                    if (charAt < 2048) {
                        writeByte((charAt >> 6) | 192);
                        writeByte((charAt & '?') | 128);
                    } else if (charAt >= 55296 && charAt <= 57343) {
                        int i7 = i + 1;
                        char charAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                        if (charAt <= 56319 && charAt3 >= 56320 && charAt3 <= 57343) {
                            int i8 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                            writeByte((i8 >> 18) | 240);
                            writeByte(((i8 >> 12) & 63) | 128);
                            writeByte(((i8 >> 6) & 63) | 128);
                            writeByte((i8 & 63) | 128);
                            i += 2;
                        } else {
                            writeByte(63);
                            i = i7;
                        }
                    } else {
                        writeByte((charAt >> '\f') | 224);
                        writeByte(((charAt >> 6) & 63) | 128);
                        writeByte((charAt & '?') | 128);
                    }
                    i++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
    }

    public g a(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        }
        if (i2 >= i) {
            if (i2 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            }
            if (charset != null) {
                if (charset.equals(C.f29229a)) {
                    a(str, i, i2);
                    return this;
                }
                byte[] bytes = str.substring(i, i2).getBytes(charset);
                write(bytes, 0, bytes.length);
                return this;
            }
            throw new IllegalArgumentException("charset == null");
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
    }

    @Override // okio.h
    public long a(z zVar) throws IOException {
        if (zVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long b2 = zVar.b(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (b2 == -1) {
                return j;
            }
            j += b2;
        }
    }

    @Override // okio.y
    public void a(g gVar, long j) {
        if (gVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (gVar != this) {
            C.a(gVar.f29244c, 0L, j);
            while (j > 0) {
                w wVar = gVar.f29243b;
                if (j < wVar.f29274c - wVar.f29273b) {
                    w wVar2 = this.f29243b;
                    w wVar3 = wVar2 != null ? wVar2.f29278g : null;
                    if (wVar3 != null && wVar3.f29276e) {
                        if ((wVar3.f29274c + j) - (wVar3.f29275d ? 0 : wVar3.f29273b) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            gVar.f29243b.a(wVar3, (int) j);
                            gVar.f29244c -= j;
                            this.f29244c += j;
                            return;
                        }
                    }
                    gVar.f29243b = gVar.f29243b.a((int) j);
                }
                w wVar4 = gVar.f29243b;
                long j2 = wVar4.f29274c - wVar4.f29273b;
                gVar.f29243b = wVar4.b();
                w wVar5 = this.f29243b;
                if (wVar5 == null) {
                    this.f29243b = wVar4;
                    w wVar6 = this.f29243b;
                    wVar6.f29278g = wVar6;
                    wVar6.f29277f = wVar6;
                } else {
                    wVar5.f29278g.a(wVar4);
                    wVar4.a();
                }
                gVar.f29244c -= j2;
                this.f29244c += j2;
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    @Override // okio.i
    public long a(byte b2) {
        return a(b2, 0L, Long.MAX_VALUE);
    }

    public long a(byte b2, long j, long j2) {
        w wVar;
        long j3 = 0;
        if (j >= 0 && j2 >= j) {
            long j4 = this.f29244c;
            if (j2 <= j4) {
                j4 = j2;
            }
            if (j == j4 || (wVar = this.f29243b) == null) {
                return -1L;
            }
            long j5 = this.f29244c;
            if (j5 - j >= j) {
                while (true) {
                    j5 = j3;
                    j3 = (wVar.f29274c - wVar.f29273b) + j5;
                    if (j3 >= j) {
                        break;
                    }
                    wVar = wVar.f29277f;
                }
            } else {
                while (j5 > j) {
                    wVar = wVar.f29278g;
                    j5 -= wVar.f29274c - wVar.f29273b;
                }
            }
            long j6 = j;
            while (j5 < j4) {
                byte[] bArr = wVar.f29272a;
                int min = (int) Math.min(wVar.f29274c, (wVar.f29273b + j4) - j5);
                for (int i = (int) ((wVar.f29273b + j6) - j5); i < min; i++) {
                    if (bArr[i] == b2) {
                        return (i - wVar.f29273b) + j5;
                    }
                }
                j6 = (wVar.f29274c - wVar.f29273b) + j5;
                wVar = wVar.f29277f;
                j5 = j6;
            }
            return -1L;
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f29244c), Long.valueOf(j), Long.valueOf(j2)));
    }

    @Override // okio.i
    public boolean a(long j, ByteString byteString) {
        return a(j, byteString, 0, byteString.size());
    }

    public boolean a(long j, ByteString byteString, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.f29244c - j < i2 || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (g(i3 + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    public final ByteString a(int i) {
        if (i == 0) {
            return ByteString.EMPTY;
        }
        return new SegmentedByteString(this, i);
    }
}
