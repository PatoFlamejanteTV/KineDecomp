package com.google.api.client.repackaged.org.apache.commons.codec.binary;

/* loaded from: classes.dex */
public class Base64 extends BaseNCodec {

    /* renamed from: a, reason: collision with root package name */
    static final byte[] f2504a = {13, 10};
    private static final byte[] i = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] k = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};
    private final byte[] l;
    private final byte[] m;
    private final byte[] n;
    private final int o;
    private final int p;
    private int q;

    public Base64() {
        this(0);
    }

    public Base64(boolean z) {
        this(76, f2504a, z);
    }

    public Base64(int i2) {
        this(i2, f2504a);
    }

    public Base64(int i2, byte[] bArr) {
        this(i2, bArr, false);
    }

    public Base64(int i2, byte[] bArr, boolean z) {
        super(3, 4, i2, bArr == null ? 0 : bArr.length);
        this.m = k;
        if (bArr != null) {
            if (f(bArr)) {
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + StringUtils.a(bArr) + "]");
            }
            if (i2 > 0) {
                this.p = bArr.length + 4;
                this.n = new byte[bArr.length];
                System.arraycopy(bArr, 0, this.n, 0, bArr.length);
            } else {
                this.p = 4;
                this.n = null;
            }
        } else {
            this.p = 4;
            this.n = null;
        }
        this.o = this.p - 1;
        this.l = z ? j : i;
    }

    @Override // com.google.api.client.repackaged.org.apache.commons.codec.binary.BaseNCodec
    void a(byte[] bArr, int i2, int i3) {
        if (!this.f) {
            if (i3 < 0) {
                this.f = true;
                if (this.h != 0 || this.c != 0) {
                    a(this.p);
                    int i4 = this.e;
                    switch (this.h) {
                        case 1:
                            byte[] bArr2 = this.d;
                            int i5 = this.e;
                            this.e = i5 + 1;
                            bArr2[i5] = this.l[(this.q >> 2) & 63];
                            byte[] bArr3 = this.d;
                            int i6 = this.e;
                            this.e = i6 + 1;
                            bArr3[i6] = this.l[(this.q << 4) & 63];
                            if (this.l == i) {
                                byte[] bArr4 = this.d;
                                int i7 = this.e;
                                this.e = i7 + 1;
                                bArr4[i7] = 61;
                                byte[] bArr5 = this.d;
                                int i8 = this.e;
                                this.e = i8 + 1;
                                bArr5[i8] = 61;
                                break;
                            }
                            break;
                        case 2:
                            byte[] bArr6 = this.d;
                            int i9 = this.e;
                            this.e = i9 + 1;
                            bArr6[i9] = this.l[(this.q >> 10) & 63];
                            byte[] bArr7 = this.d;
                            int i10 = this.e;
                            this.e = i10 + 1;
                            bArr7[i10] = this.l[(this.q >> 4) & 63];
                            byte[] bArr8 = this.d;
                            int i11 = this.e;
                            this.e = i11 + 1;
                            bArr8[i11] = this.l[(this.q << 2) & 63];
                            if (this.l == i) {
                                byte[] bArr9 = this.d;
                                int i12 = this.e;
                                this.e = i12 + 1;
                                bArr9[i12] = 61;
                                break;
                            }
                            break;
                    }
                    this.g = (this.e - i4) + this.g;
                    if (this.c > 0 && this.g > 0) {
                        System.arraycopy(this.n, 0, this.d, this.e, this.n.length);
                        this.e += this.n.length;
                        return;
                    }
                    return;
                }
                return;
            }
            int i13 = 0;
            while (i13 < i3) {
                a(this.p);
                this.h = (this.h + 1) % 3;
                int i14 = i2 + 1;
                int i15 = bArr[i2];
                if (i15 < 0) {
                    i15 += 256;
                }
                this.q = i15 + (this.q << 8);
                if (this.h == 0) {
                    byte[] bArr10 = this.d;
                    int i16 = this.e;
                    this.e = i16 + 1;
                    bArr10[i16] = this.l[(this.q >> 18) & 63];
                    byte[] bArr11 = this.d;
                    int i17 = this.e;
                    this.e = i17 + 1;
                    bArr11[i17] = this.l[(this.q >> 12) & 63];
                    byte[] bArr12 = this.d;
                    int i18 = this.e;
                    this.e = i18 + 1;
                    bArr12[i18] = this.l[(this.q >> 6) & 63];
                    byte[] bArr13 = this.d;
                    int i19 = this.e;
                    this.e = i19 + 1;
                    bArr13[i19] = this.l[this.q & 63];
                    this.g += 4;
                    if (this.c > 0 && this.c <= this.g) {
                        System.arraycopy(this.n, 0, this.d, this.e, this.n.length);
                        this.e += this.n.length;
                        this.g = 0;
                    }
                }
                i13++;
                i2 = i14;
            }
        }
    }

    @Override // com.google.api.client.repackaged.org.apache.commons.codec.binary.BaseNCodec
    void b(byte[] bArr, int i2, int i3) {
        byte b;
        if (!this.f) {
            if (i3 < 0) {
                this.f = true;
            }
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    break;
                }
                a(this.o);
                int i5 = i2 + 1;
                byte b2 = bArr[i2];
                if (b2 == 61) {
                    this.f = true;
                    break;
                }
                if (b2 >= 0 && b2 < k.length && (b = k[b2]) >= 0) {
                    this.h = (this.h + 1) % 4;
                    this.q = b + (this.q << 6);
                    if (this.h == 0) {
                        byte[] bArr2 = this.d;
                        int i6 = this.e;
                        this.e = i6 + 1;
                        bArr2[i6] = (byte) ((this.q >> 16) & 255);
                        byte[] bArr3 = this.d;
                        int i7 = this.e;
                        this.e = i7 + 1;
                        bArr3[i7] = (byte) ((this.q >> 8) & 255);
                        byte[] bArr4 = this.d;
                        int i8 = this.e;
                        this.e = i8 + 1;
                        bArr4[i8] = (byte) (this.q & 255);
                    }
                }
                i4++;
                i2 = i5;
            }
            if (this.f && this.h != 0) {
                a(this.o);
                switch (this.h) {
                    case 2:
                        this.q >>= 4;
                        byte[] bArr5 = this.d;
                        int i9 = this.e;
                        this.e = i9 + 1;
                        bArr5[i9] = (byte) (this.q & 255);
                        return;
                    case 3:
                        this.q >>= 2;
                        byte[] bArr6 = this.d;
                        int i10 = this.e;
                        this.e = i10 + 1;
                        bArr6[i10] = (byte) ((this.q >> 8) & 255);
                        byte[] bArr7 = this.d;
                        int i11 = this.e;
                        this.e = i11 + 1;
                        bArr7[i11] = (byte) (this.q & 255);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public static byte[] a(byte[] bArr) {
        return a(bArr, false);
    }

    public static String b(byte[] bArr) {
        return StringUtils.a(a(bArr, false));
    }

    public static String c(byte[] bArr) {
        return StringUtils.a(a(bArr, false, true));
    }

    public static byte[] a(byte[] bArr, boolean z) {
        return a(bArr, z, false);
    }

    public static byte[] a(byte[] bArr, boolean z, boolean z2) {
        return a(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static byte[] a(byte[] bArr, boolean z, boolean z2, int i2) {
        if (bArr != null && bArr.length != 0) {
            Base64 base64 = z ? new Base64(z2) : new Base64(0, f2504a, z2);
            long g = base64.g(bArr);
            if (g > i2) {
                throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + g + ") than the specified maximum size of " + i2);
            }
            return base64.e(bArr);
        }
        return bArr;
    }

    public static byte[] a(String str) {
        return new Base64().b(str);
    }

    @Override // com.google.api.client.repackaged.org.apache.commons.codec.binary.BaseNCodec
    protected boolean a(byte b) {
        return b >= 0 && b < this.m.length && this.m[b] != -1;
    }
}
