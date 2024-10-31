package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzda implements Parcelable.Creator<zzcz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcz createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        Long l = null;
        String str3 = null;
        Long l2 = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 2) {
                str = SafeParcelReader.p(parcel, a2);
            } else if (a3 == 3) {
                str2 = SafeParcelReader.p(parcel, a2);
            } else if (a3 == 4) {
                l = SafeParcelReader.D(parcel, a2);
            } else if (a3 == 5) {
                str3 = SafeParcelReader.p(parcel, a2);
            } else if (a3 != 6) {
                SafeParcelReader.F(parcel, a2);
            } else {
                l2 = SafeParcelReader.D(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzcz(str, str2, l, str3, l2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcz[] newArray(int i) {
        return new zzcz[i];
    }
}
