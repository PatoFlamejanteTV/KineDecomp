package com.facebook.ads.redexgen.X;

import android.graphics.Color;
import android.support.annotation.Nullable;
import java.io.Serializable;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.2T, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C2T implements Serializable {
    public static byte[] A09 = null;
    public static final int A0A;
    public static final int A0B;
    public static final int A0C;
    public static final int A0D;
    public static final int A0E;
    public static final int A0F;
    public static final long serialVersionUID = 8946536326456653736L;
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final int A08;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C2T.A09
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
            int r0 = r0 + (-93)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2T.A02(int, int, int):java.lang.String");
    }

    public static void A03() {
        A09 = new byte[]{-35, -30, -38, -34, -22, -25, -22, -19, -103, -88, -87, -88, -83, -88, -68, 22, 35, 24, 45, 19, 23, 35, 32, 35, 38, -54, -37, -56, -58, -37, -52, -33, -37, -58, -54, -42, -45, -42, -39, -19, 3, -6, 3, -2, 3, 45, -29, -27, -46, -28, -39, -28, -36, -43, -49, -45, -33, -36, -33, -30, -113, -46, -94, -46, -93, -46, -91, -25, 42, 42, -8, -12, -4, -12, 42, 42, 56, 73, 54, 52, 56, 68, 65, 68, 71, 52, 68, 75, 58, 71, 52, 66, 58, 57, 62, 54, -61, -59, -59, -57, -48, -42, -63, -59, -47, -50, -47, -44, -57, -40, -59, -61, -57, -45, -48, -45, -42, -22, -5, 41, -5, 45, -4, -3, -29, -40, -29, -37, -44, -50, -46, -34, -37, -34, -31, 38, 55, 36, 34, 55, 40, 59, 55, 34, 38, 50, 47, 50, 53, 34, 50, 57, 40, 53, 34, 48, 40, 39, 44, 36};
    }

    static {
        A03();
        A0A = Color.parseColor(A02(39, 7, 109));
        A0B = Color.parseColor(A02(117, 7, 106));
        A0C = Color.parseColor(A02(60, 7, 15));
        A0D = Color.parseColor(A02(67, 9, 103));
        A0E = Color.parseColor(A02(8, 7, 25));
        A0F = Color.parseColor(A02(67, 9, 103));
    }

    public C2T(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.A00 = i;
        this.A01 = i2;
        this.A02 = i3;
        this.A03 = i4;
        this.A04 = i5;
        this.A05 = i6;
        this.A06 = i7;
        this.A07 = i8;
        this.A08 = i9;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0025, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A00(@android.support.annotation.Nullable org.json.JSONObject r1, java.lang.String r2, int r3) {
        /*
            if (r1 == 0) goto L23
            r0 = 2
        L3:
            switch(r0) {
                case 2: goto L7;
                case 3: goto L15;
                case 4: goto L25;
                default: goto L6;
            }
        L6:
            goto L3
        L7:
            org.json.JSONObject r1 = (org.json.JSONObject) r1
            java.lang.String r2 = (java.lang.String) r2
            boolean r0 = r1.has(r2)
            if (r0 == 0) goto L13
            r0 = 3
            goto L3
        L13:
            r0 = 4
            goto L3
        L15:
            org.json.JSONObject r1 = (org.json.JSONObject) r1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r0 = r1.optString(r2)
            int r3 = android.graphics.Color.parseColor(r0)
            r0 = 4
            goto L3
        L23:
            r0 = 4
            goto L3
        L25:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2T.A00(org.json.JSONObject, java.lang.String, int):int");
    }

    public static C2T A01(@Nullable JSONObject jSONObject) {
        return new C2T(A00(jSONObject, A02(96, 12, 5), A0A), A00(jSONObject, A02(15, 10, 87), A0B), A00(jSONObject, A02(46, 14, 19), -16777216), A00(jSONObject, A02(0, 8, 30), A0C), A00(jSONObject, A02(108, 9, 7), A0D), A00(jSONObject, A02(76, 20, 120), -1), A00(jSONObject, A02(25, 14, 10), -1), A00(jSONObject, A02(135, 25, 102), A0F), A00(jSONObject, A02(124, 11, 18), -16777216));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A04(boolean r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            if (r4 == 0) goto L12
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L9;
                case 3: goto L14;
                case 4: goto Lc;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            r1 = -1
            r0 = 3
            goto L5
        Lc:
            com.facebook.ads.redexgen.X.2T r2 = (com.facebook.ads.redexgen.X.C2T) r2
            int r1 = r2.A00
            r0 = 3
            goto L5
        L12:
            r0 = 4
            goto L5
        L14:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2T.A04(boolean):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A05(boolean r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            if (r4 == 0) goto L12
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L9;
                case 3: goto L14;
                case 4: goto Lc;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            r1 = -1
            r0 = 3
            goto L5
        Lc:
            com.facebook.ads.redexgen.X.2T r2 = (com.facebook.ads.redexgen.X.C2T) r2
            int r1 = r2.A01
            r0 = 3
            goto L5
        L12:
            r0 = 4
            goto L5
        L14:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2T.A05(boolean):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A06(boolean r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            if (r4 == 0) goto L12
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L9;
                case 3: goto L14;
                case 4: goto Lc;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            r1 = -1
            r0 = 3
            goto L5
        Lc:
            com.facebook.ads.redexgen.X.2T r2 = (com.facebook.ads.redexgen.X.C2T) r2
            int r1 = r2.A02
            r0 = 3
            goto L5
        L12:
            r0 = 4
            goto L5
        L14:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2T.A06(boolean):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A07(boolean r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            if (r4 == 0) goto L13
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L9;
                case 3: goto L15;
                case 4: goto Ld;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            int r1 = com.facebook.ads.redexgen.X.C2T.A0E
            r0 = 3
            goto L5
        Ld:
            com.facebook.ads.redexgen.X.2T r2 = (com.facebook.ads.redexgen.X.C2T) r2
            int r1 = r2.A03
            r0 = 3
            goto L5
        L13:
            r0 = 4
            goto L5
        L15:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2T.A07(boolean):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0017, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A08(boolean r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            if (r4 == 0) goto L15
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L9;
                case 3: goto L17;
                case 4: goto Lf;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            com.facebook.ads.redexgen.X.2T r2 = (com.facebook.ads.redexgen.X.C2T) r2
            int r1 = r2.A05
            r0 = 3
            goto L5
        Lf:
            com.facebook.ads.redexgen.X.2T r2 = (com.facebook.ads.redexgen.X.C2T) r2
            int r1 = r2.A04
            r0 = 3
            goto L5
        L15:
            r0 = 4
            goto L5
        L17:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2T.A08(boolean):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0017, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A09(boolean r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            if (r4 == 0) goto L15
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L9;
                case 3: goto L17;
                case 4: goto Lf;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            com.facebook.ads.redexgen.X.2T r2 = (com.facebook.ads.redexgen.X.C2T) r2
            int r1 = r2.A07
            r0 = 3
            goto L5
        Lf:
            com.facebook.ads.redexgen.X.2T r2 = (com.facebook.ads.redexgen.X.C2T) r2
            int r1 = r2.A06
            r0 = 3
            goto L5
        L15:
            r0 = 4
            goto L5
        L17:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2T.A09(boolean):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A0A(boolean r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            if (r4 == 0) goto L12
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L9;
                case 3: goto L14;
                case 4: goto Lc;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            r1 = -1
            r0 = 3
            goto L5
        Lc:
            com.facebook.ads.redexgen.X.2T r2 = (com.facebook.ads.redexgen.X.C2T) r2
            int r1 = r2.A08
            r0 = 3
            goto L5
        L12:
            r0 = 4
            goto L5
        L14:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2T.A0A(boolean):int");
    }
}
