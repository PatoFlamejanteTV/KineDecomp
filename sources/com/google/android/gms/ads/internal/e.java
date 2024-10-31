package com.google.android.gms.ads.internal;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.zzaan;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzwb;
import com.google.android.gms.internal.ads.zzwu;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
final class E {

    /* renamed from: a, reason: collision with root package name */
    private final String f9989a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, String> f9990b = new TreeMap();

    /* renamed from: c, reason: collision with root package name */
    private String f9991c;

    /* renamed from: d, reason: collision with root package name */
    private String f9992d;

    public E(String str) {
        this.f9989a = str;
    }

    public final String a() {
        return this.f9991c;
    }

    public final String b() {
        return this.f9992d;
    }

    public final String c() {
        return this.f9989a;
    }

    public final Map<String, String> d() {
        return this.f9990b;
    }

    public final void a(zzwb zzwbVar, zzbbi zzbbiVar) {
        this.f9991c = zzwbVar.zzcji.zzcne;
        Bundle bundle = zzwbVar.zzcjl;
        Bundle bundle2 = bundle != null ? bundle.getBundle(AdMobAdapter.class.getName()) : null;
        if (bundle2 == null) {
            return;
        }
        String str = (String) zzwu.zzpz().zzd(zzaan.zzcvh);
        for (String str2 : bundle2.keySet()) {
            if (str.equals(str2)) {
                this.f9992d = bundle2.getString(str2);
            } else if (str2.startsWith("csa_")) {
                this.f9990b.put(str2.substring(4), bundle2.getString(str2));
            }
        }
        this.f9990b.put("SDKVersion", zzbbiVar.zzdp);
    }
}
