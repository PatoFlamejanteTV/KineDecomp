package com.facebook.ads.redexgen.X;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Ac, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0258Ac {
    public static byte[] A07;
    public final float A00;
    public final float A01;
    public final float A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final float[] A06;

    static {
        A07();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A06(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0258Ac.A07
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
            r0 = r0 ^ 26
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0258Ac.A06(int, int, int):java.lang.String");
    }

    public static void A07() {
        A07 = new byte[]{95, 84, 62, 38, 38, 102, 126, 89, 68, 85, 68, 64, 35, 39, 32, 59, 82, 85};
    }

    public C0258Ac(int i, int i2, int i3, float[] fArr, float f, float f2, float f3) {
        this.A05 = i;
        this.A03 = i2;
        this.A04 = i3;
        this.A06 = fArr;
        this.A02 = f;
        this.A01 = f2;
        this.A00 = f3;
    }

    private final float A00() {
        return this.A00;
    }

    private final float A01() {
        return this.A01;
    }

    private final float A02() {
        return this.A02;
    }

    private final int A03() {
        return this.A03;
    }

    private final int A04() {
        return this.A04;
    }

    private final int A05() {
        return this.A05;
    }

    private final float[] A08() {
        return this.A06;
    }

    public final int A09() {
        return 32;
    }

    public final JSONObject A0A(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(A06(9, 3, 59), this.A05);
        jSONObject2.put(A06(7, 2, 55), this.A03);
        jSONObject2.put(A06(3, 2, 72), this.A04);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(A06(1, 1, 54), EJ.A00(this.A06[0]));
        jSONObject3.put(A06(0, 1, 60), EJ.A00(this.A06[1]));
        jSONObject2.put(A06(5, 2, 8), jSONObject3);
        jSONObject2.put(A06(16, 2, 60), EJ.A00(this.A02));
        jSONObject2.put(A06(12, 2, 77), EJ.A00(this.A01));
        jSONObject2.put(A06(14, 2, 78), EJ.A00(this.A00));
        jSONObject.put(A06(2, 1, 82), jSONObject2);
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x00ea, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0B(com.facebook.ads.redexgen.X.C0258Ac r6) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0258Ac.A0B(com.facebook.ads.redexgen.X.Ac):boolean");
    }
}
