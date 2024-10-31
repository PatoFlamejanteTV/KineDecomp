package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzawg implements zzawr {
    private static List<Future<Void>> zzefp = Collections.synchronizedList(new ArrayList());
    private static ScheduledExecutorService zzefq = Executors.newSingleThreadScheduledExecutor();
    private final Context mContext;
    private final zzawo zzecd;
    private final zzbvn zzefr;
    private final LinkedHashMap<String, zzbvt> zzefs;
    private final zzawt zzefv;
    private boolean zzefw;
    private final C0954jd zzefx;
    private final List<String> zzeft = new ArrayList();
    private final List<String> zzefu = new ArrayList();
    private final Object mLock = new Object();
    private HashSet<String> zzefy = new HashSet<>();
    private boolean zzefz = false;
    private boolean zzega = false;
    private boolean zzegb = false;

    public zzawg(Context context, zzbbi zzbbiVar, zzawo zzawoVar, String str, zzawt zzawtVar) {
        Preconditions.a(zzawoVar, "SafeBrowsing config is not present.");
        this.mContext = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzefs = new LinkedHashMap<>();
        this.zzefv = zzawtVar;
        this.zzecd = zzawoVar;
        Iterator<String> it = this.zzecd.zzegl.iterator();
        while (it.hasNext()) {
            this.zzefy.add(it.next().toLowerCase(Locale.ENGLISH));
        }
        this.zzefy.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzbvn zzbvnVar = new zzbvn();
        zzbvnVar.zzgar = 8;
        zzbvnVar.url = str;
        zzbvnVar.zzgat = str;
        zzbvnVar.zzgav = new zzbvo();
        zzbvnVar.zzgav.zzegh = this.zzecd.zzegh;
        zzbvu zzbvuVar = new zzbvu();
        zzbvuVar.zzgcc = zzbbiVar.zzdp;
        zzbvuVar.zzgce = Boolean.valueOf(Wrappers.a(this.mContext).a());
        long b2 = GoogleApiAvailabilityLight.a().b(this.mContext);
        if (b2 > 0) {
            zzbvuVar.zzgcd = Long.valueOf(b2);
        }
        zzbvnVar.zzgbf = zzbvuVar;
        this.zzefr = zzbvnVar;
        this.zzefx = new C0954jd(this.mContext, this.zzecd.zzego, this);
    }

    private final zzbvt zzdl(String str) {
        zzbvt zzbvtVar;
        synchronized (this.mLock) {
            zzbvtVar = this.zzefs.get(str);
        }
        return zzbvtVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ Void zzdm(String str) {
        return null;
    }

    private final zzbcb<Void> zzxt() {
        zzbcb<Void> zza;
        if (!((this.zzefw && this.zzecd.zzegn) || (this.zzegb && this.zzecd.zzegm) || (!this.zzefw && this.zzecd.zzegk))) {
            return zzbbq.zzm(null);
        }
        synchronized (this.mLock) {
            this.zzefr.zzgaw = new zzbvt[this.zzefs.size()];
            this.zzefs.values().toArray(this.zzefr.zzgaw);
            this.zzefr.zzgbg = (String[]) this.zzeft.toArray(new String[0]);
            this.zzefr.zzgbh = (String[]) this.zzefu.toArray(new String[0]);
            if (zzawq.isEnabled()) {
                String str = this.zzefr.url;
                String str2 = this.zzefr.zzgax;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 53 + String.valueOf(str2).length());
                sb.append("Sending SB report\n  url: ");
                sb.append(str);
                sb.append("\n  clickUrl: ");
                sb.append(str2);
                sb.append("\n  resources: \n");
                StringBuilder sb2 = new StringBuilder(sb.toString());
                for (zzbvt zzbvtVar : this.zzefr.zzgaw) {
                    sb2.append("    [");
                    sb2.append(zzbvtVar.zzgcb.length);
                    sb2.append("] ");
                    sb2.append(zzbvtVar.url);
                }
                zzawq.zzdn(sb2.toString());
            }
            zzbcb<String> zza2 = new zzazs(this.mContext).zza(1, this.zzecd.zzegi, null, zzbuz.zzb(this.zzefr));
            if (zzawq.isEnabled()) {
                zza2.zza(new RunnableC0941id(this), zzayf.zzeky);
            }
            zza = zzbbq.zza(zza2, C0899fd.f12159a, zzbcg.zzepp);
        }
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzawr
    public final void zza(String str, Map<String, String> map, int i) {
        synchronized (this.mLock) {
            if (i == 3) {
                this.zzegb = true;
            }
            if (this.zzefs.containsKey(str)) {
                if (i == 3) {
                    this.zzefs.get(str).zzgca = Integer.valueOf(i);
                }
                return;
            }
            zzbvt zzbvtVar = new zzbvt();
            zzbvtVar.zzgca = Integer.valueOf(i);
            zzbvtVar.zzgbu = Integer.valueOf(this.zzefs.size());
            zzbvtVar.url = str;
            zzbvtVar.zzgbv = new zzbvq();
            if (this.zzefy.size() > 0 && map != null) {
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    try {
                        String key = entry.getKey() != null ? entry.getKey() : "";
                        String value = entry.getValue() != null ? entry.getValue() : "";
                        if (this.zzefy.contains(key.toLowerCase(Locale.ENGLISH))) {
                            zzbvp zzbvpVar = new zzbvp();
                            zzbvpVar.zzgbj = key.getBytes("UTF-8");
                            zzbvpVar.zzgbk = value.getBytes("UTF-8");
                            arrayList.add(zzbvpVar);
                        }
                    } catch (UnsupportedEncodingException unused) {
                        zzawq.zzdn("Cannot convert string to bytes, skip header.");
                    }
                }
                zzbvp[] zzbvpVarArr = new zzbvp[arrayList.size()];
                arrayList.toArray(zzbvpVarArr);
                zzbvtVar.zzgbv.zzgbm = zzbvpVarArr;
            }
            this.zzefs.put(str, zzbvtVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawr
    public final String[] zzb(String[] strArr) {
        return (String[]) this.zzefx.a(strArr).toArray(new String[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzawr
    public final void zzdi(String str) {
        synchronized (this.mLock) {
            this.zzefr.zzgax = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzdj(String str) {
        synchronized (this.mLock) {
            this.zzeft.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzdk(String str) {
        synchronized (this.mLock) {
            this.zzefu.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbcb zzm(Map map) throws Exception {
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray optJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (optJSONArray != null) {
                        synchronized (this.mLock) {
                            int length = optJSONArray.length();
                            zzbvt zzdl = zzdl(str);
                            if (zzdl == null) {
                                String valueOf = String.valueOf(str);
                                zzawq.zzdn(valueOf.length() != 0 ? "Cannot find the corresponding resource object for ".concat(valueOf) : new String("Cannot find the corresponding resource object for "));
                            } else {
                                zzdl.zzgcb = new String[length];
                                for (int i = 0; i < length; i++) {
                                    zzdl.zzgcb[i] = optJSONArray.getJSONObject(i).getString("threat_type");
                                }
                                this.zzefw = (length > 0) | this.zzefw;
                            }
                        }
                    }
                }
            } catch (JSONException e2) {
                if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcvm)).booleanValue()) {
                    zzbbd.zza("Failed to get SafeBrowsing metadata", e2);
                }
                return zzbbq.zzd(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.zzefw) {
            synchronized (this.mLock) {
                this.zzefr.zzgar = 9;
            }
        }
        return zzxt();
    }

    @Override // com.google.android.gms.internal.ads.zzawr
    public final void zzs(View view) {
        if (this.zzecd.zzegj && !this.zzega) {
            com.google.android.gms.ads.internal.zzbv.e();
            Bitmap zzu = zzayh.zzu(view);
            if (zzu == null) {
                zzawq.zzdn("Failed to capture the webview bitmap.");
            } else {
                this.zzega = true;
                zzayh.zzd(new RunnableC0913gd(this, zzu));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawr
    public final zzawo zzxp() {
        return this.zzecd;
    }

    @Override // com.google.android.gms.internal.ads.zzawr
    public final boolean zzxq() {
        return PlatformVersion.f() && this.zzecd.zzegj && !this.zzega;
    }

    @Override // com.google.android.gms.internal.ads.zzawr
    public final void zzxr() {
        this.zzefz = true;
    }

    @Override // com.google.android.gms.internal.ads.zzawr
    public final void zzxs() {
        synchronized (this.mLock) {
            zzbcb zza = zzbbq.zza(this.zzefv.zza(this.mContext, this.zzefs.keySet()), new zzbbl(this) { // from class: com.google.android.gms.internal.ads.ed

                /* renamed from: a, reason: collision with root package name */
                private final zzawg f12140a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f12140a = this;
                }

                @Override // com.google.android.gms.internal.ads.zzbbl
                public final zzbcb zzf(Object obj) {
                    return this.f12140a.zzm((Map) obj);
                }
            }, zzbcg.zzepp);
            zzbcb zza2 = zzbbq.zza(zza, 10L, TimeUnit.SECONDS, zzefq);
            zzbbq.zza(zza, new C0927hd(this, zza2), zzbcg.zzepp);
            zzefp.add(zza2);
        }
    }
}
