package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzaqt implements zzaqp<zzbgg> {
    private final Context mContext;
    private final zzbbi zzbpt;
    private String zzbqb;
    private final zzcu zzdcf;
    private final com.google.android.gms.ads.internal.zzbb zzdug;
    private zzbcb<zzbgg> zzduv;
    private final com.google.android.gms.ads.internal.gmsg.zzaa zzduw;
    private final zzaci zzdux;

    public zzaqt(Context context, com.google.android.gms.ads.internal.zzbb zzbbVar, String str, zzcu zzcuVar, zzbbi zzbbiVar) {
        zzbbd.zzen("Webview loading for native ads.");
        this.mContext = context;
        this.zzdug = zzbbVar;
        this.zzdcf = zzcuVar;
        this.zzbpt = zzbbiVar;
        this.zzbqb = str;
        com.google.android.gms.ads.internal.zzbv.f();
        zzbcb<zzbgg> zza = zzbgm.zza(this.mContext, this.zzbpt, (String) zzwu.zzpz().zzd(zzaan.zzcud), this.zzdcf, this.zzdug.zzid());
        this.zzduw = new com.google.android.gms.ads.internal.gmsg.zzaa(this.mContext);
        this.zzdux = new zzaci(zzbbVar, str);
        this.zzduv = zzbbq.zza(zza, new zzbbl(this) { // from class: com.google.android.gms.internal.ads.lc

            /* renamed from: a, reason: collision with root package name */
            private final zzaqt f12292a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12292a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbbl
            public final zzbcb zzf(Object obj) {
                return this.f12292a.zzh((zzbgg) obj);
            }
        }, zzbcg.zzepp);
        zzbbo.zza(this.zzduv, "WebViewNativeAdsUtil.constructor");
    }

    @Override // com.google.android.gms.internal.ads.zzaqp
    public final void zza(String str, com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg> zzuVar) {
        zzbbq.zza(this.zzduv, new C1064rc(this, str, zzuVar), zzbcg.zzepo);
    }

    @Override // com.google.android.gms.internal.ads.zzaqp
    public final void zzb(String str, com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg> zzuVar) {
        zzbbq.zza(this.zzduv, new C1078sc(this, str, zzuVar), zzbcg.zzepo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbcb zzc(JSONObject jSONObject, zzbgg zzbggVar) throws Exception {
        jSONObject.put("ads_id", this.zzbqb);
        zzbggVar.zzb("google.afma.nativeAds.handleClickGmsg", jSONObject);
        return zzbbq.zzm(new JSONObject());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbcb zzd(JSONObject jSONObject, zzbgg zzbggVar) throws Exception {
        jSONObject.put("ads_id", this.zzbqb);
        zzbcl zzbclVar = new zzbcl();
        zzbggVar.zza("/nativeAdPreProcess", new C1051qc(this, zzbggVar, zzbclVar));
        zzbggVar.zzb("google.afma.nativeAds.preProcessJsonGmsg", jSONObject);
        return zzbclVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaqp
    public final zzbcb<JSONObject> zzh(final JSONObject jSONObject) {
        return zzbbq.zza(this.zzduv, new zzbbl(this, jSONObject) { // from class: com.google.android.gms.internal.ads.mc

            /* renamed from: a, reason: collision with root package name */
            private final zzaqt f12322a;

            /* renamed from: b, reason: collision with root package name */
            private final JSONObject f12323b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12322a = this;
                this.f12323b = jSONObject;
            }

            @Override // com.google.android.gms.internal.ads.zzbbl
            public final zzbcb zzf(Object obj) {
                return this.f12322a.zzd(this.f12323b, (zzbgg) obj);
            }
        }, zzbcg.zzepo);
    }

    @Override // com.google.android.gms.internal.ads.zzaqp
    public final zzbcb<JSONObject> zzi(final JSONObject jSONObject) {
        return zzbbq.zza(this.zzduv, new zzbbl(this, jSONObject) { // from class: com.google.android.gms.internal.ads.nc

            /* renamed from: a, reason: collision with root package name */
            private final zzaqt f12344a;

            /* renamed from: b, reason: collision with root package name */
            private final JSONObject f12345b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12344a = this;
                this.f12345b = jSONObject;
            }

            @Override // com.google.android.gms.internal.ads.zzbbl
            public final zzbcb zzf(Object obj) {
                return this.f12344a.zzc(this.f12345b, (zzbgg) obj);
            }
        }, zzbcg.zzepo);
    }

    @Override // com.google.android.gms.internal.ads.zzaqp
    public final zzbcb<JSONObject> zzj(final JSONObject jSONObject) {
        return zzbbq.zza(this.zzduv, new zzbbl(this, jSONObject) { // from class: com.google.android.gms.internal.ads.oc

            /* renamed from: a, reason: collision with root package name */
            private final zzaqt f12381a;

            /* renamed from: b, reason: collision with root package name */
            private final JSONObject f12382b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12381a = this;
                this.f12382b = jSONObject;
            }

            @Override // com.google.android.gms.internal.ads.zzbbl
            public final zzbcb zzf(Object obj) {
                return this.f12381a.zzb(this.f12382b, (zzbgg) obj);
            }
        }, zzbcg.zzepo);
    }

    @Override // com.google.android.gms.internal.ads.zzaqp
    public final zzbcb<JSONObject> zzk(final JSONObject jSONObject) {
        return zzbbq.zza(this.zzduv, new zzbbl(this, jSONObject) { // from class: com.google.android.gms.internal.ads.pc

            /* renamed from: a, reason: collision with root package name */
            private final zzaqt f12421a;

            /* renamed from: b, reason: collision with root package name */
            private final JSONObject f12422b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12421a = this;
                this.f12422b = jSONObject;
            }

            @Override // com.google.android.gms.internal.ads.zzbbl
            public final zzbcb zzf(Object obj) {
                return this.f12421a.zza(this.f12422b, (zzbgg) obj);
            }
        }, zzbcg.zzepo);
    }

    @Override // com.google.android.gms.internal.ads.zzaqp
    public final void zzug() {
        zzbbq.zza(this.zzduv, new C1106uc(this), zzbcg.zzepo);
    }

    @Override // com.google.android.gms.internal.ads.zzaqp
    public final void zza(String str, JSONObject jSONObject) {
        zzbbq.zza(this.zzduv, new C1092tc(this, str, jSONObject), zzbcg.zzepo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbcb zzb(JSONObject jSONObject, zzbgg zzbggVar) throws Exception {
        jSONObject.put("ads_id", this.zzbqb);
        zzbggVar.zzb("google.afma.nativeAds.handleImpressionPing", jSONObject);
        return zzbbq.zzm(new JSONObject());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbcb zzh(zzbgg zzbggVar) throws Exception {
        zzbbd.zzen("Javascript has loaded for native ads.");
        zzbhn zzadl = zzbggVar.zzadl();
        com.google.android.gms.ads.internal.zzbb zzbbVar = this.zzdug;
        zzadl.zza(zzbbVar, zzbbVar, zzbbVar, zzbbVar, zzbbVar, false, null, new com.google.android.gms.ads.internal.zzw(this.mContext, null, null), null, null);
        zzbggVar.zza("/logScionEvent", this.zzduw);
        zzbggVar.zza("/logScionEvent", this.zzdux);
        return zzbbq.zzm(zzbggVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbcb zza(JSONObject jSONObject, zzbgg zzbggVar) throws Exception {
        jSONObject.put("ads_id", this.zzbqb);
        zzbggVar.zzb("google.afma.nativeAds.handleDownloadedImpressionPing", jSONObject);
        return zzbbq.zzm(new JSONObject());
    }
}
