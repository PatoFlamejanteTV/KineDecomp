package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzark
/* loaded from: classes2.dex */
public final class zzavh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzavh> CREATOR = new zzavi();
    public final String zzbsn;
    public final zzwb zzdwg;

    @SafeParcelable.Constructor
    public zzavh(@SafeParcelable.Param(id = 2) zzwb zzwbVar, @SafeParcelable.Param(id = 3) String str) {
        this.zzdwg = zzwbVar;
        this.zzbsn = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, (Parcelable) this.zzdwg, i, false);
        SafeParcelWriter.a(parcel, 3, this.zzbsn, false);
        SafeParcelWriter.a(parcel, a2);
    }
}
