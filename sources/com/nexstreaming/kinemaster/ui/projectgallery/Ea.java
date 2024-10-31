package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
public class Ea implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SharedPreferences f22823a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22824b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ea(ProjectGalleryActivity projectGalleryActivity, SharedPreferences sharedPreferences) {
        this.f22824b = projectGalleryActivity;
        this.f22823a = sharedPreferences;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f22823a.edit().putLong("rate_nextShowPopupDate", new Date().getTime() + 259200000).apply();
        dialogInterface.dismiss();
    }
}
