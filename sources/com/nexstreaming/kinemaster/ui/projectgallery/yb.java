package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
public class yb implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.e f23005a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f23006b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public yb(ProjectGalleryActivity projectGalleryActivity, com.nexstreaming.kinemaster.ui.a.e eVar) {
        this.f23006b = projectGalleryActivity;
        this.f23005a = eVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f23005a.dismiss();
    }
}
