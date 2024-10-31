package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzb implements Parcelable.Creator<ActionCodeSettings> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActionCodeSettings createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        boolean z = false;
        boolean z2 = false;
        int i = 0;
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
                    str3 = SafeParcelReader.p(parcel, a2);
                    break;
                case 4:
                    str4 = SafeParcelReader.p(parcel, a2);
                    break;
                case 5:
                    z = SafeParcelReader.t(parcel, a2);
                    break;
                case 6:
                    str5 = SafeParcelReader.p(parcel, a2);
                    break;
                case 7:
                    z2 = SafeParcelReader.t(parcel, a2);
                    break;
                case 8:
                    str6 = SafeParcelReader.p(parcel, a2);
                    break;
                case 9:
                    i = SafeParcelReader.A(parcel, a2);
                    break;
                case 10:
                    str7 = SafeParcelReader.p(parcel, a2);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new ActionCodeSettings(str, str2, str3, str4, z, str5, z2, str6, i, str7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActionCodeSettings[] newArray(int i) {
        return new ActionCodeSettings[i];
    }
}
