package com.google.android.gms.internal.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class zzx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzx> CREATOR = new zzy();
    private final byte[] zzu;

    @SafeParcelable.Constructor
    public zzx(@SafeParcelable.Param(id = 2) byte[] bArr) {
        this.zzu = bArr;
    }

    public final byte[] getPayload() {
        return this.zzu;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.zzu, false);
        SafeParcelWriter.a(parcel, a2);
    }
}
