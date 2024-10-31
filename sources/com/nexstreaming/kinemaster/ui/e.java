package com.nexstreaming.kinemaster.ui;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashActivity.kt */
/* loaded from: classes.dex */
public final class e implements DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SplashActivity f21561a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SplashActivity splashActivity) {
        this.f21561a = splashActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f21561a.M = null;
    }
}
