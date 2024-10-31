package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.internal.zzag;
import com.google.android.gms.measurement.internal.zzp;
import com.google.android.gms.measurement.internal.zzv;

/* loaded from: classes.dex */
public final class AppMeasurementReceiver extends BroadcastReceiver {

    /* renamed from: a */
    static final Object f2011a = new Object();
    static PowerManager.WakeLock b;
    static Boolean c;

    public static boolean a(Context context) {
        zzx.a(context);
        if (c != null) {
            return c.booleanValue();
        }
        boolean a2 = zzag.a(context, (Class<? extends BroadcastReceiver>) AppMeasurementReceiver.class, false);
        c = Boolean.valueOf(a2);
        return a2;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        zzv a2 = zzv.a(context);
        zzp f = a2.f();
        String action = intent.getAction();
        if (a2.d().z()) {
            f.t().a("Device AppMeasurementReceiver got", action);
        } else {
            f.t().a("Local AppMeasurementReceiver got", action);
        }
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            boolean a3 = AppMeasurementService.a(context);
            Intent intent2 = new Intent(context, (Class<?>) AppMeasurementService.class);
            intent2.setAction("com.google.android.gms.measurement.UPLOAD");
            synchronized (f2011a) {
                context.startService(intent2);
                if (a3) {
                    try {
                        PowerManager powerManager = (PowerManager) context.getSystemService("power");
                        if (b == null) {
                            b = powerManager.newWakeLock(1, "AppMeasurement WakeLock");
                            b.setReferenceCounted(false);
                        }
                        b.acquire(1000L);
                    } catch (SecurityException e) {
                        f.o().a("AppMeasurementService at risk of not starting. For more reliable app measurements, add the WAKE_LOCK permission to your manifest.");
                    }
                }
            }
        }
    }
}
