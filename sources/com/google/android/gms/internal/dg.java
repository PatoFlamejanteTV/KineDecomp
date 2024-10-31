package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;

/* loaded from: classes.dex */
class dg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzen f1500a;
    final /* synthetic */ AdRequestParcel b;
    final /* synthetic */ zzhi c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dg(zzhi zzhiVar, zzen zzenVar, AdRequestParcel adRequestParcel) {
        this.c = zzhiVar;
        this.f1500a = zzenVar;
        this.b = adRequestParcel;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        try {
            zzen zzenVar = this.f1500a;
            AdRequestParcel adRequestParcel = this.b;
            str2 = this.c.zzHi;
            zzenVar.zza(adRequestParcel, str2);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Fail to load ad from adapter.", e);
            zzhi zzhiVar = this.c;
            str = this.c.zzzj;
            zzhiVar.zzb(str, 0);
        }
    }
}
