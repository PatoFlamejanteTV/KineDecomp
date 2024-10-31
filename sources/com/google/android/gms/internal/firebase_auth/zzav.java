package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzav implements Parcelable.Creator<zzau> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzau createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            if (SafeParcelReader.a(a2) != 1) {
                SafeParcelReader.F(parcel, a2);
            } else {
                str = SafeParcelReader.p(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzau(str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzau[] newArray(int i) {
        return new zzau[i];
    }
}
