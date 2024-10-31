package com.nexstreaming.kinemaster.ad.providers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import c.d.b.b.i;
import c.d.b.c.a;
import c.d.b.m.e;
import com.google.ads.consent.ConsentInformation;
import com.google.ads.consent.ConsentStatus;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.nexstreaming.app.general.iab.Presenter.IABBasePresent;
import com.nexstreaming.kinemaster.ad.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class AdmobAdProvider<Ad> extends AdListener implements g {
    private static final String APP_ID = "ca-app-pub-6554794109779706~1563563274";
    public static final String EAS_AD_INTERSTITIAL_ID = "ca-app-pub-6554794109779706/8626754583";
    public static final String EAS_AD_UNIT_ID = "ca-app-pub-6554794109779706/7807708960";
    public static final String PL_AD_UNIT_ID = "ca-app-pub-6554794109779706/8880638559";
    public static final String STORE_AD_UNIT_ID = "ca-app-pub-6554794109779706/8929218945";
    private static final String TAG = "AdmobAdProvider";
    private static final String TEST_NA_UNIT_ID = "ca-app-pub-6554794109779706/1829866932";
    public static final String TIMELINE_AD_UNIT_ID = "ca-app-pub-6554794109779706/6897864314";
    private static final long VALID_TIME = 3600000;
    private Ad ad;
    private final Context context;
    private boolean isEnabled;
    private boolean isLoaded;
    private boolean isLoading;
    private List<g.a> listeners;
    private long loadedTime;
    private boolean requestAd;
    protected final String unitID;

    public AdmobAdProvider(Context context, String str) {
        this.context = context.getApplicationContext();
        MobileAds.a(this.context, APP_ID);
        if (e.f3850a.a()) {
            this.isEnabled = true;
        } else if (a.d(context)) {
            this.isEnabled = i.d().i();
            i.d().a(new OnCompleteListener() { // from class: com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider.1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public void onComplete(Task task) {
                    if (i.d().i() != AdmobAdProvider.this.isEnabled) {
                        AdmobAdProvider admobAdProvider = AdmobAdProvider.this;
                        if (admobAdProvider instanceof AdmobNativeAdvancedCustomAdProvider) {
                            admobAdProvider.requestCustomInstallAd();
                        } else {
                            admobAdProvider.requestTriggerAd();
                        }
                        AdmobAdProvider.this.isEnabled = true;
                    }
                }
            });
        } else {
            this.isEnabled = true;
        }
        this.unitID = str;
    }

    @Override // com.nexstreaming.kinemaster.ad.g
    public synchronized void addListener(g.a aVar) {
        if (this.listeners == null) {
            this.listeners = new ArrayList();
        }
        if (!this.listeners.contains(aVar)) {
            this.listeners.add(aVar);
        }
    }

    @Override // com.nexstreaming.kinemaster.ad.g
    public void clearAd() {
        this.isLoaded = false;
        this.isLoading = false;
        this.loadedTime = 0L;
    }

    public Ad getAd() {
        return this.ad;
    }

    public final Context getContext() {
        return this.context;
    }

    @SuppressLint({"HardwareIds"})
    protected String getDeviceId() {
        String string = Settings.Secure.getString(this.context.getContentResolver(), "android_id");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return IABBasePresent.e(string).toUpperCase();
    }

    @Override // com.nexstreaming.kinemaster.ad.g
    public String getId() {
        return AdmobAdProvider.class.getName();
    }

    @Override // com.nexstreaming.kinemaster.ad.g
    public String getUnitId() {
        return this.unitID;
    }

    @Override // com.nexstreaming.kinemaster.ad.g
    public boolean isOpened() {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ad.g
    public boolean isReady() {
        return this.isEnabled && this.isLoaded && this.loadedTime + VALID_TIME > System.currentTimeMillis();
    }

    public final AdRequest newAdRequest() {
        AdRequest.Builder builder = new AdRequest.Builder();
        if (ConsentInformation.a(this.context).a() == ConsentStatus.NON_PERSONALIZED) {
            Bundle bundle = new Bundle();
            bundle.putString("npa", "1");
            builder.a(AdMobAdapter.class, bundle);
        }
        return builder.a();
    }

    protected synchronized void notifyLoaded() {
        if (this.listeners != null) {
            try {
                for (int size = this.listeners.size() - 1; size >= 0; size--) {
                    g.a aVar = this.listeners.get(size);
                    if (aVar != null) {
                        aVar.a(this);
                    }
                }
            } catch (Exception e2) {
                Log.e(TAG, e2.getMessage(), e2);
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.internal.ads.zzvt
    public void onAdClicked() {
        if (this.requestAd) {
            return;
        }
        clearAd();
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdClosed() {
        this.isLoading = false;
        this.isLoaded = false;
        if (this.requestAd) {
            this.ad = null;
            requestTriggerAd();
        }
        this.loadedTime = 0L;
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdFailedToLoad(int i) {
        this.isLoading = false;
        this.isLoading = false;
        this.ad = null;
        this.loadedTime = 0L;
        Log.d(TAG, "onAdFailedToLoad: " + i);
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdImpression() {
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdLoaded() {
        this.isLoaded = true;
        this.isLoading = false;
        this.loadedTime = System.currentTimeMillis();
        notifyLoaded();
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdOpened() {
    }

    protected Ad onCreateAd() {
        return null;
    }

    protected void onLoadAd() {
    }

    @Override // com.nexstreaming.kinemaster.ad.g
    public synchronized void removeListener(g.a aVar) {
        if (this.listeners != null) {
            this.listeners.remove(aVar);
        }
    }

    public void requestCustomAd() {
        this.requestAd = false;
        if (this.isLoading || this.isLoaded) {
            return;
        }
        onLoadAd();
        this.isLoading = true;
    }

    @Override // com.nexstreaming.kinemaster.ad.g
    public void requestCustomInstallAd() {
        this.requestAd = false;
        if (this.isLoading || this.isLoaded) {
            return;
        }
        onLoadAd();
        this.isLoading = true;
    }

    @Override // com.nexstreaming.kinemaster.ad.g
    public void requestTriggerAd() {
        this.requestAd = true;
        if (this.isEnabled) {
            if (this.ad == null) {
                this.ad = onCreateAd();
            }
            if (this.ad == null || this.isLoading || this.isLoaded) {
                return;
            }
            onLoadAd();
            this.isLoading = true;
        }
    }

    @Override // com.nexstreaming.kinemaster.ad.g
    public void showAd(AppCompatActivity appCompatActivity) {
        showAd(appCompatActivity, -1, -1);
    }

    public void showAd(AppCompatActivity appCompatActivity, int i, int i2) {
    }

    @Override // com.nexstreaming.kinemaster.ad.g
    public void showDialogAd(AppCompatActivity appCompatActivity, int i, int i2) {
    }
}
