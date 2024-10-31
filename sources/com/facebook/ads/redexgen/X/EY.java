package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.support.annotation.Nullable;
import org.json.JSONObject;

/* loaded from: assets/audience_network.dex */
public final class EY {
    public static int A00;
    public static int A01;
    public static int A02;
    public static int A03;
    public static int A04;
    public static int A05;
    public static int A06;
    public static int A07;
    public static byte[] A08;
    public static final String A09;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.EY.A08
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
            int r0 = r0 + (-29)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EY.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A08 = new byte[]{-108, -104, -116, -110, -112, -2, 1, -13, -10, -15, 6, -5, -1, -9, -121, -123, -121, -116, -119, -41, -44, -50, -124, -94, -92, -87, -90, 97, -87, -86, -75, 111, -3, 0, -5, -1, 14, 1, -3, 16, 5, 18, 1, -5, 16, 21, 12, 1, -104, -85, -85, -100, -92, -89, -85, -63, -33, -31, -26, -29, -98, -30, -19, -11, -20, -22, -19, -33, -30, -98, -28, -33, -25, -22, -13, -16, -29, -84, -2, -4, -2, 3, 0, -6, -2, 10, 9, 15, 0, 19, 15, -92, -89, -94, -75, -88, -76, -72, -88, -74, -73, -94, -84, -89, -83, -53, -51, -46, -49, -118, -41, -45, -35, -35, -104, -21, -18, -23, -19, -4, -17, -21, -2, -13, 0, -17, -23, -3, -13, 4, -17, -23, -20, 3, -2, -17, -3, 126, -100, -98, -93, -96, 91, -97, -92, -82, -90, 91, -82, -80, -98, -98, -96, -82, -82, 105, -103, -100, -105, -98, -89, -86, -91, -103, -84, -105, -84, -79, -88, -99, -62, -32, -30, -25, -28, -97, -29, -24, -14, -22, -97, -27, -32, -24, -21, -12, -15, -28, -83, -5, -10, -2, 1, 10, 7, -6, -12, 7, -6, -10, 8, 4, 3};
    }

    static {
        A01();
        A09 = EY.class.getSimpleName();
        A05 = C0512Kc.A0c;
        A06 = C0512Kc.A0g;
        A02 = C0512Kc.A0Z;
        A01 = C0512Kc.A0Y;
        A03 = C0512Kc.A0a;
        A00 = C0512Kc.A0W;
        A04 = C0512Kc.A0b;
        A07 = C0512Kc.A0h;
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A02(C0361Eb c0361Eb, EP ep, int i, String str, long j) {
        if (!A06(c0361Eb)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(A00(156, 14, 27), ep.A00);
            jSONObject.put(A00(91, 13, 38), ep.A01);
            if (j > 0) {
                jSONObject.put(A00(5, 9, 117), K4.A06(System.currentTimeMillis() - j));
            }
            C0514Ke c0514Ke = new C0514Ke(str);
            c0514Ke.A05(jSONObject);
            c0514Ke.A03(1);
            c0361Eb.A06().A5X(A00(14, 5, 7), i, c0514Ke);
        } catch (Throwable th) {
            c0361Eb.A06().A3C(th);
        }
    }

    public static void A03(C0361Eb c0361Eb, ES es, String str, int i, @Nullable String str2, @Nullable Integer num, @Nullable Long l) {
        if (A06(c0361Eb)) {
            A05(c0361Eb, es.A05, es.A06, es.A07, A00(0, 5, 14), str, i, str2, num, l, null);
        }
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A04(C0361Eb c0361Eb, EX ex, boolean z) {
        if (!A06(c0361Eb)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(A00(156, 14, 27), ex.A00);
            jSONObject.put(A00(91, 13, 38), ex.A03);
            jSONObject.put(A00(32, 16, 127), ex.A02);
            jSONObject.put(A00(78, 13, 126), ex.A01);
            if (C0413Gc.A12(c0361Eb)) {
                jSONObject.put(A00(19, 3, 69), ex.A04);
            }
            String message = z ? A00(22, 10, 36) : A00(104, 11, 77);
            int i = z ? A05 : A06;
            C0514Ke c0514Ke = new C0514Ke(message);
            c0514Ke.A05(jSONObject);
            c0514Ke.A03(1);
            InterfaceC0515Kf A062 = c0361Eb.A06();
            String message2 = A00(14, 5, 7);
            A062.A5X(message2, i, c0514Ke);
        } catch (Throwable th) {
            c0361Eb.A06().A3C(th);
        }
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A05(C0361Eb c0361Eb, String str, String str2, String str3, String str4, String str5, int i, @Nullable String str6, @Nullable Integer num, @Nullable Long l, @Nullable Integer num2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(A00(156, 14, 27), str);
            jSONObject.put(A00(91, 13, 38), str2);
            jSONObject.put(A00(32, 16, 127), str4);
            if (str6 != null) {
                jSONObject.put(A00(189, 14, 120), str6);
            }
            if (num != null) {
                jSONObject.put(A00(115, 22, 109), String.valueOf(num));
            }
            if (l != null) {
                jSONObject.put(A00(5, 9, 117), String.valueOf(l));
            }
            if (num2 != null) {
                jSONObject.put(A00(48, 7, 26), String.valueOf(num2));
            }
            jSONObject.put(A00(78, 13, 126), str5);
            if (C0413Gc.A12(c0361Eb)) {
                jSONObject.put(A00(19, 3, 69), str3);
            }
            String A002 = A00(137, 19, 30);
            if (i == A03) {
                A002 = A00(55, 23, 97);
            } else if (i == A01) {
                A002 = A00(170, 19, 98);
            }
            C0514Ke c0514Ke = new C0514Ke(A002);
            c0514Ke.A05(jSONObject);
            c0514Ke.A03(1);
            c0361Eb.A06().A5X(A00(14, 5, 7), i, c0514Ke);
        } catch (Throwable th) {
            c0361Eb.A06().A3C(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x004b, code lost:            return r0;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A06(com.facebook.ads.redexgen.X.C0361Eb r8) {
        /*
            r0 = 0
            r7 = 0
            r0 = 0
            r0 = 1
            r1 = 0
            com.facebook.ads.redexgen.X.Ej r1 = r8.A03()
            boolean r1 = r1.A5A()
            if (r1 == 0) goto L48
            r1 = 2
        L10:
            switch(r1) {
                case 2: goto L23;
                case 3: goto L1d;
                case 4: goto L1a;
                case 5: goto L4b;
                case 6: goto L14;
                case 7: goto L26;
                case 8: goto L3d;
                case 9: goto L40;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            if (r7 <= 0) goto L18
            r1 = 7
            goto L10
        L18:
            r1 = 5
            goto L10
        L1a:
            r0 = 0
            r1 = 5
            goto L10
        L1d:
            if (r7 != 0) goto L21
            r1 = 4
            goto L10
        L21:
            r1 = 6
            goto L10
        L23:
            r7 = 1
            r1 = 3
            goto L10
        L26:
            com.facebook.ads.redexgen.X.Eb r8 = (com.facebook.ads.redexgen.X.C0361Eb) r8
            com.facebook.ads.redexgen.X.GJ r1 = r8.A04()
            double r5 = r1.A00()
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r1 = (double) r7
            double r3 = r3 / r1
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L3b
            r1 = 8
            goto L10
        L3b:
            r1 = 5
            goto L10
        L3d:
            r0 = 0
            r1 = 5
            goto L10
        L40:
            com.facebook.ads.redexgen.X.Eb r8 = (com.facebook.ads.redexgen.X.C0361Eb) r8
            int r7 = com.facebook.ads.redexgen.X.C0414Gd.A06(r8)
            r1 = 3
            goto L10
        L48:
            r1 = 9
            goto L10
        L4b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EY.A06(com.facebook.ads.redexgen.X.Eb):boolean");
    }
}
