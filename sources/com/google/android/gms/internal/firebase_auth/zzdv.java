package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzj;

/* loaded from: classes2.dex */
public final class zzdv extends AbstractSafeParcelable implements com.google.firebase.auth.api.internal.zzdw<zzdv, zzj.zzs> {
    public static final Parcelable.Creator<zzdv> CREATOR = new zzdw();
    private String zzgc;
    private String zzid;
    private boolean zzor;
    private long zzos;

    public zzdv() {
    }

    public final String getIdToken() {
        return this.zzgc;
    }

    public final boolean isNewUser() {
        return this.zzor;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.zzgc, false);
        SafeParcelWriter.a(parcel, 3, this.zzid, false);
        SafeParcelWriter.a(parcel, 4, this.zzos);
        SafeParcelWriter.a(parcel, 5, this.zzor);
        SafeParcelWriter.a(parcel, a2);
    }

    public final /* synthetic */ com.google.firebase.auth.api.internal.zzdw zza(zzhc zzhcVar) {
        if (zzhcVar instanceof zzj.zzs) {
            zzj.zzs zzsVar = (zzj.zzs) zzhcVar;
            this.zzgc = Strings.a(zzsVar.getIdToken());
            this.zzid = Strings.a(zzsVar.zzr());
            this.zzos = zzsVar.zzs();
            this.zzor = zzsVar.zzt();
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of VerifyCustomTokenResponse.");
    }

    public final zzhm<zzj.zzs> zzdj() {
        return zzj.zzs.zzl();
    }

    public final String zzr() {
        return this.zzid;
    }

    public final long zzs() {
        return this.zzos;
    }

    @SafeParcelable.Constructor
    public zzdv(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) long j, @SafeParcelable.Param(id = 5) boolean z) {
        this.zzgc = str;
        this.zzid = str2;
        this.zzos = j;
        this.zzor = z;
    }
}
