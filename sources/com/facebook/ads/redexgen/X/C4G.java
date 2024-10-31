package com.facebook.ads.redexgen.X;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

/* renamed from: com.facebook.ads.redexgen.X.4G, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C4G {
    public static byte[] A00;
    public static final ThreadLocal<double[]> A01;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C4G.A00
            int r0 = r2 + r3
            byte[] r2 = java.util.Arrays.copyOfRange(r1, r2, r0)
            r1 = 0
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L19;
                case 4: goto L27;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            byte[] r2 = (byte[]) r2
            int r0 = r2.length
            if (r1 >= r0) goto L17
            r0 = 3
            goto Lc
        L17:
            r0 = 4
            goto Lc
        L19:
            byte[] r2 = (byte[]) r2
            r0 = r2[r1]
            int r0 = r0 - r4
            int r0 = r0 + (-38)
            byte r0 = (byte) r0
            r2[r1] = r0
            int r1 = r1 + 1
            r0 = 2
            goto Lc
        L27:
            byte[] r2 = (byte[]) r2
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4G.A03(int, int, int):java.lang.String");
    }

    public static void A04() {
        A00 = new byte[]{-12, -6, -7, -35, -2, -1, -91, -14, -6, -8, -7, -91, -19, -26, -5, -22, -91, -26, -91, -15, -22, -13, -20, -7, -19, -91, -12, -21, -91, -72, -77, -44, -33, -29, -37, -44, -109, -32, -24, -26, -25, -109, -43, -40, -109, -43, -40, -25, -22, -40, -40, -31, -109, -93, -109, -44, -31, -41, -109, -91, -88, -88, -95};
    }

    static {
        A04();
        A01 = new ThreadLocal<>();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public static double A00(@ColorInt int i) {
        double[] A07 = A07();
        A06(i, A07);
        return A07[1] / 100.0d;
    }

    @ColorInt
    public static int A01(@ColorInt int i, @IntRange(from = 0, to = 255) int i2) {
        char c = i2 >= 0 ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    if (i2 <= 255) {
                        c = 4;
                        break;
                    } else {
                        c = 3;
                        break;
                    }
                case 3:
                    throw new IllegalArgumentException(A03(31, 32, 77));
                case 4:
                    return (16777215 & i) | (i2 << 24);
            }
        }
    }

    @ColorInt
    public static int A02(@ColorInt int i, @ColorInt int i2, @FloatRange(from = 0.0d, to = 1.0d) float g) {
        float inverseRatio = 1.0f - g;
        return Color.argb((int) ((Color.alpha(i) * inverseRatio) + (Color.alpha(i2) * g)), (int) ((Color.red(i) * inverseRatio) + (Color.red(i2) * g)), (int) ((Color.green(i) * inverseRatio) + (Color.green(i2) * g)), (int) ((Color.blue(i) * inverseRatio) + (Color.blue(i2) * g)));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0013. Please report as an issue. */
    public static void A05(@IntRange(from = 0, to = 255) int i, @IntRange(from = 0, to = 255) int i2, @IntRange(from = 0, to = 255) int i3, @NonNull double[] dArr) {
        double sg = 0.0d;
        double sr = 0.0d;
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        char c = dArr.length != 3 ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    throw new IllegalArgumentException(A03(0, 31, 95));
                case 3:
                    d3 = i / 255.0d;
                    c = d3 < 0.04045d ? (char) 4 : '\f';
                case 4:
                    sr = d3 / 12.92d;
                    c = 5;
                case 5:
                    d = i2 / 255.0d;
                    c = d < 0.04045d ? (char) 6 : (char) 11;
                case 6:
                    sg = d / 12.92d;
                    c = 7;
                case 7:
                    d2 = i3 / 255.0d;
                    c = d2 < 0.04045d ? '\b' : '\n';
                case '\b':
                    d4 = d2 / 12.92d;
                    c = '\t';
                case '\t':
                    double[] dArr2 = dArr;
                    dArr2[0] = 100.0d * ((0.4124d * sr) + (0.3576d * sg) + (0.1805d * d4));
                    dArr2[1] = 100.0d * ((0.2126d * sr) + (0.7152d * sg) + (0.0722d * d4));
                    dArr2[2] = 100.0d * ((0.0193d * sr) + (0.1192d * sg) + (0.9505d * d4));
                    return;
                case '\n':
                    d4 = Math.pow((0.055d + d2) / 1.055d, 2.4d);
                    c = '\t';
                case 11:
                    sg = Math.pow((0.055d + d) / 1.055d, 2.4d);
                    c = 7;
                case '\f':
                    sr = Math.pow((0.055d + d3) / 1.055d, 2.4d);
                    c = 5;
            }
        }
    }

    public static void A06(@ColorInt int i, @NonNull double[] dArr) {
        A05(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    public static double[] A07() {
        double[] dArr = A01.get();
        if (dArr == null) {
            double[] dArr2 = new double[3];
            A01.set(dArr2);
            return dArr2;
        }
        return dArr;
    }
}
