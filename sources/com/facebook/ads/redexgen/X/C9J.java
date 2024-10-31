package com.facebook.ads.redexgen.X;

import android.content.Context;
import com.facebook.ads.AdError;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.internal.api.Repairable;
import com.facebook.ads.internal.api.RewardedVideoAdApi;
import com.facebook.ads.internal.protocol.AdPlacementType;

/* renamed from: com.facebook.ads.redexgen.X.9J, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C9J implements RewardedVideoAdApi, Repairable {
    public static byte[] A04;
    public final RewardedVideoAd A00;
    public final C00993s A01;
    public final C01013u A02;
    public final C0362Ec A03;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C9J.A04
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
            int r0 = r0 + (-127)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C9J.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A04 = new byte[]{53, 56, 42, 45, 10, 45, -1, 18, 36, 14, 31, 17, 18, 17, -51, 35, 22, 17, 18, 28, -51, 14, 17, -51, 32, 21, 28, 36, -51, 16, 14, 25, 25, 18, 17, 76, 95, 113, 91, 108, 94, 95, 94, 26, 112, 99, 94, 95, 105, 26, 91, 94, 26, 102, 105, 91, 94, 26, 108, 95, 107, 111, 95, 109, 110, 95, 94, -55, -56, -52, -6, -6, -9, -55, 83, 86, 72, 75, 40, 75, 45, 89, 86, 84, 41, 80, 75, -44, -48, -44, -41, -40, 1, 6, -40, 59, 96, 102, 87, 100, 96, 83, 94, 18, 87, 100, 100, 97, 100, 32, -4, -6, 41, 42, 40, -1, -4, -4, -2, -41, -22, -4, -26, -9, -23, -22, -23, -91, -5, -18, -23, -22, -12, -91, -26, -23, -91, -23, -22, -8, -7, -9, -12, -2, -22, -23, 47, 36, 43, 51, 50, 97, 99, 94, 95, 98, 53, 47, 60, 61, 75, 76, 74, 71, 81, -59, -14, -63, -66, -63, -66, -62, -12, 27, 30, 23, 27, 29, 30, 73, 23, -13, -13, -19, -16, 30, 34, 31, -11, -78, -80, -80, -76, -75, -28, -78, -31};
    }

    public C9J(Context context, String str, RewardedVideoAd rewardedVideoAd) {
        this.A00 = rewardedVideoAd;
        this.A03 = C8N.A05(context);
        this.A03.A08().A2g(AdPlacementType.REWARDED_VIDEO.toString());
        this.A01 = new C00993s(this.A03, str, this.A00);
        this.A03.A0B(this);
        this.A02 = new C01013u(this.A01);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:            r2 = r2;        r2.A02.A08(r2.A00, r4, r5);        r2.A03.A08().A2b();     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A02(@android.support.annotation.Nullable java.lang.String r4, boolean r5) {
        /*
            r3 = this;
            r2 = r3
            if (r4 != 0) goto L22
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L24;
                case 4: goto L15;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            com.facebook.ads.redexgen.X.9J r2 = (com.facebook.ads.redexgen.X.C9J) r2
            com.facebook.ads.redexgen.X.Ec r0 = r2.A03
            com.facebook.ads.redexgen.X.0c r0 = r0.A08()
            r0.A2d()
            r0 = 3
            goto L4
        L15:
            com.facebook.ads.redexgen.X.9J r2 = (com.facebook.ads.redexgen.X.C9J) r2
            com.facebook.ads.redexgen.X.Ec r0 = r2.A03
            com.facebook.ads.redexgen.X.0c r0 = r0.A08()
            r0.A2c()
            r0 = 3
            goto L4
        L22:
            r0 = 4
            goto L4
        L24:
            com.facebook.ads.redexgen.X.9J r2 = (com.facebook.ads.redexgen.X.C9J) r2
            java.lang.String r4 = (java.lang.String) r4
            com.facebook.ads.redexgen.X.3u r1 = r2.A02
            com.facebook.ads.RewardedVideoAd r0 = r2.A00
            r1.A08(r0, r4, r5)
            com.facebook.ads.redexgen.X.Ec r0 = r2.A03
            com.facebook.ads.redexgen.X.0c r0 = r0.A08()
            r0.A2b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C9J.A02(java.lang.String, boolean):void");
    }

    public final RewardedVideoAd.RewardedVideoAdLoadConfigBuilder buildLoadAdConfig() {
        return new C9K(this);
    }

    public final RewardedVideoAd.RewardedVideoAdShowConfigBuilder buildShowAdConfig() {
        return new C9L();
    }

    public final void destroy() {
        I5.A05(A00(158, 7, 89), A00(119, 27, 6), A00(87, 8, 33));
        if (C0413Gc.A0y(this.A03)) {
            return;
        }
        this.A02.A04();
        this.A03.A08().A2h();
    }

    public final void finalize() {
        this.A02.A03();
    }

    public final String getPlacementId() {
        return this.A01.A0B;
    }

    public final int getVideoDuration() {
        return this.A01.A00;
    }

    public final boolean isAdInvalidated() {
        return this.A02.A09();
    }

    public final boolean isAdLoaded() {
        return this.A02.A0A();
    }

    public final void loadAd() {
        I5.A05(A00(0, 6, 74), A00(35, 32, 123), A00(67, 7, 22));
        A02(null, true);
    }

    public final void loadAd(RewardedVideoAd.RewardedVideoLoadAdConfig rewardedVideoLoadAdConfig) {
        ((C9K) rewardedVideoLoadAdConfig).A00();
    }

    public final void loadAd(boolean z) {
        I5.A05(A00(0, 6, 74), A00(35, 32, 123), A00(189, 8, 0));
        A02(null, z);
    }

    @Deprecated
    public final void loadAdFromBid(String str) {
        I5.A05(A00(74, 13, 104), A00(35, 32, 123), A00(165, 8, 15));
        A02(str, true);
    }

    public final void loadAdFromBid(String str, boolean z) {
        I5.A05(A00(74, 13, 104), A00(35, 32, 123), A00(181, 8, 62));
        A02(str, z);
    }

    public final void repair(Throwable th) {
        if (this.A01.A03 != null) {
            this.A01.A03.onError(this.A00, new AdError(2001, A00(95, 16, 115) + C0504Ju.A03(this.A01.A0A, th)));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001b, code lost:            r1.A2Z(r2);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setAdListener(com.facebook.ads.RewardedVideoAdListener r4) {
        /*
            r3 = this;
            r2 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.3s r0 = r3.A01
            r0.A03 = r4
            com.facebook.ads.redexgen.X.Ec r0 = r3.A03
            com.facebook.ads.redexgen.X.0c r1 = r0.A08()
            if (r4 == 0) goto L19
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L13;
                case 3: goto L1b;
                case 4: goto L16;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            r2 = 1
            r0 = 3
            goto Lf
        L16:
            r2 = 0
            r0 = 3
            goto Lf
        L19:
            r0 = 4
            goto Lf
        L1b:
            com.facebook.ads.redexgen.X.0c r1 = (com.facebook.ads.redexgen.X.InterfaceC00050c) r1
            r1.A2Z(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C9J.setAdListener(com.facebook.ads.RewardedVideoAdListener):void");
    }

    @Deprecated
    public final void setExtraHints(ExtraHints extraHints) {
        this.A01.A05 = extraHints.getHints();
        this.A01.A06 = extraHints.getMediationData();
    }

    public final void setRewardData(RewardData rewardData) {
        this.A02.A07(rewardData);
    }

    public final boolean show() {
        I5.A05(A00(146, 4, 61), A00(6, 29, 46), A00(150, 8, 126));
        return show(-1);
    }

    public final boolean show(int i) {
        I5.A05(A00(146, 4, 61), A00(6, 29, 46), A00(111, 8, 72));
        this.A03.A08().A2m();
        boolean A0B = this.A02.A0B(this.A00, new C9L().withAppOrientation(i).build());
        this.A03.A08().A2l(A0B);
        return A0B;
    }

    public final boolean show(RewardedVideoAd.RewardedVideoShowAdConfig rewardedVideoShowAdConfig) {
        I5.A05(A00(146, 4, 61), A00(6, 29, 46), A00(173, 8, 104));
        this.A03.A08().A2m();
        boolean A0B = this.A02.A0B(this.A00, rewardedVideoShowAdConfig);
        this.A03.A08().A2l(A0B);
        return A0B;
    }
}
