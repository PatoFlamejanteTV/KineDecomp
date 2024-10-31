package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import android.content.SharedPreferences;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class bc implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SharedPreferences f4156a;
    final /* synthetic */ ProjectGalleryActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(ProjectGalleryActivity projectGalleryActivity, SharedPreferences sharedPreferences) {
        this.b = projectGalleryActivity;
        this.f4156a = sharedPreferences;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f4156a.edit().putBoolean("rate_neverShowReviewPopup", true).remove("rate_nextShowPopupDate").apply();
        dialogInterface.dismiss();
    }
}
