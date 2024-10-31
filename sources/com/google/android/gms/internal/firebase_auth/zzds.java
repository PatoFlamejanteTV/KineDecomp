package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzds implements Parcelable.Creator<zzdr> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdr createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
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
                    str5 = SafeParcelReader.p(parcel, a2);
                    break;
                case 7:
                    str6 = SafeParcelReader.p(parcel, a2);
                    break;
                case 8:
                    str7 = SafeParcelReader.p(parcel, a2);
                    break;
                case 9:
                    str8 = SafeParcelReader.p(parcel, a2);
                    break;
                case 10:
                    z = SafeParcelReader.t(parcel, a2);
                    break;
                case 11:
                    z2 = SafeParcelReader.t(parcel, a2);
                    break;
                case 12:
                    str9 = SafeParcelReader.p(parcel, a2);
                    break;
                case 13:
                    str10 = SafeParcelReader.p(parcel, a2);
                    break;
                case 14:
                    str11 = SafeParcelReader.p(parcel, a2);
                    break;
                case 15:
                    str12 = SafeParcelReader.p(parcel, a2);
                    break;
                case 16:
                    z3 = SafeParcelReader.t(parcel, a2);
                    break;
                case 17:
                    str13 = SafeParcelReader.p(parcel, a2);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzdr(str, str2, str3, str4, str5, str6, str7, str8, z, z2, str9, str10, str11, str12, z3, str13);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdr[] newArray(int i) {
        return new zzdr[i];
    }
}
