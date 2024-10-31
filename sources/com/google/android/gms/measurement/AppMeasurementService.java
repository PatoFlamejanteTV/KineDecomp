package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzey;
import com.google.android.gms.measurement.internal.zzfc;

/* loaded from: classes2.dex */
public final class AppMeasurementService extends Service implements zzfc {

    /* renamed from: a */
    private zzey<AppMeasurementService> f13603a;

    private final zzey<AppMeasurementService> a() {
        if (this.f13603a == null) {
            this.f13603a = new zzey<>(this);
        }
        return this.f13603a;
    }

    @Override // com.google.android.gms.measurement.internal.zzfc
    public final boolean callServiceStopSelfResult(int i) {
        return stopSelfResult(i);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return a().a(intent);
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        a().a();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        a().b();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        a().b(intent);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        return a().a(intent, i, i2);
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return a().c(intent);
    }

    @Override // com.google.android.gms.measurement.internal.zzfc
    public final void zza(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.measurement.internal.zzfc
    public final void a(Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }
}
