package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class zzb extends zzd {

    /* renamed from: a */
    private final o f737a;

    public zzb(zzf zzfVar, zzg zzgVar) {
        super(zzfVar);
        com.google.android.gms.common.internal.zzx.a(zzgVar);
        this.f737a = zzgVar.j(zzfVar);
    }

    public long a(zzh zzhVar) {
        D();
        com.google.android.gms.common.internal.zzx.a(zzhVar);
        m();
        long a2 = this.f737a.a(zzhVar, true);
        if (a2 == 0) {
            this.f737a.a(zzhVar);
        }
        return a2;
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void a() {
        this.f737a.E();
    }

    public void a(zzab zzabVar) {
        com.google.android.gms.common.internal.zzx.a(zzabVar);
        D();
        b("Hit delivery requested", zzabVar);
        r().a(new g(this, zzabVar));
    }

    public void a(zzw zzwVar) {
        D();
        r().a(new h(this, zzwVar));
    }

    public void a(String str, Runnable runnable) {
        com.google.android.gms.common.internal.zzx.a(str, (Object) "campaign param can't be empty");
        r().a(new f(this, str, runnable));
    }

    public void a(boolean z) {
        a("Network connectivity status changed", Boolean.valueOf(z));
        r().a(new e(this, z));
    }

    public void b() {
        this.f737a.b();
    }

    public void c() {
        D();
        Context o = o();
        if (!AnalyticsReceiver.a(o) || !AnalyticsService.a(o)) {
            a((zzw) null);
            return;
        }
        Intent intent = new Intent(o, (Class<?>) AnalyticsService.class);
        intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        o.startService(intent);
    }

    public boolean d() {
        D();
        try {
            r().a(new i(this)).get(4L, TimeUnit.SECONDS);
            return true;
        } catch (InterruptedException e) {
            d("syncDispatchLocalHits interrupted", e);
            return false;
        } catch (ExecutionException e2) {
            e("syncDispatchLocalHits failed", e2);
            return false;
        } catch (TimeoutException e3) {
            d("syncDispatchLocalHits timed out", e3);
            return false;
        }
    }

    public void e() {
        D();
        com.google.android.gms.measurement.zzg.d();
        this.f737a.f();
    }

    public void f() {
        b("Radio powered up");
        c();
    }

    public void g() {
        m();
        this.f737a.e();
    }

    public void h() {
        m();
        this.f737a.d();
    }
}
