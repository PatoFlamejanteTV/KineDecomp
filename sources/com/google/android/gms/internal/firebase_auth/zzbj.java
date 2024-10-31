package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.ActionCodeSettings;

/* loaded from: classes2.dex */
public final class zzbj implements Parcelable.Creator<zzbi> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbi createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        ActionCodeSettings actionCodeSettings = null;
        String str2 = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                str = SafeParcelReader.p(parcel, a2);
            } else if (a3 == 2) {
                actionCodeSettings = (ActionCodeSettings) SafeParcelReader.a(parcel, a2, ActionCodeSettings.CREATOR);
            } else if (a3 != 3) {
                SafeParcelReader.F(parcel, a2);
            } else {
                str2 = SafeParcelReader.p(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzbi(str, actionCodeSettings, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbi[] newArray(int i) {
        return new zzbi[i];
    }
}
