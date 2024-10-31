package com.nexstreaming.kinemaster.ui.share;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareBaseActivity.java */
/* loaded from: classes.dex */
public class am implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ad f4297a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ad adVar) {
        this.f4297a = adVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
