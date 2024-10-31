package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;

/* loaded from: classes.dex */
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {

    /* renamed from: a, reason: collision with root package name */
    CustomEventBanner f671a;
    CustomEventInterstitial b;
    CustomEventNative c;
    private View d;

    /* loaded from: classes.dex */
    static final class a implements CustomEventBannerListener {

        /* renamed from: a, reason: collision with root package name */
        private final CustomEventAdapter f672a;
        private final MediationBannerListener b;

        public a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f672a = customEventAdapter;
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

    /* loaded from: classes.dex */
    static class c implements CustomEventNativeListener {

        /* renamed from: a, reason: collision with root package name */
        private final CustomEventAdapter f674a;
        private final MediationNativeListener b;

        public c(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
            this.f674a = customEventAdapter;
            this.b = mediationNativeListener;
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

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void a() {
        if (this.f671a != null) {
            this.f671a.a();
        }
        if (this.b != null) {
            this.b.a();
        }
        if (this.c != null) {
            this.c.a();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public void a(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f671a = (CustomEventBanner) a(bundle.getString("class_name"));
        if (this.f671a == null) {
            mediationBannerListener.onAdFailedToLoad(this, 0);
        } else {
            this.f671a.a(context, new a(this, mediationBannerListener), bundle.getString("parameter"), adSize, mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void a(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.b = (CustomEventInterstitial) a(bundle.getString("class_name"));
        if (this.b == null) {
            mediationInterstitialListener.onAdFailedToLoad(this, 0);
        } else {
            this.b.a(context, a(mediationInterstitialListener), bundle.getString("parameter"), mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void a(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        this.c = (CustomEventNative) a(bundle.getString("class_name"));
        if (this.c == null) {
            mediationNativeListener.onAdFailedToLoad(this, 0);
        } else {
            this.c.a(context, new c(this, mediationNativeListener), bundle.getString("parameter"), nativeMediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void b() {
        if (this.f671a != null) {
            this.f671a.b();
        }
        if (this.b != null) {
            this.b.b();
        }
        if (this.c != null) {
            this.c.b();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void c() {
        if (this.f671a != null) {
            this.f671a.c();
        }
        if (this.b != null) {
            this.b.c();
        }
        if (this.c != null) {
            this.c.c();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public View d() {
        return this.d;
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void e() {
        this.b.d();
    }
}
