package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.nexstreaming.kinemaster.ui.previewplay.PreviewPlayActivity;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class af implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4132a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ProjectGalleryActivity projectGalleryActivity) {
        this.f4132a = projectGalleryActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean t;
        com.nexstreaming.kinemaster.project.f fVar;
        t = this.f4132a.t();
        if (t) {
            Intent intent = new Intent(this.f4132a, (Class<?>) PreviewPlayActivity.class);
            fVar = this.f4132a.q;
            intent.setData(Uri.fromFile(fVar.a()));
            this.f4132a.startActivity(intent);
            this.f4132a.overridePendingTransition(0, 0);
        }
    }
}
