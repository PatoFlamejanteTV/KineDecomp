package com.nexstreaming.kinemaster.ui.share;

import android.content.DialogInterface;

/* compiled from: ShareBaseActivity.java */
/* loaded from: classes.dex */
class ah implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ af f4292a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar) {
        this.f4292a = afVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f4292a.f4290a.g();
    }
}
