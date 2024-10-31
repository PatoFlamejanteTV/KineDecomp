package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzdc implements Parcelable.Creator<zzdb> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdb createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
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
                    str5 = SafeParcelReader.p(parcel, a2);
                    break;
                case 7:
                    str6 = SafeParcelReader.p(parcel, a2);
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
        return new zzdb(str, str2, str3, str4, str5, str6, str7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdb[] newArray(int i) {
        return new zzdb[i];
    }
}
