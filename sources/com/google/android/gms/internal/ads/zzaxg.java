package com.google.android.gms.internal.ads;

import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzaxg {
    public final int errorCode;
    public final zzwf zzbst;
    public final zzasi zzeag;
    public final JSONObject zzehh;
    public final zzakr zzehj;
    public final long zzehn;
    public final long zzeho;
    public final zzum zzehw;
    public final boolean zzehx;
    public final zzasm zzehy;

    public zzaxg(zzasi zzasiVar, zzasm zzasmVar, zzakr zzakrVar, zzwf zzwfVar, int i, long j, long j2, JSONObject jSONObject, zzur zzurVar) {
        this.zzeag = zzasiVar;
        this.zzehy = zzasmVar;
        this.zzehj = null;
        this.zzbst = null;
        this.errorCode = i;
        this.zzehn = j;
        this.zzeho = j2;
        this.zzehh = null;
        this.zzehw = new zzum(zzurVar);
        this.zzehx = false;
    }

    public zzaxg(zzasi zzasiVar, zzasm zzasmVar, zzakr zzakrVar, zzwf zzwfVar, int i, long j, long j2, JSONObject jSONObject, zzum zzumVar, Boolean bool) {
        this.zzeag = zzasiVar;
        this.zzehy = zzasmVar;
        this.zzehj = zzakrVar;
        this.zzbst = zzwfVar;
        this.errorCode = i;
        this.zzehn = j;
        this.zzeho = j2;
        this.zzehh = jSONObject;
        this.zzehw = zzumVar;
        if (bool != null) {
            this.zzehx = bool.booleanValue();
        } else {
            this.zzehx = zzbal.zzf(zzasiVar.zzdwg.zzcjl);
        }
    }
}
