package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
public class fd implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ez f3894a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fd(ez ezVar) {
        this.f3894a = ezVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
