package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzdw implements Parcelable.Creator<zzdv> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdv createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        long j = 0;
        boolean z = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 2) {
                str = SafeParcelReader.p(parcel, a2);
            } else if (a3 == 3) {
                str2 = SafeParcelReader.p(parcel, a2);
            } else if (a3 == 4) {
                j = SafeParcelReader.C(parcel, a2);
            } else if (a3 != 5) {
                SafeParcelReader.F(parcel, a2);
            } else {
                z = SafeParcelReader.t(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzdv(str, str2, j, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdv[] newArray(int i) {
        return new zzdv[i];
    }
}
