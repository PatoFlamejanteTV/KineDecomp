package com.nexstreaming.kinemaster.ui.projectgallery;

import android.widget.GridView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class bo implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4168a;
    final /* synthetic */ ProjectGalleryActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(ProjectGalleryActivity projectGalleryActivity, int i) {
        this.b = projectGalleryActivity;
        this.f4168a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        gridView = this.b.e;
        gridView.setSelection(this.f4168a);
    }
}
