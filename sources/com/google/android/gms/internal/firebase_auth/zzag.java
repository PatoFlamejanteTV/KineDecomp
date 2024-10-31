package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class zzag extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzag> CREATOR = new zzah();
    private final String zzgw;
    private final String zzib;

    @SafeParcelable.Constructor
    public zzag(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2) {
        this.zzib = str;
        this.zzgw = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.zzib, false);
        SafeParcelWriter.a(parcel, 2, this.zzgw, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final String zzcf() {
        return this.zzgw;
    }

    public final String zzcm() {
        return this.zzib;
    }
}
