package com.google.android.gms.internal.ads;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public final class zzap {
    public static zzc zzb(zzp zzpVar) {
        long j;
        long j2;
        boolean z;
        long j3;
        long j4;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = zzpVar.zzab;
        String str = map.get("Date");
        long zzf = str != null ? zzf(str) : 0L;
        String str2 = map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            j = 0;
            int i2 = 0;
            j2 = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j2 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    i2 = 1;
                }
                i++;
            }
            i = i2;
            z = true;
        } else {
            j = 0;
            j2 = 0;
            z = false;
        }
        String str3 = map.get("Expires");
        long zzf2 = str3 != null ? zzf(str3) : 0L;
        String str4 = map.get("Last-Modified");
        long zzf3 = str4 != null ? zzf(str4) : 0L;
        String str5 = map.get("ETag");
        if (z) {
            j3 = currentTimeMillis + (j * 1000);
            if (i == 0) {
                Long.signum(j2);
                j4 = (j2 * 1000) + j3;
            }
            j4 = j3;
        } else if (zzf <= 0 || zzf2 < zzf) {
            j3 = 0;
            j4 = j3;
        } else {
            j4 = (zzf2 - zzf) + currentTimeMillis;
            j3 = j4;
        }
        zzc zzcVar = new zzc();
        zzcVar.data = zzpVar.data;
        zzcVar.zza = str5;
        zzcVar.zze = j3;
        zzcVar.zzd = j4;
        zzcVar.zzb = zzf;
        zzcVar.zzc = zzf3;
        zzcVar.zzf = map;
        zzcVar.zzg = zzpVar.allHeaders;
        return zzcVar;
    }

    private static long zzf(String str) {
        try {
            return zzq().parse(str).getTime();
        } catch (ParseException e2) {
            zzaf.zza(e2, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    private static SimpleDateFormat zzq() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static String zzb(long j) {
        return zzq().format(new Date(j));
    }
}
