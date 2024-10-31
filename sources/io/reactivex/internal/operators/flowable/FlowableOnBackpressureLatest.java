package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class FlowableOnBackpressureLatest<T> extends a<T, T> {

    /* loaded from: classes3.dex */
    static final class BackpressureLatestSubscriber<T> extends AtomicInteger implements io.reactivex.h<T>, g.b.c {
        private static final long serialVersionUID = 163080509307634843L;
        volatile boolean cancelled;
        volatile boolean done;
        final g.b.b<? super T> downstream;
        Throwable error;
        g.b.c upstream;
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<T> current = new AtomicReference<>();

        BackpressureLatestSubscriber(g.b.b<? super T> bVar) {
            this.downstream = bVar;
        }

        @Override // g.b.c
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.current.lazySet(null);
            }
        }

        boolean checkTerminated(boolean z, boolean z2, g.b.b<?> bVar, AtomicReference<T> atomicReference) {
            if (this.cancelled) {
                atomicReference.lazySet(null);
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.error;
            if (th != null) {
                atomicReference.lazySet(null);
                bVar.onError(th);
                return true;
            }
            if (!z2) {
                return false;
            }
            bVar.onComplete();
            return true;
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            g.b.b<? super T> bVar = this.downstream;
            AtomicLong atomicLong = this.requested;
            AtomicReference<T> atomicReference = this.current;
            int i = 1;
            do {
                long j = 0;
                while (true) {
                    if (j == atomicLong.get()) {
                        break;
                    }
                    boolean z = this.done;
                    T andSet = atomicReference.getAndSet(null);
                    boolean z2 = andSet == null;
                    if (checkTerminated(z, z2, bVar, atomicReference)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    bVar.onNext(andSet);
                    j++;
                }
                if (j == atomicLong.get()) {
                    if (checkTerminated(this.done, atomicReference.get() == null, bVar, atomicReference)) {
                        return;
                    }
                }
                if (j != 0) {
                    io.reactivex.internal.util.b.c(atomicLong, j);
                }
                i = addAndGet(-i);
            } while (i != 0);
        }

        @Override // g.b.b
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // g.b.b
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // g.b.b
        public void onNext(T t) {
            this.current.lazySet(t);
            drain();
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
                io.reactivex.internal.util.b.a(this.requested, j);
                drain();
            }
        }
    }

    public FlowableOnBackpressureLatest(io.reactivex.e<T> eVar) {
        super(eVar);
    }

    @Override // io.reactivex.e
    protected void b(g.b.b<? super T> bVar) {
        this.f28211b.a((io.reactivex.h) new BackpressureLatestSubscriber(bVar));
    }
}
