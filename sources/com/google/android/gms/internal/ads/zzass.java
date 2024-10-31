package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzass extends zzew implements zzasq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzass(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzasq
    public final void zza(zzasi zzasiVar, zzast zzastVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzasiVar);
        zzey.zza(obtainAndWriteInterfaceToken, zzastVar);
        zza(2, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzasq
    public final zzasm zzb(zzasi zzasiVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzasiVar);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        zzasm zzasmVar = (zzasm) zzey.zza(transactAndReadException, zzasm.CREATOR);
        transactAndReadException.recycle();
        return zzasmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzasq
    public final void zza(zzatb zzatbVar, zzasw zzaswVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzatbVar);
        zzey.zza(obtainAndWriteInterfaceToken, zzaswVar);
        zza(4, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzasq
    public final void zzb(zzatb zzatbVar, zzasw zzaswVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzatbVar);
        zzey.zza(obtainAndWriteInterfaceToken, zzaswVar);
        zza(5, obtainAndWriteInterfaceToken);
    }
}
