package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzdl;

/* loaded from: classes2.dex */
public final class zzfd extends Aa {

    /* renamed from: c, reason: collision with root package name */
    private Handler f14028c;

    /* renamed from: d, reason: collision with root package name */
    @VisibleForTesting
    private long f14029d;

    /* renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    private long f14030e;

    /* renamed from: f, reason: collision with root package name */
    private final _a f14031f;

    /* renamed from: g, reason: collision with root package name */
    private final _a f14032g;

    /* renamed from: h, reason: collision with root package name */
    private final _a f14033h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfd(zzbw zzbwVar) {
        super(zzbwVar);
        this.f14031f = new Da(this, this.f13672a);
        this.f14032g = new Ea(this, this.f13672a);
        this.f14033h = new Fa(this, this.f13672a);
        this.f14029d = a().c();
        this.f14030e = this.f14029d;
    }

    private final void A() {
        synchronized (this) {
            if (this.f14028c == null) {
                this.f14028c = new zzdl(Looper.getMainLooper());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        c();
        a(false, false);
        l().a(a().c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(long j) {
        c();
        A();
        b().y().a("Activity resumed, time", Long.valueOf(j));
        this.f14029d = j;
        this.f14030e = this.f14029d;
        if (j().q(n().z())) {
            a(a().a());
            return;
        }
        this.f14031f.a();
        this.f14032g.a();
        if (j().o(n().z()) || j().p(n().z())) {
            this.f14033h.a();
        }
        if (i().a(a().a())) {
            i().s.a(true);
            i().u.a(0L);
        }
        if (i().s.a()) {
            this.f14031f.a(Math.max(0L, i().q.a() - i().u.a()));
        } else {
            this.f14032g.a(Math.max(0L, 3600000 - i().u.a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(long j) {
        c();
        A();
        this.f14031f.a();
        this.f14032g.a();
        if (j().o(n().z()) || j().p(n().z())) {
            this.f14033h.a();
            this.f14033h.a(i().r.a());
        }
        b().y().a("Activity paused, time", Long.valueOf(j));
        if (this.f14029d != 0) {
            i().u.a(i().u.a() + (j - this.f14029d));
        }
    }

    private final void d(long j) {
        c();
        b().y().a("Session started, time", Long.valueOf(a().c()));
        Long valueOf = j().o(n().z()) ? Long.valueOf(j / 1000) : null;
        Long l = j().p(n().z()) ? -1L : null;
        m().a("auto", "_sid", valueOf, j);
        m().a("auto", "_sno", l, j);
        i().s.a(false);
        Bundle bundle = new Bundle();
        if (j().o(n().z())) {
            bundle.putLong("_sid", valueOf.longValue());
        }
        m().a("auto", "_s", j, bundle);
        i().t.a(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(long j) {
        c();
        A();
        a(j, false);
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
    public final /* bridge */ /* synthetic */ zza l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.C1417ga
    public final /* bridge */ /* synthetic */ zzda m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.C1417ga
    public final /* bridge */ /* synthetic */ zzam n() {
        return super.n();
    }

    @Override // com.google.android.gms.measurement.internal.C1417ga
    public final /* bridge */ /* synthetic */ zzdy p() {
        return super.p();
    }

    @Override // com.google.android.gms.measurement.internal.Aa
    protected final boolean v() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public final void y() {
        c();
        d(a().a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final long z() {
        long c2 = a().c();
        long j = c2 - this.f14030e;
        this.f14030e = c2;
        return j;
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(long j, boolean z) {
        c();
        A();
        this.f14031f.a();
        this.f14032g.a();
        if (j().o(n().z()) || j().p(n().z())) {
            this.f14033h.a();
        }
        if (i().a(j)) {
            i().s.a(true);
            i().u.a(0L);
        }
        if (i().s.a()) {
            d(j);
            return;
        }
        this.f14032g.a(Math.max(0L, 3600000 - i().u.a()));
        if (z && j().r(n().z())) {
            i().t.a(j);
            if (j().o(n().z()) || j().p(n().z())) {
                this.f14033h.a();
                this.f14033h.a(i().r.a());
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.C1417ga, com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    public final boolean a(boolean z, boolean z2) {
        c();
        t();
        long c2 = a().c();
        i().t.a(a().a());
        long j = c2 - this.f14029d;
        if (!z && j < 1000) {
            b().y().a("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j));
            return false;
        }
        i().u.a(j);
        b().y().a("Recording user engagement, ms", Long.valueOf(j));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j);
        zzdy.a(p().y(), bundle, true);
        if (j().s(n().z())) {
            if (j().d(n().z(), zzai.ua)) {
                if (!z2) {
                    z();
                }
            } else if (z2) {
                bundle.putLong("_fr", 1L);
            } else {
                z();
            }
        }
        if (!j().d(n().z(), zzai.ua) || !z2) {
            m().b("auto", "_e", bundle);
        }
        this.f14029d = c2;
        this.f14032g.a();
        this.f14032g.a(Math.max(0L, 3600000 - i().u.a()));
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzas b() {
        return super.b();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ Clock a() {
        return super.a();
    }
}
