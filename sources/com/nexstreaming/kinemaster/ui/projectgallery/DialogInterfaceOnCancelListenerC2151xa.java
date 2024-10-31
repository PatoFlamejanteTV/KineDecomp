package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;

/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.xa */
/* loaded from: classes2.dex */
class DialogInterfaceOnCancelListenerC2151xa implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DialogInterfaceOnClickListenerC2153ya f22998a;

    public DialogInterfaceOnCancelListenerC2151xa(DialogInterfaceOnClickListenerC2153ya dialogInterfaceOnClickListenerC2153ya) {
        this.f22998a = dialogInterfaceOnClickListenerC2153ya;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f22998a.f23003a.edit().putBoolean("rate_neverShowReviewPopup", true).remove("rate_nextShowPopupDate").apply();
        dialogInterface.dismiss();
    }
}
