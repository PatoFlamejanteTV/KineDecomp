package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.internal.zzen;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@zzgr
/* loaded from: classes.dex */
public final class zzet extends zzen.zza {
    private final MediationAdapter zzzJ;
    private zzeu zzzK;

    public zzet(MediationAdapter mediationAdapter) {
        this.zzzJ = mediationAdapter;
    }

    private Bundle zza(String str, int i, String str2) throws RemoteException {
        com.google.android.gms.ads.internal.util.client.zzb.e("Server parameters: " + str);
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle2.putString(next, jSONObject.getString(next));
                }
                bundle = bundle2;
            }
            if (this.zzzJ instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                bundle.putInt("tagForChildDirectedTreatment", i);
            }
            return bundle;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not get Server Parameters Bundle.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzen
    public void destroy() throws RemoteException {
        try {
            this.zzzJ.a();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not destroy adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzen
    public com.google.android.gms.dynamic.zzd getView() throws RemoteException {
        if (!(this.zzzJ instanceof MediationBannerAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.e("MediationAdapter is not a MediationBannerAdapter: " + this.zzzJ.getClass().getCanonicalName());
            throw new RemoteException();
        }
        try {
            return com.google.android.gms.dynamic.zze.a(((MediationBannerAdapter) this.zzzJ).d());
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not get banner view from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzen
    public boolean isInitialized() throws RemoteException {
        if (!(this.zzzJ instanceof MediationRewardedVideoAdAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.e("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzzJ.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.a("Check if adapter is initialized.");
        try {
            return ((MediationRewardedVideoAdAdapter) this.zzzJ).e();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not check if adapter is initialized.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzen
    public void pause() throws RemoteException {
        try {
            this.zzzJ.b();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not pause adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzen
    public void resume() throws RemoteException {
        try {
            this.zzzJ.c();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not resume adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzen
    public void showInterstitial() throws RemoteException {
        if (!(this.zzzJ instanceof MediationInterstitialAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.e("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzzJ.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.a("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzzJ).e();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not show interstitial from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzen
    public void showVideo() throws RemoteException {
        if (!(this.zzzJ instanceof MediationRewardedVideoAdAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.e("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzzJ.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.a("Show rewarded video ad from adapter.");
        try {
            ((MediationRewardedVideoAdAdapter) this.zzzJ).d();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not show rewarded video ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzen
    public void zza(AdRequestParcel adRequestParcel, String str) throws RemoteException {
        if (!(this.zzzJ instanceof MediationRewardedVideoAdAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.e("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzzJ.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.a("Requesting rewarded video ad from adapter.");
        try {
            MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzzJ;
            mediationRewardedVideoAdAdapter.a(new zzes(adRequestParcel.b == -1 ? null : new Date(adRequestParcel.b), adRequestParcel.d, adRequestParcel.e != null ? new HashSet(adRequestParcel.e) : null, adRequestParcel.k, adRequestParcel.f, adRequestParcel.g), zza(str, adRequestParcel.g, null), adRequestParcel.m != null ? adRequestParcel.m.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not load rewarded video ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzen
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, com.google.android.gms.ads.internal.reward.mediation.client.zza zzaVar, String str2) throws RemoteException {
        if (!(this.zzzJ instanceof MediationRewardedVideoAdAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.e("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzzJ.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.a("Initialize rewarded video adapter.");
        try {
            MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzzJ;
            mediationRewardedVideoAdAdapter.a((Context) com.google.android.gms.dynamic.zze.a(zzdVar), new zzes(adRequestParcel.b == -1 ? null : new Date(adRequestParcel.b), adRequestParcel.d, adRequestParcel.e != null ? new HashSet(adRequestParcel.e) : null, adRequestParcel.k, adRequestParcel.f, adRequestParcel.g), str, new com.google.android.gms.ads.internal.reward.mediation.client.zzb(zzaVar), zza(str2, adRequestParcel.g, null), adRequestParcel.m != null ? adRequestParcel.m.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not initialize rewarded video adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzen
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, zzeo zzeoVar) throws RemoteException {
        zza(zzdVar, adRequestParcel, str, (String) null, zzeoVar);
    }

    @Override // com.google.android.gms.internal.zzen
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, String str2, zzeo zzeoVar) throws RemoteException {
        if (!(this.zzzJ instanceof MediationInterstitialAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.e("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzzJ.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.a("Requesting interstitial ad from adapter.");
        try {
            MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.zzzJ;
            mediationInterstitialAdapter.a((Context) com.google.android.gms.dynamic.zze.a(zzdVar), new zzeu(zzeoVar), zza(str, adRequestParcel.g, str2), new zzes(adRequestParcel.b == -1 ? null : new Date(adRequestParcel.b), adRequestParcel.d, adRequestParcel.e != null ? new HashSet(adRequestParcel.e) : null, adRequestParcel.k, adRequestParcel.f, adRequestParcel.g), adRequestParcel.m != null ? adRequestParcel.m.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not request interstitial ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzen
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, String str2, zzeo zzeoVar, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) throws RemoteException {
        if (!(this.zzzJ instanceof MediationNativeAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.e("MediationAdapter is not a MediationNativeAdapter: " + this.zzzJ.getClass().getCanonicalName());
            throw new RemoteException();
        }
        try {
            MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) this.zzzJ;
            zzex zzexVar = new zzex(adRequestParcel.b == -1 ? null : new Date(adRequestParcel.b), adRequestParcel.d, adRequestParcel.e != null ? new HashSet(adRequestParcel.e) : null, adRequestParcel.k, adRequestParcel.f, adRequestParcel.g, nativeAdOptionsParcel, list);
            Bundle bundle = adRequestParcel.m != null ? adRequestParcel.m.getBundle(mediationNativeAdapter.getClass().getName()) : null;
            this.zzzK = new zzeu(zzeoVar);
            mediationNativeAdapter.a((Context) com.google.android.gms.dynamic.zze.a(zzdVar), this.zzzK, zza(str, adRequestParcel.g, str2), zzexVar, bundle);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not request interstitial ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzen
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzeo zzeoVar) throws RemoteException {
        zza(zzdVar, adSizeParcel, adRequestParcel, str, null, zzeoVar);
    }

    @Override // com.google.android.gms.internal.zzen
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzeo zzeoVar) throws RemoteException {
        if (!(this.zzzJ instanceof MediationBannerAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.e("MediationAdapter is not a MediationBannerAdapter: " + this.zzzJ.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.a("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzzJ;
            mediationBannerAdapter.a((Context) com.google.android.gms.dynamic.zze.a(zzdVar), new zzeu(zzeoVar), zza(str, adRequestParcel.g, str2), com.google.android.gms.ads.zza.a(adSizeParcel.f, adSizeParcel.c, adSizeParcel.b), new zzes(adRequestParcel.b == -1 ? null : new Date(adRequestParcel.b), adRequestParcel.d, adRequestParcel.e != null ? new HashSet(adRequestParcel.e) : null, adRequestParcel.k, adRequestParcel.f, adRequestParcel.g), adRequestParcel.m != null ? adRequestParcel.m.getBundle(mediationBannerAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not request banner ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzen
    public zzeq zzdV() {
        NativeAdMapper zzeb = this.zzzK.zzeb();
        if (zzeb instanceof NativeAppInstallAdMapper) {
            return new zzev((NativeAppInstallAdMapper) zzeb);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzen
    public zzer zzdW() {
        NativeAdMapper zzeb = this.zzzK.zzeb();
        if (zzeb instanceof NativeContentAdMapper) {
            return new zzew((NativeContentAdMapper) zzeb);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzen
    public Bundle zzdX() {
        if (this.zzzJ instanceof zzjj) {
            return ((zzjj) this.zzzJ).zzdX();
        }
        com.google.android.gms.ads.internal.util.client.zzb.e("MediationAdapter is not a v2 MediationBannerAdapter: " + this.zzzJ.getClass().getCanonicalName());
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.zzen
    public Bundle zzdY() {
        if (this.zzzJ instanceof zzjk) {
            return ((zzjk) this.zzzJ).zzdY();
        }
        com.google.android.gms.ads.internal.util.client.zzb.e("MediationAdapter is not a v2 MediationInterstitialAdapter: " + this.zzzJ.getClass().getCanonicalName());
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.zzen
    public Bundle zzdZ() {
        return new Bundle();
    }
}
