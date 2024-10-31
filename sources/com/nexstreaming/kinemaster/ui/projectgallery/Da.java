package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import android.content.SharedPreferences;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
public class Da implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SharedPreferences f22820a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22821b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Da(ProjectGalleryActivity projectGalleryActivity, SharedPreferences sharedPreferences) {
        this.f22821b = projectGalleryActivity;
        this.f22820a = sharedPreferences;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f22820a.edit().putBoolean("rate_neverShowReviewPopup", true).remove("rate_nextShowPopupDate").apply();
        dialogInterface.dismiss();
    }
}
