package com.google.android.gms.analytics.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmp;
import java.lang.Thread;

/* loaded from: classes.dex */
public class zzf {

    /* renamed from: a, reason: collision with root package name */
    private static zzf f741a;
    private final Context b;
    private final Context c;
    private final zzmn d;
    private final zzr e;
    private final zzaf f;
    private final com.google.android.gms.measurement.zzg g;
    private final zzb h;
    private final zzv i;
    private final zzan j;
    private final zzai k;
    private final GoogleAnalytics l;
    private final zzn m;
    private final zza n;
    private final zzk o;
    private final zzu p;

    protected zzf(zzg zzgVar) {
        Context a2 = zzgVar.a();
        com.google.android.gms.common.internal.zzx.a(a2, "Application context can't be null");
        com.google.android.gms.common.internal.zzx.b(a2 instanceof Application, "getApplicationContext didn't return the application");
        Context b = zzgVar.b();
        com.google.android.gms.common.internal.zzx.a(b);
        this.b = a2;
        this.c = b;
        this.d = zzgVar.h(this);
        this.e = zzgVar.g(this);
        zzaf f = zzgVar.f(this);
        f.E();
        this.f = f;
        if (e().a()) {
            f().d("Google Analytics " + zze.f740a + " is starting up.");
        } else {
            f().d("Google Analytics " + zze.f740a + " is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4");
        }
        zzai q = zzgVar.q(this);
        q.E();
        this.k = q;
        zzan e = zzgVar.e(this);
        e.E();
        this.j = e;
        zzb l = zzgVar.l(this);
        zzn d = zzgVar.d(this);
        zza c = zzgVar.c(this);
        zzk b2 = zzgVar.b(this);
        zzu a3 = zzgVar.a(this);
        com.google.android.gms.measurement.zzg a4 = zzgVar.a(a2);
        a4.a(a());
        this.g = a4;
        GoogleAnalytics i = zzgVar.i(this);
        d.E();
        this.m = d;
        c.E();
        this.n = c;
        b2.E();
        this.o = b2;
        a3.E();
        this.p = a3;
        zzv p = zzgVar.p(this);
        p.E();
        this.i = p;
        l.E();
        this.h = l;
        if (e().a()) {
            f().b("Device AnalyticsService version", zze.f740a);
        }
        i.a();
        this.l = i;
        l.b();
    }

    public static zzf a(Context context) {
        com.google.android.gms.common.internal.zzx.a(context);
        if (f741a == null) {
            synchronized (zzf.class) {
                if (f741a == null) {
                    zzmn zzqt = zzmp.zzqt();
                    long elapsedRealtime = zzqt.elapsedRealtime();
                    zzf zzfVar = new zzf(new zzg(context.getApplicationContext()));
                    f741a = zzfVar;
                    GoogleAnalytics.d();
                    long elapsedRealtime2 = zzqt.elapsedRealtime() - elapsedRealtime;
                    long longValue = zzy.Q.a().longValue();
                    if (elapsedRealtime2 > longValue) {
                        zzfVar.f().c("Slow initialization (ms)", Long.valueOf(elapsedRealtime2), Long.valueOf(longValue));
                    }
                }
            }
        }
        return f741a;
    }

    private void a(zzd zzdVar) {
        com.google.android.gms.common.internal.zzx.a(zzdVar, "Analytics service not created/initialized");
        com.google.android.gms.common.internal.zzx.b(zzdVar.C(), "Analytics service not initialized");
    }

    protected Thread.UncaughtExceptionHandler a() {
        return new j(this);
    }

    public Context b() {
        return this.b;
    }

    public Context c() {
        return this.c;
    }

    public zzmn d() {
        return this.d;
    }

    public zzr e() {
        return this.e;
    }

    public zzaf f() {
        a(this.f);
        return this.f;
    }

    public zzaf g() {
        return this.f;
    }

    public com.google.android.gms.measurement.zzg h() {
        com.google.android.gms.common.internal.zzx.a(this.g);
        return this.g;
    }

    public zzb i() {
        a(this.h);
        return this.h;
    }

    public zzv j() {
        a(this.i);
        return this.i;
    }

    public GoogleAnalytics k() {
        com.google.android.gms.common.internal.zzx.a(this.l);
        com.google.android.gms.common.internal.zzx.b(this.l.c(), "Analytics instance not initialized");
        return this.l;
    }

    public zzan l() {
        a(this.j);
        return this.j;
    }

    public zzai m() {
        a(this.k);
        return this.k;
    }

    public zzai n() {
        if (this.k == null || !this.k.C()) {
            return null;
        }
        return this.k;
    }

    public zza o() {
        a(this.n);
        return this.n;
    }

    public zzn p() {
        a(this.m);
        return this.m;
    }

    public zzk q() {
        a(this.o);
        return this.o;
    }

    public zzu r() {
        return this.p;
    }

    public void s() {
        com.google.android.gms.measurement.zzg.d();
    }
}
