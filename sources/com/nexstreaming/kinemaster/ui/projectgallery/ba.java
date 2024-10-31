package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class ba implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ay f4154a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(ay ayVar) {
        this.f4154a = ayVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        KMUsage.Rate_Report.logEvent("selection", "Close");
        this.f4154a.f4151a.edit().putBoolean("rate_neverShowReviewPopup", true).remove("rate_nextShowPopupDate").apply();
        dialogInterface.dismiss();
    }
}
