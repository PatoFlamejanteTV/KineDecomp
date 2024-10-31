package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.PhoneAuthCredential;

/* loaded from: classes2.dex */
public final class zzbc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbc> CREATOR = new zzbd();
    private final String zzgk;
    private final PhoneAuthCredential zzif;

    @SafeParcelable.Constructor
    public zzbc(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) PhoneAuthCredential phoneAuthCredential) {
        this.zzgk = str;
        this.zzif = phoneAuthCredential;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.zzgk, false);
        SafeParcelWriter.a(parcel, 2, (Parcelable) this.zzif, i, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final String zzbx() {
        return this.zzgk;
    }

    public final PhoneAuthCredential zzcp() {
        return this.zzif;
    }
}
