package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzbfq implements com.google.android.gms.ads.internal.gmsg.zzu<zzbdz> {
    private static Integer zze(Map<String, String> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(map.get(str)));
        } catch (NumberFormatException unused) {
            String str2 = map.get(str);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 39 + String.valueOf(str2).length());
            sb.append("Precache invalid numeric parameter '");
            sb.append(str);
            sb.append("': ");
            sb.append(str2);
            zzbbd.zzeo(sb.toString());
            return null;
        }
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzbdz zzbdzVar, Map map) {
        zzbfk zzbfkVar;
        zzbdz zzbdzVar2 = zzbdzVar;
        if (zzbbd.isLoggable(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String valueOf = String.valueOf(jSONObject);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 15);
            sb.append("Precache GMSG: ");
            sb.append(valueOf);
            zzbbd.zzdn(sb.toString());
        }
        com.google.android.gms.ads.internal.zzbv.C();
        if (map.containsKey("abort")) {
            if (zzbfj.zzc(zzbdzVar2)) {
                return;
            }
            zzbbd.zzeo("Precache abort but no precache task running.");
            return;
        }
        String str = (String) map.get("src");
        if (str != null) {
            if (zzbfj.zzd(zzbdzVar2) != null) {
                zzbbd.zzeo("Precache task is already running.");
                return;
            }
            if (zzbdzVar2.zzid() == null) {
                zzbbd.zzeo("Precache requires a dependency provider.");
                return;
            }
            zzbdy zzbdyVar = new zzbdy((String) map.get("flags"));
            Integer zze = zze(map, "player");
            if (zze == null) {
                zze = 0;
            }
            zzbfkVar = zzbdzVar2.zzid().f10264a.zza(zzbdzVar2, zze.intValue(), null, zzbdyVar);
            new zzbfh(zzbdzVar2, zzbfkVar, str).zzwa();
        } else {
            zzbfh zzd = zzbfj.zzd(zzbdzVar2);
            if (zzd != null) {
                zzbfkVar = zzd.zzewk;
            } else {
                zzbbd.zzeo("Precache must specify a source.");
                return;
            }
        }
        Integer zze2 = zze(map, "minBufferMs");
        if (zze2 != null) {
            zzbfkVar.zzcz(zze2.intValue());
        }
        Integer zze3 = zze(map, "maxBufferMs");
        if (zze3 != null) {
            zzbfkVar.zzda(zze3.intValue());
        }
        Integer zze4 = zze(map, "bufferForPlaybackMs");
        if (zze4 != null) {
            zzbfkVar.zzdb(zze4.intValue());
        }
        Integer zze5 = zze(map, "bufferForPlaybackAfterRebufferMs");
        if (zze5 != null) {
            zzbfkVar.zzdc(zze5.intValue());
        }
    }
}
