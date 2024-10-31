package com.nexstreaming.kinemaster.codeccaps.ui;

import android.content.DialogInterface;
import android.content.Intent;
import com.nexstreaming.kinemaster.ui.settings.SettingsActivity;

/* compiled from: CapabilityTestRunnerActivity.java */
/* loaded from: classes.dex */
class b implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CapabilityTestRunnerActivity f20123a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(CapabilityTestRunnerActivity capabilityTestRunnerActivity) {
        this.f20123a = capabilityTestRunnerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        CapabilityTestIntroActivity.H = true;
        this.f20123a.finish();
        Intent intent = new Intent(this.f20123a, (Class<?>) SettingsActivity.class);
        intent.putExtra("SELECTED_FRAG_KEY", "pref_information_device_capability");
        this.f20123a.startActivity(intent);
    }
}
