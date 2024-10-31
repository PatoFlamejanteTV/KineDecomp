package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

@zzark
/* loaded from: classes2.dex */
public final class zzamj<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final zzalm zzdnz;

    public zzamj(zzalm zzalmVar) {
        this.zzdnz = zzalmVar;
    }

    public final void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbbd.zzdn("Adapter called onClick.");
        zzwu.zzpv();
        if (!zzbat.zzaar()) {
            zzbbd.zzd("#008 Must be called on the main UI thread.", null);
            zzbat.zztu.post(new RunnableC1022ob(this));
        } else {
            try {
                this.zzdnz.onAdClicked();
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbbd.zzdn("Adapter called onDismissScreen.");
        zzwu.zzpv();
        if (!zzbat.zzaar()) {
            zzbbd.zzeo("#008 Must be called on the main UI thread.");
            zzbat.zztu.post(new RunnableC1063rb(this));
        } else {
            try {
                this.zzdnz.onAdClosed();
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error. ");
        sb.append(valueOf);
        zzbbd.zzdn(sb.toString());
        zzwu.zzpv();
        if (!zzbat.zzaar()) {
            zzbbd.zzd("#008 Must be called on the main UI thread.", null);
            zzbat.zztu.post(new RunnableC1077sb(this, errorCode));
        } else {
            try {
                this.zzdnz.onAdFailedToLoad(zzamv.zza(errorCode));
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbbd.zzdn("Adapter called onLeaveApplication.");
        zzwu.zzpv();
        if (!zzbat.zzaar()) {
            zzbbd.zzd("#008 Must be called on the main UI thread.", null);
            zzbat.zztu.post(new RunnableC1091tb(this));
        } else {
            try {
                this.zzdnz.onAdLeftApplication();
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbbd.zzdn("Adapter called onPresentScreen.");
        zzwu.zzpv();
        if (!zzbat.zzaar()) {
            zzbbd.zzd("#008 Must be called on the main UI thread.", null);
            zzbat.zztu.post(new RunnableC1105ub(this));
        } else {
            try {
                this.zzdnz.onAdOpened();
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbbd.zzdn("Adapter called onReceivedAd.");
        zzwu.zzpv();
        if (!zzbat.zzaar()) {
            zzbbd.zzd("#008 Must be called on the main UI thread.", null);
            zzbat.zztu.post(new RunnableC1119vb(this));
        } else {
            try {
                this.zzdnz.onAdLoaded();
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbbd.zzdn("Adapter called onDismissScreen.");
        zzwu.zzpv();
        if (!zzbat.zzaar()) {
            zzbbd.zzd("#008 Must be called on the main UI thread.", null);
            zzbat.zztu.post(new RunnableC1133wb(this));
        } else {
            try {
                this.zzdnz.onAdClosed();
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error ");
        sb.append(valueOf);
        sb.append(".");
        zzbbd.zzdn(sb.toString());
        zzwu.zzpv();
        if (!zzbat.zzaar()) {
            zzbbd.zzd("#008 Must be called on the main UI thread.", null);
            zzbat.zztu.post(new RunnableC1147xb(this, errorCode));
        } else {
            try {
                this.zzdnz.onAdFailedToLoad(zzamv.zza(errorCode));
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbbd.zzdn("Adapter called onLeaveApplication.");
        zzwu.zzpv();
        if (!zzbat.zzaar()) {
            zzbbd.zzd("#008 Must be called on the main UI thread.", null);
            zzbat.zztu.post(new RunnableC1161yb(this));
        } else {
            try {
                this.zzdnz.onAdLeftApplication();
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbbd.zzdn("Adapter called onPresentScreen.");
        zzwu.zzpv();
        if (!zzbat.zzaar()) {
            zzbbd.zzd("#008 Must be called on the main UI thread.", null);
            zzbat.zztu.post(new RunnableC1036pb(this));
        } else {
            try {
                this.zzdnz.onAdOpened();
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbbd.zzdn("Adapter called onReceivedAd.");
        zzwu.zzpv();
        if (!zzbat.zzaar()) {
            zzbbd.zzd("#008 Must be called on the main UI thread.", null);
            zzbat.zztu.post(new RunnableC1050qb(this));
        } else {
            try {
                this.zzdnz.onAdLoaded();
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
    }
}
