package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzark
/* loaded from: classes2.dex */
public final class zzawc implements MediationRewardedVideoAdListener {
    private final zzavz zzefn;

    public zzawc(zzavz zzavzVar) {
        this.zzefn = zzavzVar;
    }

    public final void onAdClicked(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onAdClicked.");
        try {
            this.zzefn.zzx(ObjectWrapper.a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdClosed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onAdClosed.");
        try {
            this.zzefn.zzw(ObjectWrapper.a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdFailedToLoad(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onAdFailedToLoad.");
        try {
            this.zzefn.zzd(ObjectWrapper.a(mediationRewardedVideoAdAdapter), i);
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdLeftApplication(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onAdLeftApplication.");
        try {
            this.zzefn.zzy(ObjectWrapper.a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdLoaded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onAdLoaded.");
        try {
            this.zzefn.zzt(ObjectWrapper.a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdOpened(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onAdOpened.");
        try {
            this.zzefn.zzu(ObjectWrapper.a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    public final void onInitializationFailed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onInitializationFailed.");
        try {
            this.zzefn.zzc(ObjectWrapper.a(mediationRewardedVideoAdAdapter), i);
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onInitializationSucceeded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onInitializationSucceeded.");
        try {
            this.zzefn.zzs(ObjectWrapper.a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onRewarded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, RewardItem rewardItem) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onRewarded.");
        try {
            if (rewardItem != null) {
                this.zzefn.zza(ObjectWrapper.a(mediationRewardedVideoAdAdapter), new zzawd(rewardItem));
            } else {
                this.zzefn.zza(ObjectWrapper.a(mediationRewardedVideoAdAdapter), new zzawd("", 1));
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onVideoCompleted(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onVideoCompleted.");
        try {
            this.zzefn.zzz(ObjectWrapper.a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onVideoStarted(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onVideoStarted.");
        try {
            this.zzefn.zzv(ObjectWrapper.a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void zzc(Bundle bundle) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        zzbbd.zzdn("Adapter called onAdMetadataChanged.");
        try {
            this.zzefn.zzc(bundle);
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }
}
