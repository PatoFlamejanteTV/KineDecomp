package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzdz implements Parcelable.Creator<zzdy> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdy createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        long j = 0;
        long j2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        boolean z = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    j = SafeParcelReader.C(parcel, a2);
                    break;
                case 2:
                    j2 = SafeParcelReader.C(parcel, a2);
                    break;
                case 3:
                    z = SafeParcelReader.t(parcel, a2);
                    break;
                case 4:
                    str = SafeParcelReader.p(parcel, a2);
                    break;
                case 5:
                    str2 = SafeParcelReader.p(parcel, a2);
                    break;
                case 6:
                    str3 = SafeParcelReader.p(parcel, a2);
                    break;
                case 7:
                    bundle = SafeParcelReader.f(parcel, a2);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzdy(j, j2, z, str, str2, str3, bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdy[] newArray(int i) {
        return new zzdy[i];
    }
}
