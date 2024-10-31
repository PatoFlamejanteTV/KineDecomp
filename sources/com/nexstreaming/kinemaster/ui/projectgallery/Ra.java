package com.nexstreaming.kinemaster.ui.projectgallery;

import android.support.v7.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
public class Ra implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f22880a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22881b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ra(ProjectGalleryActivity projectGalleryActivity, int i) {
        this.f22881b = projectGalleryActivity;
        this.f22880a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        RecyclerView recyclerView;
        recyclerView = this.f22881b.sa;
        recyclerView.scrollToPosition(this.f22880a);
    }
}
