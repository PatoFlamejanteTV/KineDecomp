package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.ta, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class DialogInterfaceOnCancelListenerC2143ta implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22982a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnCancelListenerC2143ta(ProjectGalleryActivity projectGalleryActivity) {
        this.f22982a = projectGalleryActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
    }
}
