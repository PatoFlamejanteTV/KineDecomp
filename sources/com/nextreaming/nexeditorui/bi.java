package com.nextreaming.nexeditorui;

import android.content.DialogInterface;

/* compiled from: KineMasterBaseActivity.java */
/* loaded from: classes.dex */
class bi implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bh f4546a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bh bhVar) {
        this.f4546a = bhVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
