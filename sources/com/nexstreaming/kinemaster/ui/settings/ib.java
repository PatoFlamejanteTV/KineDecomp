package com.nexstreaming.kinemaster.ui.settings;

import android.content.DialogInterface;
import com.nexstreaming.kinemaster.ui.gdpr.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsActivity.java */
/* loaded from: classes2.dex */
public class ib implements g.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f23153a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.gdpr.g f23154b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ SettingsActivity f23155c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ib(SettingsActivity settingsActivity, int i, com.nexstreaming.kinemaster.ui.gdpr.g gVar) {
        this.f23155c = settingsActivity;
        this.f23153a = i;
        this.f23154b = gVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.gdpr.g.a
    public void a(DialogInterface dialogInterface, boolean z, boolean z2) {
        if ((this.f23153a == 1 && c.d.b.c.a.d(this.f23155c) && !z) || (this.f23153a == 2 && c.d.b.c.a.c(this.f23155c) && !z2)) {
            this.f23155c.a(this.f23154b, this.f23153a, z, z2);
        } else {
            c.d.b.c.a.a(this.f23155c, this.f23153a, z, z2);
            dialogInterface.dismiss();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.gdpr.g.a
    public void a(DialogInterface dialogInterface) {
        this.f23154b.dismiss();
    }
}
