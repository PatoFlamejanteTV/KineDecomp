package com.nexstreaming.kinemaster.ui.projectgallery;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.FullScreenInputActivity;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class ae implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4131a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ProjectGalleryActivity projectGalleryActivity) {
        this.f4131a = projectGalleryActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.nexstreaming.kinemaster.project.f fVar;
        com.nexstreaming.kinemaster.project.f fVar2;
        Activity D;
        if (motionEvent.getActionMasked() == 0) {
            fVar = this.f4131a.q;
            if (fVar != null) {
                fVar2 = this.f4131a.q;
                String f = fVar2.f();
                ProjectGalleryActivity projectGalleryActivity = this.f4131a;
                D = this.f4131a.D();
                projectGalleryActivity.startActivityForResult(FullScreenInputActivity.a(D).a(f).c(false).b(false).d(true).f(true).a(), FullScreenInputActivity.a());
            }
        }
        return false;
    }
}
