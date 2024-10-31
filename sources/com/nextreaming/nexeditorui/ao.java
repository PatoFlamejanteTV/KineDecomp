package com.nextreaming.nexeditorui;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABWrapper.java */
/* loaded from: classes.dex */
public class ao implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ af f4523a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(af afVar) {
        this.f4523a = afVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4523a.y();
        dialogInterface.dismiss();
    }
}
