package com.nexstreaming.kinemaster.ui.projectgallery;

import android.view.View;

/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.eb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class RunnableC2107eb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22917a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2107eb(ProjectGalleryActivity projectGalleryActivity) {
        this.f22917a = projectGalleryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        View view3;
        View view4;
        View view5;
        view = this.f22917a.X;
        view.setVisibility(4);
        view2 = this.f22917a.Y;
        view2.setTranslationX(0.0f);
        view3 = this.f22917a.Y;
        view3.setTranslationY(0.0f);
        view4 = this.f22917a.Y;
        view4.setScaleX(0.0f);
        view5 = this.f22917a.Y;
        view5.setScaleY(0.0f);
    }
}
