package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class zzcc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcc> CREATOR = new zzcd();
    private final String zzgk;
    private final String zzik;

    @SafeParcelable.Constructor
    public zzcc(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2) {
        this.zzik = str;
        this.zzgk = str2;
    }

    public final String getProvider() {
        return this.zzik;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.zzik, false);
        SafeParcelWriter.a(parcel, 2, this.zzgk, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final String zzbx() {
        return this.zzgk;
    }
}
