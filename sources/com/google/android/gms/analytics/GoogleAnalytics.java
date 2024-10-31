package com.google.android.gms.analytics;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.analytics.internal.zzae;
import com.google.android.gms.analytics.internal.zzan;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzy;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class GoogleAnalytics extends zza {
    private static List<Runnable> b = new ArrayList();
    private boolean c;
    private boolean d;
    private Set<Object> e;
    private boolean f;
    private volatile boolean g;
    private boolean h;

    public GoogleAnalytics(zzf zzfVar) {
        super(zzfVar);
        this.e = new HashSet();
    }

    public static GoogleAnalytics a(Context context) {
        return zzf.a(context).k();
    }

    public static void d() {
        synchronized (GoogleAnalytics.class) {
            if (b != null) {
                Iterator<Runnable> it = b.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
                b = null;
            }
        }
    }

    private com.google.android.gms.analytics.internal.zzb p() {
        return k().i();
    }

    private zzan q() {
        return k().l();
    }

    public Tracker a(String str) {
        Tracker tracker;
        synchronized (this) {
            tracker = new Tracker(k(), str, null);
            tracker.E();
        }
        return tracker;
    }

    public void a() {
        b();
        this.c = true;
    }

    @Deprecated
    public void a(Logger logger) {
        zzae.a(logger);
        if (this.h) {
            return;
        }
        Log.i(zzy.c.a(), "GoogleAnalytics.setLogger() is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + zzy.c.a() + " DEBUG");
        this.h = true;
    }

    public void a(boolean z) {
        this.f = z;
    }

    void b() {
        Logger a2;
        zzan q = q();
        if (q.d()) {
            g().a(q.e());
        }
        if (q.h()) {
            a(q.i());
        }
        if (!q.d() || (a2 = zzae.a()) == null) {
            return;
        }
        a2.a(q.e());
    }

    public boolean c() {
        return this.c && !this.d;
    }

    public boolean e() {
        return this.f;
    }

    public boolean f() {
        return this.g;
    }

    @Deprecated
    public Logger g() {
        return zzae.a();
    }

    public String h() {
        zzx.c("getClientId can not be called from the main thread");
        return k().p().b();
    }

    public void i() {
        p().c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        p().d();
    }
}
