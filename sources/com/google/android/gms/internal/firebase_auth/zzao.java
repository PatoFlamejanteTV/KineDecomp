package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class zzao extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzao> CREATOR = new zzap();
    private final String zzgw;
    private final String zzib;
    private final String zzic;

    @SafeParcelable.Constructor
    public zzao(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) String str3) {
        this.zzib = str;
        this.zzic = str2;
        this.zzgw = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.zzib, false);
        SafeParcelWriter.a(parcel, 2, this.zzic, false);
        SafeParcelWriter.a(parcel, 3, this.zzgw, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final String zzcf() {
        return this.zzgw;
    }

    public final String zzcm() {
        return this.zzib;
    }

    public final String zzcn() {
        return this.zzic;
    }
}
