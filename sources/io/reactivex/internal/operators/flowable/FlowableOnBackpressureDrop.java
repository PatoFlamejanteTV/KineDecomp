package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public final class FlowableOnBackpressureDrop<T> extends a<T, T> implements io.reactivex.c.e<T> {

    /* renamed from: c, reason: collision with root package name */
    final io.reactivex.c.e<? super T> f28203c;

    /* loaded from: classes3.dex */
    static final class BackpressureDropSubscriber<T> extends AtomicLong implements io.reactivex.h<T>, g.b.c {
        private static final long serialVersionUID = -6246093802440953054L;
        boolean done;
        final g.b.b<? super T> downstream;
        final io.reactivex.c.e<? super T> onDrop;
        g.b.c upstream;

        BackpressureDropSubscriber(g.b.b<? super T> bVar, io.reactivex.c.e<? super T> eVar) {
            this.downstream = bVar;
            this.onDrop = eVar;
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
                return;
            }
            try {
                this.onDrop.accept(t);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                cancel();
                onError(th);
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

    public FlowableOnBackpressureDrop(io.reactivex.e<T> eVar) {
        super(eVar);
        this.f28203c = this;
    }

    @Override // io.reactivex.c.e
    public void accept(T t) {
    }

    @Override // io.reactivex.e
    protected void b(g.b.b<? super T> bVar) {
        this.f28211b.a((io.reactivex.h) new BackpressureDropSubscriber(bVar, this.f28203c));
    }
}
