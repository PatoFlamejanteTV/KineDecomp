package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.nexstreaming.kinemaster.usage.KMUsage;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class be implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SharedPreferences f4158a;
    final /* synthetic */ ProjectGalleryActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(ProjectGalleryActivity projectGalleryActivity, SharedPreferences sharedPreferences) {
        this.b = projectGalleryActivity;
        this.f4158a = sharedPreferences;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        KMUsage.Rate_Review.logEvent("selection", "Remind");
        this.f4158a.edit().putLong("rate_nextShowPopupDate", new Date().getTime() + 259200000).apply();
        dialogInterface.dismiss();
    }
}
