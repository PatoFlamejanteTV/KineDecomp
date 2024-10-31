package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import b.b.c.j;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.PlatformVersion;

@zzark
/* loaded from: classes2.dex */
public final class zzanu implements MediationInterstitialAdapter {
    private Uri mUri;
    private Activity zzdow;
    private MediationInterstitialListener zzdox;

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onDestroy() {
        zzbbd.zzdn("Destroying AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onPause() {
        zzbbd.zzdn("Pausing AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onResume() {
        zzbbd.zzdn("Resuming AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzdox = mediationInterstitialListener;
        if (this.zzdox == null) {
            zzbbd.zzeo("Listener not set for mediation. Returning.");
            return;
        }
        if (!(context instanceof Activity)) {
            zzbbd.zzeo("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.zzdox.onAdFailedToLoad(this, 0);
            return;
        }
        if (!(PlatformVersion.b() && zzabk.zzj(context))) {
            zzbbd.zzeo("Default browser does not support custom tabs. Bailing out.");
            this.zzdox.onAdFailedToLoad(this, 0);
            return;
        }
        String string = bundle.getString("tab_url");
        if (TextUtils.isEmpty(string)) {
            zzbbd.zzeo("The tab_url retrieved from mediation metadata is empty. Bailing out.");
            this.zzdox.onAdFailedToLoad(this, 0);
        } else {
            this.zzdow = (Activity) context;
            this.mUri = Uri.parse(string);
            this.zzdox.onAdLoaded(this);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        b.b.c.j a2 = new j.a().a();
        a2.f3280a.setData(this.mUri);
        zzayh.zzelc.post(new Hb(this, new AdOverlayInfoParcel(new com.google.android.gms.ads.internal.overlay.zzc(a2.f3280a), null, new Gb(this), null, new zzbbi(0, 0, false))));
        com.google.android.gms.ads.internal.zzbv.i().zzyl();
    }
}
