package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;

@zzark
@TargetApi(17)
/* loaded from: classes2.dex */
public final class zzbam {
    private static zzbam zzenr;
    String zzeiz;

    private zzbam() {
    }

    public static zzbam zzaal() {
        if (zzenr == null) {
            zzenr = new zzbam();
        }
        return zzenr;
    }
}
