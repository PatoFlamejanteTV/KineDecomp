package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import java.io.File;

/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.va, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class DialogInterfaceOnClickListenerC2147va implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DialogInterfaceOnClickListenerC2153ya f22990a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnClickListenerC2147va(DialogInterfaceOnClickListenerC2153ya dialogInterfaceOnClickListenerC2153ya) {
        this.f22990a = dialogInterfaceOnClickListenerC2153ya;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f22990a.f23003a.edit().putBoolean("rate_neverShowReviewPopup", true).remove("rate_nextShowPopupDate").apply();
        dialogInterface.dismiss();
        ProjectGalleryActivity projectGalleryActivity = this.f22990a.f23004b;
        com.nexstreaming.kinemaster.support.v.a(projectGalleryActivity, projectGalleryActivity.B(), "RVW", new File[0]);
    }
}
