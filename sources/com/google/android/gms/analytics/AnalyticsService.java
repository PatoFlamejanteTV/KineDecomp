package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqy;

/* loaded from: classes.dex */
public final class AnalyticsService extends Service {
    private static Boolean b;

    /* renamed from: a, reason: collision with root package name */
    private final Handler f681a = new Handler();

    private void a() {
        try {
            synchronized (AnalyticsReceiver.f680a) {
                zzqy zzqyVar = AnalyticsReceiver.b;
                if (zzqyVar != null && zzqyVar.isHeld()) {
                    zzqyVar.release();
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
        boolean a2 = zzam.a(context, (Class<? extends Service>) AnalyticsService.class);
        b = Boolean.valueOf(a2);
        return a2;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        zzf a2 = zzf.a(this);
        zzaf f = a2.f();
        if (a2.e().a()) {
            f.b("Device AnalyticsService is starting up");
        } else {
            f.b("Local AnalyticsService is starting up");
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        zzf a2 = zzf.a(this);
        zzaf f = a2.f();
        if (a2.e().a()) {
            f.b("Device AnalyticsService is shutting down");
        } else {
            f.b("Local AnalyticsService is shutting down");
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        a();
        zzf a2 = zzf.a(this);
        zzaf f = a2.f();
        String action = intent.getAction();
        if (a2.e().a()) {
            f.a("Device AnalyticsService called. startId, action", Integer.valueOf(i2), action);
        } else {
            f.a("Local AnalyticsService called. startId, action", Integer.valueOf(i2), action);
        }
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            a2.i().a((zzw) new a(this, i2, a2, f));
        }
        return 2;
    }
}
