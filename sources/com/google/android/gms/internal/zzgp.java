package com.google.android.gms.internal;

import com.google.android.gms.internal.zzgm;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
/* loaded from: classes.dex */
public class zzgp implements zzgm.zza<com.google.android.gms.ads.internal.formats.zzf> {
    private final boolean zzEa;

    public zzgp(boolean z) {
        this.zzEa = z;
    }

    private void zza(zzgm zzgmVar, JSONObject jSONObject, zzmi<String, Future<com.google.android.gms.ads.internal.formats.zzc>> zzmiVar) throws JSONException {
        zzmiVar.put(jSONObject.getString("name"), zzgmVar.zza(jSONObject, "image_value", this.zzEa));
    }

    private void zza(JSONObject jSONObject, zzmi<String, String> zzmiVar) throws JSONException {
        zzmiVar.put(jSONObject.getString("name"), jSONObject.getString("string_value"));
    }

    private <K, V> zzmi<K, V> zzc(zzmi<K, Future<V>> zzmiVar) throws InterruptedException, ExecutionException {
        zzmi<K, V> zzmiVar2 = new zzmi<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= zzmiVar.size()) {
                return zzmiVar2;
            }
            zzmiVar2.put(zzmiVar.keyAt(i2), zzmiVar.valueAt(i2).get());
            i = i2 + 1;
        }
    }

    @Override // com.google.android.gms.internal.zzgm.zza
    /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public com.google.android.gms.ads.internal.formats.zzf zza(zzgm zzgmVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        zzmi<String, Future<com.google.android.gms.ads.internal.formats.zzc>> zzmiVar = new zzmi<>();
        zzmi<String, String> zzmiVar2 = new zzmi<>();
        zziq<com.google.android.gms.ads.internal.formats.zza> zze = zzgmVar.zze(jSONObject);
        JSONArray jSONArray = jSONObject.getJSONArray("custom_assets");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString("type");
            if ("string".equals(string)) {
                zza(jSONObject2, zzmiVar2);
            } else if ("image".equals(string)) {
                zza(zzgmVar, jSONObject2, zzmiVar);
            } else {
                com.google.android.gms.ads.internal.util.client.zzb.e("Unknown custom asset type: " + string);
            }
        }
        return new com.google.android.gms.ads.internal.formats.zzf(jSONObject.getString("custom_template_id"), zzc(zzmiVar), zzmiVar2, zze.get());
    }
}
