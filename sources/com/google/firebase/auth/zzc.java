package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.PhoneAuthProvider;

/* loaded from: classes2.dex */
public final class zzc implements Parcelable.Creator<PhoneAuthProvider.ForceResendingToken> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PhoneAuthProvider.ForceResendingToken createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            SafeParcelReader.a(a2);
            SafeParcelReader.F(parcel, a2);
        }
        SafeParcelReader.s(parcel, b2);
        return new PhoneAuthProvider.ForceResendingToken();
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PhoneAuthProvider.ForceResendingToken[] newArray(int i) {
        return new PhoneAuthProvider.ForceResendingToken[i];
    }
}
