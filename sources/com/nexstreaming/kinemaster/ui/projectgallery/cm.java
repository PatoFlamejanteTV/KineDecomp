package com.nexstreaming.kinemaster.ui.projectgallery;

import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class cm implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4193a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(ProjectGalleryActivity projectGalleryActivity) {
        this.f4193a = projectGalleryActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4193a.findViewById(R.id.permissionSettings).setVisibility(8);
        this.f4193a.findViewById(R.id.permissionRationale).setVisibility(8);
        this.f4193a.F = System.nanoTime();
        this.f4193a.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, R.id.reqperms);
    }
}
