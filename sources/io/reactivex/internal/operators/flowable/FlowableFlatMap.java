package io.reactivex.internal.operators.flowable;

import io.reactivex.d.b.m;
import io.reactivex.d.b.n;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class FlowableFlatMap<T, U> extends a<T, U> {

    /* renamed from: c, reason: collision with root package name */
    final io.reactivex.c.f<? super T, ? extends g.b.a<? extends U>> f28185c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f28186d;

    /* renamed from: e, reason: collision with root package name */
    final int f28187e;

    /* renamed from: f, reason: collision with root package name */
    final int f28188f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class InnerSubscriber<T, U> extends AtomicReference<g.b.c> implements io.reactivex.h<U>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -4606175640614850599L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long id;
        final int limit;
        final MergeSubscriber<T, U> parent;
        long produced;
        volatile n<U> queue;

        InnerSubscriber(MergeSubscriber<T, U> mergeSubscriber, long j) {
            this.id = j;
            this.parent = mergeSubscriber;
            this.bufferSize = mergeSubscriber.bufferSize;
            this.limit = this.bufferSize >> 2;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        @Override // g.b.b
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // g.b.b
        public void onError(Throwable th) {
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.innerError(this, th);
        }

        @Override // g.b.b
        public void onNext(U u) {
            if (this.fusionMode != 2) {
                this.parent.tryEmit(u, this);
            } else {
                this.parent.drain();
            }
        }

        @Override // io.reactivex.h, g.b.b
        public void onSubscribe(g.b.c cVar) {
            if (SubscriptionHelper.setOnce(this, cVar)) {
                if (cVar instanceof io.reactivex.d.b.k) {
                    io.reactivex.d.b.k kVar = (io.reactivex.d.b.k) cVar;
                    int requestFusion = kVar.requestFusion(7);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = kVar;
                        this.done = true;
                        this.parent.drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = kVar;
                    }
                }
                cVar.request(this.bufferSize);
            }
        }

        void requestMore(long j) {
            if (this.fusionMode != 1) {
                long j2 = this.produced + j;
                if (j2 >= this.limit) {
                    this.produced = 0L;
                    get().request(j2);
                } else {
                    this.produced = j2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class MergeSubscriber<T, U> extends AtomicInteger implements io.reactivex.h<T>, g.b.c {
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final g.b.b<? super U> downstream;
        long lastId;
        int lastIndex;
        final io.reactivex.c.f<? super T, ? extends g.b.a<? extends U>> mapper;
        final int maxConcurrency;
        volatile m<U> queue;
        int scalarEmitted;
        final int scalarLimit;
        long uniqueId;
        g.b.c upstream;
        static final InnerSubscriber<?, ?>[] EMPTY = new InnerSubscriber[0];
        static final InnerSubscriber<?, ?>[] CANCELLED = new InnerSubscriber[0];
        final AtomicThrowable errs = new AtomicThrowable();
        final AtomicReference<InnerSubscriber<?, ?>[]> subscribers = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        MergeSubscriber(g.b.b<? super U> bVar, io.reactivex.c.f<? super T, ? extends g.b.a<? extends U>> fVar, boolean z, int i, int i2) {
            this.downstream = bVar;
            this.mapper = fVar;
            this.delayErrors = z;
            this.maxConcurrency = i;
            this.bufferSize = i2;
            this.scalarLimit = Math.max(1, i >> 1);
            this.subscribers.lazySet(EMPTY);
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean addInner(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                if (innerSubscriberArr == CANCELLED) {
                    innerSubscriber.dispose();
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new InnerSubscriber[length + 1];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, innerSubscriberArr2));
            return true;
        }

        @Override // g.b.c
        public void cancel() {
            m<U> mVar;
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            disposeAll();
            if (getAndIncrement() != 0 || (mVar = this.queue) == null) {
                return;
            }
            mVar.clear();
        }

        boolean checkTerminate() {
            if (this.cancelled) {
                clearScalarQueue();
                return true;
            }
            if (this.delayErrors || this.errs.get() == null) {
                return false;
            }
            clearScalarQueue();
            Throwable terminate = this.errs.terminate();
            if (terminate != ExceptionHelper.f28475a) {
                this.downstream.onError(terminate);
            }
            return true;
        }

        void clearScalarQueue() {
            m<U> mVar = this.queue;
            if (mVar != null) {
                mVar.clear();
            }
        }

        void disposeAll() {
            InnerSubscriber<?, ?>[] andSet;
            InnerSubscriber<?, ?>[] innerSubscriberArr = this.subscribers.get();
            InnerSubscriber<?, ?>[] innerSubscriberArr2 = CANCELLED;
            if (innerSubscriberArr == innerSubscriberArr2 || (andSet = this.subscribers.getAndSet(innerSubscriberArr2)) == CANCELLED) {
                return;
            }
            for (InnerSubscriber<?, ?> innerSubscriber : andSet) {
                innerSubscriber.dispose();
            }
            Throwable terminate = this.errs.terminate();
            if (terminate == null || terminate == ExceptionHelper.f28475a) {
                return;
            }
            io.reactivex.f.a.b(terminate);
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:100:0x0198, code lost:            r24.lastIndex = r4;        r24.lastId = r11[r4].id;        r3 = r16;        r5 = 0;     */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drainLoop() {
            /*
                Method dump skipped, instructions count: 458
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlatMap.MergeSubscriber.drainLoop():void");
        }

        n<U> getInnerQueue(InnerSubscriber<T, U> innerSubscriber) {
            n<U> nVar = innerSubscriber.queue;
            if (nVar != null) {
                return nVar;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.bufferSize);
            innerSubscriber.queue = spscArrayQueue;
            return spscArrayQueue;
        }

        n<U> getMainQueue() {
            m<U> mVar = this.queue;
            if (mVar == null) {
                int i = this.maxConcurrency;
                if (i == Integer.MAX_VALUE) {
                    mVar = new io.reactivex.internal.queue.a<>(this.bufferSize);
                } else {
                    mVar = new SpscArrayQueue(i);
                }
                this.queue = mVar;
            }
            return mVar;
        }

        void innerError(InnerSubscriber<T, U> innerSubscriber, Throwable th) {
            if (this.errs.addThrowable(th)) {
                innerSubscriber.done = true;
                if (!this.delayErrors) {
                    this.upstream.cancel();
                    for (InnerSubscriber<?, ?> innerSubscriber2 : this.subscribers.getAndSet(CANCELLED)) {
                        innerSubscriber2.dispose();
                    }
                }
                drain();
                return;
            }
            io.reactivex.f.a.b(th);
        }

        @Override // g.b.b
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // g.b.b
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.f.a.b(th);
            } else if (this.errs.addThrowable(th)) {
                this.done = true;
                drain();
            } else {
                io.reactivex.f.a.b(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // g.b.b
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                g.b.a<? extends U> apply = this.mapper.apply(t);
                io.reactivex.d.a.b.a(apply, "The mapper returned a null Publisher");
                g.b.a<? extends U> aVar = apply;
                if (aVar instanceof Callable) {
                    try {
                        Object call = ((Callable) aVar).call();
                        if (call != null) {
                            tryEmitScalar(call);
                            return;
                        }
                        if (this.maxConcurrency == Integer.MAX_VALUE || this.cancelled) {
                            return;
                        }
                        int i = this.scalarEmitted + 1;
                        this.scalarEmitted = i;
                        int i2 = this.scalarLimit;
                        if (i == i2) {
                            this.scalarEmitted = 0;
                            this.upstream.request(i2);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.errs.addThrowable(th);
                        drain();
                        return;
                    }
                }
                long j = this.uniqueId;
                this.uniqueId = 1 + j;
                InnerSubscriber innerSubscriber = new InnerSubscriber(this, j);
                if (addInner(innerSubscriber)) {
                    aVar.a(innerSubscriber);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.upstream.cancel();
                onError(th2);
            }
        }

        @Override // io.reactivex.h, g.b.b
        public void onSubscribe(g.b.c cVar) {
            if (SubscriptionHelper.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                int i = this.maxConcurrency;
                if (i == Integer.MAX_VALUE) {
                    cVar.request(Long.MAX_VALUE);
                } else {
                    cVar.request(i);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void removeInner(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber<?, ?>[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                int length = innerSubscriberArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (innerSubscriberArr[i2] == innerSubscriber) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriberArr2 = EMPTY;
                } else {
                    InnerSubscriber<?, ?>[] innerSubscriberArr3 = new InnerSubscriber[length - 1];
                    System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i);
                    System.arraycopy(innerSubscriberArr, i + 1, innerSubscriberArr3, i, (length - i) - 1);
                    innerSubscriberArr2 = innerSubscriberArr3;
                }
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, innerSubscriberArr2));
        }

        @Override // g.b.c
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                drain();
            }
        }

        void tryEmit(U u, InnerSubscriber<T, U> innerSubscriber) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j = this.requested.get();
                n<U> nVar = innerSubscriber.queue;
                if (j != 0 && (nVar == null || nVar.isEmpty())) {
                    this.downstream.onNext(u);
                    if (j != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    innerSubscriber.requestMore(1L);
                } else {
                    if (nVar == null) {
                        nVar = getInnerQueue(innerSubscriber);
                    }
                    if (!nVar.offer(u)) {
                        onError(new MissingBackpressureException("Inner queue full?!"));
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                n nVar2 = innerSubscriber.queue;
                if (nVar2 == null) {
                    nVar2 = new SpscArrayQueue(this.bufferSize);
                    innerSubscriber.queue = nVar2;
                }
                if (!nVar2.offer(u)) {
                    onError(new MissingBackpressureException("Inner queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        void tryEmitScalar(U u) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j = this.requested.get();
                n<U> nVar = this.queue;
                if (j != 0 && (nVar == null || nVar.isEmpty())) {
                    this.downstream.onNext(u);
                    if (j != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                        int i = this.scalarEmitted + 1;
                        this.scalarEmitted = i;
                        int i2 = this.scalarLimit;
                        if (i == i2) {
                            this.scalarEmitted = 0;
                            this.upstream.request(i2);
                        }
                    }
                } else {
                    if (nVar == null) {
                        nVar = getMainQueue();
                    }
                    if (!nVar.offer(u)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!getMainQueue().offer(u)) {
                onError(new IllegalStateException("Scalar queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }
    }

    public FlowableFlatMap(io.reactivex.e<T> eVar, io.reactivex.c.f<? super T, ? extends g.b.a<? extends U>> fVar, boolean z, int i, int i2) {
        super(eVar);
        this.f28185c = fVar;
        this.f28186d = z;
        this.f28187e = i;
        this.f28188f = i2;
    }

    public static <T, U> io.reactivex.h<T> a(g.b.b<? super U> bVar, io.reactivex.c.f<? super T, ? extends g.b.a<? extends U>> fVar, boolean z, int i, int i2) {
        return new MergeSubscriber(bVar, fVar, z, i, i2);
    }

    @Override // io.reactivex.e
    protected void b(g.b.b<? super U> bVar) {
        if (k.a(this.f28211b, bVar, this.f28185c)) {
            return;
        }
        this.f28211b.a((io.reactivex.h) a(bVar, this.f28185c, this.f28186d, this.f28187e, this.f28188f));
    }
}
