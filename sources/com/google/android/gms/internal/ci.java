package com.google.android.gms.internal;

import android.content.DialogInterface;

/* loaded from: classes.dex */
class ci implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzfe f1475a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(zzfe zzfeVar) {
        this.f1475a = zzfeVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1475a.zzak("User canceled the download.");
    }
}
