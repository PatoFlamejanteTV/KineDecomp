package com.facebook.ads.redexgen.X;

import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;

/* renamed from: com.facebook.ads.redexgen.X.Fu, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0405Fu extends AbstractRunnableC00351g {
    public static byte[] A03;
    public final /* synthetic */ AudienceNetworkAds.InitListener A00;
    public final /* synthetic */ C0365Ef A01;
    public final /* synthetic */ MultithreadedBundleWrapper A02;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C0405Fu.A03
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
            r0 = r0 ^ 88
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0405Fu.A01(int, int, int):java.lang.String");
    }

    public static void A04() {
        A03 = new byte[]{120, 79, 64, 11, 88, 94, 72, 72, 78, 88, 88, 77, 94, 71, 71, 82, 11, 66, 69, 66, 95, 66, 74, 71, 66, 81, 78, 79, 10};
    }

    public C0405Fu(C0365Ef c0365Ef, MultithreadedBundleWrapper multithreadedBundleWrapper, AudienceNetworkAds.InitListener initListener) {
        this.A01 = c0365Ef;
        this.A02 = multithreadedBundleWrapper;
        this.A00 = initListener;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004f, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A05() {
        /*
            r7 = this;
            r6 = r7
            r0 = 0
            r0 = 0
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 13: goto L36;
                case 14: goto L4f;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            com.facebook.ads.redexgen.X.GI r1 = com.facebook.ads.redexgen.X.GI.A01()     // Catch: java.lang.Throwable -> L23
            com.facebook.ads.redexgen.X.Ef r0 = r6.A01     // Catch: java.lang.Throwable -> L23
            r1.A09(r0)     // Catch: java.lang.Throwable -> L23
            java.util.concurrent.atomic.AtomicBoolean r0 = com.facebook.ads.redexgen.X.G2.A03()     // Catch: java.lang.Throwable -> L23
            boolean r0 = r0.get()     // Catch: java.lang.Throwable -> L23
            if (r0 != 0) goto L27
            com.facebook.ads.redexgen.X.Ef r1 = r6.A01     // Catch: java.lang.Throwable -> L23
            com.facebook.ads.internal.settings.MultithreadedBundleWrapper r0 = r6.A02     // Catch: java.lang.Throwable -> L23
            com.facebook.ads.redexgen.X.GT.A03(r1, r0)     // Catch: java.lang.Throwable -> L23
            goto L27
        L23:
            r0 = move-exception
            com.facebook.ads.redexgen.X.C0511Kb.A0F(r0)
        L27:
            com.facebook.ads.redexgen.X.Ef r0 = r6.A01
            com.facebook.ads.redexgen.X.G2.A0E(r0)
            com.facebook.ads.AudienceNetworkAds$InitListener r0 = r6.A00
            if (r0 == 0) goto L33
            r0 = 13
            goto L4
        L33:
            r0 = 14
            goto L4
        L36:
            com.facebook.ads.redexgen.X.Fu r6 = (com.facebook.ads.redexgen.X.C0405Fu) r6
            com.facebook.ads.AudienceNetworkAds$InitListener r5 = r6.A00
            com.facebook.ads.redexgen.X.G1 r4 = new com.facebook.ads.redexgen.X.G1
            r3 = 1
            r2 = 0
            r1 = 29
            r0 = 115(0x73, float:1.61E-43)
            java.lang.String r0 = A01(r2, r1, r0)
            r4.<init>(r3, r0)
            com.facebook.ads.redexgen.X.G2.A06(r5, r4)
            r0 = 14
            goto L4
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0405Fu.A05():void");
    }
}
