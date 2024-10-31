package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import android.content.SharedPreferences;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
public class Oa implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SharedPreferences f22874a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22875b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Oa(ProjectGalleryActivity projectGalleryActivity, SharedPreferences sharedPreferences) {
        this.f22875b = projectGalleryActivity;
        this.f22874a = sharedPreferences;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f22874a.edit().putInt("km_versionWarningVer", 14242).apply();
        dialogInterface.dismiss();
    }
}
