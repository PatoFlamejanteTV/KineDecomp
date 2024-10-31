package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public abstract class n {
    private static volatile Handler b;

    /* renamed from: a */
    private final zzv f2039a;
    private final Runnable c;
    private volatile long d;
    private boolean e;

    public n(zzv zzvVar) {
        zzx.a(zzvVar);
        this.f2039a = zzvVar;
        this.e = true;
        this.c = new o(this);
    }

    private Handler d() {
        Handler handler;
        if (b != null) {
            return b;
        }
        synchronized (n.class) {
            if (b == null) {
                b = new Handler(this.f2039a.m().getMainLooper());
            }
            handler = b;
        }
        return handler;
    }

    public abstract void a();

    public void a(long j) {
        c();
        if (j >= 0) {
            this.d = this.f2039a.n().currentTimeMillis();
            if (d().postDelayed(this.c, j)) {
                return;
            }
            this.f2039a.f().b().a("Failed to schedule delayed post. time", Long.valueOf(j));
        }
    }

    public boolean b() {
        return this.d != 0;
    }

    public void c() {
        this.d = 0L;
        d().removeCallbacks(this.c);
    }
}
