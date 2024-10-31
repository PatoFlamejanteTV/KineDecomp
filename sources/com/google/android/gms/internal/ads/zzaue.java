package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzaue extends zzaug {
    private final Object mLock = new Object();
    private final Context zzbup;
    private SharedPreferences zzedt;
    private final zzajv<JSONObject, JSONObject> zzedu;

    public zzaue(Context context, zzajv<JSONObject, JSONObject> zzajvVar) {
        this.zzbup = context.getApplicationContext();
        this.zzedu = zzajvVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Void zzn(JSONObject jSONObject) {
        zzaan.zza(this.zzbup, 1, jSONObject);
        this.zzedt.edit().putLong("js_last_update", com.google.android.gms.ads.internal.zzbv.l().a()).apply();
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaug
    public final zzbcb<Void> zzwy() {
        synchronized (this.mLock) {
            if (this.zzedt == null) {
                this.zzedt = this.zzbup.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        if (com.google.android.gms.ads.internal.zzbv.l().a() - this.zzedt.getLong("js_last_update", 0L) < ((Long) zzwu.zzpz().zzd(zzaan.zzctz)).longValue()) {
            return zzbbq.zzm(null);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", zzbbi.zzaav().zzdp);
            jSONObject.put("mf", zzwu.zzpz().zzd(zzaan.zzcua));
            jSONObject.put("cl", "221522000");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("dynamite_version", DynamiteModule.b(this.zzbup, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", 12451009);
            return zzbbq.zza(this.zzedu.zzj(jSONObject), new zzbbm(this) { // from class: com.google.android.gms.internal.ads.Xc

                /* renamed from: a, reason: collision with root package name */
                private final zzaue f11955a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f11955a = this;
                }

                @Override // com.google.android.gms.internal.ads.zzbbm
                public final Object apply(Object obj) {
                    return this.f11955a.zzn((JSONObject) obj);
                }
            }, zzbcg.zzepp);
        } catch (JSONException e2) {
            zzbbd.zzb("Unable to populate SDK Core Constants parameters.", e2);
            return zzbbq.zzm(null);
        }
    }
}
