package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzbbj implements Parcelable.Creator<zzbbi> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbbi createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 2) {
                str = SafeParcelReader.p(parcel, a2);
            } else if (a3 == 3) {
                i = SafeParcelReader.A(parcel, a2);
            } else if (a3 == 4) {
                i2 = SafeParcelReader.A(parcel, a2);
            } else if (a3 == 5) {
                z = SafeParcelReader.t(parcel, a2);
            } else if (a3 != 6) {
                SafeParcelReader.F(parcel, a2);
            } else {
                z2 = SafeParcelReader.t(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzbbi(str, i, i2, z, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbbi[] newArray(int i) {
        return new zzbbi[i];
    }
}
