package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;

@zzgr
/* loaded from: classes.dex */
public final class zzeu implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener {
    private final zzeo zzzL;
    private NativeAdMapper zzzM;

    public zzeu(zzeo zzeoVar) {
        this.zzzL = zzeoVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public void onAdClicked(MediationBannerAdapter mediationBannerAdapter) {
        com.google.android.gms.common.internal.zzx.b("onAdClicked must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onAdClicked.");
        try {
            this.zzzL.onAdClicked();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdClicked.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public void onAdClicked(MediationInterstitialAdapter mediationInterstitialAdapter) {
        com.google.android.gms.common.internal.zzx.b("onAdClicked must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onAdClicked.");
        try {
            this.zzzL.onAdClicked();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdClicked.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public void onAdClicked(MediationNativeAdapter mediationNativeAdapter) {
        com.google.android.gms.common.internal.zzx.b("onAdClicked must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onAdClicked.");
        try {
            this.zzzL.onAdClicked();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdClicked.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public void onAdClosed(MediationBannerAdapter mediationBannerAdapter) {
        com.google.android.gms.common.internal.zzx.b("onAdClosed must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onAdClosed.");
        try {
            this.zzzL.onAdClosed();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdClosed.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public void onAdClosed(MediationInterstitialAdapter mediationInterstitialAdapter) {
        com.google.android.gms.common.internal.zzx.b("onAdClosed must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onAdClosed.");
        try {
            this.zzzL.onAdClosed();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdClosed.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public void onAdClosed(MediationNativeAdapter mediationNativeAdapter) {
        com.google.android.gms.common.internal.zzx.b("onAdClosed must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onAdClosed.");
        try {
            this.zzzL.onAdClosed();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdClosed.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, int i) {
        com.google.android.gms.common.internal.zzx.b("onAdFailedToLoad must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onAdFailedToLoad with error. " + i);
        try {
            this.zzzL.onAdFailedToLoad(i);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdFailedToLoad.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, int i) {
        com.google.android.gms.common.internal.zzx.b("onAdFailedToLoad must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.zzzL.onAdFailedToLoad(i);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdFailedToLoad.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, int i) {
        com.google.android.gms.common.internal.zzx.b("onAdFailedToLoad must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.zzzL.onAdFailedToLoad(i);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdFailedToLoad.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public void onAdLeftApplication(MediationBannerAdapter mediationBannerAdapter) {
        com.google.android.gms.common.internal.zzx.b("onAdLeftApplication must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onAdLeftApplication.");
        try {
            this.zzzL.onAdLeftApplication();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdLeftApplication.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public void onAdLeftApplication(MediationInterstitialAdapter mediationInterstitialAdapter) {
        com.google.android.gms.common.internal.zzx.b("onAdLeftApplication must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onAdLeftApplication.");
        try {
            this.zzzL.onAdLeftApplication();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdLeftApplication.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public void onAdLeftApplication(MediationNativeAdapter mediationNativeAdapter) {
        com.google.android.gms.common.internal.zzx.b("onAdLeftApplication must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onAdLeftApplication.");
        try {
            this.zzzL.onAdLeftApplication();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdLeftApplication.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public void onAdLoaded(MediationBannerAdapter mediationBannerAdapter) {
        com.google.android.gms.common.internal.zzx.b("onAdLoaded must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onAdLoaded.");
        try {
            this.zzzL.onAdLoaded();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdLoaded.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public void onAdLoaded(MediationInterstitialAdapter mediationInterstitialAdapter) {
        com.google.android.gms.common.internal.zzx.b("onAdLoaded must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onAdLoaded.");
        try {
            this.zzzL.onAdLoaded();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdLoaded.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, NativeAdMapper nativeAdMapper) {
        com.google.android.gms.common.internal.zzx.b("onAdLoaded must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onAdLoaded.");
        this.zzzM = nativeAdMapper;
        try {
            this.zzzL.onAdLoaded();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdLoaded.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public void onAdOpened(MediationBannerAdapter mediationBannerAdapter) {
        com.google.android.gms.common.internal.zzx.b("onAdOpened must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onAdOpened.");
        try {
            this.zzzL.onAdOpened();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdOpened.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public void onAdOpened(MediationInterstitialAdapter mediationInterstitialAdapter) {
        com.google.android.gms.common.internal.zzx.b("onAdOpened must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onAdOpened.");
        try {
            this.zzzL.onAdOpened();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdOpened.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public void onAdOpened(MediationNativeAdapter mediationNativeAdapter) {
        com.google.android.gms.common.internal.zzx.b("onAdOpened must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter called onAdOpened.");
        try {
            this.zzzL.onAdOpened();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdOpened.", e);
        }
    }

    public NativeAdMapper zzeb() {
        return this.zzzM;
    }
}
