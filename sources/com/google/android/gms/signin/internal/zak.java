package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zak implements Parcelable.Creator<zaj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zaj createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        ConnectionResult connectionResult = null;
        int i = 0;
        ResolveAccountResponse resolveAccountResponse = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i = SafeParcelReader.A(parcel, a2);
            } else if (a3 == 2) {
                connectionResult = (ConnectionResult) SafeParcelReader.a(parcel, a2, ConnectionResult.CREATOR);
            } else if (a3 != 3) {
                SafeParcelReader.F(parcel, a2);
            } else {
                resolveAccountResponse = (ResolveAccountResponse) SafeParcelReader.a(parcel, a2, ResolveAccountResponse.CREATOR);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zaj(i, connectionResult, resolveAccountResponse);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zaj[] newArray(int i) {
        return new zaj[i];
    }
}
