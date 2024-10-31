package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class bs implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bq f4172a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bq bqVar) {
        this.f4172a = bqVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
