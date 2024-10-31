package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.FirebaseApp;

/* loaded from: classes2.dex */
public final class zzs {

    /* renamed from: a */
    private static Logger f16544a = new Logger("TokenRefresher", "FirebaseAuth:");

    /* renamed from: b */
    private final FirebaseApp f16545b;

    /* renamed from: c */
    @VisibleForTesting
    volatile long f16546c;

    /* renamed from: d */
    @VisibleForTesting
    volatile long f16547d;

    /* renamed from: e */
    @VisibleForTesting
    private long f16548e;

    /* renamed from: f */
    @VisibleForTesting
    private HandlerThread f16549f;

    /* renamed from: g */
    @VisibleForTesting
    private Handler f16550g;

    /* renamed from: h */
    @VisibleForTesting
    private Runnable f16551h;

    public zzs(FirebaseApp firebaseApp) {
        f16544a.d("Initializing TokenRefresher", new Object[0]);
        Preconditions.a(firebaseApp);
        this.f16545b = firebaseApp;
        this.f16549f = new HandlerThread("TokenRefresher", 10);
        this.f16549f.start();
        this.f16550g = new com.google.android.gms.internal.firebase_auth.zzf(this.f16549f.getLooper());
        this.f16551h = new c(this, this.f16545b.d());
        this.f16548e = 300000L;
    }

    public final void a() {
        this.f16550g.removeCallbacks(this.f16551h);
    }

    public final void b() {
        Logger logger = f16544a;
        long j = this.f16546c - this.f16548e;
        StringBuilder sb = new StringBuilder(43);
        sb.append("Scheduling refresh for ");
        sb.append(j);
        logger.d(sb.toString(), new Object[0]);
        a();
        this.f16547d = Math.max((this.f16546c - DefaultClock.d().a()) - this.f16548e, 0L) / 1000;
        this.f16550g.postDelayed(this.f16551h, this.f16547d * 1000);
    }

    public final void c() {
        long j;
        int i = (int) this.f16547d;
        if (i == 30 || i == 60 || i == 120 || i == 240 || i == 480) {
            j = 2 * this.f16547d;
        } else {
            j = i != 960 ? 30L : 960L;
        }
        this.f16547d = j;
        this.f16546c = DefaultClock.d().a() + (this.f16547d * 1000);
        Logger logger = f16544a;
        long j2 = this.f16546c;
        StringBuilder sb = new StringBuilder(43);
        sb.append("Scheduling refresh for ");
        sb.append(j2);
        logger.d(sb.toString(), new Object[0]);
        this.f16550g.postDelayed(this.f16551h, this.f16547d * 1000);
    }
}
