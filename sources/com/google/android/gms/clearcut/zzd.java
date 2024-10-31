package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class zzd implements Parcelable.Creator<zzc> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzc createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        long j = 0;
        long j2 = 0;
        boolean z = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                z = SafeParcelReader.t(parcel, a2);
            } else if (a3 == 2) {
                j2 = SafeParcelReader.C(parcel, a2);
            } else if (a3 != 3) {
                SafeParcelReader.F(parcel, a2);
            } else {
                j = SafeParcelReader.C(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzc(z, j, j2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzc[] newArray(int i) {
        return new zzc[i];
    }
}
