package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class zan implements Parcelable.Creator<ResolveAccountResponse> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ResolveAccountResponse createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        IBinder iBinder = null;
        ConnectionResult connectionResult = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i = SafeParcelReader.A(parcel, a2);
            } else if (a3 == 2) {
                iBinder = SafeParcelReader.z(parcel, a2);
            } else if (a3 == 3) {
                connectionResult = (ConnectionResult) SafeParcelReader.a(parcel, a2, ConnectionResult.CREATOR);
            } else if (a3 == 4) {
                z = SafeParcelReader.t(parcel, a2);
            } else if (a3 != 5) {
                SafeParcelReader.F(parcel, a2);
            } else {
                z2 = SafeParcelReader.t(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new ResolveAccountResponse(i, iBinder, connectionResult, z, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ResolveAccountResponse[] newArray(int i) {
        return new ResolveAccountResponse[i];
    }
}
