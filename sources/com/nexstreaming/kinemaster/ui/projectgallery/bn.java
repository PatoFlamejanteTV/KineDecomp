package com.nexstreaming.kinemaster.ui.projectgallery;

import com.nextreaming.nexeditorui.KineMasterApplication;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class bn implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4167a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(ProjectGalleryActivity projectGalleryActivity) {
        this.f4167a = projectGalleryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (KineMasterApplication.a().c().a().isRunning()) {
            this.f4167a.v();
        }
    }
}
