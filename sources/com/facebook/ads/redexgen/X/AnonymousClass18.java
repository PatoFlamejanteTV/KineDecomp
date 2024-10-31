package com.facebook.ads.redexgen.X;

import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.18, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass18 {
    public static byte[] A06;
    public final String A00;
    public final String A01;
    public final String A02;
    public final String A03;
    public final String A04;
    public final List<String> A05;

    static {
        A02();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass18.A06
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
            r0 = r0 ^ 40
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass18.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A06 = new byte[]{64, 81, 81, 82, 72, 85, 68, 126, 84, 83, 77, 74, 70, 85, 76, 66, 83, 120, 82, 85, 78, 10, 27, 27, 24, 2, 31, 14, 90, 93, 80, 80, 94, 93, 95, 87, 99, 73, 78, 80, 26, 11, 9, 1, 11, 13, 15, 78, 64, 92, 122, 77, 68, 86, 77, 64, 86};
    }

    public AnonymousClass18(String str, String str2, String str3, List<String> mKeyHashes, String str4, String str5) {
        this.A04 = str;
        this.A01 = str2;
        this.A00 = str3;
        this.A05 = mKeyHashes;
        this.A03 = str4;
        this.A02 = str5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a6, code lost:            return r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.AnonymousClass18 A00(org.json.JSONObject r12) {
        /*
            r8 = 0
            r7 = 0
            r4 = 0
            r5 = 0
            r9 = 0
            r3 = 0
            r6 = 0
            if (r12 != 0) goto La1
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L61;
                case 3: goto La4;
                case 4: goto L1e;
                case 5: goto L1b;
                case 6: goto Le;
                case 7: goto L64;
                case 8: goto L73;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            org.json.JSONArray r4 = (org.json.JSONArray) r4
            int r0 = r4.length()
            if (r3 >= r0) goto L18
            r0 = 7
            goto La
        L18:
            r0 = 8
            goto La
        L1b:
            r3 = 0
            r0 = 6
            goto La
        L1e:
            org.json.JSONObject r12 = (org.json.JSONObject) r12
            r2 = 40
            r1 = 7
            r0 = 66
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.String r6 = r12.optString(r0)
            r2 = 21
            r1 = 7
            r0 = 67
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.String r7 = r12.optString(r0)
            r2 = 0
            r1 = 11
            r0 = 9
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.String r8 = r12.optString(r0)
            r2 = 47
            r1 = 10
            r0 = 13
            java.lang.String r0 = A01(r2, r1, r0)
            org.json.JSONArray r4 = r12.optJSONArray(r0)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            if (r4 == 0) goto L5e
            r0 = 5
            goto La
        L5e:
            r0 = 8
            goto La
        L61:
            r5 = 0
            r0 = 3
            goto La
        L64:
            org.json.JSONArray r4 = (org.json.JSONArray) r4
            java.util.ArrayList r9 = (java.util.ArrayList) r9
            java.lang.String r0 = r4.optString(r3)
            r9.add(r0)
            int r3 = r3 + 1
            r0 = 6
            goto La
        L73:
            org.json.JSONObject r12 = (org.json.JSONObject) r12
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r8 = (java.lang.String) r8
            java.util.ArrayList r9 = (java.util.ArrayList) r9
            r2 = 11
            r1 = 10
            r0 = 15
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.String r10 = r12.optString(r0)
            r2 = 28
            r1 = 12
            r0 = 20
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.String r11 = r12.optString(r0)
            com.facebook.ads.redexgen.X.18 r5 = new com.facebook.ads.redexgen.X.18
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r0 = 3
            goto La
        La1:
            r0 = 4
            goto La
        La4:
            com.facebook.ads.redexgen.X.18 r5 = (com.facebook.ads.redexgen.X.AnonymousClass18) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass18.A00(org.json.JSONObject):com.facebook.ads.redexgen.X.18");
    }

    public final String A03() {
        return this.A00;
    }

    public final String A04() {
        return this.A01;
    }

    public final String A05() {
        return this.A04;
    }
}
