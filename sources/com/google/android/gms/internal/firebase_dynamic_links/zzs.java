package com.google.android.gms.internal.firebase_dynamic_links;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzs extends zza implements zzr {
    public zzs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.appinvite.internal.IAppInviteService");
    }

    @Override // com.google.android.gms.internal.firebase_dynamic_links.zzr
    public final void zza(zzp zzpVar, String str) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, zzpVar);
        zza.writeString(str);
        zza(1, zza);
    }

    @Override // com.google.android.gms.internal.firebase_dynamic_links.zzr
    public final void zzb(zzp zzpVar, String str) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, zzpVar);
        zza.writeString(str);
        zza(2, zza);
    }

    @Override // com.google.android.gms.internal.firebase_dynamic_links.zzr
    public final void zza(zzp zzpVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, zzpVar);
        zza(3, zza);
    }
}
