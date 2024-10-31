package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.zza;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zzbr;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzdl;
import com.google.android.gms.internal.zzdp;
import com.google.android.gms.internal.zzdz;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzgu;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zziz;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
/* loaded from: classes.dex */
public class zzm extends zzhz {

    /* renamed from: a */
    static final long f642a = TimeUnit.SECONDS.toMillis(10);
    private static final Object b = new Object();
    private static boolean c = false;
    private static zzdz d = null;
    private static zzdl e = null;
    private static zzdp f = null;
    private static zzdk g = null;
    private final zza.InterfaceC0027zza h;
    private final AdRequestInfoParcel.zza i;
    private final Object j;
    private final Context k;
    private zzdz.zzd l;

    /* loaded from: classes.dex */
    public static class zza implements zzdz.zzb<zzbb> {
        @Override // com.google.android.gms.internal.zzdz.zzb
        /* renamed from: a */
        public void zzc(zzbb zzbbVar) {
            zzm.b(zzbbVar);
        }
    }

    /* loaded from: classes.dex */
    public static class zzb implements zzdz.zzb<zzbb> {
        @Override // com.google.android.gms.internal.zzdz.zzb
        /* renamed from: a */
        public void zzc(zzbb zzbbVar) {
            zzm.a(zzbbVar);
        }
    }

    /* loaded from: classes.dex */
    public static class zzc implements zzdk {
        @Override // com.google.android.gms.internal.zzdk
        public void zza(zziz zzizVar, Map<String, String> map) {
            String str = map.get("request_id");
            com.google.android.gms.ads.internal.util.client.zzb.e("Invalid request: " + map.get("errors"));
            zzm.f.zzZ(str);
        }
    }

    public zzm(Context context, AdRequestInfoParcel.zza zzaVar, zza.InterfaceC0027zza interfaceC0027zza) {
        super(true);
        this.j = new Object();
        this.h = interfaceC0027zza;
        this.k = context;
        this.i = zzaVar;
        synchronized (b) {
            if (!c) {
                f = new zzdp();
                e = new zzdl(context.getApplicationContext(), zzaVar.j);
                g = new zzc();
                d = new zzdz(this.k.getApplicationContext(), this.i.j, zzby.zzul.get(), new zzb(), new zza());
                c = true;
            }
        }
    }

    private AdResponseParcel a(AdRequestInfoParcel adRequestInfoParcel) {
        String uuid = UUID.randomUUID().toString();
        JSONObject a2 = a(adRequestInfoParcel, uuid);
        if (a2 == null) {
            return new AdResponseParcel(0);
        }
        long elapsedRealtime = zzp.i().elapsedRealtime();
        Future<JSONObject> zzY = f.zzY(uuid);
        com.google.android.gms.ads.internal.util.client.zza.f654a.post(new e(this, a2, uuid));
        try {
            JSONObject jSONObject = zzY.get(f642a - (zzp.i().elapsedRealtime() - elapsedRealtime), TimeUnit.MILLISECONDS);
            if (jSONObject == null) {
                return new AdResponseParcel(-1);
            }
            AdResponseParcel zza2 = zzgu.zza(this.k, adRequestInfoParcel, jSONObject.toString());
            return (zza2.e == -3 || !TextUtils.isEmpty(zza2.c)) ? zza2 : new AdResponseParcel(3);
        } catch (InterruptedException e2) {
            return new AdResponseParcel(-1);
        } catch (CancellationException e3) {
            return new AdResponseParcel(-1);
        } catch (ExecutionException e4) {
            return new AdResponseParcel(0);
        } catch (TimeoutException e5) {
            return new AdResponseParcel(2);
        }
    }

    public static /* synthetic */ zzdp a() {
        return f;
    }

    private JSONObject a(AdRequestInfoParcel adRequestInfoParcel, String str) {
        JSONObject zza2;
        AdvertisingIdClient.Info info;
        Bundle bundle = adRequestInfoParcel.c.c.getBundle("sdk_less_server_data");
        String string = adRequestInfoParcel.c.c.getString("sdk_less_network_id");
        if (bundle == null || (zza2 = zzgu.zza(this.k, adRequestInfoParcel, zzp.k().zzC(this.k), null, null, new zzbr(zzby.zzul.get()), null, null, new ArrayList())) == null) {
            return null;
        }
        try {
            info = AdvertisingIdClient.b(this.k);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e2) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Cannot get advertising id info", e2);
            info = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("request_id", str);
        hashMap.put("network_id", string);
        hashMap.put("request_param", zza2);
        hashMap.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bundle);
        if (info != null) {
            hashMap.put("adid", info.a());
            hashMap.put("lat", Integer.valueOf(info.b() ? 1 : 0));
        }
        try {
            return zzp.e().zzz(hashMap);
        } catch (JSONException e3) {
            return null;
        }
    }

    protected static void a(zzbb zzbbVar) {
        zzbbVar.zza("/loadAd", f);
        zzbbVar.zza("/fetchHttpRequest", e);
        zzbbVar.zza("/invalidRequest", g);
    }

    protected static void b(zzbb zzbbVar) {
        zzbbVar.zzb("/loadAd", f);
        zzbbVar.zzb("/fetchHttpRequest", e);
        zzbbVar.zzb("/invalidRequest", g);
    }

    @Override // com.google.android.gms.internal.zzhz
    public void onStop() {
        synchronized (this.j) {
            com.google.android.gms.ads.internal.util.client.zza.f654a.post(new h(this));
        }
    }

    @Override // com.google.android.gms.internal.zzhz
    public void zzbn() {
        com.google.android.gms.ads.internal.util.client.zzb.a("SdkLessAdLoaderBackgroundTask started.");
        AdRequestInfoParcel adRequestInfoParcel = new AdRequestInfoParcel(this.i, null, -1L);
        AdResponseParcel a2 = a(adRequestInfoParcel);
        com.google.android.gms.ads.internal.util.client.zza.f654a.post(new d(this, new zzhs.zza(adRequestInfoParcel, a2, null, null, a2.e, zzp.i().elapsedRealtime(), a2.n, null)));
    }
}
