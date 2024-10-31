package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzj;

/* loaded from: classes2.dex */
public final class zzcn implements com.google.firebase.auth.api.internal.zzdw<zzcn, zzj.zze> {
    private String zzgc;
    private String zzgh;
    private String zzid;
    private String zzoq;
    private boolean zzor;
    private long zzos;

    public final String getIdToken() {
        return this.zzgc;
    }

    public final boolean isNewUser() {
        return this.zzor;
    }

    public final /* synthetic */ com.google.firebase.auth.api.internal.zzdw zza(zzhc zzhcVar) {
        if (zzhcVar instanceof zzj.zze) {
            zzj.zze zzeVar = (zzj.zze) zzhcVar;
            this.zzoq = Strings.a(zzeVar.getLocalId());
            this.zzgh = Strings.a(zzeVar.getEmail());
            this.zzgc = Strings.a(zzeVar.getIdToken());
            this.zzid = Strings.a(zzeVar.zzr());
            this.zzor = zzeVar.zzt();
            this.zzos = zzeVar.zzs();
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of EmailLinkSigninResponse.");
    }

    public final zzhm<zzj.zze> zzdj() {
        return zzj.zze.zzl();
    }

    public final String zzr() {
        return this.zzid;
    }

    public final long zzs() {
        return this.zzos;
    }
}
