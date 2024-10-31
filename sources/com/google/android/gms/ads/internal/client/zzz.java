package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzcl;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzgb;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class zzz {

    /* renamed from: a, reason: collision with root package name */
    private final zzel f559a;
    private final zzh b;
    private final AtomicBoolean c;
    private AdListener d;
    private zza e;
    private zzs f;
    private AdSize[] g;
    private String h;
    private String i;
    private ViewGroup j;
    private AppEventListener k;
    private InAppPurchaseListener l;
    private PlayStorePurchaseListener m;
    private OnCustomRenderedAdLoadedListener n;
    private boolean o;

    public zzz(ViewGroup viewGroup) {
        this(viewGroup, null, false, zzh.a());
    }

    zzz(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzh zzhVar) {
        this(viewGroup, attributeSet, z, zzhVar, null);
    }

    zzz(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzh zzhVar, zzs zzsVar) {
        this.f559a = new zzel();
        this.j = viewGroup;
        this.b = zzhVar;
        this.f = zzsVar;
        this.c = new AtomicBoolean(false);
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzk zzkVar = new zzk(context, attributeSet);
                this.g = zzkVar.a(z);
                this.h = zzkVar.a();
                if (viewGroup.isInEditMode()) {
                    zzl.a().a(viewGroup, new AdSizeParcel(context, this.g[0]), "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzl.a().a(viewGroup, new AdSizeParcel(context, AdSize.f516a), e.getMessage(), e.getMessage());
            }
        }
    }

    private void n() {
        try {
            com.google.android.gms.dynamic.zzd zzaM = this.f.zzaM();
            if (zzaM == null) {
                return;
            }
            this.j.addView((View) com.google.android.gms.dynamic.zze.a(zzaM));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Failed to get an ad frame.", e);
        }
    }

    public void a() {
        try {
            if (this.f != null) {
                this.f.destroy();
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Failed to destroy AdView.", e);
        }
    }

    public void a(AdListener adListener) {
        try {
            this.d = adListener;
            if (this.f != null) {
                this.f.zza(adListener != null ? new zzc(adListener) : null);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Failed to set the AdListener.", e);
        }
    }

    public void a(AppEventListener appEventListener) {
        try {
            this.k = appEventListener;
            if (this.f != null) {
                this.f.zza(appEventListener != null ? new zzj(appEventListener) : null);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Failed to set the AppEventListener.", e);
        }
    }

    public void a(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.n = onCustomRenderedAdLoadedListener;
        try {
            if (this.f != null) {
                this.f.zza(onCustomRenderedAdLoadedListener != null ? new zzcl(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Failed to set the onCustomRenderedAdLoadedListener.", e);
        }
    }

    public void a(zza zzaVar) {
        try {
            this.e = zzaVar;
            if (this.f != null) {
                this.f.zza(zzaVar != null ? new zzb(zzaVar) : null);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Failed to set the AdClickListener.", e);
        }
    }

    public void a(zzy zzyVar) {
        try {
            if (this.f == null) {
                l();
            }
            if (this.f.zzb(this.b.a(this.j.getContext(), zzyVar))) {
                this.f559a.zze(zzyVar.j());
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Failed to load ad.", e);
        }
    }

    public void a(InAppPurchaseListener inAppPurchaseListener) {
        if (this.m != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.l = inAppPurchaseListener;
            if (this.f != null) {
                this.f.zza(inAppPurchaseListener != null ? new zzfx(inAppPurchaseListener) : null);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void a(String str) {
        if (this.h != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.h = str;
    }

    public void a(boolean z) {
        this.o = z;
        try {
            if (this.f != null) {
                this.f.setManualImpressionsEnabled(this.o);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Failed to set manual impressions.", e);
        }
    }

    public void a(AdSize... adSizeArr) {
        if (this.g != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        b(adSizeArr);
    }

    public AdListener b() {
        return this.d;
    }

    public void b(AdSize... adSizeArr) {
        this.g = adSizeArr;
        try {
            if (this.f != null) {
                this.f.zza(new AdSizeParcel(this.j.getContext(), this.g));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Failed to set the ad size.", e);
        }
        this.j.requestLayout();
    }

    public AdSize c() {
        AdSizeParcel zzaN;
        try {
            if (this.f != null && (zzaN = this.f.zzaN()) != null) {
                return zzaN.b();
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Failed to get the current AdSize.", e);
        }
        if (this.g != null) {
            return this.g[0];
        }
        return null;
    }

    public AdSize[] d() {
        return this.g;
    }

    public String e() {
        return this.h;
    }

    public AppEventListener f() {
        return this.k;
    }

    public InAppPurchaseListener g() {
        return this.l;
    }

    public OnCustomRenderedAdLoadedListener h() {
        return this.n;
    }

    public void i() {
        try {
            if (this.f != null) {
                this.f.pause();
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Failed to call pause.", e);
        }
    }

    public void j() {
        try {
            if (this.f != null) {
                this.f.resume();
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Failed to call resume.", e);
        }
    }

    public String k() {
        try {
            if (this.f != null) {
                return this.f.getMediationAdapterClassName();
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    void l() throws RemoteException {
        if ((this.g == null || this.h == null) && this.f == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        this.f = m();
        if (this.d != null) {
            this.f.zza(new zzc(this.d));
        }
        if (this.e != null) {
            this.f.zza(new zzb(this.e));
        }
        if (this.k != null) {
            this.f.zza(new zzj(this.k));
        }
        if (this.l != null) {
            this.f.zza(new zzfx(this.l));
        }
        if (this.m != null) {
            this.f.zza(new zzgb(this.m), this.i);
        }
        if (this.n != null) {
            this.f.zza(new zzcl(this.n));
        }
        this.f.zza(zzl.c());
        this.f.setManualImpressionsEnabled(this.o);
        n();
    }

    protected zzs m() throws RemoteException {
        Context context = this.j.getContext();
        return zzl.b().a(context, new AdSizeParcel(context, this.g), this.h, this.f559a);
    }
}
