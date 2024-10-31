package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zza extends C1417ga {

    /* renamed from: b */
    private final Map<String, Long> f13884b;

    /* renamed from: c */
    private final Map<String, Integer> f13885c;

    /* renamed from: d */
    private long f13886d;

    public zza(zzbw zzbwVar) {
        super(zzbwVar);
        this.f13885c = new ArrayMap();
        this.f13884b = new ArrayMap();
    }

    public final void c(String str, long j) {
        d();
        c();
        Preconditions.b(str);
        if (this.f13885c.isEmpty()) {
            this.f13886d = j;
        }
        Integer num = this.f13885c.get(str);
        if (num != null) {
            this.f13885c.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (this.f13885c.size() >= 100) {
            b().t().a("Too many ads visible");
        } else {
            this.f13885c.put(str, 1);
            this.f13884b.put(str, Long.valueOf(j));
        }
    }

    public final void d(String str, long j) {
        d();
        c();
        Preconditions.b(str);
        Integer num = this.f13885c.get(str);
        if (num != null) {
            zzdx y = p().y();
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.f13885c.remove(str);
                Long l = this.f13884b.get(str);
                if (l == null) {
                    b().q().a("First ad unit exposure time was never set");
                } else {
                    long longValue = j - l.longValue();
                    this.f13884b.remove(str);
                    a(str, longValue, y);
                }
                if (this.f13885c.isEmpty()) {
                    long j2 = this.f13886d;
                    if (j2 == 0) {
                        b().q().a("First ad exposure time was never set");
                        return;
                    } else {
                        a(j - j2, y);
                        this.f13886d = 0L;
                        return;
                    }
                }
                return;
            }
            this.f13885c.put(str, Integer.valueOf(intValue));
            return;
        }
        b().q().a("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    public final void a(String str, long j) {
        if (str != null && str.length() != 0) {
            zzgs().a(new RunnableC1420i(this, str, j));
        } else {
            b().q().a("Ad unit id must be a non-empty string");
        }
    }

    public final void b(String str, long j) {
        if (str != null && str.length() != 0) {
            zzgs().a(new RunnableC1447w(this, str, j));
        } else {
            b().q().a("Ad unit id must be a non-empty string");
        }
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

    @Override // com.google.android.gms.measurement.internal.C1417ga
    public final /* bridge */ /* synthetic */ zzda m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.C1417ga
    public final /* bridge */ /* synthetic */ zzdy p() {
        return super.p();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }

    private final void a(long j, zzdx zzdxVar) {
        if (zzdxVar == null) {
            b().y().a("Not logging ad exposure. No active activity");
            return;
        }
        if (j < 1000) {
            b().y().a("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j);
        zzdy.a(zzdxVar, bundle, true);
        m().b("am", "_xa", bundle);
    }

    public final void b(long j) {
        Iterator<String> it = this.f13884b.keySet().iterator();
        while (it.hasNext()) {
            this.f13884b.put(it.next(), Long.valueOf(j));
        }
        if (this.f13884b.isEmpty()) {
            return;
        }
        this.f13886d = j;
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzas b() {
        return super.b();
    }

    @Override // com.google.android.gms.measurement.internal.C1417ga, com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    private final void a(String str, long j, zzdx zzdxVar) {
        if (zzdxVar == null) {
            b().y().a("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j < 1000) {
            b().y().a("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j);
        zzdy.a(zzdxVar, bundle, true);
        m().b("am", "_xu", bundle);
    }

    @Override // com.google.android.gms.measurement.internal.C1417ga, com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    public final void a(long j) {
        zzdx y = p().y();
        for (String str : this.f13884b.keySet()) {
            a(str, j - this.f13884b.get(str).longValue(), y);
        }
        if (!this.f13884b.isEmpty()) {
            a(j - this.f13886d, y);
        }
        b(j);
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ Clock a() {
        return super.a();
    }
}
