package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.DialogInterface;

/* compiled from: MediaEditFragment.java */
/* loaded from: classes.dex */
public class ca implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f3809a;
    final /* synthetic */ com.nexstreaming.kinemaster.g.i b;
    final /* synthetic */ bo c;

    public ca(bo boVar, boolean z, com.nexstreaming.kinemaster.g.i iVar) {
        this.c = boVar;
        this.f3809a = z;
        this.b = iVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (!this.f3809a) {
            this.b.cancel();
        }
        dialogInterface.dismiss();
    }
}
