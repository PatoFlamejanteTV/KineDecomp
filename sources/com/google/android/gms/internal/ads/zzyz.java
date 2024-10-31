package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

@zzark
/* loaded from: classes2.dex */
public final class zzyz {
    private VideoOptions zzblb;
    private boolean zzbli;
    private AppEventListener zzblk;
    private String zzboa;
    private zzvt zzciw;
    private AdListener zzciz;
    private AdSize[] zzckq;
    private final zzalf zzcmj;
    private final AtomicBoolean zzcmk;
    private final VideoController zzcml;

    @VisibleForTesting
    private final zzww zzcmm;
    private Correlator zzcmn;
    private zzxl zzcmo;
    private OnCustomRenderedAdLoadedListener zzcmp;
    private ViewGroup zzcmq;
    private int zzcmr;
    private final zzwe zzvn;

    public zzyz(ViewGroup viewGroup) {
        this(viewGroup, null, false, zzwe.zzckj, 0);
    }

    private static boolean zzcj(int i) {
        return i == 1;
    }

    public final void destroy() {
        try {
            if (this.zzcmo != null) {
                this.zzcmo.destroy();
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    public final AdListener getAdListener() {
        return this.zzciz;
    }

    public final AdSize getAdSize() {
        zzwf zzif;
        try {
            if (this.zzcmo != null && (zzif = this.zzcmo.zzif()) != null) {
                return zzif.zzpp();
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
        AdSize[] adSizeArr = this.zzckq;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    public final AdSize[] getAdSizes() {
        return this.zzckq;
    }

    public final String getAdUnitId() {
        zzxl zzxlVar;
        if (this.zzboa == null && (zzxlVar = this.zzcmo) != null) {
            try {
                this.zzboa = zzxlVar.getAdUnitId();
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
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
            zzbbd.zzd("#007 Could not call remote method.", e2);
            return null;
        }
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzcmp;
    }

    public final VideoController getVideoController() {
        return this.zzcml;
    }

    public final VideoOptions getVideoOptions() {
        return this.zzblb;
    }

    public final boolean isLoading() {
        try {
            if (this.zzcmo != null) {
                return this.zzcmo.isLoading();
            }
            return false;
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
            return false;
        }
    }

    public final void pause() {
        try {
            if (this.zzcmo != null) {
                this.zzcmo.pause();
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    public final void recordManualImpression() {
        if (this.zzcmk.getAndSet(true)) {
            return;
        }
        try {
            if (this.zzcmo != null) {
                this.zzcmo.zzih();
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    public final void resume() {
        try {
            if (this.zzcmo != null) {
                this.zzcmo.resume();
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    public final void setAdListener(AdListener adListener) {
        this.zzciz = adListener;
        this.zzcmm.zza(adListener);
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (this.zzckq == null) {
            zza(adSizeArr);
            return;
        }
        throw new IllegalStateException("The ad size can only be set once on AdView.");
    }

    public final void setAdUnitId(String str) {
        if (this.zzboa == null) {
            this.zzboa = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzblk = appEventListener;
            if (this.zzcmo != null) {
                this.zzcmo.zza(appEventListener != null ? new zzwh(appEventListener) : null);
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    public final void setCorrelator(Correlator correlator) {
        this.zzcmn = correlator;
        try {
            if (this.zzcmo != null) {
                this.zzcmo.zza(this.zzcmn == null ? null : this.zzcmn.a());
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzbli = z;
        try {
            if (this.zzcmo != null) {
                this.zzcmo.setManualImpressionsEnabled(this.zzbli);
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzcmp = onCustomRenderedAdLoadedListener;
        try {
            if (this.zzcmo != null) {
                this.zzcmo.zza(onCustomRenderedAdLoadedListener != null ? new zzabj(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        this.zzblb = videoOptions;
        try {
            if (this.zzcmo != null) {
                this.zzcmo.zza(videoOptions == null ? null : new zzzw(videoOptions));
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    public final void zza(zzyx zzyxVar) {
        zzxl a2;
        try {
            if (this.zzcmo == null) {
                if ((this.zzckq != null && this.zzboa != null) || this.zzcmo != null) {
                    Context context = this.zzcmq.getContext();
                    zzwf zza = zza(context, this.zzckq, this.zzcmr);
                    if ("search_v2".equals(zza.zzckk)) {
                        a2 = new nn(zzwu.zzpw(), context, zza, this.zzboa).a(context, false);
                    } else {
                        a2 = new ln(zzwu.zzpw(), context, zza, this.zzboa, this.zzcmj).a(context, false);
                    }
                    this.zzcmo = a2;
                    this.zzcmo.zza(new zzvx(this.zzcmm));
                    if (this.zzciw != null) {
                        this.zzcmo.zza(new zzvu(this.zzciw));
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
                    if (this.zzblb != null) {
                        this.zzcmo.zza(new zzzw(this.zzblb));
                    }
                    this.zzcmo.setManualImpressionsEnabled(this.zzbli);
                    try {
                        IObjectWrapper zzie = this.zzcmo.zzie();
                        if (zzie != null) {
                            this.zzcmq.addView((View) ObjectWrapper.a(zzie));
                        }
                    } catch (RemoteException e2) {
                        zzbbd.zzd("#007 Could not call remote method.", e2);
                    }
                } else {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
            }
            if (this.zzcmo.zzb(zzwe.zza(this.zzcmq.getContext(), zzyxVar))) {
                this.zzcmj.zzj(zzyxVar.zzqk());
            }
        } catch (RemoteException e3) {
            zzbbd.zzd("#007 Could not call remote method.", e3);
        }
    }

    public final zzyp zzbc() {
        zzxl zzxlVar = this.zzcmo;
        if (zzxlVar == null) {
            return null;
        }
        try {
            return zzxlVar.getVideoController();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
            return null;
        }
    }

    public zzyz(ViewGroup viewGroup, int i) {
        this(viewGroup, null, false, zzwe.zzckj, i);
    }

    public zzyz(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzwe.zzckj, 0);
    }

    public zzyz(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, false, zzwe.zzckj, i);
    }

    @VisibleForTesting
    private zzyz(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzwe zzweVar, zzxl zzxlVar, int i) {
        this.zzcmj = new zzalf();
        this.zzcml = new VideoController();
        this.zzcmm = new vn(this);
        this.zzcmq = viewGroup;
        this.zzvn = zzweVar;
        this.zzcmo = null;
        this.zzcmk = new AtomicBoolean(false);
        this.zzcmr = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzwi zzwiVar = new zzwi(context, attributeSet);
                this.zzckq = zzwiVar.zzt(z);
                this.zzboa = zzwiVar.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    zzbat zzpv = zzwu.zzpv();
                    AdSize adSize = this.zzckq[0];
                    int i2 = this.zzcmr;
                    zzwf zzwfVar = new zzwf(context, adSize);
                    zzwfVar.zzckp = zzcj(i2);
                    zzpv.zza(viewGroup, zzwfVar, "Ads by Google");
                }
            } catch (IllegalArgumentException e2) {
                zzwu.zzpv().zza(viewGroup, new zzwf(context, AdSize.f9932a), e2.getMessage(), e2.getMessage());
            }
        }
    }

    @VisibleForTesting
    private zzyz(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzwe zzweVar, int i) {
        this(viewGroup, attributeSet, z, zzweVar, null, i);
    }

    public final void zza(zzvt zzvtVar) {
        try {
            this.zzciw = zzvtVar;
            if (this.zzcmo != null) {
                this.zzcmo.zza(zzvtVar != null ? new zzvu(zzvtVar) : null);
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    public final void zza(AdSize... adSizeArr) {
        this.zzckq = adSizeArr;
        try {
            if (this.zzcmo != null) {
                this.zzcmo.zza(zza(this.zzcmq.getContext(), this.zzckq, this.zzcmr));
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
        this.zzcmq.requestLayout();
    }

    public final boolean zza(zzxl zzxlVar) {
        if (zzxlVar == null) {
            return false;
        }
        try {
            IObjectWrapper zzie = zzxlVar.zzie();
            if (zzie == null || ((View) ObjectWrapper.a(zzie)).getParent() != null) {
                return false;
            }
            this.zzcmq.addView((View) ObjectWrapper.a(zzie));
            this.zzcmo = zzxlVar;
            return true;
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
            return false;
        }
    }

    private static zzwf zza(Context context, AdSize[] adSizeArr, int i) {
        zzwf zzwfVar = new zzwf(context, adSizeArr);
        zzwfVar.zzckp = zzcj(i);
        return zzwfVar;
    }
}
