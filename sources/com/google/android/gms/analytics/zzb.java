package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzaa;
import com.google.android.gms.internal.gtm.zzab;
import com.google.android.gms.internal.gtm.zzac;
import com.google.android.gms.internal.gtm.zzam;
import com.google.android.gms.internal.gtm.zzao;
import com.google.android.gms.internal.gtm.zzap;
import com.google.android.gms.internal.gtm.zzas;
import com.google.android.gms.internal.gtm.zzcd;
import com.google.android.gms.internal.gtm.zzcz;
import com.google.android.gms.internal.gtm.zzq;
import com.google.android.gms.internal.gtm.zzr;
import com.google.android.gms.internal.gtm.zzs;
import com.google.android.gms.internal.gtm.zzt;
import com.google.android.gms.internal.gtm.zzu;
import com.google.android.gms.internal.gtm.zzv;
import com.google.android.gms.internal.gtm.zzw;
import com.google.android.gms.internal.gtm.zzx;
import com.google.android.gms.internal.gtm.zzy;
import com.google.android.gms.internal.gtm.zzz;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzb extends zzam implements zzo {

    /* renamed from: a, reason: collision with root package name */
    private static DecimalFormat f10357a;

    /* renamed from: b, reason: collision with root package name */
    private final zzap f10358b;

    /* renamed from: c, reason: collision with root package name */
    private final String f10359c;

    /* renamed from: d, reason: collision with root package name */
    private final Uri f10360d;

    public zzb(zzap zzapVar, String str) {
        this(zzapVar, str, true, false);
    }

    @VisibleForTesting
    private static Map<String, String> b(zzg zzgVar) {
        HashMap hashMap = new HashMap();
        zzu zzuVar = (zzu) zzgVar.a(zzu.class);
        if (zzuVar != null) {
            for (Map.Entry<String, Object> entry : zzuVar.zzbm().entrySet()) {
                Object value = entry.getValue();
                String str = null;
                if (value != null) {
                    if (value instanceof String) {
                        String str2 = (String) value;
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                    } else if (value instanceof Double) {
                        Double d2 = (Double) value;
                        if (d2.doubleValue() != 0.0d) {
                            str = a(d2.doubleValue());
                        }
                    } else if (value instanceof Boolean) {
                        if (value != Boolean.FALSE) {
                            str = "1";
                        }
                    } else {
                        str = String.valueOf(value);
                    }
                }
                if (str != null) {
                    hashMap.put(entry.getKey(), str);
                }
            }
        }
        zzz zzzVar = (zzz) zzgVar.a(zzz.class);
        if (zzzVar != null) {
            a(hashMap, com.umeng.commonsdk.proguard.e.ar, zzzVar.zzbs());
            a(hashMap, "cid", zzzVar.zzbt());
            a(hashMap, "uid", zzzVar.zzbu());
            a(hashMap, "sc", zzzVar.zzbx());
            a(hashMap, "sf", zzzVar.zzbz());
            a(hashMap, "ni", zzzVar.zzby());
            a(hashMap, "adid", zzzVar.zzbv());
            a(hashMap, "ate", zzzVar.zzbw());
        }
        zzaa zzaaVar = (zzaa) zzgVar.a(zzaa.class);
        if (zzaaVar != null) {
            a(hashMap, "cd", zzaaVar.zzca());
            a(hashMap, com.umeng.commonsdk.proguard.e.al, zzaaVar.zzcb());
            a(hashMap, "dr", zzaaVar.zzcc());
        }
        zzx zzxVar = (zzx) zzgVar.a(zzx.class);
        if (zzxVar != null) {
            a(hashMap, "ec", zzxVar.zzbr());
            a(hashMap, "ea", zzxVar.getAction());
            a(hashMap, "el", zzxVar.getLabel());
            a(hashMap, "ev", zzxVar.getValue());
        }
        zzr zzrVar = (zzr) zzgVar.a(zzr.class);
        if (zzrVar != null) {
            a(hashMap, "cn", zzrVar.getName());
            a(hashMap, "cs", zzrVar.getSource());
            a(hashMap, "cm", zzrVar.zzbd());
            a(hashMap, "ck", zzrVar.zzbe());
            a(hashMap, "cc", zzrVar.zzbf());
            a(hashMap, "ci", zzrVar.getId());
            a(hashMap, "anid", zzrVar.zzbg());
            a(hashMap, "gclid", zzrVar.zzbh());
            a(hashMap, "dclid", zzrVar.zzbi());
            a(hashMap, "aclid", zzrVar.zzbj());
        }
        zzy zzyVar = (zzy) zzgVar.a(zzy.class);
        if (zzyVar != null) {
            a(hashMap, "exd", zzyVar.zzuq);
            a(hashMap, "exf", zzyVar.zzur);
        }
        zzab zzabVar = (zzab) zzgVar.a(zzab.class);
        if (zzabVar != null) {
            a(hashMap, "sn", zzabVar.zzvh);
            a(hashMap, "sa", zzabVar.zzvi);
            a(hashMap, "st", zzabVar.zzvj);
        }
        zzac zzacVar = (zzac) zzgVar.a(zzac.class);
        if (zzacVar != null) {
            a(hashMap, "utv", zzacVar.zzvk);
            a(hashMap, "utt", zzacVar.zzvl);
            a(hashMap, "utc", zzacVar.mCategory);
            a(hashMap, "utl", zzacVar.zzvm);
        }
        zzs zzsVar = (zzs) zzgVar.a(zzs.class);
        if (zzsVar != null) {
            for (Map.Entry<Integer, String> entry2 : zzsVar.zzbk().entrySet()) {
                String a2 = zzd.a(entry2.getKey().intValue());
                if (!TextUtils.isEmpty(a2)) {
                    hashMap.put(a2, entry2.getValue());
                }
            }
        }
        zzt zztVar = (zzt) zzgVar.a(zzt.class);
        if (zztVar != null) {
            for (Map.Entry<Integer, Double> entry3 : zztVar.zzbl().entrySet()) {
                String b2 = zzd.b(entry3.getKey().intValue());
                if (!TextUtils.isEmpty(b2)) {
                    hashMap.put(b2, a(entry3.getValue().doubleValue()));
                }
            }
        }
        zzw zzwVar = (zzw) zzgVar.a(zzw.class);
        if (zzwVar != null) {
            ProductAction zzbn = zzwVar.zzbn();
            if (zzbn != null) {
                for (Map.Entry<String, String> entry4 : zzbn.a().entrySet()) {
                    if (entry4.getKey().startsWith("&")) {
                        hashMap.put(entry4.getKey().substring(1), entry4.getValue());
                    } else {
                        hashMap.put(entry4.getKey(), entry4.getValue());
                    }
                }
            }
            Iterator<Promotion> it = zzwVar.zzbq().iterator();
            int i = 1;
            while (it.hasNext()) {
                hashMap.putAll(it.next().a(zzd.f(i)));
                i++;
            }
            Iterator<Product> it2 = zzwVar.zzbo().iterator();
            int i2 = 1;
            while (it2.hasNext()) {
                hashMap.putAll(it2.next().a(zzd.d(i2)));
                i2++;
            }
            int i3 = 1;
            for (Map.Entry<String, List<Product>> entry5 : zzwVar.zzbp().entrySet()) {
                List<Product> value2 = entry5.getValue();
                String i4 = zzd.i(i3);
                int i5 = 1;
                for (Product product : value2) {
                    String valueOf = String.valueOf(i4);
                    String valueOf2 = String.valueOf(zzd.g(i5));
                    hashMap.putAll(product.a(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
                    i5++;
                }
                if (!TextUtils.isEmpty(entry5.getKey())) {
                    String valueOf3 = String.valueOf(i4);
                    hashMap.put("nm".length() != 0 ? valueOf3.concat("nm") : new String(valueOf3), entry5.getKey());
                }
                i3++;
            }
        }
        zzv zzvVar = (zzv) zzgVar.a(zzv.class);
        if (zzvVar != null) {
            a(hashMap, "ul", zzvVar.getLanguage());
            a(hashMap, "sd", zzvVar.zzuk);
            a(hashMap, "sr", zzvVar.zzul, zzvVar.zzum);
            a(hashMap, "vp", zzvVar.zzun, zzvVar.zzuo);
        }
        zzq zzqVar = (zzq) zzgVar.a(zzq.class);
        if (zzqVar != null) {
            a(hashMap, "an", zzqVar.zzaz());
            a(hashMap, "aid", zzqVar.zzbb());
            a(hashMap, "aiid", zzqVar.zzbc());
            a(hashMap, "av", zzqVar.zzba());
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Uri e(String str) {
        Preconditions.b(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(ShareConstants.MEDIA_URI);
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    @Override // com.google.android.gms.analytics.zzo
    public final void a(zzg zzgVar) {
        Preconditions.a(zzgVar);
        Preconditions.a(zzgVar.f(), "Can't deliver not submitted measurement");
        Preconditions.c("deliver should be called on worker thread");
        zzg a2 = zzgVar.a();
        zzz zzzVar = (zzz) a2.b(zzz.class);
        if (TextUtils.isEmpty(zzzVar.zzbs())) {
            zzco().zza(b(a2), "Ignoring measurement without type");
            return;
        }
        if (TextUtils.isEmpty(zzzVar.zzbt())) {
            zzco().zza(b(a2), "Ignoring measurement without client id");
            return;
        }
        if (this.f10358b.zzde().e()) {
            return;
        }
        double zzbz = zzzVar.zzbz();
        if (zzcz.zza(zzbz, zzzVar.zzbt())) {
            zzb("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(zzbz));
            return;
        }
        Map<String, String> b2 = b(a2);
        b2.put("v", "1");
        b2.put("_v", zzao.zzwe);
        b2.put("tid", this.f10359c);
        if (this.f10358b.zzde().f()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : b2.entrySet()) {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
            }
            zzc("Dry run is enabled. GoogleAnalytics would have sent", sb.toString());
            return;
        }
        HashMap hashMap = new HashMap();
        zzcz.zzb(hashMap, "uid", zzzVar.zzbu());
        zzq zzqVar = (zzq) zzgVar.a(zzq.class);
        if (zzqVar != null) {
            zzcz.zzb(hashMap, "an", zzqVar.zzaz());
            zzcz.zzb(hashMap, "aid", zzqVar.zzbb());
            zzcz.zzb(hashMap, "av", zzqVar.zzba());
            zzcz.zzb(hashMap, "aiid", zzqVar.zzbc());
        }
        b2.put("_s", String.valueOf(zzcs().zza(new zzas(0L, zzzVar.zzbt(), this.f10359c, !TextUtils.isEmpty(zzzVar.zzbv()), 0L, hashMap))));
        zzcs().zza(new zzcd(zzco(), b2, zzgVar.d(), true));
    }

    @Override // com.google.android.gms.analytics.zzo
    public final Uri c() {
        return this.f10360d;
    }

    private zzb(zzap zzapVar, String str, boolean z, boolean z2) {
        super(zzapVar);
        Preconditions.b(str);
        this.f10358b = zzapVar;
        this.f10359c = str;
        this.f10360d = e(this.f10359c);
    }

    private static void a(Map<String, String> map, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }

    private static String a(double d2) {
        if (f10357a == null) {
            f10357a = new DecimalFormat("0.######");
        }
        return f10357a.format(d2);
    }

    private static void a(Map<String, String> map, String str, double d2) {
        if (d2 != 0.0d) {
            map.put(str, a(d2));
        }
    }

    private static void a(Map<String, String> map, String str, boolean z) {
        if (z) {
            map.put(str, "1");
        }
    }

    private static void a(Map<String, String> map, String str, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(23);
        sb.append(i);
        sb.append(FragmentC2201x.f23219a);
        sb.append(i2);
        map.put(str, sb.toString());
    }
}
