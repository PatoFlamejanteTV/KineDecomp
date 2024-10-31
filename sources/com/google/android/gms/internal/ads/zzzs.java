package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzark
/* loaded from: classes2.dex */
public final class zzzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzzs> CREATOR = new zzzt();
    public final String zzcne;

    public zzzs(SearchAdRequest searchAdRequest) {
        this.zzcne = searchAdRequest.a();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 15, this.zzcne, false);
        SafeParcelWriter.a(parcel, a2);
    }

    @SafeParcelable.Constructor
    public zzzs(@SafeParcelable.Param(id = 15) String str) {
        this.zzcne = str;
    }
}
