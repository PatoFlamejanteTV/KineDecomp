package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzfc;

/* loaded from: classes2.dex */
public final class zzey<T extends Context & zzfc> {

    /* renamed from: a */
    private final T f14027a;

    public zzey(T t) {
        Preconditions.a(t);
        this.f14027a = t;
    }

    public final void a() {
        zzbw a2 = zzbw.a(this.f14027a, (zzan) null);
        zzas b2 = a2.b();
        a2.zzgw();
        b2.y().a("Local AppMeasurementService is starting up");
    }

    public final void b() {
        zzbw a2 = zzbw.a(this.f14027a, (zzan) null);
        zzas b2 = a2.b();
        a2.zzgw();
        b2.y().a("Local AppMeasurementService is shutting down");
    }

    public final boolean c(Intent intent) {
        if (intent == null) {
            c().q().a("onUnbind called with null intent");
            return true;
        }
        c().y().a("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    private final zzas c() {
        return zzbw.a(this.f14027a, (zzan) null).b();
    }

    public final int a(Intent intent, int i, int i2) {
        zzbw a2 = zzbw.a(this.f14027a, (zzan) null);
        zzas b2 = a2.b();
        if (intent == null) {
            b2.t().a("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        a2.zzgw();
        b2.y().a("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            a(new Runnable(this, i2, b2, intent) { // from class: com.google.android.gms.measurement.internal.za

                /* renamed from: a, reason: collision with root package name */
                private final zzey f13880a;

                /* renamed from: b, reason: collision with root package name */
                private final int f13881b;

                /* renamed from: c, reason: collision with root package name */
                private final zzas f13882c;

                /* renamed from: d, reason: collision with root package name */
                private final Intent f13883d;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f13880a = this;
                    this.f13881b = i2;
                    this.f13882c = b2;
                    this.f13883d = intent;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f13880a.a(this.f13881b, this.f13882c, this.f13883d);
                }
            });
        }
        return 2;
    }

    public final void b(Intent intent) {
        if (intent == null) {
            c().q().a("onRebind called with null intent");
        } else {
            c().y().a("onRebind called. action", intent.getAction());
        }
    }

    private final void a(Runnable runnable) {
        zzfo a2 = zzfo.a(this.f14027a);
        a2.zzgs().a(new Ca(this, a2, runnable));
    }

    public final IBinder a(Intent intent) {
        if (intent == null) {
            c().q().a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzby(zzfo.a(this.f14027a));
        }
        c().t().a("onBind received unknown action", action);
        return null;
    }

    @TargetApi(24)
    public final boolean a(JobParameters jobParameters) {
        zzbw a2 = zzbw.a(this.f14027a, (zzan) null);
        zzas b2 = a2.b();
        String string = jobParameters.getExtras().getString(NativeProtocol.WEB_DIALOG_ACTION);
        a2.zzgw();
        b2.y().a("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        a(new Runnable(this, b2, jobParameters) { // from class: com.google.android.gms.measurement.internal.Ba

            /* renamed from: a, reason: collision with root package name */
            private final zzey f13612a;

            /* renamed from: b, reason: collision with root package name */
            private final zzas f13613b;

            /* renamed from: c, reason: collision with root package name */
            private final JobParameters f13614c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f13612a = this;
                this.f13613b = b2;
                this.f13614c = jobParameters;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13612a.a(this.f13613b, this.f13614c);
            }
        });
        return true;
    }

    public final /* synthetic */ void a(zzas zzasVar, JobParameters jobParameters) {
        zzasVar.y().a("AppMeasurementJobService processed last upload request.");
        this.f14027a.zza(jobParameters, false);
    }

    public final /* synthetic */ void a(int i, zzas zzasVar, Intent intent) {
        if (this.f14027a.callServiceStopSelfResult(i)) {
            zzasVar.y().a("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            c().y().a("Completed wakeful intent.");
            this.f14027a.a(intent);
        }
    }
}
