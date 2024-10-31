package com.google.android.gms.internal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dv implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1515a;
    final /* synthetic */ zzif b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dv(zzif zzifVar, String str) {
        this.b = zzifVar;
        this.f1515a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Context context;
        zzid e = com.google.android.gms.ads.internal.zzp.e();
        context = this.b.mContext;
        e.zzb(context, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", this.f1515a), "Share via"));
    }
}
