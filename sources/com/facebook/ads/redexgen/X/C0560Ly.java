package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Ly, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0560Ly extends AbstractRunnableC00351g {
    public static byte[] A02;
    public final /* synthetic */ int A00;
    public final /* synthetic */ C0561Lz A01;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C0560Ly.A02
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0560Ly.A01(int, int, int):java.lang.String");
    }

    public static void A04() {
        A02 = new byte[]{-58, -7, -22, -22, -23, -10, -19, -14, -21, -92, -19, -14, -24, -23, -22, -19, -14, -19, -8, -23, -16, -3};
    }

    public C0560Ly(C0561Lz c0561Lz, int i) {
        this.A01 = c0561Lz;
        this.A00 = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A05() {
        /*
            r5 = this;
            r4 = r5
            com.facebook.ads.redexgen.X.Lz r0 = r4.A01
            com.facebook.ads.redexgen.X.M3 r0 = r0.A00
            com.facebook.ads.redexgen.X.Lb r0 = com.facebook.ads.redexgen.X.M3.A0B(r0)
            if (r0 != 0) goto L5c
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L5e;
                case 3: goto L10;
                case 4: goto L26;
                case 5: goto L3c;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.Ly r4 = (com.facebook.ads.redexgen.X.C0560Ly) r4
            com.facebook.ads.redexgen.X.Lz r0 = r4.A01
            com.facebook.ads.redexgen.X.M3 r0 = r0.A00
            com.facebook.ads.redexgen.X.Lb r0 = com.facebook.ads.redexgen.X.M3.A0B(r0)
            com.facebook.ads.redexgen.X.FR r1 = r0.getState()
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A02
            if (r1 != r0) goto L24
            r0 = 4
            goto Lc
        L24:
            r0 = 2
            goto Lc
        L26:
            com.facebook.ads.redexgen.X.Ly r4 = (com.facebook.ads.redexgen.X.C0560Ly) r4
            com.facebook.ads.redexgen.X.Lz r0 = r4.A01
            com.facebook.ads.redexgen.X.M3 r0 = r0.A00
            com.facebook.ads.redexgen.X.Lb r0 = com.facebook.ads.redexgen.X.M3.A0B(r0)
            int r1 = r0.getCurrentPositionInMillis()
            int r0 = r4.A00
            if (r1 != r0) goto L3a
            r0 = 5
            goto Lc
        L3a:
            r0 = 2
            goto Lc
        L3c:
            com.facebook.ads.redexgen.X.Ly r4 = (com.facebook.ads.redexgen.X.C0560Ly) r4
            com.facebook.ads.redexgen.X.Lz r0 = r4.A01
            com.facebook.ads.redexgen.X.M3 r0 = r0.A00
            android.os.Handler r1 = com.facebook.ads.redexgen.X.M3.A02(r0)
            r0 = 0
            r1.removeCallbacksAndMessages(r0)
            com.facebook.ads.redexgen.X.Lz r0 = r4.A01
            com.facebook.ads.redexgen.X.M3 r3 = r0.A00
            r2 = 0
            r1 = 22
            r0 = 74
            java.lang.String r0 = A01(r2, r1, r0)
            com.facebook.ads.redexgen.X.M3.A0Z(r3, r0)
            r0 = 2
            goto Lc
        L5c:
            r0 = 3
            goto Lc
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0560Ly.A05():void");
    }
}
