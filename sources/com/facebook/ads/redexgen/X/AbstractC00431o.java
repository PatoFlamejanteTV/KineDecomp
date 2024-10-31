package com.facebook.ads.redexgen.X;

import com.facebook.ads.RewardData;
import com.facebook.ads.internal.protocol.AdPlacementType;

/* renamed from: com.facebook.ads.redexgen.X.1o, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC00431o implements C1F {
    public int A00;
    public RewardData A01;

    public abstract int A0A();

    public abstract boolean A0B();

    public final void A00(int i) {
        this.A00 = i;
    }

    public final void A01(RewardData rewardData) {
        this.A01 = rewardData;
    }

    @Override // com.facebook.ads.redexgen.X.C1F
    public final AdPlacementType A4p() {
        return AdPlacementType.REWARDED_VIDEO;
    }
}
