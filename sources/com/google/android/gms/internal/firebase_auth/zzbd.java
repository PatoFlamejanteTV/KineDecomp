package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.PhoneAuthCredential;

/* loaded from: classes2.dex */
public final class zzbd implements Parcelable.Creator<zzbc> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbc createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        PhoneAuthCredential phoneAuthCredential = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                str = SafeParcelReader.p(parcel, a2);
            } else if (a3 != 2) {
                SafeParcelReader.F(parcel, a2);
            } else {
                phoneAuthCredential = (PhoneAuthCredential) SafeParcelReader.a(parcel, a2, PhoneAuthCredential.CREATOR);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzbc(str, phoneAuthCredential);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbc[] newArray(int i) {
        return new zzbc[i];
    }
}
