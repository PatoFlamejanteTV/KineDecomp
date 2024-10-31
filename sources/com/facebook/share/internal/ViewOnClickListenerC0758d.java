package com.facebook.share.internal;

import android.app.Dialog;
import android.view.View;

/* compiled from: DeviceShareDialogFragment.java */
/* renamed from: com.facebook.share.internal.d */
/* loaded from: classes.dex */
class ViewOnClickListenerC0758d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DeviceShareDialogFragment f9569a;

    public ViewOnClickListenerC0758d(DeviceShareDialogFragment deviceShareDialogFragment) {
        this.f9569a = deviceShareDialogFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        dialog = this.f9569a.dialog;
        dialog.dismiss();
    }
}
