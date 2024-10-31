package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class zzck implements Parcelable.Creator<zzcj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcj createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        zzdp zzdpVar = null;
        ArrayList<String> arrayList = null;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 2:
                    str = SafeParcelReader.p(parcel, a2);
                    break;
                case 3:
                    z = SafeParcelReader.t(parcel, a2);
                    break;
                case 4:
                    str2 = SafeParcelReader.p(parcel, a2);
                    break;
                case 5:
                    z2 = SafeParcelReader.t(parcel, a2);
                    break;
                case 6:
                    zzdpVar = (zzdp) SafeParcelReader.a(parcel, a2, zzdp.CREATOR);
                    break;
                case 7:
                    arrayList = SafeParcelReader.r(parcel, a2);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzcj(str, z, str2, z2, zzdpVar, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcj[] newArray(int i) {
        return new zzcj[i];
    }
}
