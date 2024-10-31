package com.nexstreaming.kinemaster.codeccaps.ui;

import android.content.DialogInterface;

/* compiled from: CapabilityTestRunnerActivity.java */
/* loaded from: classes.dex */
class m implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CapabilityTestRunnerActivity f20135a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(CapabilityTestRunnerActivity capabilityTestRunnerActivity) {
        this.f20135a = capabilityTestRunnerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        CapabilityTestIntroActivity.H = true;
        this.f20135a.finish();
    }
}
