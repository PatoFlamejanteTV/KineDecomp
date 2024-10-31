package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class cl implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4192a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ProjectGalleryActivity projectGalleryActivity) {
        this.f4192a = projectGalleryActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4192a.findViewById(R.id.permissionSettings).setVisibility(8);
        this.f4192a.findViewById(R.id.permissionRationale).setVisibility(8);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.f4192a.getPackageName(), null));
        this.f4192a.startActivityForResult(intent, R.id.req_perm_settings);
    }
}
