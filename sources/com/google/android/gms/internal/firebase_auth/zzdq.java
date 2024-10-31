package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class zzdq implements Parcelable.Creator<zzdp> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdp createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        int i = 0;
        ArrayList<String> arrayList = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i = SafeParcelReader.A(parcel, a2);
            } else if (a3 != 2) {
                SafeParcelReader.F(parcel, a2);
            } else {
                arrayList = SafeParcelReader.r(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzdp(i, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdp[] newArray(int i) {
        return new zzdp[i];
    }
}
