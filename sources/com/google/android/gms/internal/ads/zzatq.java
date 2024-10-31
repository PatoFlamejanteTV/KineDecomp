package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzatq extends zzasr {
    private static final Object sLock = new Object();
    private static zzatq zzeau;
    private final Context mContext;
    private final zzatp zzeav;
    private final ScheduledExecutorService zzeaw = Executors.newSingleThreadScheduledExecutor();

    private zzatq(Context context, zzatp zzatpVar) {
        this.mContext = context;
        this.zzeav = zzatpVar;
    }

    public static zzatq zza(Context context, zzatp zzatpVar) {
        zzatq zzatqVar;
        synchronized (sLock) {
            if (zzeau == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                zzaan.initialize(context);
                zzeau = new zzatq(context, zzatpVar);
                if (context.getApplicationContext() != null) {
                    com.google.android.gms.ads.internal.zzbv.e().zzaj(context);
                }
                zzaxx.zzag(context);
            }
            zzatqVar = zzeau;
        }
        return zzatqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzasq
    public final void zzb(zzatb zzatbVar, zzasw zzaswVar) {
        zzaxz.v("Nonagon code path entered in octagon");
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.ads.zzasq
    public final zzasm zzb(zzasi zzasiVar) {
        return zza(this.mContext, this.zzeav, zzasiVar, this.zzeaw);
    }

    @Override // com.google.android.gms.internal.ads.zzasq
    public final void zza(zzatb zzatbVar, zzasw zzaswVar) {
        zzaxz.v("Nonagon code path entered in octagon");
        throw new IllegalArgumentException();
    }

    private static zzasm zza(Context context, zzatp zzatpVar, zzasi zzasiVar, ScheduledExecutorService scheduledExecutorService) {
        Bundle bundle;
        String uuid;
        char c2;
        String string;
        zzbbd.zzdn("Starting ad request from service using: google.afma.request.getAdDictionary");
        zzaba zzabaVar = new zzaba(((Boolean) zzwu.zzpz().zzd(zzaan.zzcpw)).booleanValue(), "load_ad", zzasiVar.zzbst.zzckk);
        if (zzasiVar.versionCode > 10) {
            long j = zzasiVar.zzdwv;
            if (j != -1) {
                zzabaVar.zza(zzabaVar.zzao(j), "cts");
            }
        }
        zzaay zzrg = zzabaVar.zzrg();
        zzbcb zza = zzbbq.zza(zzatpVar.zzear.zzm(context), ((Long) zzwu.zzpz().zzd(zzaan.zzcvj)).longValue(), TimeUnit.MILLISECONDS, scheduledExecutorService);
        zzbcb<String> zzm = zzbbq.zzm(null);
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcxz)).booleanValue()) {
            zzm = zzatpVar.zzeam.zzdo(zzasiVar.zzdwh.packageName);
        }
        zzbcb<String> zzdp = zzatpVar.zzeam.zzdp(zzasiVar.zzdwh.packageName);
        zzbcb<String> zza2 = zzatpVar.zzeas.zza(zzasiVar.zzdwi, zzasiVar.zzdwh);
        Future<zzatz> zzt = com.google.android.gms.ads.internal.zzbv.p().zzt(context);
        zzbcb<Location> zzm2 = zzbbq.zzm(null);
        Bundle bundle2 = zzasiVar.zzdwg.extras;
        boolean z = (bundle2 == null || bundle2.getString("_ad") == null) ? false : true;
        if (zzasiVar.zzdxb && !z) {
            zzm2 = zzatpVar.zzeap.zza(zzasiVar.applicationInfo);
        }
        zzbcb<String> zzbcbVar = zzm;
        zzbcb zza3 = zzbbq.zza(zzm2, ((Long) zzwu.zzpz().zzd(zzaan.zzcuu)).longValue(), TimeUnit.MILLISECONDS, scheduledExecutorService);
        Future zzm3 = zzbbq.zzm(null);
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcro)).booleanValue()) {
            zzm3 = zzbbq.zza(zzatpVar.zzeas.zzad(context), ((Long) zzwu.zzpz().zzd(zzaan.zzcrp)).longValue(), TimeUnit.MILLISECONDS, scheduledExecutorService);
        }
        if (zzasiVar.versionCode < 4 || (bundle = zzasiVar.zzdwm) == null) {
            bundle = null;
        }
        com.google.android.gms.ads.internal.zzbv.e();
        if (zzayh.zzn(context, "android.permission.ACCESS_NETWORK_STATE") && ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() == null) {
            zzbbd.zzdn("Device is offline.");
        }
        if (zzasiVar.versionCode >= 7) {
            uuid = zzasiVar.zzdws;
        } else {
            uuid = UUID.randomUUID().toString();
        }
        Bundle bundle3 = zzasiVar.zzdwg.extras;
        if (bundle3 != null && (string = bundle3.getString("_ad")) != null) {
            return zzatv.zza(context, zzasiVar, string);
        }
        List<String> zzf = zzatpVar.zzean.zzf(zzasiVar.zzdwt);
        String str = uuid;
        Bundle bundle4 = (Bundle) zzbbq.zza(zza, (Object) null, ((Long) zzwu.zzpz().zzd(zzaan.zzcvj)).longValue(), TimeUnit.MILLISECONDS);
        Location location = (Location) zzbbq.zza(zza3, (Object) null);
        AdvertisingIdClient.Info info = (AdvertisingIdClient.Info) zzbbq.zza((Future<Object>) zzm3, (Object) null);
        String str2 = (String) zzbbq.zza(zza2, (Object) null);
        String str3 = (String) zzbbq.zza(zzbcbVar, (Object) null);
        String str4 = (String) zzbbq.zza(zzdp, (Object) null);
        zzatz zzatzVar = (zzatz) zzbbq.zza(zzt, (Object) null);
        if (zzatzVar == null) {
            zzbbd.zzeo("Error fetching device info. This is not recoverable.");
            return new zzasm(0);
        }
        zzato zzatoVar = new zzato();
        zzatoVar.zzeag = zzasiVar;
        zzatoVar.zzeah = zzatzVar;
        zzatoVar.zzcjj = location;
        zzatoVar.zzeac = bundle4;
        zzatoVar.zzdwi = str2;
        zzatoVar.zzeaf = info;
        if (zzf == null) {
            zzatoVar.zzdwt.clear();
        }
        zzatoVar.zzdwt = zzf;
        zzatoVar.zzdwm = bundle;
        zzatoVar.zzead = str3;
        zzatoVar.zzeae = str4;
        zzatoVar.zzeai = zzatpVar.zzeal.zzf(context);
        zzatoVar.zzeaj = zzatpVar.zzeaj;
        JSONObject zza4 = zzatv.zza(context, zzatoVar);
        if (zza4 == null) {
            return new zzasm(0);
        }
        if (zzasiVar.versionCode < 7) {
            try {
                zza4.put("request_id", str);
            } catch (JSONException unused) {
            }
        }
        zzabaVar.zza(zzrg, "arc");
        zzbcb zza5 = zzbbq.zza(zzbbq.zza(zzatpVar.zzeat.zzwo().zzj(zza4), Sc.f11823a, scheduledExecutorService), 10L, TimeUnit.SECONDS, scheduledExecutorService);
        zzbcb<Void> zzwy = zzatpVar.zzeao.zzwy();
        if (zzwy != null) {
            zzbbo.zza(zzwy, "AdRequestServiceImpl.loadAd.flags");
        }
        zzaty zzatyVar = (zzaty) zzbbq.zza(zza5, (Object) null);
        if (zzatyVar == null) {
            return new zzasm(0);
        }
        if (zzatyVar.getErrorCode() != -2) {
            return new zzasm(zzatyVar.getErrorCode());
        }
        zzabaVar.zzrj();
        zzasm zza6 = !TextUtils.isEmpty(zzatyVar.zzwt()) ? zzatv.zza(context, zzasiVar, zzatyVar.zzwt()) : null;
        if (zza6 == null && !TextUtils.isEmpty(zzatyVar.getUrl())) {
            zza6 = zza(zzasiVar, context, zzasiVar.zzbsp.zzdp, zzatyVar.getUrl(), str3, str4, zzatyVar, zzabaVar, zzatpVar);
        }
        if (zza6 == null) {
            c2 = 0;
            zza6 = new zzasm(0);
        } else {
            c2 = 0;
        }
        String[] strArr = new String[1];
        strArr[c2] = "tts";
        zzabaVar.zza(zzrg, strArr);
        zza6.zzdyq = zzabaVar.zzrh();
        zza6.zzdze = zzatyVar.zzwv();
        return zza6;
    }

    private static void zza(String str, Map<String, List<String>> map, String str2, int i) {
        if (zzbbd.isLoggable(2)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 39);
            sb.append("Http Response: {\n  URL:\n    ");
            sb.append(str);
            sb.append("\n  Headers:");
            zzaxz.v(sb.toString());
            if (map != null) {
                for (String str3 : map.keySet()) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 5);
                    sb2.append("    ");
                    sb2.append(str3);
                    sb2.append(":");
                    zzaxz.v(sb2.toString());
                    Iterator<String> it = map.get(str3).iterator();
                    while (it.hasNext()) {
                        String valueOf = String.valueOf(it.next());
                        zzaxz.v(valueOf.length() != 0 ? "      ".concat(valueOf) : new String("      "));
                    }
                }
            }
            zzaxz.v("  Body:");
            if (str2 != null) {
                int i2 = 0;
                while (i2 < Math.min(str2.length(), NexVideoClipItem.ABSTRACT_DIMENSION)) {
                    int i3 = i2 + 1000;
                    zzaxz.v(str2.substring(i2, Math.min(str2.length(), i3)));
                    i2 = i3;
                }
            } else {
                zzaxz.v("    null");
            }
            StringBuilder sb3 = new StringBuilder(34);
            sb3.append("  Response Code:\n    ");
            sb3.append(i);
            sb3.append("\n}");
            zzaxz.v(sb3.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008c A[Catch: all -> 0x01ca, TryCatch #4 {all -> 0x01ca, blocks: (B:13:0x0051, B:15:0x0062, B:17:0x0068, B:18:0x0072, B:20:0x0078, B:21:0x0084, B:23:0x008c, B:26:0x0099, B:28:0x00a3, B:33:0x00be, B:34:0x00ce, B:38:0x00eb, B:43:0x00ff, B:45:0x010d, B:46:0x0118, B:55:0x012e, B:56:0x0131, B:60:0x0132, B:64:0x0140, B:82:0x014c, B:66:0x0162, B:76:0x017b, B:68:0x0191, B:89:0x01a5, B:98:0x00c9, B:99:0x00cc), top: B:12:0x0051, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzasm zza(com.google.android.gms.internal.ads.zzasi r18, android.content.Context r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, com.google.android.gms.internal.ads.zzaty r24, com.google.android.gms.internal.ads.zzaba r25, com.google.android.gms.internal.ads.zzatp r26) {
        /*
            Method dump skipped, instructions count: 507
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzatq.zza(com.google.android.gms.internal.ads.zzasi, android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.ads.zzaty, com.google.android.gms.internal.ads.zzaba, com.google.android.gms.internal.ads.zzatp):com.google.android.gms.internal.ads.zzasm");
    }

    @Override // com.google.android.gms.internal.ads.zzasq
    public final void zza(zzasi zzasiVar, zzast zzastVar) {
        com.google.android.gms.ads.internal.zzbv.i().zzd(this.mContext, zzasiVar.zzbsp);
        zzbcb<?> zzc = zzayf.zzc(new Tc(this, zzasiVar, zzastVar));
        com.google.android.gms.ads.internal.zzbv.u().zzaak();
        com.google.android.gms.ads.internal.zzbv.u().getHandler().postDelayed(new Uc(this, zzc), 60000L);
    }
}
