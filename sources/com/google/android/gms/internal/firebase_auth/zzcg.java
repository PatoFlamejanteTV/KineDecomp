package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class zzcg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcg> CREATOR = new zzch();
    private final String zzgh;
    private final Status zzim;
    private final com.google.firebase.auth.zzd zzin;

    @SafeParcelable.Constructor
    public zzcg(@SafeParcelable.Param(id = 1) Status status, @SafeParcelable.Param(id = 2) com.google.firebase.auth.zzd zzdVar, @SafeParcelable.Param(id = 3) String str) {
        this.zzim = status;
        this.zzin = zzdVar;
        this.zzgh = str;
    }

    public final String getEmail() {
        return this.zzgh;
    }

    public final Status getStatus() {
        return this.zzim;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, (Parcelable) this.zzim, i, false);
        SafeParcelWriter.a(parcel, 2, (Parcelable) this.zzin, i, false);
        SafeParcelWriter.a(parcel, 3, this.zzgh, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final com.google.firebase.auth.zzd zzcv() {
        return this.zzin;
    }
}
