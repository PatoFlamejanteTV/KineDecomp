package com.facebook.ads.redexgen.X;

import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.2d, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C00582d {
    public static byte[] A00;

    static {
        A0B();
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
            byte[] r1 = com.facebook.ads.redexgen.X.C00582d.A00
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
            r0 = r0 ^ 89
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00582d.A02(int, int, int):java.lang.String");
    }

    public static void A0B() {
        A00 = new byte[]{115, 95, 94, 68, 89, 94, 69, 85, 16, 71, 81, 68, 83, 88, 89, 94, 87, 16, 68, 95, 16, 66, 85, 83, 85, 89, 70, 85, 16, 81, 94, 16, 89, 94, 29, 87, 81, 93, 85, 16, 66, 85, 71, 81, 66, 84, 20, 22, 29, 22, 1, 26, 16, 44, 7, 22, 11, 7, 22, 33, 51, 37, 54, 32, 100, 45, 42, 100, 31, 55, 33, 39, 55, 25, 55, 110, 109, 114, 115, 110, 114, 111, 120, 121, 28, 11, 25, 15, 28, 10, 49, 7, 0, 49, 22, 25, 1, 3, 26, 100, 72, 73, 83, 78, 73, 82, 66, 7, 112, 70, 83, 68, 79, 78, 73, 64, 97, 77, 76, 86, 75, 76, 87, 71, 2, 85, 67, 86, 65, 74, 75, 76, 69, 2, 86, 77, 2, 80, 71, 65, 71, 75, 84, 71, 2, 89, 83, 87, 67, 76, 86, 75, 86, 91, 95, 89, 65, 87, 80, 80, 71, 76, 65, 91, 95, 65, 80, 77, 65, 106, 87, 64, 87, 87, 89, 80, 106, 66, 84, 92, 65, 92, 91, 82, 106, 83, 90, 71, 106, 71, 80, 66, 84, 71, 81, 101, 70, 89, 88, 69, 89, 68, 83, 82, 45, 21, 23, 14, 40, 36, 37, 63, 34, 37, 62, 46, 20, 60, 42, 63, 40, 35, 34, 37, 44, Byte.MAX_VALUE, 73, 83, 1, 74, 74, 6, 84, 67, 69, 67, 79, 80, 67, 6, 93, 87, 83, 71, 72, 82, 79, 82, 95, 91, 93, 69, 83, 84, 84, 67, 72, 69, 95, 91, 6, 79, 64, 6, 95, 73, 83, 6, 81, 71, 82, 69, 78, 6, 82, 78, 79, 85, 6, 80, 79, 66, 67, 73, 8, 75, 100, 103, 123, 109, 40, 73, 108, 5, 7, 12, 7, 16, 11, 1, 61, 16, 7, 21, 3, 16, 6, 77, 65, 64, 90, 71, 64, 91, 75, 113, 89, 79, 90, 77, 70, 71, 64, 73, 113, 72, 65, 92, 113, 92, 75, 89, 79, 92, 74, 98, 109, 110, 114, 100, 94, 96, 101};
    }

    public static C2Z A00(JSONObject jSONObject) {
        return new C2Y().A08(A07(jSONObject)).A09(A06(jSONObject)).A07(A08(jSONObject)).A06(A05(jSONObject)).A05(A04(jSONObject)).A0A();
    }

    public static C00652k A01(JSONObject jSONObject) {
        return new C00642j().A02(A09(jSONObject)).A03(A0A(jSONObject)).A04();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(org.json.JSONObject r4) {
        /*
            r0 = 0
            r3 = 0
            r2 = 46
            r1 = 12
            r0 = 42
            java.lang.String r0 = A02(r2, r1, r0)
            org.json.JSONObject r4 = r4.optJSONObject(r0)
            if (r4 != 0) goto L3f
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L17;
                case 3: goto L41;
                case 4: goto L23;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            r2 = 195(0xc3, float:2.73E-43)
            r1 = 9
            r0 = 111(0x6f, float:1.56E-43)
            java.lang.String r3 = A02(r2, r1, r0)
            r0 = 3
            goto L13
        L23:
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            r2 = 75
            r1 = 9
            r0 = 68
            java.lang.String r3 = A02(r2, r1, r0)
            r2 = 195(0xc3, float:2.73E-43)
            r1 = 9
            r0 = 111(0x6f, float:1.56E-43)
            java.lang.String r0 = A02(r2, r1, r0)
            java.lang.String r3 = r4.optString(r3, r0)
            r0 = 3
            goto L13
        L3f:
            r0 = 4
            goto L13
        L41:
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = (java.lang.String) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00582d.A03(org.json.JSONObject):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A04(org.json.JSONObject r4) {
        /*
            r0 = 0
            r3 = 0
            r2 = 46
            r1 = 12
            r0 = 42
            java.lang.String r0 = A02(r2, r1, r0)
            org.json.JSONObject r4 = r4.optJSONObject(r0)
            if (r4 != 0) goto L3f
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L17;
                case 3: goto L41;
                case 4: goto L23;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            r2 = 225(0xe1, float:3.15E-43)
            r1 = 60
            r0 = 127(0x7f, float:1.78E-43)
            java.lang.String r3 = A02(r2, r1, r0)
            r0 = 3
            goto L13
        L23:
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            r2 = 165(0xa5, float:2.31E-43)
            r1 = 30
            r0 = 108(0x6c, float:1.51E-43)
            java.lang.String r3 = A02(r2, r1, r0)
            r2 = 225(0xe1, float:3.15E-43)
            r1 = 60
            r0 = 127(0x7f, float:1.78E-43)
            java.lang.String r0 = A02(r2, r1, r0)
            java.lang.String r3 = r4.optString(r3, r0)
            r0 = 3
            goto L13
        L3f:
            r0 = 4
            goto L13
        L41:
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = (java.lang.String) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00582d.A04(org.json.JSONObject):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A05(org.json.JSONObject r4) {
        /*
            r0 = 0
            r3 = 0
            r2 = 46
            r1 = 12
            r0 = 42
            java.lang.String r0 = A02(r2, r1, r0)
            org.json.JSONObject r4 = r4.optJSONObject(r0)
            if (r4 != 0) goto L3f
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L17;
                case 3: goto L41;
                case 4: goto L23;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            r2 = 285(0x11d, float:4.0E-43)
            r1 = 8
            r0 = 81
            java.lang.String r3 = A02(r2, r1, r0)
            r0 = 3
            goto L13
        L23:
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            r2 = 335(0x14f, float:4.7E-43)
            r1 = 8
            r0 = 88
            java.lang.String r3 = A02(r2, r1, r0)
            r2 = 285(0x11d, float:4.0E-43)
            r1 = 8
            r0 = 81
            java.lang.String r0 = A02(r2, r1, r0)
            java.lang.String r3 = r4.optString(r3, r0)
            r0 = 3
            goto L13
        L3f:
            r0 = 4
            goto L13
        L41:
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = (java.lang.String) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00582d.A05(org.json.JSONObject):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A06(org.json.JSONObject r4) {
        /*
            r0 = 0
            r3 = 0
            r2 = 46
            r1 = 12
            r0 = 42
            java.lang.String r0 = A02(r2, r1, r0)
            org.json.JSONObject r4 = r4.optJSONObject(r0)
            if (r4 != 0) goto L3f
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L17;
                case 3: goto L41;
                case 4: goto L23;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            r2 = 116(0x74, float:1.63E-43)
            r1 = 49
            r0 = 123(0x7b, float:1.72E-43)
            java.lang.String r3 = A02(r2, r1, r0)
            r0 = 3
            goto L13
        L23:
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            r2 = 307(0x133, float:4.3E-43)
            r1 = 28
            r0 = 119(0x77, float:1.67E-43)
            java.lang.String r3 = A02(r2, r1, r0)
            r2 = 116(0x74, float:1.63E-43)
            r1 = 49
            r0 = 123(0x7b, float:1.72E-43)
            java.lang.String r0 = A02(r2, r1, r0)
            java.lang.String r3 = r4.optString(r3, r0)
            r0 = 3
            goto L13
        L3f:
            r0 = 4
            goto L13
        L41:
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = (java.lang.String) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00582d.A06(org.json.JSONObject):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A07(org.json.JSONObject r4) {
        /*
            r0 = 0
            r3 = 0
            r2 = 46
            r1 = 12
            r0 = 42
            java.lang.String r0 = A02(r2, r1, r0)
            org.json.JSONObject r4 = r4.optJSONObject(r0)
            if (r4 != 0) goto L3d
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L17;
                case 3: goto L3f;
                case 4: goto L22;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            r2 = 0
            r1 = 46
            r0 = 105(0x69, float:1.47E-43)
            java.lang.String r3 = A02(r2, r1, r0)
            r0 = 3
            goto L13
        L22:
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            r2 = 293(0x125, float:4.1E-43)
            r1 = 14
            r0 = 59
            java.lang.String r3 = A02(r2, r1, r0)
            r2 = 0
            r1 = 46
            r0 = 105(0x69, float:1.47E-43)
            java.lang.String r0 = A02(r2, r1, r0)
            java.lang.String r3 = r4.optString(r3, r0)
            r0 = 3
            goto L13
        L3d:
            r0 = 4
            goto L13
        L3f:
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = (java.lang.String) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00582d.A07(org.json.JSONObject):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A08(org.json.JSONObject r4) {
        /*
            r0 = 0
            r3 = 0
            r2 = 46
            r1 = 12
            r0 = 42
            java.lang.String r0 = A02(r2, r1, r0)
            org.json.JSONObject r4 = r4.optJSONObject(r0)
            if (r4 != 0) goto L3f
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L17;
                case 3: goto L41;
                case 4: goto L23;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            r2 = 99
            r1 = 17
            r0 = 126(0x7e, float:1.77E-43)
            java.lang.String r3 = A02(r2, r1, r0)
            r0 = 3
            goto L13
        L23:
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            r2 = 208(0xd0, float:2.91E-43)
            r1 = 17
            r0 = 18
            java.lang.String r3 = A02(r2, r1, r0)
            r2 = 99
            r1 = 17
            r0 = 126(0x7e, float:1.77E-43)
            java.lang.String r0 = A02(r2, r1, r0)
            java.lang.String r3 = r4.optString(r3, r0)
            r0 = 3
            goto L13
        L3f:
            r0 = 4
            goto L13
        L41:
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = (java.lang.String) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00582d.A08(org.json.JSONObject):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A09(org.json.JSONObject r4) {
        /*
            r0 = 0
            r3 = 0
            r2 = 46
            r1 = 12
            r0 = 42
            java.lang.String r0 = A02(r2, r1, r0)
            org.json.JSONObject r4 = r4.optJSONObject(r0)
            if (r4 != 0) goto L3f
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L17;
                case 3: goto L41;
                case 4: goto L23;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            r2 = 58
            r1 = 17
            r0 = 29
            java.lang.String r3 = A02(r2, r1, r0)
            r0 = 3
            goto L13
        L23:
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            r2 = 84
            r1 = 11
            r0 = 55
            java.lang.String r3 = A02(r2, r1, r0)
            r2 = 58
            r1 = 17
            r0 = 29
            java.lang.String r0 = A02(r2, r1, r0)
            java.lang.String r3 = r4.optString(r3, r0)
            r0 = 3
            goto L13
        L3f:
            r0 = 4
            goto L13
        L41:
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = (java.lang.String) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00582d.A09(org.json.JSONObject):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0042, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A0A(org.json.JSONObject r4) {
        /*
            r0 = 0
            r3 = 0
            r2 = 46
            r1 = 12
            r0 = 42
            java.lang.String r0 = A02(r2, r1, r0)
            org.json.JSONObject r4 = r4.optJSONObject(r0)
            if (r4 != 0) goto L3c
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L17;
                case 3: goto L3e;
                case 4: goto L22;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            r2 = 204(0xcc, float:2.86E-43)
            r1 = 4
            r0 = 39
            java.lang.String r3 = A02(r2, r1, r0)
            r0 = 3
            goto L13
        L22:
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            r2 = 95
            r1 = 4
            r0 = 51
            java.lang.String r3 = A02(r2, r1, r0)
            r2 = 204(0xcc, float:2.86E-43)
            r1 = 4
            r0 = 39
            java.lang.String r0 = A02(r2, r1, r0)
            java.lang.String r3 = r4.optString(r3, r0)
            r0 = 3
            goto L13
        L3c:
            r0 = 4
            goto L13
        L3e:
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = (java.lang.String) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00582d.A0A(org.json.JSONObject):java.lang.String");
    }
}
