package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zzj;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzdz;
import com.google.android.gms.internal.zzja;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
/* loaded from: classes.dex */
public final class zzgt extends zzj.zza {
    private static zzgt zzFA;
    private static final Object zzpy = new Object();
    private final Context mContext;
    private final zzgs zzFB;
    private final zzbr zzFC;
    private final zzdz zzrf;

    zzgt(Context context, zzbr zzbrVar, zzgs zzgsVar) {
        this.mContext = context;
        this.zzFB = zzgsVar;
        this.zzFC = zzbrVar;
        this.zzrf = new zzdz(context.getApplicationContext() != null ? context.getApplicationContext() : context, new VersionInfoParcel(8115000, 8115000, true), zzbrVar.zzdc(), new da(this), new zzdz.zzc());
    }

    private static AdResponseParcel zza(Context context, zzdz zzdzVar, zzbr zzbrVar, zzgs zzgsVar, AdRequestInfoParcel adRequestInfoParcel) {
        String string;
        com.google.android.gms.ads.internal.util.client.zzb.a("Starting ad request from service.");
        zzby.initialize(context);
        zzcg zzcgVar = new zzcg(zzby.zzuQ.get().booleanValue(), "load_ad", adRequestInfoParcel.d.b);
        if (adRequestInfoParcel.f620a > 10 && adRequestInfoParcel.B != -1) {
            zzcgVar.zza(zzcgVar.zzb(adRequestInfoParcel.B), "cts");
        }
        zzce zzdn = zzcgVar.zzdn();
        zzgsVar.zzFv.init();
        zzgy zzC = com.google.android.gms.ads.internal.zzp.k().zzC(context);
        if (zzC.zzGE == -1) {
            com.google.android.gms.ads.internal.util.client.zzb.a("Device is offline.");
            return new AdResponseParcel(2);
        }
        String uuid = adRequestInfoParcel.f620a >= 7 ? adRequestInfoParcel.w : UUID.randomUUID().toString();
        zzgv zzgvVar = new zzgv(uuid, adRequestInfoParcel.f.packageName);
        if (adRequestInfoParcel.c.c != null && (string = adRequestInfoParcel.c.c.getString("_ad")) != null) {
            return zzgu.zza(context, adRequestInfoParcel, string);
        }
        Location zzd = zzgsVar.zzFv.zzd(250L);
        String zzc = zzgsVar.zzFw.zzc(context, adRequestInfoParcel.g.packageName);
        JSONObject zza = zzgu.zza(context, adRequestInfoParcel, zzC, zzgsVar.zzFy.zzD(context), zzd, zzbrVar, zzc, zzgsVar.zzFx.zzax(adRequestInfoParcel.h), zzgsVar.zzFu.zza(adRequestInfoParcel));
        if (adRequestInfoParcel.f620a < 7) {
            try {
                zza.put("request_id", uuid);
            } catch (JSONException e) {
            }
        }
        if (zza == null) {
            return new AdResponseParcel(0);
        }
        String jSONObject = zza.toString();
        zzcgVar.zza(zzdn, "arc");
        zzce zzdn2 = zzcgVar.zzdn();
        if (zzby.zzum.get().booleanValue()) {
            zzid.zzIE.post(new cu(zzdzVar, zzgvVar, zzcgVar, zzdn2, jSONObject));
        } else {
            zzid.zzIE.post(new cx(context, adRequestInfoParcel, zzgvVar, zzcgVar, zzdn2, jSONObject, zzbrVar));
        }
        try {
            de deVar = zzgvVar.zzfS().get(10L, TimeUnit.SECONDS);
            if (deVar == null) {
                return new AdResponseParcel(0);
            }
            if (deVar.a() != -2) {
                return new AdResponseParcel(deVar.a());
            }
            if (zzcgVar.zzdq() != null) {
                zzcgVar.zza(zzcgVar.zzdq(), "rur");
            }
            AdResponseParcel zza2 = zza(adRequestInfoParcel, context, adRequestInfoParcel.k.b, deVar.d(), deVar.f() ? zzgsVar.zzFt.zzaw(adRequestInfoParcel.g.packageName) : null, zzc, deVar, zzcgVar, zzgsVar);
            if (zza2.x == 1) {
                zzgsVar.zzFw.clearToken(context, adRequestInfoParcel.g.packageName);
            }
            zzcgVar.zza(zzdn, "tts");
            zza2.z = zzcgVar.zzdp();
            return zza2;
        } catch (Exception e2) {
            return new AdResponseParcel(0);
        } finally {
            zzid.zzIE.post(new cy(zzgvVar));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x018f, code lost:            com.google.android.gms.ads.internal.util.client.zzb.e("Received error HTTP response code: " + r9);        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel(0);     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01ab, code lost:            r2.disconnect();     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01ae, code lost:            if (r21 == null) goto L77;     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01b0, code lost:            r21.zzFz.zzfZ();     */
    /* JADX WARN: Code restructure failed: missing block: B:95:?, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.ads.internal.request.AdResponseParcel zza(com.google.android.gms.ads.internal.request.AdRequestInfoParcel r13, android.content.Context r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, com.google.android.gms.internal.de r19, com.google.android.gms.internal.zzcg r20, com.google.android.gms.internal.zzgs r21) {
        /*
            Method dump skipped, instructions count: 467
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgt.zza(com.google.android.gms.ads.internal.request.AdRequestInfoParcel, android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.de, com.google.android.gms.internal.zzcg, com.google.android.gms.internal.zzgs):com.google.android.gms.ads.internal.request.AdResponseParcel");
    }

    public static zzgt zza(Context context, zzbr zzbrVar, zzgs zzgsVar) {
        zzgt zzgtVar;
        synchronized (zzpy) {
            if (zzFA == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                zzFA = new zzgt(context, zzbrVar, zzgsVar);
            }
            zzgtVar = zzFA;
        }
        return zzgtVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzja.zza zza(String str, zzcg zzcgVar, zzce zzceVar) {
        return new cz(zzcgVar, zzceVar, str);
    }

    private static void zza(String str, Map<String, List<String>> map, String str2, int i) {
        if (com.google.android.gms.ads.internal.util.client.zzb.a(2)) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (String str3 : map.keySet()) {
                    com.google.android.gms.ads.internal.util.client.zzb.d("    " + str3 + ":");
                    Iterator<String> it = map.get(str3).iterator();
                    while (it.hasNext()) {
                        com.google.android.gms.ads.internal.util.client.zzb.d("      " + it.next());
                    }
                }
            }
            com.google.android.gms.ads.internal.util.client.zzb.d("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), NexVideoClipItem.ABSTRACT_DIMENSION); i2 += LicenseErrCode.LICENSE_STATUS_NOT_LICENSED) {
                    com.google.android.gms.ads.internal.util.client.zzb.d(str2.substring(i2, Math.min(str2.length(), i2 + LicenseErrCode.LICENSE_STATUS_NOT_LICENSED)));
                }
            } else {
                com.google.android.gms.ads.internal.util.client.zzb.d("    null");
            }
            com.google.android.gms.ads.internal.util.client.zzb.d("  Response Code:\n    " + i + "\n}");
        }
    }

    @Override // com.google.android.gms.ads.internal.request.zzj
    public void zza(AdRequestInfoParcel adRequestInfoParcel, com.google.android.gms.ads.internal.request.zzk zzkVar) {
        com.google.android.gms.ads.internal.zzp.h().zzb(this.mContext, adRequestInfoParcel.k);
        zzid.zzb(new db(this, adRequestInfoParcel, zzkVar));
    }

    @Override // com.google.android.gms.ads.internal.request.zzj
    public AdResponseParcel zze(AdRequestInfoParcel adRequestInfoParcel) {
        return zza(this.mContext, this.zzrf, this.zzFC, this.zzFB, adRequestInfoParcel);
    }
}
