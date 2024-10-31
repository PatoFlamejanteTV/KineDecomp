package com.facebook.ads.redexgen.X;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: assets/audience_network.dex */
public class DI implements BI<String> {
    public static byte[] A02;
    public static final String A03;
    public final String A00;
    public final String A01;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.DI.A02
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
            int r0 = r0 + (-41)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.DI.A00(int, int, int):java.lang.String");
    }

    public static void A03() {
        A02 = new byte[]{122, -89, -89, -92, -89, 85, -101, -102, -87, -104, -99, -98, -93, -100, 85, -120, -82, -88, -87, -102, -94, 85, -123, -89, -92, -91, -102, -89, -87, -82, -91, -90, -85, -74, -99, -90, -84, -91, -101};
    }

    static {
        A03();
        A03 = DI.class.getSimpleName();
    }

    public DI(String str) {
        this.A00 = str;
        this.A01 = A01(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0058, code lost:            return r6;     */
    @android.annotation.SuppressLint({"BadMethodUse-android.util.Log.e", "CatchGeneralException"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(java.lang.String r8) {
        /*
            r0 = 0
            r0 = 0
            r7 = 0
            r0 = 0
            r2 = 30
            r1 = 9
            r0 = 46
            java.lang.String r6 = A00(r2, r1, r0)
            r5 = 1
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L20;
                case 6: goto L14;
                case 8: goto L30;
                case 14: goto L54;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            java.lang.reflect.Method r0 = com.facebook.ads.redexgen.X.DJ.A07()     // Catch: java.lang.Exception -> L42
            if (r0 == 0) goto L1d
            r0 = 8
            goto L10
        L1d:
            r0 = 14
            goto L10
        L20:
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch: java.lang.Exception -> L42
            r0 = 0
            r7[r0] = r8     // Catch: java.lang.Exception -> L42
            java.lang.Class r0 = com.facebook.ads.redexgen.X.DJ.A03()     // Catch: java.lang.Exception -> L42
            if (r0 == 0) goto L2d
            r0 = 6
            goto L10
        L2d:
            r0 = 14
            goto L10
        L30:
            java.lang.reflect.Method r1 = com.facebook.ads.redexgen.X.DJ.A07()     // Catch: java.lang.Exception -> L42
            java.lang.Class r0 = com.facebook.ads.redexgen.X.DJ.A03()     // Catch: java.lang.Exception -> L42
            java.lang.Object r0 = r1.invoke(r0, r7)     // Catch: java.lang.Exception -> L42
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L42
            r6 = r0
            r0 = 14
            goto L10
        L42:
            r4 = move-exception
            java.lang.String r3 = com.facebook.ads.redexgen.X.DI.A03
            r2 = 0
            r1 = 30
            r0 = 12
            java.lang.String r0 = A00(r2, r1, r0)
            android.util.Log.e(r3, r0, r4)
            r0 = 14
            goto L10
        L54:
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r6 = (java.lang.String) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.DI.A01(java.lang.String):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.BI
    /* renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final JSONObject A8S(String str, JSONObject jSONObject) throws JSONException {
        jSONObject.put(this.A00, this.A01);
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002e, code lost:            return r2;     */
    @Override // com.facebook.ads.redexgen.X.BI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A5B(java.lang.Object r5) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.DI r5 = (com.facebook.ads.redexgen.X.DI) r5
            java.lang.String r1 = r3.A00
            java.lang.String r0 = r5.A00
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L2c
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L14;
                case 3: goto L26;
                case 4: goto L2e;
                case 5: goto L29;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            com.facebook.ads.redexgen.X.DI r3 = (com.facebook.ads.redexgen.X.DI) r3
            com.facebook.ads.redexgen.X.DI r5 = (com.facebook.ads.redexgen.X.DI) r5
            java.lang.String r1 = r3.A01
            java.lang.String r0 = r5.A01
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L24
            r0 = 3
            goto L10
        L24:
            r0 = 5
            goto L10
        L26:
            r2 = 1
            r0 = 4
            goto L10
        L29:
            r2 = 0
            r0 = 4
            goto L10
        L2c:
            r0 = 5
            goto L10
        L2e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.DI.A5B(java.lang.Object):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.BI
    public final int A8O() {
        return this.A00.getBytes().length + this.A01.getBytes().length;
    }
}
