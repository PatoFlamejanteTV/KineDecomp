package io.reactivex.internal.subscribers;

import g.b.c;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.d;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public class StrictSubscriber<T> extends AtomicInteger implements h<T>, c {
    private static final long serialVersionUID = -4945028590049415624L;
    volatile boolean done;
    final g.b.b<? super T> downstream;
    final AtomicThrowable error = new AtomicThrowable();
    final AtomicLong requested = new AtomicLong();
    final AtomicReference<c> upstream = new AtomicReference<>();
    final AtomicBoolean once = new AtomicBoolean();

    public StrictSubscriber(g.b.b<? super T> bVar) {
        this.downstream = bVar;
    }

    @Override // g.b.c
    public void cancel() {
        if (this.done) {
            return;
        }
        SubscriptionHelper.cancel(this.upstream);
    }

    @Override // g.b.b
    public void onComplete() {
        this.done = true;
        d.a(this.downstream, this, this.error);
    }

    @Override // g.b.b
    public void onError(Throwable th) {
        this.done = true;
        d.a((g.b.b<?>) this.downstream, th, (AtomicInteger) this, this.error);
    }

    @Override // g.b.b
    public void onNext(T t) {
        d.a(this.downstream, t, this, this.error);
    }

    @Override // io.reactivex.h, g.b.b
    public void onSubscribe(c cVar) {
        if (this.once.compareAndSet(false, true)) {
            this.downstream.onSubscribe(this);
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, cVar);
        } else {
            cVar.cancel();
            cancel();
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
        }
    }

    @Override // g.b.c
    public void request(long j) {
        if (j <= 0) {
            cancel();
            onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j));
            return;
        }
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
    }
}
