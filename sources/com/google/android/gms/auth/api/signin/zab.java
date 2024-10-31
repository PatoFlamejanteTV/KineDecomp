package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zab implements Parcelable.Creator<GoogleSignInAccount> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        ArrayList arrayList = null;
        String str7 = null;
        String str8 = null;
        long j = 0;
        int i = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    i = SafeParcelReader.A(parcel, a2);
                    break;
                case 2:
                    str = SafeParcelReader.p(parcel, a2);
                    break;
                case 3:
                    str2 = SafeParcelReader.p(parcel, a2);
                    break;
                case 4:
                    str3 = SafeParcelReader.p(parcel, a2);
                    break;
                case 5:
                    str4 = SafeParcelReader.p(parcel, a2);
                    break;
                case 6:
                    uri = (Uri) SafeParcelReader.a(parcel, a2, Uri.CREATOR);
                    break;
                case 7:
                    str5 = SafeParcelReader.p(parcel, a2);
                    break;
                case 8:
                    j = SafeParcelReader.C(parcel, a2);
                    break;
                case 9:
                    str6 = SafeParcelReader.p(parcel, a2);
                    break;
                case 10:
                    arrayList = SafeParcelReader.c(parcel, a2, Scope.CREATOR);
                    break;
                case 11:
                    str7 = SafeParcelReader.p(parcel, a2);
                    break;
                case 12:
                    str8 = SafeParcelReader.p(parcel, a2);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, arrayList, str7, str8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
