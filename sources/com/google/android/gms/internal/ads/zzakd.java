package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzakd {

    @VisibleForTesting
    private static final zzazn<zzaii> zzdke = new C0839bb();

    @VisibleForTesting
    private static final zzazn<zzaii> zzdkf = new C0854cb();
    private final zzait zzdkg;

    public zzakd(Context context, zzbbi zzbbiVar, String str) {
        this.zzdkg = new zzait(context, zzbbiVar, str, zzdke, zzdkf);
    }

    public final <I, O> zzajv<I, O> zza(String str, zzajy<I> zzajyVar, zzajx<O> zzajxVar) {
        return new zzakg(this.zzdkg, str, zzajyVar, zzajxVar);
    }
}
