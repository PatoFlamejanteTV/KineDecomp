package com.facebook.share.internal;

import android.app.Dialog;

/* compiled from: DeviceShareDialogFragment.java */
/* renamed from: com.facebook.share.internal.f */
/* loaded from: classes.dex */
public class RunnableC0760f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ DeviceShareDialogFragment f9571a;

    public RunnableC0760f(DeviceShareDialogFragment deviceShareDialogFragment) {
        this.f9571a = deviceShareDialogFragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        Dialog dialog;
        dialog = this.f9571a.dialog;
        dialog.dismiss();
    }
}
