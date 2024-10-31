package com.nextreaming.nexeditorui;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KineMasterBaseActivity.java */
/* loaded from: classes.dex */
public class bn implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ba f4551a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(ba baVar) {
        this.f4551a = baVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f4551a.e();
    }
}
