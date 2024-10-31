package com.nexstreaming.kinemaster.ui.projectgallery;

import android.view.View;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
class V extends com.nexstreaming.app.general.util.A {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22888b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public V(ProjectGalleryActivity projectGalleryActivity) {
        this.f22888b = projectGalleryActivity;
    }

    @Override // com.nexstreaming.app.general.util.A
    public void a(View view) {
        com.nexstreaming.kinemaster.project.k kVar;
        com.nexstreaming.kinemaster.project.k kVar2;
        kVar = this.f22888b.va;
        if (kVar != null) {
            ProjectGalleryActivity projectGalleryActivity = this.f22888b;
            kVar2 = projectGalleryActivity.va;
            projectGalleryActivity.a(kVar2, "edit_button");
        }
    }
}
