package com.nexstreaming.kinemaster.ui.projectgallery;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
class W implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22892a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public W(ProjectGalleryActivity projectGalleryActivity) {
        this.f22892a = projectGalleryActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.nexstreaming.kinemaster.project.k kVar;
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        kVar = this.f22892a.va;
        if (kVar == null) {
            return false;
        }
        this.f22892a.ea();
        return false;
    }
}
