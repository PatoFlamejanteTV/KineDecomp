package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzhs;

@zzgr
/* loaded from: classes.dex */
public class zzge extends zzgc {
    private zzgd zzDt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzge(Context context, zzhs.zza zzaVar, zziz zzizVar, zzgg.zza zzaVar2) {
        super(context, zzaVar, zzizVar, zzaVar2);
    }

    @Override // com.google.android.gms.internal.zzgc
    protected void zzfs() {
        int i;
        int i2;
        AdSizeParcel zzaN = this.zzoM.zzaN();
        if (zzaN.e) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            i = displayMetrics.widthPixels;
            i2 = displayMetrics.heightPixels;
        } else {
            i = zzaN.g;
            i2 = zzaN.d;
        }
        this.zzDt = new zzgd(this, this.zzoM, i, i2);
        this.zzoM.zzhe().zza(this);
        this.zzDt.zza(this.zzDf);
    }

    @Override // com.google.android.gms.internal.zzgc
    protected int zzft() {
        if (!this.zzDt.zzfx()) {
            return !this.zzDt.zzfy() ? 2 : -2;
        }
        com.google.android.gms.ads.internal.util.client.zzb.a("Ad-Network indicated no fill with passback URL.");
        return 3;
    }
}
