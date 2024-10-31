package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class zzdy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdy> CREATOR = new zzdz();
    public final String origin;
    public final long zzade;
    public final long zzadf;
    public final boolean zzadg;
    public final String zzadh;
    public final String zzadi;
    public final Bundle zzadj;

    @SafeParcelable.Constructor
    public zzdy(@SafeParcelable.Param(id = 1) long j, @SafeParcelable.Param(id = 2) long j2, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) String str2, @SafeParcelable.Param(id = 6) String str3, @SafeParcelable.Param(id = 7) Bundle bundle) {
        this.zzade = j;
        this.zzadf = j2;
        this.zzadg = z;
        this.zzadh = str;
        this.origin = str2;
        this.zzadi = str3;
        this.zzadj = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.zzade);
        SafeParcelWriter.a(parcel, 2, this.zzadf);
        SafeParcelWriter.a(parcel, 3, this.zzadg);
        SafeParcelWriter.a(parcel, 4, this.zzadh, false);
        SafeParcelWriter.a(parcel, 5, this.origin, false);
        SafeParcelWriter.a(parcel, 6, this.zzadi, false);
        SafeParcelWriter.a(parcel, 7, this.zzadj, false);
        SafeParcelWriter.a(parcel, a2);
    }
}
