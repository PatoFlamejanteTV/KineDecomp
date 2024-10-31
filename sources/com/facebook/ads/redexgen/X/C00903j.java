package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedAdListener;
import java.lang.ref.WeakReference;
import java.util.EnumSet;

/* renamed from: com.facebook.ads.redexgen.X.3j, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C00903j {
    public long A00 = -1;

    @Nullable
    public InterstitialAd A01;

    @Nullable
    public InterstitialAdListener A02;

    @Nullable
    public RewardData A03;

    @Nullable
    public RewardedAdListener A04;

    @Nullable
    public String A05;

    @Nullable
    public String A06;

    @Nullable
    public String A07;

    @Nullable
    public EnumSet<CacheFlag> A08;
    public final C0362Ec A09;
    public final String A0A;
    public final WeakReference<InterstitialAd> A0B;

    public C00903j(C0362Ec c0362Ec, @Nullable InterstitialAd interstitialAd, String str) {
        this.A09 = c0362Ec;
        this.A0A = str;
        this.A01 = interstitialAd;
        this.A0B = new WeakReference<>(interstitialAd);
    }

    public final long A00() {
        return this.A00;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.InterstitialAd A01() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.InterstitialAd r0 = r2.A01
            if (r0 == 0) goto L1d
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L1f;
                case 4: goto L11;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.3j r2 = (com.facebook.ads.redexgen.X.C00903j) r2
            com.facebook.ads.InterstitialAd r1 = r2.A01
            r0 = 3
            goto L7
        L11:
            com.facebook.ads.redexgen.X.3j r2 = (com.facebook.ads.redexgen.X.C00903j) r2
            java.lang.ref.WeakReference<com.facebook.ads.InterstitialAd> r0 = r2.A0B
            java.lang.Object r1 = r0.get()
            com.facebook.ads.InterstitialAd r1 = (com.facebook.ads.InterstitialAd) r1
            r0 = 3
            goto L7
        L1d:
            r0 = 4
            goto L7
        L1f:
            com.facebook.ads.InterstitialAd r1 = (com.facebook.ads.InterstitialAd) r1
            com.facebook.ads.InterstitialAd r1 = (com.facebook.ads.InterstitialAd) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00903j.A01():com.facebook.ads.InterstitialAd");
    }

    @Nullable
    public final InterstitialAdListener A02() {
        return this.A02;
    }

    @Nullable
    public final RewardData A03() {
        return this.A03;
    }

    @Nullable
    public final RewardedAdListener A04() {
        return this.A04;
    }

    public final C0362Ec A05() {
        return this.A09;
    }

    @Nullable
    public final String A06() {
        return this.A05;
    }

    @Nullable
    public final String A07() {
        return this.A06;
    }

    @Nullable
    public final String A08() {
        return this.A07;
    }

    public final String A09() {
        return this.A0A;
    }

    @Nullable
    public final EnumSet<CacheFlag> A0A() {
        return this.A08;
    }

    public final void A0B(long j) {
        this.A00 = j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0020, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0C(@android.support.annotation.Nullable com.facebook.ads.InterstitialAd r3) {
        /*
            r2 = this;
            r1 = r2
            if (r3 != 0) goto L1e
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L20;
                case 4: goto L16;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            com.facebook.ads.redexgen.X.3j r1 = (com.facebook.ads.redexgen.X.C00903j) r1
            com.facebook.ads.redexgen.X.Ec r0 = r1.A09
            boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A0Y(r0)
            if (r0 != 0) goto L14
            r0 = 3
            goto L4
        L14:
            r0 = 4
            goto L4
        L16:
            com.facebook.ads.redexgen.X.3j r1 = (com.facebook.ads.redexgen.X.C00903j) r1
            com.facebook.ads.InterstitialAd r3 = (com.facebook.ads.InterstitialAd) r3
            r1.A01 = r3
            r0 = 3
            goto L4
        L1e:
            r0 = 4
            goto L4
        L20:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00903j.A0C(com.facebook.ads.InterstitialAd):void");
    }

    public final void A0D(@Nullable InterstitialAdListener interstitialAdListener) {
        this.A02 = interstitialAdListener;
    }

    public final void A0E(RewardData rewardData) {
        this.A03 = rewardData;
    }

    public final void A0F(@Nullable RewardedAdListener rewardedAdListener) {
        this.A04 = rewardedAdListener;
    }

    public final void A0G(@Nullable String str) {
        this.A05 = str;
    }

    public final void A0H(@Nullable String str) {
        this.A06 = str;
    }

    public final void A0I(@Nullable String str) {
        this.A07 = str;
    }

    public final void A0J(@Nullable EnumSet<CacheFlag> flags) {
        this.A08 = flags;
    }
}
