package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class ap implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ao f4142a;

    public ap(ao aoVar) {
        this.f4142a = aoVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.nexstreaming.kinemaster.project.f fVar;
        com.nexstreaming.kinemaster.project.f fVar2;
        boolean a2;
        com.nexstreaming.kinemaster.project.f fVar3;
        boolean b;
        com.nexstreaming.kinemaster.project.f fVar4;
        fVar = this.f4142a.f4141a.f4139a.q;
        if (fVar != null) {
            ProjectGalleryActivity projectGalleryActivity = this.f4142a.f4141a.f4139a;
            fVar2 = this.f4142a.f4141a.f4139a.q;
            a2 = projectGalleryActivity.a(fVar2.a().getName());
            if (a2) {
                ProjectGalleryActivity projectGalleryActivity2 = this.f4142a.f4141a.f4139a;
                fVar4 = this.f4142a.f4141a.f4139a.q;
                projectGalleryActivity2.a(fVar4);
                dialogInterface.dismiss();
                return;
            }
            ProjectGalleryActivity projectGalleryActivity3 = this.f4142a.f4141a.f4139a;
            fVar3 = this.f4142a.f4141a.f4139a.q;
            b = projectGalleryActivity3.b(fVar3);
            dialogInterface.dismiss();
            this.f4142a.f4141a.f4139a.c(b);
        }
    }
}
