package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzark
/* loaded from: classes2.dex */
public final class zzzw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzzw> CREATOR = new zzzx();
    public final boolean zzcnf;
    public final boolean zzcng;
    public final boolean zzcnh;

    public zzzw(VideoOptions videoOptions) {
        this(videoOptions.c(), videoOptions.b(), videoOptions.a());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.zzcnf);
        SafeParcelWriter.a(parcel, 3, this.zzcng);
        SafeParcelWriter.a(parcel, 4, this.zzcnh);
        SafeParcelWriter.a(parcel, a2);
    }

    @SafeParcelable.Constructor
    public zzzw(@SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) boolean z3) {
        this.zzcnf = z;
        this.zzcng = z2;
        this.zzcnh = z3;
    }
}
