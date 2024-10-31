package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public abstract class zzxe extends zzex implements zzxd {
    public zzxe() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // com.google.android.gms.internal.ads.zzex
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzd((zzwb) zzey.zza(parcel, zzwb.CREATOR));
            parcel2.writeNoException();
        } else if (i == 2) {
            String mediationAdapterClassName = getMediationAdapterClassName();
            parcel2.writeNoException();
            parcel2.writeString(mediationAdapterClassName);
        } else if (i == 3) {
            boolean isLoading = isLoading();
            parcel2.writeNoException();
            zzey.writeBoolean(parcel2, isLoading);
        } else if (i == 4) {
            String zzje = zzje();
            parcel2.writeNoException();
            parcel2.writeString(zzje);
        } else {
            if (i != 5) {
                return false;
            }
            zza((zzwb) zzey.zza(parcel, zzwb.CREATOR), parcel.readInt());
            parcel2.writeNoException();
        }
        return true;
    }
}
