package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzcs implements Parcelable.Creator<zzcr> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcr createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        zzcv zzcvVar = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            if (SafeParcelReader.a(a2) != 2) {
                SafeParcelReader.F(parcel, a2);
            } else {
                zzcvVar = (zzcv) SafeParcelReader.a(parcel, a2, zzcv.CREATOR);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzcr(zzcvVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcr[] newArray(int i) {
        return new zzcr[i];
    }
}
