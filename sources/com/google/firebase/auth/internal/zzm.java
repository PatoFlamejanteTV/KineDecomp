package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.firebase_auth.zzcz;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class zzm implements Parcelable.Creator<zzl> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzl createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        zzcz zzczVar = null;
        zzh zzhVar = null;
        String str = null;
        String str2 = null;
        ArrayList arrayList = null;
        ArrayList<String> arrayList2 = null;
        String str3 = null;
        Boolean bool = null;
        zzn zznVar = null;
        com.google.firebase.auth.zzd zzdVar = null;
        boolean z = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    zzczVar = (zzcz) SafeParcelReader.a(parcel, a2, zzcz.CREATOR);
                    break;
                case 2:
                    zzhVar = (zzh) SafeParcelReader.a(parcel, a2, zzh.CREATOR);
                    break;
                case 3:
                    str = SafeParcelReader.p(parcel, a2);
                    break;
                case 4:
                    str2 = SafeParcelReader.p(parcel, a2);
                    break;
                case 5:
                    arrayList = SafeParcelReader.c(parcel, a2, zzh.CREATOR);
                    break;
                case 6:
                    arrayList2 = SafeParcelReader.r(parcel, a2);
                    break;
                case 7:
                    str3 = SafeParcelReader.p(parcel, a2);
                    break;
                case 8:
                    bool = SafeParcelReader.u(parcel, a2);
                    break;
                case 9:
                    zznVar = (zzn) SafeParcelReader.a(parcel, a2, zzn.CREATOR);
                    break;
                case 10:
                    z = SafeParcelReader.t(parcel, a2);
                    break;
                case 11:
                    zzdVar = (com.google.firebase.auth.zzd) SafeParcelReader.a(parcel, a2, com.google.firebase.auth.zzd.CREATOR);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzl(zzczVar, zzhVar, str, str2, arrayList, arrayList2, str3, bool, zznVar, z, zzdVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzl[] newArray(int i) {
        return new zzl[i];
    }
}
