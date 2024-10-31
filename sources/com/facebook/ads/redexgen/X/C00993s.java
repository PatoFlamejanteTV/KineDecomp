package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;
import java.lang.ref.WeakReference;

/* renamed from: com.facebook.ads.redexgen.X.3s, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C00993s {
    public int A00 = -1;
    public long A01 = -1;

    @Nullable
    public RewardData A02;

    @Nullable
    public RewardedVideoAdListener A03;

    @Nullable
    public String A04;

    @Nullable
    public String A05;

    @Nullable
    public String A06;
    public boolean A07;

    @Nullable
    public RewardedVideoAd A08;
    public WeakReference<RewardedVideoAd> A09;
    public final C0362Ec A0A;
    public final String A0B;

    public C00993s(C0362Ec c0362Ec, String str, @Nullable RewardedVideoAd rewardedVideoAd) {
        this.A0A = c0362Ec;
        this.A0B = str;
        this.A08 = rewardedVideoAd;
        this.A09 = new WeakReference<>(rewardedVideoAd);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.RewardedVideoAd A00() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.RewardedVideoAd r0 = r2.A08
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
            com.facebook.ads.redexgen.X.3s r2 = (com.facebook.ads.redexgen.X.C00993s) r2
            com.facebook.ads.RewardedVideoAd r1 = r2.A08
            r0 = 3
            goto L7
        L11:
            com.facebook.ads.redexgen.X.3s r2 = (com.facebook.ads.redexgen.X.C00993s) r2
            java.lang.ref.WeakReference<com.facebook.ads.RewardedVideoAd> r0 = r2.A09
            java.lang.Object r1 = r0.get()
            com.facebook.ads.RewardedVideoAd r1 = (com.facebook.ads.RewardedVideoAd) r1
            r0 = 3
            goto L7
        L1d:
            r0 = 4
            goto L7
        L1f:
            com.facebook.ads.RewardedVideoAd r1 = (com.facebook.ads.RewardedVideoAd) r1
            com.facebook.ads.RewardedVideoAd r1 = (com.facebook.ads.RewardedVideoAd) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00993s.A00():com.facebook.ads.RewardedVideoAd");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0020, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A01(@android.support.annotation.Nullable com.facebook.ads.RewardedVideoAd r3) {
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
            com.facebook.ads.redexgen.X.3s r1 = (com.facebook.ads.redexgen.X.C00993s) r1
            com.facebook.ads.redexgen.X.Ec r0 = r1.A0A
            boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A0Y(r0)
            if (r0 != 0) goto L14
            r0 = 3
            goto L4
        L14:
            r0 = 4
            goto L4
        L16:
            com.facebook.ads.redexgen.X.3s r1 = (com.facebook.ads.redexgen.X.C00993s) r1
            com.facebook.ads.RewardedVideoAd r3 = (com.facebook.ads.RewardedVideoAd) r3
            r1.A08 = r3
            r0 = 3
            goto L4
        L1e:
            r0 = 4
            goto L4
        L20:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00993s.A01(com.facebook.ads.RewardedVideoAd):void");
    }
}
