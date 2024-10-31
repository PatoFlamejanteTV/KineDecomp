package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;

/* loaded from: classes3.dex */
public final class MaybeToFlowable<T> extends io.reactivex.e<T> implements io.reactivex.d.b.f<T> {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.k<T> f28263b;

    /* loaded from: classes3.dex */
    static final class MaybeToFlowableSubscriber<T> extends DeferredScalarSubscription<T> implements io.reactivex.j<T> {
        private static final long serialVersionUID = 7603343402964826922L;
        io.reactivex.disposables.b upstream;

        MaybeToFlowableSubscriber(g.b.b<? super T> bVar) {
            super(bVar);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, g.b.c
        public void cancel() {
            super.cancel();
            this.upstream.dispose();
        }

        @Override // io.reactivex.j
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.j
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.j
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.j
        public void onSuccess(T t) {
            complete(t);
        }
    }

    public MaybeToFlowable(io.reactivex.k<T> kVar) {
        this.f28263b = kVar;
    }

    @Override // io.reactivex.e
    protected void b(g.b.b<? super T> bVar) {
        this.f28263b.a(new MaybeToFlowableSubscriber(bVar));
    }
}
