package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzf implements Parcelable.Creator<EmailAuthCredential> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ EmailAuthCredential createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        boolean z = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                str = SafeParcelReader.p(parcel, a2);
            } else if (a3 == 2) {
                str2 = SafeParcelReader.p(parcel, a2);
            } else if (a3 == 3) {
                str3 = SafeParcelReader.p(parcel, a2);
            } else if (a3 == 4) {
                str4 = SafeParcelReader.p(parcel, a2);
            } else if (a3 != 5) {
                SafeParcelReader.F(parcel, a2);
            } else {
                z = SafeParcelReader.t(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new EmailAuthCredential(str, str2, str3, str4, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ EmailAuthCredential[] newArray(int i) {
        return new EmailAuthCredential[i];
    }
}
