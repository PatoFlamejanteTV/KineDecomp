package com.google.android.gms.internal.measurement;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
final class W {

    /* renamed from: a */
    private final ConcurrentHashMap<X, List<Throwable>> f13402a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b */
    private final ReferenceQueue<Throwable> f13403b = new ReferenceQueue<>();

    public final List<Throwable> a(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.f13403b.poll();
        while (poll != null) {
            this.f13402a.remove(poll);
            poll = this.f13403b.poll();
        }
        return this.f13402a.get(new X(th, null));
    }
}
