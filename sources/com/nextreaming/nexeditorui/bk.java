package com.nextreaming.nexeditorui;

import android.content.DialogInterface;

/* compiled from: KineMasterBaseActivity.java */
/* loaded from: classes.dex */
class bk implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bj f4548a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bj bjVar) {
        this.f4548a = bjVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
