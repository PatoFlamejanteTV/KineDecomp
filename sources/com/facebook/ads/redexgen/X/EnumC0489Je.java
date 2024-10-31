package com.facebook.ads.redexgen.X;

import com.facebook.ads.NativeAdBase;

/* renamed from: com.facebook.ads.redexgen.X.Je, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC0489Je {
    A0H(0),
    A0G(1),
    A0F(2),
    A0J(3),
    A0I(4),
    A09(5, NativeAdBase.NativeComponentTag.AD_ICON),
    A0E(6, NativeAdBase.NativeComponentTag.AD_TITLE),
    A08(7, NativeAdBase.NativeComponentTag.AD_COVER_IMAGE),
    A0D(8, NativeAdBase.NativeComponentTag.AD_SUBTITLE),
    A05(9, NativeAdBase.NativeComponentTag.AD_BODY),
    A06(10, NativeAdBase.NativeComponentTag.AD_CALL_TO_ACTION),
    A0C(11, NativeAdBase.NativeComponentTag.AD_SOCIAL_CONTEXT),
    A07(12, NativeAdBase.NativeComponentTag.AD_CHOICES_ICON),
    A0A(13, NativeAdBase.NativeComponentTag.AD_MEDIA),
    A0B(12, NativeAdBase.NativeComponentTag.AD_OPTIONS_VIEW);

    public static int A02;
    public static byte[] A03;
    public final int A00;
    public final NativeAdBase.NativeComponentTag A01;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.EnumC0489Je.A03
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
            int r0 = r0 + (-58)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC0489Je.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A03 = new byte[]{-58, -53, -47, -62, -49, -53, -66, -55, -36, -66, -63, -36, -48, -52, -64, -58, -66, -55, -36, -64, -52, -53, -47, -62, -43, -47, -21, -16, -10, -25, -12, -16, -29, -18, 1, -29, -26, 1, -28, -15, -26, -5, -17, -12, -6, -21, -8, -12, -25, -14, 5, -25, -22, 5, -11, -10, -6, -17, -11, -12, -7, 5, -4, -17, -21, -3, -50, -45, -39, -54, -41, -45, -58, -47, -28, -58, -55, -28, -50, -56, -44, -45, -51, -46, -40, -55, -42, -46, -59, -48, -29, -46, -45, -29, -40, -59, -53, -66, -61, -55, -70, -57, -61, -74, -63, -44, -74, -71, -44, -62, -70, -71, -66, -74, -83, -78, -72, -87, -74, -78, -91, -80, -61, -91, -76, -83, -61, -72, -77, -77, -61, -80, -77, -69, -50, -45, -39, -54, -41, -45, -58, -47, -28, -45, -44, -28, -56, -47, -50, -56, -48, -43, -38, -32, -47, -34, -38, -51, -40, -21, -51, -48, -21, -49, -37, -30, -47, -34, -21, -43, -39, -51, -45, -47, -111, -106, -100, -115, -102, -106, -119, -108, -89, -119, -116, -89, -100, -111, -100, -108, -115, -15, -10, -4, -19, -6, -10, -23, -12, 7, -10, -3, -12, -12, 7, -2, -15, -19, -1, -38, -33, -27, -42, -29, -33, -46, -35, -16, -24, -29, -32, -33, -40, -16, -27, -46, -40, -16, -44, -35, -46, -28, -28, -3, 2, 8, -7, 6, 2, -11, 0, 19, -11, -8, 19, -9, -4, 3, -3, -9, -7, 7, 19, -3, -9, 3, 2, 2, 7, 13, -2, 11, 7, -6, 5, 24, -6, -3, 24, 12, 14, -5, 13, 2, 13, 5, -2, -13, -8, -2, -17, -4, -8, -21, -10, 9, -21, -18, 9, -19, -21, -10, -10, 9, -2, -7, 9, -21, -19, -2, -13, -7, -8};
    }

    static {
        A02();
        A02 = -1593835521;
    }

    EnumC0489Je(int i) {
        this.A00 = i;
        this.A01 = null;
    }

    EnumC0489Je(int i, NativeAdBase.NativeComponentTag nativeComponentTag) {
        this.A00 = i;
        this.A01 = nativeComponentTag;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x002c, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.EnumC0489Je A00(com.facebook.ads.NativeAdBase.NativeComponentTag r5) {
        /*
            r4 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Je[] r3 = values()
            int r2 = r3.length
            r1 = 0
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L15;
                case 4: goto L2a;
                case 5: goto L23;
                case 6: goto L27;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            if (r1 >= r2) goto L13
            r0 = 3
            goto Lb
        L13:
            r0 = 6
            goto Lb
        L15:
            com.facebook.ads.NativeAdBase$NativeComponentTag r5 = (com.facebook.ads.NativeAdBase.NativeComponentTag) r5
            com.facebook.ads.redexgen.X.Je[] r3 = (com.facebook.ads.redexgen.X.EnumC0489Je[]) r3
            r4 = r3[r1]
            com.facebook.ads.NativeAdBase$NativeComponentTag r0 = r4.A01
            if (r0 != r5) goto L21
            r0 = 4
            goto Lb
        L21:
            r0 = 5
            goto Lb
        L23:
            int r1 = r1 + 1
            r0 = 2
            goto Lb
        L27:
            r4 = 0
            r0 = 4
            goto Lb
        L2a:
            com.facebook.ads.redexgen.X.Je r4 = (com.facebook.ads.redexgen.X.EnumC0489Je) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC0489Je.A00(com.facebook.ads.NativeAdBase$NativeComponentTag):com.facebook.ads.redexgen.X.Je");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x002a, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A03(android.view.View r3, com.facebook.ads.NativeAdBase.NativeComponentTag r4) {
        /*
            r0 = 0
            com.facebook.ads.redexgen.X.Je r2 = A00(r4)
            if (r3 == 0) goto L28
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L14;
                case 4: goto L1d;
                case 5: goto L2a;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.Je r2 = (com.facebook.ads.redexgen.X.EnumC0489Je) r2
            if (r2 == 0) goto L12
            r0 = 3
            goto L8
        L12:
            r0 = 5
            goto L8
        L14:
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 4
            if (r1 <= r0) goto L1b
            r0 = 4
            goto L8
        L1b:
            r0 = 5
            goto L8
        L1d:
            android.view.View r3 = (android.view.View) r3
            com.facebook.ads.NativeAdBase$NativeComponentTag r4 = (com.facebook.ads.NativeAdBase.NativeComponentTag) r4
            int r0 = com.facebook.ads.redexgen.X.EnumC0489Je.A02
            r3.setTag(r0, r4)
            r0 = 5
            goto L8
        L28:
            r0 = 5
            goto L8
        L2a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC0489Je.A03(android.view.View, com.facebook.ads.NativeAdBase$NativeComponentTag):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0025, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A04(android.view.View r2, com.facebook.ads.redexgen.X.EnumC0489Je r3) {
        /*
            if (r2 == 0) goto L23
            r0 = 2
        L3:
            switch(r0) {
                case 2: goto L7;
                case 3: goto Lf;
                case 4: goto L18;
                case 5: goto L25;
                default: goto L6;
            }
        L6:
            goto L3
        L7:
            com.facebook.ads.redexgen.X.Je r3 = (com.facebook.ads.redexgen.X.EnumC0489Je) r3
            if (r3 == 0) goto Ld
            r0 = 3
            goto L3
        Ld:
            r0 = 5
            goto L3
        Lf:
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 4
            if (r1 <= r0) goto L16
            r0 = 4
            goto L3
        L16:
            r0 = 5
            goto L3
        L18:
            android.view.View r2 = (android.view.View) r2
            com.facebook.ads.redexgen.X.Je r3 = (com.facebook.ads.redexgen.X.EnumC0489Je) r3
            int r0 = com.facebook.ads.redexgen.X.EnumC0489Je.A02
            r2.setTag(r0, r3)
            r0 = 5
            goto L3
        L23:
            r0 = 5
            goto L3
        L25:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC0489Je.A04(android.view.View, com.facebook.ads.redexgen.X.Je):void");
    }

    public final int A05() {
        return this.A00;
    }
}
