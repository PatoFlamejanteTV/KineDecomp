package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzaan;
import com.google.android.gms.internal.ads.zzaba;
import com.google.android.gms.internal.ads.zzabg;
import com.google.android.gms.internal.ads.zzalg;
import com.google.android.gms.internal.ads.zzaol;
import com.google.android.gms.internal.ads.zzapl;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzasm;
import com.google.android.gms.internal.ads.zzawr;
import com.google.android.gms.internal.ads.zzaws;
import com.google.android.gms.internal.ads.zzaxf;
import com.google.android.gms.internal.ads.zzaxg;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzbgg;
import com.google.android.gms.internal.ads.zzbgm;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzbht;
import com.google.android.gms.internal.ads.zzwf;
import com.google.android.gms.internal.ads.zzwu;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public abstract class zzh extends zzc implements zzaf, zzaol {

    /* renamed from: a, reason: collision with root package name */
    private boolean f10260a;

    public zzh(Context context, zzwf zzwfVar, String str, zzalg zzalgVar, zzbbi zzbbiVar, zzv zzvVar) {
        super(context, zzwfVar, str, zzalgVar, zzbbiVar, zzvVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean A() {
        zzasm zzasmVar;
        zzaxg zzaxgVar = this.zzbls.k;
        return (zzaxgVar == null || (zzasmVar = zzaxgVar.zzehy) == null || !zzasmVar.zzdzc) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public zzbgg a(zzaxg zzaxgVar, zzw zzwVar, zzawr zzawrVar) throws zzbgq {
        View nextView = this.zzbls.f10254f.getNextView();
        if (nextView instanceof zzbgg) {
            ((zzbgg) nextView).destroy();
        }
        if (nextView != 0) {
            this.zzbls.f10254f.removeView(nextView);
        }
        zzbv.f();
        zzbw zzbwVar = this.zzbls;
        Context context = zzbwVar.f10251c;
        zzbht zzb = zzbht.zzb(zzbwVar.i);
        zzbw zzbwVar2 = this.zzbls;
        zzbgg zza = zzbgm.zza(context, zzb, zzbwVar2.i.zzckk, false, false, zzbwVar2.f10252d, zzbwVar2.f10253e, this.zzbln, this, this.zzbly, zzaxgVar.zzehw);
        if (this.zzbls.i.zzckm == null) {
            zzg(zza.getView());
        }
        zza.zzadl().zza(this, this, this, this, this, false, null, zzwVar, this, zzawrVar);
        a(zza);
        zza.zzfb(zzaxgVar.zzeag.zzdws);
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void b(zzbgg zzbggVar) {
        zzbw zzbwVar = this.zzbls;
        zzaxf zzaxfVar = zzbwVar.j;
        if (zzaxfVar != null) {
            this.zzblu.zza(zzbwVar.i, zzaxfVar, zzbggVar.getView(), zzbggVar);
            this.f10260a = false;
        } else {
            this.f10260a = true;
            zzbbd.zzeo("Request to enable ActiveView before adState is available.");
        }
    }

    @Override // com.google.android.gms.ads.internal.zzaf
    public final void x() {
        onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zzaf
    public final void y() {
        recordImpression();
        zzih();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public void zza(zzaxg zzaxgVar, zzaba zzabaVar) {
        if (zzaxgVar.errorCode != -2) {
            zzayh.zzelc.post(new K(this, zzaxgVar));
            return;
        }
        zzwf zzwfVar = zzaxgVar.zzbst;
        if (zzwfVar != null) {
            this.zzbls.i = zzwfVar;
        }
        zzasm zzasmVar = zzaxgVar.zzehy;
        if (zzasmVar.zzdyd && !zzasmVar.zzckp) {
            zzbw zzbwVar = this.zzbls;
            zzbwVar.L = 0;
            zzbv.d();
            zzbw zzbwVar2 = this.zzbls;
            zzbwVar.f10256h = zzapl.zza(zzbwVar2.f10251c, this, zzaxgVar, zzbwVar2.f10252d, null, this.zzbma, this, zzabaVar);
            return;
        }
        zzaws zzawsVar = this.zzbly.f10266c;
        zzbw zzbwVar3 = this.zzbls;
        zzayh.zzelc.post(new L(this, zzaxgVar, zzawsVar.zza(zzbwVar3.f10251c, zzbwVar3.f10253e, zzaxgVar.zzehy), zzabaVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public void zzil() {
        super.zzil();
        if (this.f10260a) {
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcuk)).booleanValue()) {
                b(this.zzbls.j.zzdrv);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaol
    public final void zzjk() {
        zzii();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zza
    public boolean zza(zzaxf zzaxfVar, zzaxf zzaxfVar2) {
        zzbgg zzbggVar;
        zzbx zzbxVar;
        if (this.zzbls.d() && (zzbxVar = this.zzbls.f10254f) != null) {
            zzbxVar.a().zzef(zzaxfVar2.zzdyi);
        }
        try {
            if (zzaxfVar2.zzdrv != null && !zzaxfVar2.zzdyd && zzaxfVar2.zzehx && !zzaxfVar2.zzdwg.extras.containsKey("sdk_less_server_data")) {
                try {
                    zzaxfVar2.zzdrv.zzadz();
                } catch (Throwable unused) {
                    zzaxz.v("Could not render test Ad label.");
                }
            }
        } catch (RuntimeException unused2) {
            zzaxz.v("Could not render test AdLabel.");
        }
        if (zzaxfVar2 != null && (zzbggVar = zzaxfVar2.zzdrv) != null) {
            zzbggVar.zzay(zzaxfVar2.zzdzf);
        }
        return super.zza(zzaxfVar, zzaxfVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(zzbgg zzbggVar) {
        zzbggVar.zza("/trackActiveViewUnit", new J(this));
    }

    @Override // com.google.android.gms.ads.internal.zzaf
    public final void a(View view) {
        zzbw zzbwVar = this.zzbls;
        zzbwVar.K = view;
        zzb(new zzaxf(zzbwVar.k, null, null, null, null, null, null, null));
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final void zza(zzabg zzabgVar) {
        Preconditions.a("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzbls.D = zzabgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaol
    public final void zza(int i, int i2, int i3, int i4) {
        zzik();
    }
}
