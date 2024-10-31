package com.nexstreaming.kinemaster.ad.providers.tencent;

import android.view.ViewGroup;

/* compiled from: TencentAdListener.kt */
/* loaded from: classes.dex */
public interface TencentAdListener {

    /* compiled from: TencentAdListener.kt */
    /* loaded from: classes.dex */
    public interface NativeExpressAdListener {
        void onNativeClosed(ViewGroup viewGroup);

        void onNativeLoaded(ViewGroup viewGroup);
    }

    /* compiled from: TencentAdListener.kt */
    /* loaded from: classes.dex */
    public interface SplashAdListener {
        void onSplashADClicked();

        void onSplashADTick(long j);

        void onSplashDismissed();

        void onSplashNoAd(long j);

        void onSplashPresented();
    }
}
