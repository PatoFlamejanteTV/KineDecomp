package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.view.View;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Gx, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0434Gx {
    public static byte[] A00;
    public static final Map<String, String> A01;
    public static final Map<String, List<String>> A02;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0434Gx.A00
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
            int r0 = r0 + (-19)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0434Gx.A00(int, int, int):java.lang.String");
    }

    public static void A03() {
        A00 = new byte[]{-40, -53, -41, -37, -53, -39, -38, -59, -38, -49, -45, -53, -59, -45, -39, -38, -23, -30, -30, -39, -32, -28, -25, -39, -36, -41, -20, -31, -27, -35, -41, -27, -21, -112, -107, -100, -100, -96, -114, -113, -103, -110, -116, -114, -111, -96, -46, -29, 126, 123, -114, 123, -96, -93, -118, -111, -96, -103, -103, -112, -105, -118, -105, -102, -110, -110, -108, -103, -110};
    }

    static {
        A03();
        A02 = new HashMap();
        A01 = new HashMap();
    }

    @Nullable
    public static String A01(String str) {
        return A01.get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:            return r6;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> A02(com.facebook.ads.redexgen.X.C0362Ec r7, org.json.JSONArray r8) {
        /*
            r0 = 0
            r0 = 0
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r5 = 0
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto L1a;
                case 3: goto Lc;
                case 4: goto Ld;
                case 5: goto Lc;
                case 6: goto Lc;
                case 7: goto Lc;
                case 8: goto L43;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            org.json.JSONArray r8 = (org.json.JSONArray) r8     // Catch: org.json.JSONException -> L27
            java.lang.String r0 = r8.getString(r5)     // Catch: org.json.JSONException -> L27
            r6.add(r0)     // Catch: org.json.JSONException -> L27
            int r5 = r5 + 1
            r0 = 2
            goto L9
        L1a:
            org.json.JSONArray r8 = (org.json.JSONArray) r8     // Catch: org.json.JSONException -> L27
            int r0 = r8.length()     // Catch: org.json.JSONException -> L27
            if (r5 >= r0) goto L24
            r0 = 4
            goto L9
        L24:
            r0 = 8
            goto L9
        L27:
            r4 = move-exception
            com.facebook.ads.redexgen.X.Kf r3 = r7.A06()
            r2 = 52
            r1 = 17
            r0 = 24
            java.lang.String r2 = A00(r2, r1, r0)
            int r1 = com.facebook.ads.redexgen.X.C0512Kc.A0s
            com.facebook.ads.redexgen.X.Ke r0 = new com.facebook.ads.redexgen.X.Ke
            r0.<init>(r4)
            r3.A5W(r2, r1, r0)
            r0 = 8
            goto L9
        L43:
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            java.util.List r6 = (java.util.List) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0434Gx.A02(com.facebook.ads.redexgen.X.Ec, org.json.JSONArray):java.util.List");
    }

    public static void A04(View view, C0432Gv c0432Gv, EnumC0431Gu enumC0431Gu) {
        view.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC0433Gw(c0432Gv, enumC0431Gu));
    }

    public static void A05(C0362Ec c0362Ec, String str, long j) {
        C0432Gv c0432Gv = new C0432Gv(str, c0362Ec.A05());
        HashMap hashMap = new HashMap();
        hashMap.put(A00(0, 15, 83), K4.A06(j));
        hashMap.put(A00(21, 12, 101), K4.A04(j));
        c0432Gv.A02(EnumC0431Gu.A0C, hashMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0083, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A06(com.facebook.ads.redexgen.X.C0362Ec r15, org.json.JSONObject r16, long r17, @android.support.annotation.Nullable java.lang.String r19) {
        /*
            r3 = r16
            r5 = r15
            r10 = r19
            r0 = 0
            r1 = 0
            r4 = 48
            r2 = 4
            r0 = 7
            java.lang.String r0 = A00(r4, r2, r0)
            org.json.JSONObject r6 = r3.optJSONObject(r0)
            if (r6 != 0) goto L81
            r0 = 2
        L16:
            r8 = r17
            switch(r0) {
                case 2: goto L83;
                case 3: goto L30;
                case 4: goto L57;
                case 5: goto L1c;
                case 6: goto L4b;
                case 7: goto L5f;
                case 8: goto L6e;
                default: goto L1b;
            }
        L1b:
            goto L16
        L1c:
            com.facebook.ads.redexgen.X.Ec r5 = (com.facebook.ads.redexgen.X.C0362Ec) r5
            org.json.JSONObject r6 = (org.json.JSONObject) r6
            org.json.JSONArray r1 = (org.json.JSONArray) r1
            java.util.List r13 = A02(r5, r1)
            r16 = 0
            r11 = r5
            r12 = r6
            r14 = r8
            A07(r11, r12, r13, r14, r16)
            r0 = 2
            goto L16
        L30:
            org.json.JSONObject r3 = (org.json.JSONObject) r3
            java.lang.String r10 = (java.lang.String) r10
            r2 = 15
            r1 = 6
            r0 = 97
            java.lang.String r0 = A00(r2, r1, r0)
            org.json.JSONArray r1 = r3.optJSONArray(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 == 0) goto L49
            r0 = 4
            goto L16
        L49:
            r0 = 6
            goto L16
        L4b:
            java.lang.String r10 = (java.lang.String) r10
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != 0) goto L55
            r0 = 7
            goto L16
        L55:
            r0 = 2
            goto L16
        L57:
            org.json.JSONArray r1 = (org.json.JSONArray) r1
            if (r1 == 0) goto L5d
            r0 = 5
            goto L16
        L5d:
            r0 = 6
            goto L16
        L5f:
            java.lang.String r10 = (java.lang.String) r10
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r0 = com.facebook.ads.redexgen.X.C0434Gx.A02
            boolean r0 = r0.containsKey(r10)
            if (r0 == 0) goto L6c
            r0 = 8
            goto L16
        L6c:
            r0 = 2
            goto L16
        L6e:
            com.facebook.ads.redexgen.X.Ec r5 = (com.facebook.ads.redexgen.X.C0362Ec) r5
            java.lang.String r10 = (java.lang.String) r10
            org.json.JSONObject r6 = (org.json.JSONObject) r6
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r0 = com.facebook.ads.redexgen.X.C0434Gx.A02
            java.lang.Object r7 = r0.get(r10)
            java.util.List r7 = (java.util.List) r7
            A07(r5, r6, r7, r8, r10)
            r0 = 2
            goto L16
        L81:
            r0 = 3
            goto L16
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0434Gx.A06(com.facebook.ads.redexgen.X.Ec, org.json.JSONObject, long, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00b0, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A07(com.facebook.ads.redexgen.X.C0362Ec r7, org.json.JSONObject r8, java.util.List<java.lang.String> r9, long r10, @android.support.annotation.Nullable java.lang.String r12) {
        /*
            r4 = 0
            r3 = 0
            r6 = 0
            r5 = 0
            r2 = 46
            r1 = 2
            r0 = 92
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r8.has(r0)
            if (r0 == 0) goto Lad
            r0 = 2
        L14:
            switch(r0) {
                case 2: goto L36;
                case 3: goto Lb0;
                case 4: goto L8a;
                case 5: goto L77;
                case 6: goto L18;
                case 7: goto L28;
                case 8: goto L56;
                case 9: goto La2;
                case 10: goto L24;
                default: goto L17;
            }
        L17:
            goto L14
        L18:
            org.json.JSONArray r5 = (org.json.JSONArray) r5
            int r0 = r5.length()
            if (r6 >= r0) goto L22
            r0 = 7
            goto L14
        L22:
            r0 = 3
            goto L14
        L24:
            int r6 = r6 + 1
            r0 = 6
            goto L14
        L28:
            org.json.JSONArray r5 = (org.json.JSONArray) r5
            org.json.JSONObject r3 = r5.optJSONObject(r6)
            if (r3 == 0) goto L33
            r0 = 8
            goto L14
        L33:
            r0 = 10
            goto L14
        L36:
            com.facebook.ads.redexgen.X.Ec r7 = (com.facebook.ads.redexgen.X.C0362Ec) r7
            org.json.JSONObject r8 = (org.json.JSONObject) r8
            java.util.List r9 = (java.util.List) r9
            java.lang.String r12 = (java.lang.String) r12
            r2 = 46
            r1 = 2
            r0 = 92
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.String r0 = r8.optString(r0)
            A08(r0, r12)
            A09(r0, r9)
            A05(r7, r0, r10)
            r0 = 3
            goto L14
        L56:
            java.util.List r9 = (java.util.List) r9
            java.lang.String r12 = (java.lang.String) r12
            org.json.JSONObject r3 = (org.json.JSONObject) r3
            r2 = 46
            r1 = 2
            r0 = 92
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.String r4 = r3.optString(r0)
            A08(r4, r12)
            A09(r4, r9)
            if (r6 != 0) goto L74
            r0 = 9
            goto L14
        L74:
            r0 = 10
            goto L14
        L77:
            org.json.JSONObject r8 = (org.json.JSONObject) r8
            r2 = 33
            r1 = 13
            r0 = 26
            java.lang.String r0 = A00(r2, r1, r0)
            org.json.JSONArray r5 = r8.optJSONArray(r0)
            r6 = 0
            r0 = 6
            goto L14
        L8a:
            org.json.JSONObject r8 = (org.json.JSONObject) r8
            r2 = 33
            r1 = 13
            r0 = 26
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r8.has(r0)
            if (r0 == 0) goto L9f
            r0 = 5
            goto L14
        L9f:
            r0 = 3
            goto L14
        La2:
            com.facebook.ads.redexgen.X.Ec r7 = (com.facebook.ads.redexgen.X.C0362Ec) r7
            java.lang.String r4 = (java.lang.String) r4
            A05(r7, r4, r10)
            r0 = 10
            goto L14
        Lad:
            r0 = 4
            goto L14
        Lb0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0434Gx.A07(com.facebook.ads.redexgen.X.Ec, org.json.JSONObject, java.util.List, long, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0024, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A08(@android.support.annotation.Nullable java.lang.String r1, @android.support.annotation.Nullable java.lang.String r2) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L22
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L24;
                case 4: goto L17;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            java.lang.String r2 = (java.lang.String) r2
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L15
            r0 = 3
            goto L7
        L15:
            r0 = 4
            goto L7
        L17:
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = (java.lang.String) r2
            java.util.Map<java.lang.String, java.lang.String> r0 = com.facebook.ads.redexgen.X.C0434Gx.A01
            r0.put(r1, r2)
            r0 = 3
            goto L7
        L22:
            r0 = 3
            goto L7
        L24:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0434Gx.A08(java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0024, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A09(java.lang.String r1, java.util.List<java.lang.String> r2) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L22
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L24;
                case 4: goto L17;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            java.util.List r2 = (java.util.List) r2
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L15
            r0 = 3
            goto L7
        L15:
            r0 = 4
            goto L7
        L17:
            java.lang.String r1 = (java.lang.String) r1
            java.util.List r2 = (java.util.List) r2
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r0 = com.facebook.ads.redexgen.X.C0434Gx.A02
            r0.put(r1, r2)
            r0 = 3
            goto L7
        L22:
            r0 = 3
            goto L7
        L24:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0434Gx.A09(java.lang.String, java.util.List):void");
    }

    public static boolean A0A(String str, EnumC0431Gu enumC0431Gu) {
        return A0B(str, enumC0431Gu.A02());
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002c, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0B(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = 0
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r0 = com.facebook.ads.redexgen.X.C0434Gx.A02
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L2a
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L27;
                case 4: goto L2c;
                case 5: goto L24;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = (java.lang.String) r3
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r0 = com.facebook.ads.redexgen.X.C0434Gx.A02
            java.lang.Object r0 = r0.get(r2)
            java.util.List r0 = (java.util.List) r0
            boolean r0 = r0.contains(r3)
            if (r0 == 0) goto L22
            r0 = 3
            goto La
        L22:
            r0 = 5
            goto La
        L24:
            r1 = 0
            r0 = 4
            goto La
        L27:
            r1 = 1
            r0 = 4
            goto La
        L2a:
            r0 = 5
            goto La
        L2c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0434Gx.A0B(java.lang.String, java.lang.String):boolean");
    }
}
