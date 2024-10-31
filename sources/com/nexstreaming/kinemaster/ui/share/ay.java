package com.nexstreaming.kinemaster.ui.share;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareIntentActivity.java */
/* loaded from: classes.dex */
public class ay implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareIntentActivity f4309a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ShareIntentActivity shareIntentActivity) {
        this.f4309a = shareIntentActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.f4309a.finish();
    }
}
