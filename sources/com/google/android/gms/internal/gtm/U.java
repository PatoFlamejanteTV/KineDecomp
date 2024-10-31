package com.google.android.gms.internal.gtm;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
final class U {

    /* renamed from: a */
    private final ConcurrentHashMap<V, List<Throwable>> f13184a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b */
    private final ReferenceQueue<Throwable> f13185b = new ReferenceQueue<>();

    public final List<Throwable> a(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.f13185b.poll();
        while (poll != null) {
            this.f13184a.remove(poll);
            poll = this.f13185b.poll();
        }
        return this.f13184a.get(new V(th, null));
    }
}
