package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzj;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzcj extends AbstractSafeParcelable implements com.google.firebase.auth.api.internal.zzdw<zzcj, zzj.zzb> {
    public static final Parcelable.Creator<zzcj> CREATOR = new zzck();
    private String zzgb;
    private String zzol;
    private boolean zzom;
    private boolean zzon;
    private zzdp zzoo;
    private List<String> zzop;

    public zzcj() {
        this.zzoo = zzdp.zzec();
    }

    public final List<String> getAllProviders() {
        return this.zzoo.zzeb();
    }

    public final List<String> getSignInMethods() {
        return this.zzop;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.zzol, false);
        SafeParcelWriter.a(parcel, 3, this.zzom);
        SafeParcelWriter.a(parcel, 4, this.zzgb, false);
        SafeParcelWriter.a(parcel, 5, this.zzon);
        SafeParcelWriter.a(parcel, 6, (Parcelable) this.zzoo, i, false);
        SafeParcelWriter.c(parcel, 7, this.zzop, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final /* synthetic */ com.google.firebase.auth.api.internal.zzdw zza(zzhc zzhcVar) {
        zzdp zzdpVar;
        if (zzhcVar instanceof zzj.zzb) {
            zzj.zzb zzbVar = (zzj.zzb) zzhcVar;
            this.zzol = Strings.a(zzbVar.zze());
            this.zzom = zzbVar.zzh();
            this.zzgb = Strings.a(zzbVar.getProviderId());
            this.zzon = zzbVar.zzi();
            if (zzbVar.zzg() == 0) {
                zzdpVar = zzdp.zzec();
            } else {
                zzdpVar = new zzdp(1, new ArrayList(zzbVar.zzf()));
            }
            this.zzoo = zzdpVar;
            this.zzop = zzbVar.zzk() == 0 ? new ArrayList<>(0) : zzbVar.zzj();
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of CreateAuthUriResponse.");
    }

    public final zzhm<zzj.zzb> zzdj() {
        return zzj.zzb.zzl();
    }

    @SafeParcelable.Constructor
    public zzcj(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) zzdp zzdpVar, @SafeParcelable.Param(id = 7) List<String> list) {
        this.zzol = str;
        this.zzom = z;
        this.zzgb = str2;
        this.zzon = z2;
        this.zzoo = zzdpVar == null ? zzdp.zzec() : zzdp.zza(zzdpVar);
        this.zzop = list;
    }
}
