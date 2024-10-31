package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public class GlobalHistogramBinarizer extends Binarizer {

    /* renamed from: b */
    private static final byte[] f19071b = new byte[0];

    /* renamed from: c */
    private byte[] f19072c;

    /* renamed from: d */
    private final int[] f19073d;

    @Override // com.google.zxing.Binarizer
    public BitMatrix a() throws NotFoundException {
        LuminanceSource b2 = b();
        int c2 = b2.c();
        int a2 = b2.a();
        BitMatrix bitMatrix = new BitMatrix(c2, a2);
        a(c2);
        int[] iArr = this.f19073d;
        for (int i = 1; i < 5; i++) {
            byte[] a3 = b2.a((a2 * i) / 5, this.f19072c);
            int i2 = (c2 << 2) / 5;
            for (int i3 = c2 / 5; i3 < i2; i3++) {
                int i4 = (a3[i3] & 255) >> 3;
                iArr[i4] = iArr[i4] + 1;
            }
        }
        int a4 = a(iArr);
        byte[] b3 = b2.b();
        for (int i5 = 0; i5 < a2; i5++) {
            int i6 = i5 * c2;
            for (int i7 = 0; i7 < c2; i7++) {
                if ((b3[i6 + i7] & 255) < a4) {
                    bitMatrix.b(i7, i5);
                }
            }
        }
        return bitMatrix;
    }

    private void a(int i) {
        if (this.f19072c.length < i) {
            this.f19072c = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.f19073d[i2] = 0;
        }
    }

    private static int a(int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (iArr[i4] > i) {
                i = iArr[i4];
                i3 = i4;
            }
            if (iArr[i4] > i2) {
                i2 = iArr[i4];
            }
        }
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = i7 - i3;
            int i9 = iArr[i7] * i8 * i8;
            if (i9 > i6) {
                i5 = i7;
                i6 = i9;
            }
        }
        if (i3 > i5) {
            int i10 = i3;
            i3 = i5;
            i5 = i10;
        }
        if (i5 - i3 <= length / 16) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i11 = i5 - 1;
        int i12 = i11;
        int i13 = -1;
        while (i11 > i3) {
            int i14 = i11 - i3;
            int i15 = i14 * i14 * (i5 - i11) * (i2 - iArr[i11]);
            if (i15 > i13) {
                i12 = i11;
                i13 = i15;
            }
            i11--;
        }
        return i12 << 3;
    }
}
