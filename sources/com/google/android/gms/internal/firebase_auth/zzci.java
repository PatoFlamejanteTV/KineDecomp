package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.api.internal.zzff;

/* loaded from: classes2.dex */
public final class zzci implements zzff<zzj.zza> {
    private final String zzgw;
    private String zzoj;
    private String zzok;

    public zzci(String str, String str2) {
        Preconditions.b(str);
        this.zzoj = str;
        this.zzok = "http://localhost";
        this.zzgw = str2;
    }

    public final /* synthetic */ zzhc zzds() {
        zzj.zza.C0082zza zze = zzj.zza.zzc().zzd(this.zzoj).zze(this.zzok);
        String str = this.zzgw;
        if (str != null) {
            zze.zzf(str);
        }
        return (zzj.zza) zze.zzhn();
    }
}
