package com.google.android.gms.internal.ads;

import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzro implements zzsb {
    private final zzrg zzbvr;
    private final zzbgg zzbvs;
    private final com.google.android.gms.ads.internal.gmsg.zzu<zzbgg> zzbvt = new C0908fm(this);
    private final com.google.android.gms.ads.internal.gmsg.zzu<zzbgg> zzbvu = new C0922gm(this);
    private final com.google.android.gms.ads.internal.gmsg.zzu<zzbgg> zzbvv = new C0936hm(this);

    public zzro(zzrg zzrgVar, zzbgg zzbggVar) {
        this.zzbvr = zzrgVar;
        this.zzbvs = zzbggVar;
        zzbgg zzbggVar2 = this.zzbvs;
        zzbggVar2.zza("/updateActiveView", this.zzbvt);
        zzbggVar2.zza("/untrackActiveViewUnit", this.zzbvu);
        zzbggVar2.zza("/visibilityChanged", this.zzbvv);
        String valueOf = String.valueOf(this.zzbvr.zzbuu.zzmt());
        zzbbd.zzdn(valueOf.length() != 0 ? "Custom JS tracking ad unit: ".concat(valueOf) : new String("Custom JS tracking ad unit: "));
    }

    @Override // com.google.android.gms.internal.ads.zzsb
    public final void zzb(JSONObject jSONObject, boolean z) {
        if (!z) {
            this.zzbvs.zzb("AFMA_updateActiveView", jSONObject);
        } else {
            this.zzbvr.zzb(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsb
    public final boolean zznf() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzsb
    public final void zzng() {
        zzbgg zzbggVar = this.zzbvs;
        zzbggVar.zzb("/visibilityChanged", this.zzbvv);
        zzbggVar.zzb("/untrackActiveViewUnit", this.zzbvu);
        zzbggVar.zzb("/updateActiveView", this.zzbvt);
    }
}
