package com.google.android.gms.ads.internal;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.ThinAdSizeParcel;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.request.zza;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzay;
import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbk;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzce;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzck;
import com.google.android.gms.internal.zzdg;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzfw;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzht;
import com.google.android.gms.internal.zzhw;
import com.google.android.gms.internal.zzhx;
import java.util.HashSet;

@zzgr
/* loaded from: classes.dex */
public abstract class zza extends zzs.zza implements com.google.android.gms.ads.internal.client.zza, com.google.android.gms.ads.internal.overlay.zzn, zza.InterfaceC0027zza, zzdg, zzgg.zza, zzhw {
    protected zzcg zzoo;
    protected zzce zzop;
    protected zzce zzoq;
    boolean zzor = false;
    protected final zzo zzos;
    protected final zzq zzot;
    protected transient AdRequestParcel zzou;
    protected final zzay zzov;
    protected final zzd zzow;

    public zza(zzq zzqVar, zzo zzoVar, zzd zzdVar) {
        this.zzot = zzqVar;
        this.zzos = zzoVar == null ? new zzo(this) : zzoVar;
        this.zzow = zzdVar;
        zzp.e().zzI(this.zzot.c);
        zzp.h().zzb(this.zzot.c, this.zzot.e);
        this.zzov = zzp.h().zzgt();
    }

    private AdRequestParcel zza(AdRequestParcel adRequestParcel) {
        return (!GooglePlayServicesUtil.g(this.zzot.c) || adRequestParcel.k == null) ? adRequestParcel : new com.google.android.gms.ads.internal.client.zzf(adRequestParcel).a(null).a();
    }

