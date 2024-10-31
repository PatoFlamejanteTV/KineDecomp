package com.google.android.gms.analytics.internal;

import android.os.Handler;

/* loaded from: classes.dex */
abstract class y {
    private static volatile Handler b;

    /* renamed from: a, reason: collision with root package name */
    private final zzf f723a;
    private final Runnable c;
    private volatile long d;
    private boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(zzf zzfVar) {
        com.google.android.gms.common.internal.zzx.a(zzfVar);
        this.f723a = zzfVar;
        this.c = new z(this);
    }

    private Handler e() {
        Handler handler;
        if (b != null) {
            return b;
        }
        synchronized (y.class) {
            if (b == null) {
                b = new Handler(this.f723a.b().getMainLooper());
            }
            handler = b;
        }
        return handler;
    }

    public abstract void a();

    public void a(long j) {
        d();
        if (j >= 0) {
            this.d = this.f723a.d().currentTimeMillis();
            if (e().postDelayed(this.c, j)) {
                return;
            }
            this.f723a.f().e("Failed to schedule delayed post. time", Long.valueOf(j));
        }
    }

    public long b() {
        if (this.d == 0) {
            return 0L;
        }
        return Math.abs(this.f723a.d().currentTimeMillis() - this.d);
    }

    public void b(long j) {
        if (c()) {
            if (j < 0) {
                d();
                return;
            }
            long abs = j - Math.abs(this.f723a.d().currentTimeMillis() - this.d);
            long j2 = abs >= 0 ? abs : 0L;
            e().removeCallbacks(this.c);
            if (e().postDelayed(this.c, j2)) {
                return;
            }
            this.f723a.f().e("Failed to adjust delayed post. time", Long.valueOf(j2));
        }
    }

    public boolean c() {
        return this.d != 0;
    }

    public void d() {
        this.d = 0L;
        e().removeCallbacks(this.c);
    }
}
