package com.facebook.internal;

import android.content.DialogInterface;

/* compiled from: WebDialog.java */
/* loaded from: classes.dex */
public class F implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ WebDialog f9275a;

    public F(WebDialog webDialog) {
        this.f9275a = webDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f9275a.cancel();
    }
}
