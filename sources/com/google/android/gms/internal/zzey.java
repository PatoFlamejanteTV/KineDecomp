package com.google.android.gms.internal;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.internal.zzen;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@zzgr
/* loaded from: classes.dex */
public final class zzey<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends zzen.zza {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zzzP;
    private final NETWORK_EXTRAS zzzQ;

    public zzey(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.zzzP = mediationAdapter;
        this.zzzQ = network_extras;
    }

    private SERVER_PARAMETERS zzb(String str, int i, String str2) throws RemoteException {
        HashMap hashMap;
        try {
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            } else {
                hashMap = new HashMap(0);
            }
            Class<SERVER_PARAMETERS> c = this.zzzP.c();
            if (c == null) {
                return null;
            }
            SERVER_PARAMETERS newInstance = c.newInstance();
            newInstance.a(hashMap);
            return newInstance;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not get MediationServerParameters.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzen
    public void destroy() throws RemoteException {
        try {
            this.zzzP.a();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not destroy adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzen
    public com.google.android.gms.dynamic.zzd getView() throws RemoteException {
        if (!(this.zzzP instanceof MediationBannerAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.e("MediationAdapter is not a MediationBannerAdapter: " + this.zzzP.getClass().getCanonicalName());
            throw new RemoteException();
        }
        try {
            return com.google.android.gms.dynamic.zze.a(((MediationBannerAdapter) this.zzzP).d());
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not get banner view from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzen
    public boolean isInitialized() {
        return true;
    }

    @Override // com.google.android.gms.internal.zzen
    public void pause() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.zzen
    public void resume() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.zzen
    public void showInterstitial() throws RemoteException {
        if (!(this.zzzP instanceof MediationInterstitialAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.e("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzzP.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.a("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzzP).e();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not show interstitial from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzen
    public void showVideo() {
    }

    @Override // com.google.android.gms.internal.zzen
    public void zza(AdRequestParcel adRequestParcel, String str) {
    }

    @Override // com.google.android.gms.internal.zzen
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, com.google.android.gms.ads.internal.reward.mediation.client.zza zzaVar, String str2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzen
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, zzeo zzeoVar) throws RemoteException {
        zza(zzdVar, adRequestParcel, str, (String) null, zzeoVar);
    }

    @Override // com.google.android.gms.internal.zzen
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, String str2, zzeo zzeoVar) throws RemoteException {
        if (!(this.zzzP instanceof MediationInterstitialAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.e("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzzP.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.a("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzzP).a(new zzez(zzeoVar), (Activity) com.google.android.gms.dynamic.zze.a(zzdVar), zzb(str, adRequestParcel.g, str2), zzfa.zzh(adRequestParcel), this.zzzQ);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not request interstitial ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzen
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, String str2, zzeo zzeoVar, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) {
    }

    @Override // com.google.android.gms.internal.zzen
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzeo zzeoVar) throws RemoteException {
        zza(zzdVar, adSizeParcel, adRequestParcel, str, null, zzeoVar);
    }

    @Override // com.google.android.gms.internal.zzen
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzeo zzeoVar) throws RemoteException {
        if (!(this.zzzP instanceof MediationBannerAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.e("MediationAdapter is not a MediationBannerAdapter: " + this.zzzP.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.a("Requesting banner ad from adapter.");
        try {
            ((MediationBannerAdapter) this.zzzP).a(new zzez(zzeoVar), (Activity) com.google.android.gms.dynamic.zze.a(zzdVar), zzb(str, adRequestParcel.g, str2), zzfa.zzb(adSizeParcel), zzfa.zzh(adRequestParcel), this.zzzQ);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not request banner ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzen
    public zzeq zzdV() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzen
    public zzer zzdW() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzen
    public Bundle zzdX() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.zzen
    public Bundle zzdY() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.zzen
    public Bundle zzdZ() {
        return new Bundle();
    }
}
