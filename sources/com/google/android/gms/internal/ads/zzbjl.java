package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzbjl extends zzew implements zzbjk {
    public zzbjl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    @Override // com.google.android.gms.internal.ads.zzbjk
    public final zzbji zza(zzbjg zzbjgVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzbjgVar);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        zzbji zzbjiVar = (zzbji) zzey.zza(transactAndReadException, zzbji.CREATOR);
        transactAndReadException.recycle();
        return zzbjiVar;
    }
}
