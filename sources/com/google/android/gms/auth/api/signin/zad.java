package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zad implements Parcelable.Creator<GoogleSignInOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptions createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        ArrayList arrayList = null;
        Account account = null;
        String str = null;
        String str2 = null;
        ArrayList arrayList2 = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    i = SafeParcelReader.A(parcel, a2);
                    break;
                case 2:
                    arrayList = SafeParcelReader.c(parcel, a2, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) SafeParcelReader.a(parcel, a2, Account.CREATOR);
                    break;
                case 4:
                    z = SafeParcelReader.t(parcel, a2);
                    break;
                case 5:
                    z2 = SafeParcelReader.t(parcel, a2);
                    break;
                case 6:
                    z3 = SafeParcelReader.t(parcel, a2);
                    break;
                case 7:
                    str = SafeParcelReader.p(parcel, a2);
                    break;
                case 8:
                    str2 = SafeParcelReader.p(parcel, a2);
                    break;
                case 9:
                    arrayList2 = SafeParcelReader.c(parcel, a2, GoogleSignInOptionsExtensionParcelable.CREATOR);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new GoogleSignInOptions(i, (ArrayList<Scope>) arrayList, account, z, z2, z3, str, str2, (ArrayList<GoogleSignInOptionsExtensionParcelable>) arrayList2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptions[] newArray(int i) {
        return new GoogleSignInOptions[i];
    }
}
