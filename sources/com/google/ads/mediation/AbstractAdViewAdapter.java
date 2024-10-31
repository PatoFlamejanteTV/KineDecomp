package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAdViewHolder;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.zzb;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzbat;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbiy;
import com.google.android.gms.internal.ads.zzvt;
import com.google.android.gms.internal.ads.zzwu;
import com.google.android.gms.internal.ads.zzyp;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@zzark
/* loaded from: classes.dex */
public abstract class AbstractAdViewAdapter implements com.google.android.gms.ads.mediation.MediationBannerAdapter, MediationNativeAdapter, OnImmersiveModeUpdatedListener, zzb, MediationRewardedVideoAdAdapter, zzbiy {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    private AdView zzhs;
    private InterstitialAd zzht;
    private AdLoader zzhu;
    private Context zzhv;
    private InterstitialAd zzhw;
    private MediationRewardedVideoAdListener zzhx;

    @VisibleForTesting
    private final RewardedVideoAdListener zzhy = new com.google.ads.mediation.a(this);

    /* loaded from: classes.dex */
    static class a extends NativeAppInstallAdMapper {
        private final NativeAppInstallAd p;

        public a(NativeAppInstallAd nativeAppInstallAd) {
            this.p = nativeAppInstallAd;
            c(nativeAppInstallAd.getHeadline().toString());
            a(nativeAppInstallAd.getImages());
            a(nativeAppInstallAd.getBody().toString());
            a(nativeAppInstallAd.getIcon());
            b(nativeAppInstallAd.getCallToAction().toString());
            if (nativeAppInstallAd.getStarRating() != null) {
                a(nativeAppInstallAd.getStarRating().doubleValue());
            }
            if (nativeAppInstallAd.getStore() != null) {
                e(nativeAppInstallAd.getStore().toString());
            }
            if (nativeAppInstallAd.getPrice() != null) {
                d(nativeAppInstallAd.getPrice().toString());
            }
            b(true);
            a(true);
            a(nativeAppInstallAd.getVideoController());
        }

