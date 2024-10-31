package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.gmsg.HttpClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzatd extends zzaxv {
    private final Context mContext;
    private final Object zzdsn;
    private final zzarm zzdvp;
    private final zzasj zzdvq;
    private zzur zzdvs;
    private zzaji zzdzx;

    @VisibleForTesting
    private static final long zzdzr = TimeUnit.SECONDS.toMillis(10);
    private static final Object sLock = new Object();

    @VisibleForTesting
    private static boolean zzdzs = false;
    private static zzait zzdzt = null;
    private static HttpClient zzdzu = null;
    private static com.google.android.gms.ads.internal.gmsg.zzz zzdzv = null;
    private static com.google.android.gms.ads.internal.gmsg.zzu<Object> zzdzw = null;

    public zzatd(Context context, zzasj zzasjVar, zzarm zzarmVar, zzur zzurVar) {
        super(true);
        this.zzdsn = new Object();
        this.zzdvp = zzarmVar;
        this.mContext = context;
        this.zzdvq = zzasjVar;
        this.zzdvs = zzurVar;
        synchronized (sLock) {
            if (!zzdzs) {
                zzdzv = new com.google.android.gms.ads.internal.gmsg.zzz();
                zzdzu = new HttpClient(context.getApplicationContext(), zzasjVar.zzbsp);
                zzdzw = new zzatl();
                zzdzt = new zzait(this.mContext.getApplicationContext(), this.zzdvq.zzbsp, (String) zzwu.zzpz().zzd(zzaan.zzcnw), new zzatk(), new zzatj());
                zzdzs = true;
            }
        }
    }

    private final JSONObject zza(zzasi zzasiVar, String str) {
        zzatz zzatzVar;
        AdvertisingIdClient.Info info;
        Bundle bundle = zzasiVar.zzdwg.extras.getBundle("sdk_less_server_data");
        if (bundle == null) {
            return null;
        }
        try {
            zzatzVar = com.google.android.gms.ads.internal.zzbv.p().zzt(this.mContext).get();
        } catch (Exception e2) {
            zzbbd.zzc("Error grabbing device info: ", e2);
            zzatzVar = null;
        }
        Context context = this.mContext;
        zzato zzatoVar = new zzato();
        zzatoVar.zzeag = zzasiVar;
        zzatoVar.zzeah = zzatzVar;
        JSONObject zza = zzatv.zza(context, zzatoVar);
        if (zza == null) {
            return null;
        }
        try {
            info = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e3) {
            zzbbd.zzc("Cannot get advertising id info", e3);
            info = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("request_id", str);
        hashMap.put("request_param", zza);
        hashMap.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bundle);
        if (info != null) {
            hashMap.put("adid", info.getId());
            hashMap.put("lat", Integer.valueOf(info.isLimitAdTrackingEnabled() ? 1 : 0));
        }
        try {
            return com.google.android.gms.ads.internal.zzbv.e().zzn(hashMap);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zzc(zzaii zzaiiVar) {
        zzaiiVar.zza("/loadAd", zzdzv);
        zzaiiVar.zza("/fetchHttpRequest", zzdzu);
        zzaiiVar.zza("/invalidRequest", zzdzw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zzd(zzaii zzaiiVar) {
        zzaiiVar.zzb("/loadAd", zzdzv);
        zzaiiVar.zzb("/fetchHttpRequest", zzdzu);
        zzaiiVar.zzb("/invalidRequest", zzdzw);
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void onStop() {
        synchronized (this.zzdsn) {
            zzbat.zztu.post(new Rc(this));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void zzki() {
        zzbbd.zzdn("SdkLessAdLoaderBackgroundTask started.");
        String zzz = com.google.android.gms.ads.internal.zzbv.E().zzz(this.mContext);
        zzasi zzasiVar = new zzasi(this.zzdvq, -1L, com.google.android.gms.ads.internal.zzbv.E().zzx(this.mContext), com.google.android.gms.ads.internal.zzbv.E().zzy(this.mContext), zzz, com.google.android.gms.ads.internal.zzbv.E().zzaa(this.mContext));
        zzasm zzc = zzc(zzasiVar);
        int i = zzc.errorCode;
        if ((i == -2 || i == 3) && !TextUtils.isEmpty(zzz)) {
            com.google.android.gms.ads.internal.zzbv.E().zzh(this.mContext, zzz);
        }
        zzbat.zztu.post(new Nc(this, new zzaxg(zzasiVar, zzc, null, null, zzc.errorCode, com.google.android.gms.ads.internal.zzbv.l().c(), zzc.zzdyh, null, this.zzdvs)));
    }

    private final zzasm zzc(zzasi zzasiVar) {
        com.google.android.gms.ads.internal.zzbv.e();
        String zzzs = zzayh.zzzs();
        JSONObject zza = zza(zzasiVar, zzzs);
        if (zza == null) {
            return new zzasm(0);
        }
        long c2 = com.google.android.gms.ads.internal.zzbv.l().c();
        Future<JSONObject> a2 = zzdzv.a(zzzs);
        zzbat.zztu.post(new Oc(this, zza, zzzs));
        try {
            JSONObject jSONObject = a2.get(zzdzr - (com.google.android.gms.ads.internal.zzbv.l().c() - c2), TimeUnit.MILLISECONDS);
            if (jSONObject == null) {
                return new zzasm(-1);
            }
            zzasm zza2 = zzatv.zza(this.mContext, zzasiVar, jSONObject.toString());
            return (zza2.errorCode == -3 || !TextUtils.isEmpty(zza2.zzdyb)) ? zza2 : new zzasm(3);
        } catch (InterruptedException | CancellationException unused) {
            return new zzasm(-1);
        } catch (ExecutionException unused2) {
            return new zzasm(0);
        } catch (TimeoutException unused3) {
            return new zzasm(2);
        }
    }
}
