package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class cp implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cn f4196a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(cn cnVar) {
        this.f4196a = cnVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
