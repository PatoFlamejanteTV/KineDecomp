package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.EmailAuthCredential;

/* loaded from: classes2.dex */
public final class zzbx implements Parcelable.Creator<zzbw> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbw createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        EmailAuthCredential emailAuthCredential = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            if (SafeParcelReader.a(a2) != 1) {
                SafeParcelReader.F(parcel, a2);
            } else {
                emailAuthCredential = (EmailAuthCredential) SafeParcelReader.a(parcel, a2, EmailAuthCredential.CREATOR);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzbw(emailAuthCredential);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbw[] newArray(int i) {
        return new zzbw[i];
    }
}
