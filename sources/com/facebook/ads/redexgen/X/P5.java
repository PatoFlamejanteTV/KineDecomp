package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public class P5 extends AbstractRunnableC00351g {
    public static byte[] A01;
    public final /* synthetic */ P6 A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.P5.A01
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
            r0 = r0 ^ 37
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.P5.A01(int, int, int):java.lang.String");
    }

    public static void A04() {
        A01 = new byte[]{107, 84, 89, 88, 82, 29, 74, 92, 78, 29, 83, 88, 75, 88, 79, 29, 77, 79, 88, 77, 92, 79, 88, 89};
    }

    public P5(P6 p6) {
        this.A00 = p6;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
    public final void A05() {
        boolean z;
        z = this.A00.A06;
        if (z) {
            return;
        }
        this.A00.A0G(A01(0, 24, 24));
    }
}
