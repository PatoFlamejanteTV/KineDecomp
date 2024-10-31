package com.nexstreaming.kinemaster.ui;

import android.content.DialogInterface;
import android.content.Intent;

/* compiled from: SplashActivity.kt */
/* loaded from: classes.dex */
final class j implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SplashActivity f21615a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(SplashActivity splashActivity) {
        this.f21615a = splashActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f21615a.a((Intent) null, 603979776);
    }
}
