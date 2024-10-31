package io.grpc.internal;

import io.grpc.internal.Kc;

/* compiled from: SharedResourcePool.java */
/* loaded from: classes3.dex */
public final class Lc<T> implements Ub<T> {

    /* renamed from: a */
    private final Kc.b<T> f27420a;

    private Lc(Kc.b<T> bVar) {
        this.f27420a = bVar;
    }

    public static <T> Lc<T> a(Kc.b<T> bVar) {
        return new Lc<>(bVar);
    }

    @Override // io.grpc.internal.Ub
    public T getObject() {
        return (T) Kc.a(this.f27420a);
    }

    @Override // io.grpc.internal.Ub
    public T a(Object obj) {
        Kc.a(this.f27420a, obj);
        return null;
    }
}
