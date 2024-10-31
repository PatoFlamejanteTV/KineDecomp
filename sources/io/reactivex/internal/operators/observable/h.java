package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.q;

/* compiled from: ObservableJust.java */
/* loaded from: classes3.dex */
public final class h<T> extends io.reactivex.m<T> implements io.reactivex.d.b.l<T> {

    /* renamed from: a, reason: collision with root package name */
    private final T f28336a;

    public h(T t) {
        this.f28336a = t;
    }

    @Override // io.reactivex.m
    protected void b(q<? super T> qVar) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(qVar, this.f28336a);
        qVar.onSubscribe(scalarDisposable);
        scalarDisposable.run();
    }

    @Override // io.reactivex.d.b.l, java.util.concurrent.Callable
    public T call() {
        return this.f28336a;
    }
}
