package com.nexstreaming.kinemaster.ui;

import android.os.Handler;

/* compiled from: TencentSplashAdActivity.kt */
/* loaded from: classes.dex */
public final class q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ TencentSplashAdActivity f23014a;

    /* renamed from: b */
    final /* synthetic */ long f23015b;

    public q(TencentSplashAdActivity tencentSplashAdActivity, long j) {
        this.f23014a = tencentSplashAdActivity;
        this.f23015b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        new Handler().postDelayed(new p(this), this.f23015b);
    }
}
