package com.nexstreaming.kinemaster.ui.settings;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsActivity.java */
/* loaded from: classes2.dex */
public class hb implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SettingsActivity f23149a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hb(SettingsActivity settingsActivity) {
        this.f23149a = settingsActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
