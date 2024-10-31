package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* loaded from: classes2.dex */
public final class I {

    /* renamed from: a */
    private final Clock f13158a;

    /* renamed from: b */
    private long f13159b;

    public I(Clock clock) {
        Preconditions.a(clock);
        this.f13158a = clock;
    }

    public final void a() {
        this.f13159b = 0L;
    }

    public final void b() {
        this.f13159b = this.f13158a.c();
    }

    public final boolean a(long j) {
        return this.f13159b == 0 || this.f13158a.c() - this.f13159b > j;
    }

    public I(Clock clock, long j) {
        Preconditions.a(clock);
        this.f13158a = clock;
        this.f13159b = j;
    }
}
