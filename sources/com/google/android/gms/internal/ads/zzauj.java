package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzauj implements zzatu {
    private zzajv<JSONObject, JSONObject> zzedu;
    private zzajv<JSONObject, JSONObject> zzedw;

    public zzauj(Context context) {
        zzakd zzb = com.google.android.gms.ads.internal.zzbv.t().zzb(context, zzbbi.zzaav());
        zzajz<JSONObject> zzajzVar = zzaka.zzdkb;
        this.zzedw = zzb.zza("google.afma.request.getAdDictionary", zzajzVar, zzajzVar);
        zzakd zzb2 = com.google.android.gms.ads.internal.zzbv.t().zzb(context, zzbbi.zzaav());
        zzajz<JSONObject> zzajzVar2 = zzaka.zzdkb;
        this.zzedu = zzb2.zza("google.afma.sdkConstants.getSdkConstants", zzajzVar2, zzajzVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzatu
    public final zzajv<JSONObject, JSONObject> zzwo() {
        return this.zzedw;
    }

    @Override // com.google.android.gms.internal.ads.zzatu
    public final zzajv<JSONObject, JSONObject> zzwp() {
        return this.zzedu;
    }
}
