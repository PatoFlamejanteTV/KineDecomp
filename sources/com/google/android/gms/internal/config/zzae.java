package com.google.android.gms.internal.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzae implements Parcelable.Creator<zzad> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzad createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        DataHolder dataHolder = null;
        DataHolder dataHolder2 = null;
        long j = 0;
        int i = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 2) {
                i = SafeParcelReader.A(parcel, a2);
            } else if (a3 == 3) {
                dataHolder = (DataHolder) SafeParcelReader.a(parcel, a2, DataHolder.CREATOR);
            } else if (a3 == 4) {
                j = SafeParcelReader.C(parcel, a2);
            } else if (a3 != 5) {
                SafeParcelReader.F(parcel, a2);
            } else {
                dataHolder2 = (DataHolder) SafeParcelReader.a(parcel, a2, DataHolder.CREATOR);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzad(i, dataHolder, j, dataHolder2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzad[] newArray(int i) {
        return new zzad[i];
    }
}
