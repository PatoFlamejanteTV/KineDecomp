package com.nextreaming.nexeditorui;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABWrapper.java */
/* loaded from: classes.dex */
public class ap implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DialogInterface.OnClickListener f4524a;
    final /* synthetic */ af b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(af afVar, DialogInterface.OnClickListener onClickListener) {
        this.b = afVar;
        this.f4524a = onClickListener;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f4524a != null) {
            this.f4524a.onClick(dialogInterface, i);
        }
        dialogInterface.dismiss();
    }
}
