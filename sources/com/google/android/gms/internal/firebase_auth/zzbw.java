package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.EmailAuthCredential;

/* loaded from: classes2.dex */
public final class zzbw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbw> CREATOR = new zzbx();
    private final EmailAuthCredential zzij;

    @SafeParcelable.Constructor
    public zzbw(@SafeParcelable.Param(id = 1) EmailAuthCredential emailAuthCredential) {
        this.zzij = emailAuthCredential;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, (Parcelable) this.zzij, i, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final EmailAuthCredential zzct() {
        return this.zzij;
    }
}
