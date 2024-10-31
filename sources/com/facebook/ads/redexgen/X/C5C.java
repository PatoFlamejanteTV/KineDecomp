package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.util.Log;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

@Deprecated
/* renamed from: com.facebook.ads.redexgen.X.5C, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C5C {
    public static Method A00;
    public static byte[] A01;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C5C.A01
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
            int r0 = r0 + (-127)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5C.A03(int, int, int):java.lang.String");
    }

    public static void A04() {
        A01 = new byte[]{-60, -16, -10, -19, -27, -95, -17, -16, -11, -95, -25, -22, -17, -27, -95, -18, -26, -11, -23, -16, -27, -95, -24, -26, -11, -44, -28, -30, -19, -26, -27, -44, -28, -13, -16, -19, -19, -57, -30, -28, -11, -16, -13, -87, -86, -95, -16, -17, -95, -41, -22, -26, -8, -60, -16, -17, -25, -22, -24, -10, -13, -30, -11, -22, -16, -17, 98, 96, 111, 78, 94, 92, 103, 96, 95, 78, 94, 109, 106, 103, 103, 65, 92, 94, 111, 106, 109, -37, -18, -22, -4, -56, -12, -13, -21, -18, -20, -56, -12, -14, -11, -26, -7};
    }

    static {
        A04();
        if (Build.VERSION.SDK_INT == 25) {
            try {
                A00 = ViewConfiguration.class.getDeclaredMethod(A03(66, 21, 124), new Class[0]);
            } catch (Exception unused) {
                Log.i(A03(87, 16, 6), A03(0, 66, 2));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static float A00(@android.support.annotation.NonNull android.view.ViewConfiguration r3, @android.support.annotation.NonNull android.content.Context r4) {
        /*
            r2 = 0
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 26
            if (r1 < r0) goto L1e
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L20;
                case 4: goto L14;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            android.view.ViewConfiguration r3 = (android.view.ViewConfiguration) r3
            float r2 = r3.getScaledHorizontalScrollFactor()
            r0 = 3
            goto L8
        L14:
            android.view.ViewConfiguration r3 = (android.view.ViewConfiguration) r3
            android.content.Context r4 = (android.content.Context) r4
            float r2 = A02(r3, r4)
            r0 = 3
            goto L8
        L1e:
            r0 = 4
            goto L8
        L20:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5C.A00(android.view.ViewConfiguration, android.content.Context):float");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static float A01(@android.support.annotation.NonNull android.view.ViewConfiguration r3, @android.support.annotation.NonNull android.content.Context r4) {
        /*
            r2 = 0
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 26
            if (r1 < r0) goto L1e
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L20;
                case 4: goto L14;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            android.view.ViewConfiguration r3 = (android.view.ViewConfiguration) r3
            float r2 = r3.getScaledVerticalScrollFactor()
            r0 = 3
            goto L8
        L14:
            android.view.ViewConfiguration r3 = (android.view.ViewConfiguration) r3
            android.content.Context r4 = (android.content.Context) r4
            float r2 = A02(r3, r4)
            r0 = 3
            goto L8
        L1e:
            r0 = 4
            goto L8
        L20:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5C.A01(android.view.ViewConfiguration, android.content.Context):float");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0076, code lost:            return r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static float A02(android.view.ViewConfiguration r6, android.content.Context r7) {
        /*
            r5 = 0
            r4 = 0
            r0 = 0
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 25
            if (r1 < r0) goto L73
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L3c;
                case 3: goto L12;
                case 4: goto Ld;
                case 5: goto Ld;
                case 6: goto Ld;
                case 7: goto Ld;
                case 8: goto Ld;
                case 9: goto Ld;
                case 10: goto L45;
                case 11: goto L60;
                case 12: goto L76;
                case 13: goto Le;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            r5 = 0
            r0 = 12
            goto La
        L12:
            java.lang.reflect.Method r1 = com.facebook.ads.redexgen.X.C5C.A00     // Catch: java.lang.Exception -> L25
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Exception -> L25
            java.lang.Object r0 = r1.invoke(r6, r0)     // Catch: java.lang.Exception -> L25
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Exception -> L25
            int r0 = r0.intValue()     // Catch: java.lang.Exception -> L25
            float r5 = (float) r0     // Catch: java.lang.Exception -> L25
            r0 = 12
            goto La
        L25:
            r2 = 87
            r1 = 16
            r0 = 6
            java.lang.String r3 = A03(r2, r1, r0)
            r2 = 0
            r1 = 66
            r0 = 2
            java.lang.String r0 = A03(r2, r1, r0)
            android.util.Log.i(r3, r0)
            r0 = 10
            goto La
        L3c:
            java.lang.reflect.Method r0 = com.facebook.ads.redexgen.X.C5C.A00
            if (r0 == 0) goto L42
            r0 = 3
            goto La
        L42:
            r0 = 10
            goto La
        L45:
            android.content.Context r7 = (android.content.Context) r7
            android.util.TypedValue r4 = new android.util.TypedValue
            r4.<init>()
            android.content.res.Resources$Theme r2 = r7.getTheme()
            r1 = 16842829(0x101004d, float:2.3693774E-38)
            r0 = 1
            boolean r0 = r2.resolveAttribute(r1, r4, r0)
            if (r0 == 0) goto L5d
            r0 = 11
            goto La
        L5d:
            r0 = 13
            goto La
        L60:
            android.content.Context r7 = (android.content.Context) r7
            android.util.TypedValue r4 = (android.util.TypedValue) r4
            android.content.res.Resources r0 = r7.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            float r5 = r4.getDimension(r0)
            r0 = 12
            goto La
        L73:
            r0 = 10
            goto La
        L76:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5C.A02(android.view.ViewConfiguration, android.content.Context):float");
    }
}
