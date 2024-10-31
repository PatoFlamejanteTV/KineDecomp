package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class FlowableToList<T, U extends Collection<? super T>> extends a<T, U> {

    /* renamed from: c, reason: collision with root package name */
    final Callable<U> f28210c;

    /* loaded from: classes3.dex */
    static final class ToListSubscriber<T, U extends Collection<? super T>> extends DeferredScalarSubscription<U> implements io.reactivex.h<T>, g.b.c {
        private static final long serialVersionUID = -8134157938864266736L;
        g.b.c upstream;

        /* JADX WARN: Multi-variable type inference failed */
        ToListSubscriber(g.b.b<? super U> bVar, U u) {
            super(bVar);
            this.value = u;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, g.b.c
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        @Override // g.b.b
        public void onComplete() {
            complete(this.value);
        }

        @Override // g.b.b
        public void onError(Throwable th) {
            this.value = null;
            this.downstream.onError(th);
        }

        @Override // g.b.b
        public void onNext(T t) {
            Collection collection = (Collection) this.value;
            if (collection != null) {
                collection.add(t);
            }
        }

        @Override // io.reactivex.h, g.b.b
        public void onSubscribe(g.b.c cVar) {
            if (SubscriptionHelper.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableToList(io.reactivex.e<T> eVar, Callable<U> callable) {
        super(eVar);
        this.f28210c = callable;
    }

    @Override // io.reactivex.e
    protected void b(g.b.b<? super U> bVar) {
        try {
            U call = this.f28210c.call();
            io.reactivex.d.a.b.a(call, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
            this.f28211b.a((io.reactivex.h) new ToListSubscriber(bVar, call));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            EmptySubscription.error(th, bVar);
        }
    }
}
