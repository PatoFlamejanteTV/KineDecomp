package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.gb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class DialogInterfaceOnClickListenerC2113gb implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f22923a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22924b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnClickListenerC2113gb(ProjectGalleryActivity projectGalleryActivity, int i) {
        this.f22924b = projectGalleryActivity;
        this.f22923a = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ProjectGalleryActivity projectGalleryActivity = this.f22924b;
        int i2 = projectGalleryActivity.Na;
        int i3 = this.f22923a;
        if (i2 == i3 && i3 >= 0) {
            com.nexstreaming.app.general.tracelog.r.a(projectGalleryActivity, i2);
        }
        dialogInterface.dismiss();
    }
}
