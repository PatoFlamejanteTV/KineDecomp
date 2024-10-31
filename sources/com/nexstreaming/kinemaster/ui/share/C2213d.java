package com.nexstreaming.kinemaster.ui.share;

import android.app.Activity;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ad.AdManager;
import com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider;
import com.nexstreaming.kinemaster.ad.providers.AdmobNativeUnifiedAdProvider;
import com.nextreaming.nexeditorui.EditorGlobal;

/* compiled from: ExportAndShareActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.share.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C2213d implements com.nexstreaming.kinemaster.ad.m {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ExportAndShareActivity f23332a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2213d(ExportAndShareActivity exportAndShareActivity) {
        this.f23332a = exportAndShareActivity;
    }

    @Override // com.nexstreaming.kinemaster.ad.m
    public void a(InterstitialAd interstitialAd, String str) {
        this.f23332a.ka = true;
    }

    @Override // com.nexstreaming.kinemaster.ad.m
    public void a(UnifiedNativeAd unifiedNativeAd, String str) {
        Activity u;
        C2220ga c2220ga;
        if (EditorGlobal.p) {
            Crashlytics.log("[ES] onInstallAdLoaded Invoked");
        }
        if (unifiedNativeAd == null) {
            if (EditorGlobal.p) {
                Crashlytics.log("[ES] onInstallAdLoaded: nativeAppInstallAd is null");
            }
        } else {
            if (this.f23332a.C() || !str.equals(AdmobAdProvider.EAS_AD_UNIT_ID)) {
                u = this.f23332a.u();
                com.nexstreaming.kinemaster.ad.g a2 = AdManager.a(u).a(AdmobAdProvider.EAS_AD_UNIT_ID);
                if (a2 != null) {
                    a2.clearAd();
                    return;
                }
                return;
            }
            UnifiedNativeAdView createUnifiedAdView = AdmobNativeUnifiedAdProvider.createUnifiedAdView(this.f23332a, unifiedNativeAd, R.layout.layout_admob_in_exportlist);
            c2220ga = this.f23332a.W;
            c2220ga.a(createUnifiedAdView);
        }
    }
}
