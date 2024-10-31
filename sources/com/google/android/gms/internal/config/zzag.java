package com.google.android.gms.internal.config;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public abstract class zzag extends zzb implements zzaf {
    public zzag() {
        super("com.google.android.gms.config.internal.IConfigCallbacks");
    }

    @Override // com.google.android.gms.internal.config.zzb
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zza((Status) zzc.zza(parcel, Status.CREATOR), parcel.createByteArray());
        } else if (i == 2) {
            zza((Status) zzc.zza(parcel, Status.CREATOR), zzc.zza(parcel));
        } else if (i == 3) {
            zza((Status) zzc.zza(parcel, Status.CREATOR));
        } else {
            if (i != 4) {
                return false;
            }
            zza((Status) zzc.zza(parcel, Status.CREATOR), (zzad) zzc.zza(parcel, zzad.CREATOR));
        }
        return true;
    }
}
