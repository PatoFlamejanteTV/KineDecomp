package com.nexstreaming.kinemaster.ui.previewplay;

import android.content.DialogInterface;

/* compiled from: PreviewPlayActivity.java */
/* loaded from: classes.dex */
class c implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f3722a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f3722a = bVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f3722a.f3721a.finish();
    }
}
