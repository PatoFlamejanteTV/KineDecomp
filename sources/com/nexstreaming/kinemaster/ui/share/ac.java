package com.nexstreaming.kinemaster.ui.share;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareActivity.java */
/* loaded from: classes.dex */
public class ac implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareActivity f4287a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ShareActivity shareActivity) {
        this.f4287a = shareActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4287a.w();
    }
}
