package io.reactivex.internal.operators.flowable;

import io.reactivex.d.b.m;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public final class FlowableOnBackpressureBuffer<T> extends a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final int f28199c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f28200d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f28201e;

    /* renamed from: f, reason: collision with root package name */
    final io.reactivex.c.a f28202f;

    /* loaded from: classes3.dex */
    static final class BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements io.reactivex.h<T> {
        private static final long serialVersionUID = -2514538129242366402L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        final g.b.b<? super T> downstream;
        Throwable error;
        final io.reactivex.c.a onOverflow;
        boolean outputFused;
        final m<T> queue;
        final AtomicLong requested = new AtomicLong();
        g.b.c upstream;

        BackpressureBufferSubscriber(g.b.b<? super T> bVar, int i, boolean z, boolean z2, io.reactivex.c.a aVar) {
            m<T> spscArrayQueue;
            this.downstream = bVar;
            this.onOverflow = aVar;
            this.delayError = z2;
            if (z) {
                spscArrayQueue = new io.reactivex.internal.queue.a<>(i);
            } else {
                spscArrayQueue = new SpscArrayQueue<>(i);
            }
            this.queue = spscArrayQueue;
        }

        @Override // g.b.c
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        boolean checkTerminated(boolean z, boolean z2, g.b.b<? super T> bVar) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.delayError) {
                if (!z2) {
                    return false;
                }
                Throwable th = this.error;
                if (th != null) {
                    bVar.onError(th);
                } else {
                    bVar.onComplete();
                }
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                bVar.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            bVar.onComplete();
            return true;
        }

        @Override // io.reactivex.d.b.n
        public void clear() {
            this.queue.clear();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                m<T> mVar = this.queue;
                g.b.b<? super T> bVar = this.downstream;
                int i = 1;
                while (!checkTerminated(this.done, mVar.isEmpty(), bVar)) {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (j2 != j) {
                        boolean z = this.done;
                        T poll = mVar.poll();
                        boolean z2 = poll == null;
                        if (checkTerminated(z, z2, bVar)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        bVar.onNext(poll);
                        j2++;
                    }
                    if (j2 == j && checkTerminated(this.done, mVar.isEmpty(), bVar)) {
                        return;
                    }
                    if (j2 != 0 && j != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j2);
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.d.b.n
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // g.b.b
        public void onComplete() {
            this.done = true;
            if (this.outputFused) {
                this.downstream.onComplete();
            } else {
                drain();
            }
        }

        @Override // g.b.b
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (this.outputFused) {
                this.downstream.onError(th);
            } else {
                drain();
            }
        }

        @Override // g.b.b
        public void onNext(T t) {
            if (!this.queue.offer(t)) {
                this.upstream.cancel();
                MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
                try {
                    this.onOverflow.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    missingBackpressureException.initCause(th);
                }
                onError(missingBackpressureException);
                return;
            }
            if (this.outputFused) {
                this.downstream.onNext(null);
            } else {
                drain();
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

        @Override // io.reactivex.d.b.n
        public T poll() throws Exception {
            return this.queue.poll();
        }

        @Override // g.b.c
        public void request(long j) {
            if (this.outputFused || !SubscriptionHelper.validate(j)) {
                return;
            }
            io.reactivex.internal.util.b.a(this.requested, j);
            drain();
        }

        @Override // io.reactivex.d.b.j
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }
    }

    public FlowableOnBackpressureBuffer(io.reactivex.e<T> eVar, int i, boolean z, boolean z2, io.reactivex.c.a aVar) {
        super(eVar);
        this.f28199c = i;
        this.f28200d = z;
        this.f28201e = z2;
        this.f28202f = aVar;
    }

    @Override // io.reactivex.e
    protected void b(g.b.b<? super T> bVar) {
        this.f28211b.a((io.reactivex.h) new BackpressureBufferSubscriber(bVar, this.f28199c, this.f28200d, this.f28201e, this.f28202f));
    }
}
