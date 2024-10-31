package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmp;

/* loaded from: classes.dex */
public class zzg {

    /* renamed from: a */
    private final Context f742a;
    private final Context b;

    public zzg(Context context) {
        com.google.android.gms.common.internal.zzx.a(context);
        Context applicationContext = context.getApplicationContext();
        com.google.android.gms.common.internal.zzx.a(applicationContext, "Application context can't be null");
        this.f742a = applicationContext;
        this.b = applicationContext;
    }

    public Context a() {
        return this.f742a;
    }

    public zzu a(zzf zzfVar) {
        return new zzu(zzfVar);
    }

    public com.google.android.gms.measurement.zzg a(Context context) {
        return com.google.android.gms.measurement.zzg.a(context);
    }

    public Context b() {
        return this.b;
    }

    public zzk b(zzf zzfVar) {
        return new zzk(zzfVar);
    }

    public zza c(zzf zzfVar) {
        return new zza(zzfVar);
    }

    public zzn d(zzf zzfVar) {
        return new zzn(zzfVar);
    }

    public zzan e(zzf zzfVar) {
        return new zzan(zzfVar);
    }

    public zzaf f(zzf zzfVar) {
        return new zzaf(zzfVar);
    }

    public zzr g(zzf zzfVar) {
        return new zzr(zzfVar);
    }

    public zzmn h(zzf zzfVar) {
        return zzmp.zzqt();
    }

    public GoogleAnalytics i(zzf zzfVar) {
        return new GoogleAnalytics(zzfVar);
    }

    public o j(zzf zzfVar) {
        return new o(zzfVar, this);
    }

    public b k(zzf zzfVar) {
        return new b(zzfVar);
    }

    public zzb l(zzf zzfVar) {
        return new zzb(zzfVar, this);
    }

    public n m(zzf zzfVar) {
        return new n(zzfVar);
    }

    public c n(zzf zzfVar) {
        return new c(zzfVar);
    }

    public zzi o(zzf zzfVar) {
        return new zzi(zzfVar);
    }

    public zzv p(zzf zzfVar) {
        return new zzv(zzfVar);
    }

    public zzai q(zzf zzfVar) {
        return new zzai(zzfVar);
    }
}
