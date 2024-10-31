package io.reactivex.internal.operators.flowable;

import io.reactivex.d.b.n;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class FlowableConcatMap<T, R> extends io.reactivex.internal.operators.flowable.a<T, R> {

    /* renamed from: c, reason: collision with root package name */
    final io.reactivex.c.f<? super T, ? extends g.b.a<? extends R>> f28174c;

    /* renamed from: d, reason: collision with root package name */
    final int f28175d;

    /* renamed from: e, reason: collision with root package name */
    final ErrorMode f28176e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static abstract class BaseConcatMapSubscriber<T, R> extends AtomicInteger implements io.reactivex.h<T>, a<R>, g.b.c {
        private static final long serialVersionUID = -3511336836796789179L;
        volatile boolean active;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        final int limit;
        final io.reactivex.c.f<? super T, ? extends g.b.a<? extends R>> mapper;
        final int prefetch;
        n<T> queue;
        int sourceMode;
        g.b.c upstream;
        final ConcatMapInner<R> inner = new ConcatMapInner<>(this);
        final AtomicThrowable errors = new AtomicThrowable();

        BaseConcatMapSubscriber(io.reactivex.c.f<? super T, ? extends g.b.a<? extends R>> fVar, int i) {
            this.mapper = fVar;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        abstract void drain();

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.a
        public final void innerComplete() {
            this.active = false;
            drain();
        }

        @Override // g.b.b
        public final void onComplete() {
            this.done = true;
            drain();
        }

        @Override // g.b.b
        public final void onNext(T t) {
            if (this.sourceMode != 2 && !this.queue.offer(t)) {
                this.upstream.cancel();
                onError(new IllegalStateException("Queue full?!"));
            } else {
                drain();
            }
        }

        @Override // io.reactivex.h, g.b.b
        public final void onSubscribe(g.b.c cVar) {
            if (SubscriptionHelper.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                if (cVar instanceof io.reactivex.d.b.k) {
                    io.reactivex.d.b.k kVar = (io.reactivex.d.b.k) cVar;
                    int requestFusion = kVar.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = kVar;
                        this.done = true;
                        subscribeActual();
                        drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = kVar;
                        subscribeActual();
                        cVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                subscribeActual();
                cVar.request(this.prefetch);
            }
        }

        abstract void subscribeActual();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ConcatMapDelayed<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = -2945777694260521066L;
        final g.b.b<? super R> downstream;
        final boolean veryEnd;

        ConcatMapDelayed(g.b.b<? super R> bVar, io.reactivex.c.f<? super T, ? extends g.b.a<? extends R>> fVar, int i, boolean z) {
            super(fVar, i);
            this.downstream = bVar;
            this.veryEnd = z;
        }

        @Override // g.b.c
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.inner.cancel();
            this.upstream.cancel();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void drain() {
            if (getAndIncrement() == 0) {
                while (!this.cancelled) {
                    if (!this.active) {
                        boolean z = this.done;
                        if (z && !this.veryEnd && this.errors.get() != null) {
                            this.downstream.onError(this.errors.terminate());
                            return;
                        }
                        try {
                            T poll = this.queue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                Throwable terminate = this.errors.terminate();
                                if (terminate != null) {
                                    this.downstream.onError(terminate);
                                    return;
                                } else {
                                    this.downstream.onComplete();
                                    return;
                                }
                            }
                            if (!z2) {
                                try {
                                    g.b.a<? extends R> apply = this.mapper.apply(poll);
                                    io.reactivex.d.a.b.a(apply, "The mapper returned a null Publisher");
                                    g.b.a<? extends R> aVar = apply;
                                    if (this.sourceMode != 1) {
                                        int i = this.consumed + 1;
                                        if (i == this.limit) {
                                            this.consumed = 0;
                                            this.upstream.request(i);
                                        } else {
                                            this.consumed = i;
                                        }
                                    }
                                    if (aVar instanceof Callable) {
                                        try {
                                            Object call = ((Callable) aVar).call();
                                            if (call == null) {
                                                continue;
                                            } else if (this.inner.isUnbounded()) {
                                                this.downstream.onNext(call);
                                            } else {
                                                this.active = true;
                                                ConcatMapInner<R> concatMapInner = this.inner;
                                                concatMapInner.setSubscription(new b(call, concatMapInner));
                                            }
                                        } catch (Throwable th) {
                                            io.reactivex.exceptions.a.b(th);
                                            this.upstream.cancel();
                                            this.errors.addThrowable(th);
                                            this.downstream.onError(this.errors.terminate());
                                            return;
                                        }
                                    } else {
                                        this.active = true;
                                        aVar.a(this.inner);
                                    }
                                } catch (Throwable th2) {
                                    io.reactivex.exceptions.a.b(th2);
                                    this.upstream.cancel();
                                    this.errors.addThrowable(th2);
                                    this.downstream.onError(this.errors.terminate());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            io.reactivex.exceptions.a.b(th3);
                            this.upstream.cancel();
                            this.errors.addThrowable(th3);
                            this.downstream.onError(this.errors.terminate());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.a
        public void innerError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (!this.veryEnd) {
                    this.upstream.cancel();
                    this.done = true;
                }
                this.active = false;
                drain();
                return;
            }
            io.reactivex.f.a.b(th);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.a
        public void innerNext(R r) {
            this.downstream.onNext(r);
        }

        @Override // g.b.b
        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                this.done = true;
                drain();
            } else {
                io.reactivex.f.a.b(th);
            }
        }

        @Override // g.b.c
        public void request(long j) {
            this.inner.request(j);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void subscribeActual() {
            this.downstream.onSubscribe(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ConcatMapImmediate<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = 7898995095634264146L;
        final g.b.b<? super R> downstream;
        final AtomicInteger wip;

        ConcatMapImmediate(g.b.b<? super R> bVar, io.reactivex.c.f<? super T, ? extends g.b.a<? extends R>> fVar, int i) {
            super(fVar, i);
            this.downstream = bVar;
            this.wip = new AtomicInteger();
        }

        @Override // g.b.c
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.inner.cancel();
            this.upstream.cancel();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                while (!this.cancelled) {
                    if (!this.active) {
                        boolean z = this.done;
                        try {
                            T poll = this.queue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.downstream.onComplete();
                                return;
                            }
                            if (!z2) {
                                try {
                                    g.b.a<? extends R> apply = this.mapper.apply(poll);
                                    io.reactivex.d.a.b.a(apply, "The mapper returned a null Publisher");
                                    g.b.a<? extends R> aVar = apply;
                                    if (this.sourceMode != 1) {
                                        int i = this.consumed + 1;
                                        if (i == this.limit) {
                                            this.consumed = 0;
                                            this.upstream.request(i);
                                        } else {
                                            this.consumed = i;
                                        }
                                    }
                                    if (aVar instanceof Callable) {
                                        try {
                                            Object call = ((Callable) aVar).call();
                                            if (call == null) {
                                                continue;
                                            } else if (this.inner.isUnbounded()) {
                                                if (get() == 0 && compareAndSet(0, 1)) {
                                                    this.downstream.onNext(call);
                                                    if (!compareAndSet(1, 0)) {
                                                        this.downstream.onError(this.errors.terminate());
                                                        return;
                                                    }
                                                }
                                            } else {
                                                this.active = true;
                                                ConcatMapInner<R> concatMapInner = this.inner;
                                                concatMapInner.setSubscription(new b(call, concatMapInner));
                                            }
                                        } catch (Throwable th) {
                                            io.reactivex.exceptions.a.b(th);
                                            this.upstream.cancel();
                                            this.errors.addThrowable(th);
                                            this.downstream.onError(this.errors.terminate());
                                            return;
                                        }
                                    } else {
                                        this.active = true;
                                        aVar.a(this.inner);
                                    }
                                } catch (Throwable th2) {
                                    io.reactivex.exceptions.a.b(th2);
                                    this.upstream.cancel();
                                    this.errors.addThrowable(th2);
                                    this.downstream.onError(this.errors.terminate());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            io.reactivex.exceptions.a.b(th3);
                            this.upstream.cancel();
                            this.errors.addThrowable(th3);
                            this.downstream.onError(this.errors.terminate());
                            return;
                        }
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.a
        public void innerError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.downstream.onError(this.errors.terminate());
                    return;
                }
                return;
            }
            io.reactivex.f.a.b(th);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.a
        public void innerNext(R r) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.downstream.onNext(r);
                if (compareAndSet(1, 0)) {
                    return;
                }
                this.downstream.onError(this.errors.terminate());
            }
        }

        @Override // g.b.b
        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                this.inner.cancel();
                if (getAndIncrement() == 0) {
                    this.downstream.onError(this.errors.terminate());
                    return;
                }
                return;
            }
            io.reactivex.f.a.b(th);
        }

        @Override // g.b.c
        public void request(long j) {
            this.inner.request(j);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void subscribeActual() {
            this.downstream.onSubscribe(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ConcatMapInner<R> extends SubscriptionArbiter implements io.reactivex.h<R> {
        private static final long serialVersionUID = 897683679971470653L;
        final a<R> parent;
        long produced;

        ConcatMapInner(a<R> aVar) {
            super(false);
            this.parent = aVar;
        }

        @Override // g.b.b
        public void onComplete() {
            long j = this.produced;
            if (j != 0) {
                this.produced = 0L;
                produced(j);
            }
            this.parent.innerComplete();
        }

        @Override // g.b.b
        public void onError(Throwable th) {
            long j = this.produced;
            if (j != 0) {
                this.produced = 0L;
                produced(j);
            }
            this.parent.innerError(th);
        }

        @Override // g.b.b
        public void onNext(R r) {
            this.produced++;
            this.parent.innerNext(r);
        }

        @Override // io.reactivex.h, g.b.b
        public void onSubscribe(g.b.c cVar) {
            setSubscription(cVar);
        }
    }

    /* loaded from: classes3.dex */
    interface a<T> {
        void innerComplete();

        void innerError(Throwable th);

        void innerNext(T t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class b<T> implements g.b.c {

        /* renamed from: a, reason: collision with root package name */
        final g.b.b<? super T> f28177a;

        /* renamed from: b, reason: collision with root package name */
        final T f28178b;

        /* renamed from: c, reason: collision with root package name */
        boolean f28179c;

        b(T t, g.b.b<? super T> bVar) {
            this.f28178b = t;
            this.f28177a = bVar;
        }

        @Override // g.b.c
        public void cancel() {
        }

        @Override // g.b.c
        public void request(long j) {
            if (j <= 0 || this.f28179c) {
                return;
            }
            this.f28179c = true;
            g.b.b<? super T> bVar = this.f28177a;
            bVar.onNext(this.f28178b);
            bVar.onComplete();
        }
    }

    public FlowableConcatMap(io.reactivex.e<T> eVar, io.reactivex.c.f<? super T, ? extends g.b.a<? extends R>> fVar, int i, ErrorMode errorMode) {
        super(eVar);
        this.f28174c = fVar;
        this.f28175d = i;
        this.f28176e = errorMode;
    }

    public static <T, R> g.b.b<T> a(g.b.b<? super R> bVar, io.reactivex.c.f<? super T, ? extends g.b.a<? extends R>> fVar, int i, ErrorMode errorMode) {
        int i2 = io.reactivex.internal.operators.flowable.b.f28212a[errorMode.ordinal()];
        if (i2 == 1) {
            return new ConcatMapDelayed(bVar, fVar, i, false);
        }
        if (i2 != 2) {
            return new ConcatMapImmediate(bVar, fVar, i);
        }
        return new ConcatMapDelayed(bVar, fVar, i, true);
    }

    @Override // io.reactivex.e
    protected void b(g.b.b<? super R> bVar) {
        if (k.a(this.f28211b, bVar, this.f28174c)) {
            return;
        }
        this.f28211b.a((g.b.b) a(bVar, this.f28174c, this.f28175d, this.f28176e));
    }
}
