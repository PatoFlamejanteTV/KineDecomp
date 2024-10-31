package com.nexstreaming.kinemaster.ui.projectgallery;

import android.view.View;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class ad implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ac f4130a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.f4130a = acVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        view = this.f4130a.c.f4128a.h;
        view.setVisibility(8);
    }
}
