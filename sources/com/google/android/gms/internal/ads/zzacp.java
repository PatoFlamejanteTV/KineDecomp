package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzark
/* loaded from: classes2.dex */
public final class zzacp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzacp> CREATOR = new zzacq();
    public final int versionCode;
    public final boolean zzdcs;
    public final int zzdct;
    public final boolean zzdcu;
    public final int zzdcv;
    public final zzzw zzdcw;
    private final boolean zzdcx;

    public zzacp(NativeAdOptions nativeAdOptions) {
        this(3, nativeAdOptions.e(), nativeAdOptions.b(), nativeAdOptions.d(), nativeAdOptions.a(), nativeAdOptions.c() != null ? new zzzw(nativeAdOptions.c()) : null, nativeAdOptions.f());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.versionCode);
        SafeParcelWriter.a(parcel, 2, this.zzdcs);
        SafeParcelWriter.a(parcel, 3, this.zzdct);
        SafeParcelWriter.a(parcel, 4, this.zzdcu);
        SafeParcelWriter.a(parcel, 5, this.zzdcv);
        SafeParcelWriter.a(parcel, 6, (Parcelable) this.zzdcw, i, false);
        SafeParcelWriter.a(parcel, 7, this.zzdcx);
        SafeParcelWriter.a(parcel, a2);
    }

    @SafeParcelable.Constructor
    public zzacp(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) boolean z2, @SafeParcelable.Param(id = 5) int i3, @SafeParcelable.Param(id = 6) zzzw zzzwVar, @SafeParcelable.Param(id = 7) boolean z3) {
        this.versionCode = i;
        this.zzdcs = z;
        this.zzdct = i2;
        this.zzdcu = z2;
        this.zzdcv = i3;
        this.zzdcw = zzzwVar;
        this.zzdcx = z3;
    }
}
