package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zzc implements Parcelable.Creator<Credential> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Credential createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        Uri uri = null;
        ArrayList arrayList = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    str = SafeParcelReader.p(parcel, a2);
                    break;
                case 2:
                    str2 = SafeParcelReader.p(parcel, a2);
                    break;
                case 3:
                    uri = (Uri) SafeParcelReader.a(parcel, a2, Uri.CREATOR);
                    break;
                case 4:
                    arrayList = SafeParcelReader.c(parcel, a2, IdToken.CREATOR);
                    break;
                case 5:
                    str3 = SafeParcelReader.p(parcel, a2);
                    break;
                case 6:
                    str4 = SafeParcelReader.p(parcel, a2);
                    break;
                case 7:
                case 8:
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
                case 9:
                    str5 = SafeParcelReader.p(parcel, a2);
                    break;
                case 10:
                    str6 = SafeParcelReader.p(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new Credential(str, str2, uri, arrayList, str3, str4, str5, str6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Credential[] newArray(int i) {
        return new Credential[i];
    }
}
