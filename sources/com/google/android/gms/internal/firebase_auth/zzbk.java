package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class zzbk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbk> CREATOR = new zzbl();
    private final zzdj zzih;

    @SafeParcelable.Constructor
    public zzbk(@SafeParcelable.Param(id = 1) zzdj zzdjVar) {
        this.zzih = zzdjVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, (Parcelable) this.zzih, i, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final zzdj zzcr() {
        return this.zzih;
    }
}
