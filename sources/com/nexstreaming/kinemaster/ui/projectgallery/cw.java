package com.nexstreaming.kinemaster.ui.projectgallery;

import android.view.View;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class cw implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4203a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(ProjectGalleryActivity projectGalleryActivity) {
        this.f4203a = projectGalleryActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.nexstreaming.kinemaster.project.f fVar;
        boolean z;
        com.nexstreaming.kinemaster.project.f fVar2;
        fVar = this.f4203a.q;
        if (fVar != null) {
            z = this.f4203a.C;
            if (!z) {
                ProjectGalleryActivity projectGalleryActivity = this.f4203a;
                fVar2 = this.f4203a.q;
                projectGalleryActivity.a(fVar2, "edit_button");
                this.f4203a.C = true;
            }
        }
    }
}
