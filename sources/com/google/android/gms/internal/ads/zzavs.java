package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzark
/* loaded from: classes2.dex */
public final class zzavs extends zzawa {
    private volatile zzavt zzeeq;
    private volatile zzavq zzefe;
    private volatile zzavr zzeff;
    private volatile zzavx zzefg;

    public zzavs(zzavr zzavrVar) {
        this.zzeff = zzavrVar;
    }

    public final void zza(zzavq zzavqVar) {
        this.zzefe = zzavqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzavz
    public final void zzc(IObjectWrapper iObjectWrapper, int i) {
        if (this.zzefe != null) {
            this.zzefe.zzct(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavz
    public final void zzd(IObjectWrapper iObjectWrapper, int i) {
        if (this.zzeeq != null) {
            this.zzeeq.zza(ObjectWrapper.a(iObjectWrapper).getClass().getName(), i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavz
    public final void zzs(IObjectWrapper iObjectWrapper) {
        if (this.zzefe != null) {
            this.zzefe.zzxl();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavz
    public final void zzt(IObjectWrapper iObjectWrapper) {
        if (this.zzeeq != null) {
            this.zzeeq.zzde(ObjectWrapper.a(iObjectWrapper).getClass().getName());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavz
    public final void zzu(IObjectWrapper iObjectWrapper) {
        if (this.zzeff != null) {
            this.zzeff.onRewardedVideoAdOpened();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavz
    public final void zzv(IObjectWrapper iObjectWrapper) {
        if (this.zzeff != null) {
            this.zzeff.onRewardedVideoStarted();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavz
    public final void zzw(IObjectWrapper iObjectWrapper) {
        if (this.zzeff != null) {
            this.zzeff.onRewardedVideoAdClosed();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavz
    public final void zzx(IObjectWrapper iObjectWrapper) {
        if (this.zzeff != null) {
            this.zzeff.zzkh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavz
    public final void zzy(IObjectWrapper iObjectWrapper) {
        if (this.zzeff != null) {
            this.zzeff.onRewardedVideoAdLeftApplication();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavz
    public final void zzz(IObjectWrapper iObjectWrapper) {
        if (this.zzeff != null) {
            this.zzeff.onRewardedVideoCompleted();
        }
    }

    public final void zza(zzavt zzavtVar) {
        this.zzeeq = zzavtVar;
    }

    public final void zza(zzavx zzavxVar) {
        this.zzefg = zzavxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzavz
    public final void zzc(Bundle bundle) {
        if (this.zzefg != null) {
            this.zzefg.zzc(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavz
    public final void zza(IObjectWrapper iObjectWrapper, zzawd zzawdVar) {
        if (this.zzeff != null) {
            this.zzeff.zzc(zzawdVar);
        }
    }
}
