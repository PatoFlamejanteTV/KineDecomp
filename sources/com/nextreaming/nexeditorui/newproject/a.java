package com.nextreaming.nexeditorui.newproject;

import android.content.DialogInterface;

/* compiled from: NewProjectActivity.java */
/* loaded from: classes.dex */
class a implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NewProjectActivity f4659a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(NewProjectActivity newProjectActivity) {
        this.f4659a = newProjectActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
