package com.nexstreaming.kinemaster.ui.projectgallery;

import android.view.View;

/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.ba, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C2097ba extends com.nexstreaming.app.general.util.A {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22906b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2097ba(ProjectGalleryActivity projectGalleryActivity) {
        this.f22906b = projectGalleryActivity;
    }

    @Override // com.nexstreaming.app.general.util.A
    public void a(View view) {
        boolean L;
        com.nexstreaming.kinemaster.project.k kVar;
        O o;
        com.nexstreaming.kinemaster.project.k kVar2;
        L = this.f22906b.L();
        if (L) {
            kVar = this.f22906b.va;
            if (kVar != null) {
                o = this.f22906b.Ba;
                kVar2 = this.f22906b.va;
                o.a(kVar2.e(), this.f22906b.y().e(), true).onComplete(new C2094aa(this)).onCancel(new Z(this)).onFailure(new Y(this));
            }
        }
    }
}
