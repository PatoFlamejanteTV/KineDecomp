package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzsi;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class zzbw implements Q {

    /* renamed from: a, reason: collision with root package name */
    private static volatile zzbw f13978a;
    private long A;
    private volatile Boolean B;

    @VisibleForTesting
    private Boolean C;

    @VisibleForTesting
    private Boolean D;
    private int E;
    private final long G;

    /* renamed from: b, reason: collision with root package name */
    private final Context f13979b;

    /* renamed from: c, reason: collision with root package name */
    private final String f13980c;

    /* renamed from: d, reason: collision with root package name */
    private final String f13981d;

    /* renamed from: e, reason: collision with root package name */
    private final String f13982e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f13983f;

    /* renamed from: g, reason: collision with root package name */
    private final zzn f13984g;

    /* renamed from: h, reason: collision with root package name */
    private final zzq f13985h;
    private final C1428m i;
    private final zzas j;
    private final zzbr k;
    private final zzfd l;
    private final AppMeasurement m;
    private final zzfy n;
    private final zzaq o;
    private final Clock p;
    private final zzdy q;
    private final zzda r;
    private final zza s;
    private zzao t;
    private zzeb u;
    private zzaa v;
    private zzam w;
    private zzbj x;
    private Boolean z;
    private boolean y = false;
    private AtomicInteger F = new AtomicInteger(0);

    private zzbw(zzcz zzczVar) {
        Bundle bundle;
        Preconditions.a(zzczVar);
        this.f13984g = new zzn(zzczVar.f13995a);
        zzai.a(this.f13984g);
        this.f13979b = zzczVar.f13995a;
        this.f13980c = zzczVar.f13996b;
        this.f13981d = zzczVar.f13997c;
        this.f13982e = zzczVar.f13998d;
        this.f13983f = zzczVar.f13999e;
        this.B = zzczVar.f14000f;
        zzan zzanVar = zzczVar.f14001g;
        if (zzanVar != null && (bundle = zzanVar.f13926g) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.C = (Boolean) obj;
            }
            Object obj2 = zzanVar.f13926g.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.D = (Boolean) obj2;
            }
        }
        zzsi.zzae(this.f13979b);
        this.p = DefaultClock.d();
        this.G = this.p.a();
        this.f13985h = new zzq(this);
        C1428m c1428m = new C1428m(this);
        c1428m.p();
        this.i = c1428m;
        zzas zzasVar = new zzas(this);
        zzasVar.p();
        this.j = zzasVar;
        zzfy zzfyVar = new zzfy(this);
        zzfyVar.p();
        this.n = zzfyVar;
        zzaq zzaqVar = new zzaq(this);
        zzaqVar.p();
        this.o = zzaqVar;
        this.s = new zza(this);
        zzdy zzdyVar = new zzdy(this);
        zzdyVar.x();
        this.q = zzdyVar;
        zzda zzdaVar = new zzda(this);
        zzdaVar.x();
        this.r = zzdaVar;
        this.m = new AppMeasurement(this);
        zzfd zzfdVar = new zzfd(this);
        zzfdVar.x();
        this.l = zzfdVar;
        zzbr zzbrVar = new zzbr(this);
        zzbrVar.p();
        this.k = zzbrVar;
        zzn zznVar = this.f13984g;
        if (this.f13979b.getApplicationContext() instanceof Application) {
            zzda h2 = h();
            if (h2.getContext().getApplicationContext() instanceof Application) {
                Application application = (Application) h2.getContext().getApplicationContext();
                if (h2.f14002c == null) {
                    h2.f14002c = new C1411da(h2, null);
                }
                application.unregisterActivityLifecycleCallbacks(h2.f14002c);
                application.registerActivityLifecycleCallbacks(h2.f14002c);
                h2.b().y().a("Registered activity lifecycle callback");
            }
        } else {
            b().t().a("Application context is not an Application");
        }
        this.k.a(new RunnableC1443u(this, zzczVar));
    }

    private final void F() {
        if (!this.y) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzcz zzczVar) {
        zzau w;
        String concat;
        zzgs().c();
        zzq.m();
        zzaa zzaaVar = new zzaa(this);
        zzaaVar.p();
        this.v = zzaaVar;
        zzam zzamVar = new zzam(this);
        zzamVar.x();
        this.w = zzamVar;
        zzao zzaoVar = new zzao(this);
        zzaoVar.x();
        this.t = zzaoVar;
        zzeb zzebVar = new zzeb(this);
        zzebVar.x();
        this.u = zzebVar;
        this.n.m();
        this.i.m();
        this.x = new zzbj(this);
        this.w.u();
        b().w().a("App measurement is starting up, version", Long.valueOf(this.f13985h.l()));
        zzn zznVar = this.f13984g;
        b().w().a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        zzn zznVar2 = this.f13984g;
        String z = zzamVar.z();
        if (TextUtils.isEmpty(this.f13980c)) {
            if (p().e(z)) {
                w = b().w();
                concat = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                w = b().w();
                String valueOf = String.valueOf(z);
                concat = valueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(valueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
            }
            w.a(concat);
        }
        b().x().a("Debug-level message logging enabled");
        if (this.E != this.F.get()) {
            b().q().a("Not all components initialized", Integer.valueOf(this.E), Integer.valueOf(this.F.get()));
        }
        this.y = true;
    }

    public final boolean A() {
        return this.f13983f;
    }

    public final boolean B() {
        return this.B != null && this.B.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long C() {
        Long valueOf = Long.valueOf(q().k.a());
        if (valueOf.longValue() == 0) {
            return this.G;
        }
        return Math.min(this.G, valueOf.longValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void D() {
        this.F.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean E() {
        F();
        zzgs().c();
        Boolean bool = this.z;
        if (bool == null || this.A == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.p.c() - this.A) > 1000)) {
            this.A = this.p.c();
            zzn zznVar = this.f13984g;
            boolean z = true;
            this.z = Boolean.valueOf(p().f("android.permission.INTERNET") && p().f("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.a(this.f13979b).a() || this.f13985h.t() || (zzbm.a(this.f13979b) && zzfy.a(this.f13979b, false))));
            if (this.z.booleanValue()) {
                if (!p().c(i().y(), i().A()) && TextUtils.isEmpty(i().A())) {
                    z = false;
                }
                this.z = Boolean.valueOf(z);
            }
        }
        return this.z.booleanValue();
    }

    @Override // com.google.android.gms.measurement.internal.Q
    public final zzas b() {
        b(this.j);
        return this.j;
    }

    public final boolean c() {
        boolean z;
        zzgs().c();
        F();
        if (this.f13985h.a(zzai.wa)) {
            if (this.f13985h.n()) {
                return false;
            }
            Boolean bool = this.D;
            if (bool != null && bool.booleanValue()) {
                return false;
            }
            Boolean u = q().u();
            if (u != null) {
                return u.booleanValue();
            }
            Boolean o = this.f13985h.o();
            if (o != null) {
                return o.booleanValue();
            }
            Boolean bool2 = this.C;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
            if (GoogleServices.b()) {
                return false;
            }
            if (!this.f13985h.a(zzai.sa) || this.B == null) {
                return true;
            }
            return this.B.booleanValue();
        }
        if (this.f13985h.n()) {
            return false;
        }
        Boolean o2 = this.f13985h.o();
        if (o2 != null) {
            z = o2.booleanValue();
        } else {
            z = !GoogleServices.b();
            if (z && this.B != null && zzai.sa.a().booleanValue()) {
                z = this.B.booleanValue();
            }
        }
        return q().c(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d() {
        zzgs().c();
        if (q().f13800f.a() == 0) {
            q().f13800f.a(this.p.a());
        }
        if (Long.valueOf(q().k.a()).longValue() == 0) {
            b().y().a("Persisting first open", Long.valueOf(this.G));
            q().k.a(this.G);
        }
        if (!E()) {
            if (c()) {
                if (!p().f("android.permission.INTERNET")) {
                    b().q().a("App is missing INTERNET permission");
                }
                if (!p().f("android.permission.ACCESS_NETWORK_STATE")) {
                    b().q().a("App is missing ACCESS_NETWORK_STATE permission");
                }
                zzn zznVar = this.f13984g;
                if (!Wrappers.a(this.f13979b).a() && !this.f13985h.t()) {
                    if (!zzbm.a(this.f13979b)) {
                        b().q().a("AppMeasurementReceiver not registered/enabled");
                    }
                    if (!zzfy.a(this.f13979b, false)) {
                        b().q().a("AppMeasurementService not registered/enabled");
                    }
                }
                b().q().a("Uploading is not possible. App measurement disabled");
                return;
            }
            return;
        }
        zzn zznVar2 = this.f13984g;
        if (!TextUtils.isEmpty(i().y()) || !TextUtils.isEmpty(i().A())) {
            p();
            if (zzfy.a(i().y(), q().q(), i().A(), q().r())) {
                b().w().a("Rechecking which service to use due to a GMP App Id change");
                q().t();
                l().y();
                this.u.y();
                this.u.A();
                q().k.a(this.G);
                q().m.a(null);
            }
            q().c(i().y());
            q().d(i().A());
            if (this.f13985h.q(i().z())) {
                this.l.a(this.G);
            }
        }
        h().a(q().m.a());
        zzn zznVar3 = this.f13984g;
        if (TextUtils.isEmpty(i().y()) && TextUtils.isEmpty(i().A())) {
            return;
        }
        boolean c2 = c();
        if (!q().x() && !this.f13985h.n()) {
            q().d(!c2);
        }
        if (!this.f13985h.i(i().z()) || c2) {
            h().C();
        }
        j().a(new AtomicReference<>());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        zzn zznVar = this.f13984g;
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f() {
        zzn zznVar = this.f13984g;
    }

    public final zza g() {
        zza zzaVar = this.s;
        if (zzaVar != null) {
            return zzaVar;
        }
        throw new IllegalStateException("Component not created");
    }

    @Override // com.google.android.gms.measurement.internal.Q
    public final Context getContext() {
        return this.f13979b;
    }

    public final zzda h() {
        b(this.r);
        return this.r;
    }

    public final zzam i() {
        b(this.w);
        return this.w;
    }

    public final zzeb j() {
        b(this.u);
        return this.u;
    }

    public final zzdy k() {
        b(this.q);
        return this.q;
    }

    public final zzao l() {
        b(this.t);
        return this.t;
    }

    public final zzfd m() {
        b(this.l);
        return this.l;
    }

    public final zzaa n() {
        b(this.v);
        return this.v;
    }

    public final zzaq o() {
        a((O) this.o);
        return this.o;
    }

    public final zzfy p() {
        a((O) this.n);
        return this.n;
    }

    public final C1428m q() {
        a((O) this.i);
        return this.i;
    }

    public final zzq r() {
        return this.f13985h;
    }

    public final zzas s() {
        zzas zzasVar = this.j;
        if (zzasVar == null || !zzasVar.k()) {
            return null;
        }
        return this.j;
    }

    public final zzbj t() {
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbr u() {
        return this.k;
    }

    public final AppMeasurement v() {
        return this.m;
    }

    public final boolean w() {
        return TextUtils.isEmpty(this.f13980c);
    }

    public final String x() {
        return this.f13980c;
    }

    public final String y() {
        return this.f13981d;
    }

    public final String z() {
        return this.f13982e;
    }

    @Override // com.google.android.gms.measurement.internal.Q
    public final zzbr zzgs() {
        b(this.k);
        return this.k;
    }

    @Override // com.google.android.gms.measurement.internal.Q
    public final zzn zzgw() {
        return this.f13984g;
    }

    private static void b(P p) {
        if (p != null) {
            if (p.k()) {
                return;
            }
            String valueOf = String.valueOf(p.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
        throw new IllegalStateException("Component not created");
    }

    private static void b(Aa aa) {
        if (aa != null) {
            if (aa.s()) {
                return;
            }
            String valueOf = String.valueOf(aa.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
        throw new IllegalStateException("Component not created");
    }

    @Override // com.google.android.gms.measurement.internal.Q
    public final Clock a() {
        return this.p;
    }

    public static zzbw a(Context context, zzan zzanVar) {
        Bundle bundle;
        if (zzanVar != null && (zzanVar.f13924e == null || zzanVar.f13925f == null)) {
            zzanVar = new zzan(zzanVar.f13920a, zzanVar.f13921b, zzanVar.f13922c, zzanVar.f13923d, null, null, zzanVar.f13926g);
        }
        Preconditions.a(context);
        Preconditions.a(context.getApplicationContext());
        if (f13978a == null) {
            synchronized (zzbw.class) {
                if (f13978a == null) {
                    f13978a = new zzbw(new zzcz(context, zzanVar));
                }
            }
        } else if (zzanVar != null && (bundle = zzanVar.f13926g) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            f13978a.a(zzanVar.f13926g.getBoolean("dataCollectionDefaultEnabled"));
        }
        return f13978a;
    }

    private static void a(O o) {
        if (o == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(boolean z) {
        this.B = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(P p) {
        this.E++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Aa aa) {
        this.E++;
    }
}
