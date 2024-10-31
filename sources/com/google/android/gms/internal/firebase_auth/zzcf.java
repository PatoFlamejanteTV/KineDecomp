package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.UserProfileChangeRequest;

/* loaded from: classes2.dex */
public final class zzcf implements Parcelable.Creator<zzce> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzce createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        UserProfileChangeRequest userProfileChangeRequest = null;
        String str = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                userProfileChangeRequest = (UserProfileChangeRequest) SafeParcelReader.a(parcel, a2, UserProfileChangeRequest.CREATOR);
            } else if (a3 != 2) {
                SafeParcelReader.F(parcel, a2);
            } else {
                str = SafeParcelReader.p(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzce(userProfileChangeRequest, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzce[] newArray(int i) {
        return new zzce[i];
    }
}
