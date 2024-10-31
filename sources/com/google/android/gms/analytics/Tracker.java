package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzan;
import com.google.android.gms.internal.gtm.zzcz;
import java.util.HashMap;
import java.util.Map;

@VisibleForTesting
/* loaded from: classes.dex */
public class Tracker extends zzan {

    /* renamed from: a */
    private boolean f10336a;

    /* renamed from: b */
    private final Map<String, String> f10337b;

    /* renamed from: c */
    private final Map<String, String> f10338c;

    /* renamed from: d */
    private final a f10339d;

    /* loaded from: classes.dex */
    public class a extends zzan implements GoogleAnalytics.a {
        public final synchronized boolean a() {
            throw null;
        }
    }

    private static String a(Map.Entry<String, String> entry) {
        String key = entry.getKey();
        if (key.startsWith("&") && key.length() >= 2) {
            return entry.getKey().substring(1);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void zzaw() {
        this.f10339d.zzag();
        String zzaz = zzcu().zzaz();
        if (zzaz != null) {
            a("&an", zzaz);
        }
        String zzba = zzcu().zzba();
        if (zzba != null) {
            a("&av", zzba);
        }
    }

    private static void a(Map<String, String> map, Map<String, String> map2) {
        Preconditions.a(map2);
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String a2 = a(entry);
            if (a2 != null) {
                map2.put(a2, entry.getValue());
            }
        }
    }

    public void a(Map<String, String> map) {
        long a2 = zzcn().a();
        if (zzcr().e()) {
            zzr("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        boolean f2 = zzcr().f();
        HashMap hashMap = new HashMap();
        a(this.f10337b, hashMap);
        a(map, hashMap);
        boolean zzb = zzcz.zzb(this.f10337b.get("useSecure"), true);
        Map<String, String> map2 = this.f10338c;
        Preconditions.a(hashMap);
        if (map2 != null) {
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                String a3 = a(entry);
                if (a3 != null && !hashMap.containsKey(a3)) {
                    hashMap.put(a3, entry.getValue());
                }
            }
        }
        this.f10338c.clear();
        String str = hashMap.get(com.umeng.commonsdk.proguard.e.ar);
        if (TextUtils.isEmpty(str)) {
            zzco().zza(hashMap, "Missing hit type parameter");
            return;
        }
        String str2 = hashMap.get("tid");
        if (TextUtils.isEmpty(str2)) {
            zzco().zza(hashMap, "Missing tracking id parameter");
            return;
        }
        boolean z = this.f10336a;
        synchronized (this) {
            if ("screenview".equalsIgnoreCase(str) || com.umeng.analytics.pro.b.au.equalsIgnoreCase(str) || "appview".equalsIgnoreCase(str) || TextUtils.isEmpty(str)) {
                int parseInt = Integer.parseInt(this.f10337b.get("&a")) + 1;
                if (parseInt >= Integer.MAX_VALUE) {
                    parseInt = 1;
                }
                this.f10337b.put("&a", Integer.toString(parseInt));
            }
        }
        zzcq().a(new e(this, hashMap, z, str, a2, f2, zzb, str2));
    }

    public void a(String str, String str2) {
        Preconditions.a(str, (Object) "Key should be non-null");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f10337b.put(str, str2);
    }
}
