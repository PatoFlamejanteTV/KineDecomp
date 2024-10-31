package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaEditFragment.java */
/* loaded from: classes.dex */
public class bv implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bo f3803a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bo boVar) {
        this.f3803a = boVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
