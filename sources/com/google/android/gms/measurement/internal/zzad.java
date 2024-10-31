package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.measurement.AppMeasurementReceiver;
import com.google.android.gms.measurement.AppMeasurementService;

/* loaded from: classes.dex */
public class zzad extends ac {

    /* renamed from: a */
    private boolean f2054a;
    private final AlarmManager b;

    public zzad(zzv zzvVar) {
        super(zzvVar);
        this.b = (AlarmManager) i().getSystemService("alarm");
    }

    private PendingIntent o() {
        Intent intent = new Intent(i(), (Class<?>) AppMeasurementReceiver.class);
        intent.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(i(), 0, intent, 0);
    }

    @Override // com.google.android.gms.measurement.internal.ac
    protected void a() {
        this.b.cancel(o());
    }

    public void a(long j) {
        x();
        zzx.b(j > 0);
        zzx.a(AppMeasurementReceiver.a(i()), "Receiver not registered/enabled");
        zzx.a(AppMeasurementService.a(i()), "Service not registered/enabled");
        b();
        long elapsedRealtime = h().elapsedRealtime() + j;
        this.f2054a = true;
        this.b.setInexactRepeating(2, elapsedRealtime, 86400000L, o());
    }

    public void b() {
        x();
        this.f2054a = false;
        this.b.cancel(o());
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ void e() {
        super.e();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzn f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzab g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzmn h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ Context i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzag j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzu k() {
        return super.k();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzp l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzs m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzc n() {
        return super.n();
    }
}
