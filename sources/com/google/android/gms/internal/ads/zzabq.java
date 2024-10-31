package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzabq extends zzagc implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzacf {
    private zzbgg zzdaq;
    private zzacd zzdar;
    private boolean zzdas = false;
    private boolean zzdat = false;

    public zzabq(zzbgg zzbggVar) {
        this.zzdaq = zzbggVar;
    }

    private final void zzry() {
        zzbgg zzbggVar = this.zzdaq;
        if (zzbggVar == null) {
            return;
        }
        ViewParent parent = zzbggVar.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView((View) this.zzdaq);
        }
    }

    private final void zzrz() {
        zzbgg zzbggVar;
        zzacd zzacdVar = this.zzdar;
        if (zzacdVar == null || (zzbggVar = this.zzdaq) == null) {
            return;
        }
        zzacdVar.zzc(zzbggVar.getView(), Collections.emptyMap());
    }

    @Override // com.google.android.gms.internal.ads.zzagb
    public final void destroy() {
        Preconditions.a("#008 Must be called on the main UI thread.");
        if (this.zzdas) {
            return;
        }
        zzry();
        zzacd zzacdVar = this.zzdar;
        if (zzacdVar != null) {
            zzacdVar.zzsr();
            this.zzdar.zzsq();
        }
        this.zzdar = null;
        this.zzdaq = null;
        this.zzdas = true;
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final String getCustomTemplateId() {
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzagb
    public final zzyp getVideoController() throws RemoteException {
        Preconditions.a("#008 Must be called on the main UI thread.");
        if (this.zzdas) {
            zzbbd.e("Instream ad is destroyed already.");
            return null;
        }
        zzbgg zzbggVar = this.zzdaq;
        if (zzbggVar == null) {
            return null;
        }
        return zzbggVar.zzabu();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzrz();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzrz();
    }

    @Override // com.google.android.gms.internal.ads.zzagb
    public final void zza(IObjectWrapper iObjectWrapper, zzagd zzagdVar) {
        Preconditions.a("#008 Must be called on the main UI thread.");
        if (this.zzdas) {
            zzbbd.e("Instream ad is destroyed already.");
            zza(zzagdVar, 2);
            return;
        }
        if (this.zzdaq.zzabu() == null) {
            zzbbd.e("Instream internal error: can not get video controller.");
            zza(zzagdVar, 0);
            return;
        }
        if (this.zzdat) {
            zzbbd.e("Instream ad should not be used again.");
            zza(zzagdVar, 1);
            return;
        }
        this.zzdat = true;
        zzry();
        ((ViewGroup) ObjectWrapper.a(iObjectWrapper)).addView(this.zzdaq.getView(), new ViewGroup.LayoutParams(-1, -1));
        com.google.android.gms.ads.internal.zzbv.D();
        zzbct.zza(this.zzdaq.getView(), (ViewTreeObserver.OnGlobalLayoutListener) this);
        com.google.android.gms.ads.internal.zzbv.D();
        zzbct.zza(this.zzdaq.getView(), (ViewTreeObserver.OnScrollChangedListener) this);
        zzrz();
        try {
            zzagdVar.zztf();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final void zzb(zzacd zzacdVar) {
        this.zzdar = zzacdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final String zzrv() {
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final zzabm zzrw() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final View zzrx() {
        zzbgg zzbggVar = this.zzdaq;
        if (zzbggVar == null) {
            return null;
        }
        return zzbggVar.getView();
    }

    private static void zza(zzagd zzagdVar, int i) {
        try {
            zzagdVar.zzcl(i);
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }
}
