package com.facebook.ads.redexgen.X;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: assets/audience_network.dex */
public final class IR {
    public static IR A00;
    public static byte[] A01;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A04(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.IR.A01
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
            int r0 = r0 + (-20)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IR.A04(int, int, int):java.lang.String");
    }

    public static void A05() {
        A01 = new byte[]{-93, -80, -80, -83, -80, -70, -67, -72, -53, -66, -55, -56, -53, -51, -62, -57, -64, -72, -68, -56, -57, -65, -62, -64, -81, -83, -100, -98, -90, -96, -83, -82, -102, -101, -100, -97, -92, -97, -86, -97, -91, -92, -30, -33, -14, -33, -35, -21, -19, -30, -29, -22, -35, -14, -9, -18, -29, -65, -60, -69, -80, -89, -86, -89, -74, -70, -85, -72, -87, -75, -86, -85, -76, -73, -58, -68, -76, -62, -62, -80, -74, -76, -68, -72, -83, -81, -79, -71, -79, -70, -64, -65, -73, -76, -57, -76, -119, -106, -121, -98, -119, -108, -111, -116, -119, -100, -111, -105, -106, -121, -99, -99, -111, -116, -22, -23, -27, -8, -7, -10, -23, -29, -25, -13, -14, -22, -19, -21};
    }

    static {
        A05();
        A00 = new IR();
    }

    public static synchronized IR A00() {
        IR ir;
        synchronized (IR.class) {
            ir = A00;
        }
        return ir;
    }

    /* JADX WARN: Incorrect condition in loop: B:5:0x0066 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.facebook.ads.redexgen.X.IU A01(com.facebook.ads.redexgen.X.C0362Ec r11, org.json.JSONObject r12, long r13, @android.support.annotation.Nullable java.lang.String r15) throws org.json.JSONException {
        /*
            r10 = this;
            r2 = 82
            r1 = 10
            r0 = 56
            java.lang.String r0 = A04(r2, r1, r0)
            org.json.JSONArray r1 = r12.getJSONArray(r0)
            r0 = 0
            org.json.JSONObject r3 = r1.getJSONObject(r0)
            r2 = 32
            r1 = 10
            r0 = 34
            java.lang.String r0 = A04(r2, r1, r0)
            org.json.JSONObject r0 = r3.getJSONObject(r0)
            com.facebook.ads.redexgen.X.Fr r6 = com.facebook.ads.redexgen.X.C0403Fr.A00(r0)
            r2 = 114(0x72, float:1.6E-43)
            r1 = 14
            r0 = 112(0x70, float:1.57E-43)
            java.lang.String r0 = A04(r2, r1, r0)
            java.lang.String r5 = r3.optString(r0)
            r2 = 5
            r1 = 19
            r0 = 69
            java.lang.String r0 = A04(r2, r1, r0)
            java.lang.String r0 = r3.optString(r0)
            com.facebook.ads.redexgen.X.Fq r4 = new com.facebook.ads.redexgen.X.Fq
            r4.<init>(r6, r5, r0)
            r2 = 72
            r1 = 3
            r0 = 63
            java.lang.String r0 = A04(r2, r1, r0)
            boolean r0 = r3.has(r0)
            if (r0 == 0) goto Lb0
            r2 = 72
            r1 = 3
            r0 = 63
            java.lang.String r0 = A04(r2, r1, r0)
            org.json.JSONArray r8 = r3.getJSONArray(r0)
            r7 = 0
        L62:
            int r0 = r8.length()
            if (r7 >= r0) goto Lb0
            org.json.JSONObject r9 = r8.getJSONObject(r7)
            com.facebook.ads.redexgen.X.C0434Gx.A06(r11, r9, r13, r15)
            r2 = 61
            r1 = 7
            r0 = 50
            java.lang.String r0 = A04(r2, r1, r0)
            java.lang.String r6 = r9.optString(r0)
            r2 = 42
            r1 = 15
            r0 = 106(0x6a, float:1.49E-43)
            java.lang.String r0 = A04(r2, r1, r0)
            java.lang.String r5 = r9.optString(r0)
            r2 = 92
            r1 = 4
            r0 = 63
            java.lang.String r0 = A04(r2, r1, r0)
            org.json.JSONObject r3 = r9.optJSONObject(r0)
            r2 = 24
            r1 = 8
            r0 = 39
            java.lang.String r0 = A04(r2, r1, r0)
            org.json.JSONArray r1 = r9.optJSONArray(r0)
            com.facebook.ads.redexgen.X.Fo r0 = new com.facebook.ads.redexgen.X.Fo
            r0.<init>(r6, r5, r3, r1)
            r4.A09(r0)
            int r7 = r7 + 1
            goto L62
        Lb0:
            r2 = 96
            r1 = 18
            r0 = 20
            java.lang.String r0 = A04(r2, r1, r0)
            java.lang.String r1 = r12.optString(r0)
            com.facebook.ads.redexgen.X.IU r0 = new com.facebook.ads.redexgen.X.IU
            r0.<init>(r4, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IR.A01(com.facebook.ads.redexgen.X.Ec, org.json.JSONObject, long, java.lang.String):com.facebook.ads.redexgen.X.IU");
    }

    private IV A02(JSONObject jSONObject) {
        return new IV(jSONObject.optString(A04(75, 7, 59), A04(57, 0, 118)), jSONObject.optInt(A04(68, 4, 50), 0), null);
    }

    private IV A03(JSONObject definition) {
        try {
            JSONArray placements = definition.getJSONArray(A04(82, 10, 56));
            JSONObject jSONObject = placements.getJSONObject(0);
            JSONObject placement = jSONObject.getJSONObject(A04(32, 10, 34));
            C0403Fr A002 = C0403Fr.A00(placement);
            String optString = jSONObject.optString(A04(114, 14, 112));
            String optString2 = jSONObject.optString(A04(5, 19, 69));
            String optString3 = definition.optString(A04(75, 7, 59), A04(57, 0, 118));
            String featureConfig = A04(68, 4, 50);
            return new IV(optString3, definition.optInt(featureConfig, 0), new C0402Fq(A002, optString, optString2));
        } catch (JSONException unused) {
            return A02(definition);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x00c2, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.IT A06(com.facebook.ads.redexgen.X.C0362Ec r14, java.lang.String r15, long r16, @android.support.annotation.Nullable java.lang.String r18) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IR.A06(com.facebook.ads.redexgen.X.Ec, java.lang.String, long, java.lang.String):com.facebook.ads.redexgen.X.IT");
    }
}
