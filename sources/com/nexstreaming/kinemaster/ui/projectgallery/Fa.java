package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import com.nexstreaming.kinemaster.util.update.AssetUpdateActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
public class Fa implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22832a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fa(ProjectGalleryActivity projectGalleryActivity) {
        this.f22832a = projectGalleryActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ProjectGalleryActivity projectGalleryActivity = this.f22832a;
        projectGalleryActivity.startActivity(AssetUpdateActivity.c(projectGalleryActivity));
        dialogInterface.dismiss();
    }
}
