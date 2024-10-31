package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzaga implements Parcelable.Creator<zzafz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzafz createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        int i = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            if (SafeParcelReader.a(a2) != 1) {
                SafeParcelReader.F(parcel, a2);
            } else {
                i = SafeParcelReader.A(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzafz(i);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzafz[] newArray(int i) {
        return new zzafz[i];
    }
}
