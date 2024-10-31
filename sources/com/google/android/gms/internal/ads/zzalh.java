package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public abstract class zzalh extends zzex implements zzalg {
    public zzalh() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzalg zzu(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        if (queryLocalInterface instanceof zzalg) {
            return (zzalg) queryLocalInterface;
        }
        return new zzali(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzex
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzalj zzcp = zzcp(parcel.readString());
            parcel2.writeNoException();
            zzey.zza(parcel2, zzcp);
        } else if (i == 2) {
            boolean zzcq = zzcq(parcel.readString());
            parcel2.writeNoException();
            zzey.writeBoolean(parcel2, zzcq);
        } else {
            if (i != 3) {
                return false;
            }
            zzang zzct = zzct(parcel.readString());
            parcel2.writeNoException();
            zzey.zza(parcel2, zzct);
        }
        return true;
    }
}
