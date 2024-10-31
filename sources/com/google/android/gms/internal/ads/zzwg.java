package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzwg implements Parcelable.Creator<zzwf> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzwf createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        zzwf[] zzwfVarArr = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 2:
                    str = SafeParcelReader.p(parcel, a2);
                    break;
                case 3:
                    i = SafeParcelReader.A(parcel, a2);
                    break;
                case 4:
                    i2 = SafeParcelReader.A(parcel, a2);
                    break;
                case 5:
                    z = SafeParcelReader.t(parcel, a2);
                    break;
                case 6:
                    i3 = SafeParcelReader.A(parcel, a2);
                    break;
                case 7:
                    i4 = SafeParcelReader.A(parcel, a2);
                    break;
                case 8:
                    zzwfVarArr = (zzwf[]) SafeParcelReader.b(parcel, a2, zzwf.CREATOR);
                    break;
                case 9:
                    z2 = SafeParcelReader.t(parcel, a2);
                    break;
                case 10:
                    z3 = SafeParcelReader.t(parcel, a2);
                    break;
                case 11:
                    z4 = SafeParcelReader.t(parcel, a2);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzwf(str, i, i2, z, i3, i4, zzwfVarArr, z2, z3, z4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzwf[] newArray(int i) {
        return new zzwf[i];
    }
}
