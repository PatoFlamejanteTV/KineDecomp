package com.google.android.gms.internal.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzs implements Parcelable.Creator<zzr> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        int i2 = 0;
        boolean z = true;
        boolean z2 = false;
        int i3 = 0;
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
                    str2 = SafeParcelReader.p(parcel, a2);
                    break;
                case 6:
                    str3 = SafeParcelReader.p(parcel, a2);
                    break;
                case 7:
                    z = SafeParcelReader.t(parcel, a2);
                    break;
                case 8:
                    str4 = SafeParcelReader.p(parcel, a2);
                    break;
                case 9:
                    z2 = SafeParcelReader.t(parcel, a2);
                    break;
                case 10:
                    i3 = SafeParcelReader.A(parcel, a2);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzr(str, i, i2, str2, str3, z, str4, z2, i3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr[] newArray(int i) {
        return new zzr[i];
    }
}
