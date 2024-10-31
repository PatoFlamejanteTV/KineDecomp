package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public abstract class zae extends com.google.android.gms.internal.base.zab implements zad {
    public zae() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // com.google.android.gms.internal.base.zab
    protected boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 3) {
            a((ConnectionResult) com.google.android.gms.internal.base.zac.zaa(parcel, ConnectionResult.CREATOR), (zaa) com.google.android.gms.internal.base.zac.zaa(parcel, zaa.CREATOR));
        } else if (i == 4) {
            a((Status) com.google.android.gms.internal.base.zac.zaa(parcel, Status.CREATOR));
        } else if (i == 6) {
            b((Status) com.google.android.gms.internal.base.zac.zaa(parcel, Status.CREATOR));
        } else if (i == 7) {
            a((Status) com.google.android.gms.internal.base.zac.zaa(parcel, Status.CREATOR), (GoogleSignInAccount) com.google.android.gms.internal.base.zac.zaa(parcel, GoogleSignInAccount.CREATOR));
        } else {
            if (i != 8) {
                return false;
            }
            a((zaj) com.google.android.gms.internal.base.zac.zaa(parcel, zaj.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
