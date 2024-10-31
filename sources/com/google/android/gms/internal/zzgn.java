package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.internal.zzgm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
/* loaded from: classes.dex */
public class zzgn implements zzgm.zza<com.google.android.gms.ads.internal.formats.zzd> {
    private final boolean zzEa;
    private final boolean zzEb;

    public zzgn(boolean z, boolean z2) {
        this.zzEa = z;
        this.zzEb = z2;
    }

    @Override // com.google.android.gms.internal.zzgm.zza
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public com.google.android.gms.ads.internal.formats.zzd zza(zzgm zzgmVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        List<zziq<com.google.android.gms.ads.internal.formats.zzc>> zza = zzgmVar.zza(jSONObject, "images", true, this.zzEa, this.zzEb);
        zziq<com.google.android.gms.ads.internal.formats.zzc> zza2 = zzgmVar.zza(jSONObject, "app_icon", true, this.zzEa);
        zziq<com.google.android.gms.ads.internal.formats.zza> zze = zzgmVar.zze(jSONObject);
        ArrayList arrayList = new ArrayList();
        Iterator<zziq<com.google.android.gms.ads.internal.formats.zzc>> it = zza.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().get());
        }
        return new com.google.android.gms.ads.internal.formats.zzd(jSONObject.getString("headline"), arrayList, jSONObject.getString("body"), zza2.get(), jSONObject.getString("call_to_action"), jSONObject.optDouble("rating", -1.0d), jSONObject.optString("store"), jSONObject.optString("price"), zze.get(), new Bundle());
    }
}
