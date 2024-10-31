package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.content.DialogInterface;

/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
class w implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ u f4745a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.f4745a = uVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
