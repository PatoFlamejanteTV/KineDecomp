package com.nextreaming.nexeditorui;

import android.content.DialogInterface;

/* compiled from: NexPrefsFrag.java */
/* loaded from: classes.dex */
class cm implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cl f4577a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(cl clVar) {
        this.f4577a = clVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
