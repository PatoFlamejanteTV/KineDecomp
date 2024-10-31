package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

@zzgr
/* loaded from: classes.dex */
public final class zzez<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final zzeo zzzL;

    public zzez(zzeo zzeoVar) {
        this.zzzL = zzeoVar;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onClick.");
        if (!com.google.android.gms.ads.internal.client.zzl.a().b()) {
            com.google.android.gms.ads.internal.util.client.zzb.e("onClick must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.f654a.post(new bt(this));
        } else {
            try {
                this.zzzL.onAdClicked();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdClicked.", e);
            }
        }
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onDismissScreen.");
        if (!com.google.android.gms.ads.internal.client.zzl.a().b()) {
            com.google.android.gms.ads.internal.util.client.zzb.e("onDismissScreen must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.f654a.post(new by(this));
        } else {
            try {
                this.zzzL.onAdClosed();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdClosed.", e);
            }
        }
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onDismissScreen.");
        if (!com.google.android.gms.ads.internal.client.zzl.a().b()) {
            com.google.android.gms.ads.internal.util.client.zzb.e("onDismissScreen must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.f654a.post(new cd(this));
        } else {
            try {
                this.zzzL.onAdClosed();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdClosed.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, AdRequest.ErrorCode errorCode) {
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (!com.google.android.gms.ads.internal.client.zzl.a().b()) {
            com.google.android.gms.ads.internal.util.client.zzb.e("onFailedToReceiveAd must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.f654a.post(new bz(this, errorCode));
        } else {
            try {
                this.zzzL.onAdFailedToLoad(zzfa.zza(errorCode));
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, AdRequest.ErrorCode errorCode) {
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (!com.google.android.gms.ads.internal.client.zzl.a().b()) {
            com.google.android.gms.ads.internal.util.client.zzb.e("onFailedToReceiveAd must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.f654a.post(new bu(this, errorCode));
        } else {
            try {
                this.zzzL.onAdFailedToLoad(zzfa.zza(errorCode));
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onLeaveApplication.");
        if (!com.google.android.gms.ads.internal.client.zzl.a().b()) {
            com.google.android.gms.ads.internal.util.client.zzb.e("onLeaveApplication must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.f654a.post(new ca(this));
        } else {
            try {
                this.zzzL.onAdLeftApplication();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdLeftApplication.", e);
            }
        }
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onLeaveApplication.");
        if (!com.google.android.gms.ads.internal.client.zzl.a().b()) {
            com.google.android.gms.ads.internal.util.client.zzb.e("onLeaveApplication must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.f654a.post(new bv(this));
        } else {
            try {
                this.zzzL.onAdLeftApplication();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdLeftApplication.", e);
            }
        }
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onPresentScreen.");
        if (!com.google.android.gms.ads.internal.client.zzl.a().b()) {
            com.google.android.gms.ads.internal.util.client.zzb.e("onPresentScreen must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.f654a.post(new cb(this));
        } else {
            try {
                this.zzzL.onAdOpened();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdOpened.", e);
            }
        }
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onPresentScreen.");
        if (!com.google.android.gms.ads.internal.client.zzl.a().b()) {
            com.google.android.gms.ads.internal.util.client.zzb.e("onPresentScreen must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.f654a.post(new bw(this));
        } else {
            try {
                this.zzzL.onAdOpened();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdOpened.", e);
            }
        }
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onReceivedAd.");
        if (!com.google.android.gms.ads.internal.client.zzl.a().b()) {
            com.google.android.gms.ads.internal.util.client.zzb.e("onReceivedAd must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.f654a.post(new cc(this));
        } else {
            try {
                this.zzzL.onAdLoaded();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdLoaded.", e);
            }
        }
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onReceivedAd.");
        if (!com.google.android.gms.ads.internal.client.zzl.a().b()) {
            com.google.android.gms.ads.internal.util.client.zzb.e("onReceivedAd must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.f654a.post(new bx(this));
        } else {
            try {
                this.zzzL.onAdLoaded();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdLoaded.", e);
            }
        }
    }
}
