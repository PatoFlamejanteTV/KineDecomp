package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzaan;
import com.google.android.gms.internal.ads.zzajv;
import com.google.android.gms.internal.ads.zzajz;
import com.google.android.gms.internal.ads.zzaka;
import com.google.android.gms.internal.ads.zzakd;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzaxj;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzbbo;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzbcb;
import com.google.android.gms.internal.ads.zzbcg;
import com.google.android.gms.internal.ads.zzwu;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzad {

    /* renamed from: b, reason: collision with root package name */
    private Context f10174b;

    /* renamed from: a, reason: collision with root package name */
    private final Object f10173a = new Object();

    /* renamed from: c, reason: collision with root package name */
    private long f10175c = 0;

    public final void a(Context context, zzbbi zzbbiVar, String str, Runnable runnable) {
        a(context, zzbbiVar, true, null, str, null, runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void a(Context context, zzbbi zzbbiVar, boolean z, zzaxj zzaxjVar, String str, String str2, Runnable runnable) {
        if (zzbv.l().c() - this.f10175c < 5000) {
            zzbbd.zzeo("Not retrying to fetch app settings");
            return;
        }
        this.f10175c = zzbv.l().c();
        boolean z2 = true;
        if (zzaxjVar != null) {
            if (!(zzbv.l().a() - zzaxjVar.zzyc() > ((Long) zzwu.zzpz().zzd(zzaan.zzcvb)).longValue()) && zzaxjVar.zzyd()) {
                z2 = false;
            }
        }
        if (z2) {
            if (context == null) {
                zzbbd.zzeo("Context not provided to fetch application settings");
                return;
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                zzbbd.zzeo("App settings could not be fetched. Required parameters missing");
                return;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            this.f10174b = applicationContext;
            zzakd zzb = zzbv.t().zzb(this.f10174b, zzbbiVar);
            zzajz<JSONObject> zzajzVar = zzaka.zzdkb;
            zzajv zza = zzb.zza("google.afma.config.fetchAppSettings", zzajzVar, zzajzVar);
            try {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("app_id", str);
                } else if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("ad_unit_id", str2);
                }
                jSONObject.put("is_init", z);
                jSONObject.put(com.umeng.analytics.pro.b.ad, context.getPackageName());
                zzbcb zzj = zza.zzj(jSONObject);
                zzbcb zza2 = zzbbq.zza(zzj, C0776b.f10023a, zzbcg.zzepp);
                if (runnable != null) {
                    zzj.zza(runnable, zzbcg.zzepp);
                }
                zzbbo.zza(zza2, "ConfigLoader.maybeFetchNewAppSettings");
            } catch (Exception e2) {
                zzbbd.zzb("Error requesting application settings", e2);
            }
        }
    }
}
