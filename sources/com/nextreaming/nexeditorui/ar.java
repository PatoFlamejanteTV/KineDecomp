package com.nextreaming.nexeditorui;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABWrapper.java */
/* loaded from: classes.dex */
public class ar implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DialogInterface.OnClickListener f4526a;
    final /* synthetic */ af b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(af afVar, DialogInterface.OnClickListener onClickListener) {
        this.b = afVar;
        this.f4526a = onClickListener;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.f4526a != null) {
            this.f4526a.onClick(dialogInterface, i);
        }
        this.b.y = null;
    }
}
