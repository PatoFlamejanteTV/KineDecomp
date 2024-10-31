package com.google.firebase.auth.api.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzb;
import com.google.android.gms.internal.firebase_auth.zzc;
import com.google.android.gms.internal.firebase_auth.zzcg;
import com.google.android.gms.internal.firebase_auth.zzcj;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdg;
import com.google.firebase.auth.PhoneAuthCredential;

/* loaded from: classes2.dex */
public abstract class zzdy extends zzb implements zzdx {
    public zzdy() {
        super("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzb
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                a((zzcz) zzc.zza(parcel, zzcz.CREATOR));
                return true;
            case 2:
                a((zzcz) zzc.zza(parcel, zzcz.CREATOR), (zzct) zzc.zza(parcel, zzct.CREATOR));
                return true;
            case 3:
                a((zzcj) zzc.zza(parcel, zzcj.CREATOR));
                return true;
            case 4:
                a((zzdg) zzc.zza(parcel, zzdg.CREATOR));
                return true;
            case 5:
                onFailure((Status) zzc.zza(parcel, Status.CREATOR));
                return true;
            case 6:
                zzde();
                return true;
            case 7:
                o();
                return true;
            case 8:
                e(parcel.readString());
                return true;
            case 9:
                c(parcel.readString());
                return true;
            case 10:
                a((PhoneAuthCredential) zzc.zza(parcel, PhoneAuthCredential.CREATOR));
                return true;
            case 11:
                d(parcel.readString());
                return true;
            case 12:
                a((Status) zzc.zza(parcel, Status.CREATOR), (PhoneAuthCredential) zzc.zza(parcel, PhoneAuthCredential.CREATOR));
                return true;
            case 13:
                p();
                return true;
            case 14:
                a((zzcg) zzc.zza(parcel, zzcg.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
