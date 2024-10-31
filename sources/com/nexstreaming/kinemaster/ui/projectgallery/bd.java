package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class bd implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SharedPreferences f4157a;
    final /* synthetic */ ProjectGalleryActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(ProjectGalleryActivity projectGalleryActivity, SharedPreferences sharedPreferences) {
        this.b = projectGalleryActivity;
        this.f4157a = sharedPreferences;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        KMUsage.Rate_Review.logEvent("selection", "Rate");
        dialogInterface.dismiss();
        Intent intent = new Intent("android.intent.action.VIEW");
        this.f4157a.edit().putBoolean("rate_neverShowReviewPopup", true).remove("rate_nextShowPopupDate").apply();
        try {
            intent.setData(Uri.parse("market://details?id=" + this.b.getPackageName()));
            this.b.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + this.b.getPackageName()));
            this.b.startActivity(intent);
        }
    }
}
