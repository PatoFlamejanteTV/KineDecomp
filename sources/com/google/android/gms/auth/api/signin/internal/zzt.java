package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public abstract class zzt extends com.google.android.gms.internal.p000authapi.zzd implements zzs {
    public zzt() {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    @Override // com.google.android.gms.internal.p000authapi.zzd
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 101:
                a((GoogleSignInAccount) com.google.android.gms.internal.p000authapi.zze.zzc(parcel, GoogleSignInAccount.CREATOR), (Status) com.google.android.gms.internal.p000authapi.zze.zzc(parcel, Status.CREATOR));
                break;
            case 102:
                c((Status) com.google.android.gms.internal.p000authapi.zze.zzc(parcel, Status.CREATOR));
                break;
            case 103:
                d((Status) com.google.android.gms.internal.p000authapi.zze.zzc(parcel, Status.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
