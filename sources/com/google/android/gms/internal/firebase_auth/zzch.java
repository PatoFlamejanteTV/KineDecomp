package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzch implements Parcelable.Creator<zzcg> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcg createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        Status status = null;
        com.google.firebase.auth.zzd zzdVar = null;
        String str = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                status = (Status) SafeParcelReader.a(parcel, a2, Status.CREATOR);
            } else if (a3 == 2) {
                zzdVar = (com.google.firebase.auth.zzd) SafeParcelReader.a(parcel, a2, com.google.firebase.auth.zzd.CREATOR);
            } else if (a3 != 3) {
                SafeParcelReader.F(parcel, a2);
            } else {
                str = SafeParcelReader.p(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzcg(status, zzdVar, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcg[] newArray(int i) {
        return new zzcg[i];
    }
}
