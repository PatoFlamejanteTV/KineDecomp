package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import android.content.SharedPreferences;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.za, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class DialogInterfaceOnCancelListenerC2155za implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SharedPreferences f23008a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f23009b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnCancelListenerC2155za(ProjectGalleryActivity projectGalleryActivity, SharedPreferences sharedPreferences) {
        this.f23009b = projectGalleryActivity;
        this.f23008a = sharedPreferences;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f23008a.edit().putBoolean("rate_neverShowReviewPopup", true).remove("rate_nextShowPopupDate").apply();
        dialogInterface.dismiss();
    }
}
