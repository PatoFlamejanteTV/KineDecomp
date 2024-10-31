package com.google.android.gms.internal.config;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzai extends zza implements zzah {
    public zzai(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.config.internal.IConfigService");
    }

    @Override // com.google.android.gms.internal.config.zzah
    public final void zza(zzaf zzafVar, zzab zzabVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, zzafVar);
        zzc.zza(zza, zzabVar);
        zza(8, zza);
    }
}
