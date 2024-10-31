package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import android.content.SharedPreferences;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class bk implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SharedPreferences f4164a;
    final /* synthetic */ ProjectGalleryActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(ProjectGalleryActivity projectGalleryActivity, SharedPreferences sharedPreferences) {
        this.b = projectGalleryActivity;
        this.f4164a = sharedPreferences;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4164a.edit().putInt("km_versionWarningVer", 8291).apply();
        dialogInterface.dismiss();
    }
}
