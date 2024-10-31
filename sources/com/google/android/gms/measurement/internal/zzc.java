package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmy;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzc extends ab {

    /* renamed from: a */
    static final String f2055a = String.valueOf(GoogleApiAvailability.f862a / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
    private Boolean b;

    public zzc(zzv zzvVar) {
        super(zzvVar);
    }

    public boolean A() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    ApplicationInfo applicationInfo = i().getApplicationInfo();
                    String zzj = zzmy.zzj(i(), Process.myPid());
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.b = Boolean.valueOf(str != null && str.equals(zzj));
                    }
                    if (this.b == null) {
                        this.b = Boolean.TRUE;
                        l().b().a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.b.booleanValue();
    }

    public long B() {
        return zzk.o.a().longValue();
    }

    public long C() {
        return zzk.k.a().longValue();
    }

    public long D() {
        return 20L;
    }

    public long E() {
        return Math.max(0L, zzk.e.a().longValue());
    }

    public int F() {
        return zzk.f.a().intValue();
    }

    public int G() {
        return Math.max(0, zzk.g.a().intValue());
    }

    public String H() {
        return zzk.h.a();
    }

    public long I() {
        return Math.max(0L, zzk.i.a().longValue());
    }

    public long J() {
        return Math.max(0L, zzk.j.a().longValue());
    }

    public long K() {
        return Math.max(0L, zzk.l.a().longValue());
    }

    public long L() {
        return Math.max(0L, zzk.m.a().longValue());
    }

    public int M() {
        return Math.min(20, Math.max(0, zzk.n.a().intValue()));
    }

    public String a() {
        return zzk.c.a();
    }

    public int b() {
        return 24;
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

    public int o() {
        return 36;
    }

    public int p() {
        return 36;
    }

    public int q() {
        return 20;
    }

    public long r() {
        return 3600000L;
    }

    public long s() {
        return 60000L;
    }

    public long t() {
        return 61000L;
    }

    public long u() {
        return zzk.d.a().longValue();
    }

    public long v() {
        return zzk.p.a().longValue();
    }

    public String w() {
        return "google_app_measurement.db";
    }

    public String x() {
        return "google_app_measurement2.db";
    }

    public long y() {
        return GoogleApiAvailability.f862a / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
    }

    public boolean z() {
        return zzd.f1003a;
    }
}
