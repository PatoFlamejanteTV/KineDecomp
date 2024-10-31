package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public class LK extends AbstractC02238s {
    public static byte[] A01;
    public final /* synthetic */ LO A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.LK.A01
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
            r0 = r0 ^ 32
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LK.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{113, 110, 99, 98, 104, 78, 105, 115, 98, 117, 116, 115, 110, 115, 102, 107, 66, 113, 98, 105, 115};
    }

    public LK(LO lo) {
        this.A00 = lo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0086, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.C1S
    /* renamed from: A02, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A03(com.facebook.ads.redexgen.X.QM r6) {
        /*
            r5 = this;
            r4 = r5
            com.facebook.ads.redexgen.X.LO r0 = r4.A00
            java.util.concurrent.atomic.AtomicBoolean r1 = com.facebook.ads.redexgen.X.LO.A0D(r0)
            r0 = 1
            r1.set(r0)
            com.facebook.ads.redexgen.X.LO r1 = r4.A00
            r0 = 0
            r1.setForcedTimeViewIncomplete(r0)
            com.facebook.ads.redexgen.X.LO r0 = r4.A00
            r0.A06()
            com.facebook.ads.redexgen.X.LO r0 = r4.A00
            com.facebook.ads.redexgen.X.81 r0 = r0.getAudienceNetworkListener()
            if (r0 == 0) goto L84
            r0 = 2
        L1f:
            switch(r0) {
                case 2: goto L6c;
                case 3: goto L5e;
                case 4: goto L4f;
                case 5: goto L43;
                case 6: goto L23;
                case 7: goto L86;
                default: goto L22;
            }
        L22:
            goto L1f
        L23:
            com.facebook.ads.redexgen.X.LK r4 = (com.facebook.ads.redexgen.X.LK) r4
            com.facebook.ads.redexgen.X.LO r0 = r4.A00
            com.facebook.ads.internal.view.FullScreenAdToolbar r1 = r0.A0D
            com.facebook.ads.redexgen.X.LO r0 = r4.A00
            int r0 = r0.getCloseButtonStyle()
            r1.setToolbarActionMode(r0)
            com.facebook.ads.redexgen.X.LO r0 = r4.A00
            com.facebook.ads.internal.view.FullScreenAdToolbar r3 = r0.A0D
            r2 = 0
            r1 = 0
            r0 = 65
            java.lang.String r0 = A00(r2, r1, r0)
            r3.setToolbarActionMessage(r0)
            r0 = 7
            goto L1f
        L43:
            com.facebook.ads.redexgen.X.LK r4 = (com.facebook.ads.redexgen.X.LK) r4
            com.facebook.ads.redexgen.X.LO r0 = r4.A00
            com.facebook.ads.internal.view.FullScreenAdToolbar r0 = r0.A0D
            if (r0 == 0) goto L4d
            r0 = 6
            goto L1f
        L4d:
            r0 = 7
            goto L1f
        L4f:
            com.facebook.ads.redexgen.X.LK r4 = (com.facebook.ads.redexgen.X.LK) r4
            com.facebook.ads.redexgen.X.QM r6 = (com.facebook.ads.redexgen.X.QM) r6
            com.facebook.ads.redexgen.X.LO r0 = r4.A00
            com.facebook.ads.redexgen.X.Nr r0 = com.facebook.ads.redexgen.X.LO.A06(r0)
            r0.A0M(r6)
            r0 = 5
            goto L1f
        L5e:
            com.facebook.ads.redexgen.X.LK r4 = (com.facebook.ads.redexgen.X.LK) r4
            com.facebook.ads.redexgen.X.LO r0 = r4.A00
            com.facebook.ads.redexgen.X.Nr r0 = com.facebook.ads.redexgen.X.LO.A06(r0)
            if (r0 == 0) goto L6a
            r0 = 4
            goto L1f
        L6a:
            r0 = 5
            goto L1f
        L6c:
            com.facebook.ads.redexgen.X.LK r4 = (com.facebook.ads.redexgen.X.LK) r4
            com.facebook.ads.redexgen.X.QM r6 = (com.facebook.ads.redexgen.X.QM) r6
            com.facebook.ads.redexgen.X.LO r0 = r4.A00
            com.facebook.ads.redexgen.X.81 r3 = r0.getAudienceNetworkListener()
            r2 = 0
            r1 = 21
            r0 = 39
            java.lang.String r0 = A00(r2, r1, r0)
            r3.A3c(r0, r6)
            r0 = 3
            goto L1f
        L84:
            r0 = 3
            goto L1f
        L86:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LK.A03(com.facebook.ads.redexgen.X.QM):void");
    }
}
