package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.stats.zzc;
import com.google.android.gms.internal.zzmm;
import com.google.android.gms.internal.zzmr;
import java.util.List;

/* loaded from: classes.dex */
public class zzi {

    /* renamed from: a, reason: collision with root package name */
    private static String f1046a = "WakeLockTracker";
    private static zzi b = new zzi();
    private static Integer c;

    public static zzi a() {
        return b;
    }

    private static boolean a(Context context) {
        if (c == null) {
            c = Integer.valueOf(b());
        }
        return c.intValue() != zzd.b;
    }

    private static int b() {
        try {
            return zzmm.zzjA() ? zzc.zzb.f1043a.get().intValue() : zzd.b;
        } catch (SecurityException e) {
            return zzd.b;
        }
    }

    public void a(Context context, String str, int i, String str2, String str3, int i2, List<String> list) {
        a(context, str, i, str2, str3, i2, list, 0L);
    }

    public void a(Context context, String str, int i, String str2, String str3, int i2, List<String> list, long j) {
        if (a(context)) {
            if (TextUtils.isEmpty(str)) {
                Log.e(f1046a, "missing wakeLock key. " + str);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (7 == i || 8 == i || 10 == i || 11 == i) {
                try {
                    context.startService(new Intent().setComponent(zzd.f1044a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", new WakeLockEvent(currentTimeMillis, i, str2, i2, list, str, SystemClock.elapsedRealtime(), zzmr.zzao(context), str3, context.getPackageName(), zzmr.zzap(context), j)));
                } catch (Exception e) {
                    Log.wtf(f1046a, e);
                }
            }
        }
    }
}
