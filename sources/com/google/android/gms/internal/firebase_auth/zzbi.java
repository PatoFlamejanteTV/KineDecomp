package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.ActionCodeSettings;

/* loaded from: classes2.dex */
public final class zzbi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbi> CREATOR = new zzbj();
    private final String zzgh;
    private final String zzgw;
    private final ActionCodeSettings zzig;

    @SafeParcelable.Constructor
    public zzbi(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) ActionCodeSettings actionCodeSettings, @SafeParcelable.Param(id = 3) String str2) {
        this.zzgh = str;
        this.zzig = actionCodeSettings;
        this.zzgw = str2;
    }

    public final String getEmail() {
        return this.zzgh;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.zzgh, false);
        SafeParcelWriter.a(parcel, 2, (Parcelable) this.zzig, i, false);
        SafeParcelWriter.a(parcel, 3, this.zzgw, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final String zzcf() {
        return this.zzgw;
    }

    public final ActionCodeSettings zzcq() {
        return this.zzig;
    }
}
