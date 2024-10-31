package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.internal.zzai;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzq extends O {

    /* renamed from: b, reason: collision with root package name */
    private Boolean f14081b;

    /* renamed from: c, reason: collision with root package name */
    private Wa f14082c;

    /* renamed from: d, reason: collision with root package name */
    private Boolean f14083d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzq(zzbw zzbwVar) {
        super(zzbwVar);
        this.f14082c = Va.f13707a;
        zzai.a(zzbwVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String m() {
        return zzai.o.a();
    }

    public static long p() {
        return zzai.R.a().longValue();
    }

    public static long q() {
        return zzai.r.a().longValue();
    }

    public static boolean s() {
        return zzai.n.a().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean u() {
        return zzai.na.a().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Wa wa) {
        this.f14082c = wa;
    }

    public final int b(String str, zzai.zza<Integer> zzaVar) {
        if (str == null) {
            return zzaVar.a().intValue();
        }
        String a2 = this.f14082c.a(str, zzaVar.b());
        if (TextUtils.isEmpty(a2)) {
            return zzaVar.a().intValue();
        }
        try {
            return zzaVar.a(Integer.valueOf(Integer.parseInt(a2))).intValue();
        } catch (NumberFormatException unused) {
            return zzaVar.a().intValue();
        }
    }

    public final boolean c(String str, zzai.zza<Boolean> zzaVar) {
        if (str == null) {
            return zzaVar.a().booleanValue();
        }
        String a2 = this.f14082c.a(str, zzaVar.b());
        if (TextUtils.isEmpty(a2)) {
            return zzaVar.a().booleanValue();
        }
        return zzaVar.a(Boolean.valueOf(Boolean.parseBoolean(a2))).booleanValue();
    }

    public final boolean d(String str, zzai.zza<Boolean> zzaVar) {
        return c(str, zzaVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean e(String str) {
        return c(str, zzai.ba);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean f(String str) {
        return c(str, zzai.da);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean g(String str) {
        return c(str, zzai.ea);
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean h(String str) {
        return c(str, zzai.fa);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean i(String str) {
        return c(str, zzai.ga);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean j(String str) {
        return c(str, zzai.ia);
    }

    public final boolean k() {
        if (this.f14083d == null) {
            synchronized (this) {
                if (this.f14083d == null) {
                    ApplicationInfo applicationInfo = getContext().getApplicationInfo();
                    String a2 = ProcessUtils.a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.f14083d = Boolean.valueOf(str != null && str.equals(a2));
                    }
                    if (this.f14083d == null) {
                        this.f14083d = Boolean.TRUE;
                        b().q().a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f14083d.booleanValue();
    }

    public final long l() {
        zzgw();
        return 14710L;
    }

    public final boolean n() {
        zzgw();
        Boolean b2 = b("firebase_analytics_collection_deactivated");
        return b2 != null && b2.booleanValue();
    }

    public final Boolean o() {
        zzgw();
        return b("firebase_analytics_collection_enabled");
    }

    public final String r() {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, "debug.firebase.analytics.app", "");
        } catch (ClassNotFoundException e2) {
            b().q().a("Could not find SystemProperties class", e2);
            return "";
        } catch (IllegalAccessException e3) {
            b().q().a("Could not access SystemProperties.get()", e3);
            return "";
        } catch (NoSuchMethodException e4) {
            b().q().a("Could not find SystemProperties.get() method", e4);
            return "";
        } catch (InvocationTargetException e5) {
            b().q().a("SystemProperties.get() threw an exception", e5);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean t() {
        if (this.f14081b == null) {
            this.f14081b = b("app_measurement_lite");
            if (this.f14081b == null) {
                this.f14081b = false;
            }
        }
        return this.f14081b.booleanValue() || !this.f13672a.A();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }

    public final int a(String str) {
        return b(str, zzai.C);
    }

    public final boolean d(String str) {
        return "1".equals(this.f14082c.a(str, "measurement.event_sampling_enabled"));
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ zzaa f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ zzaq g() {
        return super.g();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean l(String str) {
        return c(str, zzai.ka);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean m(String str) {
        return c(str, zzai.ma);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean p(String str) {
        return c(str, zzai.pa);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean q(String str) {
        return c(str, zzai.qa);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean s(String str) {
        return c(str, zzai.ta);
    }

    public final long a(String str, zzai.zza<Long> zzaVar) {
        if (str == null) {
            return zzaVar.a().longValue();
        }
        String a2 = this.f14082c.a(str, zzaVar.b());
        if (TextUtils.isEmpty(a2)) {
            return zzaVar.a().longValue();
        }
        try {
            return zzaVar.a(Long.valueOf(Long.parseLong(a2))).longValue();
        } catch (NumberFormatException unused) {
            return zzaVar.a().longValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean o(String str) {
        return c(str, zzai.oa);
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean n(String str) {
        return c(str, zzai.la);
    }

    public final boolean c(String str) {
        return "1".equals(this.f14082c.a(str, "gaia_collection_enabled"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final Boolean b(String str) {
        Preconditions.b(str);
        try {
            if (getContext().getPackageManager() == null) {
                b().q().a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo a2 = Wrappers.a(getContext()).a(getContext().getPackageName(), 128);
            if (a2 == null) {
                b().q().a("Failed to load metadata: ApplicationInfo is null");
                return null;
            }
            if (a2.metaData == null) {
                b().q().a("Failed to load metadata: Metadata bundle is null");
                return null;
            }
            if (a2.metaData.containsKey(str)) {
                return Boolean.valueOf(a2.metaData.getBoolean(str));
            }
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            b().q().a("Failed to load metadata: Package name not found", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean r(String str) {
        return c(str, zzai.ra);
    }

    public final boolean a(zzai.zza<Boolean> zzaVar) {
        return c(null, zzaVar);
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ Clock a() {
        return super.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean k(String str) {
        return c(str, zzai.ja);
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzas b() {
        return super.b();
    }
}
