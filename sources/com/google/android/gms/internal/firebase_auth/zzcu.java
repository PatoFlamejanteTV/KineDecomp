package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzcu implements Parcelable.Creator<zzct> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzct createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        long j = 0;
        long j2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        zzdd zzddVar = null;
        String str5 = null;
        String str6 = null;
        com.google.firebase.auth.zzd zzdVar = null;
        boolean z = false;
        boolean z2 = false;
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
                    z = SafeParcelReader.t(parcel, a2);
                    break;
                case 5:
                    str3 = SafeParcelReader.p(parcel, a2);
                    break;
                case 6:
                    str4 = SafeParcelReader.p(parcel, a2);
                    break;
                case 7:
                    zzddVar = (zzdd) SafeParcelReader.a(parcel, a2, zzdd.CREATOR);
                    break;
                case 8:
                    str5 = SafeParcelReader.p(parcel, a2);
                    break;
                case 9:
                    str6 = SafeParcelReader.p(parcel, a2);
                    break;
                case 10:
                    j = SafeParcelReader.C(parcel, a2);
                    break;
                case 11:
                    j2 = SafeParcelReader.C(parcel, a2);
                    break;
                case 12:
                    z2 = SafeParcelReader.t(parcel, a2);
                    break;
                case 13:
                    zzdVar = (com.google.firebase.auth.zzd) SafeParcelReader.a(parcel, a2, com.google.firebase.auth.zzd.CREATOR);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzct(str, str2, z, str3, str4, zzddVar, str5, str6, j, j2, z2, zzdVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzct[] newArray(int i) {
        return new zzct[i];
    }
}
