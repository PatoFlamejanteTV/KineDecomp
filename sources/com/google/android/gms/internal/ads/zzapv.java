package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzapv implements zzaqe<zzabq> {
    @Override // com.google.android.gms.internal.ads.zzaqe
    public final /* synthetic */ zzabq zza(zzapw zzapwVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        zzbcb<zzbgg> zza;
        JSONObject zza2 = zzbac.zza(jSONObject, "html_containers", "instream");
        if (zza2 == null) {
            zza = zzapwVar.zzc(jSONObject, "video");
        } else {
            zza = zzapwVar.zza(zza2.optString("base_url"), zza2.optString("html"), true);
        }
        zzbgg zzc = zzapw.zzc(zza);
        if (zzc == null) {
            zzbbd.zzeo("Can not get video view for instream ad.");
            return null;
        }
        return new zzabq(zzc);
    }
}
