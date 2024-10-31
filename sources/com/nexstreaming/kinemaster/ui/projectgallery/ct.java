package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Intent;
import android.view.View;
import com.nexstreaming.kinemaster.support.SupportAppsActivity;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class ct implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4200a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(ProjectGalleryActivity projectGalleryActivity) {
        this.f4200a = projectGalleryActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4200a.startActivity(new Intent(this.f4200a, (Class<?>) SupportAppsActivity.class));
        this.f4200a.overridePendingTransition(0, 0);
    }
}
