package com.facebook.internal;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WebDialog.java */
/* loaded from: classes.dex */
public class af implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WebDialog f284a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(WebDialog webDialog) {
        this.f284a = webDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f284a.cancel();
    }
}
