package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class zzcw implements Parcelable.Creator<zzcv> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcv createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        ArrayList arrayList = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            if (SafeParcelReader.a(a2) != 2) {
                SafeParcelReader.F(parcel, a2);
            } else {
                arrayList = SafeParcelReader.c(parcel, a2, zzct.CREATOR);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzcv(arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcv[] newArray(int i) {
        return new zzcv[i];
    }
}
