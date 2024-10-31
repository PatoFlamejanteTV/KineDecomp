package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzah implements Parcelable.Creator<zzag> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzag createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        zzad zzadVar = null;
        String str2 = null;
        long j = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 2) {
                str = SafeParcelReader.p(parcel, a2);
            } else if (a3 == 3) {
                zzadVar = (zzad) SafeParcelReader.a(parcel, a2, zzad.CREATOR);
            } else if (a3 == 4) {
                str2 = SafeParcelReader.p(parcel, a2);
            } else if (a3 != 5) {
                SafeParcelReader.F(parcel, a2);
            } else {
                j = SafeParcelReader.C(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzag(str, zzadVar, str2, j);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzag[] newArray(int i) {
        return new zzag[i];
    }
}
