package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
public class Ca implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SharedPreferences f22817a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22818b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ca(ProjectGalleryActivity projectGalleryActivity, SharedPreferences sharedPreferences) {
        this.f22818b = projectGalleryActivity;
        this.f22817a = sharedPreferences;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f22817a.edit().putLong("rate_nextShowPopupDate", new Date().getTime() + 259200000).apply();
        dialogInterface.dismiss();
    }
}
