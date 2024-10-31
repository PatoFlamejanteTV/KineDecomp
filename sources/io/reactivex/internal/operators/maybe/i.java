package io.reactivex.internal.operators.maybe;

import io.reactivex.d.b.l;

/* compiled from: MaybeJust.java */
/* loaded from: classes3.dex */
public final class i<T> extends io.reactivex.i<T> implements l<T> {

    /* renamed from: a, reason: collision with root package name */
    final T f28284a;

    public i(T t) {
        this.f28284a = t;
    }

    @Override // io.reactivex.i
    protected void b(io.reactivex.j<? super T> jVar) {
        jVar.onSubscribe(io.reactivex.disposables.c.a());
        jVar.onSuccess(this.f28284a);
    }

    @Override // io.reactivex.d.b.l, java.util.concurrent.Callable
    public T call() {
        return this.f28284a;
    }
}
