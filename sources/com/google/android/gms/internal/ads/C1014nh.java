package com.google.android.gms.internal.ads;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.gms.internal.ads.nh */
/* loaded from: classes2.dex */
final class C1014nh {

    /* renamed from: a */
    private final ConcurrentHashMap<C1028oh, List<Throwable>> f12355a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b */
    private final ReferenceQueue<Throwable> f12356b = new ReferenceQueue<>();

    public final List<Throwable> a(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.f12356b.poll();
        while (poll != null) {
            this.f12355a.remove(poll);
            poll = this.f12356b.poll();
        }
        return this.f12355a.get(new C1028oh(th, null));
    }
}
