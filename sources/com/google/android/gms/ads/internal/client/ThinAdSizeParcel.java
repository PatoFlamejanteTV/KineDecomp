package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.internal.zzgr;

@zzgr
/* loaded from: classes.dex */
public class ThinAdSizeParcel extends AdSizeParcel {
    public ThinAdSizeParcel(AdSizeParcel adSizeParcel) {
        super(adSizeParcel.f534a, adSizeParcel.b, adSizeParcel.c, adSizeParcel.d, adSizeParcel.e, adSizeParcel.f, adSizeParcel.g, adSizeParcel.h, adSizeParcel.i, adSizeParcel.j);
    }

    @Override // com.google.android.gms.ads.internal.client.AdSizeParcel, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, this.f534a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, this.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, this.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, this.f);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }
}
