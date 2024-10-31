package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqy;

/* loaded from: classes.dex */
public final class AnalyticsReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    static Object f680a = new Object();
    static zzqy b;
    static Boolean c;

    public static boolean a(Context context) {
        zzx.a(context);
        if (c != null) {
            return c.booleanValue();
        }
        boolean a2 = zzam.a(context, (Class<? extends BroadcastReceiver>) AnalyticsReceiver.class, false);
        c = Boolean.valueOf(a2);
        return a2;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        zzf a2 = zzf.a(context);
        zzaf f = a2.f();
        String action = intent.getAction();
        if (a2.e().a()) {
            f.a("Device AnalyticsReceiver got", action);
        } else {
            f.a("Local AnalyticsReceiver got", action);
        }
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            boolean a3 = AnalyticsService.a(context);
            Intent intent2 = new Intent(context, (Class<?>) AnalyticsService.class);
            intent2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            synchronized (f680a) {
                context.startService(intent2);
                if (a3) {
                    try {
                        if (b == null) {
                            b = new zzqy(context, 1, "Analytics WakeLock");
                            b.setReferenceCounted(false);
                        }
                        b.acquire(1000L);
                    } catch (SecurityException e) {
                        f.e("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                    }
                }
            }
        }
    }
}
