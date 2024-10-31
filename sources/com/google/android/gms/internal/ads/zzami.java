package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzami<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends zzalk {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zzdog;
    private final NETWORK_EXTRAS zzdoh;

    public zzami(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.zzdog = mediationAdapter;
        this.zzdoh = network_extras;
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
            this.zzdog.destroy();
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final Bundle getInterstitialAdapterInfo() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final zzyp getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void resume() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void setImmersiveMode(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void showInterstitial() throws RemoteException {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzdog;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzeo(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzbbd.zzdn("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzdog).showInterstitial();
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void showVideo() {
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zza(IObjectWrapper iObjectWrapper, zzavz zzavzVar, List<String> list) {
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zza(IObjectWrapper iObjectWrapper, zzwb zzwbVar, String str, zzavz zzavzVar, String str2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zza(IObjectWrapper iObjectWrapper, zzwb zzwbVar, String str, String str2, zzalm zzalmVar, zzacp zzacpVar, List<String> list) {
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zza(IObjectWrapper iObjectWrapper, zzwf zzwfVar, zzwb zzwbVar, String str, zzalm zzalmVar) throws RemoteException {
        zza(iObjectWrapper, zzwfVar, zzwbVar, str, null, zzalmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zza(zzwb zzwbVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zzc(zzwb zzwbVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final IObjectWrapper zzut() throws RemoteException {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzdog;
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
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final zzalv zzuv() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final Bundle zzuw() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final Bundle zzux() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final boolean zzuy() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final zzadx zzuz() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final zzaly zzva() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zza(IObjectWrapper iObjectWrapper, zzwf zzwfVar, zzwb zzwbVar, String str, String str2, zzalm zzalmVar) throws RemoteException {
        AdSize adSize;
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzdog;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzeo(valueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(valueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        zzbbd.zzdn("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzdog;
            zzamj zzamjVar = new zzamj(zzalmVar);
            Activity activity = (Activity) ObjectWrapper.a(iObjectWrapper);
            SERVER_PARAMETERS zza = zza(str, zzwbVar.zzcjf, str2);
            int i = 0;
            AdSize[] adSizeArr = {AdSize.f9893a, AdSize.f9894b, AdSize.f9895c, AdSize.f9896d, AdSize.f9897e, AdSize.f9898f};
            while (true) {
                if (i < 6) {
                    if (adSizeArr[i].b() == zzwfVar.width && adSizeArr[i].a() == zzwfVar.height) {
                        adSize = adSizeArr[i];
                        break;
                    }
                    i++;
                } else {
                    adSize = new AdSize(com.google.android.gms.ads.zzc.a(zzwfVar.width, zzwfVar.height, zzwfVar.zzckk));
                    break;
                }
            }
            mediationBannerAdapter.requestBannerAd(zzamjVar, activity, zza, adSize, zzamv.zza(zzwbVar, zzm(zzwbVar)), this.zzdoh);
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
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzdog;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzeo(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzbbd.zzdn("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzdog).requestInterstitialAd(new zzamj(zzalmVar), (Activity) ObjectWrapper.a(iObjectWrapper), zza(str, zzwbVar.zzcjf, str2), zzamv.zza(zzwbVar, zzm(zzwbVar)), this.zzdoh);
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    private final SERVER_PARAMETERS zza(String str, int i, String str2) throws RemoteException {
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
            Class<SERVER_PARAMETERS> serverParametersType = this.zzdog.getServerParametersType();
            if (serverParametersType == null) {
                return null;
            }
            SERVER_PARAMETERS newInstance = serverParametersType.newInstance();
            newInstance.a(hashMap);
            return newInstance;
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }
}
