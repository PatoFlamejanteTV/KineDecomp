package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzfw implements Parcelable.Creator<zzfv> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfv createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        Long l = null;
        Float f2 = null;
        String str2 = null;
        String str3 = null;
        Double d2 = null;
        long j = 0;
        int i = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    i = SafeParcelReader.A(parcel, a2);
                    break;
                case 2:
                    str = SafeParcelReader.p(parcel, a2);
                    break;
                case 3:
                    j = SafeParcelReader.C(parcel, a2);
                    break;
                case 4:
                    l = SafeParcelReader.D(parcel, a2);
                    break;
                case 5:
                    f2 = SafeParcelReader.y(parcel, a2);
                    break;
                case 6:
                    str2 = SafeParcelReader.p(parcel, a2);
                    break;
                case 7:
                    str3 = SafeParcelReader.p(parcel, a2);
                    break;
                case 8:
                    d2 = SafeParcelReader.w(parcel, a2);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzfv(i, str, j, l, f2, str2, str3, d2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfv[] newArray(int i) {
        return new zzfv[i];
    }
}
