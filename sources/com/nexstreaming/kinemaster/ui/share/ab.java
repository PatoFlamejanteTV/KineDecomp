package com.nexstreaming.kinemaster.ui.share;

import android.content.DialogInterface;

/* compiled from: ShareActivity.java */
/* loaded from: classes.dex */
class ab implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ aa f4286a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.f4286a = aaVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
