package com.nexstreaming.kinemaster.ui.projectgallery;

import android.view.View;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
class sb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f22978a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f22979b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22980c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public sb(ProjectGalleryActivity projectGalleryActivity, View view, int i) {
        this.f22980c = projectGalleryActivity;
        this.f22978a = view;
        this.f22979b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f22978a.post(new rb(this));
    }
}
