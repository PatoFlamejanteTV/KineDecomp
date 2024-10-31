package com.facebook.ads.redexgen.X;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Oi, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0620Oi {
    public static byte[] A00;

    static {
        A02();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0620Oi.A00
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
            int r0 = r0 + (-78)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0620Oi.A00(int, int, int):java.lang.String");
    }

    public static void A02() {
        A00 = new byte[]{31, 35, 23, 29, 27, -17, -20, -26, -1, -14, -19, -18, -8, -24, -2, -5, -11, 3, 48, 48, 45, 48, -34, 50, 48, 31, 44, 49, 36, 45, 48, 43, 39, 44, 37, -34, 8, 17, 13, 12, -34, 39, 44, -34, 51, 46, 34, 31, 50, 35, 1, 31, 33, 38, 35, 34, 19, 48, 42, 49, 47, 56, 46, 41, 45, 43, 60, 46, 41, 51, 55, 43, 49, 47, 61, 1, 22, 11, -2, 10, 6, 0, -4, 16, 1, 8, -4, 9, -2, 22, 2, 15, -4, 5, 17, 10, 9, -4, 18, 15, 9, 38, 36, 53, 50, 56, 54, 40, 47, -23, -29, -17, -18};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0024. Please report as an issue. */
    public static JSONObject A01(C0362Ec c0362Ec, JSONObject jSONObject, EV ev, C0432Gv c0432Gv, OV ov) {
        int i = 0;
        JSONArray jSONArray = null;
        int i2 = 0;
        JSONArray jSONArray2 = null;
        if (ev.A0X(jSONObject.optString(A00(75, 26, 79)))) {
            c0432Gv.A02(EnumC0431Gu.A0O, null);
            char c = 4;
            while (true) {
                switch (c) {
                    case 4:
                        JSONObject optJSONObject = jSONObject.optJSONObject(A00(109, 4, 50));
                        if (optJSONObject != null && optJSONObject.optString(A00(5, 3, 44)) != null) {
                            optJSONObject.put(A00(5, 3, 44), ev.A0J(optJSONObject.optString(A00(5, 3, 44))));
                        }
                        jSONArray2 = jSONObject.optJSONArray(A00(60, 15, 124));
                        c = jSONArray2 != null ? (char) 18 : (char) 25;
                        break;
                    case 18:
                        i2 = 0;
                        c = 19;
                    case 19:
                        jSONArray2 = jSONArray2;
                        c = i2 < jSONArray2.length() ? (char) 21 : (char) 25;
                    case 21:
                        jSONArray2 = jSONArray2;
                        jSONArray2.put(i2, ev.A0J(jSONArray2.optString(i2)));
                        i2++;
                        c = 19;
                    case 25:
                        jSONArray = jSONObject.optJSONArray(A00(101, 8, 117));
                        c = jSONArray != null ? (char) 28 : '\"';
                    case 28:
                        i = 0;
                        c = 29;
                    case 29:
                        try {
                            jSONArray = jSONArray;
                            if (i >= jSONArray.length()) {
                                break;
                            } else {
                                A03(jSONArray.optJSONObject(i), ev);
                                i++;
                                c = 29;
                            }
                        } catch (JSONException unused) {
                            ov.A04(C0512Kc.A0q, A00(17, 43, 112));
                            break;
                        }
                    case '\"':
                        jSONObject = jSONObject;
                        A03(jSONObject, ev);
                        break;
                }
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x008a, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A03(org.json.JSONObject r5, com.facebook.ads.redexgen.X.EV r6) throws org.json.JSONException {
        /*
            r0 = 0
            r2 = 0
            r1 = 5
            r0 = 104(0x68, float:1.46E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            org.json.JSONObject r4 = r5.optJSONObject(r0)
            if (r4 == 0) goto L88
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L14;
                case 3: goto L28;
                case 4: goto L49;
                case 5: goto L63;
                case 6: goto L8a;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            r2 = 5
            r1 = 3
            r0 = 44
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.String r0 = r4.optString(r0)
            if (r0 == 0) goto L26
            r0 = 3
            goto L10
        L26:
            r0 = 4
            goto L10
        L28:
            com.facebook.ads.redexgen.X.EV r6 = (com.facebook.ads.redexgen.X.EV) r6
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            r2 = 5
            r1 = 3
            r0 = 44
            java.lang.String r3 = A00(r2, r1, r0)
            r2 = 5
            r1 = 3
            r0 = 44
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.String r0 = r4.optString(r0)
            java.lang.String r0 = r6.A0J(r0)
            r4.put(r3, r0)
            r0 = 4
            goto L10
        L49:
            org.json.JSONObject r5 = (org.json.JSONObject) r5
            r2 = 8
            r1 = 9
            r0 = 59
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.String r0 = r5.optString(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L61
            r0 = 5
            goto L10
        L61:
            r0 = 6
            goto L10
        L63:
            org.json.JSONObject r5 = (org.json.JSONObject) r5
            com.facebook.ads.redexgen.X.EV r6 = (com.facebook.ads.redexgen.X.EV) r6
            r2 = 8
            r1 = 9
            r0 = 59
            java.lang.String r3 = A00(r2, r1, r0)
            r2 = 8
            r1 = 9
            r0 = 59
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.String r0 = r5.optString(r0)
            java.lang.String r0 = r6.A0L(r0)
            r5.put(r3, r0)
            r0 = 6
            goto L10
        L88:
            r0 = 4
            goto L10
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0620Oi.A03(org.json.JSONObject, com.facebook.ads.redexgen.X.EV):void");
    }
}
