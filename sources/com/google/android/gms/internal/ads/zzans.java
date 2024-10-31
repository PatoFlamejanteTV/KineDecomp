package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzans extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzans> CREATOR = new zzant();
    private final int major;
    private final int minor;
    private final int zzdov;

    @SafeParcelable.Constructor
    public zzans(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) int i3) {
        this.major = i;
        this.minor = i2;
        this.zzdov = i3;
    }

    public static zzans zza(zzbiw zzbiwVar) {
        throw new NoSuchMethodError();
    }

    public final String toString() {
        int i = this.major;
        int i2 = this.minor;
        int i3 = this.zzdov;
        StringBuilder sb = new StringBuilder(35);
        sb.append(i);
        sb.append(".");
        sb.append(i2);
        sb.append(".");
        sb.append(i3);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.major);
        SafeParcelWriter.a(parcel, 2, this.minor);
        SafeParcelWriter.a(parcel, 3, this.zzdov);
        SafeParcelWriter.a(parcel, a2);
    }
}
