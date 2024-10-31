package com.google.android.gms.internal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzfb f1471a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(zzfb zzfbVar) {
        this.f1471a = zzfbVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Context context;
        Intent createIntent = this.f1471a.createIntent();
        zzid e = com.google.android.gms.ads.internal.zzp.e();
        context = this.f1471a.mContext;
        e.zzb(context, createIntent);
    }
}
