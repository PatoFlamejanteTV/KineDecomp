package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;

/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.ma */
/* loaded from: classes2.dex */
class DialogInterfaceOnClickListenerC2130ma implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RunnableC2132na f22953a;

    public DialogInterfaceOnClickListenerC2130ma(RunnableC2132na runnableC2132na) {
        this.f22953a = runnableC2132na;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
