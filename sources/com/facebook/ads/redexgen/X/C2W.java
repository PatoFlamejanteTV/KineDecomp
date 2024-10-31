package com.facebook.ads.redexgen.X;

import java.io.Serializable;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.2W, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C2W extends C2I implements Serializable {
    public static byte[] A00 = null;
    public static final long serialVersionUID = 5751287062553772011L;

    static {
        A03();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C2W.A00
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
            int r0 = r0 + (-47)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2W.A02(int, int, int):java.lang.String");
    }

    public static void A03() {
        A00 = new byte[]{-90, -85, -79, -94, -81, -80, -79, -90, -79, -90, -98, -87, -87, -102, -85, -84, -94, -89, -96, 14, 12, 29, 26, 32, 30, 16, 23};
    }

    public C2W(List<C2L> list) {
        super(list);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x007c, code lost:            r3 = new com.facebook.ads.redexgen.X.C2W(r4);        r3.A0d(r7);        r3.A0b(A02(0, 12, 14));     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0096, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C2W A01(org.json.JSONObject r7, com.facebook.ads.redexgen.X.C0362Ec r8) {
        /*
            r6 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r2 = 19
            r1 = 8
            r0 = 124(0x7c, float:1.74E-43)
            java.lang.String r0 = A02(r2, r1, r0)
            org.json.JSONArray r5 = r7.optJSONArray(r0)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            if (r5 == 0) goto L79
            r0 = 2
        L1b:
            switch(r0) {
                case 2: goto L5b;
                case 3: goto L58;
                case 4: goto L4b;
                case 5: goto L1f;
                case 6: goto L1e;
                case 7: goto L1e;
                case 8: goto L1e;
                case 9: goto L1e;
                case 10: goto L1e;
                case 11: goto L68;
                case 12: goto L7c;
                default: goto L1e;
            }
        L1e:
            goto L1b
        L1f:
            org.json.JSONArray r5 = (org.json.JSONArray) r5     // Catch: org.json.JSONException -> L30
            org.json.JSONObject r1 = r5.getJSONObject(r6)     // Catch: org.json.JSONException -> L30
            com.facebook.ads.redexgen.X.2L r0 = com.facebook.ads.redexgen.X.C2L.A00(r1)     // Catch: org.json.JSONException -> L30
            r0.A0H(r1)     // Catch: org.json.JSONException -> L30
            r4.add(r0)     // Catch: org.json.JSONException -> L30
            goto L47
        L30:
            r3 = move-exception
            r2 = 12
            r1 = 7
            r0 = 10
            java.lang.String r2 = A02(r2, r1, r0)
            int r1 = com.facebook.ads.redexgen.X.C0512Kc.A1Z
            com.facebook.ads.redexgen.X.Ke r0 = new com.facebook.ads.redexgen.X.Ke
            r0.<init>(r3)
            com.facebook.ads.redexgen.X.C0511Kb.A06(r8, r2, r1, r0)
            r3.printStackTrace()
        L47:
            int r6 = r6 + 1
            r0 = 4
            goto L1b
        L4b:
            org.json.JSONArray r5 = (org.json.JSONArray) r5
            int r0 = r5.length()
            if (r6 >= r0) goto L55
            r0 = 5
            goto L1b
        L55:
            r0 = 12
            goto L1b
        L58:
            r6 = 0
            r0 = 4
            goto L1b
        L5b:
            org.json.JSONArray r5 = (org.json.JSONArray) r5
            int r0 = r5.length()
            if (r0 <= 0) goto L65
            r0 = 3
            goto L1b
        L65:
            r0 = 11
            goto L1b
        L68:
            org.json.JSONObject r7 = (org.json.JSONObject) r7
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            com.facebook.ads.redexgen.X.2L r0 = com.facebook.ads.redexgen.X.C2L.A00(r7)
            r0.A0H(r7)
            r4.add(r0)
            r0 = 12
            goto L1b
        L79:
            r0 = 11
            goto L1b
        L7c:
            org.json.JSONObject r7 = (org.json.JSONObject) r7
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            com.facebook.ads.redexgen.X.2W r3 = new com.facebook.ads.redexgen.X.2W
            r3.<init>(r4)
            r3.A0d(r7)
            r2 = 0
            r1 = 12
            r0 = 14
            java.lang.String r0 = A02(r2, r1, r0)
            r3.A0b(r0)
            com.facebook.ads.redexgen.X.2W r3 = (com.facebook.ads.redexgen.X.C2W) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2W.A01(org.json.JSONObject, com.facebook.ads.redexgen.X.Ec):com.facebook.ads.redexgen.X.2W");
    }

    @Override // com.facebook.ads.redexgen.X.C2I
    public final int A0H() {
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.C2I
    public final int A0I() {
        return 0;
    }
}
