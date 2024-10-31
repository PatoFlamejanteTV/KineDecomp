package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzrs implements zzsb {
    private final Context mContext;
    private final zzrg zzbvr;
    private final com.google.android.gms.ads.internal.gmsg.zzaa zzbvx;
    private zzaji zzbvy;
    private boolean zzbvz;
    private final com.google.android.gms.ads.internal.gmsg.zzu<zzajr> zzbvt = new C1005mm(this);
    private final com.google.android.gms.ads.internal.gmsg.zzu<zzajr> zzbvu = new C1019nm(this);
    private final com.google.android.gms.ads.internal.gmsg.zzu<zzajr> zzbvv = new C1033om(this);
    private final com.google.android.gms.ads.internal.gmsg.zzu<zzajr> zzbwa = new C1061qm(this);

    public zzrs(zzrg zzrgVar, zzait zzaitVar, Context context) {
        this.zzbvr = zzrgVar;
        this.mContext = context;
        this.zzbvx = new com.google.android.gms.ads.internal.gmsg.zzaa(this.mContext);
        this.zzbvy = zzaitVar.zzb((zzcu) null);
        this.zzbvy.zza(new C0949im(this), new C0963jm(this));
        String valueOf = String.valueOf(this.zzbvr.zzbuu.zzmt());
        zzbbd.zzdn(valueOf.length() != 0 ? "Core JS tracking ad unit: ".concat(valueOf) : new String("Core JS tracking ad unit: "));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzajr zzajrVar) {
        zzajrVar.zza("/updateActiveView", this.zzbvt);
        zzajrVar.zza("/untrackActiveViewUnit", this.zzbvu);
        zzajrVar.zza("/visibilityChanged", this.zzbvv);
        if (com.google.android.gms.ads.internal.zzbv.E().zzv(this.mContext)) {
            zzajrVar.zza("/logScionEvent", this.zzbwa);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsb
    public final void zzb(JSONObject jSONObject, boolean z) {
        this.zzbvy.zza(new C0977km(this, jSONObject), new zzbcp());
    }

    @Override // com.google.android.gms.internal.ads.zzsb
    public final boolean zznf() {
        return this.zzbvz;
    }

    @Override // com.google.android.gms.internal.ads.zzsb
    public final void zzng() {
        this.zzbvy.zza(new C0991lm(this), new zzbcp());
        this.zzbvy.release();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(zzajr zzajrVar) {
        zzajrVar.zzb("/visibilityChanged", this.zzbvv);
        zzajrVar.zzb("/untrackActiveViewUnit", this.zzbvu);
        zzajrVar.zzb("/updateActiveView", this.zzbvt);
        if (com.google.android.gms.ads.internal.zzbv.E().zzv(this.mContext)) {
            zzajrVar.zzb("/logScionEvent", this.zzbwa);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean zza(zzrs zzrsVar, boolean z) {
        zzrsVar.zzbvz = true;
        return true;
    }
}
