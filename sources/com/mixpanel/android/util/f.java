package com.mixpanel.android.util;

import android.graphics.Bitmap;
import java.lang.reflect.Array;

/* compiled from: StackBlurManager.java */
/* loaded from: classes.dex */
public class f {
    public static void a(Bitmap bitmap, int i) {
        if (i >= 1) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            int i2 = width - 1;
            int i3 = height - 1;
            int i4 = width * height;
            int i5 = i + i + 1;
            int[] iArr2 = new int[i4];
            int[] iArr3 = new int[i4];
            int[] iArr4 = new int[i4];
            int[] iArr5 = new int[Math.max(width, height)];
            int i6 = (i5 + 1) >> 1;
            int i7 = i6 * i6;
            int[] iArr6 = new int[i7 * 256];
            for (int i8 = 0; i8 < i7 * 256; i8++) {
                iArr6[i8] = i8 / i7;
            }
            int i9 = 0;
            int i10 = 0;
            int[][] iArr7 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i5, 3);
            int i11 = i + 1;
            int i12 = 0;
            while (true) {
                int i13 = i9;
                int i14 = i12;
                if (i14 >= height) {
                    break;
                }
                int i15 = 0;
                int i16 = 0;
                int i17 = 0;
                int i18 = 0;
                int i19 = 0;
                int i20 = 0;
                int i21 = 0;
                int i22 = 0;
                int i23 = 0;
                for (int i24 = -i; i24 <= i; i24++) {
                    int i25 = iArr[Math.min(i2, Math.max(i24, 0)) + i10];
                    int[] iArr8 = iArr7[i24 + i];
                    iArr8[0] = (16711680 & i25) >> 16;
                    iArr8[1] = (65280 & i25) >> 8;
                    iArr8[2] = i25 & 255;
                    int abs = i11 - Math.abs(i24);
                    i22 += iArr8[0] * abs;
                    i21 += iArr8[1] * abs;
                    i20 += abs * iArr8[2];
                    if (i24 > 0) {
                        i16 += iArr8[0];
                        i23 += iArr8[1];
                        i15 += iArr8[2];
                    } else {
                        i19 += iArr8[0];
                        i18 += iArr8[1];
                        i17 += iArr8[2];
                    }
                }
                int i26 = i22;
                int i27 = i21;
                int i28 = i20;
                int i29 = i10;
                int i30 = i;
                for (int i31 = 0; i31 < width; i31++) {
                    iArr2[i29] = iArr6[i26];
                    iArr3[i29] = iArr6[i27];
                    iArr4[i29] = iArr6[i28];
                    int i32 = i26 - i19;
                    int i33 = i27 - i18;
                    int i34 = i28 - i17;
                    int[] iArr9 = iArr7[((i30 - i) + i5) % i5];
                    int i35 = i19 - iArr9[0];
                    int i36 = i18 - iArr9[1];
                    int i37 = i17 - iArr9[2];
                    if (i14 == 0) {
                        iArr5[i31] = Math.min(i31 + i + 1, i2);
                    }
                    int i38 = iArr[iArr5[i31] + i13];
                    iArr9[0] = (16711680 & i38) >> 16;
                    iArr9[1] = (65280 & i38) >> 8;
                    iArr9[2] = i38 & 255;
                    int i39 = i16 + iArr9[0];
                    int i40 = i23 + iArr9[1];
                    int i41 = i15 + iArr9[2];
                    i26 = i32 + i39;
                    i27 = i33 + i40;
                    i28 = i34 + i41;
                    i30 = (i30 + 1) % i5;
                    int[] iArr10 = iArr7[i30 % i5];
                    i19 = i35 + iArr10[0];
                    i18 = i36 + iArr10[1];
                    i17 = i37 + iArr10[2];
                    i16 = i39 - iArr10[0];
                    i23 = i40 - iArr10[1];
                    i15 = i41 - iArr10[2];
                    i29++;
                }
                i9 = i13 + width;
                i12 = i14 + 1;
                i10 = i29;
            }
            for (int i42 = 0; i42 < width; i42++) {
                int i43 = 0;
                int i44 = (-i) * width;
                int i45 = 0;
                int i46 = 0;
                int i47 = 0;
                int i48 = 0;
                int i49 = -i;
                int i50 = 0;
                int i51 = 0;
                int i52 = 0;
                int i53 = 0;
                while (i49 <= i) {
                    int max = Math.max(0, i44) + i42;
                    int[] iArr11 = iArr7[i49 + i];
                    iArr11[0] = iArr2[max];
                    iArr11[1] = iArr3[max];
                    iArr11[2] = iArr4[max];
                    int abs2 = i11 - Math.abs(i49);
                    int i54 = (iArr2[max] * abs2) + i52;
                    int i55 = (iArr3[max] * abs2) + i51;
                    int i56 = (iArr4[max] * abs2) + i50;
                    if (i49 > 0) {
                        i45 += iArr11[0];
                        i53 += iArr11[1];
                        i43 += iArr11[2];
                    } else {
                        i48 += iArr11[0];
                        i47 += iArr11[1];
                        i46 += iArr11[2];
                    }
                    if (i49 < i3) {
                        i44 += width;
                    }
                    i49++;
                    i50 = i56;
                    i51 = i55;
                    i52 = i54;
                }
                int i57 = i51;
                int i58 = i52;
                int i59 = i50;
                int i60 = i42;
                int i61 = i43;
                int i62 = i53;
                int i63 = i45;
                int i64 = i46;
                int i65 = i47;
                int i66 = i48;
                int i67 = i;
                for (int i68 = 0; i68 < height; i68++) {
                    iArr[i60] = (-16777216) | (iArr6[i58] << 16) | (iArr6[i57] << 8) | iArr6[i59];
                    int i69 = i58 - i66;
                    int i70 = i57 - i65;
                    int i71 = i59 - i64;
                    int[] iArr12 = iArr7[((i67 - i) + i5) % i5];
                    int i72 = i66 - iArr12[0];
                    int i73 = i65 - iArr12[1];
                    int i74 = i64 - iArr12[2];
                    if (i42 == 0) {
                        iArr5[i68] = Math.min(i68 + i11, i3) * width;
                    }
                    int i75 = iArr5[i68] + i42;
                    iArr12[0] = iArr2[i75];
                    iArr12[1] = iArr3[i75];
                    iArr12[2] = iArr4[i75];
                    int i76 = i63 + iArr12[0];
                    int i77 = i62 + iArr12[1];
                    int i78 = i61 + iArr12[2];
                    i58 = i69 + i76;
                    i57 = i70 + i77;
                    i59 = i71 + i78;
                    i67 = (i67 + 1) % i5;
                    int[] iArr13 = iArr7[i67];
                    i66 = i72 + iArr13[0];
                    i65 = i73 + iArr13[1];
                    i64 = i74 + iArr13[2];
                    i63 = i76 - iArr13[0];
                    i62 = i77 - iArr13[1];
                    i61 = i78 - iArr13[2];
                    i60 += width;
                }
            }
            bitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        }
    }
}
