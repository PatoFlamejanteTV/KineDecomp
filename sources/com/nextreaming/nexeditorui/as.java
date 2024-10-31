package com.nextreaming.nexeditorui;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABWrapper.java */
/* loaded from: classes.dex */
public class as implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ af f4527a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(af afVar) {
        this.f4527a = afVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4527a.y();
        dialogInterface.dismiss();
        this.f4527a.y = null;
    }
}
