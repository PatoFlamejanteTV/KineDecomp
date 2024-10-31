package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpc;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends zzd {

    /* renamed from: a, reason: collision with root package name */
    private boolean f714a;
    private final n b;
    private final c c;
    private final b d;
    private final zzi e;
    private long f;
    private final y g;
    private final y h;
    private final d i;
    private long j;
    private boolean k;

    /* JADX INFO: Access modifiers changed from: protected */
    public o(zzf zzfVar, zzg zzgVar) {
        super(zzfVar);
        com.google.android.gms.common.internal.zzx.a(zzgVar);
        this.f = Long.MIN_VALUE;
        this.d = zzgVar.k(zzfVar);
        this.b = zzgVar.m(zzfVar);
        this.c = zzgVar.n(zzfVar);
        this.e = zzgVar.o(zzfVar);
        this.i = new d(n());
        this.g = new p(this, zzfVar);
        this.h = new q(this, zzfVar);
    }

    private void J() {
        Context b = k().b();
        if (!AnalyticsReceiver.a(b)) {
            e("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!AnalyticsService.a(b)) {
            f("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!CampaignTrackingReceiver.a(b)) {
            e("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        } else {
            if (CampaignTrackingService.a(b)) {
                return;
            }
            e("CampaignTrackingService is not registered or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        a((zzw) new s(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        try {
            this.b.g();
            G();
        } catch (SQLiteException e) {
            d("Failed to delete stale hits", e);
        }
        this.h.a(q().C());
    }

    private boolean M() {
        if (this.k) {
            return false;
        }
        return (!q().a() || q().b()) && H() > 0;
    }

    private void N() {
        zzv u = u();
        if (u.b() && !u.c()) {
            long F = F();
            if (F == 0 || Math.abs(n().currentTimeMillis() - F) > q().k()) {
                return;
            }
            a("Dispatch alarm scheduled (ms)", Long.valueOf(q().j()));
            u.d();
        }
    }

    private void O() {
        long min;
        N();
        long H = H();
        long d = w().d();
        if (d != 0) {
            min = H - Math.abs(n().currentTimeMillis() - d);
            if (min <= 0) {
                min = Math.min(q().h(), H);
            }
        } else {
            min = Math.min(q().h(), H);
        }
        a("Dispatch scheduled (ms)", Long.valueOf(min));
        if (!this.g.c()) {
            this.g.a(min);
        } else {
            this.g.b(Math.max(1L, min + this.g.b()));
        }
    }

    private void P() {
        Q();
        R();
    }

    private void Q() {
        if (this.g.c()) {
            b("All hits dispatched or no network/service. Going to power save mode");
        }
        this.g.d();
    }

    private void R() {
        zzv u = u();
        if (u.c()) {
            u.e();
        }
    }

    private void a(zzh zzhVar, zzpc zzpcVar) {
        com.google.android.gms.common.internal.zzx.a(zzhVar);
        com.google.android.gms.common.internal.zzx.a(zzpcVar);
        com.google.android.gms.analytics.zza zzaVar = new com.google.android.gms.analytics.zza(k());
        zzaVar.b(zzhVar.c());
        zzaVar.b(zzhVar.d());
        com.google.android.gms.measurement.zzc l = zzaVar.l();
        zzjo zzjoVar = (zzjo) l.b(zzjo.class);
        zzjoVar.zzaU(ShareConstants.WEB_DIALOG_PARAM_DATA);
        zzjoVar.zzH(true);
        l.a(zzpcVar);
        zzjn zzjnVar = (zzjn) l.b(zzjn.class);
        zzpb zzpbVar = (zzpb) l.b(zzpb.class);
        for (Map.Entry<String, String> entry : zzhVar.f().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if ("an".equals(key)) {
                zzpbVar.setAppName(value);
            } else if ("av".equals(key)) {
                zzpbVar.setAppVersion(value);
            } else if ("aid".equals(key)) {
                zzpbVar.setAppId(value);
            } else if ("aiid".equals(key)) {
                zzpbVar.setAppInstallerId(value);
            } else if ("uid".equals(key)) {
                zzjoVar.setUserId(value);
            } else {
                zzjnVar.set(key, value);
            }
        }
        b("Sending installation campaign to", zzhVar.c(), zzpcVar);
        l.a(w().b());
        l.e();
    }

    private boolean g(String str) {
        return o().checkCallingOrSelfPermission(str) == 0;
    }

    public long F() {
        com.google.android.gms.measurement.zzg.d();
        D();
        try {
            return this.b.h();
        } catch (SQLiteException e) {
            e("Failed to get min/max hit times from local store", e);
            return 0L;
        }
    }

    public void G() {
        boolean z;
        k().s();
        D();
        if (!M()) {
            this.d.b();
            P();
            return;
        }
        if (this.b.f()) {
            this.d.b();
            P();
            return;
        }
        if (zzy.J.a().booleanValue()) {
            z = true;
        } else {
            this.d.a();
            z = this.d.e();
        }
        if (z) {
            O();
        } else {
            P();
            N();
        }
    }

    public long H() {
        if (this.f != Long.MIN_VALUE) {
            return this.f;
        }
        return v().f() ? v().g() * 1000 : q().i();
    }

    public void I() {
        D();
        m();
        this.k = true;
        this.e.d();
        G();
    }

    public long a(zzh zzhVar, boolean z) {
        long j;
        com.google.android.gms.common.internal.zzx.a(zzhVar);
        D();
        m();
        try {
            try {
                this.b.b();
                this.b.a(zzhVar.a(), zzhVar.b());
                j = this.b.a(zzhVar.a(), zzhVar.b(), zzhVar.c());
                if (z) {
                    zzhVar.a(1 + j);
                } else {
                    zzhVar.a(j);
                }
                this.b.a(zzhVar);
                this.b.c();
                try {
                    this.b.d();
                } catch (SQLiteException e) {
                    e("Failed to end transaction", e);
                }
            } catch (SQLiteException e2) {
                e("Failed to update Analytics property", e2);
                j = -1;
            }
            return j;
        } finally {
            try {
                this.b.d();
            } catch (SQLiteException e3) {
                e("Failed to end transaction", e3);
            }
        }
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void a() {
        this.b.E();
        this.c.E();
        this.e.E();
    }

    public void a(zzab zzabVar) {
        com.google.android.gms.common.internal.zzx.a(zzabVar);
        com.google.android.gms.measurement.zzg.d();
        D();
        if (this.k) {
            c("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            a("Delivering hit", zzabVar);
        }
        zzab b = b(zzabVar);
        g();
        if (this.e.a(b)) {
            c("Hit sent to the device AnalyticsService for delivery");
            return;
        }
        if (q().a()) {
            p().a(b, "Service unavailable on package side");
            return;
        }
        try {
            this.b.a(b);
            G();
        } catch (SQLiteException e) {
            e("Delivery failed to save hit to a database", e);
            p().a(b, "deliver: failed to insert hit to database");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(zzh zzhVar) {
        m();
        b("Sending first hit to property", zzhVar.c());
        if (w().c().a(q().F())) {
            return;
        }
        String f = w().f();
        if (TextUtils.isEmpty(f)) {
            return;
        }
        zzpc a2 = zzam.a(p(), f);
        b("Found relevant installation campaign", a2);
        a(zzhVar, a2);
    }

    public void a(zzw zzwVar) {
        a(zzwVar, this.j);
    }

    public void a(zzw zzwVar, long j) {
        com.google.android.gms.measurement.zzg.d();
        D();
        long d = w().d();
        b("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(d != 0 ? Math.abs(n().currentTimeMillis() - d) : -1L));
        if (!q().a()) {
            g();
        }
        try {
            if (i()) {
                r().a(new t(this, zzwVar, j));
                return;
            }
            w().e();
            G();
            if (zzwVar != null) {
                zzwVar.a(null);
            }
            if (this.j != j) {
                this.d.c();
            }
        } catch (Throwable th) {
            e("Local dispatch failed", th);
            w().e();
            G();
            if (zzwVar != null) {
                zzwVar.a(th);
            }
        }
    }

    public void a(String str) {
        com.google.android.gms.common.internal.zzx.a(str);
        m();
        l();
        zzpc a2 = zzam.a(p(), str);
        if (a2 == null) {
            d("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        String f = w().f();
        if (str.equals(f)) {
            e("Ignoring duplicate install campaign");
            return;
        }
        if (!TextUtils.isEmpty(f)) {
            d("Ignoring multiple install campaigns. original, new", f, str);
            return;
        }
        w().a(str);
        if (w().c().a(q().F())) {
            d("Campaign received too late, ignoring", a2);
            return;
        }
        b("Received installation campaign", a2);
        Iterator<zzh> it = this.b.d(0L).iterator();
        while (it.hasNext()) {
            a(it.next(), a2);
        }
    }

    public void a(boolean z) {
        G();
    }

    zzab b(zzab zzabVar) {
        Pair<String, Long> a2;
        if (!TextUtils.isEmpty(zzabVar.h()) || (a2 = w().g().a()) == null) {
            return zzabVar;
        }
        String str = ((Long) a2.second) + ":" + ((String) a2.first);
        HashMap hashMap = new HashMap(zzabVar.b());
        hashMap.put("_m", str);
        return zzab.a(this, zzabVar, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        D();
        com.google.android.gms.common.internal.zzx.a(!this.f714a, "Analytics backend already started");
        this.f714a = true;
        if (!q().a()) {
            J();
        }
        r().a(new r(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        D();
        w().b();
        if (!g("android.permission.ACCESS_NETWORK_STATE")) {
            f("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            I();
        }
        if (!g("android.permission.INTERNET")) {
            f("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            I();
        }
        if (AnalyticsService.a(o())) {
            b("AnalyticsService registered in the app manifest and enabled");
        } else if (q().a()) {
            f("Device AnalyticsService not registered! Hits will not be delivered reliably.");
        } else {
            e("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!this.k && !q().a() && !this.b.f()) {
            g();
        }
        G();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        m();
        this.j = n().currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        m();
        if (q().a()) {
            return;
        }
        h();
    }

    public void f() {
        com.google.android.gms.measurement.zzg.d();
        D();
        b("Service disconnected");
    }

    protected void g() {
        if (this.k || !q().c() || this.e.b()) {
            return;
        }
        if (this.i.a(q().x())) {
            this.i.a();
            b("Connecting to service");
            if (this.e.c()) {
                b("Connected to service");
                this.i.b();
                e();
            }
        }
    }

    public void h() {
        com.google.android.gms.measurement.zzg.d();
        D();
        l();
        if (!q().c()) {
            e("Service client disabled. Can't dispatch local hits to device AnalyticsService");
        }
        if (!this.e.b()) {
            b("Service not connected");
            return;
        }
        if (this.b.f()) {
            return;
        }
        b("Dispatching local hits to device AnalyticsService");
        while (true) {
            try {
                List<zzab> b = this.b.b(q().l());
                if (b.isEmpty()) {
                    G();
                    return;
                }
                while (!b.isEmpty()) {
                    zzab zzabVar = b.get(0);
                    if (!this.e.a(zzabVar)) {
                        G();
                        return;
                    }
                    b.remove(zzabVar);
                    try {
                        this.b.c(zzabVar.c());
                    } catch (SQLiteException e) {
                        e("Failed to remove hit that was send for delivery", e);
                        P();
                        return;
                    }
                }
            } catch (SQLiteException e2) {
                e("Failed to read hits from store", e2);
                P();
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f9, code lost:            if (r12.e.b() == false) goto L90;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0103, code lost:            if (q().a() != false) goto L90;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0105, code lost:            b("Service connected, sending hits to the service");     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x010e, code lost:            if (r8.isEmpty() != false) goto L119;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0110, code lost:            r0 = r8.get(0);     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x011d, code lost:            if (r12.e.a(r0) != false) goto L57;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0148, code lost:            r4 = java.lang.Math.max(r4, r0.c());        r8.remove(r0);        b("Hit sent do device AnalyticsService for delivery", r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0158, code lost:            r12.b.c(r0.c());        r3.add(java.lang.Long.valueOf(r0.c()));     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x016d, code lost:            r0 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x016e, code lost:            e("Failed to remove hit that was send for delivery", r0);        P();     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0176, code lost:            r12.b.c();        r12.b.d();     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0182, code lost:            r0 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0183, code lost:            e("Failed to commit local dispatch transaction", r0);        P();     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x011f, code lost:            r0 = r4;     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0126, code lost:            if (r12.c.b() == false) goto L69;     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0128, code lost:            r9 = r12.c.a(r8);        r10 = r9.iterator();        r4 = r0;     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0137, code lost:            if (r10.hasNext() == false) goto L121;     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0139, code lost:            r4 = java.lang.Math.max(r4, r10.next().longValue());     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x018d, code lost:            r8.removeAll(r9);     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0190, code lost:            r12.b.a(r9);        r3.addAll(r9);     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0198, code lost:            r0 = r4;     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01b6, code lost:            r0 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01b7, code lost:            e("Failed to remove successfully uploaded hits", r0);        P();     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01bf, code lost:            r12.b.c();        r12.b.d();     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01cb, code lost:            r0 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01cc, code lost:            e("Failed to commit local dispatch transaction", r0);        P();     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x019d, code lost:            if (r3.isEmpty() == false) goto L99;     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01d6, code lost:            r12.b.c();        r12.b.d();     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01e3, code lost:            r0 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01e4, code lost:            e("Failed to commit local dispatch transaction", r0);        P();     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x019f, code lost:            r12.b.c();        r12.b.d();     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01ab, code lost:            r0 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01ac, code lost:            e("Failed to commit local dispatch transaction", r0);        P();     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0205, code lost:            r0 = r4;     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0066, code lost:            b("Store is empty, nothing to dispatch");        P();     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x006e, code lost:            r12.b.c();        r12.b.d();     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0079, code lost:            r0 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x007a, code lost:            e("Failed to commit local dispatch transaction", r0);        P();     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean i() {
        /*
            Method dump skipped, instructions count: 520
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.o.i():boolean");
    }

    public void j() {
        com.google.android.gms.measurement.zzg.d();
        D();
        c("Sync dispatching local hits");
        long j = this.j;
        if (!q().a()) {
            g();
        }
        do {
            try {
            } catch (Throwable th) {
                e("Sync local dispatch failed", th);
                G();
                return;
            }
        } while (i());
        w().e();
        G();
        if (this.j != j) {
            this.d.c();
        }
    }
}
