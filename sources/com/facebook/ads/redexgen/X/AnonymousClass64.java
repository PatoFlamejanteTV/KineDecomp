package com.facebook.ads.redexgen.X;

import org.json.JSONArray;

/* renamed from: com.facebook.ads.redexgen.X.64 */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass64 {
    /* JADX WARN: Code restructure failed: missing block: B:44:0x004e, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A00(org.json.JSONArray r5, org.json.JSONArray r6) {
        /*
            r4 = 0
            r0 = 0
            r3 = 0
            r2 = 0
            int r1 = r5.length()
            int r0 = r6.length()
            if (r1 == r0) goto L4c
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L4e;
                case 3: goto L42;
                case 4: goto L35;
                case 5: goto L23;
                case 6: goto L13;
                case 7: goto L45;
                case 8: goto L49;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            org.json.JSONArray r5 = (org.json.JSONArray) r5
            org.json.JSONArray r6 = (org.json.JSONArray) r6
            com.facebook.ads.redexgen.X.6d r3 = (com.facebook.ads.redexgen.X.EnumC01586d) r3
            boolean r0 = r3.A05(r5, r6, r4)
            if (r0 == 0) goto L21
            r0 = 7
            goto Lf
        L21:
            r0 = 2
            goto Lf
        L23:
            org.json.JSONArray r5 = (org.json.JSONArray) r5
            org.json.JSONArray r6 = (org.json.JSONArray) r6
            com.facebook.ads.redexgen.X.6d r3 = com.facebook.ads.redexgen.X.EnumC01586d.A00(r5, r4)
            com.facebook.ads.redexgen.X.6d r0 = com.facebook.ads.redexgen.X.EnumC01586d.A00(r6, r4)
            if (r3 != r0) goto L33
            r0 = 6
            goto Lf
        L33:
            r0 = 2
            goto Lf
        L35:
            org.json.JSONArray r5 = (org.json.JSONArray) r5
            int r0 = r5.length()
            if (r4 >= r0) goto L3f
            r0 = 5
            goto Lf
        L3f:
            r0 = 8
            goto Lf
        L42:
            r4 = 0
            r0 = 4
            goto Lf
        L45:
            int r4 = r4 + 1
            r0 = 4
            goto Lf
        L49:
            r2 = 1
            r0 = 2
            goto Lf
        L4c:
            r0 = 3
            goto Lf
        L4e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass64.A00(org.json.JSONArray, org.json.JSONArray):boolean");
    }

    public static /* synthetic */ boolean A01(JSONArray jSONArray, JSONArray jSONArray2) {
        return A00(jSONArray, jSONArray2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0068, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A02(org.json.JSONObject r6, org.json.JSONObject r7) {
        /*
            r5 = 0
            r4 = 0
            r3 = 0
            r0 = 0
            r2 = 0
            int r1 = r6.length()
            int r0 = r7.length()
            if (r1 == r0) goto L66
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L68;
                case 3: goto L4c;
                case 4: goto L3f;
                case 5: goto L2b;
                case 6: goto L14;
                case 7: goto L54;
                case 8: goto L28;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            org.json.JSONObject r6 = (org.json.JSONObject) r6
            org.json.JSONObject r7 = (org.json.JSONObject) r7
            java.lang.String r4 = (java.lang.String) r4
            com.facebook.ads.redexgen.X.6d r5 = com.facebook.ads.redexgen.X.EnumC01586d.A01(r6, r4)
            com.facebook.ads.redexgen.X.6d r0 = com.facebook.ads.redexgen.X.EnumC01586d.A01(r7, r4)
            if (r5 != r0) goto L26
            r0 = 7
            goto L10
        L26:
            r0 = 2
            goto L10
        L28:
            r2 = 1
            r0 = 2
            goto L10
        L2b:
            org.json.JSONObject r7 = (org.json.JSONObject) r7
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r0 = r7.has(r4)
            if (r0 == 0) goto L3d
            r0 = 6
            goto L10
        L3d:
            r0 = 2
            goto L10
        L3f:
            java.util.Iterator r3 = (java.util.Iterator) r3
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L49
            r0 = 5
            goto L10
        L49:
            r0 = 8
            goto L10
        L4c:
            org.json.JSONObject r6 = (org.json.JSONObject) r6
            java.util.Iterator r3 = r6.keys()
            r0 = 4
            goto L10
        L54:
            org.json.JSONObject r6 = (org.json.JSONObject) r6
            org.json.JSONObject r7 = (org.json.JSONObject) r7
            java.lang.String r4 = (java.lang.String) r4
            com.facebook.ads.redexgen.X.6d r5 = (com.facebook.ads.redexgen.X.EnumC01586d) r5
            boolean r0 = r5.A07(r6, r7, r4)
            if (r0 != 0) goto L64
            r0 = 2
            goto L10
        L64:
            r0 = 4
            goto L10
        L66:
            r0 = 3
            goto L10
        L68:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass64.A02(org.json.JSONObject, org.json.JSONObject):boolean");
    }
}
