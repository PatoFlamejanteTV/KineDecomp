package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzajw {
    private final Object mLock = new Object();
    private zzakd zzdka;

    public final zzakd zzb(Context context, zzbbi zzbbiVar) {
        zzakd zzakdVar;
        synchronized (this.mLock) {
            if (this.zzdka == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
                this.zzdka = new zzakd(context, zzbbiVar, (String) zzwu.zzpz().zzd(zzaan.zzcnw));
            }
            zzakdVar = this.zzdka;
        }
        return zzakdVar;
    }
}
