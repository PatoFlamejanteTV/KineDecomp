package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;

/* loaded from: classes2.dex */
public final class Encoder {

    /* renamed from: a */
    private static final int[] f18977a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private Encoder() {
    }

    private static int a(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }

    public static AztecCode a(byte[] bArr, int i, int i2) {
        int i3;
        BitArray bitArray;
        boolean z;
        int i4;
        int i5;
        int i6;
        BitArray a2 = new HighLevelEncoder(bArr).a();
        int a3 = ((a2.a() * i) / 100) + 11;
        int a4 = a2.a() + a3;
        int i7 = 0;
        int i8 = 1;
        if (i2 != 0) {
            z = i2 < 0;
            i4 = Math.abs(i2);
            if (i4 <= (z ? 4 : 32)) {
                i5 = a(i4, z);
                i3 = f18977a[i4];
                int i9 = i5 - (i5 % i3);
                bitArray = a(a2, i3);
                if (bitArray.a() + a3 <= i9) {
                    if (z && bitArray.a() > (i3 << 6)) {
                        throw new IllegalArgumentException("Data to large for user specified layer");
                    }
                } else {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                }
            } else {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i2)));
            }
        } else {
            BitArray bitArray2 = null;
            int i10 = 0;
            i3 = 0;
            while (i10 <= 32) {
                boolean z2 = i10 <= 3;
                int i11 = z2 ? i10 + 1 : i10;
                int a5 = a(i11, z2);
                if (a4 <= a5) {
                    int[] iArr = f18977a;
                    if (i3 != iArr[i11]) {
                        i3 = iArr[i11];
                        bitArray2 = a(a2, i3);
                    }
                    int i12 = a5 - (a5 % i3);
                    if ((!z2 || bitArray2.a() <= (i3 << 6)) && bitArray2.a() + a3 <= i12) {
                        bitArray = bitArray2;
                        z = z2;
                        i4 = i11;
                        i5 = a5;
                    }
                }
                i10++;
                i7 = 0;
                i8 = 1;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        BitArray b2 = b(bitArray, i5, i3);
        int a6 = bitArray.a() / i3;
        BitArray a7 = a(z, i4, a6);
        int i13 = (z ? 11 : 14) + (i4 << 2);
        int[] iArr2 = new int[i13];
        int i14 = 2;
        if (z) {
            for (int i15 = 0; i15 < iArr2.length; i15++) {
                iArr2[i15] = i15;
            }
            i6 = i13;
        } else {
            int i16 = i13 / 2;
            i6 = i13 + 1 + (((i16 - 1) / 15) * 2);
            int i17 = i6 / 2;
            for (int i18 = 0; i18 < i16; i18++) {
                iArr2[(i16 - i18) - i8] = (i17 - r14) - 1;
                iArr2[i16 + i18] = (i18 / 15) + i18 + i17 + i8;
            }
        }
        BitMatrix bitMatrix = new BitMatrix(i6);
        int i19 = 0;
        int i20 = 0;
        while (i19 < i4) {
            int i21 = ((i4 - i19) << i14) + (z ? 9 : 12);
            int i22 = 0;
            while (i22 < i21) {
                int i23 = i22 << 1;
                while (i7 < i14) {
                    if (b2.a(i20 + i23 + i7)) {
                        int i24 = i19 << 1;
                        bitMatrix.b(iArr2[i24 + i7], iArr2[i24 + i22]);
                    }
                    if (b2.a((i21 << 1) + i20 + i23 + i7)) {
                        int i25 = i19 << 1;
                        bitMatrix.b(iArr2[i25 + i22], iArr2[((i13 - 1) - i25) - i7]);
                    }
                    if (b2.a((i21 << 2) + i20 + i23 + i7)) {
                        int i26 = (i13 - 1) - (i19 << 1);
                        bitMatrix.b(iArr2[i26 - i7], iArr2[i26 - i22]);
                    }
                    if (b2.a((i21 * 6) + i20 + i23 + i7)) {
                        int i27 = i19 << 1;
                        bitMatrix.b(iArr2[((i13 - 1) - i27) - i22], iArr2[i27 + i7]);
                    }
                    i7++;
                    i14 = 2;
                }
                i22++;
                i7 = 0;
                i14 = 2;
            }
            i20 += i21 << 3;
            i19++;
            i7 = 0;
            i14 = 2;
        }
        a(bitMatrix, z, i6, a7);
        if (z) {
            a(bitMatrix, i6 / 2, 5);
        } else {
            int i28 = i6 / 2;
            a(bitMatrix, i28, 7);
            int i29 = 0;
            int i30 = 0;
            while (i29 < (i13 / 2) - 1) {
                for (int i31 = i28 & 1; i31 < i6; i31 += 2) {
                    int i32 = i28 - i30;
                    bitMatrix.b(i32, i31);
                    int i33 = i28 + i30;
                    bitMatrix.b(i33, i31);
                    bitMatrix.b(i31, i32);
                    bitMatrix.b(i31, i33);
                }
                i29 += 15;
                i30 += 16;
            }
        }
        AztecCode aztecCode = new AztecCode();
        aztecCode.a(z);
        aztecCode.c(i6);
        aztecCode.b(i4);
        aztecCode.a(a6);
        aztecCode.a(bitMatrix);
        return aztecCode;
    }

    private static BitArray b(BitArray bitArray, int i, int i2) {
        int a2 = bitArray.a() / i2;
        ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(a(i2));
        int i3 = i / i2;
        int[] a3 = a(bitArray, i2, i3);
        reedSolomonEncoder.a(a3, i3 - a2);
        BitArray bitArray2 = new BitArray();
        bitArray2.a(0, i % i2);
        for (int i4 : a3) {
            bitArray2.a(i4, i2);
        }
        return bitArray2;
    }

    private static void a(BitMatrix bitMatrix, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i - i3;
            int i5 = i4;
            while (true) {
                int i6 = i + i3;
                if (i5 <= i6) {
                    bitMatrix.b(i5, i4);
                    bitMatrix.b(i5, i6);
                    bitMatrix.b(i4, i5);
                    bitMatrix.b(i6, i5);
                    i5++;
                }
            }
        }
        int i7 = i - i2;
        bitMatrix.b(i7, i7);
        int i8 = i7 + 1;
        bitMatrix.b(i8, i7);
        bitMatrix.b(i7, i8);
        int i9 = i + i2;
        bitMatrix.b(i9, i7);
        bitMatrix.b(i9, i8);
        bitMatrix.b(i9, i9 - 1);
    }

    static BitArray a(boolean z, int i, int i2) {
        BitArray bitArray = new BitArray();
        if (z) {
            bitArray.a(i - 1, 2);
            bitArray.a(i2 - 1, 6);
            return b(bitArray, 28, 4);
        }
        bitArray.a(i - 1, 5);
        bitArray.a(i2 - 1, 11);
        return b(bitArray, 40, 4);
    }

    private static void a(BitMatrix bitMatrix, boolean z, int i, BitArray bitArray) {
        int i2 = i / 2;
        int i3 = 0;
        if (z) {
            while (i3 < 7) {
                int i4 = (i2 - 3) + i3;
                if (bitArray.a(i3)) {
                    bitMatrix.b(i4, i2 - 5);
                }
                if (bitArray.a(i3 + 7)) {
                    bitMatrix.b(i2 + 5, i4);
                }
                if (bitArray.a(20 - i3)) {
                    bitMatrix.b(i4, i2 + 5);
                }
                if (bitArray.a(27 - i3)) {
                    bitMatrix.b(i2 - 5, i4);
                }
                i3++;
            }
            return;
        }
        while (i3 < 10) {
            int i5 = (i2 - 5) + i3 + (i3 / 5);
            if (bitArray.a(i3)) {
                bitMatrix.b(i5, i2 - 7);
            }
            if (bitArray.a(i3 + 10)) {
                bitMatrix.b(i2 + 7, i5);
            }
            if (bitArray.a(29 - i3)) {
                bitMatrix.b(i5, i2 + 7);
            }
            if (bitArray.a(39 - i3)) {
                bitMatrix.b(i2 - 7, i5);
            }
            i3++;
        }
    }

    private static int[] a(BitArray bitArray, int i, int i2) {
        int[] iArr = new int[i2];
        int a2 = bitArray.a() / i;
        for (int i3 = 0; i3 < a2; i3++) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                i4 |= bitArray.a((i3 * i) + i5) ? 1 << ((i - i5) - 1) : 0;
            }
            iArr[i3] = i4;
        }
        return iArr;
    }

    private static GenericGF a(int i) {
        if (i == 4) {
            return GenericGF.f19081d;
        }
        if (i == 6) {
            return GenericGF.f19080c;
        }
        if (i == 8) {
            return GenericGF.f19084g;
        }
        if (i == 10) {
            return GenericGF.f19079b;
        }
        if (i == 12) {
            return GenericGF.f19078a;
        }
        throw new IllegalArgumentException("Unsupported word size " + i);
    }

    static BitArray a(BitArray bitArray, int i) {
        BitArray bitArray2 = new BitArray();
        int a2 = bitArray.a();
        int i2 = (1 << i) - 2;
        int i3 = 0;
        while (i3 < a2) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i3 + i5;
                if (i6 >= a2 || bitArray.a(i6)) {
                    i4 |= 1 << ((i - 1) - i5);
                }
            }
            int i7 = i4 & i2;
            if (i7 == i2) {
                bitArray2.a(i7, i);
            } else if (i7 == 0) {
                bitArray2.a(i4 | 1, i);
            } else {
                bitArray2.a(i4, i);
                i3 += i;
            }
            i3--;
            i3 += i;
        }
        return bitArray2;
    }
}
