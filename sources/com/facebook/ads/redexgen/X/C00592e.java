package com.facebook.ads.redexgen.X;

import java.io.Serializable;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.2e, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C00592e implements Serializable {
    public static byte[] A0B = null;
    public static final EnumC00602f A0C;
    public static final NT A0D;
    public static final long serialVersionUID = -5352540123250859603L;
    public String A00;
    public final int A01;
    public final int A02;
    public final EnumC00602f A03;
    public final NT A04;
    public final String A05;
    public final String A06;
    public final String A07;
    public final String A08;
    public final boolean A09;
    public final boolean A0A;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C00592e.A0B
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
            int r0 = r0 + (-6)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00592e.A03(int, int, int):java.lang.String");
    }

    public static void A06() {
        A0B = new byte[]{-64, -66, -57, -66, -53, -62, -68, -72, -51, -66, -47, -51, 117, 120, 111, 107, 116, 122, 103, 122, 111, 117, 116, -17, -30, -12, -34, -17, -31, -30, -31, -36, -19, -23, -34, -10, -36, -15, -30, -11, -15, -96, -114, -117, -120, -97, -110, -114, -96, -120, -99, -110, -106, -114, -104, -98, -99, -120, -110, -105, -120, -106, -110, -107, -107, -110, -100, -114, -116, -104, -105, -115, -100, -24, -27, -36, -103, -101, -114, -116, -118, -116, -111, -110, -105, -112, -120, -106, -114, -99, -111, -104, -115, -29, -28, -21, -32, -8, -34, -30, -21, -24, -30, -22, -34, -13, -28, -9, -13, -81, -76, -70, -72, -75, -91, -87, -89, -72, -86, -91, -81, -87, -75, -76, -91, -69, -72, -78, 122, -125, 118, 119, -127, 122, 116, 122, -125, 121, 116, 120, 118, -121, 121, -85, -89, -100, -76, -100, -99, -89, -96, -102, -97, -100, -81, -100, -79, -60, -42, -64, -47, -61, -60, -61, Byte.MAX_VALUE, -81, -53, -64, -40, -80, -88, -90, -83, -83, -98, -97, -87, -94, -100, -80, -94, -96, -84, -85, -95, -80, 120, -127, 116, 117, Byte.MAX_VALUE, 120, 114, 124, -127, -121, -123, -126, 114, 118, 116, -123, 119, -72, -44, -55, -31, -120, -69, -36, -41, -38, -51, -120, -33, -47, -44, -44, -120, -55, -35, -36, -41, -43, -55, -36, -47, -53, -55, -44, -44, -31, -120, -41, -40, -51, -42, -120, -47, -42, -120, -61, -37, -51, -53, -37, -59, -37, -121, Byte.MIN_VALUE, -123, 125, 123, -126, -126, 115, 116, 126, 119, 113, -123, 119, 117, -127, Byte.MIN_VALUE, 118, -123};
    }

    static {
        A06();
        A0D = NT.A04;
        A0C = EnumC00602f.A03;
    }

    public C00592e(String str, String str2, int i, String str3, String str4, NT nt, int i2, boolean z, boolean z2, EnumC00602f enumC00602f) {
        this.A07 = str;
        this.A06 = str2;
        this.A01 = i;
        this.A08 = str3;
        this.A05 = str4;
        this.A04 = nt;
        this.A02 = i2;
        this.A0A = z;
        this.A09 = z2;
        this.A03 = enumC00602f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A00(org.json.JSONObject r4) {
        /*
            r3 = 0
            r2 = 169(0xa9, float:2.37E-43)
            r1 = 17
            r0 = 55
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r0 = r4.has(r0)
            if (r0 == 0) goto L3b
            r0 = 2
        L12:
            switch(r0) {
                case 2: goto L16;
                case 3: goto L3d;
                case 4: goto L28;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            r2 = 169(0xa9, float:2.37E-43)
            r1 = 17
            r0 = 55
            java.lang.String r0 = A03(r2, r1, r0)
            int r3 = r4.optInt(r0)
            r0 = 3
            goto L12
        L28:
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            r2 = 248(0xf8, float:3.48E-43)
            r1 = 19
            r0 = 12
            java.lang.String r1 = A03(r2, r1, r0)
            r0 = 0
            int r3 = r4.optInt(r1, r0)
            r0 = 3
            goto L12
        L3b:
            r0 = 4
            goto L12
        L3d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00592e.A00(org.json.JSONObject):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x009b, code lost:            return r4;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C00592e A01(org.json.JSONObject r15) {
        /*
            r0 = 0
            r4 = 0
            r2 = 143(0x8f, float:2.0E-43)
            r1 = 13
            r0 = 53
            java.lang.String r0 = A03(r2, r1, r0)
            org.json.JSONObject r2 = r15.optJSONObject(r0)
            if (r2 != 0) goto L96
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L17;
                case 3: goto L99;
                case 4: goto L1a;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            r4 = 0
            r0 = 3
            goto L13
        L1a:
            org.json.JSONObject r15 = (org.json.JSONObject) r15
            org.json.JSONObject r2 = (org.json.JSONObject) r2
            r3 = 76
            r1 = 17
            r0 = 35
            java.lang.String r1 = A03(r3, r1, r0)
            com.facebook.ads.redexgen.X.2f r0 = com.facebook.ads.redexgen.X.C00592e.A0C
            java.lang.String r0 = r0.name()
            java.lang.String r0 = r2.optString(r1, r0)
            com.facebook.ads.redexgen.X.2f r14 = com.facebook.ads.redexgen.X.EnumC00602f.A00(r0)
            com.facebook.ads.redexgen.X.2e r4 = new com.facebook.ads.redexgen.X.2e
            r3 = 73
            r1 = 3
            r0 = 109(0x6d, float:1.53E-43)
            java.lang.String r0 = A03(r3, r1, r0)
            java.lang.String r5 = r2.optString(r0)
            r3 = 109(0x6d, float:1.53E-43)
            r1 = 19
            r0 = 64
            java.lang.String r0 = A03(r3, r1, r0)
            java.lang.String r6 = r2.optString(r0)
            int r7 = A00(r15)
            java.lang.String r8 = A05(r2)
            java.lang.String r9 = A04(r2)
            com.facebook.ads.redexgen.X.NT r10 = A02(r2)
            r3 = 41
            r1 = 32
            r0 = 35
            java.lang.String r1 = A03(r3, r1, r0)
            r0 = 5000(0x1388, float:7.006E-42)
            int r11 = r2.optInt(r1, r0)
            r3 = 186(0xba, float:2.6E-43)
            r1 = 17
            r0 = 13
            java.lang.String r1 = A03(r3, r1, r0)
            r0 = 1
            boolean r12 = r2.optBoolean(r1, r0)
            r3 = 128(0x80, float:1.8E-43)
            r1 = 15
            r0 = 15
            java.lang.String r0 = A03(r3, r1, r0)
            boolean r13 = r2.optBoolean(r0)
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = 3
            goto L13
        L96:
            r0 = 4
            goto L13
        L99:
            com.facebook.ads.redexgen.X.2e r4 = (com.facebook.ads.redexgen.X.C00592e) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00592e.A01(org.json.JSONObject):com.facebook.ads.redexgen.X.2e");
    }

    public static NT A02(JSONObject jSONObject) {
        return NT.A00(jSONObject.optInt(A03(12, 11, 0), A0D.A03()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A04(org.json.JSONObject r4) {
        /*
            r0 = 0
            r3 = 0
            r2 = 0
            r1 = 12
            r0 = 83
            java.lang.String r0 = A03(r2, r1, r0)
            org.json.JSONObject r4 = r4.optJSONObject(r0)
            if (r4 != 0) goto L3e
            r0 = 2
        L12:
            switch(r0) {
                case 2: goto L16;
                case 3: goto L40;
                case 4: goto L22;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            r2 = 203(0xcb, float:2.84E-43)
            r1 = 45
            r0 = 98
            java.lang.String r3 = A03(r2, r1, r0)
            r0 = 3
            goto L12
        L22:
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            r2 = 93
            r1 = 16
            r0 = 121(0x79, float:1.7E-43)
            java.lang.String r3 = A03(r2, r1, r0)
            r2 = 203(0xcb, float:2.84E-43)
            r1 = 45
            r0 = 98
            java.lang.String r0 = A03(r2, r1, r0)
            java.lang.String r3 = r4.optString(r3, r0)
            r0 = 3
            goto L12
        L3e:
            r0 = 4
            goto L12
        L40:
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = (java.lang.String) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00592e.A04(org.json.JSONObject):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A05(org.json.JSONObject r4) {
        /*
            r0 = 0
            r3 = 0
            r2 = 0
            r1 = 12
            r0 = 83
            java.lang.String r0 = A03(r2, r1, r0)
            org.json.JSONObject r4 = r4.optJSONObject(r0)
            if (r4 != 0) goto L3e
            r0 = 2
        L12:
            switch(r0) {
                case 2: goto L16;
                case 3: goto L40;
                case 4: goto L22;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            r2 = 156(0x9c, float:2.19E-43)
            r1 = 13
            r0 = 89
            java.lang.String r3 = A03(r2, r1, r0)
            r0 = 3
            goto L12
        L22:
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            r2 = 23
            r1 = 18
            r0 = 119(0x77, float:1.67E-43)
            java.lang.String r3 = A03(r2, r1, r0)
            r2 = 156(0x9c, float:2.19E-43)
            r1 = 13
            r0 = 89
            java.lang.String r0 = A03(r2, r1, r0)
            java.lang.String r3 = r4.optString(r3, r0)
            r0 = 3
            goto L12
        L3e:
            r0 = 4
            goto L12
        L40:
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = (java.lang.String) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00592e.A05(org.json.JSONObject):java.lang.String");
    }

    public final int A07() {
        return this.A01;
    }

    public final int A08() {
        return this.A02;
    }

    public final EnumC00602f A09() {
        return this.A03;
    }

    public final NT A0A() {
        return this.A04;
    }

    public final String A0B() {
        return this.A00;
    }

    public final String A0C() {
        return this.A05;
    }

    public final String A0D() {
        return this.A06;
    }

    public final String A0E() {
        return this.A07;
    }

    public final String A0F() {
        return this.A08;
    }

    public final void A0G(String str) {
        this.A00 = str;
    }

    public final boolean A0H() {
        return this.A0A;
    }
}
