package com.fasterxml.jackson.core.io;

import com.facebook.internal.NativeProtocol;
import java.lang.ref.SoftReference;

/* compiled from: JsonStringEncoder.java */
/* loaded from: classes.dex */
public final class d {
    protected com.fasterxml.jackson.core.util.b b;
    protected com.fasterxml.jackson.core.util.a c;
    protected final char[] d = new char[6];
    private static final char[] e = b.g();
    private static final byte[] f = b.h();

    /* renamed from: a, reason: collision with root package name */
    protected static final ThreadLocal<SoftReference<d>> f435a = new ThreadLocal<>();

    public d() {
        this.d[0] = '\\';
        this.d[2] = '0';
        this.d[3] = '0';
    }

    public static d a() {
        SoftReference<d> softReference = f435a.get();
        d dVar = softReference == null ? null : softReference.get();
        if (dVar == null) {
            d dVar2 = new d();
            f435a.set(new SoftReference<>(dVar2));
            return dVar2;
        }
        return dVar;
    }

    public char[] a(String str) {
        int i;
        com.fasterxml.jackson.core.util.b bVar = this.b;
        if (bVar == null) {
            bVar = new com.fasterxml.jackson.core.util.b(null);
            this.b = bVar;
        }
        char[] k = bVar.k();
        int[] f2 = b.f();
        int length = f2.length;
        int length2 = str.length();
        int i2 = 0;
        int i3 = 0;
        loop0: while (i3 < length2) {
            do {
                char charAt = str.charAt(i3);
                if (charAt >= length || f2[charAt] == 0) {
                    if (i2 >= k.length) {
                        k = bVar.m();
                        i = 0;
                    } else {
                        i = i2;
                    }
                    i2 = i + 1;
                    k[i] = charAt;
                    i3++;
                } else {
                    int i4 = i3 + 1;
                    char charAt2 = str.charAt(i3);
                    int i5 = f2[charAt2];
                    int a2 = i5 < 0 ? a(charAt2, this.d) : b(i5, this.d);
                    if (i2 + a2 > k.length) {
                        int length3 = k.length - i2;
                        if (length3 > 0) {
                            System.arraycopy(this.d, 0, k, i2, length3);
                        }
                        k = bVar.m();
                        i2 = a2 - length3;
                        System.arraycopy(this.d, length3, k, 0, i2);
                    } else {
                        System.arraycopy(this.d, 0, k, i2, a2);
                        i2 += a2;
                    }
                    i3 = i4;
                }
            } while (i3 < length2);
        }
        bVar.a(i2);
        return bVar.g();
    }

    public byte[] b(String str) {
        int i;
        int i2;
        byte[] bArr;
        int i3;
        int i4;
        int i5;
        int i6;
        com.fasterxml.jackson.core.util.a aVar = this.c;
        if (aVar == null) {
            aVar = new com.fasterxml.jackson.core.util.a(null);
            this.c = aVar;
        }
        int length = str.length();
        byte[] c = aVar.c();
        int i7 = 0;
        int i8 = 0;
        loop0: while (i8 < length) {
            int[] f2 = b.f();
            do {
                char charAt = str.charAt(i8);
                if (charAt <= 127 && f2[charAt] == 0) {
                    if (i7 >= c.length) {
                        c = aVar.d();
                        i6 = 0;
                    } else {
                        i6 = i7;
                    }
                    i7 = i6 + 1;
                    c[i6] = (byte) charAt;
                    i8++;
                } else {
                    if (i7 >= c.length) {
                        c = aVar.d();
                        i7 = 0;
                    }
                    int i9 = i8 + 1;
                    char charAt2 = str.charAt(i8);
                    if (charAt2 <= 127) {
                        i7 = a(charAt2, f2[charAt2], aVar, i7);
                        c = aVar.e();
                        i8 = i9;
                    } else {
                        if (charAt2 <= 2047) {
                            i2 = i7 + 1;
                            c[i7] = (byte) ((charAt2 >> 6) | 192);
                            bArr = c;
                            i3 = (charAt2 & '?') | 128;
                        } else if (charAt2 < 55296 || charAt2 > 57343) {
                            int i10 = i7 + 1;
                            c[i7] = (byte) ((charAt2 >> '\f') | 224);
                            if (i10 >= c.length) {
                                c = aVar.d();
                                i = 0;
                            } else {
                                i = i10;
                            }
                            i2 = i + 1;
                            c[i] = (byte) (((charAt2 >> 6) & 63) | 128);
                            bArr = c;
                            i3 = (charAt2 & '?') | 128;
                        } else {
                            if (charAt2 > 56319) {
                                a(charAt2);
                            }
                            if (i9 >= length) {
                                a(charAt2);
                            }
                            int i11 = i9 + 1;
                            int a2 = a(charAt2, str.charAt(i9));
                            if (a2 > 1114111) {
                                a(a2);
                            }
                            int i12 = i7 + 1;
                            c[i7] = (byte) ((a2 >> 18) | 240);
                            if (i12 >= c.length) {
                                c = aVar.d();
                                i4 = 0;
                            } else {
                                i4 = i12;
                            }
                            int i13 = i4 + 1;
                            c[i4] = (byte) (((a2 >> 12) & 63) | 128);
                            if (i13 >= c.length) {
                                c = aVar.d();
                                i5 = 0;
                            } else {
                                i5 = i13;
                            }
                            i2 = i5 + 1;
                            c[i5] = (byte) (((a2 >> 6) & 63) | 128);
                            int i14 = (a2 & 63) | 128;
                            i9 = i11;
                            byte[] bArr2 = c;
                            i3 = i14;
                            bArr = bArr2;
                        }
                        if (i2 >= bArr.length) {
                            bArr = aVar.d();
                            i2 = 0;
                        }
                        int i15 = i2 + 1;
                        bArr[i2] = (byte) i3;
                        c = bArr;
                        i8 = i9;
                        i7 = i15;
                    }
                }
            } while (i8 < length);
        }
        return this.c.b(i7);
    }

