package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Ib implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzanx f11590a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ib(zzanx zzanxVar) {
        this.f11590a = zzanxVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Context context;
        Intent createIntent = this.f11590a.createIntent();
        com.google.android.gms.ads.internal.zzbv.e();
        context = this.f11590a.mContext;
        zzayh.zza(context, createIntent);
    }
}
