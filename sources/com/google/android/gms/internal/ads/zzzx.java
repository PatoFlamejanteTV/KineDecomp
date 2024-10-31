package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzzx implements Parcelable.Creator<zzzw> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzzw createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 2) {
                z = SafeParcelReader.t(parcel, a2);
            } else if (a3 == 3) {
                z2 = SafeParcelReader.t(parcel, a2);
            } else if (a3 != 4) {
                SafeParcelReader.F(parcel, a2);
            } else {
                z3 = SafeParcelReader.t(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzzw(z, z2, z3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzzw[] newArray(int i) {
        return new zzzw[i];
    }
}
