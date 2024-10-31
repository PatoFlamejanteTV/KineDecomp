package com.google.zxing.common;

import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;

/* loaded from: classes2.dex */
public final class HybridBinarizer extends GlobalHistogramBinarizer {

    /* renamed from: e */
    private BitMatrix f19075e;

    private static int a(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public BitMatrix a() throws NotFoundException {
        BitMatrix bitMatrix = this.f19075e;
        if (bitMatrix != null) {
            return bitMatrix;
        }
        LuminanceSource b2 = b();
        int c2 = b2.c();
        int a2 = b2.a();
        if (c2 >= 40 && a2 >= 40) {
            byte[] b3 = b2.b();
            int i = c2 >> 3;
            if ((c2 & 7) != 0) {
                i++;
            }
            int i2 = i;
            int i3 = a2 >> 3;
            if ((a2 & 7) != 0) {
                i3++;
            }
            int i4 = i3;
            int[][] a3 = a(b3, i2, i4, c2, a2);
            BitMatrix bitMatrix2 = new BitMatrix(c2, a2);
            a(b3, i2, i4, c2, a2, a3, bitMatrix2);
            this.f19075e = bitMatrix2;
        } else {
            this.f19075e = super.a();
        }
        return this.f19075e;
    }

    private static void a(byte[] bArr, int i, int i2, int i3, int i4, int[][] iArr, BitMatrix bitMatrix) {
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i5 << 3;
            int i7 = i4 - 8;
            if (i6 > i7) {
                i6 = i7;
            }
            for (int i8 = 0; i8 < i; i8++) {
                int i9 = i8 << 3;
                int i10 = i3 - 8;
                if (i9 <= i10) {
                    i10 = i9;
                }
                int a2 = a(i8, 2, i - 3);
                int a3 = a(i5, 2, i2 - 3);
                int i11 = 0;
                for (int i12 = -2; i12 <= 2; i12++) {
                    int[] iArr2 = iArr[a3 + i12];
                    i11 += iArr2[a2 - 2] + iArr2[a2 - 1] + iArr2[a2] + iArr2[a2 + 1] + iArr2[a2 + 2];
                }
                a(bArr, i10, i6, i11 / 25, i3, bitMatrix);
            }
        }
    }

    private static void a(byte[] bArr, int i, int i2, int i3, int i4, BitMatrix bitMatrix) {
        int i5 = (i2 * i4) + i;
        int i6 = 0;
        while (i6 < 8) {
            for (int i7 = 0; i7 < 8; i7++) {
                if ((bArr[i5 + i7] & 255) <= i3) {
                    bitMatrix.b(i + i7, i2 + i6);
                }
            }
            i6++;
            i5 += i4;
        }
    }

    private static int[][] a(byte[] bArr, int i, int i2, int i3, int i4) {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, i2, i);
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i5 << 3;
            int i7 = i4 - 8;
            if (i6 > i7) {
                i6 = i7;
            }
            for (int i8 = 0; i8 < i; i8++) {
                int i9 = i8 << 3;
                int i10 = i3 - 8;
                if (i9 > i10) {
                    i9 = i10;
                }
                int i11 = (i6 * i3) + i9;
                int i12 = 0;
                int i13 = 0;
                int i14 = 0;
                int i15 = 255;
                while (i12 < 8) {
                    int i16 = i13;
                    for (int i17 = 0; i17 < 8; i17++) {
                        int i18 = bArr[i11 + i17] & 255;
                        i16 += i18;
                        if (i18 < i15) {
                            i15 = i18;
                        }
                        if (i18 > i14) {
                            i14 = i18;
                        }
                    }
                    if (i14 - i15 <= 24) {
                        i13 = i16;
                        i12++;
                        i11 += i3;
                    }
                    while (true) {
                        i12++;
                        i11 += i3;
                        if (i12 < 8) {
                            for (int i19 = 0; i19 < 8; i19++) {
                                i16 += bArr[i11 + i19] & 255;
                            }
                        }
                    }
                    i13 = i16;
                    i12++;
                    i11 += i3;
                }
                int i20 = i13 >> 6;
                if (i14 - i15 <= 24) {
                    i20 = i15 / 2;
                    if (i5 > 0 && i8 > 0) {
                        int i21 = i5 - 1;
                        int i22 = i8 - 1;
                        int i23 = ((iArr[i21][i8] + (iArr[i5][i22] * 2)) + iArr[i21][i22]) / 4;
                        if (i15 < i23) {
                            i20 = i23;
                        }
                    }
                }
                iArr[i5][i8] = i20;
            }
        }
        return iArr;
    }
}
