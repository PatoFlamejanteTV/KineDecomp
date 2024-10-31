package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;

/* loaded from: classes.dex */
public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {

    /* renamed from: a, reason: collision with root package name */
    CustomEventBanner f507a;
    CustomEventInterstitial b;
    private View c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a implements CustomEventBannerListener {

        /* renamed from: a, reason: collision with root package name */
        private final CustomEventAdapter f508a;
        private final MediationBannerListener b;

        public a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f508a = customEventAdapter;
            this.b = mediationBannerListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements CustomEventInterstitialListener {
        private final CustomEventAdapter b;
        private final MediationInterstitialListener c;

        public b(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.b = customEventAdapter;
            this.c = mediationInterstitialListener;
        }
    }

    private static <T> T a(String str) {
        try {
            return (T) Class.forName(str).newInstance();
        } catch (Throwable th) {
            zzb.e("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    b a(MediationInterstitialListener mediationInterstitialListener) {
        return new b(this, mediationInterstitialListener);
    }

    @Override // com.google.ads.mediation.MediationAdapter
    public void a() {
        if (this.f507a != null) {
            this.f507a.a();
        }
        if (this.b != null) {
            this.b.a();
        }
    }

    @Override // com.google.ads.mediation.MediationBannerAdapter
    public void a(MediationBannerListener mediationBannerListener, Activity activity, CustomEventServerParameters customEventServerParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f507a = (CustomEventBanner) a(customEventServerParameters.b);
        if (this.f507a == null) {
            mediationBannerListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        } else {
            this.f507a.a(new a(this, mediationBannerListener), activity, customEventServerParameters.f510a, customEventServerParameters.c, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.a(customEventServerParameters.f510a));
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialAdapter
    public void a(MediationInterstitialListener mediationInterstitialListener, Activity activity, CustomEventServerParameters customEventServerParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.b = (CustomEventInterstitial) a(customEventServerParameters.b);
        if (this.b == null) {
            mediationInterstitialListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        } else {
            this.b.a(a(mediationInterstitialListener), activity, customEventServerParameters.f510a, customEventServerParameters.c, mediationAdRequest, customEventExtras == null ? null : customEventExtras.a(customEventServerParameters.f510a));
        }
    }

    @Override // com.google.ads.mediation.MediationAdapter
    public Class<CustomEventExtras> b() {
        return CustomEventExtras.class;
    }

    @Override // com.google.ads.mediation.MediationAdapter
    public Class<CustomEventServerParameters> c() {
        return CustomEventServerParameters.class;
    }

    @Override // com.google.ads.mediation.MediationBannerAdapter
    public View d() {
        return this.c;
    }

    @Override // com.google.ads.mediation.MediationInterstitialAdapter
    public void e() {
        this.b.b();
    }
}
