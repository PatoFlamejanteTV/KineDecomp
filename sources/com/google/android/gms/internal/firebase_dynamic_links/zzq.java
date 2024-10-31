package com.google.android.gms.internal.firebase_dynamic_links;

import android.content.Intent;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public abstract class zzq extends zzb implements zzp {
    public zzq() {
        super("com.google.android.gms.appinvite.internal.IAppInviteCallbacks");
    }

    @Override // com.google.android.gms.internal.firebase_dynamic_links.zzb
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zza((Status) zzc.zza(parcel, Status.CREATOR));
        } else {
            if (i != 2) {
                return false;
            }
            zza((Status) zzc.zza(parcel, Status.CREATOR), (Intent) zzc.zza(parcel, Intent.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
