package com.nexstreaming.kinemaster.ui.projectgallery;

import android.view.View;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class cv implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4202a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(ProjectGalleryActivity projectGalleryActivity) {
        this.f4202a = projectGalleryActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        ProjectGalleryActivity projectGalleryActivity = this.f4202a;
        z = this.f4202a.c;
        projectGalleryActivity.b(!z);
    }
}
