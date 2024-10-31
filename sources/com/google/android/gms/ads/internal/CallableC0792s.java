package com.google.android.gms.ads.internal;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzaba;
import com.google.android.gms.internal.ads.zzacf;
import com.google.android.gms.internal.ads.zzasi;
import com.google.android.gms.internal.ads.zzasj;
import com.google.android.gms.internal.ads.zzaxg;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzwb;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.ads.internal.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class CallableC0792s implements Callable<zzacf> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f10150a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ JSONArray f10151b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ int f10152c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzaxg f10153d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzbb f10154e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallableC0792s(zzbb zzbbVar, int i, JSONArray jSONArray, int i2, zzaxg zzaxgVar) {
        this.f10154e = zzbbVar;
        this.f10150a = i;
        this.f10151b = jSONArray;
        this.f10152c = i2;
        this.f10153d = zzaxgVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzacf call() throws Exception {
        Bundle bundle;
        if (this.f10150a >= this.f10151b.length()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(this.f10151b.get(this.f10150a));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ads", jSONArray);
        zzbb zzbbVar = this.f10154e;
        zzbw zzbwVar = zzbbVar.zzbls;
        zzbb zzbbVar2 = new zzbb(zzbwVar.f10251c, zzbbVar.zzbly, zzbwVar.i, zzbwVar.f10250b, zzbbVar.zzbma, zzbwVar.f10253e, true);
        zzbb.a(this.f10154e.zzbls, zzbbVar2.zzbls);
        zzbbVar2.B();
        zzbbVar2.zza(this.f10154e.zzblo);
        zzaba zzabaVar = zzbbVar2.zzbln;
        int i = this.f10150a;
        zzabaVar.zzg("num_ads_requested", String.valueOf(this.f10152c));
        zzabaVar.zzg("ad_index", String.valueOf(i));
        zzasi zzasiVar = this.f10153d.zzeag;
        String jSONObject2 = jSONObject.toString();
        Bundle bundle2 = zzasiVar.zzdwg.extras;
        if (bundle2 != null) {
            bundle = new Bundle(bundle2);
        } else {
            bundle = new Bundle();
        }
        Bundle bundle3 = bundle;
        bundle3.putString("_ad", jSONObject2);
        zzwb zzwbVar = zzasiVar.zzdwg;
        zzbbVar2.zza(new zzasj(zzasiVar.zzdwf, new zzwb(zzwbVar.versionCode, zzwbVar.zzcjb, bundle3, zzwbVar.zzcjc, zzwbVar.zzcjd, zzwbVar.zzcje, zzwbVar.zzcjf, zzwbVar.zzcjg, zzwbVar.zzcjh, zzwbVar.zzcji, zzwbVar.zzcjj, zzwbVar.zzcjk, zzwbVar.zzcjl, zzwbVar.zzcjm, zzwbVar.zzcjn, zzwbVar.zzcjo, zzwbVar.zzcjp, zzwbVar.zzcjq, null, zzwbVar.zzcjs, zzwbVar.zzcjt), zzasiVar.zzbst, zzasiVar.zzbsn, zzasiVar.applicationInfo, zzasiVar.zzdwh, zzasiVar.zzdwj, zzasiVar.zzclm, zzasiVar.zzbsp, zzasiVar.zzdwk, zzasiVar.zzbtt, zzasiVar.zzdwu, zzasiVar.zzdwm, zzasiVar.zzdwn, zzasiVar.zzdwo, zzasiVar.zzdwp, zzasiVar.zzbwv, zzasiVar.zzdwq, zzasiVar.zzdwr, zzasiVar.zzdws, zzasiVar.zzdwt, zzasiVar.zzbsm, zzasiVar.zzbti, zzasiVar.zzdww, zzasiVar.zzdwx, zzasiVar.zzdxd, zzasiVar.zzdwy, zzasiVar.zzdwz, zzasiVar.zzdxa, zzasiVar.zzdxb, zzbbq.zzm(zzasiVar.zzdxc), zzasiVar.zzdxe, zzasiVar.zzdlv, zzasiVar.zzdxf, zzasiVar.zzdxg, zzasiVar.zzdxh, zzasiVar.zzbtl, zzasiVar.zzdxi, zzasiVar.zzdxj, zzasiVar.zzdxn, zzbbq.zzm(zzasiVar.zzdwi), zzasiVar.zzbtn, zzasiVar.zzdxo, zzasiVar.zzdxp, 1, zzasiVar.zzdxr, zzasiVar.zzdxs, zzasiVar.zzdxt, zzasiVar.zzdxu, zzasiVar.zzdxv, zzasiVar.zzbtk, zzasiVar.zzdxx), zzbbVar2.zzbln);
        return zzbbVar2.D().get();
    }
}
