package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzu implements Parcelable.Creator<GoogleAuthCredential> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleAuthCredential createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                str = SafeParcelReader.p(parcel, a2);
            } else if (a3 != 2) {
                SafeParcelReader.F(parcel, a2);
            } else {
                str2 = SafeParcelReader.p(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new GoogleAuthCredential(str, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleAuthCredential[] newArray(int i) {
        return new GoogleAuthCredential[i];
    }
}
