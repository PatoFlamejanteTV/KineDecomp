package com.google.android.gms.internal;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@zzgr
/* loaded from: classes.dex */
public final class zzgw {
    private List<String> zzDJ;
    private String zzFU;
    private String zzFV;
    private List<String> zzFW;
    private String zzFX;
    private String zzFY;
    private List<String> zzFZ;
    private String zzwq;
    private final AdRequestInfoParcel zzzz;
    private long zzGa = -1;
    private boolean zzGb = false;
    private final long zzGc = -1;
    private long zzGd = -1;
    private int mOrientation = -1;
    private boolean zzGe = false;
    private boolean zzGf = false;
    private boolean zzGg = false;
    private boolean zzGh = true;
    private int zzGi = 0;
    private String zzGj = "";
    private boolean zzGk = false;

    public zzgw(AdRequestInfoParcel adRequestInfoParcel) {
        this.zzzz = adRequestInfoParcel;
    }

    static String zzd(Map<String, List<String>> map, String str) {
        List<String> list = map.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    static long zze(Map<String, List<String>> map, String str) {
        List<String> list = map.get(str);
        if (list != null && !list.isEmpty()) {
            try {
                return Float.parseFloat(r0) * 1000.0f;
            } catch (NumberFormatException e) {
                com.google.android.gms.ads.internal.util.client.zzb.e("Could not parse float from " + str + " header: " + list.get(0));
            }
        }
        return -1L;
    }

    static List<String> zzf(Map<String, List<String>> map, String str) {
        String str2;
        List<String> list = map.get(str);
        if (list == null || list.isEmpty() || (str2 = list.get(0)) == null) {
            return null;
        }
        return Arrays.asList(str2.trim().split("\\s+"));
    }

    private boolean zzg(Map<String, List<String>> map, String str) {
        List<String> list = map.get(str);
        return (list == null || list.isEmpty() || !Boolean.valueOf(list.get(0)).booleanValue()) ? false : true;
    }

    private void zzi(Map<String, List<String>> map) {
        this.zzFU = zzd(map, "X-Afma-Ad-Size");
    }

    private void zzj(Map<String, List<String>> map) {
        List<String> zzf = zzf(map, "X-Afma-Click-Tracking-Urls");
        if (zzf != null) {
            this.zzFW = zzf;
        }
    }

    private void zzk(Map<String, List<String>> map) {
        List<String> list = map.get("X-Afma-Debug-Dialog");
        if (list == null || list.isEmpty()) {
            return;
        }
        this.zzFX = list.get(0);
    }

    private void zzl(Map<String, List<String>> map) {
        List<String> zzf = zzf(map, "X-Afma-Tracking-Urls");
        if (zzf != null) {
            this.zzFZ = zzf;
        }
    }

    private void zzm(Map<String, List<String>> map) {
        long zze = zze(map, "X-Afma-Interstitial-Timeout");
        if (zze != -1) {
            this.zzGa = zze;
        }
    }

    private void zzn(Map<String, List<String>> map) {
        this.zzFY = zzd(map, "X-Afma-ActiveView");
    }

    private void zzo(Map<String, List<String>> map) {
        this.zzGf = AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE.equals(zzd(map, "X-Afma-Ad-Format"));
    }

    private void zzp(Map<String, List<String>> map) {
        this.zzGe |= zzg(map, "X-Afma-Custom-Rendering-Allowed");
    }

    private void zzq(Map<String, List<String>> map) {
        this.zzGb |= zzg(map, "X-Afma-Mediation");
    }

    private void zzr(Map<String, List<String>> map) {
        List<String> zzf = zzf(map, "X-Afma-Manual-Tracking-Urls");
        if (zzf != null) {
            this.zzDJ = zzf;
        }
    }

    private void zzs(Map<String, List<String>> map) {
        long zze = zze(map, "X-Afma-Refresh-Rate");
        if (zze != -1) {
            this.zzGd = zze;
        }
    }

    private void zzt(Map<String, List<String>> map) {
        List<String> list = map.get("X-Afma-Orientation");
        if (list == null || list.isEmpty()) {
            return;
        }
        String str = list.get(0);
        if ("portrait".equalsIgnoreCase(str)) {
            this.mOrientation = com.google.android.gms.ads.internal.zzp.g().zzgH();
        } else if ("landscape".equalsIgnoreCase(str)) {
            this.mOrientation = com.google.android.gms.ads.internal.zzp.g().zzgG();
        }
    }

    private void zzu(Map<String, List<String>> map) {
        List<String> list = map.get("X-Afma-Use-HTTPS");
        if (list == null || list.isEmpty()) {
            return;
        }
        this.zzGg = Boolean.valueOf(list.get(0)).booleanValue();
    }

    private void zzv(Map<String, List<String>> map) {
        List<String> list = map.get("X-Afma-Content-Url-Opted-Out");
        if (list == null || list.isEmpty()) {
            return;
        }
        this.zzGh = Boolean.valueOf(list.get(0)).booleanValue();
    }

    private void zzw(Map<String, List<String>> map) {
        List<String> zzf = zzf(map, "X-Afma-OAuth-Token-Status");
        this.zzGi = 0;
        if (zzf == null) {
            return;
        }
        for (String str : zzf) {
            if ("Clear".equalsIgnoreCase(str)) {
                this.zzGi = 1;
                return;
            } else if ("No-Op".equalsIgnoreCase(str)) {
                this.zzGi = 0;
                return;
            }
        }
    }

    private void zzx(Map<String, List<String>> map) {
        List<String> list = map.get("X-Afma-Gws-Query-Id");
        if (list == null || list.isEmpty()) {
            return;
        }
        this.zzGj = list.get(0);
    }

    private void zzy(Map<String, List<String>> map) {
        String zzd = zzd(map, "X-Afma-Fluid");
        if (zzd == null || !zzd.equals("height")) {
            return;
        }
        this.zzGk = true;
    }

    public void zzb(String str, Map<String, List<String>> map, String str2) {
        this.zzFV = str;
        this.zzwq = str2;
        zzh(map);
    }

    public void zzh(Map<String, List<String>> map) {
        zzi(map);
        zzj(map);
        zzk(map);
        zzl(map);
        zzm(map);
        zzq(map);
        zzr(map);
        zzs(map);
        zzt(map);
        zzn(map);
        zzu(map);
        zzp(map);
        zzo(map);
        zzv(map);
        zzw(map);
        zzx(map);
        zzy(map);
    }

    public AdResponseParcel zzj(long j) {
        return new AdResponseParcel(this.zzzz, this.zzFV, this.zzwq, this.zzFW, this.zzFZ, this.zzGa, this.zzGb, -1L, this.zzDJ, this.zzGd, this.mOrientation, this.zzFU, j, this.zzFX, this.zzFY, this.zzGe, this.zzGf, this.zzGg, this.zzGh, false, this.zzGi, this.zzGj, this.zzGk);
    }
}
