package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdz;
import java.util.concurrent.Future;

@zzgr
/* loaded from: classes.dex */
public final class zzgv {
    private String zzBY;
    private String zzFO;
    zzdz.zzd zzFQ;
    zziz zzoM;
    private final Object zzpd = new Object();
    private zzin<de> zzFP = new zzin<>();
    public final zzdk zzFR = new dc(this);
    public final zzdk zzFS = new dd(this);

    public zzgv(String str, String str2) {
        this.zzFO = str2;
        this.zzBY = str;
    }

    public void zzb(zzdz.zzd zzdVar) {
        this.zzFQ = zzdVar;
    }

    public void zze(zziz zzizVar) {
        this.zzoM = zzizVar;
    }

    public zzdz.zzd zzfR() {
        return this.zzFQ;
    }

    public Future<de> zzfS() {
        return this.zzFP;
    }

    public void zzfT() {
        if (this.zzoM != null) {
            this.zzoM.destroy();
            this.zzoM = null;
        }
    }
}
