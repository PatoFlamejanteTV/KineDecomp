package com.google.android.gms.internal.firebase_messaging;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
final class b {

    /* renamed from: a */
    private final ConcurrentHashMap<c, List<Throwable>> f13118a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b */
    private final ReferenceQueue<Throwable> f13119b = new ReferenceQueue<>();

    public final List<Throwable> a(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.f13119b.poll();
        while (poll != null) {
            this.f13118a.remove(poll);
            poll = this.f13119b.poll();
        }
        List<Throwable> list = this.f13118a.get(new c(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f13118a.putIfAbsent(new c(th, this.f13119b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
