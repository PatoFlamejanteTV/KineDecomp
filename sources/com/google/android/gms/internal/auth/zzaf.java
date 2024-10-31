package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class zzaf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaf> CREATOR = new zzag();
    private final String accountType;
    private final byte[] zzbp;
    private final int zzv;

    public zzaf(String str, byte[] bArr) {
        this(1, str, bArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.zzv);
        SafeParcelWriter.a(parcel, 2, this.accountType, false);
        SafeParcelWriter.a(parcel, 3, this.zzbp, false);
        SafeParcelWriter.a(parcel, a2);
    }

    @SafeParcelable.Constructor
    public zzaf(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) byte[] bArr) {
        this.zzv = 1;
        Preconditions.a(str);
        this.accountType = str;
        Preconditions.a(bArr);
        this.zzbp = bArr;
    }
}
