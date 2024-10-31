package com.nexstreaming.kinemaster.ui;

import android.content.Intent;

/* compiled from: TencentSplashAdActivity.kt */
/* loaded from: classes.dex */
final class p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ q f21720a;

    public p(q qVar) {
        this.f21720a = qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TencentSplashAdActivity tencentSplashAdActivity = this.f21720a.f23014a;
        tencentSplashAdActivity.startActivity(new Intent(tencentSplashAdActivity, (Class<?>) SplashActivity.class));
        this.f21720a.f23014a.finish();
    }
}
