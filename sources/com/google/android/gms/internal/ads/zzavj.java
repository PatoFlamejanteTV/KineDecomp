package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzark
/* loaded from: classes2.dex */
public final class zzavj implements RewardedVideoAd {
    private final Context mContext;
    private String zzbtr;
    private final zzauw zzeem;
    private String zzeeo;
    private final Object mLock = new Object();
    private final zzavg zzeen = new zzavg(null);

    public zzavj(Context context, zzauw zzauwVar) {
        this.zzeem = zzauwVar == null ? new zzzq() : zzauwVar;
        this.mContext = context.getApplicationContext();
    }

    private final void zza(String str, zzyx zzyxVar) {
        synchronized (this.mLock) {
            if (this.zzeem == null) {
                return;
            }
            try {
                this.zzeem.zza(new zzavh(zzwe.zza(this.mContext, zzyxVar), str));
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void destroy() {
        destroy(null);
    }

    public final Bundle getAdMetadata() {
        synchronized (this.mLock) {
            if (this.zzeem != null) {
                try {
                    return this.zzeem.getAdMetadata();
                } catch (RemoteException e2) {
                    zzbbd.zzd("#007 Could not call remote method.", e2);
                }
            }
            return new Bundle();
        }
    }

    public final String getCustomData() {
        String str;
        synchronized (this.mLock) {
            str = this.zzeeo;
        }
        return str;
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.zzeem != null) {
                return this.zzeem.getMediationAdapterClassName();
            }
            return null;
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
            return null;
        }
    }

    public final RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.mLock) {
            rewardedVideoAdListener = this.zzeen.getRewardedVideoAdListener();
        }
        return rewardedVideoAdListener;
    }

    public final String getUserId() {
        String str;
        synchronized (this.mLock) {
            str = this.zzbtr;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final boolean isLoaded() {
        synchronized (this.mLock) {
            if (this.zzeem == null) {
                return false;
            }
            try {
                return this.zzeem.isLoaded();
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
                return false;
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void loadAd(String str, AdRequest adRequest) {
        zza(str, adRequest.a());
    }

    public final void pause() {
        pause(null);
    }

    public final void resume() {
        resume(null);
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        synchronized (this.mLock) {
            if (this.zzeem != null) {
                try {
                    this.zzeem.zza(new zzwa(adMetadataListener));
                } catch (RemoteException e2) {
                    zzbbd.zzd("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    public final void setCustomData(String str) {
        synchronized (this.mLock) {
            if (this.zzeem != null) {
                try {
                    this.zzeem.setCustomData(str);
                    this.zzeeo = str;
                } catch (RemoteException e2) {
                    zzbbd.zzd("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    public final void setImmersiveMode(boolean z) {
        synchronized (this.mLock) {
            if (this.zzeem != null) {
                try {
                    this.zzeem.setImmersiveMode(z);
                } catch (RemoteException e2) {
                    zzbbd.zzd("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        synchronized (this.mLock) {
            this.zzeen.setRewardedVideoAdListener(rewardedVideoAdListener);
            if (this.zzeem != null) {
                try {
                    this.zzeem.zza(this.zzeen);
                } catch (RemoteException e2) {
                    zzbbd.zzd("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    public final void setUserId(String str) {
        synchronized (this.mLock) {
            this.zzbtr = str;
            if (this.zzeem != null) {
                try {
                    this.zzeem.setUserId(str);
                } catch (RemoteException e2) {
                    zzbbd.zzd("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void show() {
        synchronized (this.mLock) {
            if (this.zzeem == null) {
                return;
            }
            try {
                this.zzeem.show();
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void destroy(Context context) {
        synchronized (this.mLock) {
            this.zzeen.setRewardedVideoAdListener(null);
            if (this.zzeem == null) {
                return;
            }
            try {
                this.zzeem.zzg(ObjectWrapper.a(context));
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void loadAd(String str, PublisherAdRequest publisherAdRequest) {
        zza(str, publisherAdRequest.a());
    }

    public final void pause(Context context) {
        synchronized (this.mLock) {
            if (this.zzeem == null) {
                return;
            }
            try {
                this.zzeem.zze(ObjectWrapper.a(context));
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void resume(Context context) {
        synchronized (this.mLock) {
            if (this.zzeem == null) {
                return;
            }
            try {
                this.zzeem.zzf(ObjectWrapper.a(context));
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
    }
}
