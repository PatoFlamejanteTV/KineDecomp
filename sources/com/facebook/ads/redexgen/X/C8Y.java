package com.facebook.ads.redexgen.X;

import android.content.Context;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedAdListener;
import com.facebook.ads.internal.api.InterstitialAdApi;
import com.facebook.ads.internal.api.Repairable;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.EnumSet;

/* renamed from: com.facebook.ads.redexgen.X.8Y, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C8Y implements InterstitialAdApi, Repairable {
    public static byte[] A04;
    public final InterstitialAd A00;
    public final C00903j A01;
    public final C00953o A02;
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
            byte[] r1 = com.facebook.ads.redexgen.X.C8Y.A04
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
            r0 = r0 ^ 13
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C8Y.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A04 = new byte[]{87, 112, 106, 123, 108, 109, 106, 119, 106, 119, Byte.MAX_VALUE, 114, 62, Byte.MAX_VALUE, 122, 62, 109, 118, 113, 105, 62, 125, Byte.MAX_VALUE, 114, 114, 123, 122, 21, 50, 40, 57, 46, 47, 40, 53, 40, 53, 61, 48, 124, 61, 56, 124, 48, 51, 61, 56, 124, 46, 57, 45, 41, 57, 47, 40, 57, 56, 117, 34, 37, 37, 117, 116, 113, 113, 122, 93, 71, 86, 65, 64, 71, 90, 71, 90, 82, 95, 19, 82, 87, 19, 87, 86, 64, 71, 65, 92, 74, 86, 87, 72, 111, 117, 100, 115, 111, 96, 109, 33, 100, 115, 115, 110, 115, 47, 11, 125, 102, 97, 121, 66, 67, 85, 82, 84, 73, 95, 92, 94, 8, 80, 11, 12, 94, 15, 28, 23, 52, 23, 25, 28, 57, 28, 11, 11, 12, 14, 11, 8, 92, 11};
    }

    public C8Y(Context context, String str, InterstitialAd interstitialAd) {
        this.A00 = interstitialAd;
        this.A03 = C8N.A03(context);
        this.A03.A08().A2g(AdPlacementType.INTERSTITIAL.toString());
        this.A01 = new C00903j(this.A03, interstitialAd, str);
        this.A03.A0B(this);
        this.A02 = new C00953o(this.A01);
    }

    public final void A02(RewardData rewardData) {
        this.A01.A0E(rewardData);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:            r4 = r4;        r4.A02.A07(r4.A00, r7, r8);        r4.A03.A08().A2b();     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005b, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A03(java.util.EnumSet<com.facebook.ads.CacheFlag> r7, @android.support.annotation.Nullable java.lang.String r8) {
        /*
            r6 = this;
            r4 = r6
            r2 = 125(0x7d, float:1.75E-43)
            r1 = 8
            r0 = 117(0x75, float:1.64E-43)
            java.lang.String r5 = A00(r2, r1, r0)
            r2 = 27
            r1 = 30
            r0 = 81
            java.lang.String r3 = A00(r2, r1, r0)
            r2 = 57
            r1 = 8
            r0 = 76
            java.lang.String r0 = A00(r2, r1, r0)
            com.facebook.ads.redexgen.X.I5.A05(r5, r3, r0)
            if (r8 != 0) goto L43
            r0 = 2
        L25:
            switch(r0) {
                case 2: goto L29;
                case 3: goto L45;
                case 4: goto L36;
                default: goto L28;
            }
        L28:
            goto L25
        L29:
            com.facebook.ads.redexgen.X.8Y r4 = (com.facebook.ads.redexgen.X.C8Y) r4
            com.facebook.ads.redexgen.X.Ec r0 = r4.A03
            com.facebook.ads.redexgen.X.0c r0 = r0.A08()
            r0.A2d()
            r0 = 3
            goto L25
        L36:
            com.facebook.ads.redexgen.X.8Y r4 = (com.facebook.ads.redexgen.X.C8Y) r4
            com.facebook.ads.redexgen.X.Ec r0 = r4.A03
            com.facebook.ads.redexgen.X.0c r0 = r0.A08()
            r0.A2c()
            r0 = 3
            goto L25
        L43:
            r0 = 4
            goto L25
        L45:
            com.facebook.ads.redexgen.X.8Y r4 = (com.facebook.ads.redexgen.X.C8Y) r4
            java.util.EnumSet r7 = (java.util.EnumSet) r7
            java.lang.String r8 = (java.lang.String) r8
            com.facebook.ads.redexgen.X.3o r1 = r4.A02
            com.facebook.ads.InterstitialAd r0 = r4.A00
            r1.A07(r0, r7, r8)
            com.facebook.ads.redexgen.X.Ec r0 = r4.A03
            com.facebook.ads.redexgen.X.0c r0 = r0.A08()
            r0.A2b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C8Y.A03(java.util.EnumSet, java.lang.String):void");
    }

    public final InterstitialAd.InterstitialAdLoadConfigBuilder buildLoadAdConfig() {
        return new C8Z(this);
    }

    public final InterstitialAd.InterstitialAdShowConfigBuilder buildShowAdConfig() {
        return new C02058a();
    }

    public final void destroy() {
        I5.A05(A00(110, 7, 43), A00(65, 25, 62), A00(133, 8, 52));
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
        return this.A01.A09();
    }

    public final boolean isAdInvalidated() {
        return this.A02.A08();
    }

    public final boolean isAdLoaded() {
        return this.A02.A09();
    }

    public final void loadAd() {
        loadAd(CacheFlag.ALL);
    }

    public final void loadAd(InterstitialAd.InterstitialLoadAdConfig interstitialLoadAdConfig) {
        ((C8Z) interstitialLoadAdConfig).A00();
    }

    public final void loadAd(EnumSet<CacheFlag> enumSet) {
        A03(enumSet, null);
    }

    @Deprecated
    public final void loadAdFromBid(String str) {
        A03(CacheFlag.ALL, str);
    }

    public final void loadAdFromBid(EnumSet<CacheFlag> cacheFlags, String str) {
        A03(cacheFlags, str);
    }

    public final void repair(Throwable th) {
        if (this.A01.A02() != null) {
            this.A01.A02().onError(this.A00, new AdError(2001, A00(90, 16, 12) + C0504Ju.A03(this.A03, th)));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0017, code lost:            r1.A2Z(r2);        r3.A01.A0D(r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setAdListener(com.facebook.ads.InterstitialAdListener r4) {
        /*
            r3 = this;
            r2 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Ec r0 = r3.A03
            com.facebook.ads.redexgen.X.0c r1 = r0.A08()
            if (r4 == 0) goto L15
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L17;
                case 4: goto L12;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            r2 = 1
            r0 = 3
            goto Lb
        L12:
            r2 = 0
            r0 = 3
            goto Lb
        L15:
            r0 = 4
            goto Lb
        L17:
            r0 = r3
            com.facebook.ads.redexgen.X.8Y r0 = (com.facebook.ads.redexgen.X.C8Y) r0
            com.facebook.ads.InterstitialAdListener r4 = (com.facebook.ads.InterstitialAdListener) r4
            com.facebook.ads.redexgen.X.0c r1 = (com.facebook.ads.redexgen.X.InterfaceC00050c) r1
            r1.A2Z(r2)
            com.facebook.ads.redexgen.X.3j r0 = r0.A01
            r0.A0D(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C8Y.setAdListener(com.facebook.ads.InterstitialAdListener):void");
    }

    @Deprecated
    public final void setExtraHints(ExtraHints extraHints) {
        this.A01.A0H(extraHints.getHints());
        this.A01.A0I(extraHints.getMediationData());
    }

    public final void setRewardedAdListener(RewardedAdListener rewardedAdListener) {
        this.A01.A0F(rewardedAdListener);
    }

    public final boolean show() {
        I5.A05(A00(106, 4, 3), A00(0, 27, 19), A00(117, 8, 100));
        this.A03.A08().A2m();
        boolean A0A = this.A02.A0A(this.A00, new C02058a());
        this.A03.A08().A2l(A0A);
        return A0A;
    }

    public final boolean show(InterstitialAd.InterstitialShowAdConfig interstitialShowAdConfig) {
        this.A03.A08().A2m();
        boolean A0A = this.A02.A0A(this.A00, interstitialShowAdConfig);
        this.A03.A08().A2l(A0A);
        return A0A;
    }
}
