package com.nexstreaming.kinemaster.ui.settings;

import com.nexstreaming.kinemaster.ui.gdpr.ConfirmFragment;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsActivity.java */
/* loaded from: classes2.dex */
public class Za implements ConfirmFragment.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ConfirmFragment f23105a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.gdpr.g f23106b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f23107c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f23108d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f23109e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ SettingsActivity f23110f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Za(SettingsActivity settingsActivity, ConfirmFragment confirmFragment, com.nexstreaming.kinemaster.ui.gdpr.g gVar, int i, boolean z, boolean z2) {
        this.f23110f = settingsActivity;
        this.f23105a = confirmFragment;
        this.f23106b = gVar;
        this.f23107c = i;
        this.f23108d = z;
        this.f23109e = z2;
    }

    @Override // com.nexstreaming.kinemaster.ui.gdpr.ConfirmFragment.a
    public void a(ConfirmFragment.BUTTON button) {
        this.f23105a.dismiss();
        this.f23106b.setCancelable(true);
        if (_a.f23111a[button.ordinal()] != 1) {
            return;
        }
        this.f23106b.dismiss();
        c.d.b.c.a.a(this.f23110f, this.f23107c, this.f23108d, this.f23109e);
    }
}
