package com.nexstreaming.kinemaster.ad.providers.tencent;

import android.content.Context;
import com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdListener;
import com.umeng.analytics.pro.b;
import kotlin.jvm.internal.h;

/* compiled from: TencentAdManager.kt */
/* loaded from: classes.dex */
public final class TencentAdManager {
    private final TencentAdListener.NativeExpressAdListener adListener;
    private final Context context;
    private TencentNativeExpressAdProvider tencentNativeExpressAdProvider;
    private final String unitId;

    public TencentAdManager(Context context, TencentAdListener.NativeExpressAdListener nativeExpressAdListener, String str) {
        h.b(context, b.Q);
        h.b(nativeExpressAdListener, "adListener");
        h.b(str, "unitId");
        this.context = context;
        this.adListener = nativeExpressAdListener;
        this.unitId = str;
        this.tencentNativeExpressAdProvider = new TencentNativeExpressAdProvider(this.context, this.adListener, this.unitId);
    }

    public final TencentAdListener.NativeExpressAdListener getAdListener() {
        return this.adListener;
    }

    public final Context getContext() {
        return this.context;
    }

    public final TencentNativeExpressAdProvider getTencentNativeExpressAdProvider() {
        return this.tencentNativeExpressAdProvider;
    }

    public final String getUnitId() {
        return this.unitId;
    }

    public final void requestNativeExpressAd() {
        TencentNativeExpressAdProvider tencentNativeExpressAdProvider = this.tencentNativeExpressAdProvider;
        if (tencentNativeExpressAdProvider != null) {
            tencentNativeExpressAdProvider.onLoadAd();
        }
    }

    public final void requestSplashAd() {
    }

    public final void setContainer() {
        TencentNativeExpressAdProvider tencentNativeExpressAdProvider = this.tencentNativeExpressAdProvider;
        if (tencentNativeExpressAdProvider != null) {
            tencentNativeExpressAdProvider.setContainer();
        }
    }

    public final void setTencentNativeExpressAdProvider(TencentNativeExpressAdProvider tencentNativeExpressAdProvider) {
        this.tencentNativeExpressAdProvider = tencentNativeExpressAdProvider;
    }

    public final void setContainer(int i) {
        TencentNativeExpressAdProvider tencentNativeExpressAdProvider = this.tencentNativeExpressAdProvider;
        if (tencentNativeExpressAdProvider != null) {
            tencentNativeExpressAdProvider.setContainer(i);
        }
    }
}
