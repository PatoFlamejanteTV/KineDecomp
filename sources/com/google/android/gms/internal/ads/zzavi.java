package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzavi implements Parcelable.Creator<zzavh> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzavh createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        zzwb zzwbVar = null;
        String str = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 2) {
                zzwbVar = (zzwb) SafeParcelReader.a(parcel, a2, zzwb.CREATOR);
            } else if (a3 != 3) {
                SafeParcelReader.F(parcel, a2);
            } else {
                str = SafeParcelReader.p(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzavh(zzwbVar, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzavh[] newArray(int i) {
        return new zzavh[i];
    }
}
