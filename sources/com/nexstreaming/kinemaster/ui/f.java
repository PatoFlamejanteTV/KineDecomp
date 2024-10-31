package com.nexstreaming.kinemaster.ui;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashActivity.kt */
/* loaded from: classes.dex */
public final class f implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SplashActivity f21580a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SplashActivity splashActivity) {
        this.f21580a = splashActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f21580a.finish();
    }
}
