package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzx implements Parcelable.Creator<PlayGamesAuthCredential> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlayGamesAuthCredential createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            if (SafeParcelReader.a(a2) != 1) {
                SafeParcelReader.F(parcel, a2);
            } else {
                str = SafeParcelReader.p(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new PlayGamesAuthCredential(str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlayGamesAuthCredential[] newArray(int i) {
        return new PlayGamesAuthCredential[i];
    }
}