    private boolean zzaR() {
        com.google.android.gms.ads.internal.util.client.zzb.c("Ad leaving application.");
        if (this.zzot.n == null) {
            return false;
        }
        try {
            this.zzot.n.b();
            return true;
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call AdListener.onAdLeftApplication().", e);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void destroy() {
        zzx.b("destroy must be called on the main UI thread.");
        this.zzos.a();
        this.zzov.zzf(this.zzot.j);
        this.zzot.j();
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public boolean isLoading() {
        return this.zzor;
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public boolean isReady() {
        zzx.b("isLoaded must be called on the main UI thread.");
        return this.zzot.g == null && this.zzot.h == null && this.zzot.j != null;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public void onAdClicked() {
        if (this.zzot.j == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Ad state was null when trying to ping click URLs.");
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzb.a("Pinging click URLs.");
        this.zzot.l.zzgg();
        if (this.zzot.j.zzyY != null) {
            zzp.e().zza(this.zzot.c, this.zzot.e.b, this.zzot.j.zzyY);
        }
        if (this.zzot.m != null) {
            try {
                this.zzot.m.a();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.d("Could not notify onAdClicked event.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzdg
    public void onAppEvent(String str, String str2) {
        if (this.zzot.o != null) {
            try {
                this.zzot.o.a(str, str2);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.d("Could not call the AppEventListener.", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void pause() {
        zzx.b("pause must be called on the main UI thread.");
    }

    public void recordImpression() {
        zzc(this.zzot.j);
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void resume() {
        zzx.b("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void setManualImpressionsEnabled(boolean z) {
        throw new UnsupportedOperationException("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void stopLoading() {
        zzx.b("stopLoading must be called on the main UI thread.");
        this.zzor = false;
        this.zzot.a(true);
    }

    public Bundle zza(zzbk zzbkVar) {
        String str;
        if (zzbkVar == null) {
            return null;
        }
        if (zzbkVar.zzcx()) {
            zzbkVar.wakeup();
        }
        zzbh zzcv = zzbkVar.zzcv();
        if (zzcv != null) {
            str = zzcv.zzcm();
            com.google.android.gms.ads.internal.util.client.zzb.a("In AdManger: loadAd, " + zzcv.toString());
        } else {
            str = null;
        }
        if (str == null) {
            return null;
        }
        Bundle bundle = new Bundle(1);
        bundle.putString("fingerprint", str);
        bundle.putInt("v", 1);
        return bundle;
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zza(AdSizeParcel adSizeParcel) {
        zzx.b("setAdSize must be called on the main UI thread.");
        this.zzot.i = adSizeParcel;
        if (this.zzot.j != null && this.zzot.j.zzBD != null && this.zzot.C == 0) {
            this.zzot.j.zzBD.zza(adSizeParcel);
        }
        if (this.zzot.f == null) {
            return;
        }
        if (this.zzot.f.getChildCount() > 1) {
            this.zzot.f.removeView(this.zzot.f.getNextView());
        }
        this.zzot.f.setMinimumWidth(adSizeParcel.g);
        this.zzot.f.setMinimumHeight(adSizeParcel.d);
        this.zzot.f.requestLayout();
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zza(com.google.android.gms.ads.internal.client.zzn zznVar) {
        zzx.b("setAdListener must be called on the main UI thread.");
        this.zzot.m = zznVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zza(com.google.android.gms.ads.internal.client.zzo zzoVar) {
        zzx.b("setAdListener must be called on the main UI thread.");
        this.zzot.n = zzoVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zza(zzu zzuVar) {
        zzx.b("setAppEventListener must be called on the main UI thread.");
        this.zzot.o = zzuVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zza(zzv zzvVar) {
        zzx.b("setCorrelationIdProvider must be called on the main UI thread");
        this.zzot.p = zzvVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zza(zzck zzckVar) {
        throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zza(zzfs zzfsVar) {
        throw new IllegalStateException("setInAppPurchaseListener is not supported for current ad type");
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zza(zzfw zzfwVar, String str) {
        throw new IllegalStateException("setPlayStorePurchaseParams is not supported for current ad type");
    }

    @Override // com.google.android.gms.ads.internal.request.zza.InterfaceC0027zza
    public void zza(zzhs.zza zzaVar) {
        if (zzaVar.zzHD.n != -1 && !TextUtils.isEmpty(zzaVar.zzHD.z)) {
            long zzo = zzo(zzaVar.zzHD.z);
            if (zzo != -1) {
                this.zzoo.zza(this.zzoo.zzb(zzo + zzaVar.zzHD.n), "stc");
            }
        }
        this.zzoo.zzT(zzaVar.zzHD.z);
        this.zzoo.zza(this.zzop, "arf");
        this.zzoq = this.zzoo.zzdn();
        this.zzoo.zze("gqi", zzaVar.zzHD.A);
        this.zzot.g = null;
        this.zzot.k = zzaVar;
        zza(zzaVar, this.zzoo);
    }

    protected abstract void zza(zzhs.zza zzaVar, zzcg zzcgVar);

    @Override // com.google.android.gms.internal.zzhw
    public void zza(HashSet<zzht> hashSet) {
        this.zzot.a(hashSet);
    }

    protected abstract boolean zza(AdRequestParcel adRequestParcel, zzcg zzcgVar);

    boolean zza(zzhs zzhsVar) {
        return false;
    }

    protected abstract boolean zza(zzhs zzhsVar, zzhs zzhsVar2);

    void zzaL() {
        this.zzoo = new zzcg(zzby.zzuQ.get().booleanValue(), "load_ad", this.zzot.i.b);
        this.zzop = new zzce(-1L, null, null);
        this.zzoq = new zzce(-1L, null, null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public com.google.android.gms.dynamic.zzd zzaM() {
        zzx.b("getAdFrame must be called on the main UI thread.");
        return com.google.android.gms.dynamic.zze.a(this.zzot.f);
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public AdSizeParcel zzaN() {
        zzx.b("getAdSize must be called on the main UI thread.");
        if (this.zzot.i == null) {
            return null;
        }
        return new ThinAdSizeParcel(this.zzot.i);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public void zzaO() {
        zzaR();
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zzaP() {
        zzx.b("recordManualImpression must be called on the main UI thread.");
        if (this.zzot.j == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzb.a("Pinging manual tracking URLs.");
        if (this.zzot.j.zzEM != null) {
            zzp.e().zza(this.zzot.c, this.zzot.e.b, this.zzot.j.zzEM);
        }
    }

    public boolean zzaQ() {
        com.google.android.gms.ads.internal.util.client.zzb.d("Ad closing.");
        if (this.zzot.n == null) {
            return false;
        }
        try {
            this.zzot.n.a();
            return true;
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call AdListener.onAdClosed().", e);
            return false;
        }
    }

    public boolean zzaS() {
        com.google.android.gms.ads.internal.util.client.zzb.c("Ad opening.");
        if (this.zzot.n == null) {
            return false;
        }
        try {
            this.zzot.n.d();
            return true;
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call AdListener.onAdOpened().", e);
            return false;
        }
    }

    public boolean zzaT() {
        com.google.android.gms.ads.internal.util.client.zzb.c("Ad finished loading.");
        this.zzor = false;
        if (this.zzot.n == null) {
            return false;
        }
        try {
            this.zzot.n.c();
            return true;
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call AdListener.onAdLoaded().", e);
            return false;
        }
    }

    public void zzb(View view) {
        this.zzot.f.addView(view, zzp.g().zzgJ());
    }

    @Override // com.google.android.gms.internal.zzgg.zza
    public void zzb(zzhs zzhsVar) {
        this.zzoo.zza(this.zzoq, "awr");
        this.zzot.h = null;
        if (zzhsVar.errorCode != -2 && zzhsVar.errorCode != 3) {
            zzp.h().zzb(this.zzot.a());
        }
        if (zzhsVar.errorCode == -1) {
            this.zzor = false;
            return;
        }
        if (zza(zzhsVar)) {
            com.google.android.gms.ads.internal.util.client.zzb.a("Ad refresh scheduled.");
        }
        if (zzhsVar.errorCode != -2) {
            zze(zzhsVar.errorCode);
            return;
        }
        if (this.zzot.A == null) {
            this.zzot.A = new zzhx(this.zzot.b);
        }
        this.zzov.zze(this.zzot.j);
        if (zza(this.zzot.j, zzhsVar)) {
            this.zzot.j = zzhsVar;
            this.zzot.i();
            this.zzoo.zze("is_mraid", this.zzot.j.zzbY() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            this.zzoo.zze("is_mediation", this.zzot.j.zzEK ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            if (this.zzot.j.zzBD != null && this.zzot.j.zzBD.zzhe() != null) {
                this.zzoo.zze("is_video", this.zzot.j.zzBD.zzhe().zzhr() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            this.zzoo.zza(this.zzop, "ttc");
            if (zzp.h().zzgo() != null) {
                zzp.h().zzgo().zza(this.zzoo);
            }
            if (this.zzot.e()) {
                zzaT();
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public boolean zzb(AdRequestParcel adRequestParcel) {
        zzx.b("loadAd must be called on the main UI thread.");
        AdRequestParcel zza = zza(adRequestParcel);
        if (this.zzor) {
            if (this.zzou != null) {
                com.google.android.gms.ads.internal.util.client.zzb.e("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
            }
            this.zzou = zza;
            return false;
        }
        com.google.android.gms.ads.internal.util.client.zzb.c("Starting ad request.");
        this.zzor = true;
        zzaL();
        this.zzop = this.zzoo.zzdn();
        if (!zza.f) {
            com.google.android.gms.ads.internal.util.client.zzb.c("Use AdRequest.Builder.addTestDevice(\"" + com.google.android.gms.ads.internal.client.zzl.a().a(this.zzot.c) + "\") to get test ads on this device.");
        }
        return zza(zza, this.zzoo);
    }

    public void zzc(zzhs zzhsVar) {
        if (zzhsVar == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Ad state was null when trying to ping impression URLs.");
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzb.a("Pinging Impression URLs.");
        this.zzot.l.zzgf();
        if (zzhsVar.zzyZ != null) {
            zzp.e().zza(this.zzot.c, this.zzot.e.b, zzhsVar.zzyZ);
        }
    }

    public boolean zzc(AdRequestParcel adRequestParcel) {
        Object parent = this.zzot.f.getParent();
        return (parent instanceof View) && ((View) parent).isShown() && zzp.e().zzgB();
    }

    public void zzd(AdRequestParcel adRequestParcel) {
        if (zzc(adRequestParcel)) {
            zzb(adRequestParcel);
        } else {
            com.google.android.gms.ads.internal.util.client.zzb.c("Ad is not visible. Not refreshing ad.");
            this.zzos.a(adRequestParcel);
        }
    }

    public boolean zze(int i) {
        com.google.android.gms.ads.internal.util.client.zzb.e("Failed to load ad: " + i);
        this.zzor = false;
        if (this.zzot.n == null) {
            return false;
        }
        try {
            this.zzot.n.a(i);
            return true;
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call AdListener.onAdFailedToLoad().", e);
            return false;
        }
    }

    long zzo(String str) {
        int indexOf = str.indexOf("ufe");
        int indexOf2 = str.indexOf(44, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        try {
            return Long.parseLong(str.substring(indexOf + 4, indexOf2));
        } catch (IndexOutOfBoundsException e) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Invalid index for Url fetch time in CSI latency info.");
            return -1L;
        } catch (NumberFormatException e2) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Cannot find valid format of Url fetch time in CSI latency info.");
            return -1L;
        }
    }
}
