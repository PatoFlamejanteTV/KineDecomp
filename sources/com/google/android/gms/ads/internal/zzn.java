package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzck;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzeq;
import com.google.android.gms.internal.zzer;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzmi;
import java.util.List;

@zzgr
/* loaded from: classes.dex */
public class zzn extends zzb {
    public zzn(Context context, AdSizeParcel adSizeParcel, String str, zzem zzemVar, VersionInfoParcel versionInfoParcel) {
        super(context, adSizeParcel, str, zzemVar, versionInfoParcel, null);
    }

    private static com.google.android.gms.ads.internal.formats.zzd a(zzeq zzeqVar) throws RemoteException {
        return new com.google.android.gms.ads.internal.formats.zzd(zzeqVar.getHeadline(), zzeqVar.getImages(), zzeqVar.getBody(), zzeqVar.zzdw() != null ? zzeqVar.zzdw() : null, zzeqVar.getCallToAction(), zzeqVar.getStarRating(), zzeqVar.getStore(), zzeqVar.getPrice(), null, zzeqVar.getExtras());
    }

    private static com.google.android.gms.ads.internal.formats.zze a(zzer zzerVar) throws RemoteException {
        return new com.google.android.gms.ads.internal.formats.zze(zzerVar.getHeadline(), zzerVar.getImages(), zzerVar.getBody(), zzerVar.zzdA() != null ? zzerVar.zzdA() : null, zzerVar.getCallToAction(), zzerVar.getAdvertiser(), null, zzerVar.getExtras());
    }

    private void a(com.google.android.gms.ads.internal.formats.zzd zzdVar) {
        zzid.zzIE.post(new k(this, zzdVar));
    }

    private void a(com.google.android.gms.ads.internal.formats.zze zzeVar) {
        zzid.zzIE.post(new l(this, zzeVar));
    }

    private void a(zzhs zzhsVar, String str) {
        zzid.zzIE.post(new m(this, str, zzhsVar));
    }

    public zzcy a(String str) {
        zzx.b("getOnCustomClickListener must be called on the main UI thread.");
        return this.zzot.u.get(str);
    }

    public zzmi<String, zzcz> a() {
        zzx.b("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        return this.zzot.v;
    }

    public void a(NativeAdOptionsParcel nativeAdOptionsParcel) {
        zzx.b("setNativeAdOptions must be called on the main UI thread.");
        this.zzot.w = nativeAdOptionsParcel;
    }

    public void a(zzcw zzcwVar) {
        zzx.b("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        this.zzot.s = zzcwVar;
    }

    public void a(zzcx zzcxVar) {
        zzx.b("setOnContentAdLoadedListener must be called on the main UI thread.");
        this.zzot.t = zzcxVar;
    }

    public void a(zzmi<String, zzcz> zzmiVar) {
        zzx.b("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        this.zzot.v = zzmiVar;
    }

    public void a(List<String> list) {
        zzx.b("setNativeTemplates must be called on the main UI thread.");
        this.zzot.y = list;
    }

    public void b(zzmi<String, zzcy> zzmiVar) {
        zzx.b("setOnCustomClickListener must be called on the main UI thread.");
        this.zzot.u = zzmiVar;
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzs
    public void pause() {
        throw new IllegalStateException("Native Ad DOES NOT support pause().");
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.zzg
    public void recordImpression() {
        zza(this.zzot.j, false);
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzs
    public void resume() {
        throw new IllegalStateException("Native Ad DOES NOT support resume().");
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.client.zzs
    public void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzs
    public void zza(zzck zzckVar) {
        throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzs
    public void zza(zzfs zzfsVar) {
        throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
    }

    @Override // com.google.android.gms.ads.internal.zza
    public void zza(zzhs.zza zzaVar, zzcg zzcgVar) {
        if (zzaVar.zzqn != null) {
            this.zzot.i = zzaVar.zzqn;
        }
        if (zzaVar.errorCode != -2) {
            zzid.zzIE.post(new j(this, zzaVar));
            return;
        }
        this.zzot.C = 0;
        this.zzot.h = zzp.d().zza(this.zzot.c, this, zzaVar, this.zzot.d, null, this.zzox, this, zzcgVar);
        com.google.android.gms.ads.internal.util.client.zzb.a("AdRenderer: " + this.zzot.h.getClass().getName());
    }

    @Override // com.google.android.gms.ads.internal.zzb
    protected boolean zza(AdRequestParcel adRequestParcel, zzhs zzhsVar, boolean z) {
        return this.zzos.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza
    public boolean zza(zzhs zzhsVar, zzhs zzhsVar2) {
        a((List<String>) null);
        if (!this.zzot.e()) {
            throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
        }
        if (zzhsVar2.zzEK) {
            try {
                zzeq zzdV = zzhsVar2.zzzv.zzdV();
                zzer zzdW = zzhsVar2.zzzv.zzdW();
                if (zzdV != null) {
                    com.google.android.gms.ads.internal.formats.zzd a2 = a(zzdV);
                    a2.a(new com.google.android.gms.ads.internal.formats.zzg(this.zzot.c, this, this.zzot.d, zzdV));
                    a(a2);
                } else {
                    if (zzdW == null) {
                        com.google.android.gms.ads.internal.util.client.zzb.e("No matching mapper for retrieved native ad template.");
                        zze(0);
                        return false;
                    }
                    com.google.android.gms.ads.internal.formats.zze a3 = a(zzdW);
                    a3.a(new com.google.android.gms.ads.internal.formats.zzg(this.zzot.c, this, this.zzot.d, zzdW));
                    a(a3);
                }
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.d("Failed to get native ad mapper", e);
            }
        } else {
            zzh.zza zzaVar = zzhsVar2.zzHB;
            if ((zzaVar instanceof com.google.android.gms.ads.internal.formats.zze) && this.zzot.t != null) {
                a((com.google.android.gms.ads.internal.formats.zze) zzhsVar2.zzHB);
            } else if ((zzaVar instanceof com.google.android.gms.ads.internal.formats.zzd) && this.zzot.s != null) {
                a((com.google.android.gms.ads.internal.formats.zzd) zzhsVar2.zzHB);
            } else {
                if (!(zzaVar instanceof com.google.android.gms.ads.internal.formats.zzf) || this.zzot.v == null || this.zzot.v.get(((com.google.android.gms.ads.internal.formats.zzf) zzaVar).getCustomTemplateId()) == null) {
                    com.google.android.gms.ads.internal.util.client.zzb.e("No matching listener for retrieved native ad template.");
                    zze(0);
                    return false;
                }
                a(zzhsVar2, ((com.google.android.gms.ads.internal.formats.zzf) zzaVar).getCustomTemplateId());
            }
        }
        return super.zza(zzhsVar, zzhsVar2);
    }
}
