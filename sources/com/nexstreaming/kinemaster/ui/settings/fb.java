package com.nexstreaming.kinemaster.ui.settings;

import android.content.Context;
import android.content.DialogInterface;
import com.nexstreaming.kinemaster.codeccaps.ui.CapabilityTestIntroActivity;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.ui.projectedit.FullScreenInputActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsActivity.java */
/* loaded from: classes2.dex */
public class fb implements e.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SettingsActivity f23141a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fb(SettingsActivity settingsActivity) {
        this.f23141a = settingsActivity;
    }

    @Override // com.nexstreaming.kinemaster.ui.a.e.c
    public boolean a(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        SettingsActivity settingsActivity = this.f23141a;
        settingsActivity.startActivityForResult(FullScreenInputActivity.a(settingsActivity).a(), 8194);
        return true;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        SettingsActivity settingsActivity = this.f23141a;
        settingsActivity.startActivity(CapabilityTestIntroActivity.a((Context) settingsActivity, true));
    }
}
