package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class zzak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzak> CREATOR = new zzal();
    private final String zzgi;
    private final String zzgk;

    @SafeParcelable.Constructor
    public zzak(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2) {
        this.zzgk = str;
        this.zzgi = str2;
    }

    public final String getPassword() {
        return this.zzgi;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.zzgk, false);
        SafeParcelWriter.a(parcel, 2, this.zzgi, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final String zzbx() {
        return this.zzgk;
    }
}
