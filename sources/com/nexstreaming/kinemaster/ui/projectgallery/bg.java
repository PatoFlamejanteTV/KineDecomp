package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.nexstreaming.kinemaster.usage.KMUsage;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class bg implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SharedPreferences f4160a;
    final /* synthetic */ ProjectGalleryActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(ProjectGalleryActivity projectGalleryActivity, SharedPreferences sharedPreferences) {
        this.b = projectGalleryActivity;
        this.f4160a = sharedPreferences;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        KMUsage.Rate_Review.logEvent("selection", "Cancel");
        this.f4160a.edit().putLong("rate_nextShowPopupDate", new Date().getTime() + 259200000).apply();
        dialogInterface.dismiss();
    }
}
