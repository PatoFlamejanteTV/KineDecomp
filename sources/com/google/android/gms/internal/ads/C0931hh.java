package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.ads.hh */
/* loaded from: classes2.dex */
final class C0931hh {
    private static long a(byte[] bArr, int i) {
        return (((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16)) & 4294967295L;
    }

    private static long a(byte[] bArr, int i, int i2) {
        return (a(bArr, i) >> i2) & 67108863;
    }

    private static void a(byte[] bArr, long j, int i) {
        int i2 = 0;
        while (i2 < 4) {
            bArr[i + i2] = (byte) (255 & j);
            i2++;
            j >>= 8;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 32) {
            long a2 = a(bArr, 0, 0) & 67108863;
            int i = 2;
            int i2 = 3;
            long a3 = a(bArr, 3, 2) & 67108611;
            long a4 = a(bArr, 6, 4) & 67092735;
            long a5 = a(bArr, 9, 6) & 66076671;
            long a6 = a(bArr, 12, 8) & 1048575;
            long j = a3 * 5;
            long j2 = a4 * 5;
            long j3 = a5 * 5;
            long j4 = a6 * 5;
            byte[] bArr3 = new byte[17];
            long j5 = 0;
            long j6 = 0;
            long j7 = 0;
            long j8 = 0;
            long j9 = 0;
            int i3 = 0;
            while (i3 < bArr2.length) {
                int min = Math.min(16, bArr2.length - i3);
                System.arraycopy(bArr2, i3, bArr3, 0, min);
                bArr3[min] = 1;
                if (min != 16) {
                    Arrays.fill(bArr3, min + 1, 17, (byte) 0);
                }
                long a7 = j9 + a(bArr3, 0, 0);
                long a8 = j5 + a(bArr3, i2, i);
                long a9 = j6 + a(bArr3, 6, 4);
                long a10 = j7 + a(bArr3, 9, 6);
                long a11 = j8 + (a(bArr3, 12, 8) | (bArr3[16] << 24));
                long j10 = (a7 * a2) + (a8 * j4) + (a9 * j3) + (a10 * j2) + (a11 * j);
                long j11 = (a7 * a3) + (a8 * a2) + (a9 * j4) + (a10 * j3) + (a11 * j2);
                long j12 = (a7 * a4) + (a8 * a3) + (a9 * a2) + (a10 * j4) + (a11 * j3);
                long j13 = (a7 * a5) + (a8 * a4) + (a9 * a3) + (a10 * a2) + (a11 * j4);
                long j14 = j11 + (j10 >> 26);
                long j15 = j12 + (j14 >> 26);
                long j16 = j13 + (j15 >> 26);
                long j17 = (a7 * a6) + (a8 * a5) + (a9 * a4) + (a10 * a3) + (a11 * a2) + (j16 >> 26);
                long j18 = (j10 & 67108863) + ((j17 >> 26) * 5);
                j5 = (j14 & 67108863) + (j18 >> 26);
                i3 += 16;
                j6 = j15 & 67108863;
                j7 = j16 & 67108863;
                j8 = j17 & 67108863;
                j9 = j18 & 67108863;
                i = 2;
                i2 = 3;
            }
            long j19 = j6 + (j5 >> 26);
            long j20 = j19 & 67108863;
            long j21 = j7 + (j19 >> 26);
            long j22 = j21 & 67108863;
            long j23 = j8 + (j21 >> 26);
            long j24 = j23 & 67108863;
            long j25 = j9 + ((j23 >> 26) * 5);
            long j26 = j25 & 67108863;
            long j27 = (j5 & 67108863) + (j25 >> 26);
            long j28 = j26 + 5;
            long j29 = j28 & 67108863;
            long j30 = (j28 >> 26) + j27;
            long j31 = j20 + (j30 >> 26);
            long j32 = j22 + (j31 >> 26);
            long j33 = j32 & 67108863;
            long j34 = (j24 + (j32 >> 26)) - 67108864;
            long j35 = j34 >> 63;
            long j36 = j26 & j35;
            long j37 = j27 & j35;
            long j38 = j20 & j35;
            long j39 = j22 & j35;
            long j40 = j24 & j35;
            long j41 = j35 ^ (-1);
            long j42 = (j30 & 67108863 & j41) | j37;
            long j43 = (j31 & 67108863 & j41) | j38;
            long j44 = (j33 & j41) | j39;
            long j45 = (j34 & j41) | j40;
            long j46 = ((j42 << 26) | j36 | (j29 & j41)) & 4294967295L;
            long j47 = ((j42 >> 6) | (j43 << 20)) & 4294967295L;
            long j48 = ((j43 >> 12) | (j44 << 14)) & 4294967295L;
            long j49 = ((j44 >> 18) | (j45 << 8)) & 4294967295L;
            long a12 = j46 + a(bArr, 16);
            long j50 = a12 & 4294967295L;
            long a13 = j47 + a(bArr, 20) + (a12 >> 32);
            long j51 = a13 & 4294967295L;
            long a14 = j48 + a(bArr, 24) + (a13 >> 32);
            long j52 = a14 & 4294967295L;
            long a15 = (j49 + a(bArr, 28) + (a14 >> 32)) & 4294967295L;
            byte[] bArr4 = new byte[16];
            a(bArr4, j50, 0);
            a(bArr4, j51, 4);
            a(bArr4, j52, 8);
            a(bArr4, a15, 12);
            return bArr4;
        }
        throw new IllegalArgumentException("The key length in bytes must be 32.");
    }
}
