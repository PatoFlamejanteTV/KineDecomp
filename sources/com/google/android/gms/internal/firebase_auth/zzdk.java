package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzdk implements Parcelable.Creator<zzdj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdj createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        long j = 0;
        boolean z = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                str = SafeParcelReader.p(parcel, a2);
            } else if (a3 == 2) {
                j = SafeParcelReader.C(parcel, a2);
            } else if (a3 == 3) {
                z = SafeParcelReader.t(parcel, a2);
            } else if (a3 == 4) {
                str2 = SafeParcelReader.p(parcel, a2);
            } else if (a3 != 5) {
                SafeParcelReader.F(parcel, a2);
            } else {
                str3 = SafeParcelReader.p(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzdj(str, j, z, str2, str3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdj[] newArray(int i) {
        return new zzdj[i];
    }
}
