package com.nexstreaming.kinemaster.ui.share;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareIntentActivity.java */
/* loaded from: classes.dex */
public class ax implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareIntentActivity f4308a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(ShareIntentActivity shareIntentActivity) {
        this.f4308a = shareIntentActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f4308a.finish();
    }
}
