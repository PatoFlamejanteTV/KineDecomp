package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdSize;
import com.facebook.ads.internal.api.AdSizeApi;
import java.io.Serializable;

/* renamed from: com.facebook.ads.redexgen.X.Hw, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC0457Hw implements Serializable, AdSizeApi {
    A04(320, 50),
    A07(0, 0),
    A05(-1, 50),
    A06(-1, 90),
    A08(-1, 250);

    public static byte[] A02 = null;
    public static final long serialVersionUID = 42;
    public final int A00;
    public final int A01;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.EnumC0457Hw.A02
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
            int r0 = r0 + (-79)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC0457Hw.A03(int, int, int):java.lang.String");
    }

    public static void A04() {
        A02 = new byte[]{-46, -59, -61, -44, -63, -50, -57, -52, -59, -33, -56, -59, -55, -57, -56, -44, -33, -78, -75, -80, -95, -96, -83, -83, -92, -79, -66, -89, -92, -88, -90, -89, -77, -66, -104, -113, -71, -72, -59, -59, -68, -55, -42, -65, -68, -64, -66, -65, -53, -42, -84, -89, -77, -72, -66, -81, -68, -67, -66, -77, -66, -77, -85, -74, -49, -50, -37, -37, -46, -33, -20, -64, -65, -67, -20, -62, -67, 22, 47, 44, 47, 48, 56, 47, -31, 2, 37, 20, 42, 59, 38, -31, 53, 58, 49, 38, -17};
    }

    static {
        A04();
    }

    EnumC0457Hw(int i, int i2) {
        this.A01 = i;
        this.A00 = i2;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0005. Please report as an issue. */
    public static AdSizeApi A00(int i) {
        char c;
        EnumC0457Hw enumC0457Hw = null;
        switch (i) {
            case 4:
                c = 7;
                break;
            case 5:
                c = 6;
                break;
            case 6:
                c = 5;
                break;
            case 7:
                c = 4;
                break;
            case 100:
                c = 3;
                break;
            default:
                c = 2;
                break;
        }
        while (true) {
            switch (c) {
                case 2:
                    throw new IllegalArgumentException(A03(77, 20, 114));
                case 3:
                    enumC0457Hw = A07;
                    c = '\b';
                case 4:
                    enumC0457Hw = A08;
                    c = '\b';
                case 5:
                    enumC0457Hw = A06;
                    c = '\b';
                case 6:
                    enumC0457Hw = A05;
                    c = '\b';
                case 7:
                    enumC0457Hw = A04;
                    c = '\b';
                case '\b':
                    return enumC0457Hw;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x0091, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.EnumC0457Hw A01(int r2, int r3) {
        /*
            r1 = 0
            com.facebook.ads.redexgen.X.Hw r0 = com.facebook.ads.redexgen.X.EnumC0457Hw.A07
            int r0 = r0.A00
            if (r0 != r3) goto L8c
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L62;
                case 3: goto L87;
                case 4: goto L8f;
                case 5: goto L70;
                case 6: goto L18;
                case 7: goto L57;
                case 8: goto L47;
                case 9: goto L2f;
                case 10: goto L6c;
                case 11: goto L3b;
                case 12: goto L7b;
                case 13: goto L5e;
                case 14: goto L23;
                case 15: goto Lc;
                case 16: goto L53;
                case 17: goto L5b;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.Hw r0 = com.facebook.ads.redexgen.X.EnumC0457Hw.A08
            int r0 = r0.A01
            if (r0 != r2) goto L15
            r0 = 16
            goto L8
        L15:
            r0 = 17
            goto L8
        L18:
            com.facebook.ads.redexgen.X.Hw r0 = com.facebook.ads.redexgen.X.EnumC0457Hw.A04
            int r0 = r0.A01
            if (r0 != r2) goto L20
            r0 = 7
            goto L8
        L20:
            r0 = 8
            goto L8
        L23:
            com.facebook.ads.redexgen.X.Hw r0 = com.facebook.ads.redexgen.X.EnumC0457Hw.A08
            int r0 = r0.A00
            if (r0 != r3) goto L2c
            r0 = 15
            goto L8
        L2c:
            r0 = 17
            goto L8
        L2f:
            com.facebook.ads.redexgen.X.Hw r0 = com.facebook.ads.redexgen.X.EnumC0457Hw.A05
            int r0 = r0.A01
            if (r0 != r2) goto L38
            r0 = 10
            goto L8
        L38:
            r0 = 11
            goto L8
        L3b:
            com.facebook.ads.redexgen.X.Hw r0 = com.facebook.ads.redexgen.X.EnumC0457Hw.A06
            int r0 = r0.A00
            if (r0 != r3) goto L44
            r0 = 12
            goto L8
        L44:
            r0 = 14
            goto L8
        L47:
            com.facebook.ads.redexgen.X.Hw r0 = com.facebook.ads.redexgen.X.EnumC0457Hw.A05
            int r0 = r0.A00
            if (r0 != r3) goto L50
            r0 = 9
            goto L8
        L50:
            r0 = 11
            goto L8
        L53:
            com.facebook.ads.redexgen.X.Hw r1 = com.facebook.ads.redexgen.X.EnumC0457Hw.A08
            r0 = 4
            goto L8
        L57:
            com.facebook.ads.redexgen.X.Hw r1 = com.facebook.ads.redexgen.X.EnumC0457Hw.A04
            r0 = 4
            goto L8
        L5b:
            r1 = 0
            r0 = 4
            goto L8
        L5e:
            com.facebook.ads.redexgen.X.Hw r1 = com.facebook.ads.redexgen.X.EnumC0457Hw.A06
            r0 = 4
            goto L8
        L62:
            com.facebook.ads.redexgen.X.Hw r0 = com.facebook.ads.redexgen.X.EnumC0457Hw.A07
            int r0 = r0.A01
            if (r0 != r2) goto L6a
            r0 = 3
            goto L8
        L6a:
            r0 = 5
            goto L8
        L6c:
            com.facebook.ads.redexgen.X.Hw r1 = com.facebook.ads.redexgen.X.EnumC0457Hw.A05
            r0 = 4
            goto L8
        L70:
            com.facebook.ads.redexgen.X.Hw r0 = com.facebook.ads.redexgen.X.EnumC0457Hw.A04
            int r0 = r0.A00
            if (r0 != r3) goto L78
            r0 = 6
            goto L8
        L78:
            r0 = 8
            goto L8
        L7b:
            com.facebook.ads.redexgen.X.Hw r0 = com.facebook.ads.redexgen.X.EnumC0457Hw.A06
            int r0 = r0.A01
            if (r0 != r2) goto L84
            r0 = 13
            goto L8
        L84:
            r0 = 14
            goto L8
        L87:
            com.facebook.ads.redexgen.X.Hw r1 = com.facebook.ads.redexgen.X.EnumC0457Hw.A07
            r0 = 4
            goto L8
        L8c:
            r0 = 5
            goto L8
        L8f:
            com.facebook.ads.redexgen.X.Hw r1 = (com.facebook.ads.redexgen.X.EnumC0457Hw) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC0457Hw.A01(int, int):com.facebook.ads.redexgen.X.Hw");
    }

    public static EnumC0457Hw A02(AdSize adSize) {
        return A01(adSize.getWidth(), adSize.getHeight());
    }

    public final AdSize A05() {
        return AdSize.fromWidthAndHeight(this.A01, this.A00);
    }

    public final int getHeight() {
        return this.A00;
    }

    public final int getWidth() {
        return this.A01;
    }
}
