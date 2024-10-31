package com.nexstreaming.kinemaster.ui.projectgallery;

import android.view.View;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
class Ya implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22897a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ya(ProjectGalleryActivity projectGalleryActivity) {
        this.f22897a = projectGalleryActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        Eb eb;
        Eb eb2;
        Eb eb3;
        Eb eb4;
        if (z) {
            this.f22897a.G();
            eb2 = this.f22897a.ua;
            if (eb2.i() == -1) {
                eb4 = this.f22897a.ua;
                eb4.l();
                return;
            } else {
                eb3 = this.f22897a.ua;
                eb3.k();
                return;
            }
        }
        eb = this.f22897a.ua;
        eb.f();
    }
}
