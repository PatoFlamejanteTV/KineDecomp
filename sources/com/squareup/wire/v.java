package com.squareup.wire;

import java.io.IOException;

/* compiled from: WireOutput.java */
/* loaded from: classes.dex */
public final class v {

    /* renamed from: a */
    private final byte[] f25749a;

    /* renamed from: b */
    private final int f25750b;

    /* renamed from: c */
    private int f25751c;

    private v(byte[] bArr, int i, int i2) {
        this.f25749a = bArr;
        this.f25751c = i;
        this.f25750b = i + i2;
    }

    public static int a(int i) {
        if (i >= 0) {
            return b(i);
        }
        return 10;
    }

    public static int a(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int b(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int c(int i) {
        return b(a(i, WireType.VARINT));
    }

    public static long d(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int h(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public void b(byte[] bArr) throws IOException {
        b(bArr, 0, bArr.length);
    }

    public void d(int i) throws IOException {
        e(i & 255);
        e((i >> 8) & 255);
        e((i >> 16) & 255);
        e((i >> 24) & 255);
    }

    public void e(int i) throws IOException {
        a((byte) i);
    }

    public void f(int i) throws IOException {
        if (i >= 0) {
            g(i);
        } else {
            c(i);
        }
    }

    public void g(int i) throws IOException {
        while ((i & (-128)) != 0) {
            e((i & 127) | 128);
            i >>>= 7;
        }
        e(i);
    }

    public static int a(int i, WireType wireType) {
        return (i << 3) | wireType.value();
    }

    void b(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f25750b;
        int i4 = this.f25751c;
        if (i3 - i4 >= i2) {
            System.arraycopy(bArr, i, this.f25749a, i4, i2);
            this.f25751c += i2;
            return;
        }
        throw new IOException("Out of space: position=" + this.f25751c + ", limit=" + this.f25750b);
    }

    public void c(long j) throws IOException {
        while (((-128) & j) != 0) {
            e((((int) j) & 127) | 128);
            j >>>= 7;
        }
        e((int) j);
    }

    public static v a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static v a(byte[] bArr, int i, int i2) {
        return new v(bArr, i, i2);
    }

    void a(byte b2) throws IOException {
        int i = this.f25751c;
        if (i != this.f25750b) {
            byte[] bArr = this.f25749a;
            this.f25751c = i + 1;
            bArr[i] = b2;
        } else {
            throw new IOException("Out of space: position=" + this.f25751c + ", limit=" + this.f25750b);
        }
    }

    public void b(int i, WireType wireType) throws IOException {
        g(a(i, wireType));
    }

    public void b(long j) throws IOException {
        e(((int) j) & 255);
        e(((int) (j >> 8)) & 255);
        e(((int) (j >> 16)) & 255);
        e(((int) (j >> 24)) & 255);
        e(((int) (j >> 32)) & 255);
        e(((int) (j >> 40)) & 255);
        e(((int) (j >> 48)) & 255);
        e(((int) (j >> 56)) & 255);
    }
}
