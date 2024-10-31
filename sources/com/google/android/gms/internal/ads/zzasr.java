package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public abstract class zzasr extends zzex implements zzasq {
    public zzasr() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzex
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            zzast zzastVar = null;
            zzasw zzaswVar = null;
            zzasw zzaswVar2 = null;
            if (i == 2) {
                zzasi zzasiVar = (zzasi) zzey.zza(parcel, zzasi.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    if (queryLocalInterface instanceof zzast) {
                        zzastVar = (zzast) queryLocalInterface;
                    } else {
                        zzastVar = new zzasv(readStrongBinder);
                    }
                }
                zza(zzasiVar, zzastVar);
                parcel2.writeNoException();
            } else if (i == 4) {
                zzatb zzatbVar = (zzatb) zzey.zza(parcel, zzatb.CREATOR);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (queryLocalInterface2 instanceof zzasw) {
                        zzaswVar2 = (zzasw) queryLocalInterface2;
                    } else {
                        zzaswVar2 = new zzasx(readStrongBinder2);
                    }
                }
                zza(zzatbVar, zzaswVar2);
                parcel2.writeNoException();
            } else {
                if (i != 5) {
                    return false;
                }
                zzatb zzatbVar2 = (zzatb) zzey.zza(parcel, zzatb.CREATOR);
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (queryLocalInterface3 instanceof zzasw) {
                        zzaswVar = (zzasw) queryLocalInterface3;
                    } else {
                        zzaswVar = new zzasx(readStrongBinder3);
                    }
                }
                zzb(zzatbVar2, zzaswVar);
                parcel2.writeNoException();
            }
        } else {
            zzasm zzb = zzb((zzasi) zzey.zza(parcel, zzasi.CREATOR));
            parcel2.writeNoException();
            zzey.zzb(parcel2, zzb);
        }
        return true;
    }
}
