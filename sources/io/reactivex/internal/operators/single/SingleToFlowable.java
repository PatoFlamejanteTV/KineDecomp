package io.reactivex.internal.operators.single;

import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.t;
import io.reactivex.u;

/* loaded from: classes3.dex */
public final class SingleToFlowable<T> extends e<T> {

    /* renamed from: b, reason: collision with root package name */
    final u<? extends T> f28366b;

    /* loaded from: classes3.dex */
    static final class SingleToFlowableObserver<T> extends DeferredScalarSubscription<T> implements t<T> {
        private static final long serialVersionUID = 187782011903685568L;
        io.reactivex.disposables.b upstream;

        SingleToFlowableObserver(g.b.b<? super T> bVar) {
            super(bVar);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, g.b.c
        public void cancel() {
            super.cancel();
            this.upstream.dispose();
        }

        @Override // io.reactivex.t
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.t
        public void onSuccess(T t) {
            complete(t);
        }
    }

    public SingleToFlowable(u<? extends T> uVar) {
        this.f28366b = uVar;
    }

    @Override // io.reactivex.e
    public void b(g.b.b<? super T> bVar) {
        this.f28366b.a(new SingleToFlowableObserver(bVar));
    }
}
