package com.nexstreaming.kinemaster.ui.projectgallery;

import android.view.View;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
class qb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ rb f22971a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public qb(rb rbVar) {
        this.f22971a = rbVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        view = this.f22971a.f22975a.f22980c.W;
        view.setVisibility(8);
    }
}
