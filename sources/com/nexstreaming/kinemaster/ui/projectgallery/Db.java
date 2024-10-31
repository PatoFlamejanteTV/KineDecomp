package com.nexstreaming.kinemaster.ui.projectgallery;

import android.view.KeyEvent;
import android.view.View;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
class Db implements View.OnKeyListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22822a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Db(ProjectGalleryActivity projectGalleryActivity) {
        this.f22822a = projectGalleryActivity;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i != 66) {
            return false;
        }
        this.f22822a.ea();
        return true;
    }
}
