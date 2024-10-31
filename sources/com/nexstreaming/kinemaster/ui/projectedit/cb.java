package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.DialogInterface;

/* compiled from: MediaEditFragment.java */
/* loaded from: classes.dex */
public class cb implements DialogInterface.OnShowListener {

    /* renamed from: a */
    final /* synthetic */ bo f3810a;

    public cb(bo boVar) {
        this.f3810a = boVar;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        this.f3810a.k(true);
        this.f3810a.i(true);
    }
}
