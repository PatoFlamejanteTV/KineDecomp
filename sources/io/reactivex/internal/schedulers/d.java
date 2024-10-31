package io.reactivex.internal.schedulers;

import io.reactivex.r;
import java.util.concurrent.ThreadFactory;

/* compiled from: NewThreadScheduler.java */
/* loaded from: classes3.dex */
public final class d extends r {

    /* renamed from: b */
    private static final RxThreadFactory f28434b = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* renamed from: c */
    final ThreadFactory f28435c;

    public d() {
        this(f28434b);
    }

    @Override // io.reactivex.r
    public r.b a() {
        return new e(this.f28435c);
    }

    public d(ThreadFactory threadFactory) {
        this.f28435c = threadFactory;
    }
}
