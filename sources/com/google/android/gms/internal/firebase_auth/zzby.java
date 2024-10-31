package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.PhoneAuthCredential;

/* loaded from: classes2.dex */
public final class zzby extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzby> CREATOR = new zzbz();
    private final String zzgw;
    private final PhoneAuthCredential zzif;

    @SafeParcelable.Constructor
    public zzby(@SafeParcelable.Param(id = 1) PhoneAuthCredential phoneAuthCredential, @SafeParcelable.Param(id = 2) String str) {
        this.zzif = phoneAuthCredential;
        this.zzgw = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, (Parcelable) this.zzif, i, false);
        SafeParcelWriter.a(parcel, 2, this.zzgw, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final PhoneAuthCredential zzcp() {
        return this.zzif;
    }
}
