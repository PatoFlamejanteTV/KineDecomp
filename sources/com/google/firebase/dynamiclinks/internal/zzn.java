package com.google.firebase.dynamiclinks.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public abstract class zzn extends com.google.android.gms.internal.firebase_dynamic_links.zzb implements zzm {
    public zzn() {
        super("com.google.firebase.dynamiclinks.internal.IDynamicLinksCallbacks");
    }

    @Override // com.google.android.gms.internal.firebase_dynamic_links.zzb
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            a((Status) com.google.android.gms.internal.firebase_dynamic_links.zzc.zza(parcel, Status.CREATOR), (zza) com.google.android.gms.internal.firebase_dynamic_links.zzc.zza(parcel, zza.CREATOR));
        } else {
            if (i != 2) {
                return false;
            }
            a((Status) com.google.android.gms.internal.firebase_dynamic_links.zzc.zza(parcel, Status.CREATOR), (zzq) com.google.android.gms.internal.firebase_dynamic_links.zzc.zza(parcel, zzq.CREATOR));
        }
        return true;
    }
}
