package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzdy extends Aa {

    /* renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    protected zzdx f14012c;

    /* renamed from: d, reason: collision with root package name */
    private volatile zzdx f14013d;

    /* renamed from: e, reason: collision with root package name */
    private zzdx f14014e;

    /* renamed from: f, reason: collision with root package name */
    private final Map<Activity, zzdx> f14015f;

    /* renamed from: g, reason: collision with root package name */
    private zzdx f14016g;

    /* renamed from: h, reason: collision with root package name */
    private String f14017h;

    public zzdy(zzbw zzbwVar) {
        super(zzbwVar);
        this.f14015f = new ArrayMap();
    }

    private final zzdx d(Activity activity) {
        Preconditions.a(activity);
        zzdx zzdxVar = this.f14015f.get(activity);
        if (zzdxVar != null) {
            return zzdxVar;
        }
        zzdx zzdxVar2 = new zzdx(null, a(activity.getClass().getCanonicalName()), h().r());
        this.f14015f.put(activity, zzdxVar2);
        return zzdxVar2;
    }

    public final void a(Activity activity, String str, String str2) {
        if (this.f14013d == null) {
            b().t().a("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (this.f14015f.get(activity) == null) {
            b().t().a("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = a(activity.getClass().getCanonicalName());
        }
        boolean equals = this.f14013d.f14009b.equals(str2);
        boolean d2 = zzfy.d(this.f14013d.f14008a, str);
        if (equals && d2) {
            b().v().a("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > 100)) {
            b().t().a("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > 100)) {
            b().t().a("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        b().y().a("Setting current screen to name, class", str == null ? "null" : str, str2);
        zzdx zzdxVar = new zzdx(str, str2, h().r());
        this.f14015f.put(activity, zzdxVar);
        a(activity, zzdxVar, true);
    }

    public final void b(Activity activity) {
        zzdx d2 = d(activity);
        this.f14014e = this.f14013d;
        this.f14013d = null;
        zzgs().a(new RunnableC1419ha(this, d2));
    }

    public final void c(Activity activity) {
        a(activity, d(activity), false);
        zza l = l();
        l.zzgs().a(new S(l, l.a().c()));
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
    public final /* bridge */ /* synthetic */ zzeb o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.C1417ga
    public final /* bridge */ /* synthetic */ zzfd r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.Aa
    protected final boolean v() {
        return false;
    }

    public final zzdx y() {
        t();
        c();
        return this.f14012c;
    }

    public final zzdx z() {
        d();
        return this.f14013d;
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }

    public final void b(Activity activity, Bundle bundle) {
        zzdx zzdxVar;
        if (bundle == null || (zzdxVar = this.f14015f.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", zzdxVar.f14010c);
        bundle2.putString("name", zzdxVar.f14008a);
        bundle2.putString("referrer_name", zzdxVar.f14009b);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    @Override // com.google.android.gms.measurement.internal.C1417ga, com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.C1417ga, com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzas b() {
        return super.b();
    }

    private final void a(Activity activity, zzdx zzdxVar, boolean z) {
        zzdx zzdxVar2 = this.f14013d == null ? this.f14014e : this.f14013d;
        if (zzdxVar.f14009b == null) {
            zzdxVar = new zzdx(zzdxVar.f14008a, a(activity.getClass().getCanonicalName()), zzdxVar.f14010c);
        }
        this.f14014e = this.f14013d;
        this.f14013d = zzdxVar;
        zzgs().a(new RunnableC1415fa(this, z, zzdxVar2, zzdxVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzdx zzdxVar, boolean z) {
        l().a(a().c());
        if (r().a(zzdxVar.f14011d, z)) {
            zzdxVar.f14011d = false;
        }
    }

    public static void a(zzdx zzdxVar, Bundle bundle, boolean z) {
        if (bundle != null && zzdxVar != null && (!bundle.containsKey("_sc") || z)) {
            String str = zzdxVar.f14008a;
            if (str != null) {
                bundle.putString("_sn", str);
            } else {
                bundle.remove("_sn");
            }
            bundle.putString("_sc", zzdxVar.f14009b);
            bundle.putLong("_si", zzdxVar.f14010c);
            return;
        }
        if (bundle != null && zzdxVar == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public final void a(String str, zzdx zzdxVar) {
        c();
        synchronized (this) {
            if (this.f14017h == null || this.f14017h.equals(str) || zzdxVar != null) {
                this.f14017h = str;
                this.f14016g = zzdxVar;
            }
        }
    }

    @VisibleForTesting
    private static String a(String str) {
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    public final void a(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.f14015f.put(activity, new zzdx(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final void a(Activity activity) {
        this.f14015f.remove(activity);
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ Clock a() {
        return super.a();
    }
}
