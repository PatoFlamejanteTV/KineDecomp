package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzl implements Parcelable.Creator<zzk> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzk createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        long j5 = -2147483648L;
        boolean z = true;
        boolean z2 = false;
        int i = 0;
        boolean z3 = true;
        boolean z4 = true;
        boolean z5 = false;
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
                    str3 = SafeParcelReader.p(parcel, a2);
                    break;
                case 5:
                    str4 = SafeParcelReader.p(parcel, a2);
                    break;
                case 6:
                    j = SafeParcelReader.C(parcel, a2);
                    break;
                case 7:
                    j2 = SafeParcelReader.C(parcel, a2);
                    break;
                case 8:
                    str5 = SafeParcelReader.p(parcel, a2);
                    break;
                case 9:
                    z = SafeParcelReader.t(parcel, a2);
                    break;
                case 10:
                    z2 = SafeParcelReader.t(parcel, a2);
                    break;
                case 11:
                    j5 = SafeParcelReader.C(parcel, a2);
                    break;
                case 12:
                    str6 = SafeParcelReader.p(parcel, a2);
                    break;
                case 13:
                    j3 = SafeParcelReader.C(parcel, a2);
                    break;
                case 14:
                    j4 = SafeParcelReader.C(parcel, a2);
                    break;
                case 15:
                    i = SafeParcelReader.A(parcel, a2);
                    break;
                case 16:
                    z3 = SafeParcelReader.t(parcel, a2);
                    break;
                case 17:
                    z4 = SafeParcelReader.t(parcel, a2);
                    break;
                case 18:
                    z5 = SafeParcelReader.t(parcel, a2);
                    break;
                case 19:
                    str7 = SafeParcelReader.p(parcel, a2);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzk(str, str2, str3, str4, j, j2, str5, z, z2, j5, str6, j3, j4, i, z3, z4, z5, str7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzk[] newArray(int i) {
        return new zzk[i];
    }
}
