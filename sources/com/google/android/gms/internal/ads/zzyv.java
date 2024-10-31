package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzark
/* loaded from: classes2.dex */
public final class zzyv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzyv> CREATOR = new zzyw();
    public final int zzcly;

    @SafeParcelable.Constructor
    public zzyv(@SafeParcelable.Param(id = 2) int i) {
        this.zzcly = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.zzcly);
        SafeParcelWriter.a(parcel, a2);
    }
}
