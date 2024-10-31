package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public final class FlowableOnBackpressureError<T> extends a<T, T> {

    /* loaded from: classes3.dex */
    static final class BackpressureErrorSubscriber<T> extends AtomicLong implements io.reactivex.h<T>, g.b.c {
        private static final long serialVersionUID = -3176480756392482682L;
        boolean done;
        final g.b.b<? super T> downstream;
        g.b.c upstream;

        BackpressureErrorSubscriber(g.b.b<? super T> bVar) {
            this.downstream = bVar;
        }

        @Override // g.b.c
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // g.b.b
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.downstream.onComplete();
        }

        @Override // g.b.b
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.f.a.b(th);
            } else {
                this.done = true;
                this.downstream.onError(th);
            }
        }

        @Override // g.b.b
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (get() != 0) {
                this.downstream.onNext(t);
                io.reactivex.internal.util.b.c(this, 1L);
            } else {
                onError(new MissingBackpressureException("could not emit value due to lack of requests"));
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

        @Override // g.b.c
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this, j);
            }
        }
    }

    public FlowableOnBackpressureError(io.reactivex.e<T> eVar) {
        super(eVar);
    }

    @Override // io.reactivex.e
    protected void b(g.b.b<? super T> bVar) {
        this.f28211b.a((io.reactivex.h) new BackpressureErrorSubscriber(bVar));
    }
}
