package com.nextreaming.nexeditorui;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KineMasterBaseActivity.java */
/* loaded from: classes.dex */
public class bc implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ba f4540a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(ba baVar) {
        this.f4540a = baVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ba.d = true;
    }
}
