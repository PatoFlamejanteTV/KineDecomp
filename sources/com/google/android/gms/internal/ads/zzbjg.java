package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class zzbjg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbjg> CREATOR = new zzbjh();
    private final String packageName;
    private final int versionCode;
    private final String zzfcv;

    @SafeParcelable.Constructor
    public zzbjg(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2) {
        this.versionCode = i;
        this.packageName = str;
        this.zzfcv = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.versionCode);
        SafeParcelWriter.a(parcel, 2, this.packageName, false);
        SafeParcelWriter.a(parcel, 3, this.zzfcv, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public zzbjg(String str, String str2) {
        this(1, str, str2);
    }
}
