package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;

/* loaded from: classes.dex */
class db implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdRequestInfoParcel f1495a;
    final /* synthetic */ com.google.android.gms.ads.internal.request.zzk b;
    final /* synthetic */ zzgt c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(zzgt zzgtVar, AdRequestInfoParcel adRequestInfoParcel, com.google.android.gms.ads.internal.request.zzk zzkVar) {
        this.c = zzgtVar;
        this.f1495a = adRequestInfoParcel;
        this.b = zzkVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AdResponseParcel adResponseParcel;
        try {
            adResponseParcel = this.c.zze(this.f1495a);
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzp.h().zzc(e, true);
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not fetch ad response due to an Exception.", e);
            adResponseParcel = null;
        }
        if (adResponseParcel == null) {
            adResponseParcel = new AdResponseParcel(0);
        }
        try {
            this.b.a(adResponseParcel);
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Fail to forward ad response.", e2);
        }
    }
}
