package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;

/* loaded from: classes.dex */
public final class zzmr {
    private static IntentFilter zzail = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    public static int zzao(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, zzail);
        return ((zzmx.zzqC() ? ((PowerManager) context.getSystemService("power")).isInteractive() : ((PowerManager) context.getSystemService("power")).isScreenOn() ? 1 : 0) << 1) | (((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0 ? 1 : 0);
    }

    public static float zzap(Context context) {
        if (context.getApplicationContext().registerReceiver(null, zzail) == null) {
            return Float.NaN;
        }
        return r1.getIntExtra("level", -1) / r1.getIntExtra("scale", -1);
    }
}
