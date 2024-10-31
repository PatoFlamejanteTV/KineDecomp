package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class zziy {
    private final Context mContext;
    private com.google.android.gms.ads.internal.overlay.zzk zzCo;
    private final ViewGroup zzJT;
    private final zziz zzoM;

    public zziy(Context context, ViewGroup viewGroup, zziz zzizVar) {
        this(context, viewGroup, zzizVar, null);
    }

    zziy(Context context, ViewGroup viewGroup, zziz zzizVar, com.google.android.gms.ads.internal.overlay.zzk zzkVar) {
        this.mContext = context;
        this.zzJT = viewGroup;
        this.zzoM = zzizVar;
        this.zzCo = zzkVar;
    }

    public void onDestroy() {
        com.google.android.gms.common.internal.zzx.b("onDestroy must be called from the UI thread.");
        if (this.zzCo != null) {
            this.zzCo.m();
        }
    }

    public void zza(int i, int i2, int i3, int i4, int i5) {
        if (this.zzCo != null) {
            return;
        }
        zzcc.zza(this.zzoM.zzhn().zzdm(), this.zzoM.zzhm(), "vpr");
        this.zzCo = new com.google.android.gms.ads.internal.overlay.zzk(this.mContext, this.zzoM, i5, this.zzoM.zzhn().zzdm(), zzcc.zzb(this.zzoM.zzhn().zzdm()));
        this.zzJT.addView(this.zzCo, 0, new ViewGroup.LayoutParams(-1, -1));
        this.zzCo.a(i, i2, i3, i4);
        this.zzoM.zzhe().zzF(false);
    }

    public void zze(int i, int i2, int i3, int i4) {
        com.google.android.gms.common.internal.zzx.b("The underlay may only be modified from the UI thread.");
        if (this.zzCo != null) {
            this.zzCo.a(i, i2, i3, i4);
        }
    }

    public com.google.android.gms.ads.internal.overlay.zzk zzgX() {
        com.google.android.gms.common.internal.zzx.b("getAdVideoUnderlay must be called from the UI thread.");
        return this.zzCo;
    }
}
