package com.google.android.gms.internal.gtm;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.gtm.y, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1341y {

    /* renamed from: a, reason: collision with root package name */
    private static volatile Handler f13321a;

    /* renamed from: b, reason: collision with root package name */
    private final zzap f13322b;

    /* renamed from: c, reason: collision with root package name */
    private final Runnable f13323c;

    /* renamed from: d, reason: collision with root package name */
    private volatile long f13324d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC1341y(zzap zzapVar) {
        Preconditions.a(zzapVar);
        this.f13322b = zzapVar;
        this.f13323c = new RunnableC1343z(this);
    }

    private final Handler e() {
        Handler handler;
        if (f13321a != null) {
            return f13321a;
        }
        synchronized (AbstractC1341y.class) {
            if (f13321a == null) {
                f13321a = new zzdj(this.f13322b.getContext().getMainLooper());
            }
            handler = f13321a;
        }
        return handler;
    }

    public final void a(long j) {
        a();
        if (j >= 0) {
            this.f13324d = this.f13322b.zzcn().a();
            if (e().postDelayed(this.f13323c, j)) {
                return;
            }
            this.f13322b.zzco().zze("Failed to schedule delayed post. time", Long.valueOf(j));
        }
    }

    public abstract void b();

    public final void b(long j) {
        if (d()) {
            if (j < 0) {
                a();
                return;
            }
            long abs = j - Math.abs(this.f13322b.zzcn().a() - this.f13324d);
            if (abs < 0) {
                abs = 0;
            }
            e().removeCallbacks(this.f13323c);
            if (e().postDelayed(this.f13323c, abs)) {
                return;
            }
            this.f13322b.zzco().zze("Failed to adjust delayed post. time", Long.valueOf(abs));
        }
    }

    public final long c() {
        if (this.f13324d == 0) {
            return 0L;
        }
        return Math.abs(this.f13322b.zzcn().a() - this.f13324d);
    }

    public final boolean d() {
        return this.f13324d != 0;
    }

    public final void a() {
        this.f13324d = 0L;
        e().removeCallbacks(this.f13323c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long a(AbstractC1341y abstractC1341y, long j) {
        abstractC1341y.f13324d = 0L;
        return 0L;
    }
}
