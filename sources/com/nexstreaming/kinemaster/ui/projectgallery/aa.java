package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
public class Aa implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SharedPreferences f22811a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22812b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Aa(ProjectGalleryActivity projectGalleryActivity, SharedPreferences sharedPreferences) {
        this.f22812b = projectGalleryActivity;
        this.f22811a = sharedPreferences;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        Intent intent = new Intent("android.intent.action.VIEW");
        this.f22811a.edit().putBoolean("rate_neverShowReviewPopup", true).remove("rate_nextShowPopupDate").apply();
        try {
            intent.setData(Uri.parse("market://details?id=" + this.f22812b.getPackageName()));
            this.f22812b.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + this.f22812b.getPackageName()));
            this.f22812b.startActivity(intent);
        }
    }
}
