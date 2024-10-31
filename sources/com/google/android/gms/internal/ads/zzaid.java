package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final /* synthetic */ class zzaid {
    public static void zza(zzaic zzaicVar, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zzaicVar.zzh(str, jSONObject.toString());
    }

    public static void zzb(zzaic zzaicVar, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        zzbbd.zzdn(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        zzaicVar.zzcg(sb.toString());
    }

    public static void zza(zzaic zzaicVar, String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("(");
        sb.append(str2);
        sb.append(");");
        zzaicVar.zzcg(sb.toString());
    }

    public static void zza(zzaic zzaicVar, String str, Map map) {
        try {
            zzaicVar.zza(str, com.google.android.gms.ads.internal.zzbv.e().zzn(map));
        } catch (JSONException unused) {
            zzbbd.zzeo("Could not convert parameters to JSON.");
        }
    }
}
