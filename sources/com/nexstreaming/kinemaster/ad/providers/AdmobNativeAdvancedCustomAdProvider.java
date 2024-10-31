package com.nexstreaming.kinemaster.ad.providers;

import android.content.Context;
import android.widget.FrameLayout;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.nexstreaming.kinemaster.ad.AdManager;

/* loaded from: classes.dex */
public class AdmobNativeAdvancedCustomAdProvider extends AdmobAdProvider<FrameLayout> {
    private static final String TAG = "AdmobNativeAdvancedCustomAdProvider";
    private static final String UNIT_ID = "ca-app-pub-6554794109779706/6897864314";
    private boolean isShowAds;

    public AdmobNativeAdvancedCustomAdProvider(Context context, String str) {
        super(context, str);
    }

    private void onLoadUnifiedAd() {
        AdLoader.Builder builder = new AdLoader.Builder(getContext(), this.unitID);
        builder.a(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() { // from class: com.nexstreaming.kinemaster.ad.providers.AdmobNativeAdvancedCustomAdProvider.1
            @Override // com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener
            public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                if (AdManager.a(AdmobNativeAdvancedCustomAdProvider.this.getContext()).a() != null) {
                    AdManager.a(AdmobNativeAdvancedCustomAdProvider.this.getContext()).a(unifiedNativeAd, AdmobNativeAdvancedCustomAdProvider.this.unitID);
                }
            }
        });
        builder.a(new NativeAdOptions.Builder().a(new VideoOptions.Builder().a(true).a()).a());
        builder.a(this).a().a(newAdRequest());
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider, com.nexstreaming.kinemaster.ad.g
    public String getId() {
        return AdmobNativeAdvancedCustomAdProvider.class.getSimpleName();
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider
    protected void onLoadAd() {
        onLoadUnifiedAd();
    }
}
