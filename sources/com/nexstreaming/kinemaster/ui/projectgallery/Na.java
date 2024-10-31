package com.nexstreaming.kinemaster.ui.projectgallery;

import android.view.ViewGroup;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ad.AdManager;
import com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider;
import com.nexstreaming.kinemaster.ad.providers.AdmobNativeUnifiedAdProvider;
import com.nextreaming.nexeditorui.EditorGlobal;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
class Na implements com.nexstreaming.kinemaster.ad.m {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22865a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Na(ProjectGalleryActivity projectGalleryActivity) {
        this.f22865a = projectGalleryActivity;
    }

    @Override // com.nexstreaming.kinemaster.ad.m
    public void a(InterstitialAd interstitialAd, String str) {
    }

    @Override // com.nexstreaming.kinemaster.ad.m
    public void a(UnifiedNativeAd unifiedNativeAd, String str) {
        Eb eb;
        Eb eb2;
        if (EditorGlobal.p) {
            Crashlytics.log("[PG] onInstallAdLoaded Invoked");
        }
        if (unifiedNativeAd == null) {
            if (EditorGlobal.p) {
                Crashlytics.log("[PG] onUnifiedAdLoaded: Ad is null");
                return;
            }
            return;
        }
        if (!this.f22865a.C() && str.equals(AdmobAdProvider.PL_AD_UNIT_ID)) {
            UnifiedNativeAdView createUnifiedAdView = AdmobNativeUnifiedAdProvider.createUnifiedAdView(this.f22865a, unifiedNativeAd, R.layout.layout_admob_in_projectlist);
            if (createUnifiedAdView != null) {
                createUnifiedAdView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            eb = this.f22865a.ua;
            if (eb != null) {
                eb2 = this.f22865a.ua;
                eb2.a(createUnifiedAdView);
                return;
            }
            return;
        }
        com.nexstreaming.kinemaster.ad.g a2 = AdManager.a(this.f22865a).a(AdmobAdProvider.PL_AD_UNIT_ID);
        if (a2 != null) {
            a2.clearAd();
        }
    }
}
