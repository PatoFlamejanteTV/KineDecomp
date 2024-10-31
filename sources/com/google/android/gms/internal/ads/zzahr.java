package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzal;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzahr extends zzxm {
    private final String zzboa;
    private boolean zzboq;
    private final zzagi zzdhg;
    private zzal zzdhl;
    private final C0965ka zzdhx;

    @VisibleForTesting
    private zzahr(String str, zzagi zzagiVar) {
        this.zzboa = str;
        this.zzdhg = zzagiVar;
        this.zzdhx = new C0965ka();
        com.google.android.gms.ads.internal.zzbv.s().zza(zzagiVar);
    }

    @VisibleForTesting
    private final void abort() {
        if (this.zzdhl != null) {
            return;
        }
        this.zzdhl = this.zzdhg.zzbx(this.zzboa);
        this.zzdhx.a(this.zzdhl);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void destroy() throws RemoteException {
        zzal zzalVar = this.zzdhl;
        if (zzalVar != null) {
            zzalVar.destroy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final Bundle getAdMetadata() throws RemoteException {
        zzal zzalVar = this.zzdhl;
        if (zzalVar != null) {
            return zzalVar.getAdMetadata();
        }
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final String getAdUnitId() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final String getMediationAdapterClassName() throws RemoteException {
        zzal zzalVar = this.zzdhl;
        if (zzalVar != null) {
            return zzalVar.getMediationAdapterClassName();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzyp getVideoController() {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final boolean isLoading() throws RemoteException {
        zzal zzalVar = this.zzdhl;
        return zzalVar != null && zzalVar.isLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final boolean isReady() throws RemoteException {
        zzal zzalVar = this.zzdhl;
        return zzalVar != null && zzalVar.isReady();
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void pause() throws RemoteException {
        zzal zzalVar = this.zzdhl;
        if (zzalVar != null) {
            zzalVar.pause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void resume() throws RemoteException {
        zzal zzalVar = this.zzdhl;
        if (zzalVar != null) {
            zzalVar.resume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void setImmersiveMode(boolean z) {
        this.zzboq = z;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
        abort();
        zzal zzalVar = this.zzdhl;
        if (zzalVar != null) {
            zzalVar.setManualImpressionsEnabled(z);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void setUserId(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void showInterstitial() throws RemoteException {
        zzal zzalVar = this.zzdhl;
        if (zzalVar != null) {
            zzalVar.setImmersiveMode(this.zzboq);
            this.zzdhl.showInterstitial();
        } else {
            zzbbd.zzeo("Interstitial ad must be loaded before showInterstitial().");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void stopLoading() throws RemoteException {
        zzal zzalVar = this.zzdhl;
        if (zzalVar != null) {
            zzalVar.stopLoading();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxa zzxaVar) throws RemoteException {
        C0965ka c0965ka = this.zzdhx;
        c0965ka.f12247a = zzxaVar;
        zzal zzalVar = this.zzdhl;
        if (zzalVar != null) {
            c0965ka.a(zzalVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zzap(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final boolean zzb(zzwb zzwbVar) throws RemoteException {
        if (!zzahm.zzh(zzwbVar).contains("gw")) {
            abort();
        }
        if (zzahm.zzh(zzwbVar).contains("_skipMediation")) {
            abort();
        }
        if (zzwbVar.zzcji != null) {
            abort();
        }
        zzal zzalVar = this.zzdhl;
        if (zzalVar != null) {
            return zzalVar.zzb(zzwbVar);
        }
        zzahm s = com.google.android.gms.ads.internal.zzbv.s();
        if (zzahm.zzh(zzwbVar).contains("_ad")) {
            s.zzb(zzwbVar, this.zzboa);
        }
        C1035pa zza = s.zza(zzwbVar, this.zzboa);
        if (zza != null) {
            if (!zza.f12417e) {
                zza.a();
                zzahq.zzto().zzts();
            } else {
                zzahq.zzto().zztr();
            }
            this.zzdhl = zza.f12413a;
            zza.f12415c.a(this.zzdhx);
            this.zzdhx.a(this.zzdhl);
            return zza.f12418f;
        }
        abort();
        zzahq.zzto().zzts();
        return this.zzdhl.zzb(zzwbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final IObjectWrapper zzie() throws RemoteException {
        zzal zzalVar = this.zzdhl;
        if (zzalVar != null) {
            return zzalVar.zzie();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzwf zzif() throws RemoteException {
        zzal zzalVar = this.zzdhl;
        if (zzalVar != null) {
            return zzalVar.zzif();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zzih() throws RemoteException {
        zzal zzalVar = this.zzdhl;
        if (zzalVar != null) {
            zzalVar.zzih();
        } else {
            zzbbd.zzeo("Interstitial ad must be loaded before pingManualTrackingUrl().");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzxt zzir() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzxa zzis() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final String zzje() throws RemoteException {
        zzal zzalVar = this.zzdhl;
        if (zzalVar != null) {
            return zzalVar.zzje();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzavb zzavbVar) {
        C0965ka c0965ka = this.zzdhx;
        c0965ka.f12252f = zzavbVar;
        zzal zzalVar = this.zzdhl;
        if (zzalVar != null) {
            c0965ka.a(zzalVar);
        }
    }

    public zzahr(Context context, String str, zzalg zzalgVar, zzbbi zzbbiVar, com.google.android.gms.ads.internal.zzv zzvVar) {
        this(str, new zzagi(context, zzalgVar, zzbbiVar, zzvVar));
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxt zzxtVar) throws RemoteException {
        C0965ka c0965ka = this.zzdhx;
        c0965ka.f12249c = zzxtVar;
        zzal zzalVar = this.zzdhl;
        if (zzalVar != null) {
            c0965ka.a(zzalVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxq zzxqVar) throws RemoteException {
        C0965ka c0965ka = this.zzdhx;
        c0965ka.f12248b = zzxqVar;
        zzal zzalVar = this.zzdhl;
        if (zzalVar != null) {
            c0965ka.a(zzalVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzwf zzwfVar) throws RemoteException {
        zzal zzalVar = this.zzdhl;
        if (zzalVar != null) {
            zzalVar.zza(zzwfVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzaow zzaowVar) throws RemoteException {
        zzbbd.zzeo("setInAppPurchaseListener is deprecated and should not be called.");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzapc zzapcVar, String str) throws RemoteException {
        zzbbd.zzeo("setPlayStorePurchaseParams is deprecated and should not be called.");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzabg zzabgVar) throws RemoteException {
        C0965ka c0965ka = this.zzdhx;
        c0965ka.f12250d = zzabgVar;
        zzal zzalVar = this.zzdhl;
        if (zzalVar != null) {
            c0965ka.a(zzalVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzwx zzwxVar) throws RemoteException {
        C0965ka c0965ka = this.zzdhx;
        c0965ka.f12251e = zzwxVar;
        zzal zzalVar = this.zzdhl;
        if (zzalVar != null) {
            c0965ka.a(zzalVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxz zzxzVar) throws RemoteException {
        abort();
        zzal zzalVar = this.zzdhl;
        if (zzalVar != null) {
            zzalVar.zza(zzxzVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzzw zzzwVar) {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzyv zzyvVar) {
        throw new IllegalStateException("Unused method");
    }
}
