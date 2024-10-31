package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzbl implements Parcelable.Creator<zzbk> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbk createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        zzdj zzdjVar = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            if (SafeParcelReader.a(a2) != 1) {
                SafeParcelReader.F(parcel, a2);
            } else {
                zzdjVar = (zzdj) SafeParcelReader.a(parcel, a2, zzdj.CREATOR);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzbk(zzdjVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbk[] newArray(int i) {
        return new zzbk[i];
    }
}
