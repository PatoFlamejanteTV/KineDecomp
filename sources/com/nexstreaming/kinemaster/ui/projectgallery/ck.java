package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class ck implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4191a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(ProjectGalleryActivity projectGalleryActivity) {
        this.f4191a = projectGalleryActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
