package com.google.android.gms.internal.firebase_auth;

import android.text.TextUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzj;

/* loaded from: classes2.dex */
public final class zzdt implements com.google.firebase.auth.api.internal.zzdw<zzdt, zzj.zzq> {
    private String zzgb;
    private String zzgc;
    private String zzgf;
    private String zzgh;
    private String zzhw;
    private String zzhx;
    private String zzid;
    private String zzoq;
    private boolean zzor;
    private long zzos;
    private String zzpl;
    private boolean zzqf;
    private boolean zzqg;
    private String zzqh;
    private String zzqi;
    private String zzqj;

    public final String getEmail() {
        return this.zzgh;
    }

    public final String getErrorMessage() {
        return this.zzqj;
    }

    public final String getIdToken() {
        return this.zzgc;
    }

    public final String getProviderId() {
        return this.zzgb;
    }

    public final String getRawUserInfo() {
        return this.zzpl;
    }

    public final boolean isNewUser() {
        return this.zzor;
    }

    public final /* synthetic */ com.google.firebase.auth.api.internal.zzdw zza(zzhc zzhcVar) {
        if (zzhcVar instanceof zzj.zzq) {
            zzj.zzq zzqVar = (zzj.zzq) zzhcVar;
            this.zzqf = zzqVar.zzau();
            this.zzqg = zzqVar.zzaw();
            this.zzgc = Strings.a(zzqVar.getIdToken());
            this.zzid = Strings.a(zzqVar.zzr());
            this.zzos = zzqVar.zzs();
            this.zzoq = Strings.a(zzqVar.getLocalId());
            this.zzgh = Strings.a(zzqVar.getEmail());
            this.zzhw = Strings.a(zzqVar.getDisplayName());
            this.zzhx = Strings.a(zzqVar.zzal());
            this.zzgb = Strings.a(zzqVar.getProviderId());
            this.zzpl = Strings.a(zzqVar.getRawUserInfo());
            this.zzor = zzqVar.zzt();
            this.zzqh = zzqVar.zzav();
            this.zzqi = zzqVar.zzax();
            this.zzqj = Strings.a(zzqVar.getErrorMessage());
            this.zzgf = Strings.a(zzqVar.zzay());
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of VerifyAssertionResponse.");
    }

    public final com.google.firebase.auth.zzd zzcv() {
        if (TextUtils.isEmpty(this.zzqh) && TextUtils.isEmpty(this.zzqi)) {
            return null;
        }
        String str = this.zzgf;
        if (str != null) {
            return com.google.firebase.auth.zzd.b(this.zzgb, this.zzqi, this.zzqh, str);
        }
        return com.google.firebase.auth.zzd.a(this.zzgb, this.zzqi, this.zzqh);
    }

    public final zzhm<zzj.zzq> zzdj() {
        return zzj.zzq.zzl();
    }

    public final boolean zzed() {
        return this.zzqf;
    }

    public final String zzr() {
        return this.zzid;
    }

    public final long zzs() {
        return this.zzos;
    }
}
