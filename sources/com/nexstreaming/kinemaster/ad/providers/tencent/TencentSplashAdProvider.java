package com.nexstreaming.kinemaster.ad.providers.tencent;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdListener;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.util.AdError;
import com.umeng.analytics.pro.b;
import kotlin.jvm.internal.h;
import kotlin.text.w;

/* compiled from: TencentSplashAdProvider.kt */
/* loaded from: classes.dex */
public final class TencentSplashAdProvider extends TencentAdProvider implements SplashADListener {
    private final long MinSplashTimeNoAd;
    private TencentAdListener.SplashAdListener mAdListener;
    private Context mContext;
    private long mFetchSplashADTime;
    private SplashAD mSplashAD;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TencentSplashAdProvider(Context context) {
        super(context);
        h.b(context, b.Q);
        this.MinSplashTimeNoAd = 2000L;
    }

    public final void fetchSplashAD(Activity activity, ViewGroup viewGroup, View view, int i) {
        h.b(activity, "activity");
        h.b(viewGroup, "adContainer");
        h.b(view, "skipContainer");
        this.mFetchSplashADTime = System.currentTimeMillis();
        this.mSplashAD = new SplashAD(activity, viewGroup, view, TencentAdProvider.Companion.getAPPID(), TencentAdProvider.Companion.getSP_UNIT_ID(), this, i);
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdProvider, com.nexstreaming.kinemaster.ad.g
    public String getId() {
        String simpleName = TencentSplashAdProvider.class.getSimpleName();
        h.a((Object) simpleName, "TencentSplashAdProvider::class.java.simpleName");
        return simpleName;
    }

    public final long getMinSplashTimeNoAd() {
        return this.MinSplashTimeNoAd;
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdProvider, com.nexstreaming.kinemaster.ad.g
    public String getUnitId() {
        return TencentAdProvider.Companion.getSP_UNIT_ID();
    }

    public final boolean isInstalledOnXiaomiDevices() {
        boolean a2;
        Log.d("SYSEM", "Manufacturer = " + Build.MANUFACTURER);
        String str = Build.MANUFACTURER;
        h.a((Object) str, "Build.MANUFACTURER");
        a2 = w.a((CharSequence) str, (CharSequence) "Xiaomi", true);
        return a2;
    }

    public final boolean isSubscriptionOrPromotion() {
        return EditorGlobal.s();
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADClicked() {
        TencentAdListener.SplashAdListener splashAdListener = this.mAdListener;
        if (splashAdListener != null) {
            splashAdListener.onSplashADClicked();
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADDismissed() {
        TencentAdListener.SplashAdListener splashAdListener = this.mAdListener;
        if (splashAdListener != null) {
            splashAdListener.onSplashDismissed();
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADExposure() {
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADPresent() {
        TencentAdListener.SplashAdListener splashAdListener = this.mAdListener;
        if (splashAdListener != null) {
            splashAdListener.onSplashPresented();
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADTick(long j) {
        TencentAdListener.SplashAdListener splashAdListener = this.mAdListener;
        if (splashAdListener != null) {
            splashAdListener.onSplashADTick(j);
        }
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdProvider
    public void onLoadAd() {
        super.onLoadAd();
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onNoAD(AdError adError) {
        long currentTimeMillis = System.currentTimeMillis() - this.mFetchSplashADTime;
        long j = this.MinSplashTimeNoAd;
        long j2 = currentTimeMillis > j ? 0L : j - currentTimeMillis;
        TencentAdListener.SplashAdListener splashAdListener = this.mAdListener;
        if (splashAdListener != null) {
            splashAdListener.onSplashNoAd(j2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TencentSplashAdProvider(Context context, TencentAdListener.SplashAdListener splashAdListener) {
        this(context);
        h.b(context, b.Q);
        h.b(splashAdListener, "adListener");
        this.mAdListener = splashAdListener;
        this.mContext = context;
    }
}
