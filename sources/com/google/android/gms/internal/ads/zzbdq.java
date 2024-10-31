package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

@zzark
/* loaded from: classes2.dex */
public final class zzbdq {
    private final Context zzcnq;
    private final zzbdz zzerw;
    private final ViewGroup zzerx;
    private zzbdk zzery;

    public zzbdq(Context context, ViewGroup viewGroup, zzbgg zzbggVar) {
        this(context, viewGroup, zzbggVar, null);
    }

    public final void onDestroy() {
        Preconditions.a("onDestroy must be called from the UI thread.");
        zzbdk zzbdkVar = this.zzery;
        if (zzbdkVar != null) {
            zzbdkVar.destroy();
            this.zzerx.removeView(this.zzery);
            this.zzery = null;
        }
    }

    public final void onPause() {
        Preconditions.a("onPause must be called from the UI thread.");
        zzbdk zzbdkVar = this.zzery;
        if (zzbdkVar != null) {
            zzbdkVar.pause();
        }
    }

    public final void zza(int i, int i2, int i3, int i4, int i5, boolean z, zzbdy zzbdyVar) {
        if (this.zzery != null) {
            return;
        }
        zzaat.zza(this.zzerw.zzaby().zzrf(), this.zzerw.zzabv(), "vpr2");
        Context context = this.zzcnq;
        zzbdz zzbdzVar = this.zzerw;
        this.zzery = new zzbdk(context, zzbdzVar, i5, z, zzbdzVar.zzaby().zzrf(), zzbdyVar);
        this.zzerx.addView(this.zzery, 0, new ViewGroup.LayoutParams(-1, -1));
        this.zzery.zzd(i, i2, i3, i4);
        this.zzerw.zzat(false);
    }

    public final zzbdk zzabp() {
        Preconditions.a("getAdVideoUnderlay must be called from the UI thread.");
        return this.zzery;
    }

    public final void zze(int i, int i2, int i3, int i4) {
        Preconditions.a("The underlay may only be modified from the UI thread.");
        zzbdk zzbdkVar = this.zzery;
        if (zzbdkVar != null) {
            zzbdkVar.zzd(i, i2, i3, i4);
        }
    }

    @VisibleForTesting
    private zzbdq(Context context, ViewGroup viewGroup, zzbdz zzbdzVar, zzbdk zzbdkVar) {
        this.zzcnq = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzerx = viewGroup;
        this.zzerw = zzbdzVar;
        this.zzery = null;
    }
}
