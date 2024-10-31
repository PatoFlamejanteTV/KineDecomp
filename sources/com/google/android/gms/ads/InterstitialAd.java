package com.google.android.gms.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzvt;
import com.google.android.gms.internal.ads.zzzb;

/* loaded from: classes.dex */
public final class InterstitialAd {

    /* renamed from: a */
    private final zzzb f9941a;

    public InterstitialAd(Context context) {
        this.f9941a = new zzzb(context);
        Preconditions.a(context, "Context cannot be null");
    }

    public final void a(AdRequest adRequest) {
        this.f9941a.zza(adRequest.a());
    }

    public final boolean b() {
        return this.f9941a.isLoaded();
    }

    public final void c() {
        this.f9941a.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(AdListener adListener) {
        this.f9941a.setAdListener(adListener);
        if (adListener != 0 && (adListener instanceof zzvt)) {
            this.f9941a.zza((zzvt) adListener);
        } else if (adListener == 0) {
            this.f9941a.zza((zzvt) null);
        }
    }

    public final void b(boolean z) {
        this.f9941a.zza(true);
    }

    public final void a(String str) {
        this.f9941a.setAdUnitId(str);
    }

    public final void a(RewardedVideoAdListener rewardedVideoAdListener) {
        this.f9941a.setRewardedVideoAdListener(rewardedVideoAdListener);
    }

    public final void a(AdMetadataListener adMetadataListener) {
        this.f9941a.setAdMetadataListener(adMetadataListener);
    }

    public final Bundle a() {
        return this.f9941a.getAdMetadata();
    }

    public final void a(boolean z) {
        this.f9941a.setImmersiveMode(z);
    }
}
