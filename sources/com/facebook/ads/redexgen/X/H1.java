package com.facebook.ads.redexgen.X;

import android.content.SharedPreferences;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: assets/audience_network.dex */
public final class H1 {
    public static byte[] A00;
    public static final String A01;
    public static final AtomicBoolean A02;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.H1.A00
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
            int r0 = r0 + (-11)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.H1.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A00 = new byte[]{100, 120, 118, -118, 124, 125, -119, 116, 122, -115, 120, 122, -123, -119, 126, -124, -125, 123, -116, 123, -124, -118, -119, -98, -86, -88, 105, -95, -100, -98, -96, -99, -86, -86, -90, 105, -100, -97, -82, 105, -121, -118, 126, 124, -121, -102, 126, -118, -112, -119, -113, Byte.MIN_VALUE, -115, -114, -70, -67, -67, -62, -51, -62, -56, -57, -70, -59, -72, -62, -57, -65, -56, -118, -115, -127, Byte.MAX_VALUE, -118, 125, -127, -115, -109, -116, -110, -125, -112, -111, -92, 95, Byte.MIN_VALUE, -123, 49, 122, Byte.MAX_VALUE, 122, -123, 122, 114, 125, 122, -117, 118, 117, 50, 110, -109, -120, -105, -118, -110, -118, -109, -103, -114, -109, -116, 69, -120, -108, -102, -109, -103, -118, -105, 95, 69, -88, -86, -105, -87, -82, -91, -102, -62, -43, -43, -58, -50, -47, -43, -16, -14, -33, -15, -10, -19, -30, -36, -32, -20, -31, -30, -87, -102, -78, -91, -88, -102, -99, -33, -32, -51, -49, -41, -32, -34, -51, -49, -47, 125, 122, -115, 122, -126, -91, -103, -105, -94, 121, -91, -85, -92, -86, -101, -88, -87, 67, 53, 99, 122, -116, 53, -117, 118, -127, -118, 122, 79, 53};
    }

    static {
        A02();
        A01 = H1.class.getSimpleName();
        A02 = new AtomicBoolean();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0028, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A03(com.facebook.ads.redexgen.X.C0361Eb r2) {
        /*
            boolean r0 = A09(r2)
            if (r0 == 0) goto L26
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L28;
                case 3: goto Lb;
                case 4: goto L18;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            java.util.concurrent.atomic.AtomicBoolean r1 = com.facebook.ads.redexgen.X.H1.A02
            r0 = 1
            boolean r0 = r1.getAndSet(r0)
            if (r0 != 0) goto L16
            r0 = 4
            goto L7
        L16:
            r0 = 2
            goto L7
        L18:
            com.facebook.ads.redexgen.X.Eb r2 = (com.facebook.ads.redexgen.X.C0361Eb) r2
            java.util.concurrent.Executor r1 = com.facebook.ads.redexgen.X.KJ.A05
            com.facebook.ads.redexgen.X.Gy r0 = new com.facebook.ads.redexgen.X.Gy
            r0.<init>(r2)
            r1.execute(r0)
            r0 = 2
            goto L7
        L26:
            r0 = 3
            goto L7
        L28:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.H1.A03(com.facebook.ads.redexgen.X.Eb):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00b5, code lost:            r6 = r6;        r4 = r4;        r4.put(A01(54, 15, 78), r3.toString());        A07(r6, r4);        r0 = r6.A04();        r0 = com.facebook.ads.redexgen.X.FE.A05(new com.facebook.ads.redexgen.X.FD(r0.A01(), r0.A02(), r4));        r3 = new org.json.JSONArray();        r3.put(r0);        r4 = new org.json.JSONObject();        r1 = A01(165, 4, 14);        r0 = new org.json.JSONObject(r5);        r4.put(r1, r0);        r4.put(A01(17, 6, 11), r3);        r3 = new com.facebook.ads.redexgen.X.JC();        r3.put(A01(148, 7, 46), r4.toString());        r7.A7n(r6.A03().A4f(), r3.A08(), new com.facebook.ads.redexgen.X.H0());     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x013b, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A04(com.facebook.ads.redexgen.X.C0361Eb r6, com.facebook.ads.redexgen.X.FM r7, java.util.Map<java.lang.String, ?> r8) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.H1.A04(com.facebook.ads.redexgen.X.Eb, com.facebook.ads.redexgen.X.FM, java.util.Map):void");
    }

    public static void A06(C0361Eb c0361Eb, String str) {
        if (A09(c0361Eb)) {
            return;
        }
        if (!A02.get()) {
            c0361Eb.A06().A5l(A01(69, 14, 19), 3502, new C0514Ke(A01(84, 16, 6)));
            return;
        }
        synchronized (H1.class) {
            SharedPreferences sharedPreferences = c0361Eb.getApplicationContext().getSharedPreferences(ProcessUtils.getProcessSpecificName(A01(23, 31, 48), c0361Eb), 0);
            int i = sharedPreferences.getInt(str, 0) + 1;
            sharedPreferences.edit().putInt(str, i).apply();
            if (BuildConfigApi.isDebug()) {
                String str2 = A01(100, 22, 26) + str + A01(182, 13, 10) + i;
            }
        }
    }

    public static void A07(C0361Eb c0361Eb, Map<String, String> map) {
        Map<String, String> dataMap = c0361Eb.A02().A3p();
        map.putAll(dataMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x001a, code lost:            return r4;     */
    @android.support.annotation.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A08(double r5, int r7) {
        /*
            r0 = 0
            r4 = 1
            if (r7 <= 0) goto L18
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L9;
                case 3: goto L1a;
                case 4: goto L15;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            r2 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r0 = (double) r7
            double r2 = r2 / r0
            int r0 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r0 < 0) goto L13
            r0 = 3
            goto L5
        L13:
            r0 = 4
            goto L5
        L15:
            r4 = 0
            r0 = 3
            goto L5
        L18:
            r0 = 3
            goto L5
        L1a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.H1.A08(double, int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0034, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A09(com.facebook.ads.redexgen.X.C0361Eb r3) {
        /*
            r1 = 0
            boolean r0 = com.facebook.ads.internal.api.BuildConfigApi.isDebug()
            if (r0 == 0) goto L32
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L34;
                case 4: goto L12;
                case 5: goto Lf;
                case 6: goto L1e;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r1 = 0
            r0 = 3
            goto L8
        Lf:
            r1 = 1
            r0 = 3
            goto L8
        L12:
            com.facebook.ads.redexgen.X.Eb r3 = (com.facebook.ads.redexgen.X.C0361Eb) r3
            boolean r0 = com.facebook.ads.redexgen.X.C0414Gd.A0R(r3)
            if (r0 != 0) goto L1c
            r0 = 5
            goto L8
        L1c:
            r0 = 6
            goto L8
        L1e:
            com.facebook.ads.redexgen.X.Eb r3 = (com.facebook.ads.redexgen.X.C0361Eb) r3
            com.facebook.ads.redexgen.X.GJ r0 = r3.A04()
            double r1 = r0.A00()
            int r0 = com.facebook.ads.redexgen.X.C0414Gd.A0B(r3)
            boolean r1 = A08(r1, r0)
            r0 = 3
            goto L8
        L32:
            r0 = 4
            goto L8
        L34:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.H1.A09(com.facebook.ads.redexgen.X.Eb):boolean");
    }
}
