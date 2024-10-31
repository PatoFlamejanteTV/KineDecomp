package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* loaded from: classes2.dex */
public final class Ia {

    /* renamed from: a */
    private final Clock f13647a;

    /* renamed from: b */
    private long f13648b;

    public Ia(Clock clock) {
        Preconditions.a(clock);
        this.f13647a = clock;
    }

    public final void a() {
        this.f13648b = 0L;
    }

    public final void b() {
        this.f13648b = this.f13647a.c();
    }

    public final boolean a(long j) {
        return this.f13648b == 0 || this.f13647a.c() - this.f13648b >= 3600000;
    }
}
