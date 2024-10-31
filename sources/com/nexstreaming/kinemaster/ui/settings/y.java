package com.nexstreaming.kinemaster.ui.settings;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingFragment.java */
/* loaded from: classes.dex */
public class y implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ x f4274a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.f4274a = xVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
