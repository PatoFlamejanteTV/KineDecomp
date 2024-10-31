package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.zzbw;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzauo extends com.google.android.gms.ads.internal.zzc implements zzavr {
    private static zzauo zzeeh;
    private boolean zzboq;

    @VisibleForTesting
    private final zzawv zzbor;
    private boolean zzeei;
    private final zzauk zzeej;

    public zzauo(Context context, com.google.android.gms.ads.internal.zzv zzvVar, zzwf zzwfVar, zzalg zzalgVar, zzbbi zzbbiVar) {
        super(context, zzwfVar, null, zzalgVar, zzbbiVar, zzvVar);
        zzeeh = this;
        this.zzbor = new zzawv(context, null);
        this.zzeej = new zzauk(this.zzbls, this.zzbma, this, this, this);
    }

    public static zzauo zzxg() {
        return zzeeh;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final void destroy() {
        this.zzeej.destroy();
        super.destroy();
    }

    public final boolean isLoaded() {
        Preconditions.a("isLoaded must be called on the main UI thread.");
        zzbw zzbwVar = this.zzbls;
        return zzbwVar.f10255g == null && zzbwVar.f10256h == null && zzbwVar.j != null;
    }

    public final void onContextChanged(Context context) {
        this.zzeej.onContextChanged(context);
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void onRewardedVideoAdClosed() {
        if (com.google.android.gms.ads.internal.zzbv.E().zzv(this.zzbls.f10251c)) {
            this.zzbor.zzai(false);
        }
        zzii();
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void onRewardedVideoAdLeftApplication() {
        zzij();
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void onRewardedVideoAdOpened() {
        if (com.google.android.gms.ads.internal.zzbv.E().zzv(this.zzbls.f10251c)) {
            this.zzbor.zzai(true);
        }
        zza(this.zzbls.j, false);
        zzik();
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void onRewardedVideoCompleted() {
        this.zzeej.zzxf();
        zzip();
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void onRewardedVideoStarted() {
        this.zzeej.zzxe();
        zzio();
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final void pause() {
        this.zzeej.pause();
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final void resume() {
        this.zzeej.resume();
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final void setImmersiveMode(boolean z) {
        Preconditions.a("setImmersiveMode must be called on the main UI thread.");
        this.zzboq = z;
    }

    public final void zza(zzavh zzavhVar) {
        Preconditions.a("loadAd must be called on the main UI thread.");
        if (TextUtils.isEmpty(zzavhVar.zzbsn)) {
            zzbbd.zzeo("Invalid ad unit id. Aborting.");
            zzayh.zzelc.post(new Yc(this));
            return;
        }
        this.zzeei = false;
        zzbw zzbwVar = this.zzbls;
        String str = zzavhVar.zzbsn;
        zzbwVar.f10250b = str;
        this.zzbor.setAdUnitId(str);
        super.zzb(zzavhVar.zzdwg);
    }

    @Override // com.google.android.gms.ads.internal.zzc
    protected final boolean zza(zzwb zzwbVar, zzaxf zzaxfVar, boolean z) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void zzc(zzawd zzawdVar) {
        zzawd zzd = this.zzeej.zzd(zzawdVar);
        if (com.google.android.gms.ads.internal.zzbv.E().zzv(this.zzbls.f10251c) && zzd != null) {
            com.google.android.gms.ads.internal.zzbv.E().zza(this.zzbls.f10251c, com.google.android.gms.ads.internal.zzbv.E().zzz(this.zzbls.f10251c), this.zzbls.f10250b, zzd.type, zzd.zzefo);
        }
        zza(zzd);
    }

    public final zzavy zzdd(String str) {
        return this.zzeej.zzdd(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final void zzii() {
        this.zzbls.j = null;
        super.zzii();
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void zzkh() {
        onAdClicked();
    }

    public final void zzxh() {
        Preconditions.a("showAd must be called on the main UI thread.");
        if (!isLoaded()) {
            zzbbd.zzeo("The reward video has not loaded.");
        } else {
            this.zzeej.zzah(this.zzboq);
        }
    }

    private static zzaxg zzc(zzaxg zzaxgVar) {
        zzaxz.v("Creating mediation ad response for non-mediated rewarded ad.");
        try {
            JSONObject zzb = zzatv.zzb(zzaxgVar.zzehy);
            zzb.remove("impression_urls");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, zzaxgVar.zzeag.zzbsn);
            return new zzaxg(zzaxgVar.zzeag, zzaxgVar.zzehy, new zzakr(Arrays.asList(new zzakq(zzb.toString(), null, Arrays.asList("com.google.ads.mediation.admob.AdMobAdapter"), null, null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), jSONObject.toString(), null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList(), null, -1L)), ((Long) zzwu.zzpz().zzd(zzaan.zzctf)).longValue(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), false, "", -1L, 0, 1, null, 0, -1, -1L, false), zzaxgVar.zzbst, zzaxgVar.errorCode, zzaxgVar.zzehn, zzaxgVar.zzeho, zzaxgVar.zzehh, zzaxgVar.zzehw, null);
        } catch (JSONException e2) {
            zzbbd.zzb("Unable to generate ad state for non-mediated rewarded video.", e2);
            return new zzaxg(zzaxgVar.zzeag, zzaxgVar.zzehy, null, zzaxgVar.zzbst, 0, zzaxgVar.zzehn, zzaxgVar.zzeho, zzaxgVar.zzehh, zzaxgVar.zzehw, null);
        }
    }

    @Override // com.google.android.gms.ads.internal.zza
    public final void zza(zzaxg zzaxgVar, zzaba zzabaVar) {
        if (zzaxgVar.errorCode != -2) {
            zzayh.zzelc.post(new Zc(this, zzaxgVar));
            return;
        }
        zzbw zzbwVar = this.zzbls;
        zzbwVar.k = zzaxgVar;
        if (zzaxgVar.zzehj == null) {
            zzbwVar.k = zzc(zzaxgVar);
        }
        this.zzeej.zzxd();
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zza
    public final boolean zza(zzaxf zzaxfVar, zzaxf zzaxfVar2) {
        zzb(zzaxfVar2, false);
        return zzauk.zza(zzaxfVar, zzaxfVar2);
    }
}
