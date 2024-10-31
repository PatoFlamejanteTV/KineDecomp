package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class bb implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ay f4155a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ay ayVar) {
        this.f4155a = ayVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f4155a.f4151a.edit().putBoolean("rate_neverShowReviewPopup", true).remove("rate_nextShowPopupDate").apply();
        dialogInterface.dismiss();
    }
}
