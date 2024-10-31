package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.util.VisibleForTesting;

@zzark
/* loaded from: classes2.dex */
public final class zzzb {
    private final Context mContext;
    private AppEventListener zzblk;
    private String zzboa;
    private boolean zzboq;
    private zzvt zzciw;
    private AdListener zzciz;
    private AdMetadataListener zzcja;
    private final zzalf zzcmj;
    private Correlator zzcmn;
    private zzxl zzcmo;
    private OnCustomRenderedAdLoadedListener zzcmp;
    private boolean zzcmt;
    private RewardedVideoAdListener zzhy;
    private final zzwe zzvn;

    public zzzb(Context context) {
        this(context, zzwe.zzckj, null);
    }

    private final void zzbl(String str) {
        if (this.zzcmo != null) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63);
        sb.append("The ad unit ID must be set on InterstitialAd before ");
        sb.append(str);
        sb.append(" is called.");
        throw new IllegalStateException(sb.toString());
    }

    public final AdListener getAdListener() {
        return this.zzciz;
    }

    public final Bundle getAdMetadata() {
        try {
            if (this.zzcmo != null) {
                return this.zzcmo.getAdMetadata();
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#008 Must be called on the main UI thread.", e2);
        }
        return new Bundle();
    }

    public final String getAdUnitId() {
        return this.zzboa;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzblk;
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.zzcmo != null) {
                return this.zzcmo.zzje();
            }
            return null;
        } catch (RemoteException e2) {
            zzbbd.zzd("#008 Must be called on the main UI thread.", e2);
            return null;
        }
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzcmp;
    }

    public final boolean isLoaded() {
        try {
            if (this.zzcmo == null) {
                return false;
            }
            return this.zzcmo.isReady();
        } catch (RemoteException e2) {
            zzbbd.zzd("#008 Must be called on the main UI thread.", e2);
            return false;
        }
    }

    public final boolean isLoading() {
        try {
            if (this.zzcmo == null) {
                return false;
            }
            return this.zzcmo.isLoading();
        } catch (RemoteException e2) {
            zzbbd.zzd("#008 Must be called on the main UI thread.", e2);
            return false;
        }
    }

    public final void setAdListener(AdListener adListener) {
        try {
            this.zzciz = adListener;
            if (this.zzcmo != null) {
                this.zzcmo.zza(adListener != null ? new zzvx(adListener) : null);
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#008 Must be called on the main UI thread.", e2);
        }
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        try {
            this.zzcja = adMetadataListener;
            if (this.zzcmo != null) {
                this.zzcmo.zza(adMetadataListener != null ? new zzwa(adMetadataListener) : null);
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#008 Must be called on the main UI thread.", e2);
        }
    }

    public final void setAdUnitId(String str) {
        if (this.zzboa == null) {
            this.zzboa = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzblk = appEventListener;
            if (this.zzcmo != null) {
                this.zzcmo.zza(appEventListener != null ? new zzwh(appEventListener) : null);
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#008 Must be called on the main UI thread.", e2);
        }
    }

    public final void setCorrelator(Correlator correlator) {
        this.zzcmn = correlator;
        try {
            if (this.zzcmo != null) {
                this.zzcmo.zza(this.zzcmn == null ? null : this.zzcmn.a());
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#008 Must be called on the main UI thread.", e2);
        }
    }

    public final void setImmersiveMode(boolean z) {
        try {
            this.zzboq = z;
            if (this.zzcmo != null) {
                this.zzcmo.setImmersiveMode(z);
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#008 Must be called on the main UI thread.", e2);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.zzcmp = onCustomRenderedAdLoadedListener;
            if (this.zzcmo != null) {
                this.zzcmo.zza(onCustomRenderedAdLoadedListener != null ? new zzabj(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#008 Must be called on the main UI thread.", e2);
        }
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        try {
            this.zzhy = rewardedVideoAdListener;
            if (this.zzcmo != null) {
                this.zzcmo.zza(rewardedVideoAdListener != null ? new zzavg(rewardedVideoAdListener) : null);
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#008 Must be called on the main UI thread.", e2);
        }
    }

    public final void show() {
        try {
            zzbl("show");
            this.zzcmo.showInterstitial();
        } catch (RemoteException e2) {
            zzbbd.zzd("#008 Must be called on the main UI thread.", e2);
        }
    }

    public final void zza(zzyx zzyxVar) {
        try {
            if (this.zzcmo == null) {
                if (this.zzboa == null) {
                    zzbl("loadAd");
                }
                zzwf zzpo = this.zzcmt ? zzwf.zzpo() : new zzwf();
                zzwj zzpw = zzwu.zzpw();
                Context context = this.mContext;
                this.zzcmo = new on(zzpw, context, zzpo, this.zzboa, this.zzcmj).a(context, false);
                if (this.zzciz != null) {
                    this.zzcmo.zza(new zzvx(this.zzciz));
                }
                if (this.zzciw != null) {
                    this.zzcmo.zza(new zzvu(this.zzciw));
                }
                if (this.zzcja != null) {
                    this.zzcmo.zza(new zzwa(this.zzcja));
                }
                if (this.zzblk != null) {
                    this.zzcmo.zza(new zzwh(this.zzblk));
                }
                if (this.zzcmp != null) {
                    this.zzcmo.zza(new zzabj(this.zzcmp));
                }
                if (this.zzcmn != null) {
                    this.zzcmo.zza(this.zzcmn.a());
                }
                if (this.zzhy != null) {
                    this.zzcmo.zza(new zzavg(this.zzhy));
                }
                this.zzcmo.setImmersiveMode(this.zzboq);
            }
            if (this.zzcmo.zzb(zzwe.zza(this.mContext, zzyxVar))) {
                this.zzcmj.zzj(zzyxVar.zzqk());
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#008 Must be called on the main UI thread.", e2);
        }
    }

    public zzzb(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, zzwe.zzckj, publisherInterstitialAd);
    }

    @VisibleForTesting
    private zzzb(Context context, zzwe zzweVar, PublisherInterstitialAd publisherInterstitialAd) {
        this.zzcmj = new zzalf();
        this.mContext = context;
        this.zzvn = zzweVar;
    }

    public final void zza(zzvt zzvtVar) {
        try {
            this.zzciw = zzvtVar;
            if (this.zzcmo != null) {
                this.zzcmo.zza(zzvtVar != null ? new zzvu(zzvtVar) : null);
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#008 Must be called on the main UI thread.", e2);
        }
    }

    public final void zza(boolean z) {
        this.zzcmt = true;
    }
}
