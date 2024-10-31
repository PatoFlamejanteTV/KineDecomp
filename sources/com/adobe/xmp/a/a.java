package com.adobe.xmp.a;

import com.facebook.stetho.dumpapp.Framer;

/* compiled from: Base64.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private static byte[] f7490a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, Framer.EXIT_FRAME_PREFIX, 121, 122, 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b */
    private static byte[] f7491b = new byte[255];

    static {
        int i = 0;
        for (int i2 = 0; i2 < 255; i2++) {
            f7491b[i2] = -1;
        }
        while (true) {
            byte[] bArr = f7490a;
            if (i >= bArr.length) {
                byte[] bArr2 = f7491b;
                bArr2[9] = -2;
                bArr2[10] = -2;
                bArr2[13] = -2;
                bArr2[32] = -2;
                bArr2[61] = -3;
                return;
            }
            f7491b[bArr[i]] = (byte) i;
            i++;
        }
    }

    public static final byte[] a(byte[] bArr, int i) {
        int i2 = (i / 4) * 4;
        if (i2 < 0) {
            i2 = 0;
        }
        int length = ((bArr.length + 2) / 3) * 4;
        if (i2 > 0) {
            length += (length - 1) / i2;
        }
        byte[] bArr2 = new byte[length];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 + 3 <= bArr.length) {
            int i6 = i3 + 1;
            int i7 = i6 + 1;
            int i8 = ((bArr[i3] & 255) << 16) | ((bArr[i6] & 255) << 8);
            int i9 = i7 + 1;
            int i10 = i8 | ((bArr[i7] & 255) << 0);
            int i11 = i4 + 1;
            byte[] bArr3 = f7490a;
            bArr2[i4] = bArr3[(i10 & 16515072) >> 18];
            int i12 = i11 + 1;
            bArr2[i11] = bArr3[(i10 & 258048) >> 12];
            int i13 = i12 + 1;
            bArr2[i12] = bArr3[(i10 & 4032) >> 6];
            i4 = i13 + 1;
            bArr2[i13] = bArr3[i10 & 63];
            i5 += 4;
            if (i4 < length && i2 > 0 && i5 % i2 == 0) {
                bArr2[i4] = 10;
                i4++;
            }
            i3 = i9;
        }
        if (bArr.length - i3 == 2) {
            int i14 = ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3] & 255) << 16);
            int i15 = i4 + 1;
            byte[] bArr4 = f7490a;
            bArr2[i4] = bArr4[(i14 & 16515072) >> 18];
            int i16 = i15 + 1;
            bArr2[i15] = bArr4[(i14 & 258048) >> 12];
            bArr2[i16] = bArr4[(i14 & 4032) >> 6];
            bArr2[i16 + 1] = 61;
        } else if (bArr.length - i3 == 1) {
            int i17 = (bArr[i3] & 255) << 16;
            int i18 = i4 + 1;
            byte[] bArr5 = f7490a;
            bArr2[i4] = bArr5[(i17 & 16515072) >> 18];
            int i19 = i18 + 1;
            bArr2[i18] = bArr5[(i17 & 258048) >> 12];
            bArr2[i19] = 61;
            bArr2[i19 + 1] = 61;
        }
        return bArr2;
    }

    public static final byte[] b(byte[] bArr) {
        return a(bArr, 0);
    }

    public static final byte[] a(byte[] bArr) throws IllegalArgumentException {
        int i = 0;
        int i2 = 0;
        for (byte b2 : bArr) {
            byte b3 = f7491b[b2];
            if (b3 >= 0) {
                bArr[i2] = b3;
                i2++;
            } else if (b3 == -1) {
                throw new IllegalArgumentException("Invalid base 64 string");
            }
        }
        while (i2 > 0 && bArr[i2 - 1] == -3) {
            i2--;
        }
        byte[] bArr2 = new byte[(i2 * 3) / 4];
        int i3 = 0;
        while (i < bArr2.length - 2) {
            int i4 = i3 + 1;
            bArr2[i] = (byte) (((bArr[i3] << 2) & 255) | ((bArr[i4] >>> 4) & 3));
            int i5 = i3 + 2;
            bArr2[i + 1] = (byte) (((bArr[i4] << 4) & 255) | ((bArr[i5] >>> 2) & 15));
            bArr2[i + 2] = (byte) (((bArr[i5] << 6) & 255) | (bArr[i3 + 3] & 63));
            i3 += 4;
            i += 3;
        }
        if (i < bArr2.length) {
            bArr2[i] = (byte) (((bArr[i3] << 2) & 255) | ((bArr[i3 + 1] >>> 4) & 3));
        }
        int i6 = i + 1;
        if (i6 < bArr2.length) {
            bArr2[i6] = (byte) (((bArr[i3 + 2] >>> 2) & 15) | ((bArr[i3 + 1] << 4) & 255));
        }
        return bArr2;
    }
}
