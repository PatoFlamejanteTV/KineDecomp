package com.nexstreaming.kinemaster.ui.settings;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceCapabilityInfoFragment.java */
/* loaded from: classes.dex */
public class p implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ o f4266a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.f4266a = oVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        System.exit(0);
    }
}
