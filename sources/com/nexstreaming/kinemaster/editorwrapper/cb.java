package com.nexstreaming.kinemaster.editorwrapper;

import android.content.DialogInterface;

/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
class cb implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ca f3355a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(ca caVar) {
        this.f3355a = caVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
