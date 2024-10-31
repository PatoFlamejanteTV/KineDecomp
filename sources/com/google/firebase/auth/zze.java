package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.firebase_auth.zzdr;

/* loaded from: classes2.dex */
public final class zze implements Parcelable.Creator<zzd> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzd createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        zzdr zzdrVar = null;
        String str4 = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                str = SafeParcelReader.p(parcel, a2);
            } else if (a3 == 2) {
                str2 = SafeParcelReader.p(parcel, a2);
            } else if (a3 == 3) {
                str3 = SafeParcelReader.p(parcel, a2);
            } else if (a3 == 4) {
                zzdrVar = (zzdr) SafeParcelReader.a(parcel, a2, zzdr.CREATOR);
            } else if (a3 != 5) {
                SafeParcelReader.F(parcel, a2);
            } else {
                str4 = SafeParcelReader.p(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzd(str, str2, str3, zzdrVar, str4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzd[] newArray(int i) {
        return new zzd[i];
    }
}
