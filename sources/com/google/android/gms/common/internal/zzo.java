package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;

/* loaded from: classes.dex */
public final class zzo extends zza implements zzm {
    public zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.zzm
    public final boolean a(com.google.android.gms.common.zzk zzkVar, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zza(zza, zzkVar);
        com.google.android.gms.internal.common.zzc.zza(zza, iObjectWrapper);
        Parcel zza2 = zza(5, zza);
        boolean zza3 = com.google.android.gms.internal.common.zzc.zza(zza2);
        zza2.recycle();
        return zza3;
    }
}
