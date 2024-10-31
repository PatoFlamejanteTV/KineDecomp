package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.content.DialogInterface;

/* compiled from: AudioBrowserFragment.java */
/* loaded from: classes.dex */
class k implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f3676a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f3676a = jVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
