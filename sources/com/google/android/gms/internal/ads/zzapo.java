package com.google.android.gms.internal.ads;

import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzapo extends zzaxv {
    private final zzapm zzdsj;
    private final zzaxg zzdsk;
    private final zzasm zzdsl;

    public zzapo(zzaxg zzaxgVar, zzapm zzapmVar) {
        this.zzdsk = zzaxgVar;
        this.zzdsl = this.zzdsk.zzehy;
        this.zzdsj = zzapmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void onStop() {
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void zzki() {
        zzaxg zzaxgVar = this.zzdsk;
        zzasi zzasiVar = zzaxgVar.zzeag;
        zzwb zzwbVar = zzasiVar.zzdwg;
        zzasm zzasmVar = this.zzdsl;
        int i = zzasmVar.orientation;
        long j = zzasmVar.zzdlx;
        String str = zzasiVar.zzdwj;
        long j2 = zzasmVar.zzdye;
        zzwf zzwfVar = zzaxgVar.zzbst;
        long j3 = zzasmVar.zzdyc;
        long j4 = zzaxgVar.zzehn;
        long j5 = zzasmVar.zzdyh;
        String str2 = zzasmVar.zzdyi;
        JSONObject jSONObject = zzaxgVar.zzehh;
        zzasm zzasmVar2 = zzaxgVar.zzehy;
        zzayh.zzelc.post(new Tb(this, new zzaxf(zzwbVar, null, null, 0, null, null, i, j, str, false, null, null, null, null, null, j2, zzwfVar, j3, j4, j5, str2, jSONObject, null, null, null, null, zzasmVar2.zzdyu, zzasmVar2.zzdyv, null, null, null, zzaxgVar.zzehw, zzasmVar2.zzbph, zzaxgVar.zzehx, zzasmVar2.zzdzc, null, zzasmVar2.zzbpi, zzasmVar2.zzdzd, zzasmVar2.zzdzf)));
    }
}
