package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public final class FlowableElementAt<T> extends a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final long f28182c;

    /* renamed from: d, reason: collision with root package name */
    final T f28183d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f28184e;

    /* loaded from: classes3.dex */
    static final class ElementAtSubscriber<T> extends DeferredScalarSubscription<T> implements io.reactivex.h<T> {
        private static final long serialVersionUID = 4066607327284737757L;
        long count;
        final T defaultValue;
        boolean done;
        final boolean errorOnFewer;
        final long index;
        g.b.c upstream;

        ElementAtSubscriber(g.b.b<? super T> bVar, long j, T t, boolean z) {
            super(bVar);
            this.index = j;
            this.defaultValue = t;
            this.errorOnFewer = z;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, g.b.c
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        @Override // g.b.b
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            T t = this.defaultValue;
            if (t == null) {
                if (this.errorOnFewer) {
                    this.downstream.onError(new NoSuchElementException());
                    return;
                } else {
                    this.downstream.onComplete();
                    return;
                }
            }
            complete(t);
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
            long j = this.count;
            if (j == this.index) {
                this.done = true;
                this.upstream.cancel();
                complete(t);
                return;
            }
            this.count = j + 1;
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

    public FlowableElementAt(io.reactivex.e<T> eVar, long j, T t, boolean z) {
        super(eVar);
        this.f28182c = j;
        this.f28183d = t;
        this.f28184e = z;
    }

    @Override // io.reactivex.e
    protected void b(g.b.b<? super T> bVar) {
        this.f28211b.a((io.reactivex.h) new ElementAtSubscriber(bVar, this.f28182c, this.f28183d, this.f28184e));
    }
}
