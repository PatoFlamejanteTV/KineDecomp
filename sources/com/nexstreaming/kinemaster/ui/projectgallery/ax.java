package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class ax implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4150a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(ProjectGalleryActivity projectGalleryActivity) {
        this.f4150a = projectGalleryActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        KMUsage.Rate_Like_KM.logEvent("selection", "Yes");
        dialogInterface.dismiss();
        this.f4150a.g();
    }
}
