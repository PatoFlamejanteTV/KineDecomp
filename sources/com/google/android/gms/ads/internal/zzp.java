package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaba;
import com.google.android.gms.internal.ads.zzabg;
import com.google.android.gms.internal.ads.zzabs;
import com.google.android.gms.internal.ads.zzabu;
import com.google.android.gms.internal.ads.zzabz;
import com.google.android.gms.internal.ads.zzacb;
import com.google.android.gms.internal.ads.zzacc;
import com.google.android.gms.internal.ads.zzacd;
import com.google.android.gms.internal.ads.zzace;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzaeh;
import com.google.android.gms.internal.ads.zzaen;
import com.google.android.gms.internal.ads.zzakq;
import com.google.android.gms.internal.ads.zzakr;
import com.google.android.gms.internal.ads.zzalg;
import com.google.android.gms.internal.ads.zzals;
import com.google.android.gms.internal.ads.zzalv;
import com.google.android.gms.internal.ads.zzaly;
import com.google.android.gms.internal.ads.zzapl;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzasi;
import com.google.android.gms.internal.ads.zzasm;
import com.google.android.gms.internal.ads.zzawd;
import com.google.android.gms.internal.ads.zzaxf;
import com.google.android.gms.internal.ads.zzaxg;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzbgg;
import com.google.android.gms.internal.ads.zzwb;
import com.google.android.gms.internal.ads.zzwf;
import com.google.android.gms.internal.ads.zzyp;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzp extends zzc implements zzace {

    /* renamed from: a, reason: collision with root package name */
    private boolean f10261a;

    /* renamed from: b, reason: collision with root package name */
    private zzaxf f10262b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f10263c;

    public zzp(Context context, zzv zzvVar, zzwf zzwfVar, String str, zzalg zzalgVar, zzbbi zzbbiVar) {
        super(context, zzwfVar, str, zzalgVar, zzbbiVar, zzvVar);
        this.f10263c = false;
    }

    private final zzakr B() {
        zzaxf zzaxfVar = this.zzbls.j;
        if (zzaxfVar == null || !zzaxfVar.zzdyd) {
            return null;
        }
        return zzaxfVar.zzehj;
    }

    private static zzaxf a(zzaxg zzaxgVar, int i) {
        zzasi zzasiVar = zzaxgVar.zzeag;
        zzwb zzwbVar = zzasiVar.zzdwg;
        zzasm zzasmVar = zzaxgVar.zzehy;
        List<String> list = zzasmVar.zzdlq;
        List<String> list2 = zzasmVar.zzdlr;
        List<String> list3 = zzasmVar.zzdyf;
        int i2 = zzasmVar.orientation;
        long j = zzasmVar.zzdlx;
        String str = zzasiVar.zzdwj;
        boolean z = zzasmVar.zzdyd;
        zzakr zzakrVar = zzaxgVar.zzehj;
        long j2 = zzasmVar.zzdye;
        zzwf zzwfVar = zzaxgVar.zzbst;
        long j3 = zzasmVar.zzdyc;
        long j4 = zzaxgVar.zzehn;
        long j5 = zzaxgVar.zzeho;
        String str2 = zzasmVar.zzdyi;
        JSONObject jSONObject = zzaxgVar.zzehh;
        zzawd zzawdVar = zzasmVar.zzdyr;
        List<String> list4 = zzasmVar.zzdys;
        return new zzaxf(zzwbVar, null, list, i, list2, list3, i2, j, str, z, null, null, null, zzakrVar, null, j2, zzwfVar, j3, j4, j5, str2, jSONObject, null, zzawdVar, list4, list4, zzasmVar.zzdyu, zzasmVar.zzdyv, null, zzasmVar.zzdlu, zzasmVar.zzdyy, zzaxgVar.zzehw, zzasmVar.zzbph, zzaxgVar.zzehx, zzasmVar.zzdzc, zzasmVar.zzdls, zzasmVar.zzbpi, zzasmVar.zzdzd, zzasmVar.zzdzf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean b(zzaxf zzaxfVar, zzaxf zzaxfVar2) {
        View a2 = zzas.a(zzaxfVar2);
        if (a2 == null) {
            return false;
        }
        View nextView = this.zzbls.f10254f.getNextView();
        if (nextView != 0) {
            if (nextView instanceof zzbgg) {
                ((zzbgg) nextView).destroy();
            }
            this.zzbls.f10254f.removeView(nextView);
        }
        if (!zzas.b(zzaxfVar2)) {
            try {
                zzg(a2);
            } catch (Throwable th) {
                zzbv.i().zza(th, "AdLoaderManager.swapBannerViews");
                zzbbd.zzc("Could not add mediation view to view hierarchy.", th);
                return false;
            }
        }
        if (this.zzbls.f10254f.getChildCount() > 1) {
            this.zzbls.f10254f.showNext();
        }
        if (zzaxfVar != null) {
            View nextView2 = this.zzbls.f10254f.getNextView();
            if (nextView2 != null) {
                this.zzbls.f10254f.removeView(nextView2);
            }
            this.zzbls.c();
        }
        this.zzbls.f10254f.setMinimumWidth(zzif().widthPixels);
        this.zzbls.f10254f.setMinimumHeight(zzif().heightPixels);
        this.zzbls.f10254f.requestLayout();
        this.zzbls.f10254f.setVisibility(0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void A() {
        zzb(this.f10262b);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final zzyp getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final void pause() {
        if (this.f10263c) {
            super.pause();
            return;
        }
        throw new IllegalStateException("Native Ad does not support pause().");
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final void resume() {
        if (this.f10263c) {
            super.resume();
            return;
        }
        throw new IllegalStateException("Native Ad does not support resume().");
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final void setManualImpressionsEnabled(boolean z) {
        Preconditions.a("setManualImpressionsEnabled must be called from the main thread.");
        this.f10261a = z;
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.internal.ads.zzxl
    public final void showInterstitial() {
        throw new IllegalStateException("Interstitial is not supported by AdLoaderManager.");
    }

    @Override // com.google.android.gms.ads.internal.zza
    public final void zza(zzaxg zzaxgVar, zzaba zzabaVar) {
        this.f10262b = null;
        int i = zzaxgVar.errorCode;
        if (i != -2) {
            this.f10262b = a(zzaxgVar, i);
        } else if (!zzaxgVar.zzehy.zzdyd) {
            zzbbd.zzeo("partialAdState is not mediation");
            this.f10262b = a(zzaxgVar, 0);
        }
        if (this.f10262b != null) {
            zzayh.zzelc.post(new Runnable(this) { // from class: com.google.android.gms.ads.internal.P

                /* renamed from: a, reason: collision with root package name */
                private final zzp f10009a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f10009a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f10009a.A();
                }
            });
            return;
        }
        zzwf zzwfVar = zzaxgVar.zzbst;
        if (zzwfVar != null) {
            this.zzbls.i = zzwfVar;
        }
        zzbw zzbwVar = this.zzbls;
        zzbwVar.L = 0;
        zzbv.d();
        zzbw zzbwVar2 = this.zzbls;
        zzbwVar.f10256h = zzapl.zza(zzbwVar2.f10251c, this, zzaxgVar, zzbwVar2.f10252d, null, this.zzbma, this, zzabaVar);
    }

    @Override // com.google.android.gms.ads.internal.zzc
    protected final boolean zza(zzwb zzwbVar, zzaxf zzaxfVar, boolean z) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final zzaeh zzar(String str) {
        Preconditions.a("getOnCustomClickListener must be called on the main UI thread.");
        return this.zzbls.v.get(str);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final boolean zzb(zzwb zzwbVar) {
        zzwb zzwbVar2 = zzwbVar;
        List<Integer> list = this.zzbls.C;
        if (list != null && list.size() == 1 && this.zzbls.C.get(0).intValue() == 2) {
            zzbbd.e("Requesting only banner Ad from AdLoader or calling loadAd on returned banner is not yet supported");
            zzbr(0);
            return false;
        }
        if (this.zzbls.B != null) {
            boolean z = zzwbVar2.zzcjg;
            boolean z2 = this.f10261a;
            if (z != z2) {
                zzwbVar2 = new zzwb(zzwbVar2.versionCode, zzwbVar2.zzcjb, zzwbVar2.extras, zzwbVar2.zzcjc, zzwbVar2.zzcjd, zzwbVar2.zzcje, zzwbVar2.zzcjf, z || z2, zzwbVar2.zzcjh, zzwbVar2.zzcji, zzwbVar2.zzcjj, zzwbVar2.zzcjk, zzwbVar2.zzcjl, zzwbVar2.zzcjm, zzwbVar2.zzcjn, zzwbVar2.zzcjo, zzwbVar2.zzcjp, zzwbVar2.zzcjq, null, zzwbVar2.zzcjs, zzwbVar2.zzcjt);
            }
            return super.zzb(zzwbVar2);
        }
        return super.zzb(zzwbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final void zzi(View view) {
        zzbbd.zzd("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final void zzil() {
        zzakq zzakqVar;
        zzbw zzbwVar;
        zzaen zzaenVar;
        super.zzil();
        zzaxf zzaxfVar = this.zzbls.j;
        if (zzaxfVar == null || (zzakqVar = zzaxfVar.zzdnb) == null || !zzakqVar.zzuj() || (zzaenVar = (zzbwVar = this.zzbls).B) == null) {
            return;
        }
        try {
            zzaenVar.zza(this, ObjectWrapper.a(zzbwVar.f10251c));
            super.zzb(this.zzbls.j, false);
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.internal.ads.zzaks
    public final void zziy() {
        zzakq zzakqVar;
        zzaxf zzaxfVar = this.zzbls.j;
        if (zzaxfVar != null && "com.google.ads.mediation.admob.AdMobAdapter".equals(zzaxfVar.zzdnd) && (zzakqVar = this.zzbls.j.zzdnb) != null && zzakqVar.zzuk()) {
            zzin();
        } else {
            super.zziy();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.internal.ads.zzaks
    public final void zzjd() {
        zzakq zzakqVar;
        zzaxf zzaxfVar = this.zzbls.j;
        if (zzaxfVar != null && "com.google.ads.mediation.admob.AdMobAdapter".equals(zzaxfVar.zzdnd) && (zzakqVar = this.zzbls.j.zzdnb) != null && zzakqVar.zzuk()) {
            zzim();
        } else {
            super.zzjd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final void zzjl() {
        zzbbd.zzd("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final void zzjm() {
        zzbbd.zzd("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final void zzjn() {
        zzbbd.zzd("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final boolean zzjo() {
        if (B() != null) {
            return B().zzdmd;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final boolean zzjp() {
        if (B() != null) {
            return B().zzdme;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final boolean zzjq() {
        if (B() != null) {
            return B().zzdmf;
        }
        return false;
    }

    private final boolean a(zzaxf zzaxfVar, zzaxf zzaxfVar2) {
        a((List<String>) null);
        if (!this.zzbls.d()) {
            zzbbd.zzeo("Native ad does not have custom rendering mode.");
            zzbr(0);
            return false;
        }
        try {
            zzaly zzva = zzaxfVar2.zzdnc != null ? zzaxfVar2.zzdnc.zzva() : null;
            zzals zzuu = zzaxfVar2.zzdnc != null ? zzaxfVar2.zzdnc.zzuu() : null;
            zzalv zzuv = zzaxfVar2.zzdnc != null ? zzaxfVar2.zzdnc.zzuv() : null;
            zzadx zzuz = zzaxfVar2.zzdnc != null ? zzaxfVar2.zzdnc.zzuz() : null;
            String zzc = zzc.zzc(zzaxfVar2);
            if (zzva != null && this.zzbls.t != null) {
                zzabz zzabzVar = new zzabz(zzva.getHeadline(), zzva.getImages(), zzva.getBody(), zzva.zzsb() != null ? zzva.zzsb() : null, zzva.getCallToAction(), zzva.getAdvertiser(), zzva.getStarRating(), zzva.getStore(), zzva.getPrice(), null, zzva.getVideoController(), zzva.zzvc() != null ? (View) ObjectWrapper.a(zzva.zzvc()) : null, zzva.zzsd(), zzc, zzva.getExtras());
                zzabzVar.zzb(new zzacc(this.zzbls.f10251c, this, this.zzbls.f10252d, zzva, zzabzVar));
                a(zzabzVar);
            } else if (zzuu != null && this.zzbls.t != null) {
                zzabz zzabzVar2 = new zzabz(zzuu.getHeadline(), zzuu.getImages(), zzuu.getBody(), zzuu.zzsb() != null ? zzuu.zzsb() : null, zzuu.getCallToAction(), null, zzuu.getStarRating(), zzuu.getStore(), zzuu.getPrice(), null, zzuu.getVideoController(), zzuu.zzvc() != null ? (View) ObjectWrapper.a(zzuu.zzvc()) : null, zzuu.zzsd(), zzc, zzuu.getExtras());
                zzabzVar2.zzb(new zzacc(this.zzbls.f10251c, this, this.zzbls.f10252d, zzuu, zzabzVar2));
                a(zzabzVar2);
            } else if (zzuu != null && this.zzbls.r != null) {
                zzabs zzabsVar = new zzabs(zzuu.getHeadline(), zzuu.getImages(), zzuu.getBody(), zzuu.zzsb() != null ? zzuu.zzsb() : null, zzuu.getCallToAction(), zzuu.getStarRating(), zzuu.getStore(), zzuu.getPrice(), null, zzuu.getExtras(), zzuu.getVideoController(), zzuu.zzvc() != null ? (View) ObjectWrapper.a(zzuu.zzvc()) : null, zzuu.zzsd(), zzc);
                zzabsVar.zzb(new zzacc(this.zzbls.f10251c, this, this.zzbls.f10252d, zzuu, zzabsVar));
                zzayh.zzelc.post(new S(this, zzabsVar));
            } else if (zzuv != null && this.zzbls.t != null) {
                zzabz zzabzVar3 = new zzabz(zzuv.getHeadline(), zzuv.getImages(), zzuv.getBody(), zzuv.zzsf() != null ? zzuv.zzsf() : null, zzuv.getCallToAction(), zzuv.getAdvertiser(), -1.0d, null, null, null, zzuv.getVideoController(), zzuv.zzvc() != null ? (View) ObjectWrapper.a(zzuv.zzvc()) : null, zzuv.zzsd(), zzc, zzuv.getExtras());
                zzabzVar3.zzb(new zzacc(this.zzbls.f10251c, this, this.zzbls.f10252d, zzuv, zzabzVar3));
                a(zzabzVar3);
            } else if (zzuv != null && this.zzbls.s != null) {
                zzabu zzabuVar = new zzabu(zzuv.getHeadline(), zzuv.getImages(), zzuv.getBody(), zzuv.zzsf() != null ? zzuv.zzsf() : null, zzuv.getCallToAction(), zzuv.getAdvertiser(), null, zzuv.getExtras(), zzuv.getVideoController(), zzuv.zzvc() != null ? (View) ObjectWrapper.a(zzuv.zzvc()) : null, zzuv.zzsd(), zzc);
                zzabuVar.zzb(new zzacc(this.zzbls.f10251c, this, this.zzbls.f10252d, zzuv, zzabuVar));
                zzayh.zzelc.post(new T(this, zzabuVar));
            } else if (zzuz != null && this.zzbls.w != null && this.zzbls.w.get(zzuz.getCustomTemplateId()) != null) {
                zzayh.zzelc.post(new U(this, zzuz));
            } else {
                zzbbd.zzeo("No matching mapper/listener for retrieved native ad template.");
                zzbr(0);
                return false;
            }
            return super.zza(zzaxfVar, zzaxfVar2);
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
            zzbr(0);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzb(IObjectWrapper iObjectWrapper) {
        Object a2 = iObjectWrapper != null ? ObjectWrapper.a(iObjectWrapper) : null;
        if (a2 instanceof zzacd) {
            ((zzacd) a2).zzsm();
        }
        super.zzb(this.zzbls.j, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zza
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zza(com.google.android.gms.internal.ads.zzaxf r5, com.google.android.gms.internal.ads.zzaxf r6) {
        /*
            r4 = this;
            com.google.android.gms.ads.internal.zzbw r0 = r4.zzbls
            boolean r0 = r0.d()
            if (r0 == 0) goto L94
            boolean r0 = r6.zzdyd
            r1 = 0
            if (r0 != 0) goto L16
            r4.zzbr(r1)
            java.lang.String r5 = "newState is not mediation."
            com.google.android.gms.internal.ads.zzbbd.zzeo(r5)
            return r1
        L16:
            com.google.android.gms.internal.ads.zzakq r0 = r6.zzdnb
            r2 = 1
            if (r0 == 0) goto L64
            boolean r0 = r0.zzuj()
            if (r0 == 0) goto L64
            com.google.android.gms.ads.internal.zzbw r0 = r4.zzbls
            boolean r0 = r0.d()
            if (r0 == 0) goto L38
            com.google.android.gms.ads.internal.zzbw r0 = r4.zzbls
            com.google.android.gms.ads.internal.zzbx r0 = r0.f10254f
            if (r0 == 0) goto L38
            com.google.android.gms.internal.ads.zzazc r0 = r0.a()
            java.lang.String r3 = r6.zzdyi
            r0.zzef(r3)
        L38:
            boolean r0 = super.zza(r5, r6)
            if (r0 != 0) goto L40
        L3e:
            r5 = 0
            goto L5e
        L40:
            com.google.android.gms.ads.internal.zzbw r0 = r4.zzbls
            boolean r0 = r0.d()
            if (r0 == 0) goto L52
            boolean r5 = r4.b(r5, r6)
            if (r5 != 0) goto L52
            r4.zzbr(r1)
            goto L3e
        L52:
            com.google.android.gms.ads.internal.zzbw r5 = r4.zzbls
            boolean r5 = r5.e()
            if (r5 != 0) goto L5d
            super.zza(r6, r1)
        L5d:
            r5 = 1
        L5e:
            if (r5 != 0) goto L61
            return r1
        L61:
            r4.f10263c = r2
            goto L75
        L64:
            com.google.android.gms.internal.ads.zzakq r0 = r6.zzdnb
            if (r0 == 0) goto L8b
            boolean r0 = r0.zzuk()
            if (r0 == 0) goto L8b
            boolean r5 = r4.a(r5, r6)
            if (r5 != 0) goto L75
            return r1
        L75:
            java.util.ArrayList r5 = new java.util.ArrayList
            java.lang.Integer[] r6 = new java.lang.Integer[r2]
            r0 = 2
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r6[r1] = r0
            java.util.List r6 = java.util.Arrays.asList(r6)
            r5.<init>(r6)
            r4.b(r5)
            return r2
        L8b:
            r4.zzbr(r1)
            java.lang.String r5 = "Response is neither banner nor native."
            com.google.android.gms.internal.ads.zzbbd.zzeo(r5)
            return r1
        L94:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "AdLoader API does not support custom rendering."
            r5.<init>(r6)
            goto L9d
        L9c:
            throw r5
        L9d:
            goto L9c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzp.zza(com.google.android.gms.internal.ads.zzaxf, com.google.android.gms.internal.ads.zzaxf):boolean");
    }

    public final void b(List<Integer> list) {
        Preconditions.a("setAllowedAdTypes must be called on the main UI thread.");
        this.zzbls.C = list;
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final void zza(zzacd zzacdVar) {
        zzbbd.zzd("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final void zza(zzacb zzacbVar) {
        zzbbd.zzd("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final void zza(zzabg zzabgVar) {
        throw new IllegalStateException("CustomRendering is not supported by AdLoaderManager.");
    }

    private final void a(zzabz zzabzVar) {
        zzayh.zzelc.post(new Q(this, zzabzVar));
    }

    public final void a(List<String> list) {
        Preconditions.a("setNativeTemplates must be called on the main UI thread.");
        this.zzbls.I = list;
    }
}
