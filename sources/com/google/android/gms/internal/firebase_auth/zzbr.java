package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzbr implements Parcelable.Creator<zzbq> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbq createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        zzdr zzdrVar = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            if (SafeParcelReader.a(a2) != 1) {
                SafeParcelReader.F(parcel, a2);
            } else {
                zzdrVar = (zzdr) SafeParcelReader.a(parcel, a2, zzdr.CREATOR);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzbq(zzdrVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbq[] newArray(int i) {
        return new zzbq[i];
    }
}
