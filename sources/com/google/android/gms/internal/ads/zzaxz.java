package com.google.android.gms.internal.ads;

import android.util.Log;

@zzark
/* loaded from: classes2.dex */
public final class zzaxz extends zzbbd {
    public static void v(String str) {
        if (zzza()) {
            Log.v("Ads", str);
        }
    }

    public static boolean zzza() {
        if (zzbbd.isLoggable(2)) {
            return ((Boolean) zzwu.zzpz().zzd(zzaan.zzcss)).booleanValue();
        }
        return false;
    }
}