        @Override // com.google.android.gms.ads.mediation.NativeAdMapper
        public final void b(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.p);
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.f9971a.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.a(this.p);
            }
        }
    }

    /* loaded from: classes.dex */
    static class b extends NativeContentAdMapper {
        private final NativeContentAd n;

        public b(NativeContentAd nativeContentAd) {
            this.n = nativeContentAd;
            d(nativeContentAd.getHeadline().toString());
            a(nativeContentAd.getImages());
            b(nativeContentAd.getBody().toString());
            if (nativeContentAd.getLogo() != null) {
                a(nativeContentAd.getLogo());
            }
            c(nativeContentAd.getCallToAction().toString());
            a(nativeContentAd.getAdvertiser().toString());
            b(true);
            a(true);
            a(nativeContentAd.getVideoController());
        }

        @Override // com.google.android.gms.ads.mediation.NativeAdMapper
        public final void b(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.n);
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.f9971a.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.a(this.n);
            }
        }
    }

    /* loaded from: classes.dex */
    static class c extends UnifiedNativeAdMapper {
        private final UnifiedNativeAd r;

        public c(UnifiedNativeAd unifiedNativeAd) {
            this.r = unifiedNativeAd;
            d(unifiedNativeAd.getHeadline());
            a(unifiedNativeAd.getImages());
            b(unifiedNativeAd.getBody());
            a(unifiedNativeAd.getIcon());
            c(unifiedNativeAd.getCallToAction());
            a(unifiedNativeAd.getAdvertiser());
            a(unifiedNativeAd.getStarRating());
            f(unifiedNativeAd.getStore());
            e(unifiedNativeAd.getPrice());
            a(unifiedNativeAd.zzic());
            b(true);
            a(true);
            a(unifiedNativeAd.getVideoController());
        }

        @Override // com.google.android.gms.ads.mediation.UnifiedNativeAdMapper
        public final void a(View view, Map<String, View> map, Map<String, View> map2) {
            if (view instanceof UnifiedNativeAdView) {
                ((UnifiedNativeAdView) view).setNativeAd(this.r);
                return;
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.f9971a.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.a(this.r);
            }
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    static final class d extends AdListener implements AppEventListener, zzvt {

        /* renamed from: a, reason: collision with root package name */
        @VisibleForTesting
        private final AbstractAdViewAdapter f9900a;

        /* renamed from: b, reason: collision with root package name */
        @VisibleForTesting
        private final com.google.android.gms.ads.mediation.MediationBannerListener f9901b;

        public d(AbstractAdViewAdapter abstractAdViewAdapter, com.google.android.gms.ads.mediation.MediationBannerListener mediationBannerListener) {
            this.f9900a = abstractAdViewAdapter;
            this.f9901b = mediationBannerListener;
        }

        @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.internal.ads.zzvt
        public final void onAdClicked() {
            this.f9901b.onAdClicked(this.f9900a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdClosed() {
            this.f9901b.onAdClosed(this.f9900a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdFailedToLoad(int i) {
            this.f9901b.onAdFailedToLoad(this.f9900a, i);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLeftApplication() {
            this.f9901b.onAdLeftApplication(this.f9900a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLoaded() {
            this.f9901b.onAdLoaded(this.f9900a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdOpened() {
            this.f9901b.onAdOpened(this.f9900a);
        }

        @Override // com.google.android.gms.ads.doubleclick.AppEventListener
        public final void onAppEvent(String str, String str2) {
            this.f9901b.zza(this.f9900a, str, str2);
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    static final class e extends AdListener implements zzvt {

        /* renamed from: a, reason: collision with root package name */
        @VisibleForTesting
        private final AbstractAdViewAdapter f9902a;

        /* renamed from: b, reason: collision with root package name */
        @VisibleForTesting
        private final com.google.android.gms.ads.mediation.MediationInterstitialListener f9903b;

        public e(AbstractAdViewAdapter abstractAdViewAdapter, com.google.android.gms.ads.mediation.MediationInterstitialListener mediationInterstitialListener) {
            this.f9902a = abstractAdViewAdapter;
            this.f9903b = mediationInterstitialListener;
        }

        @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.internal.ads.zzvt
        public final void onAdClicked() {
            this.f9903b.onAdClicked(this.f9902a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdClosed() {
            this.f9903b.onAdClosed(this.f9902a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdFailedToLoad(int i) {
            this.f9903b.onAdFailedToLoad(this.f9902a, i);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLeftApplication() {
            this.f9903b.onAdLeftApplication(this.f9902a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLoaded() {
            this.f9903b.onAdLoaded(this.f9902a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdOpened() {
            this.f9903b.onAdOpened(this.f9902a);
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    static final class f extends AdListener implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener, UnifiedNativeAd.OnUnifiedNativeAdLoadedListener {

        /* renamed from: a, reason: collision with root package name */
        @VisibleForTesting
        private final AbstractAdViewAdapter f9904a;

        /* renamed from: b, reason: collision with root package name */
        @VisibleForTesting
        private final MediationNativeListener f9905b;

        public f(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
            this.f9904a = abstractAdViewAdapter;
            this.f9905b = mediationNativeListener;
        }

        @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener
        public final void a(NativeCustomTemplateAd nativeCustomTemplateAd) {
            this.f9905b.zza(this.f9904a, nativeCustomTemplateAd);
        }

        @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.internal.ads.zzvt
        public final void onAdClicked() {
            this.f9905b.onAdClicked(this.f9904a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdClosed() {
            this.f9905b.onAdClosed(this.f9904a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdFailedToLoad(int i) {
            this.f9905b.onAdFailedToLoad(this.f9904a, i);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdImpression() {
            this.f9905b.onAdImpression(this.f9904a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLeftApplication() {
            this.f9905b.onAdLeftApplication(this.f9904a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLoaded() {
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdOpened() {
            this.f9905b.onAdOpened(this.f9904a);
        }

        @Override // com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener
        public final void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
            this.f9905b.onAdLoaded(this.f9904a, new a(nativeAppInstallAd));
        }

        @Override // com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener
        public final void onContentAdLoaded(NativeContentAd nativeContentAd) {
            this.f9905b.onAdLoaded(this.f9904a, new b(nativeContentAd));
        }

        @Override // com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener
        public final void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
            this.f9905b.onAdLoaded(this.f9904a, new c(unifiedNativeAd));
        }

        @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener
        public final void a(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
            this.f9905b.zza(this.f9904a, nativeCustomTemplateAd, str);
        }
    }

    private final AdRequest zza(Context context, com.google.android.gms.ads.mediation.MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.a(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.a(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            Iterator<String> it = keywords.iterator();
            while (it.hasNext()) {
                builder.a(it.next());
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.a(location);
        }
        if (mediationAdRequest.isTesting()) {
            zzwu.zzpv();
            builder.b(zzbat.zzbf(context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            builder.b(mediationAdRequest.taggedForChildDirectedTreatment() == 1);
        }
        builder.a(mediationAdRequest.isDesignedForFamilies());
        builder.a(AdMobAdapter.class, zza(bundle, bundle2));
        return builder.a();
    }

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public View getBannerView() {
        return this.zzhs;
    }

    @Override // com.google.android.gms.internal.ads.zzbiy
    public Bundle getInterstitialAdapterInfo() {
        return new MediationAdapter.zza().a(1).a();
    }

    @Override // com.google.android.gms.ads.mediation.zzb
    public zzyp getVideoController() {
        VideoController videoController;
        AdView adView = this.zzhs;
        if (adView == null || (videoController = adView.getVideoController()) == null) {
            return null;
        }
        return videoController.b();
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public void initialize(Context context, com.google.android.gms.ads.mediation.MediationAdRequest mediationAdRequest, String str, MediationRewardedVideoAdListener mediationRewardedVideoAdListener, Bundle bundle, Bundle bundle2) {
        this.zzhv = context.getApplicationContext();
        this.zzhx = mediationRewardedVideoAdListener;
        this.zzhx.onInitializationSucceeded(this);
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public boolean isInitialized() {
        return this.zzhx != null;
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public void loadAd(com.google.android.gms.ads.mediation.MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        Context context = this.zzhv;
        if (context != null && this.zzhx != null) {
            this.zzhw = new InterstitialAd(context);
            this.zzhw.b(true);
            this.zzhw.a(getAdUnitId(bundle));
            this.zzhw.a(this.zzhy);
            this.zzhw.a(new com.google.ads.mediation.b(this));
            this.zzhw.a(zza(this.zzhv, mediationAdRequest, bundle2, bundle));
            return;
        }
        zzbbd.e("AdMobAdapter.loadAd called before initialize.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onDestroy() {
        AdView adView = this.zzhs;
        if (adView != null) {
            adView.a();
            this.zzhs = null;
        }
        if (this.zzht != null) {
            this.zzht = null;
        }
        if (this.zzhu != null) {
            this.zzhu = null;
        }
        if (this.zzhw != null) {
            this.zzhw = null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener
    public void onImmersiveModeUpdated(boolean z) {
        InterstitialAd interstitialAd = this.zzht;
        if (interstitialAd != null) {
            interstitialAd.a(z);
        }
        InterstitialAd interstitialAd2 = this.zzhw;
        if (interstitialAd2 != null) {
            interstitialAd2.a(z);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onPause() {
        AdView adView = this.zzhs;
        if (adView != null) {
            adView.b();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onResume() {
        AdView adView = this.zzhs;
        if (adView != null) {
            adView.c();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public void requestBannerAd(Context context, com.google.android.gms.ads.mediation.MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, com.google.android.gms.ads.mediation.MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzhs = new AdView(context);
        this.zzhs.setAdSize(new AdSize(adSize.b(), adSize.a()));
        this.zzhs.setAdUnitId(getAdUnitId(bundle));
        this.zzhs.setAdListener(new d(this, mediationBannerListener));
        this.zzhs.a(zza(context, mediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void requestInterstitialAd(Context context, com.google.android.gms.ads.mediation.MediationInterstitialListener mediationInterstitialListener, Bundle bundle, com.google.android.gms.ads.mediation.MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzht = new InterstitialAd(context);
        this.zzht.a(getAdUnitId(bundle));
        this.zzht.a(new e(this, mediationInterstitialListener));
        this.zzht.a(zza(context, mediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        f fVar = new f(this, mediationNativeListener);
        AdLoader.Builder a2 = new AdLoader.Builder(context, bundle.getString(AD_UNIT_ID_PARAMETER)).a((AdListener) fVar);
        NativeAdOptions nativeAdOptions = nativeMediationAdRequest.getNativeAdOptions();
        if (nativeAdOptions != null) {
            a2.a(nativeAdOptions);
        }
        if (nativeMediationAdRequest.isUnifiedNativeAdRequested()) {
            a2.a((UnifiedNativeAd.OnUnifiedNativeAdLoadedListener) fVar);
        }
        if (nativeMediationAdRequest.isAppInstallAdRequested()) {
            a2.a((NativeAppInstallAd.OnAppInstallAdLoadedListener) fVar);
        }
        if (nativeMediationAdRequest.isContentAdRequested()) {
            a2.a((NativeContentAd.OnContentAdLoadedListener) fVar);
        }
        if (nativeMediationAdRequest.zzvg()) {
            for (String str : nativeMediationAdRequest.zzvh().keySet()) {
                a2.a(str, fVar, nativeMediationAdRequest.zzvh().get(str).booleanValue() ? fVar : null);
            }
        }
        this.zzhu = a2.a();
        this.zzhu.a(zza(context, nativeMediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void showInterstitial() {
        this.zzht.c();
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public void showVideo() {
        this.zzhw.c();
    }

    protected abstract Bundle zza(Bundle bundle, Bundle bundle2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ InterstitialAd zza(AbstractAdViewAdapter abstractAdViewAdapter, InterstitialAd interstitialAd) {
        abstractAdViewAdapter.zzhw = null;
        return null;
    }
}
