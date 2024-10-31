package com.nexstreaming.kinemaster.ui.projectgallery;

import android.app.Activity;
import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class cc implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4183a;
    final /* synthetic */ ProjectGalleryActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(ProjectGalleryActivity projectGalleryActivity, int i) {
        this.b = projectGalleryActivity;
        this.f4183a = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Activity D;
        if (this.b.f4123a == this.f4183a && this.f4183a >= 0) {
            D = this.b.D();
            com.nexstreaming.app.general.tracelog.j.b(D, this.b.f4123a);
        }
        dialogInterface.dismiss();
    }
}
