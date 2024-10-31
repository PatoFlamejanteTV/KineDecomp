package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.UserProfileChangeRequest;

/* loaded from: classes2.dex */
public final class zzce extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzce> CREATOR = new zzcf();
    private final String zzgk;
    private final UserProfileChangeRequest zzil;

    @SafeParcelable.Constructor
    public zzce(@SafeParcelable.Param(id = 1) UserProfileChangeRequest userProfileChangeRequest, @SafeParcelable.Param(id = 2) String str) {
        this.zzil = userProfileChangeRequest;
        this.zzgk = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, (Parcelable) this.zzil, i, false);
        SafeParcelWriter.a(parcel, 2, this.zzgk, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final String zzbx() {
        return this.zzgk;
    }

    public final UserProfileChangeRequest zzcu() {
        return this.zzil;
    }
}
