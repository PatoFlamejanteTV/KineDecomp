package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzant implements Parcelable.Creator<zzans> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzans createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i = SafeParcelReader.A(parcel, a2);
            } else if (a3 == 2) {
                i2 = SafeParcelReader.A(parcel, a2);
            } else if (a3 != 3) {
                SafeParcelReader.F(parcel, a2);
            } else {
                i3 = SafeParcelReader.A(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzans(i, i2, i3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzans[] newArray(int i) {
        return new zzans[i];
    }
}
