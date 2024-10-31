package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class aw implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4149a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(ProjectGalleryActivity projectGalleryActivity) {
        this.f4149a = projectGalleryActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
    }
}
