package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzark
/* loaded from: classes2.dex */
public final class zzaun extends zzaux {
    private final Context mContext;
    private final Object mLock;
    private final zzbbi zzbob;
    private final zzauo zzeeg;

    public zzaun(Context context, com.google.android.gms.ads.internal.zzv zzvVar, zzalg zzalgVar, zzbbi zzbbiVar) {
        this(context, zzbbiVar, new zzauo(context, zzvVar, zzwf.zzpo(), zzalgVar, zzbbiVar));
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void destroy() {
        zzg(null);
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final Bundle getAdMetadata() {
        Bundle adMetadata;
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcrk)).booleanValue()) {
            synchronized (this.mLock) {
                adMetadata = this.zzeeg.getAdMetadata();
            }
            return adMetadata;
        }
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final String getMediationAdapterClassName() {
        String mediationAdapterClassName;
        synchronized (this.mLock) {
            mediationAdapterClassName = this.zzeeg.getMediationAdapterClassName();
        }
        return mediationAdapterClassName;
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final boolean isLoaded() {
        boolean isLoaded;
        synchronized (this.mLock) {
            isLoaded = this.zzeeg.isLoaded();
        }
        return isLoaded;
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void pause() {
        zze(null);
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void resume() {
        zzf(null);
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void setAppPackageName(String str) throws RemoteException {
        Context context = this.mContext;
        if (context instanceof zzaum) {
            try {
                ((zzaum) context).setAppPackageName(str);
            } catch (PackageManager.NameNotFoundException unused) {
                if (Build.VERSION.SDK_INT > 15) {
                    throw new RemoteException(PackageManager.NameNotFoundException.class.getSimpleName());
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void setCustomData(String str) {
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcrl)).booleanValue()) {
            synchronized (this.mLock) {
                this.zzeeg.zzap(str);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void setImmersiveMode(boolean z) {
        synchronized (this.mLock) {
            this.zzeeg.setImmersiveMode(z);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void setUserId(String str) {
        synchronized (this.mLock) {
            this.zzeeg.setUserId(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void show() {
        synchronized (this.mLock) {
            this.zzeeg.zzxh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void zza(zzavh zzavhVar) {
        synchronized (this.mLock) {
            this.zzeeg.zza(zzavhVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final synchronized void zzd(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.mContext instanceof zzaum) {
            ((zzaum) this.mContext).zzf((Activity) ObjectWrapper.a(iObjectWrapper));
        }
        show();
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void zze(IObjectWrapper iObjectWrapper) {
        synchronized (this.mLock) {
            this.zzeeg.pause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void zzf(IObjectWrapper iObjectWrapper) {
        Context context;
        synchronized (this.mLock) {
            if (iObjectWrapper == null) {
                context = null;
            } else {
                try {
                    context = (Context) ObjectWrapper.a(iObjectWrapper);
                } catch (Exception e2) {
                    zzbbd.zzc("Unable to extract updated context.", e2);
                }
            }
            if (context != null) {
                this.zzeeg.onContextChanged(context);
            }
            this.zzeeg.resume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void zzg(IObjectWrapper iObjectWrapper) {
        synchronized (this.mLock) {
            this.zzeeg.destroy();
        }
    }

    @VisibleForTesting
    private zzaun(Context context, zzbbi zzbbiVar, zzauo zzauoVar) {
        this.mLock = new Object();
        this.mContext = context;
        this.zzbob = zzbbiVar;
        this.zzeeg = zzauoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void zza(zzavb zzavbVar) {
        synchronized (this.mLock) {
            this.zzeeg.zza(zzavbVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void zza(zzauu zzauuVar) {
        synchronized (this.mLock) {
            this.zzeeg.zza(zzauuVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void zza(zzxq zzxqVar) {
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcrk)).booleanValue()) {
            synchronized (this.mLock) {
                this.zzeeg.zza(zzxqVar);
            }
        }
    }
}
