package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.common.internal.Preconditions;

@zzark
/* loaded from: classes2.dex */
public final class zzame implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener {
    private final zzalm zzdnz;
    private NativeAdMapper zzdoa;
    private UnifiedNativeAdMapper zzdob;
    private NativeCustomTemplateAd zzdoc;

    public zzame(zzalm zzalmVar) {
        this.zzdnz = zzalmVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdClicked(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onAdClicked.");
        try {
            this.zzdnz.onAdClicked();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdClosed(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onAdClosed.");
        try {
            this.zzdnz.onAdClosed();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, int i) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        StringBuilder sb = new StringBuilder(55);
        sb.append("Adapter called onAdFailedToLoad with error. ");
        sb.append(i);
        zzbbd.zzdn(sb.toString());
        try {
            this.zzdnz.onAdFailedToLoad(i);
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdImpression(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        NativeAdMapper nativeAdMapper = this.zzdoa;
        UnifiedNativeAdMapper unifiedNativeAdMapper = this.zzdob;
        if (this.zzdoc == null) {
            if (nativeAdMapper == null && unifiedNativeAdMapper == null) {
                zzbbd.zzd("#007 Could not call remote method.", null);
                return;
            }
            if (unifiedNativeAdMapper != null && !unifiedNativeAdMapper.j()) {
                zzbbd.zzdn("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
                return;
            } else if (nativeAdMapper != null && !nativeAdMapper.d()) {
                zzbbd.zzdn("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
                return;
            }
        }
        zzbbd.zzdn("Adapter called onAdImpression.");
        try {
            this.zzdnz.onAdImpression();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdLeftApplication(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onAdLeftApplication.");
        try {
            this.zzdnz.onAdLeftApplication();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdLoaded(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onAdLoaded.");
        try {
            this.zzdnz.onAdLoaded();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdOpened(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onAdOpened.");
        try {
            this.zzdnz.onAdOpened();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    public final void onVideoEnd(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onVideoEnd.");
        try {
            this.zzdnz.onVideoEnd();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void zza(MediationBannerAdapter mediationBannerAdapter, String str, String str2) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onAppEvent.");
        try {
            this.zzdnz.onAppEvent(str, str2);
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    public final NativeAdMapper zzvd() {
        return this.zzdoa;
    }

    public final UnifiedNativeAdMapper zzve() {
        return this.zzdob;
    }

    public final NativeCustomTemplateAd zzvf() {
        return this.zzdoc;
    }

    private static void zza(MediationNativeAdapter mediationNativeAdapter, UnifiedNativeAdMapper unifiedNativeAdMapper, NativeAdMapper nativeAdMapper) {
        if (mediationNativeAdapter instanceof AdMobAdapter) {
            return;
        }
        VideoController videoController = new VideoController();
        videoController.a(new zzamb());
        if (unifiedNativeAdMapper != null && unifiedNativeAdMapper.o()) {
            unifiedNativeAdMapper.a(videoController);
        }
        if (nativeAdMapper == null || !nativeAdMapper.f()) {
            return;
        }
        nativeAdMapper.a(videoController);
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdClicked(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onAdClicked.");
        try {
            this.zzdnz.onAdClicked();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdClosed(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onAdClosed.");
        try {
            this.zzdnz.onAdClosed();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, int i) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        StringBuilder sb = new StringBuilder(55);
        sb.append("Adapter called onAdFailedToLoad with error ");
        sb.append(i);
        sb.append(".");
        zzbbd.zzdn(sb.toString());
        try {
            this.zzdnz.onAdFailedToLoad(i);
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdLeftApplication(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onAdLeftApplication.");
        try {
            this.zzdnz.onAdLeftApplication();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdLoaded(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onAdLoaded.");
        try {
            this.zzdnz.onAdLoaded();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdOpened(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onAdOpened.");
        try {
            this.zzdnz.onAdOpened();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdClicked(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        NativeAdMapper nativeAdMapper = this.zzdoa;
        UnifiedNativeAdMapper unifiedNativeAdMapper = this.zzdob;
        if (this.zzdoc == null) {
            if (nativeAdMapper == null && unifiedNativeAdMapper == null) {
                zzbbd.zzd("#007 Could not call remote method.", null);
                return;
            }
            if (unifiedNativeAdMapper != null && !unifiedNativeAdMapper.i()) {
                zzbbd.zzdn("Could not call onAdClicked since setOverrideClickHandling is not set to true");
                return;
            } else if (nativeAdMapper != null && !nativeAdMapper.c()) {
                zzbbd.zzdn("Could not call onAdClicked since setOverrideClickHandling is not set to true");
                return;
            }
        }
        zzbbd.zzdn("Adapter called onAdClicked.");
        try {
            this.zzdnz.onAdClicked();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdClosed(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onAdClosed.");
        try {
            this.zzdnz.onAdClosed();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, int i) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        StringBuilder sb = new StringBuilder(55);
        sb.append("Adapter called onAdFailedToLoad with error ");
        sb.append(i);
        sb.append(".");
        zzbbd.zzdn(sb.toString());
        try {
            this.zzdnz.onAdFailedToLoad(i);
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdLeftApplication(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onAdLeftApplication.");
        try {
            this.zzdnz.onAdLeftApplication();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, NativeAdMapper nativeAdMapper) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onAdLoaded.");
        this.zzdoa = nativeAdMapper;
        this.zzdob = null;
        zza(mediationNativeAdapter, this.zzdob, this.zzdoa);
        try {
            this.zzdnz.onAdLoaded();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdOpened(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onAdOpened.");
        try {
            this.zzdnz.onAdOpened();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void zza(MediationNativeAdapter mediationNativeAdapter, NativeCustomTemplateAd nativeCustomTemplateAd) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        String valueOf = String.valueOf(nativeCustomTemplateAd.getCustomTemplateId());
        zzbbd.zzdn(valueOf.length() != 0 ? "Adapter called onAdLoaded with template id ".concat(valueOf) : new String("Adapter called onAdLoaded with template id "));
        this.zzdoc = nativeCustomTemplateAd;
        try {
            this.zzdnz.onAdLoaded();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, UnifiedNativeAdMapper unifiedNativeAdMapper) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onAdLoaded.");
        this.zzdob = unifiedNativeAdMapper;
        this.zzdoa = null;
        zza(mediationNativeAdapter, this.zzdob, this.zzdoa);
        try {
            this.zzdnz.onAdLoaded();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void zza(MediationNativeAdapter mediationNativeAdapter, NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
        if (nativeCustomTemplateAd instanceof zzaea) {
            try {
                this.zzdnz.zzb(((zzaea) nativeCustomTemplateAd).zzsx(), str);
                return;
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
                return;
            }
        }
        zzbbd.zzeo("Unexpected native custom template ad type.");
    }
}
