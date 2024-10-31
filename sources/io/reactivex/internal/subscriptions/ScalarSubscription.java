package io.reactivex.internal.subscriptions;

import g.b.b;
import io.reactivex.d.b.k;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class ScalarSubscription<T> extends AtomicInteger implements k<T> {
    static final int CANCELLED = 2;
    static final int NO_REQUEST = 0;
    static final int REQUESTED = 1;
    private static final long serialVersionUID = -3830916580126663321L;
    final b<? super T> subscriber;
    final T value;

    public ScalarSubscription(b<? super T> bVar, T t) {
        this.subscriber = bVar;
        this.value = t;
    }

    @Override // g.b.c
    public void cancel() {
        lazySet(2);
    }

    @Override // io.reactivex.d.b.n
    public void clear() {
        lazySet(1);
    }

    public boolean isCancelled() {
        return get() == 2;
    }

    @Override // io.reactivex.d.b.n
    public boolean isEmpty() {
        return get() != 0;
    }

    @Override // io.reactivex.d.b.n
    public boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.d.b.n
    public T poll() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.value;
    }

    @Override // g.b.c
    public void request(long j) {
        if (SubscriptionHelper.validate(j) && compareAndSet(0, 1)) {
            b<? super T> bVar = this.subscriber;
            bVar.onNext(this.value);
            if (get() != 2) {
                bVar.onComplete();
            }
        }
    }

    @Override // io.reactivex.d.b.j
    public int requestFusion(int i) {
        return i & 1;
    }

    public boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
