package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzj;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzcr extends AbstractSafeParcelable implements com.google.firebase.auth.api.internal.zzdw<zzcr, zzj.zzg> {
    public static final Parcelable.Creator<zzcr> CREATOR = new zzcs();
    private zzcv zzoz;

    public zzcr() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, (Parcelable) this.zzoz, i, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final /* synthetic */ com.google.firebase.auth.api.internal.zzdw zza(zzhc zzhcVar) {
        if (zzhcVar instanceof zzj.zzg) {
            zzj.zzg zzgVar = (zzj.zzg) zzhcVar;
            if (zzgVar.zzx() == 0) {
                this.zzoz = new zzcv();
            } else {
                this.zzoz = zzcv.zza(zzgVar);
            }
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of GetAccountInfoResponse.");
    }

    public final zzhm<zzj.zzg> zzdj() {
        return zzj.zzg.zzl();
    }

    public final List<zzct> zzdt() {
        return this.zzoz.zzdt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzcr(@SafeParcelable.Param(id = 2) zzcv zzcvVar) {
        zzcv zza;
        if (zzcvVar == null) {
            zza = new zzcv();
        } else {
            zza = zzcv.zza(zzcvVar);
        }
        this.zzoz = zza;
    }
}
