package com.facebook.ads.redexgen.X;

import java.io.Serializable;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.2L, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C2L implements Serializable {
    public static byte[] A0A = null;
    public static final long serialVersionUID = 85021702336014823L;
    public C2N A00;
    public C2O A01;
    public C2S A02;
    public C2U A03;
    public C2V A04;
    public boolean A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;

    static {
        A03();
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
            byte[] r1 = com.facebook.ads.redexgen.X.C2L.A0A
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
            int r0 = r0 + (-13)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2L.A01(int, int, int):java.lang.String");
    }

    public static void A03() {
        A0A = new byte[]{-67, -63, -75, -69, -71, -91, -102, -91, -99, -106, -73, -76, -82, -103, -105, -94, -94, -107, -86, -91, -107, -105, -103, -86, -97, -91, -92, -75, -77, -68, -77, -64, -73, -79, -83, -62, -77, -58, -62, -32, -46, -51, -35, -47, -18, -31, -36, -35, -25, -41, -19, -22, -28, -113, -104, -114, -119, -115, -117, -100, -114, -119, -109, -105, -117, -111, -113, -99, -70, -87, -68, -79, -74, -81, -89, -66, -87, -76, -67, -83, -91, -81, -101, -78, -91, -96, -95, -85, -101, -99, -79, -96, -91, -85, -101, -87, -79, -80, -95, -96, 124, -122, 114, -123, 120, -118, 116, -123, 119, 120, 119, 114, 116, 119, 119, 122, 117, 121, -120, 123, 119, -118, Byte.MAX_VALUE, -116, 123, 117, -118, -113, -122, 123, -103, -114, -107, -99, -123, -113, -108, -102, -104, -107, -123, -102, -104, -121, -108, -103, -113, -102, -113, -107, -108, -73, -60, -71, -50, -19, -32, -37, -36, -26, -42, -37, -20, -23, -40, -21, -32, -26, -27, -42, -22, -36, -38, -74, -78, -90, -84, -92, -81, -94, -90, -78, -79, -73, -88, -69, -73, -32, -35, -31, -33, -32, -20, -92, -109, -90, -101, -96, -103, -111, -107, -95, -89, -96, -90, -120, -119, -105, -104, -115, -110, -123, -104, -115, -109, -110, -125, -104, -115, -104, -112, -119, -98, -97, -90, -101, -77, -103, -99, -90, -93, -99, -91, -103, -82, -97, -78, -82, -9, -7, -26, -8, -19, -8, -16, -23, -53, -67, -69, -57, -58, -68, -53, -73, -66, -57, -54, -73, -54, -67, -49, -71, -54, -68, -81, -92, -85, -77, -101, -95, -76, -91, -80, -101, -80, -82, -99, -86, -81, -91, -80, -91, -85, -86, -69, -80, -73, -65, -89, -83, -74, -84, -89, -85, -87, -70, -84, -61, -65, -66, -63, -68, -64, -52, -54, -54, -66, -53, -63, -5, -18, -23, -22, -12, -28, -26, -6, -7, -12, -11, -15, -26, -2, -28, -22, -13, -26, -25, -15, -22, -23, -119, -76, 96, -73, -87, -84, -84, 96, -95, -75, -76, -81, -83, -95, -76, -87, -93, -95, -84, -84, -71, 96, -81, -80, -91, -82, 96, -87, -82, 96, -101, -77, -91, -93, -77, -99, -77, -122, 126, 124, -125, -125, 116, 117, Byte.MAX_VALUE, 120, 114, -122, 120, 118, -126, -127, 119, -122, -82, -72, -92, -68, -90, -71, -88, -83, -92, -90, -77, -87, -92, -89, -73, -76, -68, -72, -86, -50, -57, -52, -60, -62, -55, -55, -70, -69, -59, -66, -72, -52, -66, -68, -56, -57, -67, -52, -49, -51, -32, -47, -45, -37, -34, -27};
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x01a3, code lost:            r10 = r10;        r4 = r4;        r4.A04(r6);        r4.A0C(r10.optBoolean(A01(130, 21, 25)));        r4.A08(new com.facebook.ads.redexgen.X.C2V(com.facebook.ads.redexgen.X.C0490Jf.A04(r10.optJSONArray(A01(53, 15, 29)))));        r4.A09(r10.optBoolean(A01(385, 19, 56)));     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x01ea, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C2L A00(org.json.JSONObject r10) {
        /*
            Method dump skipped, instructions count: 506
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2L.A00(org.json.JSONObject):com.facebook.ads.redexgen.X.2L");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0073, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(org.json.JSONObject r5) {
        /*
            r4 = 0
            r0 = 0
            r2 = 222(0xde, float:3.11E-43)
            r1 = 16
            r0 = 45
            java.lang.String r3 = A01(r2, r1, r0)
            r2 = 331(0x14b, float:4.64E-43)
            r1 = 37
            r0 = 51
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.String r3 = r5.optString(r3, r0)
            r2 = 331(0x14b, float:4.64E-43)
            r1 = 37
            r0 = 51
            java.lang.String r0 = A01(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L6d
            r0 = 2
        L2b:
            switch(r0) {
                case 2: goto L2f;
                case 3: goto L45;
                case 4: goto L6f;
                case 5: goto L51;
                default: goto L2e;
            }
        L2e:
            goto L2b
        L2f:
            org.json.JSONObject r5 = (org.json.JSONObject) r5
            r2 = 27
            r1 = 12
            r0 = 65
            java.lang.String r0 = A01(r2, r1, r0)
            org.json.JSONObject r4 = r5.optJSONObject(r0)
            if (r4 != 0) goto L43
            r0 = 3
            goto L2b
        L43:
            r0 = 5
            goto L2b
        L45:
            r2 = 331(0x14b, float:4.64E-43)
            r1 = 37
            r0 = 51
            java.lang.String r3 = A01(r2, r1, r0)
            r0 = 4
            goto L2b
        L51:
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            r2 = 222(0xde, float:3.11E-43)
            r1 = 16
            r0 = 45
            java.lang.String r3 = A01(r2, r1, r0)
            r2 = 331(0x14b, float:4.64E-43)
            r1 = 37
            r0 = 51
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.String r3 = r4.optString(r3, r0)
            r0 = 4
            goto L2b
        L6d:
            r0 = 4
            goto L2b
        L6f:
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = (java.lang.String) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2L.A02(org.json.JSONObject):java.lang.String");
    }

    private void A04(C2N c2n) {
        this.A00 = c2n;
    }

    private final void A05(C2O c2o) {
        this.A01 = c2o;
    }

    private final void A06(C2S c2s) {
        this.A02 = c2s;
    }

    private final void A07(C2U c2u) {
        this.A03 = c2u;
    }

    private final void A08(C2V c2v) {
        this.A04 = c2v;
    }

    private final void A09(boolean z) {
        this.A06 = z;
    }

    private final void A0A(boolean z) {
        this.A07 = z;
    }

    private final void A0B(boolean z) {
        this.A08 = z;
    }

    private final void A0C(boolean z) {
        this.A09 = z;
    }

    public final C2O A0D() {
        return this.A01;
    }

    public final C2S A0E() {
        return this.A02;
    }

    public final C2U A0F() {
        return this.A03;
    }

    public final C2V A0G() {
        return this.A04;
    }

    public final void A0H(JSONObject jSONObject) {
        this.A00.A0J(jSONObject.optBoolean(A01(309, 22, 120)));
        this.A00.A0I(jSONObject.optBoolean(A01(80, 20, 47), true));
        A05(this.A00.A0K());
        A0J(jSONObject.optBoolean(A01(100, 14, 6)));
        A0A(jSONObject.optBoolean(A01(284, 13, 59)));
        A0B(jSONObject.optBoolean(A01(264, 20, 47)));
    }

    public final void A0I(JSONObject jSONObject) {
        this.A00.A0E(jSONObject.optInt(A01(155, 18, 106)));
        this.A00.A0I(jSONObject.optBoolean(A01(80, 20, 47), true));
        A05(this.A00.A0K());
    }

    public final void A0J(boolean z) {
        this.A05 = z;
    }

    public final boolean A0K() {
        return this.A05;
    }

    public final boolean A0L() {
        return this.A06;
    }

    public final boolean A0M() {
        return this.A07;
    }

    public final boolean A0N() {
        return this.A08;
    }

    public final boolean A0O() {
        return this.A09;
    }
}
