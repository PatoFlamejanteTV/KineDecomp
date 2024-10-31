package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Ow, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0634Ow extends AbstractRunnableC00351g {
    public static byte[] A02;
    public final /* synthetic */ P6 A00;
    public final /* synthetic */ QT A01;

    static {
        A04();
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
            byte[] r1 = com.facebook.ads.redexgen.X.C0634Ow.A02
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
            int r0 = r0 + (-97)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0634Ow.A01(int, int, int):java.lang.String");
    }

    public static void A04() {
        A02 = new byte[]{-63, -12, -27, -27, -28, -15, -24, -19, -26, -97, -24, -19, -29, -28, -27, -24, -19, -24, -13, -28, -21, -8};
    }

    public C0634Ow(P6 p6, QT qt) {
        this.A00 = p6;
        this.A01 = qt;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0040, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A05() {
        /*
            r5 = this;
            r4 = r5
            com.facebook.ads.redexgen.X.P6 r0 = r4.A00
            com.facebook.ads.redexgen.X.Lb r0 = com.facebook.ads.redexgen.X.P6.A02(r0)
            com.facebook.ads.redexgen.X.FR r1 = r0.getState()
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A02
            if (r1 != r0) goto L3e
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L14;
                case 3: goto L2c;
                case 4: goto L40;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            com.facebook.ads.redexgen.X.Ow r4 = (com.facebook.ads.redexgen.X.C0634Ow) r4
            com.facebook.ads.redexgen.X.P6 r0 = r4.A00
            com.facebook.ads.redexgen.X.Lb r0 = com.facebook.ads.redexgen.X.P6.A02(r0)
            int r1 = r0.getCurrentPositionInMillis()
            com.facebook.ads.redexgen.X.QT r0 = r4.A01
            int r0 = r0.A00()
            if (r1 != r0) goto L2a
            r0 = 3
            goto L10
        L2a:
            r0 = 4
            goto L10
        L2c:
            com.facebook.ads.redexgen.X.Ow r4 = (com.facebook.ads.redexgen.X.C0634Ow) r4
            com.facebook.ads.redexgen.X.P6 r3 = r4.A00
            r2 = 0
            r1 = 22
            r0 = 30
            java.lang.String r0 = A01(r2, r1, r0)
            com.facebook.ads.redexgen.X.P6.A0C(r3, r0)
            r0 = 4
            goto L10
        L3e:
            r0 = 4
            goto L10
        L40:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0634Ow.A05():void");
    }
}
