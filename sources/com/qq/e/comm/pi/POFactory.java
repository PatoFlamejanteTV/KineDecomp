package com.qq.e.comm.pi;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.view.ViewGroup;
import com.qq.e.ads.banner.ADSize;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.hybrid.HybridADListener;
import com.qq.e.ads.hybrid.HybridADSetting;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.comm.adevent.ADListener;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface POFactory {
    void config(int i, String str);

    SVSD getAPKDownloadServiceDelegate(Service service);

    ACTD getActivityDelegate(String str, Activity activity);

    BVI getBannerView(Activity activity, ADSize aDSize, String str, String str2);

    CAI getContentAdDelegate(Context context, String str, String str2, ADListener aDListener);

    HADI getHybridAD(HybridADSetting hybridADSetting, HybridADListener hybridADListener);

    IADI getIADView(Activity activity, String str, String str2);

    NADI getNativeADDelegate(Context context, String str, String str2, ADListener aDListener);

    NUADI getNativeAdManagerDelegate(Context context, String str, String str2, ADListener aDListener);

    NEADI getNativeExpressADDelegate(Context context, com.qq.e.ads.nativ.ADSize aDSize, String str, String str2, ADListener aDListener);

    NEADVI getNativeExpressADView(NEADI neadi, Context context, ViewGroup viewGroup, com.qq.e.ads.nativ.ADSize aDSize, String str, String str2, JSONObject jSONObject, HashMap<String, JSONObject> hashMap);

    NSPVI getNativeSplashAdView(Context context, String str, String str2);

    NVADI getNativeVideoADDelegate(Context context, String str, String str2, ADListener aDListener);

    RVADI getRewardVideoADDelegate(Context context, String str, String str2, ADListener aDListener);

    UBVI getUnifiedBannerViewDelegate(UnifiedBannerView unifiedBannerView, Activity activity, String str, String str2, UnifiedBannerADListener unifiedBannerADListener);

    UIADI getUnifiedInterstitialADDelegate(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener);
}
