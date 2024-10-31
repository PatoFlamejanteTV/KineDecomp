package com.facebook.ads.redexgen.X;

import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Jf, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0490Jf {
    public static byte[] A00;

    static {
        A05();
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
            byte[] r1 = com.facebook.ads.redexgen.X.C0490Jf.A00
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
            r0 = r0 ^ r4
            r0 = r0 ^ 5
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0490Jf.A00(int, int, int):java.lang.String");
    }

    public static void A05() {
        A00 = new byte[]{48, 43, 50, 50};
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x004f, code lost:            return r2.toString();     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(java.util.Map<java.lang.String, java.lang.String> r5) {
        /*
            r0 = 0
            r0 = 0
            r4 = 0
            r3 = 0
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            if (r5 == 0) goto L44
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L2f;
                case 3: goto Lf;
                case 4: goto L25;
                case 5: goto L10;
                case 6: goto Lf;
                case 7: goto Lf;
                case 8: goto Lf;
                case 9: goto Lf;
                case 10: goto L47;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch: org.json.JSONException -> L20
            java.lang.Object r1 = r4.getKey()     // Catch: org.json.JSONException -> L20
            java.lang.String r1 = (java.lang.String) r1     // Catch: org.json.JSONException -> L20
            java.lang.Object r0 = r4.getValue()     // Catch: org.json.JSONException -> L20
            r2.put(r1, r0)     // Catch: org.json.JSONException -> L20
            goto L39
        L20:
            r0 = move-exception
            r0.printStackTrace()
            goto L39
        L25:
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r0 = 5
            goto Lc
        L2f:
            java.util.Map r5 = (java.util.Map) r5
            java.util.Set r0 = r5.entrySet()
            java.util.Iterator r3 = r0.iterator()
        L39:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L41
            r0 = 4
            goto Lc
        L41:
            r0 = 10
            goto Lc
        L44:
            r0 = 10
            goto Lc
        L47:
            org.json.JSONObject r2 = (org.json.JSONObject) r2
            java.lang.String r0 = r2.toString()
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0490Jf.A01(java.util.Map):java.lang.String");
    }

    public static String A02(JSONObject jSONObject, String str) {
        return A03(jSONObject, str, null);
    }

    public static String A03(JSONObject jSONObject, String str, String str2) {
        String optString = jSONObject.optString(str, str2);
        if (A00(0, 4, 91).equals(optString)) {
            return null;
        }
        return optString;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x004a, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> A04(org.json.JSONArray r4) {
        /*
            r3 = 0
            r2 = 0
            r1 = 0
            if (r4 != 0) goto L44
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L2f;
                case 3: goto L46;
                case 4: goto L27;
                case 5: goto L1b;
                case 6: goto La;
                case 7: goto L36;
                case 8: goto L40;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            org.json.JSONArray r4 = (org.json.JSONArray) r4
            java.lang.String r3 = r4.optString(r2)
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L18
            r0 = 7
            goto L6
        L18:
            r0 = 8
            goto L6
        L1b:
            org.json.JSONArray r4 = (org.json.JSONArray) r4
            int r0 = r4.length()
            if (r2 >= r0) goto L25
            r0 = 6
            goto L6
        L25:
            r0 = 3
            goto L6
        L27:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            r0 = 5
            goto L6
        L2f:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r0 = 3
            goto L6
        L36:
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            java.lang.String r3 = (java.lang.String) r3
            r1.add(r3)
            r0 = 8
            goto L6
        L40:
            int r2 = r2 + 1
            r0 = 5
            goto L6
        L44:
            r0 = 4
            goto L6
        L46:
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            java.util.List r1 = (java.util.List) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0490Jf.A04(org.json.JSONArray):java.util.List");
    }
}
