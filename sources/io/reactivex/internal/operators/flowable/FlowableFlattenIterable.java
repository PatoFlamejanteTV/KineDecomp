package io.reactivex.internal.operators.flowable;

import io.reactivex.d.b.n;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class FlowableFlattenIterable<T, R> extends a<T, R> {

    /* renamed from: c, reason: collision with root package name */
    final io.reactivex.c.f<? super T, ? extends Iterable<? extends R>> f28192c;

    /* renamed from: d, reason: collision with root package name */
    final int f28193d;

    /* loaded from: classes3.dex */
    static final class FlattenIterableSubscriber<T, R> extends BasicIntQueueSubscription<R> implements io.reactivex.h<T> {
        private static final long serialVersionUID = -3096000382929934955L;
        volatile boolean cancelled;
        int consumed;
        Iterator<? extends R> current;
        volatile boolean done;
        final g.b.b<? super R> downstream;
        int fusionMode;
        final int limit;
        final io.reactivex.c.f<? super T, ? extends Iterable<? extends R>> mapper;
        final int prefetch;
        n<T> queue;
        g.b.c upstream;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        FlattenIterableSubscriber(g.b.b<? super R> bVar, io.reactivex.c.f<? super T, ? extends Iterable<? extends R>> fVar, int i) {
            this.downstream = bVar;
            this.mapper = fVar;
            this.prefetch = i;
            this.limit = i - (i >> 2);
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

        boolean checkTerminated(boolean z, boolean z2, g.b.b<?> bVar, n<?> nVar) {
            if (this.cancelled) {
                this.current = null;
                nVar.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.error.get() == null) {
                if (!z2) {
                    return false;
                }
                bVar.onComplete();
                return true;
            }
            Throwable a2 = ExceptionHelper.a(this.error);
            this.current = null;
            nVar.clear();
            bVar.onError(a2);
            return true;
        }

        @Override // io.reactivex.d.b.n
        public void clear() {
            this.current = null;
            this.queue.clear();
        }

        void consumedOne(boolean z) {
            if (z) {
                int i = this.consumed + 1;
                if (i == this.limit) {
                    this.consumed = 0;
                    this.upstream.request(i);
                } else {
                    this.consumed = i;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:41:0x00f7, code lost:            if (r13 != r9) goto L62;     */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00f9, code lost:            r5 = r18.done;     */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00ff, code lost:            if (r3.isEmpty() == false) goto L58;     */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0101, code lost:            if (r6 != null) goto L58;     */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0103, code lost:            r15 = true;     */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x010a, code lost:            if (checkTerminated(r5, r15, r2, r3) == false) goto L62;     */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x010c, code lost:            return;     */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0105, code lost:            r15 = false;     */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x010f, code lost:            if (r13 == 0) goto L67;     */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0118, code lost:            if (r9 == Long.MAX_VALUE) goto L67;     */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x011a, code lost:            r18.requested.addAndGet(-r13);     */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0120, code lost:            if (r6 != null) goto L69;     */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drain() {
            /*
                Method dump skipped, instructions count: 302
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlattenIterable.FlattenIterableSubscriber.drain():void");
        }

        @Override // io.reactivex.d.b.n
        public boolean isEmpty() {
            return this.current == null && this.queue.isEmpty();
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
            if (!this.done && ExceptionHelper.a(this.error, th)) {
                this.done = true;
                drain();
            } else {
                io.reactivex.f.a.b(th);
            }
        }

        @Override // g.b.b
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.fusionMode == 0 && !this.queue.offer(t)) {
                onError(new MissingBackpressureException("Queue is full?!"));
            } else {
                drain();
            }
        }

        @Override // io.reactivex.h, g.b.b
        public void onSubscribe(g.b.c cVar) {
            if (SubscriptionHelper.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                if (cVar instanceof io.reactivex.d.b.k) {
                    io.reactivex.d.b.k kVar = (io.reactivex.d.b.k) cVar;
                    int requestFusion = kVar.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = kVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                    if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = kVar;
                        this.downstream.onSubscribe(this);
                        cVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.downstream.onSubscribe(this);
                cVar.request(this.prefetch);
            }
        }

        @Override // io.reactivex.d.b.n
        public R poll() throws Exception {
            Iterator<? extends R> it = this.current;
            while (true) {
                if (it == null) {
                    T poll = this.queue.poll();
                    if (poll != null) {
                        it = this.mapper.apply(poll).iterator();
                        if (it.hasNext()) {
                            this.current = it;
                            break;
                        }
                        it = null;
                    } else {
                        return null;
                    }
                } else {
                    break;
                }
            }
            R next = it.next();
            io.reactivex.d.a.b.a(next, "The iterator returned a null value");
            if (!it.hasNext()) {
                this.current = null;
            }
            return next;
        }

        @Override // g.b.c
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                drain();
            }
        }

        @Override // io.reactivex.d.b.j
        public int requestFusion(int i) {
            return ((i & 1) == 0 || this.fusionMode != 1) ? 0 : 1;
        }
    }

    public FlowableFlattenIterable(io.reactivex.e<T> eVar, io.reactivex.c.f<? super T, ? extends Iterable<? extends R>> fVar, int i) {
        super(eVar);
        this.f28192c = fVar;
        this.f28193d = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.e
    public void b(g.b.b<? super R> bVar) {
        io.reactivex.e<T> eVar = this.f28211b;
        if (eVar instanceof Callable) {
            try {
                Object call = ((Callable) eVar).call();
                if (call == null) {
                    EmptySubscription.complete(bVar);
                    return;
                }
                try {
                    FlowableFromIterable.a(bVar, this.f28192c.apply(call).iterator());
                    return;
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    EmptySubscription.error(th, bVar);
                    return;
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                EmptySubscription.error(th2, bVar);
                return;
            }
        }
        eVar.a((io.reactivex.h) new FlattenIterableSubscriber(bVar, this.f28192c, this.f28193d));
    }
}
