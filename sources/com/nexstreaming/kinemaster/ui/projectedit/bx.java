package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaEditFragment.java */
/* loaded from: classes.dex */
public class bx implements DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bo f3805a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bo boVar) {
        this.f3805a = boVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f3805a.e = null;
    }
}
