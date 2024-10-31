package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzp implements Parcelable.Creator<zzo> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzo createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        String str = null;
        String str2 = null;
        zzfv zzfvVar = null;
        String str3 = null;
        zzag zzagVar = null;
        zzag zzagVar2 = null;
        zzag zzagVar3 = null;
        boolean z = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 2:
                    str = SafeParcelReader.p(parcel, a2);
                    break;
                case 3:
                    str2 = SafeParcelReader.p(parcel, a2);
                    break;
                case 4:
                    zzfvVar = (zzfv) SafeParcelReader.a(parcel, a2, zzfv.CREATOR);
                    break;
                case 5:
                    j = SafeParcelReader.C(parcel, a2);
                    break;
                case 6:
                    z = SafeParcelReader.t(parcel, a2);
                    break;
                case 7:
                    str3 = SafeParcelReader.p(parcel, a2);
                    break;
                case 8:
                    zzagVar = (zzag) SafeParcelReader.a(parcel, a2, zzag.CREATOR);
                    break;
                case 9:
                    j2 = SafeParcelReader.C(parcel, a2);
                    break;
                case 10:
                    zzagVar2 = (zzag) SafeParcelReader.a(parcel, a2, zzag.CREATOR);
                    break;
                case 11:
                    j3 = SafeParcelReader.C(parcel, a2);
                    break;
                case 12:
                    zzagVar3 = (zzag) SafeParcelReader.a(parcel, a2, zzag.CREATOR);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzo(str, str2, zzfvVar, j, z, str3, zzagVar, j2, zzagVar2, j3, zzagVar3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzo[] newArray(int i) {
        return new zzo[i];
    }
}