    public byte[] c(String str) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        com.fasterxml.jackson.core.util.a aVar = this.c;
        if (aVar == null) {
            aVar = new com.fasterxml.jackson.core.util.a(null);
            this.c = aVar;
        }
        int length = str.length();
        byte[] c = aVar.c();
        int length2 = c.length;
        int i6 = 0;
        int i7 = 0;
        loop0: while (true) {
            if (i7 >= length) {
                i = i6;
                break;
            }
            int i8 = i7 + 1;
            char charAt = str.charAt(i7);
            int i9 = length2;
            byte[] bArr = c;
            int i10 = i6;
            int i11 = i9;
            while (charAt <= 127) {
                if (i10 >= i11) {
                    bArr = aVar.d();
                    i11 = bArr.length;
                    i10 = 0;
                }
                int i12 = i10 + 1;
                bArr[i10] = (byte) charAt;
                if (i8 >= length) {
                    i = i12;
                    break loop0;
                }
                charAt = str.charAt(i8);
                i8++;
                i10 = i12;
            }
            if (i10 >= i11) {
                bArr = aVar.d();
                i11 = bArr.length;
                i2 = 0;
            } else {
                i2 = i10;
            }
            if (charAt < 2048) {
                i3 = i2 + 1;
                bArr[i2] = (byte) ((charAt >> 6) | 192);
                i4 = charAt;
                i7 = i8;
            } else if (charAt < 55296 || charAt > 57343) {
                int i13 = i2 + 1;
                bArr[i2] = (byte) ((charAt >> '\f') | 224);
                if (i13 >= i11) {
                    bArr = aVar.d();
                    i11 = bArr.length;
                    i13 = 0;
                }
                bArr[i13] = (byte) (((charAt >> 6) & 63) | 128);
                i3 = i13 + 1;
                i4 = charAt;
                i7 = i8;
            } else {
                if (charAt > 56319) {
                    a(charAt);
                }
                if (i8 >= length) {
                    a(charAt);
                }
                int i14 = i8 + 1;
                int a2 = a(charAt, str.charAt(i8));
                if (a2 > 1114111) {
                    a(a2);
                }
                int i15 = i2 + 1;
                bArr[i2] = (byte) ((a2 >> 18) | 240);
                if (i15 >= i11) {
                    bArr = aVar.d();
                    i11 = bArr.length;
                    i15 = 0;
                }
                int i16 = i15 + 1;
                bArr[i15] = (byte) (((a2 >> 12) & 63) | 128);
                if (i16 >= i11) {
                    bArr = aVar.d();
                    i11 = bArr.length;
                    i5 = 0;
                } else {
                    i5 = i16;
                }
                bArr[i5] = (byte) (((a2 >> 6) & 63) | 128);
                i3 = i5 + 1;
                i4 = a2;
                i7 = i14;
            }
            if (i3 >= i11) {
                bArr = aVar.d();
                i11 = bArr.length;
                i3 = 0;
            }
            int i17 = i3 + 1;
            bArr[i3] = (byte) ((i4 & 63) | 128);
            c = bArr;
            length2 = i11;
            i6 = i17;
        }
        return this.c.b(i);
    }

    private int a(int i, char[] cArr) {
        cArr[1] = 'u';
        cArr[4] = e[i >> 4];
        cArr[5] = e[i & 15];
        return 6;
    }

    private int b(int i, char[] cArr) {
        cArr[1] = (char) i;
        return 2;
    }

    private int a(int i, int i2, com.fasterxml.jackson.core.util.a aVar, int i3) {
        aVar.c(i3);
        aVar.a(92);
        if (i2 < 0) {
            aVar.a(117);
            if (i > 255) {
                int i4 = i >> 8;
                aVar.a(f[i4 >> 4]);
                aVar.a(f[i4 & 15]);
                i &= 255;
            } else {
                aVar.a(48);
                aVar.a(48);
            }
            aVar.a(f[i >> 4]);
            aVar.a(f[i & 15]);
        } else {
            aVar.a((byte) i2);
        }
        return aVar.f();
    }

    private int a(int i, int i2) {
        if (i2 < 56320 || i2 > 57343) {
            throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(i2) + "; illegal combination");
        }
        return NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST + ((i - 55296) << 10) + (i2 - 56320);
    }

    private void a(int i) {
        if (i > 1114111) {
            throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(i) + ") to output; max is 0x10FFFF as per RFC 4627");
        }
        if (i >= 55296) {
            if (i <= 56319) {
                throw new IllegalArgumentException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(i) + ")");
            }
            throw new IllegalArgumentException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(i) + ")");
        }
        throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(i) + ") to output");
    }
}
