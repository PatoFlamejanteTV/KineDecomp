package com.google.android.gms.analytics.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.analytics.AnalyticsReceiver;

/* loaded from: classes.dex */
public class zzv extends zzd {

    /* renamed from: a */
    private boolean f750a;
    private boolean b;
    private AlarmManager c;

    public zzv(zzf zzfVar) {
        super(zzfVar);
        this.c = (AlarmManager) o().getSystemService("alarm");
    }

    private PendingIntent f() {
        Intent intent = new Intent(o(), (Class<?>) AnalyticsReceiver.class);
        intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        return PendingIntent.getBroadcast(o(), 0, intent, 0);
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void a() {
        ActivityInfo receiverInfo;
        try {
            this.c.cancel(f());
            if (q().j() <= 0 || (receiverInfo = o().getPackageManager().getReceiverInfo(new ComponentName(o(), (Class<?>) AnalyticsReceiver.class), 2)) == null || !receiverInfo.enabled) {
                return;
            }
            b("Receiver registered. Using alarm for local dispatch.");
            this.f750a = true;
        } catch (PackageManager.NameNotFoundException e) {
        }
    }

    public boolean b() {
        return this.f750a;
    }

    public boolean c() {
        return this.b;
    }

    public void d() {
        D();
        com.google.android.gms.common.internal.zzx.a(b(), "Receiver not registered");
        long j = q().j();
        if (j > 0) {
            e();
            long elapsedRealtime = n().elapsedRealtime() + j;
            this.b = true;
            this.c.setInexactRepeating(2, elapsedRealtime, 0L, f());
        }
    }

    public void e() {
        D();
        this.b = false;
        this.c.cancel(f());
    }
}
