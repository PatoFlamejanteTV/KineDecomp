package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzg implements Parcelable.Creator<zzf> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzf createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        zzl zzlVar = null;
        zzd zzdVar = null;
        com.google.firebase.auth.zzd zzdVar2 = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                zzlVar = (zzl) SafeParcelReader.a(parcel, a2, zzl.CREATOR);
            } else if (a3 == 2) {
                zzdVar = (zzd) SafeParcelReader.a(parcel, a2, zzd.CREATOR);
            } else if (a3 != 3) {
                SafeParcelReader.F(parcel, a2);
            } else {
                zzdVar2 = (com.google.firebase.auth.zzd) SafeParcelReader.a(parcel, a2, com.google.firebase.auth.zzd.CREATOR);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzf(zzlVar, zzdVar, zzdVar2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzf[] newArray(int i) {
        return new zzf[i];
    }
}
