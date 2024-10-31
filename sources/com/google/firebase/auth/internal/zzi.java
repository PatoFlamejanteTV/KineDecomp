package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzi implements Parcelable.Creator<zzh> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzh createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        boolean z = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    str = SafeParcelReader.p(parcel, a2);
                    break;
                case 2:
                    str2 = SafeParcelReader.p(parcel, a2);
                    break;
                case 3:
                    str5 = SafeParcelReader.p(parcel, a2);
                    break;
                case 4:
                    str4 = SafeParcelReader.p(parcel, a2);
                    break;
                case 5:
                    str3 = SafeParcelReader.p(parcel, a2);
                    break;
                case 6:
                    str6 = SafeParcelReader.p(parcel, a2);
                    break;
                case 7:
                    z = SafeParcelReader.t(parcel, a2);
                    break;
                case 8:
                    str7 = SafeParcelReader.p(parcel, a2);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzh(str, str2, str3, str4, str5, str6, z, str7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzh[] newArray(int i) {
        return new zzh[i];
    }
}
