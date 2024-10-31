package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Map;

/* loaded from: assets/audience_network.dex */
public final class IH {
    public static byte[] A0E;
    public int A00;
    public C0361Eb A01;
    public EnumC0456Hu A02;
    public EnumC0458Hx A03;

    @Nullable
    public C0494Jj A04;

    @Nullable
    public String A05;
    public String A06;

    @Nullable
    public String A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public final AdPlacementType A0B;
    public final I2 A0C;

    @Nullable
    public final String A0D;

    static {
        A01();
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
            byte[] r1 = com.facebook.ads.redexgen.X.IH.A0E
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
            int r0 = r0 + (-98)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IH.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A0E = new byte[]{0, 19, 16, 20, 18, 19, 31, 12, 7, 9, 4, -76, -80, -91, -89, -87, -79, -87, -78, -72, -61, -72, -67, -76, -87, -80, -71, -74, -78, -69, -63, -52, -65, -78, -66, -62, -78, -64, -63, -52, -74, -79, -12, -27, -13, -12, -1, -19, -17, -28, -27, -82, -70, -69, -69, -84, 18, 3, 11, 14, 10, -1, 18, 3, 29, 7, 2, -70, 43, 29, 24, 40, 28, -70, -51, -55, -57, -74, -44, -67, -66, -61, -55, -56, 41, 28, 40, 44, 28, 42, 43, 54, 43, 32, 36, 28, -63, -62, -54, -52, -36, -66, -63, -36, -58, -63, -66, -70, -46, -59, -72, -58, -57, -59, -68, -74, -57, -72, -73, 30, 31, 12, 14, 22, 42, 31, 29, 12, 14, 16, -32, -25, -30, -3, -14, -25, -21, -29, -3, -14, -19, -23, -29, -20, -85, -75, -63, -81, -73, -82, -74, -85, -63, -93, -90, -63, -89, -70, -78, -89, -76, -85, -89, -80, -91, -89, 17, 20, 47, 34, 21, 32, 31, 34, 36, 25, 30, 23, 47, 19, 31, 30, 22, 25, 23, 47, 28, 17, 35, 36, 47, 37, 32, 20, 17, 36, 21, 47, 36, 25, 29, 21, -44, -49, -47, -52, -22, -47, -41, -52, -46, 47, 43, 32, 34, 36, 44, 36, 45, 51, 62, 40, 35, 15, 22, 17, 44, 22, 17, 18, 25, 17, 35, 5, 8, 23, 35, 22, 9, 21, 25, 9, 23, 24, 9, 8};
    }

    public IH(C0361Eb c0361Eb, String str, @Nullable C0494Jj c0494Jj, EnumC0458Hx enumC0458Hx, @Nullable String str2, int i, boolean z, boolean z2, I2 i2, @Nullable String str3, @Nullable String str4) {
        this.A01 = c0361Eb;
        this.A06 = str;
        this.A04 = c0494Jj;
        this.A03 = enumC0458Hx;
        this.A0D = str2;
        this.A00 = i;
        this.A0A = z;
        this.A08 = z2;
        this.A0C = i2;
        this.A02 = EnumC0456Hu.A00(enumC0458Hx);
        this.A0B = this.A02.A03();
        this.A07 = str3;
        this.A05 = str4;
    }

    private void A02(Map<String, String> params, String str, String str2) {
        params.put(str, str2);
    }

    public final int A03() {
        return this.A00;
    }

    public final EnumC0456Hu A04() {
        return this.A02;
    }

    public final EnumC0458Hx A05() {
        return this.A03;
    }

    public final I2 A06() {
        return this.A0C;
    }

    @Nullable
    public final C0494Jj A07() {
        return this.A04;
    }

    public final String A08() {
        return this.A06;
    }

    /* JADX WARN: Code restructure failed: missing block: B:156:0x02c1, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.String, java.lang.String> A09(java.util.Map<java.lang.String, java.lang.String> r9) {
        /*
            Method dump skipped, instructions count: 762
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IH.A09(java.util.Map):java.util.Map");
    }
}
