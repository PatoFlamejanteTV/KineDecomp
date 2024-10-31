package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.internal.zzab;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zze;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzh;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzjl;
import com.google.android.gms.internal.zzjm;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpc;
import com.google.android.gms.internal.zzpd;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpf;
import com.google.android.gms.internal.zzpg;
import com.google.android.gms.internal.zzph;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzpj;
import com.google.android.gms.measurement.zzi;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class zzb extends com.google.android.gms.analytics.internal.zzc implements zzi {

    /* renamed from: a, reason: collision with root package name */
    private static DecimalFormat f754a;
    private final zzf b;
    private final String c;
    private final Uri d;
    private final boolean e;
    private final boolean f;

    public zzb(zzf zzfVar, String str) {
        this(zzfVar, str, true, false);
    }

    public zzb(zzf zzfVar, String str, boolean z, boolean z2) {
        super(zzfVar);
        zzx.a(str);
        this.b = zzfVar;
        this.c = str;
        this.e = z;
        this.f = z2;
        this.d = a(this.c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Uri a(String str) {
        zzx.a(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    static String a(double d) {
        if (f754a == null) {
            f754a = new DecimalFormat("0.######");
        }
        return f754a.format(d);
    }

    private static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str;
        }
        if (obj instanceof Double) {
            Double d = (Double) obj;
            if (d.doubleValue() != 0.0d) {
                return a(d.doubleValue());
            }
            return null;
        }
        if (!(obj instanceof Boolean)) {
            return String.valueOf(obj);
        }
        if (obj != Boolean.FALSE) {
            return AppEventsConstants.EVENT_PARAM_VALUE_YES;
        }
        return null;
    }

    private static String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    private static void a(Map<String, String> map, String str, double d) {
        if (d != 0.0d) {
            map.put(str, a(d));
        }
    }

    private static void a(Map<String, String> map, String str, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        map.put(str, i + "x" + i2);
    }

    private static void a(Map<String, String> map, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }

    private static void a(Map<String, String> map, String str, boolean z) {
        if (z) {
            map.put(str, AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
    }

    public static Map<String, String> b(com.google.android.gms.measurement.zzc zzcVar) {
        HashMap hashMap = new HashMap();
        zzjn zzjnVar = (zzjn) zzcVar.a(zzjn.class);
        if (zzjnVar != null) {
            for (Map.Entry<String, Object> entry : zzjnVar.zzhZ().entrySet()) {
                String a2 = a(entry.getValue());
                if (a2 != null) {
                    hashMap.put(entry.getKey(), a2);
                }
            }
        }
        zzjo zzjoVar = (zzjo) zzcVar.a(zzjo.class);
        if (zzjoVar != null) {
            a(hashMap, "t", zzjoVar.zzia());
            a(hashMap, "cid", zzjoVar.getClientId());
            a(hashMap, "uid", zzjoVar.getUserId());
            a(hashMap, "sc", zzjoVar.zzid());
            a(hashMap, "sf", zzjoVar.zzif());
            a(hashMap, "ni", zzjoVar.zzie());
            a(hashMap, "adid", zzjoVar.zzib());
            a(hashMap, "ate", zzjoVar.zzic());
        }
        zzph zzphVar = (zzph) zzcVar.a(zzph.class);
        if (zzphVar != null) {
            a(hashMap, "cd", zzphVar.zzyM());
            a(hashMap, "a", zzphVar.zzyN());
            a(hashMap, "dr", zzphVar.zzyO());
        }
        zzpf zzpfVar = (zzpf) zzcVar.a(zzpf.class);
        if (zzpfVar != null) {
            a(hashMap, "ec", zzpfVar.zzyJ());
            a(hashMap, "ea", zzpfVar.getAction());
            a(hashMap, "el", zzpfVar.getLabel());
            a(hashMap, "ev", zzpfVar.getValue());
        }
        zzpc zzpcVar = (zzpc) zzcVar.a(zzpc.class);
        if (zzpcVar != null) {
            a(hashMap, "cn", zzpcVar.getName());
            a(hashMap, "cs", zzpcVar.getSource());
            a(hashMap, "cm", zzpcVar.zzyu());
            a(hashMap, "ck", zzpcVar.zzyv());
            a(hashMap, "cc", zzpcVar.getContent());
            a(hashMap, "ci", zzpcVar.getId());
            a(hashMap, "anid", zzpcVar.zzyw());
            a(hashMap, "gclid", zzpcVar.zzyx());
            a(hashMap, "dclid", zzpcVar.zzyy());
            a(hashMap, "aclid", zzpcVar.zzyz());
        }
        zzpg zzpgVar = (zzpg) zzcVar.a(zzpg.class);
        if (zzpgVar != null) {
            a(hashMap, "exd", zzpgVar.getDescription());
            a(hashMap, "exf", zzpgVar.zzyK());
        }
        zzpi zzpiVar = (zzpi) zzcVar.a(zzpi.class);
        if (zzpiVar != null) {
            a(hashMap, "sn", zzpiVar.zzyQ());
            a(hashMap, "sa", zzpiVar.getAction());
            a(hashMap, "st", zzpiVar.getTarget());
        }
        zzpj zzpjVar = (zzpj) zzcVar.a(zzpj.class);
        if (zzpjVar != null) {
            a(hashMap, "utv", zzpjVar.zzyR());
            a(hashMap, "utt", zzpjVar.getTimeInMillis());
            a(hashMap, "utc", zzpjVar.zzyJ());
            a(hashMap, "utl", zzpjVar.getLabel());
        }
        zzjl zzjlVar = (zzjl) zzcVar.a(zzjl.class);
        if (zzjlVar != null) {
            for (Map.Entry<Integer, String> entry2 : zzjlVar.zzhX().entrySet()) {
                String a3 = zzc.a(entry2.getKey().intValue());
                if (!TextUtils.isEmpty(a3)) {
                    hashMap.put(a3, entry2.getValue());
                }
            }
        }
        zzjm zzjmVar = (zzjm) zzcVar.a(zzjm.class);
        if (zzjmVar != null) {
            for (Map.Entry<Integer, Double> entry3 : zzjmVar.zzhY().entrySet()) {
                String b = zzc.b(entry3.getKey().intValue());
                if (!TextUtils.isEmpty(b)) {
                    hashMap.put(b, a(entry3.getValue().doubleValue()));
                }
            }
        }
        zzpe zzpeVar = (zzpe) zzcVar.a(zzpe.class);
        if (zzpeVar != null) {
            ProductAction zzyF = zzpeVar.zzyF();
            if (zzyF != null) {
                for (Map.Entry<String, String> entry4 : zzyF.a().entrySet()) {
                    if (entry4.getKey().startsWith("&")) {
                        hashMap.put(entry4.getKey().substring(1), entry4.getValue());
                    } else {
                        hashMap.put(entry4.getKey(), entry4.getValue());
                    }
                }
            }
            Iterator<Promotion> it = zzpeVar.zzyI().iterator();
            int i = 1;
            while (it.hasNext()) {
                hashMap.putAll(it.next().e(zzc.f(i)));
                i++;
            }
            Iterator<Product> it2 = zzpeVar.zzyG().iterator();
            int i2 = 1;
            while (it2.hasNext()) {
                hashMap.putAll(it2.next().g(zzc.d(i2)));
                i2++;
            }
            int i3 = 1;
            for (Map.Entry<String, List<Product>> entry5 : zzpeVar.zzyH().entrySet()) {
                List<Product> value = entry5.getValue();
                String i4 = zzc.i(i3);
                Iterator<Product> it3 = value.iterator();
                int i5 = 1;
                while (it3.hasNext()) {
                    hashMap.putAll(it3.next().g(i4 + zzc.g(i5)));
                    i5++;
                }
                if (!TextUtils.isEmpty(entry5.getKey())) {
                    hashMap.put(i4 + "nm", entry5.getKey());
                }
                i3++;
            }
        }
        zzpd zzpdVar = (zzpd) zzcVar.a(zzpd.class);
        if (zzpdVar != null) {
            a(hashMap, "ul", zzpdVar.getLanguage());
            a(hashMap, "sd", zzpdVar.zzyA());
            a(hashMap, "sr", zzpdVar.zzyB(), zzpdVar.zzyC());
            a(hashMap, "vp", zzpdVar.zzyD(), zzpdVar.zzyE());
        }
        zzpb zzpbVar = (zzpb) zzcVar.a(zzpb.class);
        if (zzpbVar != null) {
            a(hashMap, "an", zzpbVar.zzkp());
            a(hashMap, "aid", zzpbVar.zzuM());
            a(hashMap, "aiid", zzpbVar.zzyt());
            a(hashMap, "av", zzpbVar.zzkr());
        }
        return hashMap;
    }

    @Override // com.google.android.gms.measurement.zzi
    public Uri a() {
        return this.d;
    }

    @Override // com.google.android.gms.measurement.zzi
    public void a(com.google.android.gms.measurement.zzc zzcVar) {
        zzx.a(zzcVar);
        zzx.b(zzcVar.f(), "Can't deliver not submitted measurement");
        zzx.c("deliver should be called on worker thread");
        com.google.android.gms.measurement.zzc a2 = zzcVar.a();
        zzjo zzjoVar = (zzjo) a2.b(zzjo.class);
        if (TextUtils.isEmpty(zzjoVar.zzia())) {
            p().a(b(a2), "Ignoring measurement without type");
            return;
        }
        if (TextUtils.isEmpty(zzjoVar.getClientId())) {
            p().a(b(a2), "Ignoring measurement without client id");
            return;
        }
        if (this.b.k().f()) {
            return;
        }
        double zzif = zzjoVar.zzif();
        if (zzam.a(zzif, zzjoVar.getClientId())) {
            b("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(zzif));
            return;
        }
        Map<String, String> b = b(a2);
        b.put("v", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        b.put("_v", zze.b);
        b.put("tid", this.c);
        if (this.b.k().e()) {
            c("Dry run is enabled. GoogleAnalytics would have sent", a(b));
            return;
        }
        HashMap hashMap = new HashMap();
        zzam.a(hashMap, "uid", zzjoVar.getUserId());
        zzpb zzpbVar = (zzpb) zzcVar.a(zzpb.class);
        if (zzpbVar != null) {
            zzam.a(hashMap, "an", zzpbVar.zzkp());
            zzam.a(hashMap, "aid", zzpbVar.zzuM());
            zzam.a(hashMap, "av", zzpbVar.zzkr());
            zzam.a(hashMap, "aiid", zzpbVar.zzyt());
        }
        b.put("_s", String.valueOf(t().a(new zzh(0L, zzjoVar.getClientId(), this.c, !TextUtils.isEmpty(zzjoVar.zzib()), 0L, hashMap))));
        t().a(new zzab(p(), b, zzcVar.d(), true));
    }
}
