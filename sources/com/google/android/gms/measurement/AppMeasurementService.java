package com.google.android.gms.measurement;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.internal.zzag;
import com.google.android.gms.measurement.internal.zzp;
import com.google.android.gms.measurement.internal.zzv;
import com.google.android.gms.measurement.internal.zzw;

/* loaded from: classes.dex */
public final class AppMeasurementService extends Service {
    private static Boolean b;

    /* renamed from: a, reason: collision with root package name */
    private final Handler f2012a = new Handler();

    private void a() {
        try {
            synchronized (AppMeasurementReceiver.f2011a) {
                PowerManager.WakeLock wakeLock = AppMeasurementReceiver.b;
                if (wakeLock != null && wakeLock.isHeld()) {
                    wakeLock.release();
                }
            }
        } catch (SecurityException e) {
        }
    }

    public static boolean a(Context context) {
        zzx.a(context);
        if (b != null) {
            return b.booleanValue();
        }
        boolean a2 = zzag.a(context, (Class<? extends Service>) AppMeasurementService.class);
        b = Boolean.valueOf(a2);
        return a2;
    }

    private zzp b() {
        return zzv.a(this).f();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent == null) {
            b().b().a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzw(zzv.a(this));
        }
        b().o().a("onBind received unknown action", action);
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        zzv a2 = zzv.a(this);
        zzp f = a2.f();
        if (a2.d().z()) {
            f.t().a("Device AppMeasurementService is starting up");
        } else {
            f.t().a("Local AppMeasurementService is starting up");
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        zzv a2 = zzv.a(this);
        zzp f = a2.f();
        if (a2.d().z()) {
            f.t().a("Device AppMeasurementService is shutting down");
        } else {
            f.t().a("Local AppMeasurementService is shutting down");
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        if (intent == null) {
            b().b().a("onRebind called with null intent");
        } else {
            b().t().a("onRebind called. action", intent.getAction());
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        a();
        zzv a2 = zzv.a(this);
        zzp f = a2.f();
        String action = intent.getAction();
        if (a2.d().z()) {
            f.t().a("Device AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        } else {
            f.t().a("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        }
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            a2.g().a(new a(this, a2, i2, f));
        }
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        if (intent == null) {
            b().b().a("onUnbind called with null intent");
        } else {
            b().t().a("onUnbind called for intent. action", intent.getAction());
        }
        return true;
    }
}
