package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzj;

/* loaded from: classes2.dex */
public final class zzdy implements com.google.firebase.auth.api.internal.zzdw<zzdy, zzj.zzu> {
    private String zzgc;
    private String zzgh;
    private String zzhw;
    private String zzhx;
    private String zzid;
    private String zzoq;
    private long zzos;

    public final String getIdToken() {
        return this.zzgc;
    }

    public final /* synthetic */ com.google.firebase.auth.api.internal.zzdw zza(zzhc zzhcVar) {
        if (zzhcVar instanceof zzj.zzu) {
            zzj.zzu zzuVar = (zzj.zzu) zzhcVar;
            this.zzoq = Strings.a(zzuVar.getLocalId());
            this.zzgh = Strings.a(zzuVar.getEmail());
            this.zzhw = Strings.a(zzuVar.getDisplayName());
            this.zzgc = Strings.a(zzuVar.getIdToken());
            this.zzhx = Strings.a(zzuVar.zzal());
            this.zzid = Strings.a(zzuVar.zzr());
            this.zzos = zzuVar.zzs();
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of VerifyPasswordResponse.");
    }

    public final zzhm<zzj.zzu> zzdj() {
        return zzj.zzu.zzl();
    }

    public final String zzr() {
        return this.zzid;
    }

    public final long zzs() {
        return this.zzos;
    }
}
