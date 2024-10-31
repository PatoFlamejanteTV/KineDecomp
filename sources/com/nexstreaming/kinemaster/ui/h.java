package com.nexstreaming.kinemaster.ui;

import android.widget.ProgressBar;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashActivity.kt */
/* loaded from: classes.dex */
public final class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SplashActivity f21613a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SplashActivity splashActivity) {
        this.f21613a = splashActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ProgressBar progressBar = (ProgressBar) this.f21613a.c(com.nexstreaming.app.kinemasterfree.b.pb_loading);
        kotlin.jvm.internal.h.a((Object) progressBar, "pb_loading");
        progressBar.setVisibility(0);
    }
}
