package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.content.DialogInterface;

/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
class am implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ al f4709a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar) {
        this.f4709a = alVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
