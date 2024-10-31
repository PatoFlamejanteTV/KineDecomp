package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzal;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
@zzark
/* loaded from: classes2.dex */
public final class zzagi {
    private final Context mContext;
    private final com.google.android.gms.ads.internal.zzv zzbly;
    private final zzalg zzbma;
    private final zzbbi zzbob;

    public zzagi(Context context, zzalg zzalgVar, zzbbi zzbbiVar, com.google.android.gms.ads.internal.zzv zzvVar) {
        this.mContext = context;
        this.zzbma = zzalgVar;
        this.zzbob = zzbbiVar;
        this.zzbly = zzvVar;
    }

    @VisibleForTesting
    public final Context getApplicationContext() {
        return this.mContext.getApplicationContext();
    }

    @VisibleForTesting
    public final zzal zzbx(String str) {
        return new zzal(this.mContext, new zzwf(), str, this.zzbma, this.zzbob, this.zzbly);
    }

    @VisibleForTesting
    public final zzal zzby(String str) {
        return new zzal(this.mContext.getApplicationContext(), new zzwf(), str, this.zzbma, this.zzbob, this.zzbly);
    }

    @VisibleForTesting
    public final zzagi zztg() {
        return new zzagi(this.mContext.getApplicationContext(), this.zzbma, this.zzbob, this.zzbly);
    }
}
