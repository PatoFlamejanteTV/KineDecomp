package com.nexstreaming.kinemaster.ui;

import android.app.Activity;
import android.content.DialogInterface;
import com.umeng.analytics.pro.k;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashActivity.kt */
/* loaded from: classes.dex */
public final class c implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SplashActivity f21517a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String[] f21518b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SplashActivity splashActivity, String[] strArr) {
        this.f21517a = splashActivity;
        this.f21518b = strArr;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Activity u;
        dialogInterface.dismiss();
        u = this.f21517a.u();
        com.nexstreaming.kinemaster.ui.e.b.a(u, this.f21518b, k.a.v);
    }
}
