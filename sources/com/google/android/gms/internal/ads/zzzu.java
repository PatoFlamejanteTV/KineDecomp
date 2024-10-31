package com.google.android.gms.internal.ads;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

@zzark
/* loaded from: classes2.dex */
public final class zzzu extends zzwf {
    public zzzu(zzwf zzwfVar) {
        super(zzwfVar.zzckk, zzwfVar.height, zzwfVar.heightPixels, zzwfVar.zzckl, zzwfVar.width, zzwfVar.widthPixels, zzwfVar.zzckm, zzwfVar.zzckn, zzwfVar.zzcko, zzwfVar.zzckp);
    }

    @Override // com.google.android.gms.internal.ads.zzwf, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.zzckk, false);
        SafeParcelWriter.a(parcel, 3, this.height);
        SafeParcelWriter.a(parcel, 6, this.width);
        SafeParcelWriter.a(parcel, a2);
    }
}
