package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.support.annotation.VisibleForTesting;
import android.webkit.WebSettings;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: assets/audience_network.dex */
public final class GV {
    public static String A00;
    public static byte[] A01;
    public static final AtomicBoolean A02;
    public static final AtomicReference<String> A03;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.GV.A01
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
            int r0 = r0 + (-61)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GV.A00(int, int, int):java.lang.String");
    }

    public static void A08() {
        A01 = new byte[]{-107, -62, -72, -58, -61, -67, -72, 26, 24, 10, 23, 4, 6, 12, 10, 19, 25, -78, -80, -94, -81, -100, -98, -92, -94, -85, -79, -100, -87, -98, -80, -79, -100, -81, -94, -93, -81, -94, -80, -91, -21, 4, 1, 4, 5, 13, 4, -114, -118, -108, -117, 119, -9, -13, -14, -1, -32, -14, 38, 21, 26, 22, 31, 20, 22, -1, 22, 37, 40, 32, 35, 28, -9, 32, 35, -14, 31, 21, 35, 32, 26, 21, -20, 0, -7, 15, -2, 5, -4, -4, -49, -53, -54, -53, -72, -25, -80, -94, -82, -84, 109, -91, -96, -94, -92, -95, -82, -82, -86, 109, -96, -93, -78, 109, -88, -83, -77, -92, -79, -83, -96, -85, 109, -76, -96, -25, -29, -29, -9, -48, -17, -35, -38, -41, -18, -31, -35, -17, -88, -92, -75, -72, -111, -62, -66, -46, -49, -85, -44, -48, -31, -36, -67, 28, 40, 40, 36, -30, 21, 27, 25, 34, 40, -19, -21, -12, -21, -8, -17, -23, -62, -3, -61, -65, -66, -45, -84};
    }

    static {
        A08();
        A00 = A00(40, 7, 89);
        A02 = new AtomicBoolean();
        A03 = new AtomicReference<>();
    }

    @VisibleForTesting
    @TargetApi(17)
    public static String A01(C0361Eb c0361Eb) {
        return WebSettings.getDefaultUserAgent(c0361Eb);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0041, code lost:            return r4;     */
    @android.annotation.SuppressLint({"CatchGeneralException"})
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(com.facebook.ads.redexgen.X.C0361Eb r5) {
        /*
            r4 = 0
            r0 = 0
            r0 = 0
            java.util.concurrent.FutureTask r3 = new java.util.concurrent.FutureTask
            com.facebook.ads.redexgen.X.GU r0 = new com.facebook.ads.redexgen.X.GU
            r0.<init>(r5)
            r3.<init>(r0)
            r2 = 0
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L33;
                case 3: goto L13;
                case 4: goto L1a;
                case 5: goto L12;
                case 6: goto L12;
                case 7: goto L12;
                case 8: goto L3b;
                case 9: goto L3f;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            java.util.concurrent.FutureTask r3 = (java.util.concurrent.FutureTask) r3
            com.facebook.ads.redexgen.X.K7.A00(r3)
            r0 = 4
            goto Lf
        L1a:
            java.util.concurrent.FutureTask r3 = (java.util.concurrent.FutureTask) r3     // Catch: java.lang.Throwable -> L26
            java.lang.Object r0 = r3.get()     // Catch: java.lang.Throwable -> L26
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L26
            r0 = 9
            goto Lf
        L26:
            r0 = move-exception
            A09(r5, r0)
            r0 = 500(0x1f4, double:2.47E-321)
            android.os.SystemClock.sleep(r0)
            int r2 = r2 + 1
            r0 = 2
            goto Lf
        L33:
            r0 = 3
            if (r2 >= r0) goto L38
            r0 = 3
            goto Lf
        L38:
            r0 = 8
            goto Lf
        L3b:
            r4 = 0
            r0 = 9
            goto Lf
        L3f:
            java.lang.String r4 = (java.lang.String) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GV.A02(com.facebook.ads.redexgen.X.Eb):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:            return r6;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(com.facebook.ads.redexgen.X.C0361Eb r7, com.facebook.ads.redexgen.X.C0399Fn r8) {
        /*
            r0 = 0
            java.lang.String r6 = r8.A06()
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L3d
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L1d;
                case 4: goto L3f;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            java.util.concurrent.atomic.AtomicBoolean r1 = com.facebook.ads.redexgen.X.GV.A02
            r0 = 1
            boolean r0 = r1.getAndSet(r0)
            if (r0 != 0) goto L1b
            r0 = 3
            goto Lc
        L1b:
            r0 = 4
            goto Lc
        L1d:
            com.facebook.ads.redexgen.X.Eb r7 = (com.facebook.ads.redexgen.X.C0361Eb) r7
            r2 = 163(0xa3, float:2.28E-43)
            r1 = 7
            r0 = 73
            java.lang.String r5 = A00(r2, r1, r0)
            int r4 = com.facebook.ads.redexgen.X.C0512Kc.A1A
            com.facebook.ads.redexgen.X.Ke r3 = new com.facebook.ads.redexgen.X.Ke
            r2 = 83
            r1 = 7
            r0 = 115(0x73, float:1.61E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            r3.<init>(r0)
            com.facebook.ads.redexgen.X.C0511Kb.A06(r7, r5, r4, r3)
            r0 = 4
            goto Lc
        L3d:
            r0 = 4
            goto Lc
        L3f:
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r6 = (java.lang.String) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GV.A03(com.facebook.ads.redexgen.X.Eb, com.facebook.ads.redexgen.X.Fn):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x0140, code lost:            return r5;     */
    @android.annotation.SuppressLint({"CatchGeneralException"})
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A04(com.facebook.ads.redexgen.X.C0361Eb r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GV.A04(com.facebook.ads.redexgen.X.Eb, boolean):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0093, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A05(com.facebook.ads.redexgen.X.C0399Fn r4, com.facebook.ads.redexgen.X.C0361Eb r5) {
        /*
            r1 = 0
            boolean r0 = com.facebook.ads.redexgen.X.C0412Gb.A04(r5)
            if (r0 == 0) goto L8c
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L8f;
                case 4: goto L81;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.Fn r4 = (com.facebook.ads.redexgen.X.C0399Fn) r4
            com.facebook.ads.redexgen.X.Eb r5 = (com.facebook.ads.redexgen.X.C0361Eb) r5
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = 90
            r1 = 5
            r0 = 76
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.StringBuilder r1 = r3.append(r0)
            java.lang.String r0 = A03(r5, r4)
            java.lang.StringBuilder r3 = r1.append(r0)
            r2 = 96
            r1 = 1
            r0 = 56
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.StringBuilder r3 = r3.append(r0)
            r2 = 172(0xac, float:2.41E-43)
            r1 = 5
            r0 = 64
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.StringBuilder r1 = r3.append(r0)
            java.lang.String r0 = r4.A05()
            java.lang.StringBuilder r3 = r1.append(r0)
            r2 = 96
            r1 = 1
            r0 = 56
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.StringBuilder r3 = r3.append(r0)
            r2 = 125(0x7d, float:1.75E-43)
            r1 = 5
            r0 = 100
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.StringBuilder r1 = r3.append(r0)
            int r0 = r4.A03()
            java.lang.StringBuilder r3 = r1.append(r0)
            r2 = 96
            r1 = 1
            r0 = 56
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r1 = r0.toString()
            r0 = 3
            goto L8
        L81:
            r2 = 7
            r1 = 0
            r0 = 91
            java.lang.String r1 = A00(r2, r1, r0)
            r0 = 3
            goto L8
        L8c:
            r0 = 4
            goto L8
        L8f:
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GV.A05(com.facebook.ads.redexgen.X.Fn, com.facebook.ads.redexgen.X.Eb):java.lang.String");
    }

    public static String A06(C0399Fn c0399Fn, C0361Eb c0361Eb, boolean z) {
        return A04(c0361Eb, z) + A00(170, 2, 101) + A00(52, 31, 116) + A00(148, 5, 81) + A00(0, 7, 23) + A00(96, 1, 56) + A00(138, 5, 37) + C0399Fn.A02 + A00(96, 1, 56) + A05(c0399Fn, c0361Eb) + A00(143, 5, 63) + BuildConfigApi.getVersionName(c0361Eb) + A00(96, 1, 56) + A00(47, 5, 11) + Locale.getDefault().toString() + A00(95, 1, 77);
    }

    public static void A09(C0361Eb c0361Eb, Throwable th) {
        C0511Kb.A06(c0361Eb, A00(130, 8, 59), C0512Kc.A1o, new C0514Ke(th));
    }
}
