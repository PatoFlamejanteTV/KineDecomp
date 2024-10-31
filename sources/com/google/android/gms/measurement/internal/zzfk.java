package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import android.support.v4.app.NotificationCompat;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzdi;

/* loaded from: classes2.dex */
public final class zzfk extends La {

    /* renamed from: d, reason: collision with root package name */
    private final AlarmManager f14034d;

    /* renamed from: e, reason: collision with root package name */
    private final _a f14035e;

    /* renamed from: f, reason: collision with root package name */
    private Integer f14036f;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzfk(zzfo zzfoVar) {
        super(zzfoVar);
        this.f14034d = (AlarmManager) getContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.f14035e = new Ja(this, zzfoVar.p(), zzfoVar);
    }

    private final int s() {
        if (this.f14036f == null) {
            String valueOf = String.valueOf(getContext().getPackageName());
            this.f14036f = Integer.valueOf((valueOf.length() != 0 ? "measurement".concat(valueOf) : new String("measurement")).hashCode());
        }
        return this.f14036f.intValue();
    }

    private final PendingIntent t() {
        Context context = getContext();
        return PendingIntent.getBroadcast(context, 0, new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), 0);
    }

    @TargetApi(24)
    private final void u() {
        JobScheduler jobScheduler = (JobScheduler) getContext().getSystemService("jobscheduler");
        int s = s();
        b().y().a("Cancelling job. JobID", Integer.valueOf(s));
        jobScheduler.cancel(s);
    }

    public final void a(long j) {
        o();
        zzgw();
        Context context = getContext();
        if (!zzbm.a(context)) {
            b().x().a("Receiver not registered/enabled");
        }
        if (!zzfy.a(context, false)) {
            b().x().a("Service not registered/enabled");
        }
        r();
        long c2 = a().c() + j;
        if (j < Math.max(0L, zzai.L.a().longValue()) && !this.f14035e.c()) {
            b().y().a("Scheduling upload with DelayedRunnable");
            this.f14035e.a(j);
        }
        zzgw();
        if (Build.VERSION.SDK_INT >= 24) {
            b().y().a("Scheduling upload with JobScheduler");
            Context context2 = getContext();
            ComponentName componentName = new ComponentName(context2, "com.google.android.gms.measurement.AppMeasurementJobService");
            int s = s();
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "com.google.android.gms.measurement.UPLOAD");
            JobInfo build = new JobInfo.Builder(s, componentName).setMinimumLatency(j).setOverrideDeadline(j << 1).setExtras(persistableBundle).build();
            b().y().a("Scheduling job. JobID", Integer.valueOf(s));
            zzdi.zza(context2, build, "com.google.android.gms", "UploadAlarm");
            return;
        }
        b().y().a("Scheduling upload with AlarmManager");
        this.f14034d.setInexactRepeating(2, c2, Math.max(zzai.G.a().longValue(), j), t());
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzas b() {
        return super.b();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ zzaa f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ zzaq g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ zzfy h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ C1428m i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ zzq j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.Ka
    public final /* bridge */ /* synthetic */ zzfu k() {
        return super.k();
    }

    @Override // com.google.android.gms.measurement.internal.Ka
    public final /* bridge */ /* synthetic */ Xa m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.La
    protected final boolean p() {
        this.f14034d.cancel(t());
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        u();
        return false;
    }

    public final void r() {
        o();
        this.f14034d.cancel(t());
        this.f14035e.a();
        if (Build.VERSION.SDK_INT >= 24) {
            u();
        }
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ Clock a() {
        return super.a();
    }
}
