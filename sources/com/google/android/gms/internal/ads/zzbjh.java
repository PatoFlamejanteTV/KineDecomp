package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzbjh implements Parcelable.Creator<zzbjg> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbjg createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i = SafeParcelReader.A(parcel, a2);
            } else if (a3 == 2) {
                str = SafeParcelReader.p(parcel, a2);
            } else if (a3 != 3) {
                SafeParcelReader.F(parcel, a2);
            } else {
                str2 = SafeParcelReader.p(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzbjg(i, str, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbjg[] newArray(int i) {
        return new zzbjg[i];
    }
}
