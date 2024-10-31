package com.facebook.ads.redexgen.X;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: assets/audience_network.dex */
public class EM extends AbstractRunnableC00351g {
    public static byte[] A02;
    public final /* synthetic */ EN A00;
    public final /* synthetic */ AtomicBoolean A01;

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
            byte[] r1 = com.facebook.ads.redexgen.X.EM.A02
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
            r0 = r0 ^ 85
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EM.A01(int, int, int):java.lang.String");
    }

    public static void A04() {
        A02 = new byte[]{92, 126, 124, 119, 122, 63, 121, 126, 118, 115, 49, 107, 73, 75, 64, 77, 8, 91, 93, 75, 75, 77, 91, 91, 6};
    }

    public EM(EN en, AtomicBoolean atomicBoolean) {
        this.A00 = en;
        this.A01 = atomicBoolean;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0099, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A05() {
        /*
            r10 = this;
            r1 = r10
            com.facebook.ads.redexgen.X.EN r0 = r1.A00
            com.facebook.ads.redexgen.X.1Z r0 = r0.A00
            if (r0 == 0) goto L96
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L1a;
                case 4: goto L99;
                case 5: goto L58;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.EM r1 = (com.facebook.ads.redexgen.X.EM) r1
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.A01
            boolean r0 = r0.get()
            if (r0 == 0) goto L18
            r0 = 3
            goto L8
        L18:
            r0 = 5
            goto L8
        L1a:
            com.facebook.ads.redexgen.X.EM r1 = (com.facebook.ads.redexgen.X.EM) r1
            com.facebook.ads.redexgen.X.EN r0 = r1.A00
            com.facebook.ads.redexgen.X.EV r2 = r0.A02
            com.facebook.ads.redexgen.X.Gu r0 = com.facebook.ads.redexgen.X.EnumC0431Gu.A0G
            com.facebook.ads.redexgen.X.EV.A0E(r2, r0)
            com.facebook.ads.redexgen.X.EN r0 = r1.A00
            com.facebook.ads.redexgen.X.EV r0 = r0.A02
            com.facebook.ads.redexgen.X.Eb r4 = com.facebook.ads.redexgen.X.EV.A07(r0)
            com.facebook.ads.redexgen.X.EN r0 = r1.A00
            com.facebook.ads.redexgen.X.EP r5 = r0.A01
            int r6 = com.facebook.ads.redexgen.X.EY.A00
            r3 = 11
            r2 = 14
            r0 = 125(0x7d, float:1.75E-43)
            java.lang.String r7 = A01(r3, r2, r0)
            com.facebook.ads.redexgen.X.EN r0 = r1.A00
            com.facebook.ads.redexgen.X.EV r0 = r0.A02
            long r8 = com.facebook.ads.redexgen.X.EV.A00(r0)
            com.facebook.ads.redexgen.X.EY.A02(r4, r5, r6, r7, r8)
            com.facebook.ads.redexgen.X.EN r0 = r1.A00
            com.facebook.ads.redexgen.X.EV r0 = r0.A02
            r0.A0M()
            com.facebook.ads.redexgen.X.EN r0 = r1.A00
            com.facebook.ads.redexgen.X.1Z r0 = r0.A00
            r0.A6P()
            r0 = 4
            goto L8
        L58:
            com.facebook.ads.redexgen.X.EM r1 = (com.facebook.ads.redexgen.X.EM) r1
            com.facebook.ads.redexgen.X.EN r0 = r1.A00
            com.facebook.ads.redexgen.X.EV r2 = r0.A02
            com.facebook.ads.redexgen.X.Gu r0 = com.facebook.ads.redexgen.X.EnumC0431Gu.A0F
            com.facebook.ads.redexgen.X.EV.A0E(r2, r0)
            com.facebook.ads.redexgen.X.EN r0 = r1.A00
            com.facebook.ads.redexgen.X.EV r0 = r0.A02
            com.facebook.ads.redexgen.X.Eb r4 = com.facebook.ads.redexgen.X.EV.A07(r0)
            com.facebook.ads.redexgen.X.EN r0 = r1.A00
            com.facebook.ads.redexgen.X.EP r5 = r0.A01
            int r6 = com.facebook.ads.redexgen.X.EY.A04
            r3 = 0
            r2 = 11
            r0 = 74
            java.lang.String r7 = A01(r3, r2, r0)
            com.facebook.ads.redexgen.X.EN r0 = r1.A00
            com.facebook.ads.redexgen.X.EV r0 = r0.A02
            long r8 = com.facebook.ads.redexgen.X.EV.A00(r0)
            com.facebook.ads.redexgen.X.EY.A02(r4, r5, r6, r7, r8)
            com.facebook.ads.redexgen.X.EN r0 = r1.A00
            com.facebook.ads.redexgen.X.EV r0 = r0.A02
            r0.A0N()
            com.facebook.ads.redexgen.X.EN r0 = r1.A00
            com.facebook.ads.redexgen.X.1Z r0 = r0.A00
            r0.A6I()
            r0 = 4
            goto L8
        L96:
            r0 = 4
            goto L8
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EM.A05():void");
    }
}
