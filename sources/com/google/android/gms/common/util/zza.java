package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

/* loaded from: classes.dex */
public final class zza {

    /* renamed from: b */
    private static long f11302b;

    /* renamed from: a */
    private static final IntentFilter f11301a = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    /* renamed from: c */
    private static float f11303c = Float.NaN;

    @TargetApi(20)
    public static int a(Context context) {
        boolean isScreenOn;
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, f11301a);
        int i = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0 ? 1 : 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        if (PlatformVersion.g()) {
            isScreenOn = powerManager.isInteractive();
        } else {
            isScreenOn = powerManager.isScreenOn();
        }
        return (isScreenOn ? 2 : 0) | i;
    }

    public static synchronized float b(Context context) {
        synchronized (zza.class) {
            if (SystemClock.elapsedRealtime() - f11302b < 60000 && !Float.isNaN(f11303c)) {
                return f11303c;
            }
            if (context.getApplicationContext().registerReceiver(null, f11301a) != null) {
                f11303c = r6.getIntExtra("level", -1) / r6.getIntExtra("scale", -1);
            }
            f11302b = SystemClock.elapsedRealtime();
            return f11303c;
        }
    }
}
