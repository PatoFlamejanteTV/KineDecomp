package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class zzd implements Parcelable.Creator<GetServiceRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GetServiceRequest createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        Feature[] featureArr = null;
        Feature[] featureArr2 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    i = SafeParcelReader.A(parcel, a2);
                    break;
                case 2:
                    i2 = SafeParcelReader.A(parcel, a2);
                    break;
                case 3:
                    i3 = SafeParcelReader.A(parcel, a2);
                    break;
                case 4:
                    str = SafeParcelReader.p(parcel, a2);
                    break;
                case 5:
                    iBinder = SafeParcelReader.z(parcel, a2);
                    break;
                case 6:
                    scopeArr = (Scope[]) SafeParcelReader.b(parcel, a2, Scope.CREATOR);
                    break;
                case 7:
                    bundle = SafeParcelReader.f(parcel, a2);
                    break;
                case 8:
                    account = (Account) SafeParcelReader.a(parcel, a2, Account.CREATOR);
                    break;
                case 9:
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
                case 10:
                    featureArr = (Feature[]) SafeParcelReader.b(parcel, a2, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) SafeParcelReader.b(parcel, a2, Feature.CREATOR);
                    break;
                case 12:
                    z = SafeParcelReader.t(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new GetServiceRequest(i, i2, i3, str, iBinder, scopeArr, bundle, account, featureArr, featureArr2, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GetServiceRequest[] newArray(int i) {
        return new GetServiceRequest[i];
    }
}
