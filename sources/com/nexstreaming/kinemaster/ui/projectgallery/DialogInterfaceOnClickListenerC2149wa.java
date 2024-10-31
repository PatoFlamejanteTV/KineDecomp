package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;

/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.wa */
/* loaded from: classes2.dex */
class DialogInterfaceOnClickListenerC2149wa implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogInterfaceOnClickListenerC2153ya f22994a;

    public DialogInterfaceOnClickListenerC2149wa(DialogInterfaceOnClickListenerC2153ya dialogInterfaceOnClickListenerC2153ya) {
        this.f22994a = dialogInterfaceOnClickListenerC2153ya;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f22994a.f23003a.edit().putBoolean("rate_neverShowReviewPopup", true).remove("rate_nextShowPopupDate").apply();
        dialogInterface.dismiss();
    }
}
