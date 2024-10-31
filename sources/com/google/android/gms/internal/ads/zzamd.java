package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzamd extends zzalk {
    private final MediationAdapter zzdnx;
    private zzame zzdny;

    public zzamd(MediationAdapter mediationAdapter) {
        this.zzdnx = mediationAdapter;
    }

    private static boolean zzm(zzwb zzwbVar) {
        if (zzwbVar.zzcje) {
            return true;
        }
        zzwu.zzpv();
        return zzbat.zzaaq();
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void destroy() throws RemoteException {
        try {
            this.zzdnx.onDestroy();
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final Bundle getInterstitialAdapterInfo() {
        MediationAdapter mediationAdapter = this.zzdnx;
        if (!(mediationAdapter instanceof zzbiy)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzeo(valueOf.length() != 0 ? "Not a v2 MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a v2 MediationInterstitialAdapter: "));
            return new Bundle();
        }
        return ((zzbiy) mediationAdapter).getInterstitialAdapterInfo();
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final zzyp getVideoController() {
        MediationAdapter mediationAdapter = this.zzdnx;
        if (!(mediationAdapter instanceof com.google.android.gms.ads.mediation.zzb)) {
            return null;
        }
        try {
            return ((com.google.android.gms.ads.mediation.zzb) mediationAdapter).getVideoController();
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final boolean isInitialized() throws RemoteException {
        MediationAdapter mediationAdapter = this.zzdnx;
        if (!(mediationAdapter instanceof MediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzeo(valueOf.length() != 0 ? "Not a MediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("Not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzbbd.zzdn("Check if adapter is initialized.");
        try {
            return ((MediationRewardedVideoAdAdapter) this.zzdnx).isInitialized();
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void pause() throws RemoteException {
        try {
            this.zzdnx.onPause();
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void resume() throws RemoteException {
        try {
            this.zzdnx.onResume();
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void setImmersiveMode(boolean z) throws RemoteException {
        MediationAdapter mediationAdapter = this.zzdnx;
        if (!(mediationAdapter instanceof OnImmersiveModeUpdatedListener)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzen(valueOf.length() != 0 ? "Not an OnImmersiveModeUpdatedListener: ".concat(valueOf) : new String("Not an OnImmersiveModeUpdatedListener: "));
        } else {
            try {
                ((OnImmersiveModeUpdatedListener) mediationAdapter).onImmersiveModeUpdated(z);
            } catch (Throwable th) {
                zzbbd.zzb("", th);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void showInterstitial() throws RemoteException {
        MediationAdapter mediationAdapter = this.zzdnx;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzeo(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzbbd.zzdn("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzdnx).showInterstitial();
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void showVideo() throws RemoteException {
        MediationAdapter mediationAdapter = this.zzdnx;
        if (!(mediationAdapter instanceof MediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzeo(valueOf.length() != 0 ? "Not a MediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("Not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzbbd.zzdn("Show rewarded video ad from adapter.");
        try {
            ((MediationRewardedVideoAdAdapter) this.zzdnx).showVideo();
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zza(IObjectWrapper iObjectWrapper, zzwf zzwfVar, zzwb zzwbVar, String str, zzalm zzalmVar) throws RemoteException {
        zza(iObjectWrapper, zzwfVar, zzwbVar, str, null, zzalmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zzc(zzwb zzwbVar, String str) throws RemoteException {
        zza(zzwbVar, str, (String) null);
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Context context = (Context) ObjectWrapper.a(iObjectWrapper);
        MediationAdapter mediationAdapter = this.zzdnx;
        if (mediationAdapter instanceof OnContextChangedListener) {
            ((OnContextChangedListener) mediationAdapter).a(context);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final IObjectWrapper zzut() throws RemoteException {
        MediationAdapter mediationAdapter = this.zzdnx;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzeo(valueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(valueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        try {
            return ObjectWrapper.a(((MediationBannerAdapter) mediationAdapter).getBannerView());
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final zzals zzuu() {
        NativeAdMapper zzvd = this.zzdny.zzvd();
        if (zzvd instanceof NativeAppInstallAdMapper) {
            return new zzamf((NativeAppInstallAdMapper) zzvd);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final zzalv zzuv() {
        NativeAdMapper zzvd = this.zzdny.zzvd();
        if (zzvd instanceof NativeContentAdMapper) {
            return new zzamg((NativeContentAdMapper) zzvd);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final Bundle zzuw() {
        MediationAdapter mediationAdapter = this.zzdnx;
        if (!(mediationAdapter instanceof zzbix)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzeo(valueOf.length() != 0 ? "Not a v2 MediationBannerAdapter: ".concat(valueOf) : new String("Not a v2 MediationBannerAdapter: "));
            return new Bundle();
        }
        return ((zzbix) mediationAdapter).zzuw();
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final Bundle zzux() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final boolean zzuy() {
        return this.zzdnx instanceof InitializableMediationRewardedVideoAdAdapter;
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final zzadx zzuz() {
        NativeCustomTemplateAd zzvf = this.zzdny.zzvf();
        if (zzvf instanceof zzaea) {
            return ((zzaea) zzvf).zzsx();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final zzaly zzva() {
        UnifiedNativeAdMapper zzve = this.zzdny.zzve();
        if (zzve != null) {
            return new zzamx(zzve);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zza(IObjectWrapper iObjectWrapper, zzwf zzwfVar, zzwb zzwbVar, String str, String str2, zzalm zzalmVar) throws RemoteException {
        MediationAdapter mediationAdapter = this.zzdnx;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzeo(valueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(valueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        zzbbd.zzdn("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzdnx;
            mediationBannerAdapter.requestBannerAd((Context) ObjectWrapper.a(iObjectWrapper), new zzame(zzalmVar), zza(str, zzwbVar, str2), com.google.android.gms.ads.zzc.a(zzwfVar.width, zzwfVar.height, zzwfVar.zzckk), new zzamc(zzwbVar.zzcjb == -1 ? null : new Date(zzwbVar.zzcjb), zzwbVar.zzcjc, zzwbVar.zzcjd != null ? new HashSet(zzwbVar.zzcjd) : null, zzwbVar.zzcjj, zzm(zzwbVar), zzwbVar.zzcjf, zzwbVar.zzcjq), zzwbVar.zzcjl != null ? zzwbVar.zzcjl.getBundle(mediationBannerAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zza(IObjectWrapper iObjectWrapper, zzwb zzwbVar, String str, zzalm zzalmVar) throws RemoteException {
        zza(iObjectWrapper, zzwbVar, str, (String) null, zzalmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zza(IObjectWrapper iObjectWrapper, zzwb zzwbVar, String str, String str2, zzalm zzalmVar) throws RemoteException {
        MediationAdapter mediationAdapter = this.zzdnx;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzeo(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzbbd.zzdn("Requesting interstitial ad from adapter.");
        try {
            MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.zzdnx;
            mediationInterstitialAdapter.requestInterstitialAd((Context) ObjectWrapper.a(iObjectWrapper), new zzame(zzalmVar), zza(str, zzwbVar, str2), new zzamc(zzwbVar.zzcjb == -1 ? null : new Date(zzwbVar.zzcjb), zzwbVar.zzcjc, zzwbVar.zzcjd != null ? new HashSet(zzwbVar.zzcjd) : null, zzwbVar.zzcjj, zzm(zzwbVar), zzwbVar.zzcjf, zzwbVar.zzcjq), zzwbVar.zzcjl != null ? zzwbVar.zzcjl.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zza(IObjectWrapper iObjectWrapper, zzwb zzwbVar, String str, String str2, zzalm zzalmVar, zzacp zzacpVar, List<String> list) throws RemoteException {
        MediationAdapter mediationAdapter = this.zzdnx;
        if (!(mediationAdapter instanceof MediationNativeAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzeo(valueOf.length() != 0 ? "Not a MediationNativeAdapter: ".concat(valueOf) : new String("Not a MediationNativeAdapter: "));
            throw new RemoteException();
        }
        try {
            MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) mediationAdapter;
            zzamh zzamhVar = new zzamh(zzwbVar.zzcjb == -1 ? null : new Date(zzwbVar.zzcjb), zzwbVar.zzcjc, zzwbVar.zzcjd != null ? new HashSet(zzwbVar.zzcjd) : null, zzwbVar.zzcjj, zzm(zzwbVar), zzwbVar.zzcjf, zzacpVar, list, zzwbVar.zzcjq);
            Bundle bundle = zzwbVar.zzcjl != null ? zzwbVar.zzcjl.getBundle(mediationNativeAdapter.getClass().getName()) : null;
            this.zzdny = new zzame(zzalmVar);
            mediationNativeAdapter.requestNativeAd((Context) ObjectWrapper.a(iObjectWrapper), this.zzdny, zza(str, zzwbVar, str2), zzamhVar, bundle);
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zza(IObjectWrapper iObjectWrapper, zzwb zzwbVar, String str, zzavz zzavzVar, String str2) throws RemoteException {
        zzamc zzamcVar;
        Bundle bundle;
        MediationAdapter mediationAdapter = this.zzdnx;
        if (!(mediationAdapter instanceof MediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzeo(valueOf.length() != 0 ? "Not a MediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("Not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzbbd.zzdn("Initialize rewarded video adapter.");
        try {
            MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzdnx;
            Bundle zza = zza(str2, zzwbVar, (String) null);
            if (zzwbVar != null) {
                zzamc zzamcVar2 = new zzamc(zzwbVar.zzcjb == -1 ? null : new Date(zzwbVar.zzcjb), zzwbVar.zzcjc, zzwbVar.zzcjd != null ? new HashSet(zzwbVar.zzcjd) : null, zzwbVar.zzcjj, zzm(zzwbVar), zzwbVar.zzcjf, zzwbVar.zzcjq);
                bundle = zzwbVar.zzcjl != null ? zzwbVar.zzcjl.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null;
                zzamcVar = zzamcVar2;
            } else {
                zzamcVar = null;
                bundle = null;
            }
            mediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.a(iObjectWrapper), zzamcVar, str, new zzawc(zzavzVar), zza, bundle);
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zza(IObjectWrapper iObjectWrapper, zzavz zzavzVar, List<String> list) throws RemoteException {
        MediationAdapter mediationAdapter = this.zzdnx;
        if (!(mediationAdapter instanceof InitializableMediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzeo(valueOf.length() != 0 ? "Not an InitializableMediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("Not an InitializableMediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzbbd.zzdn("Initialize rewarded video adapter.");
        try {
            InitializableMediationRewardedVideoAdAdapter initializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter) this.zzdnx;
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(zza(it.next(), (zzwb) null, (String) null));
            }
            initializableMediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.a(iObjectWrapper), new zzawc(zzavzVar), arrayList);
        } catch (Throwable th) {
            zzbbd.zzc("Could not initialize rewarded video adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zza(zzwb zzwbVar, String str, String str2) throws RemoteException {
        MediationAdapter mediationAdapter = this.zzdnx;
        if (!(mediationAdapter instanceof MediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzeo(valueOf.length() != 0 ? "Not a MediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("Not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzbbd.zzdn("Requesting rewarded video ad from adapter.");
        try {
            MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzdnx;
            mediationRewardedVideoAdAdapter.loadAd(new zzamc(zzwbVar.zzcjb == -1 ? null : new Date(zzwbVar.zzcjb), zzwbVar.zzcjc, zzwbVar.zzcjd != null ? new HashSet(zzwbVar.zzcjd) : null, zzwbVar.zzcjj, zzm(zzwbVar), zzwbVar.zzcjf, zzwbVar.zzcjq), zza(str, zzwbVar, str2), zzwbVar.zzcjl != null ? zzwbVar.zzcjl.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    private final Bundle zza(String str, zzwb zzwbVar, String str2) throws RemoteException {
        Bundle bundle;
        String valueOf = String.valueOf(str);
        zzbbd.zzeo(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle2 = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                bundle = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle.putString(next, jSONObject.getString(next));
                }
            } else {
                bundle = bundle2;
            }
            if (this.zzdnx instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzwbVar != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzwbVar.zzcjf);
                }
            }
            return bundle;
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }
}
