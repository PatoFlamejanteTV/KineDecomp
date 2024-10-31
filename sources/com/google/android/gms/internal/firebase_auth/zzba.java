package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class zzba extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzba> CREATOR = new zzbb();
    private final String zzgk;
    private final zzdr zzie;

    @SafeParcelable.Constructor
    public zzba(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) zzdr zzdrVar) {
        this.zzgk = str;
        this.zzie = zzdrVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.zzgk, false);
        SafeParcelWriter.a(parcel, 2, (Parcelable) this.zzie, i, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final String zzbx() {
        return this.zzgk;
    }

    public final zzdr zzco() {
        return this.zzie;
    }
}
