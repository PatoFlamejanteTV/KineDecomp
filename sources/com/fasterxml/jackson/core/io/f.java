package com.fasterxml.jackson.core.io;

/* compiled from: NumberInput.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    static final String f437a = String.valueOf(Long.MIN_VALUE).substring(1);
    static final String b = String.valueOf(Long.MAX_VALUE);

    public static int a(char[] cArr, int i, int i2) {
        int i3 = cArr[i] - '0';
        int i4 = i2 + i;
        int i5 = i + 1;
        if (i5 < i4) {
            int i6 = (i3 * 10) + (cArr[i5] - '0');
            int i7 = i5 + 1;
            if (i7 < i4) {
                int i8 = (i6 * 10) + (cArr[i7] - '0');
                int i9 = i7 + 1;
                if (i9 < i4) {
                    int i10 = (i8 * 10) + (cArr[i9] - '0');
                    int i11 = i9 + 1;
                    if (i11 < i4) {
                        int i12 = (i10 * 10) + (cArr[i11] - '0');
                        int i13 = i11 + 1;
                        if (i13 < i4) {
                            int i14 = (i12 * 10) + (cArr[i13] - '0');
                            int i15 = i13 + 1;
                            if (i15 < i4) {
                                int i16 = (i14 * 10) + (cArr[i15] - '0');
                                int i17 = i15 + 1;
                                if (i17 < i4) {
                                    int i18 = (i16 * 10) + (cArr[i17] - '0');
                                    if (i17 + 1 < i4) {
                                        return (i18 * 10) + (cArr[r2] - '0');
                                    }
                                    return i18;
                                }
                                return i16;
                            }
                            return i14;
                        }
                        return i12;
                    }
                    return i10;
                }
                return i8;
            }
            return i6;
        }
        return i3;
    }

    public static long b(char[] cArr, int i, int i2) {
        int i3 = i2 - 9;
        return a(cArr, i3 + i, 9) + (a(cArr, i, i3) * 1000000000);
    }

    public static boolean a(char[] cArr, int i, int i2, boolean z) {
        String str = z ? f437a : b;
        int length = str.length();
        if (i2 < length) {
            return true;
        }
        if (i2 > length) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            int charAt = cArr[i + i3] - str.charAt(i3);
            if (charAt != 0) {
                return charAt < 0;
            }
        }
        return true;
    }

    public static double a(String str) throws NumberFormatException {
        if ("2.2250738585072012e-308".equals(str)) {
            return Double.MIN_VALUE;
        }
        return Double.parseDouble(str);
    }
}
