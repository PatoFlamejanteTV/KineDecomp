package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzj;

/* loaded from: classes2.dex */
public final class zzdo implements com.google.firebase.auth.api.internal.zzdw<zzdo, zzj.zzo> {
    private String zzgc;
    private String zzgh;
    private String zzhw;
    private String zzid;
    private long zzos;

    public final String getIdToken() {
        return this.zzgc;
    }

    public final /* synthetic */ com.google.firebase.auth.api.internal.zzdw zza(zzhc zzhcVar) {
        if (zzhcVar instanceof zzj.zzo) {
            zzj.zzo zzoVar = (zzj.zzo) zzhcVar;
            this.zzgc = Strings.a(zzoVar.getIdToken());
            this.zzhw = Strings.a(zzoVar.getDisplayName());
            this.zzgh = Strings.a(zzoVar.getEmail());
            this.zzid = Strings.a(zzoVar.zzr());
            this.zzos = zzoVar.zzs();
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of SignUpNewUserResponse.");
    }

    public final zzhm<zzj.zzo> zzdj() {
        return zzj.zzo.zzl();
    }

    public final String zzr() {
        return this.zzid;
    }

    public final long zzs() {
        return this.zzos;
    }
}
