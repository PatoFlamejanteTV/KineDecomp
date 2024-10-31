package com.nextreaming.nexeditorui;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABWrapper.java */
/* loaded from: classes.dex */
public class aq implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DialogInterface.OnClickListener f4525a;
    final /* synthetic */ af b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(af afVar, DialogInterface.OnClickListener onClickListener) {
        this.b = afVar;
        this.f4525a = onClickListener;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f4525a != null) {
            this.f4525a.onClick(dialogInterface, i);
        }
    }
}
