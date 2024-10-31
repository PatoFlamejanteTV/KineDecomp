package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class FlowableFlatMapMaybe<T, R> extends a<T, R> {

    /* renamed from: c, reason: collision with root package name */
    final io.reactivex.c.f<? super T, ? extends io.reactivex.k<? extends R>> f28189c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f28190d;

    /* renamed from: e, reason: collision with root package name */
    final int f28191e;

    /* loaded from: classes3.dex */
    static final class FlatMapMaybeSubscriber<T, R> extends AtomicInteger implements io.reactivex.h<T>, g.b.c {
        private static final long serialVersionUID = 8600231336733376951L;
        volatile boolean cancelled;
        final boolean delayErrors;
        final g.b.b<? super R> downstream;
        final io.reactivex.c.f<? super T, ? extends io.reactivex.k<? extends R>> mapper;
        final int maxConcurrency;
        g.b.c upstream;
        final AtomicLong requested = new AtomicLong();
        final io.reactivex.disposables.a set = new io.reactivex.disposables.a();
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicInteger active = new AtomicInteger(1);
        final AtomicReference<io.reactivex.internal.queue.a<R>> queue = new AtomicReference<>();

        /* loaded from: classes3.dex */
        final class InnerObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.j<R>, io.reactivex.disposables.b {
            private static final long serialVersionUID = -502562646270949838L;

            InnerObserver() {
            }

            @Override // io.reactivex.disposables.b
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.b
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // io.reactivex.j
            public void onComplete() {
                FlatMapMaybeSubscriber.this.innerComplete(this);
            }

            @Override // io.reactivex.j
            public void onError(Throwable th) {
                FlatMapMaybeSubscriber.this.innerError(this, th);
            }

            @Override // io.reactivex.j
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.j
            public void onSuccess(R r) {
                FlatMapMaybeSubscriber.this.innerSuccess(this, r);
            }
        }

        FlatMapMaybeSubscriber(g.b.b<? super R> bVar, io.reactivex.c.f<? super T, ? extends io.reactivex.k<? extends R>> fVar, boolean z, int i) {
            this.downstream = bVar;
            this.mapper = fVar;
            this.delayErrors = z;
            this.maxConcurrency = i;
        }

        @Override // g.b.c
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.set.dispose();
        }

        void clear() {
            io.reactivex.internal.queue.a<R> aVar = this.queue.get();
            if (aVar != null) {
                aVar.clear();
            }
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x0075, code lost:            if (r9 != r5) goto L65;     */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0079, code lost:            if (r15.cancelled == false) goto L43;     */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0081, code lost:            if (r15.delayErrors != false) goto L49;     */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x008b, code lost:            if (r15.errors.get() == null) goto L49;     */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x008d, code lost:            r1 = r15.errors.terminate();        clear();        r0.onError(r1);     */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0099, code lost:            return;     */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x009e, code lost:            if (r1.get() != 0) goto L52;     */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00a0, code lost:            r5 = true;     */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00a3, code lost:            r6 = r2.get();     */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00a9, code lost:            if (r6 == null) goto L57;     */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00af, code lost:            if (r6.isEmpty() == false) goto L58;     */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00b2, code lost:            if (r5 == false) goto L65;     */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00b4, code lost:            if (r11 == false) goto L65;     */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00b6, code lost:            r1 = r15.errors.terminate();     */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00bc, code lost:            if (r1 == null) goto L63;     */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00be, code lost:            r0.onError(r1);     */
        /* JADX WARN: Code restructure failed: missing block: B:59:?, code lost:            return;     */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00c2, code lost:            r0.onComplete();     */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00c5, code lost:            return;     */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00b1, code lost:            r11 = true;     */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00a2, code lost:            r5 = false;     */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x007b, code lost:            clear();     */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x007e, code lost:            return;     */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00c8, code lost:            if (r9 == 0) goto L70;     */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00ca, code lost:            io.reactivex.internal.util.b.c(r15.requested, r9);     */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x00d4, code lost:            if (r15.maxConcurrency == Integer.MAX_VALUE) goto L70;     */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x00d6, code lost:            r15.upstream.request(r9);     */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x00db, code lost:            r4 = addAndGet(-r4);     */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drainLoop() {
            /*
                Method dump skipped, instructions count: 227
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe.FlatMapMaybeSubscriber.drainLoop():void");
        }

        io.reactivex.internal.queue.a<R> getOrCreateQueue() {
            io.reactivex.internal.queue.a<R> aVar;
            do {
                io.reactivex.internal.queue.a<R> aVar2 = this.queue.get();
                if (aVar2 != null) {
                    return aVar2;
                }
                aVar = new io.reactivex.internal.queue.a<>(io.reactivex.e.a());
            } while (!this.queue.compareAndSet(null, aVar));
            return aVar;
        }

        void innerComplete(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver) {
            this.set.c(innerObserver);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    boolean z = this.active.decrementAndGet() == 0;
                    io.reactivex.internal.queue.a<R> aVar = this.queue.get();
                    if (z && (aVar == null || aVar.isEmpty())) {
                        Throwable terminate = this.errors.terminate();
                        if (terminate != null) {
                            this.downstream.onError(terminate);
                            return;
                        } else {
                            this.downstream.onComplete();
                            return;
                        }
                    }
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        this.upstream.request(1L);
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    drainLoop();
                    return;
                }
            }
            this.active.decrementAndGet();
            if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.upstream.request(1L);
            }
            drain();
        }

        void innerError(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, Throwable th) {
            this.set.c(innerObserver);
            if (this.errors.addThrowable(th)) {
                if (!this.delayErrors) {
                    this.upstream.cancel();
                    this.set.dispose();
                } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.upstream.request(1L);
                }
                this.active.decrementAndGet();
                drain();
                return;
            }
            io.reactivex.f.a.b(th);
        }

        void innerSuccess(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, R r) {
            this.set.c(innerObserver);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    boolean z = this.active.decrementAndGet() == 0;
                    if (this.requested.get() != 0) {
                        this.downstream.onNext(r);
                        io.reactivex.internal.queue.a<R> aVar = this.queue.get();
                        if (z && (aVar == null || aVar.isEmpty())) {
                            Throwable terminate = this.errors.terminate();
                            if (terminate != null) {
                                this.downstream.onError(terminate);
                                return;
                            } else {
                                this.downstream.onComplete();
                                return;
                            }
                        }
                        io.reactivex.internal.util.b.c(this.requested, 1L);
                        if (this.maxConcurrency != Integer.MAX_VALUE) {
                            this.upstream.request(1L);
                        }
                    } else {
                        io.reactivex.internal.queue.a<R> orCreateQueue = getOrCreateQueue();
                        synchronized (orCreateQueue) {
                            orCreateQueue.offer(r);
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    drainLoop();
                }
            }
            io.reactivex.internal.queue.a<R> orCreateQueue2 = getOrCreateQueue();
            synchronized (orCreateQueue2) {
                orCreateQueue2.offer(r);
            }
            this.active.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        @Override // g.b.b
        public void onComplete() {
            this.active.decrementAndGet();
            drain();
        }

        @Override // g.b.b
        public void onError(Throwable th) {
            this.active.decrementAndGet();
            if (this.errors.addThrowable(th)) {
                if (!this.delayErrors) {
                    this.set.dispose();
                }
                drain();
                return;
            }
            io.reactivex.f.a.b(th);
        }

        @Override // g.b.b
        public void onNext(T t) {
            try {
                io.reactivex.k<? extends R> apply = this.mapper.apply(t);
                io.reactivex.d.a.b.a(apply, "The mapper returned a null MaybeSource");
                io.reactivex.k<? extends R> kVar = apply;
                this.active.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (this.cancelled || !this.set.b(innerObserver)) {
                    return;
                }
                kVar.a(innerObserver);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.upstream.cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.h, g.b.b
        public void onSubscribe(g.b.c cVar) {
            if (SubscriptionHelper.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
                int i = this.maxConcurrency;
                if (i == Integer.MAX_VALUE) {
                    cVar.request(Long.MAX_VALUE);
                } else {
                    cVar.request(i);
                }
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

    public FlowableFlatMapMaybe(io.reactivex.e<T> eVar, io.reactivex.c.f<? super T, ? extends io.reactivex.k<? extends R>> fVar, boolean z, int i) {
        super(eVar);
        this.f28189c = fVar;
        this.f28190d = z;
        this.f28191e = i;
    }

    @Override // io.reactivex.e
    protected void b(g.b.b<? super R> bVar) {
        this.f28211b.a((io.reactivex.h) new FlatMapMaybeSubscriber(bVar, this.f28189c, this.f28190d, this.f28191e));
    }
}
