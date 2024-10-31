package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.api.internal.zzff;

/* loaded from: classes2.dex */
public final class zzdj extends AbstractSafeParcelable implements zzff<zzj.zzk> {
    public static final Parcelable.Creator<zzdj> CREATOR = new zzdk();
    private final String zzgw;
    private final String zzhq;
    private final long zzpo;
    private final boolean zzpp;
    private final String zzpq;

    @SafeParcelable.Constructor
    public zzdj(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) long j, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) String str3) {
        Preconditions.b(str);
        this.zzhq = str;
        this.zzpo = j;
        this.zzpp = z;
        this.zzpq = str2;
        this.zzgw = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.zzhq, false);
        SafeParcelWriter.a(parcel, 2, this.zzpo);
        SafeParcelWriter.a(parcel, 3, this.zzpp);
        SafeParcelWriter.a(parcel, 4, this.zzpq, false);
        SafeParcelWriter.a(parcel, 5, this.zzgw, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final /* synthetic */ zzhc zzds() {
        zzj.zzk.zza zzaj = zzj.zzk.zzag().zzaj(this.zzhq);
        String str = this.zzgw;
        if (str != null) {
            zzaj.zzak(str);
        }
        return (zzj.zzk) zzaj.zzhn();
    }
}
