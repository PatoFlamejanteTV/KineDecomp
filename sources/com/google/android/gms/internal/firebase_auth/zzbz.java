package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.PhoneAuthCredential;

/* loaded from: classes2.dex */
public final class zzbz implements Parcelable.Creator<zzby> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzby createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        PhoneAuthCredential phoneAuthCredential = null;
        String str = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                phoneAuthCredential = (PhoneAuthCredential) SafeParcelReader.a(parcel, a2, PhoneAuthCredential.CREATOR);
            } else if (a3 != 2) {
                SafeParcelReader.F(parcel, a2);
            } else {
                str = SafeParcelReader.p(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzby(phoneAuthCredential, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzby[] newArray(int i) {
        return new zzby[i];
    }
}
