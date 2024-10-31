package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzw implements Parcelable.Creator<PhoneAuthCredential> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PhoneAuthCredential createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        boolean z = false;
        boolean z2 = false;
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
                    z = SafeParcelReader.t(parcel, a2);
                    break;
                case 4:
                    str3 = SafeParcelReader.p(parcel, a2);
                    break;
                case 5:
                    z2 = SafeParcelReader.t(parcel, a2);
                    break;
                case 6:
                    str4 = SafeParcelReader.p(parcel, a2);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new PhoneAuthCredential(str, str2, z, str3, z2, str4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PhoneAuthCredential[] newArray(int i) {
        return new PhoneAuthCredential[i];
    }
}
