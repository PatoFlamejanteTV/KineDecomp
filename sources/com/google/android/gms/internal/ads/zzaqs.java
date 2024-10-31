package com.google.android.gms.internal.ads;

import android.support.v4.util.SimpleArrayMap;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzaqs implements zzaqe<zzabw> {
    private final boolean zzdut;

    public zzaqs(boolean z) {
        this.zzdut = z;
    }

    @Override // com.google.android.gms.internal.ads.zzaqe
    public final /* synthetic */ zzabw zza(zzapw zzapwVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        SimpleArrayMap simpleArrayMap2 = new SimpleArrayMap();
        zzbcb<zzabm> zzg = zzapwVar.zzg(jSONObject);
        zzbcb<zzbgg> zzc = zzapwVar.zzc(jSONObject, "video");
        JSONArray jSONArray = jSONObject.getJSONArray("custom_assets");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString("type");
            if ("string".equals(string)) {
                simpleArrayMap2.put(jSONObject2.getString("name"), jSONObject2.getString("string_value"));
            } else if (MessengerShareContentUtility.MEDIA_IMAGE.equals(string)) {
                simpleArrayMap.put(jSONObject2.getString("name"), zzapwVar.zza(jSONObject2, "image_value", this.zzdut));
            } else {
                String valueOf = String.valueOf(string);
                zzbbd.zzeo(valueOf.length() != 0 ? "Unknown custom asset type: ".concat(valueOf) : new String("Unknown custom asset type: "));
            }
        }
        zzbgg zzc2 = zzapw.zzc(zzc);
        String string2 = jSONObject.getString("custom_template_id");
        SimpleArrayMap simpleArrayMap3 = new SimpleArrayMap();
        for (int i2 = 0; i2 < simpleArrayMap.size(); i2++) {
            simpleArrayMap3.put(simpleArrayMap.keyAt(i2), ((Future) simpleArrayMap.valueAt(i2)).get());
        }
        return new zzabw(string2, simpleArrayMap3, simpleArrayMap2, zzg.get(), zzc2 != null ? zzc2.zzabu() : null, zzc2 != null ? zzc2.getView() : null);
    }
}
