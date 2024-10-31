package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzj;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzdm implements com.google.firebase.auth.api.internal.zzdw<zzdm, zzj.zzm> {
    private String zzgc;
    private String zzgh;
    private String zzgi;
    private String zzhw;
    private String zzhx;
    private String zzid;
    private long zzos;
    private zzdd zzpb;
    private Boolean zzpv;

    public final String getEmail() {
        return this.zzgh;
    }

    public final String getIdToken() {
        return this.zzgc;
    }

    public final /* synthetic */ com.google.firebase.auth.api.internal.zzdw zza(zzhc zzhcVar) {
        if (zzhcVar instanceof zzj.zzm) {
            zzj.zzm zzmVar = (zzj.zzm) zzhcVar;
            this.zzgh = Strings.a(zzmVar.getEmail());
            this.zzgi = Strings.a(zzmVar.zzam());
            this.zzpv = Boolean.valueOf(zzmVar.zzan());
            this.zzhw = Strings.a(zzmVar.getDisplayName());
            this.zzhx = Strings.a(zzmVar.zzal());
            this.zzpb = zzdd.zzc(zzmVar.zzak());
            this.zzgc = Strings.a(zzmVar.getIdToken());
            this.zzid = Strings.a(zzmVar.zzr());
            this.zzos = zzmVar.zzs();
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of SetAccountInfoResponse.");
    }

    public final zzhm<zzj.zzm> zzdj() {
        return zzj.zzm.zzl();
    }

    public final List<zzdb> zzdu() {
        zzdd zzddVar = this.zzpb;
        if (zzddVar != null) {
            return zzddVar.zzdu();
        }
        return null;
    }

    public final String zzr() {
        return this.zzid;
    }

    public final long zzs() {
        return this.zzos;
    }
}
