package com.nexstreaming.kinemaster.ui.projectgallery;

import android.view.View;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class bv implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4175a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(ProjectGalleryActivity projectGalleryActivity) {
        this.f4175a = projectGalleryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        View view3;
        View view4;
        View view5;
        view = this.f4175a.i;
        view.setVisibility(4);
        view2 = this.f4175a.j;
        view2.setTranslationX(0.0f);
        view3 = this.f4175a.j;
        view3.setTranslationY(0.0f);
        view4 = this.f4175a.j;
        view4.setScaleX(0.0f);
        view5 = this.f4175a.j;
        view5.setScaleY(0.0f);
    }
}
