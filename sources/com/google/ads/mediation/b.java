package com.google.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;

/* loaded from: classes.dex */
final class b extends AdMetadataListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AbstractAdViewAdapter f9912a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.f9912a = abstractAdViewAdapter;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void a() {
        InterstitialAd interstitialAd;
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        InterstitialAd interstitialAd2;
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener2;
        interstitialAd = this.f9912a.zzhw;
        if (interstitialAd != null) {
            mediationRewardedVideoAdListener = this.f9912a.zzhx;
            if (mediationRewardedVideoAdListener != null) {
                interstitialAd2 = this.f9912a.zzhw;
                Bundle a2 = interstitialAd2.a();
                mediationRewardedVideoAdListener2 = this.f9912a.zzhx;
                mediationRewardedVideoAdListener2.zzc(a2);
            }
        }
    }
}
