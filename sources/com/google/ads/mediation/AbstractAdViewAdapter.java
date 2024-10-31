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
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.internal.zzgr;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

@zzgr
/* loaded from: classes.dex */
public abstract class AbstractAdViewAdapter implements com.google.android.gms.ads.mediation.MediationBannerAdapter, com.google.android.gms.ads.mediation.MediationInterstitialAdapter, MediationNativeAdapter {

    /* renamed from: a */
    protected AdView f502a;
    protected InterstitialAd b;
    private AdLoader c;

    /* loaded from: classes.dex */
    static class a extends NativeAppInstallAdMapper {
        private final NativeAppInstallAd d;

        public a(NativeAppInstallAd nativeAppInstallAd) {
            this.d = nativeAppInstallAd;
            a(nativeAppInstallAd.getHeadline().toString());
            a(nativeAppInstallAd.getImages());
            b(nativeAppInstallAd.getBody().toString());
            a(nativeAppInstallAd.getIcon());
            c(nativeAppInstallAd.getCallToAction().toString());
            a(nativeAppInstallAd.getStarRating().doubleValue());
            d(nativeAppInstallAd.getStore().toString());
            e(nativeAppInstallAd.getPrice().toString());
            a(true);
            b(true);
        }

        @Override // com.google.android.gms.ads.mediation.NativeAdMapper
        public void a(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.d);
            }
        }
    }

    /* loaded from: classes.dex */
    static class b extends NativeContentAdMapper {
        private final NativeContentAd d;

        public b(NativeContentAd nativeContentAd) {
            this.d = nativeContentAd;
            a(nativeContentAd.getHeadline().toString());
            a(nativeContentAd.getImages());
            b(nativeContentAd.getBody().toString());
            a(nativeContentAd.getLogo());
            c(nativeContentAd.getCallToAction().toString());
            d(nativeContentAd.getAdvertiser().toString());
            a(true);
            b(true);
        }

        @Override // com.google.android.gms.ads.mediation.NativeAdMapper
        public void a(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.d);
            }
        }
    }

    /* loaded from: classes.dex */
    static final class c extends AdListener implements zza {

        /* renamed from: a */
        final AbstractAdViewAdapter f503a;
        final com.google.android.gms.ads.mediation.MediationBannerListener b;

        public c(AbstractAdViewAdapter abstractAdViewAdapter, com.google.android.gms.ads.mediation.MediationBannerListener mediationBannerListener) {
            this.f503a = abstractAdViewAdapter;
            this.b = mediationBannerListener;
        }

        @Override // com.google.android.gms.ads.AdListener
        public void a() {
            this.b.onAdLoaded(this.f503a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void a(int i) {
            this.b.onAdFailedToLoad(this.f503a, i);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void b() {
            this.b.onAdOpened(this.f503a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void c() {
            this.b.onAdClosed(this.f503a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void d() {
            this.b.onAdLeftApplication(this.f503a);
        }

        @Override // com.google.android.gms.ads.internal.client.zza
        public void onAdClicked() {
            this.b.onAdClicked(this.f503a);
        }
    }

    /* loaded from: classes.dex */
    static final class d extends AdListener implements zza {

        /* renamed from: a */
        final AbstractAdViewAdapter f504a;
        final com.google.android.gms.ads.mediation.MediationInterstitialListener b;

        public d(AbstractAdViewAdapter abstractAdViewAdapter, com.google.android.gms.ads.mediation.MediationInterstitialListener mediationInterstitialListener) {
            this.f504a = abstractAdViewAdapter;
            this.b = mediationInterstitialListener;
        }

        @Override // com.google.android.gms.ads.AdListener
        public void a() {
            this.b.onAdLoaded(this.f504a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void a(int i) {
            this.b.onAdFailedToLoad(this.f504a, i);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void b() {
            this.b.onAdOpened(this.f504a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void c() {
            this.b.onAdClosed(this.f504a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void d() {
            this.b.onAdLeftApplication(this.f504a);
        }

        @Override // com.google.android.gms.ads.internal.client.zza
        public void onAdClicked() {
            this.b.onAdClicked(this.f504a);
        }
    }

    /* loaded from: classes.dex */
    static final class e extends AdListener implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener, zza {

        /* renamed from: a */
        final AbstractAdViewAdapter f505a;
        final MediationNativeListener b;

        public e(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
            this.f505a = abstractAdViewAdapter;
            this.b = mediationNativeListener;
        }

        @Override // com.google.android.gms.ads.AdListener
        public void a() {
        }

        @Override // com.google.android.gms.ads.AdListener
        public void a(int i) {
            this.b.onAdFailedToLoad(this.f505a, i);
        }

        @Override // com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener
        public void a(NativeAppInstallAd nativeAppInstallAd) {
            this.b.onAdLoaded(this.f505a, new a(nativeAppInstallAd));
        }

        @Override // com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener
        public void a(NativeContentAd nativeContentAd) {
            this.b.onAdLoaded(this.f505a, new b(nativeContentAd));
        }

        @Override // com.google.android.gms.ads.AdListener
        public void b() {
            this.b.onAdOpened(this.f505a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void c() {
            this.b.onAdClosed(this.f505a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void d() {
            this.b.onAdLeftApplication(this.f505a);
        }

        @Override // com.google.android.gms.ads.internal.client.zza
        public void onAdClicked() {
            this.b.onAdClicked(this.f505a);
        }
    }

    protected abstract Bundle a(Bundle bundle, Bundle bundle2);

    AdLoader.Builder a(Context context, String str) {
        return new AdLoader.Builder(context, str);
    }

    AdRequest a(Context context, com.google.android.gms.ads.mediation.MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
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
            builder.b(zzl.a().a(context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            builder.a(mediationAdRequest.taggedForChildDirectedTreatment() == 1);
        }
        builder.a(AdMobAdapter.class, a(bundle, bundle2));
        return builder.a();
    }

    public String a(Bundle bundle) {
        return bundle.getString("pubid");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void a() {
        if (this.f502a != null) {
            this.f502a.a();
            this.f502a = null;
        }
        if (this.b != null) {
            this.b = null;
        }
        if (this.c != null) {
            this.c = null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public void a(Context context, com.google.android.gms.ads.mediation.MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, com.google.android.gms.ads.mediation.MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f502a = new AdView(context);
        this.f502a.setAdSize(new AdSize(adSize.b(), adSize.a()));
        this.f502a.setAdUnitId(a(bundle));
        this.f502a.setAdListener(new c(this, mediationBannerListener));
        this.f502a.a(a(context, mediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void a(Context context, com.google.android.gms.ads.mediation.MediationInterstitialListener mediationInterstitialListener, Bundle bundle, com.google.android.gms.ads.mediation.MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.b = new InterstitialAd(context);
        this.b.a(a(bundle));
        this.b.a(new d(this, mediationInterstitialListener));
        this.b.a(a(context, mediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void a(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        e eVar = new e(this, mediationNativeListener);
        AdLoader.Builder a2 = a(context, bundle.getString("pubid")).a((AdListener) eVar);
        NativeAdOptions nativeAdOptions = nativeMediationAdRequest.getNativeAdOptions();
        if (nativeAdOptions != null) {
            a2.a(nativeAdOptions);
        }
        if (nativeMediationAdRequest.isAppInstallAdRequested()) {
            a2.a((NativeAppInstallAd.OnAppInstallAdLoadedListener) eVar);
        }
        if (nativeMediationAdRequest.isContentAdRequested()) {
            a2.a((NativeContentAd.OnContentAdLoadedListener) eVar);
        }
        this.c = a2.a();
        this.c.a(a(context, nativeMediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void b() {
        if (this.f502a != null) {
            this.f502a.b();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void c() {
        if (this.f502a != null) {
            this.f502a.c();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public View d() {
        return this.f502a;
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void e() {
        this.b.a();
    }
}
