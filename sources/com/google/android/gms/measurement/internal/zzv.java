package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzpk;
import com.google.android.gms.measurement.AppMeasurementReceiver;
import com.google.android.gms.measurement.AppMeasurementService;
import com.google.android.gms.measurement.zza;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class zzv {

    /* renamed from: a, reason: collision with root package name */
    private static ad f2073a;
    private static volatile zzv b;
    private final Context c;
    private final zzc d;
    private final zzs e;
    private final zzp f;
    private final zzu g;
    private final zza h;
    private final zzag i;
    private final m j;
    private final zzq k;
    private final zzmn l;
    private final zzab m;
    private final zzf n;
    private final zzaa o;
    private final zzn p;
    private final s q;
    private final zzad r;
    private final boolean s;
    private Boolean t;
    private List<Long> u;
    private int v;
    private int w;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzv(ad adVar) {
        zzx.a(adVar);
        this.c = adVar.f2025a;
        this.l = adVar.j(this);
        this.d = adVar.a(this);
        zzs b2 = adVar.b(this);
        b2.y();
        this.e = b2;
        zzp c = adVar.c(this);
        c.y();
        this.f = c;
        this.i = adVar.g(this);
        zzf l = adVar.l(this);
        l.y();
        this.n = l;
        zzn m = adVar.m(this);
        m.y();
        this.p = m;
        m h = adVar.h(this);
        h.y();
        this.j = h;
        zzq i = adVar.i(this);
        i.y();
        this.k = i;
        zzab k = adVar.k(this);
        k.y();
        this.m = k;
        zzaa f = adVar.f(this);
        f.y();
        this.o = f;
        zzad o = adVar.o(this);
        o.y();
        this.r = o;
        this.q = adVar.n(this);
        this.h = adVar.e(this);
        zzu d = adVar.d(this);
        d.y();
        this.g = d;
        if (this.v != this.w) {
            f().b().a("Not all components initialized", Integer.valueOf(this.v), Integer.valueOf(this.w));
        }
        this.s = true;
        this.g.a(new v(this));
    }

    private void A() {
        t();
        a();
        if (!b() || !z()) {
            r().b();
            s().b();
            return;
        }
        long B = B();
        if (B == 0) {
            r().b();
            s().b();
            return;
        }
        if (!l().b()) {
            r().a();
            s().b();
            return;
        }
        long a2 = e().e.a();
        long I = d().I();
        if (!j().a(a2, I)) {
            B = Math.max(B, a2 + I);
        }
        r().b();
        long currentTimeMillis = B - n().currentTimeMillis();
        if (currentTimeMillis <= 0) {
            s().a(1L);
        } else {
            f().t().a("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis));
            s().a(currentTimeMillis);
        }
    }

    private long B() {
        long currentTimeMillis = n().currentTimeMillis();
        long K = d().K();
        long J = d().J();
        long a2 = e().c.a();
        long a3 = e().d.a();
        long t = k().t();
        if (t == 0) {
            return 0L;
        }
        long abs = currentTimeMillis - Math.abs(t - currentTimeMillis);
        long j = K + abs;
        if (!j().a(a2, J)) {
            j = a2 + J;
        }
        if (a3 == 0 || a3 < abs) {
            return j;
        }
        for (int i = 0; i < d().M(); i++) {
            j += (1 << i) * d().L();
            if (j > a3) {
                return j;
            }
        }
        return 0L;
    }

    public static zzv a(Context context) {
        zzx.a(context);
        zzx.a(context.getApplicationContext());
        if (b == null) {
            synchronized (zzv.class) {
                if (b == null) {
                    b = (f2073a != null ? f2073a : new ad(context)).a();
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Throwable th, byte[] bArr) {
        t();
        a();
        if (bArr == null) {
            bArr = new byte[0];
        }
        List<Long> list = this.u;
        this.u = null;
        if ((i != 200 && i != 204) || th != null) {
            f().t().a("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            e().d.a(n().currentTimeMillis());
            if (i == 503) {
                e().e.a(n().currentTimeMillis());
            }
            A();
            return;
        }
        e().c.a(n().currentTimeMillis());
        e().d.a(0L);
        A();
        f().t().a("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
        k().b();
        try {
            Iterator<Long> it = list.iterator();
            while (it.hasNext()) {
                k().a(it.next().longValue());
            }
            k().o();
            k().p();
            if (l().b() && z()) {
                w();
            } else {
                A();
            }
        } catch (Throwable th2) {
            k().p();
            throw th2;
        }
    }

    private void a(ab abVar) {
        if (abVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private void a(List<Long> list) {
        zzx.b(!list.isEmpty());
        if (this.u != null) {
            f().b().a("Set uploading progress before finishing the previous upload");
        } else {
            this.u = new ArrayList(list);
        }
    }

    private void b(AppMetadata appMetadata) {
        t();
        a();
        zzx.a(appMetadata);
        zzx.a(appMetadata.b);
        b b2 = k().b(appMetadata.b);
        String o = e().o();
        boolean z = false;
        if (b2 == null) {
            b2 = new b(appMetadata.b, e().p(), appMetadata.c, o, 0L, 0L);
            z = true;
        } else if (!o.equals(b2.d)) {
            b2 = b2.a(e().p(), o);
            z = true;
        }
        if (!TextUtils.isEmpty(appMetadata.c) && !appMetadata.c.equals(b2.c)) {
            b2 = b2.a(appMetadata.c);
            z = true;
        }
        if (z) {
            k().a(b2);
        }
    }

    private void b(ac acVar) {
        if (acVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (!acVar.v()) {
            throw new IllegalStateException("Component not initialized");
        }
    }

    private boolean y() {
        t();
        return this.u != null;
    }

    private boolean z() {
        return !TextUtils.isEmpty(k().r());
    }

    zzpk.zzd a(zzg[] zzgVarArr, AppMetadata appMetadata) {
        zzx.a(appMetadata);
        zzx.a(zzgVarArr);
        t();
        zzpk.zzd zzdVar = new zzpk.zzd();
        zzdVar.zzaOK = 1;
        zzdVar.zzaOS = "android";
        zzdVar.zzaOX = appMetadata.b;
        zzdVar.zzaLQ = appMetadata.e;
        zzdVar.zzaDC = appMetadata.d;
        zzdVar.zzaOY = Long.valueOf(appMetadata.f);
        zzdVar.zzaLP = appMetadata.c;
        zzdVar.zzaPd = appMetadata.g == 0 ? null : Long.valueOf(appMetadata.g);
        Pair<String, Boolean> b2 = e().b();
        if (b2 != null && b2.first != null && b2.second != null) {
            zzdVar.zzaPa = (String) b2.first;
            zzdVar.zzaPb = (Boolean) b2.second;
        }
        zzdVar.zzaOU = p().b();
        zzdVar.zzaOT = p().o();
        zzdVar.zzaOW = Integer.valueOf((int) p().p());
        zzdVar.zzaOV = p().q();
        zzdVar.zzaOZ = null;
        zzdVar.zzaON = null;
        zzdVar.zzaOO = Long.valueOf(zzgVarArr[0].d);
        zzdVar.zzaOP = Long.valueOf(zzgVarArr[0].d);
        for (int i = 1; i < zzgVarArr.length; i++) {
            zzdVar.zzaOO = Long.valueOf(Math.min(zzdVar.zzaOO.longValue(), zzgVarArr[i].d));
            zzdVar.zzaOP = Long.valueOf(Math.max(zzdVar.zzaOP.longValue(), zzgVarArr[i].d));
        }
        b b3 = k().b(appMetadata.b);
        if (b3 == null) {
            b3 = new b(appMetadata.b, e().p(), appMetadata.c, e().o(), 0L, 0L);
        }
        b a2 = b3.a(f(), zzdVar.zzaOP.longValue());
        k().a(a2);
        zzdVar.zzaPc = a2.b;
        zzdVar.zzaPe = Integer.valueOf((int) a2.e);
        zzdVar.zzaOR = b3.f != 0 ? Long.valueOf(b3.f) : null;
        zzdVar.zzaOQ = zzdVar.zzaOR;
        List<l> a3 = k().a(appMetadata.b);
        zzdVar.zzaOM = new zzpk.zze[a3.size()];
        for (int i2 = 0; i2 < a3.size(); i2++) {
            zzpk.zze zzeVar = new zzpk.zze();
            zzdVar.zzaOM[i2] = zzeVar;
            zzeVar.name = a3.get(i2).b;
            zzeVar.zzaPi = Long.valueOf(a3.get(i2).c);
            j().a(zzeVar, a3.get(i2).d);
        }
        zzdVar.zzaOL = new zzpk.zza[zzgVarArr.length];
        for (int i3 = 0; i3 < zzgVarArr.length; i3++) {
            zzpk.zza zzaVar = new zzpk.zza();
            zzdVar.zzaOL[i3] = zzaVar;
            zzaVar.name = zzgVarArr[i3].b;
            zzaVar.zzaOE = Long.valueOf(zzgVarArr[i3].d);
            zzaVar.zzaOD = new zzpk.zzb[zzgVarArr[i3].f.a()];
            Iterator<String> it = zzgVarArr[i3].f.iterator();
            int i4 = 0;
            while (it.hasNext()) {
                String next = it.next();
                zzpk.zzb zzbVar = new zzpk.zzb();
                zzaVar.zzaOD[i4] = zzbVar;
                zzbVar.name = next;
                j().a(zzbVar, zzgVarArr[i3].f.a(next));
                i4++;
            }
        }
        zzdVar.zzaPf = f().u();
        return zzdVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (!this.s) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    public void a(AppMetadata appMetadata) {
        t();
        a();
        zzx.a(appMetadata);
        zzx.a(appMetadata.b);
        if (TextUtils.isEmpty(appMetadata.c)) {
            return;
        }
        b(appMetadata);
        if (k().a(appMetadata.b, "_f") == null) {
            long currentTimeMillis = n().currentTimeMillis();
            a(new UserAttributeParcel("_fot", currentTimeMillis, Long.valueOf(3600000 * ((currentTimeMillis / 3600000) + 1)), "auto"), appMetadata);
            Bundle bundle = new Bundle();
            bundle.putLong("_c", 1L);
            a(new EventParcel("_f", new EventParams(bundle), "auto", currentTimeMillis), appMetadata);
            A();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(EventParcel eventParcel, AppMetadata appMetadata) {
        p a2;
        t();
        a();
        zzx.a(appMetadata.b);
        if (TextUtils.isEmpty(appMetadata.c)) {
            return;
        }
        f().t().a("Logging event", eventParcel);
        zzg zzgVar = new zzg(this, eventParcel.d, appMetadata.b, eventParcel.b, eventParcel.e, 0L, eventParcel.c.b());
        k().b();
        try {
            b(appMetadata);
            p a3 = k().a(appMetadata.b, zzgVar.b);
            if (a3 == null) {
                a2 = new p(appMetadata.b, zzgVar.b, 1L, 1L, zzgVar.d);
            } else {
                zzgVar = zzgVar.a(this, a3.e);
                a2 = a3.a(zzgVar.d);
            }
            k().a(a2);
            k().a(a(new zzg[]{zzgVar}, appMetadata));
            k().o();
            f().s().a("Event logged", zzgVar);
            k().p();
            A();
        } catch (Throwable th) {
            k().p();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        t();
        a();
        if (TextUtils.isEmpty(appMetadata.c)) {
            return;
        }
        j().a(userAttributeParcel.b);
        Object b2 = j().b(userAttributeParcel.a());
        if (b2 != null) {
            l lVar = new l(appMetadata.b, userAttributeParcel.b, userAttributeParcel.c, b2);
            f().s().a("Setting user attribute", lVar.b, b2);
            k().b();
            try {
                b(appMetadata);
                k().a(lVar);
                k().o();
                f().s().a("User attribute set", lVar.b, lVar.d);
            } finally {
                k().p();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ac acVar) {
        this.v++;
    }

    public void a(boolean z) {
        A();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        t();
        a();
        if (TextUtils.isEmpty(appMetadata.c)) {
            return;
        }
        f().s().a("Removing user attribute", userAttributeParcel.b);
        k().b();
        try {
            b(appMetadata);
            k().b(appMetadata.b, userAttributeParcel.b);
            k().o();
            f().s().a("User attribute removed", userAttributeParcel.b);
        } finally {
            k().p();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b() {
        a();
        t();
        if (this.t == null) {
            this.t = Boolean.valueOf(j().b("android.permission.INTERNET") && j().b("android.permission.ACCESS_NETWORK_STATE") && AppMeasurementReceiver.a(m()) && AppMeasurementService.a(m()));
            if (this.t.booleanValue() && !d().z()) {
                this.t = Boolean.valueOf(TextUtils.isEmpty(q().o()) ? false : true);
            }
        }
        return this.t.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        t();
        f().r().a("App measurement is starting up");
        f().s().a("Debug logging enabled");
        if (!b()) {
            if (!j().b("android.permission.INTERNET")) {
                f().b().a("App is missing INTERNET permission");
            }
            if (!j().b("android.permission.ACCESS_NETWORK_STATE")) {
                f().b().a("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!AppMeasurementReceiver.a(m())) {
                f().b().a("AppMeasurementReceiver not registered/enabled");
            }
            if (!AppMeasurementService.a(m())) {
                f().b().a("AppMeasurementService not registered/enabled");
            }
            f().b().a("Uploading is not possible. App measurement disabled");
        } else if (!d().z() && !TextUtils.isEmpty(q().o())) {
            i().b();
        }
        A();
    }

    public zzc d() {
        return this.d;
    }

    public zzs e() {
        a((ab) this.e);
        return this.e;
    }

    public zzp f() {
        b(this.f);
        return this.f;
    }

    public zzu g() {
        b(this.g);
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzu h() {
        return this.g;
    }

    public zzaa i() {
        b(this.o);
        return this.o;
    }

    public zzag j() {
        a(this.i);
        return this.i;
    }

    public m k() {
        b(this.j);
        return this.j;
    }

    public zzq l() {
        b(this.k);
        return this.k;
    }

    public Context m() {
        return this.c;
    }

    public zzmn n() {
        return this.l;
    }

    public zzab o() {
        b(this.m);
        return this.m;
    }

    public zzf p() {
        b(this.n);
        return this.n;
    }

    public zzn q() {
        b(this.p);
        return this.p;
    }

    public s r() {
        if (this.q == null) {
            throw new IllegalStateException("Network broadcast receiver not created");
        }
        return this.q;
    }

    public zzad s() {
        b(this.r);
        return this.r;
    }

    public void t() {
        g().e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean u() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        if (d().z()) {
            throw new IllegalStateException("Unexpected call on package side");
        }
    }

    public void w() {
        String str;
        List<Pair<zzpk.zzd, Long>> list;
        t();
        a();
        if (!d().z()) {
            Boolean q = e().q();
            if (q == null) {
                f().o().a("Upload data called on the client side before use of service was decided");
                return;
            } else if (q.booleanValue()) {
                f().b().a("Upload called in the client side when service should be used");
                return;
            }
        }
        if (y()) {
            f().o().a("Uploading requested multiple times");
            return;
        }
        if (!l().b()) {
            f().o().a("Network not connected, ignoring upload request");
            A();
            return;
        }
        long a2 = e().c.a();
        if (a2 != 0) {
            f().s().a("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(n().currentTimeMillis() - a2)));
        }
        String r = k().r();
        if (TextUtils.isEmpty(r)) {
            return;
        }
        List<Pair<zzpk.zzd, Long>> a3 = k().a(r, d().F(), d().G());
        if (a3.isEmpty()) {
            return;
        }
        Iterator<Pair<zzpk.zzd, Long>> it = a3.iterator();
        while (true) {
            if (!it.hasNext()) {
                str = null;
                break;
            }
            zzpk.zzd zzdVar = (zzpk.zzd) it.next().first;
            if (!TextUtils.isEmpty(zzdVar.zzaPa)) {
                str = zzdVar.zzaPa;
                break;
            }
        }
        if (str != null) {
            for (int i = 0; i < a3.size(); i++) {
                zzpk.zzd zzdVar2 = (zzpk.zzd) a3.get(i).first;
                if (!TextUtils.isEmpty(zzdVar2.zzaPa) && !zzdVar2.zzaPa.equals(str)) {
                    list = a3.subList(0, i);
                    break;
                }
            }
        }
        list = a3;
        zzpk.zzc zzcVar = new zzpk.zzc();
        zzcVar.zzaOI = new zzpk.zzd[list.size()];
        ArrayList arrayList = new ArrayList(list.size());
        long currentTimeMillis = n().currentTimeMillis();
        for (int i2 = 0; i2 < zzcVar.zzaOI.length; i2++) {
            zzcVar.zzaOI[i2] = (zzpk.zzd) list.get(i2).first;
            arrayList.add(list.get(i2).second);
            zzcVar.zzaOI[i2].zzaOZ = Long.valueOf(d().y());
            zzcVar.zzaOI[i2].zzaON = Long.valueOf(currentTimeMillis);
            zzcVar.zzaOI[i2].zzaPg = Boolean.valueOf(d().z());
        }
        byte[] a4 = j().a(zzcVar);
        String H = d().H();
        try {
            URL url = new URL(H);
            a(arrayList);
            e().d.a(n().currentTimeMillis());
            l().a(url, a4, new w(this));
        } catch (MalformedURLException e) {
            f().b().a("Failed to parse upload URL. Not uploading", H);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x() {
        this.w++;
    }
}
