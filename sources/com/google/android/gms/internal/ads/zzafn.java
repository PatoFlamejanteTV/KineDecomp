package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzark
/* loaded from: classes2.dex */
public final class zzafn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzafn> CREATOR = new zzafo();
    public final byte[] data;
    public final int statusCode;
    public final boolean zzac;
    public final long zzad;
    public final String[] zzdgi;
    public final String[] zzdgj;
    public final boolean zzdgk;
    public final String zzdgl;

    @SafeParcelable.Constructor
    public zzafn(@SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i, @SafeParcelable.Param(id = 4) byte[] bArr, @SafeParcelable.Param(id = 5) String[] strArr, @SafeParcelable.Param(id = 6) String[] strArr2, @SafeParcelable.Param(id = 7) boolean z2, @SafeParcelable.Param(id = 8) long j) {
        this.zzdgk = z;
        this.zzdgl = str;
        this.statusCode = i;
        this.data = bArr;
        this.zzdgi = strArr;
        this.zzdgj = strArr2;
        this.zzac = z2;
        this.zzad = j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.zzdgk);
        SafeParcelWriter.a(parcel, 2, this.zzdgl, false);
        SafeParcelWriter.a(parcel, 3, this.statusCode);
        SafeParcelWriter.a(parcel, 4, this.data, false);
        SafeParcelWriter.a(parcel, 5, this.zzdgi, false);
        SafeParcelWriter.a(parcel, 6, this.zzdgj, false);
        SafeParcelWriter.a(parcel, 7, this.zzac);
        SafeParcelWriter.a(parcel, 8, this.zzad);
        SafeParcelWriter.a(parcel, a2);
    }
}
