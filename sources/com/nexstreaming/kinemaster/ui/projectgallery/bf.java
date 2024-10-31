package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class bf implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SharedPreferences f4159a;
    final /* synthetic */ ProjectGalleryActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(ProjectGalleryActivity projectGalleryActivity, SharedPreferences sharedPreferences) {
        this.b = projectGalleryActivity;
        this.f4159a = sharedPreferences;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        KMUsage.Rate_Review.logEvent("selection", "DontAsk");
        this.f4159a.edit().putBoolean("rate_neverShowReviewPopup", true).remove("rate_nextShowPopupDate").apply();
        dialogInterface.dismiss();
    }
}
