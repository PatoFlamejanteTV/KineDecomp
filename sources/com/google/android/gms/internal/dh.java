package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;

/* loaded from: classes.dex */
class dh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzen f1501a;
    final /* synthetic */ AdRequestParcel b;
    final /* synthetic */ zzhl c;
    final /* synthetic */ zzhi d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(zzhi zzhiVar, zzen zzenVar, AdRequestParcel adRequestParcel, zzhl zzhlVar) {
        this.d = zzhiVar;
        this.f1501a = zzenVar;
        this.b = adRequestParcel;
        this.c = zzhlVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        Context context;
        String str3;
        String str4;
        try {
            zzen zzenVar = this.f1501a;
            context = this.d.mContext;
            com.google.android.gms.dynamic.zzd a2 = com.google.android.gms.dynamic.zze.a(context);
            AdRequestParcel adRequestParcel = this.b;
            str3 = this.d.zzGY;
            zzhl zzhlVar = this.c;
            str4 = this.d.zzHi;
            zzenVar.zza(a2, adRequestParcel, str3, zzhlVar, str4);
        } catch (RemoteException e) {
            StringBuilder append = new StringBuilder().append("Fail to initialize adapter ");
            str = this.d.zzzj;
            com.google.android.gms.ads.internal.util.client.zzb.d(append.append(str).toString(), e);
            zzhi zzhiVar = this.d;
            str2 = this.d.zzzj;
            zzhiVar.zzb(str2, 0);
        }
    }
}
