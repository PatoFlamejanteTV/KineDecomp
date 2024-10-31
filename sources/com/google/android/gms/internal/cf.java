package com.google.android.gms.internal;

import android.content.DialogInterface;

/* loaded from: classes.dex */
class cf implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzfb f1472a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(zzfb zzfbVar) {
        this.f1472a = zzfbVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1472a.zzak("Operation denied by user.");
    }
}
