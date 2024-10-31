package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.gmsg.zzy;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzaan;
import com.google.android.gms.internal.ads.zzaba;
import com.google.android.gms.internal.ads.zzakq;
import com.google.android.gms.internal.ads.zzakr;
import com.google.android.gms.internal.ads.zzalg;
import com.google.android.gms.internal.ads.zzalj;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzasm;
import com.google.android.gms.internal.ads.zzatv;
import com.google.android.gms.internal.ads.zzauk;
import com.google.android.gms.internal.ads.zzawd;
import com.google.android.gms.internal.ads.zzawr;
import com.google.android.gms.internal.ads.zzawv;
import com.google.android.gms.internal.ads.zzaxf;
import com.google.android.gms.internal.ads.zzaxg;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzayp;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzbgg;
import com.google.android.gms.internal.ads.zzbgm;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzbhn;
import com.google.android.gms.internal.ads.zzbhq;
import com.google.android.gms.internal.ads.zzbht;
import com.google.android.gms.internal.ads.zzsc;
import com.google.android.gms.internal.ads.zzwb;
import com.google.android.gms.internal.ads.zzwf;
import com.google.android.gms.internal.ads.zzwu;
import com.qq.e.comm.pi.ACTD;
import java.util.Collections;
import java.util.HashMap;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzal extends zzh implements com.google.android.gms.ads.internal.gmsg.zzah, zzy {

    /* renamed from: b, reason: collision with root package name */
    private transient boolean f10197b;

    /* renamed from: c, reason: collision with root package name */
    private int f10198c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f10199d;

    /* renamed from: e, reason: collision with root package name */
    private float f10200e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f10201f;

    /* renamed from: g, reason: collision with root package name */
    private zzawv f10202g;

    /* renamed from: h, reason: collision with root package name */
    private String f10203h;
    private final String i;
    private final zzauk j;

    public zzal(Context context, zzwf zzwfVar, String str, zzalg zzalgVar, zzbbi zzbbiVar, zzv zzvVar) {
        super(context, zzwfVar, str, zzalgVar, zzbbiVar, zzvVar);
        this.f10198c = -1;
        boolean z = false;
        this.f10197b = false;
        if (zzwfVar != null && "reward_mb".equals(zzwfVar.zzckk)) {
            z = true;
        }
        this.i = z ? "/Rewarded" : "/Interstitial";
        this.j = z ? new zzauk(this.zzbls, this.zzbma, new C0780f(this), this, this) : null;
    }

    private final boolean f(boolean z) {
        return this.j != null && z;
    }

    private final void zzb(Bundle bundle) {
        zzayh e2 = zzbv.e();
        zzbw zzbwVar = this.zzbls;
        e2.zzb(zzbwVar.f10251c, zzbwVar.f10253e.zzdp, "gmob-apps", bundle, false);
    }

    public final void B() {
        zzbv.z().zzb(Integer.valueOf(this.f10198c));
        if (this.zzbls.d()) {
            this.zzbls.b();
            zzbw zzbwVar = this.zzbls;
            zzbwVar.j = null;
            zzbwVar.M = false;
            this.f10197b = false;
        }
    }

    @Override // com.google.android.gms.ads.internal.zzh
    protected final zzbgg a(zzaxg zzaxgVar, zzw zzwVar, zzawr zzawrVar) throws zzbgq {
        zzbv.f();
        zzbw zzbwVar = this.zzbls;
        Context context = zzbwVar.f10251c;
        zzbht zzb = zzbht.zzb(zzbwVar.i);
        zzbw zzbwVar2 = this.zzbls;
        zzbgg zza = zzbgm.zza(context, zzb, zzbwVar2.i.zzckk, false, false, zzbwVar2.f10252d, zzbwVar2.f10253e, this.zzbln, this, this.zzbly, zzaxgVar.zzehw);
        zza.zzadl().zza(this, this, null, this, this, true, this, zzwVar, this, zzawrVar);
        a(zza);
        zza.zzfb(zzaxgVar.zzeag.zzdws);
        zza.zza("/reward", new com.google.android.gms.ads.internal.gmsg.zzag(this));
        return zza;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final void setImmersiveMode(boolean z) {
        Preconditions.a("setImmersiveMode must be called on the main UI thread.");
        this.f10201f = z;
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.internal.ads.zzxl
    public final void showInterstitial() {
        Bitmap bitmap;
        zzalj zzaljVar;
        String packageName;
        Preconditions.a("showInterstitial must be called on the main UI thread.");
        zzaxf zzaxfVar = this.zzbls.j;
        if (f(zzaxfVar != null && zzaxfVar.zzdyd)) {
            this.j.zzah(this.f10201f);
            return;
        }
        if (zzbv.E().zzv(this.zzbls.f10251c)) {
            this.f10203h = zzbv.E().zzw(this.zzbls.f10251c);
            String valueOf = String.valueOf(this.f10203h);
            String valueOf2 = String.valueOf(this.i);
            this.f10203h = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        if (this.zzbls.j == null) {
            zzbbd.zzeo("The interstitial has not loaded.");
            return;
        }
        if (!this.f10197b) {
            if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzcxp)).booleanValue()) {
                return;
            }
        }
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcra)).booleanValue()) {
            zzbv.e();
            if (zzayh.zzap(this.zzbls.f10251c)) {
                zzbbd.zzeo("It is not recommended to show an interstitial when app is not in foreground.");
                return;
            }
        }
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcsw)).booleanValue()) {
            if (this.zzbls.f10251c.getApplicationContext() != null) {
                packageName = this.zzbls.f10251c.getApplicationContext().getPackageName();
            } else {
                packageName = this.zzbls.f10251c.getPackageName();
            }
            if (!this.f10197b) {
                zzbbd.zzeo("It is not recommended to show an interstitial before onAdLoaded completes.");
                Bundle bundle = new Bundle();
                bundle.putString(ACTD.APPID_KEY, packageName);
                bundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "show_interstitial_before_load_finish");
                zzb(bundle);
            }
            zzbv.e();
            if (!zzayh.zzao(this.zzbls.f10251c)) {
                zzbbd.zzeo("It is not recommended to show an interstitial when app is not in foreground.");
                Bundle bundle2 = new Bundle();
                bundle2.putString(ACTD.APPID_KEY, packageName);
                bundle2.putString(NativeProtocol.WEB_DIALOG_ACTION, "show_interstitial_app_not_in_foreground");
                zzb(bundle2);
            }
        }
        if (this.zzbls.e()) {
            return;
        }
        zzaxf zzaxfVar2 = this.zzbls.j;
        if (zzaxfVar2.zzdyd && (zzaljVar = zzaxfVar2.zzdnc) != null) {
            try {
                zzaljVar.setImmersiveMode(this.f10201f);
                this.zzbls.j.zzdnc.showInterstitial();
                return;
            } catch (RemoteException e2) {
                zzbbd.zzc("Could not show interstitial.", e2);
                B();
                return;
            }
        }
        zzbgg zzbggVar = this.zzbls.j.zzdrv;
        if (zzbggVar == null) {
            zzbbd.zzeo("The interstitial failed to load.");
            return;
        }
        if (zzbggVar.zzadq()) {
            zzbbd.zzeo("The interstitial is already showing.");
            return;
        }
        this.zzbls.j.zzdrv.zzav(true);
        zzbw zzbwVar = this.zzbls;
        zzbwVar.a(zzbwVar.j.zzdrv.getView());
        zzbw zzbwVar2 = this.zzbls;
        zzaxf zzaxfVar3 = zzbwVar2.j;
        if (zzaxfVar3.zzehh != null) {
            this.zzblu.zza(zzbwVar2.i, zzaxfVar3);
        }
        if (PlatformVersion.a()) {
            final zzaxf zzaxfVar4 = this.zzbls.j;
            if (zzaxfVar4.zzmu()) {
                new zzsc(this.zzbls.f10251c, zzaxfVar4.zzdrv.getView()).zza(zzaxfVar4.zzdrv);
            } else {
                zzaxfVar4.zzdrv.zzadl().zza(new zzbhq(this, zzaxfVar4) { // from class: com.google.android.gms.ads.internal.e

                    /* renamed from: a, reason: collision with root package name */
                    private final zzal f10029a;

                    /* renamed from: b, reason: collision with root package name */
                    private final zzaxf f10030b;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f10029a = this;
                        this.f10030b = zzaxfVar4;
                    }

                    @Override // com.google.android.gms.internal.ads.zzbhq
                    public final void zzjx() {
                        zzal zzalVar = this.f10029a;
                        zzaxf zzaxfVar5 = this.f10030b;
                        new zzsc(zzalVar.zzbls.f10251c, zzaxfVar5.zzdrv.getView()).zza(zzaxfVar5.zzdrv);
                    }
                });
            }
        }
        if (this.zzbls.M) {
            zzbv.e();
            bitmap = zzayh.zzar(this.zzbls.f10251c);
        } else {
            bitmap = null;
        }
        this.f10198c = zzbv.z().zzb(bitmap);
        if (bitmap != null) {
            new C0781g(this, this.f10198c).zzyz();
            return;
        }
        boolean z = this.zzbls.M;
        zzbv.e();
        boolean zzay = zzayh.zzay(this.zzbls.f10251c);
        boolean z2 = this.f10201f;
        zzaxf zzaxfVar5 = this.zzbls.j;
        zzaq zzaqVar = new zzaq(z, zzay, false, 0.0f, -1, z2, zzaxfVar5.zzbph, zzaxfVar5.zzbpi);
        int requestedOrientation = this.zzbls.j.zzdrv.getRequestedOrientation();
        if (requestedOrientation == -1) {
            requestedOrientation = this.zzbls.j.orientation;
        }
        int i = requestedOrientation;
        zzbw zzbwVar3 = this.zzbls;
        zzaxf zzaxfVar6 = zzbwVar3.j;
        AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(this, this, this, zzaxfVar6.zzdrv, i, zzbwVar3.f10253e, zzaxfVar6.zzdyi, zzaqVar);
        zzbv.c();
        zzl.a(this.zzbls.f10251c, adOverlayInfoParcel, true);
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzah
    public final void v() {
        zzaxf zzaxfVar = this.zzbls.j;
        if (f(zzaxfVar != null && zzaxfVar.zzdyd)) {
            this.j.zzxe();
            zzio();
            return;
        }
        zzaxf zzaxfVar2 = this.zzbls.j;
        if (zzaxfVar2 != null && zzaxfVar2.zzehm != null) {
            zzbv.e();
            zzbw zzbwVar = this.zzbls;
            zzayh.zza(zzbwVar.f10251c, zzbwVar.f10253e.zzdp, zzbwVar.j.zzehm);
        }
        zzio();
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzah
    public final void w() {
        zzaxf zzaxfVar = this.zzbls.j;
        if (f(zzaxfVar != null && zzaxfVar.zzdyd)) {
            this.j.zzxf();
        }
        zzip();
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zza
    public final boolean zza(zzwb zzwbVar, zzaba zzabaVar) {
        if (this.zzbls.j != null) {
            zzbbd.zzeo("An interstitial is already loading. Aborting.");
            return false;
        }
        if (this.f10202g == null && zza.zza(zzwbVar) && zzbv.E().zzv(this.zzbls.f10251c) && !TextUtils.isEmpty(this.zzbls.f10250b)) {
            zzbw zzbwVar = this.zzbls;
            this.f10202g = new zzawv(zzbwVar.f10251c, zzbwVar.f10250b);
        }
        return super.zza(zzwbVar, zzabaVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final void zzii() {
        B();
        super.zzii();
    }

    @Override // com.google.android.gms.ads.internal.zzh, com.google.android.gms.ads.internal.zza
    protected final void zzil() {
        zzasm zzasmVar;
        zzaxf zzaxfVar = this.zzbls.j;
        zzbgg zzbggVar = zzaxfVar != null ? zzaxfVar.zzdrv : null;
        zzaxg zzaxgVar = this.zzbls.k;
        if (zzaxgVar != null && (zzasmVar = zzaxgVar.zzehy) != null && zzasmVar.zzdzc && zzbggVar != null && zzbv.v().zzk(this.zzbls.f10251c)) {
            zzbbi zzbbiVar = this.zzbls.f10253e;
            int i = zzbbiVar.zzeou;
            int i2 = zzbbiVar.zzeov;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i);
            sb.append(".");
            sb.append(i2);
            this.zzblx = zzbv.v().zza(sb.toString(), zzbggVar.getWebView(), "", "javascript", zzit());
            if (this.zzblx != null && zzbggVar.getView() != null) {
                zzbv.v().zza(this.zzblx, zzbggVar.getView());
                zzbggVar.zzaa(this.zzblx);
                zzbv.v().zzo(this.zzblx);
            }
        }
        super.zzil();
        this.f10197b = true;
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.overlay.zzn
    public final void zziv() {
        super.zziv();
        this.zzblu.zzh(this.zzbls.j);
        zzawv zzawvVar = this.f10202g;
        if (zzawvVar != null) {
            zzawvVar.zzai(false);
        }
        this.zzblx = null;
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.overlay.zzn
    public final void zziw() {
        zzaxf zzaxfVar;
        zzbgg zzbggVar;
        zzaxf zzaxfVar2;
        zzbgg zzbggVar2;
        zzbhn zzadl;
        recordImpression();
        super.zziw();
        zzaxf zzaxfVar3 = this.zzbls.j;
        if (zzaxfVar3 != null && (zzbggVar2 = zzaxfVar3.zzdrv) != null && (zzadl = zzbggVar2.zzadl()) != null) {
            zzadl.zzaeg();
        }
        if (zzbv.E().zzv(this.zzbls.f10251c) && (zzaxfVar2 = this.zzbls.j) != null && zzaxfVar2.zzdrv != null) {
            zzbv.E().zze(this.zzbls.j.zzdrv.getContext(), this.f10203h);
        }
        zzawv zzawvVar = this.f10202g;
        if (zzawvVar != null) {
            zzawvVar.zzai(true);
        }
        if (this.zzblx == null || (zzaxfVar = this.zzbls.j) == null || (zzbggVar = zzaxfVar.zzdrv) == null) {
            return;
        }
        zzbggVar.zza("onSdkImpression", new HashMap());
    }

    @Override // com.google.android.gms.internal.ads.zzaol
    public final void zzjv() {
        zzd zzadh = this.zzbls.j.zzdrv.zzadh();
        if (zzadh != null) {
            zzadh.A();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzh, com.google.android.gms.ads.internal.zza
    public final void zza(zzaxg zzaxgVar, zzaba zzabaVar) {
        if (zzaxgVar.errorCode != -2) {
            super.zza(zzaxgVar, zzabaVar);
            return;
        }
        if (f(zzaxgVar.zzehj != null)) {
            this.j.zzxd();
            return;
        }
        if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzcrz)).booleanValue()) {
            super.zza(zzaxgVar, zzabaVar);
            return;
        }
        boolean z = !zzaxgVar.zzehy.zzdyd;
        if (zza.zza(zzaxgVar.zzeag.zzdwg) && z) {
            this.zzbls.k = a(zzaxgVar);
        }
        super.zza(this.zzbls.k, zzabaVar);
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzy
    public final void a(boolean z) {
        this.zzbls.M = z;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzy
    public final void a(boolean z, float f2) {
        this.f10199d = z;
        this.f10200e = f2;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzah
    public final void a(zzawd zzawdVar) {
        zzaxf zzaxfVar = this.zzbls.j;
        if (f(zzaxfVar != null && zzaxfVar.zzdyd)) {
            zza(this.j.zzd(zzawdVar));
            return;
        }
        zzaxf zzaxfVar2 = this.zzbls.j;
        if (zzaxfVar2 != null) {
            if (zzaxfVar2.zzdyt != null) {
                zzbv.e();
                zzbw zzbwVar = this.zzbls;
                zzayh.zza(zzbwVar.f10251c, zzbwVar.f10253e.zzdp, zzbwVar.j.zzdyt);
            }
            zzawd zzawdVar2 = this.zzbls.j.zzdyr;
            if (zzawdVar2 != null) {
                zzawdVar = zzawdVar2;
            }
        }
        zza(zzawdVar);
    }

    @Override // com.google.android.gms.ads.internal.zzc
    protected final boolean zza(zzwb zzwbVar, zzaxf zzaxfVar, boolean z) {
        if (this.zzbls.d() && zzaxfVar.zzdrv != null) {
            zzbv.g();
            zzayp.zzi(zzaxfVar.zzdrv);
        }
        return this.zzblr.e();
    }

    @VisibleForTesting
    private static zzaxg a(zzaxg zzaxgVar) {
        try {
            String jSONObject = zzatv.zzb(zzaxgVar.zzehy).toString();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, zzaxgVar.zzeag.zzbsn);
            zzakq zzakqVar = new zzakq(jSONObject, null, Collections.singletonList("com.google.ads.mediation.admob.AdMobAdapter"), null, null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), jSONObject2.toString(), null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList(), null, -1L);
            zzasm zzasmVar = zzaxgVar.zzehy;
            zzakr zzakrVar = new zzakr(Collections.singletonList(zzakqVar), ((Long) zzwu.zzpz().zzd(zzaan.zzctf)).longValue(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), zzasmVar.zzdlu, zzasmVar.zzdlv, "", -1L, 0, 1, null, 0, -1, -1L, false);
            return new zzaxg(zzaxgVar.zzeag, new zzasm(zzaxgVar.zzeag, zzasmVar.zzbde, zzasmVar.zzdyb, Collections.emptyList(), Collections.emptyList(), zzasmVar.zzdyc, true, zzasmVar.zzdye, Collections.emptyList(), zzasmVar.zzdlx, zzasmVar.orientation, zzasmVar.zzdyg, zzasmVar.zzdyh, zzasmVar.zzdyi, zzasmVar.zzdyj, zzasmVar.zzdyk, null, zzasmVar.zzdym, zzasmVar.zzckn, zzasmVar.zzdwn, zzasmVar.zzdyn, zzasmVar.zzdyo, zzasmVar.zzcgx, zzasmVar.zzcko, zzasmVar.zzckp, null, Collections.emptyList(), Collections.emptyList(), zzasmVar.zzdyu, zzasmVar.zzdyv, zzasmVar.zzdxb, zzasmVar.zzdxc, zzasmVar.zzdlu, zzasmVar.zzdlv, zzasmVar.zzdyw, null, zzasmVar.zzdyy, zzasmVar.zzdyz, zzasmVar.zzdxn, zzasmVar.zzbph, 0, zzasmVar.zzdzc, Collections.emptyList(), zzasmVar.zzbpi, zzasmVar.zzdzd, zzasmVar.zzdze, zzasmVar.zzdzf), zzakrVar, zzaxgVar.zzbst, zzaxgVar.errorCode, zzaxgVar.zzehn, zzaxgVar.zzeho, null, zzaxgVar.zzehw, null);
        } catch (JSONException e2) {
            zzbbd.zzb("Unable to generate ad state for an interstitial ad with pooling.", e2);
            return zzaxgVar;
        }
    }

    @Override // com.google.android.gms.ads.internal.zzh, com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zza
    public final boolean zza(zzaxf zzaxfVar, zzaxf zzaxfVar2) {
        zzbw zzbwVar;
        View view;
        if (f(zzaxfVar2.zzdyd)) {
            return zzauk.zza(zzaxfVar, zzaxfVar2);
        }
        if (!super.zza(zzaxfVar, zzaxfVar2)) {
            return false;
        }
        if (!this.zzbls.d() && (view = (zzbwVar = this.zzbls).K) != null && zzaxfVar2.zzehh != null) {
            this.zzblu.zza(zzbwVar.i, zzaxfVar2, view);
        }
        zzb(zzaxfVar2, false);
        return true;
    }
}
