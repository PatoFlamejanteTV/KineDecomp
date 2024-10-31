package com.google.android.gms.internal.ads;

import android.content.Context;

@zzark
/* loaded from: classes2.dex */
public final class zzaxx {
    public static void zzag(Context context) {
        if (zzbax.zzbl(context) && !zzbax.zzaau()) {
            zzbcb zzbcbVar = (zzbcb) new C1093td(context).zzwa();
            zzbbd.zzen("Updating ad debug logging enablement.");
            zzbbo.zza(zzbcbVar, "AdDebugLogUpdater.updateEnablement");
        }
    }
}
