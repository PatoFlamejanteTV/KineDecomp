package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzark
/* loaded from: classes2.dex */
public final class zzatm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzatm> CREATOR = new zzatn();
    String zzczq;

    @SafeParcelable.Constructor
    public zzatm(@SafeParcelable.Param(id = 2) String str) {
        this.zzczq = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.zzczq, false);
        SafeParcelWriter.a(parcel, a2);
    }
}
