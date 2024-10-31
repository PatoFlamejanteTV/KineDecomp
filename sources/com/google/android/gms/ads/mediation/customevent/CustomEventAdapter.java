package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbbd;

@KeepForSdkWithMembers
@KeepName
/* loaded from: classes.dex */
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {

    /* renamed from: a, reason: collision with root package name */
    private View f10294a;

    /* renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    private CustomEventBanner f10295b;

    /* renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    private CustomEventInterstitial f10296c;

    /* renamed from: d, reason: collision with root package name */
    @VisibleForTesting
    private CustomEventNative f10297d;

    @VisibleForTesting
    /* loaded from: classes.dex */
    static final class a implements CustomEventBannerListener {

        /* renamed from: a, reason: collision with root package name */
        private final CustomEventAdapter f10298a;

        /* renamed from: b, reason: collision with root package name */
        private final MediationBannerListener f10299b;

        public a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f10298a = customEventAdapter;
            this.f10299b = mediationBannerListener;
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    class b implements CustomEventInterstitialListener {

        /* renamed from: a, reason: collision with root package name */
        private final CustomEventAdapter f10300a;

        /* renamed from: b, reason: collision with root package name */
        private final MediationInterstitialListener f10301b;

        public b(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f10300a = customEventAdapter;
            this.f10301b = mediationInterstitialListener;
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    static class c implements CustomEventNativeListener {

        /* renamed from: a, reason: collision with root package name */
        private final CustomEventAdapter f10303a;

        /* renamed from: b, reason: collision with root package name */
        private final MediationNativeListener f10304b;

        public c(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
            this.f10303a = customEventAdapter;
            this.f10304b = mediationNativeListener;
        }
    }

    private static <T> T a(String str) {
        try {
            return (T) Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(message).length());
            sb.append("Could not instantiate custom event adapter: ");
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzbbd.zzeo(sb.toString());
            return null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public final View getBannerView() {
        return this.f10294a;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onDestroy() {
        CustomEventBanner customEventBanner = this.f10295b;
        if (customEventBanner != null) {
            customEventBanner.onDestroy();
        }
        CustomEventInterstitial customEventInterstitial = this.f10296c;
        if (customEventInterstitial != null) {
            customEventInterstitial.onDestroy();
        }
        CustomEventNative customEventNative = this.f10297d;
        if (customEventNative != null) {
            customEventNative.onDestroy();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onPause() {
        CustomEventBanner customEventBanner = this.f10295b;
        if (customEventBanner != null) {
            customEventBanner.onPause();
        }
        CustomEventInterstitial customEventInterstitial = this.f10296c;
        if (customEventInterstitial != null) {
            customEventInterstitial.onPause();
        }
        CustomEventNative customEventNative = this.f10297d;
        if (customEventNative != null) {
            customEventNative.onPause();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onResume() {
        CustomEventBanner customEventBanner = this.f10295b;
        if (customEventBanner != null) {
            customEventBanner.onResume();
        }
        CustomEventInterstitial customEventInterstitial = this.f10296c;
        if (customEventInterstitial != null) {
            customEventInterstitial.onResume();
        }
        CustomEventNative customEventNative = this.f10297d;
        if (customEventNative != null) {
            customEventNative.onResume();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public final void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f10295b = (CustomEventBanner) a(bundle.getString("class_name"));
        if (this.f10295b == null) {
            mediationBannerListener.onAdFailedToLoad(this, 0);
        } else {
            this.f10295b.requestBannerAd(context, new a(this, mediationBannerListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), adSize, mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f10296c = (CustomEventInterstitial) a(bundle.getString("class_name"));
        if (this.f10296c == null) {
            mediationInterstitialListener.onAdFailedToLoad(this, 0);
        } else {
            this.f10296c.requestInterstitialAd(context, new b(this, mediationInterstitialListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdapter
    public final void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        this.f10297d = (CustomEventNative) a(bundle.getString("class_name"));
        if (this.f10297d == null) {
            mediationNativeListener.onAdFailedToLoad(this, 0);
        } else {
            this.f10297d.requestNativeAd(context, new c(this, mediationNativeListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), nativeMediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        this.f10296c.showInterstitial();
    }
}
