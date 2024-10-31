package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.internal.zzfw;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzf f609a;
    final /* synthetic */ Intent b;
    final /* synthetic */ zzc c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(zzc zzcVar, zzf zzfVar, Intent intent) {
        this.c = zzcVar;
        this.f609a = zzfVar;
        this.b = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzk zzkVar;
        zzfw zzfwVar;
        Context context;
        zzfw zzfwVar2;
        Context context2;
        try {
            zzkVar = this.c.h;
            if (zzkVar.a(this.f609a.b, -1, this.b)) {
                zzfwVar2 = this.c.d;
                context2 = this.c.c;
                zzfwVar2.zza(new zzg(context2, this.f609a.c, true, -1, this.b, this.f609a));
            } else {
                zzfwVar = this.c.d;
                context = this.c.c;
                zzfwVar.zza(new zzg(context, this.f609a.c, false, -1, this.b, this.f609a));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Fail to verify and dispatch pending transaction");
        }
    }
}
