package com.fasterxml.jackson.core.io;

import java.math.BigDecimal;

/* compiled from: NumberInput.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a */
    static final String f9774a = String.valueOf(Long.MIN_VALUE).substring(1);

    /* renamed from: b */
    static final String f9775b = String.valueOf(Long.MAX_VALUE);

    public static boolean a(char[] cArr, int i, int i2, boolean z) {
        String str = z ? f9774a : f9775b;
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

    public static int b(char[] cArr, int i, int i2) {
        int i3 = cArr[i] - '0';
        if (i2 > 4) {
            int i4 = ((i3 * 10) + (cArr[r5] - '0')) * 10;
            int i5 = (i4 + (cArr[r5] - '0')) * 10;
            int i6 = (i5 + (cArr[r5] - '0')) * 10;
            i = i + 1 + 1 + 1 + 1;
            i3 = i6 + (cArr[i] - '0');
            i2 -= 4;
            if (i2 > 4) {
                int i7 = ((i3 * 10) + (cArr[r5] - '0')) * 10;
                int i8 = (i7 + (cArr[r5] - '0')) * 10;
                int i9 = i + 1 + 1 + 1;
                return ((i8 + (cArr[i9] - '0')) * 10) + (cArr[i9 + 1] - '0');
            }
        }
        if (i2 <= 1) {
            return i3;
        }
        int i10 = i + 1;
        int i11 = (i3 * 10) + (cArr[i10] - '0');
        if (i2 <= 2) {
            return i11;
        }
        int i12 = i10 + 1;
        int i13 = (i11 * 10) + (cArr[i12] - '0');
        return i2 > 3 ? (i13 * 10) + (cArr[i12 + 1] - '0') : i13;
    }

    public static long c(char[] cArr, int i, int i2) {
        int i3 = i2 - 9;
        return (b(cArr, i, i3) * 1000000000) + b(cArr, i + i3, 9);
    }

    private static NumberFormatException c(String str) {
        return new NumberFormatException("Value \"" + str + "\" can not be represented as BigDecimal");
    }

    public static BigDecimal a(String str) throws NumberFormatException {
        try {
            return new BigDecimal(str);
        } catch (NumberFormatException unused) {
            throw c(str);
        }
    }

    public static BigDecimal a(char[] cArr) throws NumberFormatException {
        return a(cArr, 0, cArr.length);
    }

    public static BigDecimal a(char[] cArr, int i, int i2) throws NumberFormatException {
        try {
            return new BigDecimal(cArr, i, i2);
        } catch (NumberFormatException unused) {
            throw c(new String(cArr, i, i2));
        }
    }

    public static double b(String str) throws NumberFormatException {
        if ("2.2250738585072012e-308".equals(str)) {
            return Double.MIN_VALUE;
        }
        return Double.parseDouble(str);
    }
}
