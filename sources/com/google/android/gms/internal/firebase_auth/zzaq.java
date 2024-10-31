package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class zzaq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaq> CREATOR = new zzar();
    private final String zzgh;
    private final String zzgi;
    private final String zzgw;

    @SafeParcelable.Constructor
    public zzaq(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) String str3) {
        this.zzgh = str;
        this.zzgi = str2;
        this.zzgw = str3;
    }

    public final String getEmail() {
        return this.zzgh;
    }

    public final String getPassword() {
        return this.zzgi;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.zzgh, false);
        SafeParcelWriter.a(parcel, 2, this.zzgi, false);
        SafeParcelWriter.a(parcel, 3, this.zzgw, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final String zzcf() {
        return this.zzgw;
    }
}
