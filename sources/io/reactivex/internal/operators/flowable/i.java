package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.ScalarSubscription;

/* compiled from: FlowableJust.java */
/* loaded from: classes3.dex */
public final class i<T> extends io.reactivex.e<T> implements io.reactivex.d.b.l<T> {

    /* renamed from: b, reason: collision with root package name */
    private final T f28238b;

    public i(T t) {
        this.f28238b = t;
    }

    @Override // io.reactivex.e
    protected void b(g.b.b<? super T> bVar) {
        bVar.onSubscribe(new ScalarSubscription(bVar, this.f28238b));
    }

    @Override // io.reactivex.d.b.l, java.util.concurrent.Callable
    public T call() {
        return this.f28238b;
    }
}
