package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Intent;
import android.view.View;
import com.nexstreaming.kinemaster.ui.settings.SettingsActivity;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class bz implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4179a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(ProjectGalleryActivity projectGalleryActivity) {
        this.f4179a = projectGalleryActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4179a.startActivity(new Intent(this.f4179a, (Class<?>) SettingsActivity.class));
        this.f4179a.overridePendingTransition(0, 0);
    }
}
