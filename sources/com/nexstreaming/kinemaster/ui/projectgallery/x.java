package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.nexstreaming.kinemaster.ui.previewplay.PreviewPlayActivity;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
class X extends com.nexstreaming.app.general.util.A {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22894b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public X(ProjectGalleryActivity projectGalleryActivity) {
        this.f22894b = projectGalleryActivity;
    }

    @Override // com.nexstreaming.app.general.util.A
    public void a(View view) {
        boolean L;
        com.nexstreaming.kinemaster.project.k kVar;
        L = this.f22894b.L();
        if (L) {
            Intent intent = new Intent(this.f22894b, (Class<?>) PreviewPlayActivity.class);
            kVar = this.f22894b.va;
            intent.setData(Uri.fromFile(kVar.e()));
            this.f22894b.startActivity(intent);
            this.f22894b.overridePendingTransition(0, 0);
        }
    }
}
