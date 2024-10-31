package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzc implements Parcelable.Creator<Configuration> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Configuration createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        zzi[] zziVarArr = null;
        int i = 0;
        String[] strArr = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 2) {
                i = SafeParcelReader.A(parcel, a2);
            } else if (a3 == 3) {
                zziVarArr = (zzi[]) SafeParcelReader.b(parcel, a2, zzi.CREATOR);
            } else if (a3 != 4) {
                SafeParcelReader.F(parcel, a2);
            } else {
                strArr = SafeParcelReader.q(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new Configuration(i, zziVarArr, strArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Configuration[] newArray(int i) {
        return new Configuration[i];
    }
}
