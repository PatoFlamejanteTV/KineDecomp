package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzbb implements Parcelable.Creator<zzba> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzba createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        zzdr zzdrVar = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                str = SafeParcelReader.p(parcel, a2);
            } else if (a3 != 2) {
                SafeParcelReader.F(parcel, a2);
            } else {
                zzdrVar = (zzdr) SafeParcelReader.a(parcel, a2, zzdr.CREATOR);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzba(str, zzdrVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzba[] newArray(int i) {
        return new zzba[i];
    }
}
