package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.ActionCodeSettings;

/* loaded from: classes2.dex */
public final class zzbg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbg> CREATOR = new zzbh();
    private final String zzhm;
    private final ActionCodeSettings zzig;

    @SafeParcelable.Constructor
    public zzbg(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) ActionCodeSettings actionCodeSettings) {
        this.zzhm = str;
        this.zzig = actionCodeSettings;
    }

    public final String getToken() {
        return this.zzhm;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.zzhm, false);
        SafeParcelWriter.a(parcel, 2, (Parcelable) this.zzig, i, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final ActionCodeSettings zzcq() {
        return this.zzig;
    }
}
