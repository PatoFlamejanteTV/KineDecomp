package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;

@KeepForSdk
/* loaded from: classes.dex */
public class WakeLockTracker {

    /* renamed from: b */
    private static Boolean f11260b;

    /* renamed from: a */
    private static WakeLockTracker f11259a = new WakeLockTracker();

    /* renamed from: c */
    @VisibleForTesting
    private static boolean f11261c = false;

    @KeepForSdk
    public static WakeLockTracker a() {
        return f11259a;
    }

    private static boolean b() {
        if (f11260b == null) {
            f11260b = false;
        }
        return f11260b.booleanValue();
    }

    @KeepForSdk
    public void a(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list) {
        a(context, str, i, str2, str3, str4, i2, list, 0L);
    }

    @KeepForSdk
    public void a(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list, long j) {
        if (b()) {
            if (TextUtils.isEmpty(str)) {
                String valueOf = String.valueOf(str);
                Log.e("WakeLockTracker", valueOf.length() != 0 ? "missing wakeLock key. ".concat(valueOf) : new String("missing wakeLock key. "));
            } else if (7 == i || 8 == i || 10 == i || 11 == i) {
                a(context, new WakeLockEvent(System.currentTimeMillis(), i, str2, i2, StatsUtils.a(list), str, SystemClock.elapsedRealtime(), com.google.android.gms.common.util.zza.a(context), str3, StatsUtils.a(context.getPackageName()), com.google.android.gms.common.util.zza.b(context), j, str4, false));
            }
        }
    }

    private static void a(Context context, WakeLockEvent wakeLockEvent) {
        try {
            context.startService(new Intent().setComponent(LoggingConstants.f11243a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", wakeLockEvent));
        } catch (Exception e2) {
            Log.wtf("WakeLockTracker", e2);
        }
    }
}
