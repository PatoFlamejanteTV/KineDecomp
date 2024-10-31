package com.nexstreaming.kinemaster.ui;

import com.nexstreaming.kinemaster.ui.gdpr.ConfirmFragment;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashActivity.kt */
/* loaded from: classes.dex */
public final class l implements ConfirmFragment.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SplashActivity f21618a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ConfirmFragment f21619b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.gdpr.g f21620c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f21621d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f21622e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SplashActivity splashActivity, ConfirmFragment confirmFragment, com.nexstreaming.kinemaster.ui.gdpr.g gVar, boolean z, boolean z2) {
        this.f21618a = splashActivity;
        this.f21619b = confirmFragment;
        this.f21620c = gVar;
        this.f21621d = z;
        this.f21622e = z2;
    }

    @Override // com.nexstreaming.kinemaster.ui.gdpr.ConfirmFragment.a
    public final void a(ConfirmFragment.BUTTON button) {
        this.f21619b.dismiss();
        this.f21620c.setCancelable(true);
        if (button != null && a.f21305a[button.ordinal()] == 1) {
            this.f21620c.dismiss();
            c.d.b.c.a.a(this.f21618a.getApplicationContext(), 3, this.f21621d, this.f21622e);
            this.f21618a.L();
        }
    }
}
