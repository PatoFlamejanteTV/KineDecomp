package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class _a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile Handler f13726a;

    /* renamed from: b, reason: collision with root package name */
    private final Q f13727b;

    /* renamed from: c, reason: collision with root package name */
    private final Runnable f13728c;

    /* renamed from: d, reason: collision with root package name */
    private volatile long f13729d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public _a(Q q) {
        Preconditions.a(q);
        this.f13727b = q;
        this.f13728c = new ab(this, q);
    }

    private final Handler d() {
        Handler handler;
        if (f13726a != null) {
            return f13726a;
        }
        synchronized (_a.class) {
            if (f13726a == null) {
                f13726a = new zzdl(this.f13727b.getContext().getMainLooper());
            }
            handler = f13726a;
        }
        return handler;
    }

    public final void a(long j) {
        a();
        if (j >= 0) {
            this.f13729d = this.f13727b.a().a();
            if (d().postDelayed(this.f13728c, j)) {
                return;
            }
            this.f13727b.b().q().a("Failed to schedule delayed post. time", Long.valueOf(j));
        }
    }

    public abstract void b();

    public final boolean c() {
        return this.f13729d != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.f13729d = 0L;
        d().removeCallbacks(this.f13728c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long a(_a _aVar, long j) {
        _aVar.f13729d = 0L;
        return 0L;
    }
}
