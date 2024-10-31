package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;

/* compiled from: FlowableEmpty.java */
/* loaded from: classes3.dex */
public final class f extends io.reactivex.e<Object> implements io.reactivex.d.b.l<Object> {

    /* renamed from: b, reason: collision with root package name */
    public static final io.reactivex.e<Object> f28231b = new f();

    private f() {
    }

    @Override // io.reactivex.e
    public void b(g.b.b<? super Object> bVar) {
        EmptySubscription.complete(bVar);
    }

    @Override // io.reactivex.d.b.l, java.util.concurrent.Callable
    public Object call() {
        return null;
    }
}
