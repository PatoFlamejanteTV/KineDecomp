package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class zzar implements Parcelable.Creator<zzaq> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaq createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f2 = 0.0f;
        int i = 0;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 2:
                    z = SafeParcelReader.t(parcel, a2);
                    break;
                case 3:
                    z2 = SafeParcelReader.t(parcel, a2);
                    break;
                case 4:
                    str = SafeParcelReader.p(parcel, a2);
                    break;
                case 5:
                    z3 = SafeParcelReader.t(parcel, a2);
                    break;
                case 6:
                    f2 = SafeParcelReader.x(parcel, a2);
                    break;
                case 7:
                    i = SafeParcelReader.A(parcel, a2);
                    break;
                case 8:
                    z4 = SafeParcelReader.t(parcel, a2);
                    break;
                case 9:
                    z5 = SafeParcelReader.t(parcel, a2);
                    break;
                case 10:
                    z6 = SafeParcelReader.t(parcel, a2);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzaq(z, z2, str, z3, f2, i, z4, z5, z6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaq[] newArray(int i) {
        return new zzaq[i];
    }
}
