package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.internal.zzmn;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class zzf extends ac {

    /* renamed from: a */
    private long f2056a;
    private String b;

    public zzf(zzv zzvVar) {
        super(zzvVar);
    }

    @Override // com.google.android.gms.measurement.internal.ac
    protected void a() {
        Calendar calendar = Calendar.getInstance();
        this.f2056a = TimeUnit.MINUTES.convert(calendar.get(16) + calendar.get(15), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        this.b = locale.getLanguage().toLowerCase(Locale.ENGLISH) + "-" + locale.getCountry().toLowerCase(Locale.ENGLISH);
    }

    public String b() {
        x();
        return Build.MODEL;
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

    public String o() {
        x();
        return Build.VERSION.RELEASE;
    }

    public long p() {
        x();
        return this.f2056a;
    }

    public String q() {
        x();
        return this.b;
    }
}
