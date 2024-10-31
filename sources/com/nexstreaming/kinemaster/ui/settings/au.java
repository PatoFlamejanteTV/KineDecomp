package com.nexstreaming.kinemaster.ui.settings;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsActivity.java */
/* loaded from: classes.dex */
public class au implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SettingsActivity f4247a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(SettingsActivity settingsActivity) {
        this.f4247a = settingsActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
