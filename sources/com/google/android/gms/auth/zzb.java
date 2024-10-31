package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class zzb implements Parcelable.Creator<AccountChangeEventsRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AccountChangeEventsRequest createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        int i = 0;
        String str = null;
        Account account = null;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i = SafeParcelReader.A(parcel, a2);
            } else if (a3 == 2) {
                i2 = SafeParcelReader.A(parcel, a2);
            } else if (a3 == 3) {
                str = SafeParcelReader.p(parcel, a2);
            } else if (a3 != 4) {
                SafeParcelReader.F(parcel, a2);
            } else {
                account = (Account) SafeParcelReader.a(parcel, a2, Account.CREATOR);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new AccountChangeEventsRequest(i, i2, str, account);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AccountChangeEventsRequest[] newArray(int i) {
        return new AccountChangeEventsRequest[i];
    }
}
