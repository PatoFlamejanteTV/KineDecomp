package com.nexstreaming.kinemaster.ad;

import android.support.v7.app.AppCompatActivity;

/* compiled from: IAdProvider.kt */
/* loaded from: classes.dex */
public interface g {

    /* compiled from: IAdProvider.kt */
    /* loaded from: classes.dex */
    public interface a {
        void a(g gVar);
    }

    void addListener(a aVar);

    void clearAd();

    String getId();

    String getUnitId();

    boolean isOpened();

    boolean isReady();

    void removeListener(a aVar);

    void requestCustomInstallAd();

    void requestTriggerAd();

    void showAd(AppCompatActivity appCompatActivity);

    void showDialogAd(AppCompatActivity appCompatActivity, int i, int i2);
}
