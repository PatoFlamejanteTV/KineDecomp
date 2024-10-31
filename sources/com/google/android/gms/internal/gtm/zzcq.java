package com.google.android.gms.internal.gtm;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.gtm.zzcu;
import com.google.android.gms.stats.WakeLock;

/* loaded from: classes2.dex */
public final class zzcq<T extends Context & zzcu> {
    private static Boolean zzacd;
    private final Handler handler;
    private final T zzacc;

    public zzcq(T t) {
        Preconditions.a(t);
        this.zzacc = t;
        this.handler = new zzdj();
    }

    private final void zzb(Runnable runnable) {
        zzap.zzc(this.zzacc).zzcs().zza(new H(this, runnable));
    }

    public static boolean zze(Context context) {
        Preconditions.a(context);
        Boolean bool = zzacd;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean zzc = zzcz.zzc(context, "com.google.android.gms.analytics.AnalyticsService");
        zzacd = Boolean.valueOf(zzc);
        return zzc;
    }

    public final void onCreate() {
        zzap.zzc(this.zzacc).zzco().zzq("Local AnalyticsService is starting up");
    }

    public final void onDestroy() {
        zzap.zzc(this.zzacc).zzco().zzq("Local AnalyticsService is shutting down");
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        try {
            synchronized (zzcp.lock) {
                WakeLock wakeLock = zzcp.zzacb;
                if (wakeLock != null && wakeLock.a()) {
                    wakeLock.b();
                }
            }
        } catch (SecurityException unused) {
        }
        zzci zzco = zzap.zzc(this.zzacc).zzco();
        if (intent == null) {
            zzco.zzt("AnalyticsService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzco.zza("Local AnalyticsService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            zzb(new Runnable(this, i2, zzco) { // from class: com.google.android.gms.internal.gtm.F

                /* renamed from: a, reason: collision with root package name */
                private final zzcq f13145a;

                /* renamed from: b, reason: collision with root package name */
                private final int f13146b;

                /* renamed from: c, reason: collision with root package name */
                private final zzci f13147c;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f13145a = this;
                    this.f13146b = i2;
                    this.f13147c = zzco;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f13145a.zza(this.f13146b, this.f13147c);
                }
            });
        }
        return 2;
    }

    @TargetApi(24)
    public final boolean onStartJob(JobParameters jobParameters) {
        zzci zzco = zzap.zzc(this.zzacc).zzco();
        String string = jobParameters.getExtras().getString(NativeProtocol.WEB_DIALOG_ACTION);
        zzco.zza("Local AnalyticsJobService called. action", string);
        if (!"com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(string)) {
            return true;
        }
        zzb(new Runnable(this, zzco, jobParameters) { // from class: com.google.android.gms.internal.gtm.G

            /* renamed from: a, reason: collision with root package name */
            private final zzcq f13148a;

            /* renamed from: b, reason: collision with root package name */
            private final zzci f13149b;

            /* renamed from: c, reason: collision with root package name */
            private final JobParameters f13150c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f13148a = this;
                this.f13149b = zzco;
                this.f13150c = jobParameters;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13148a.zza(this.f13149b, this.f13150c);
            }
        });
        return true;
    }

    public final /* synthetic */ void zza(zzci zzciVar, JobParameters jobParameters) {
        zzciVar.zzq("AnalyticsJobService processed last dispatch request");
        this.zzacc.zza(jobParameters, false);
    }

    public final /* synthetic */ void zza(int i, zzci zzciVar) {
        if (this.zzacc.callServiceStopSelfResult(i)) {
            zzciVar.zzq("Local AnalyticsService processed last dispatch request");
        }
    }
}
