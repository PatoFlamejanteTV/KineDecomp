package io.reactivex.internal.operators.flowable;

import io.reactivex.d.b.n;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public final class FlowableObserveOn<T> extends a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final r f28196c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f28197d;

    /* renamed from: e, reason: collision with root package name */
    final int f28198e;

    /* loaded from: classes3.dex */
    static abstract class BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements io.reactivex.h<T>, Runnable {
        private static final long serialVersionUID = -8241002408341274697L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final int limit;
        boolean outputFused;
        final int prefetch;
        long produced;
        n<T> queue;
        final AtomicLong requested = new AtomicLong();
        int sourceMode;
        g.b.c upstream;
        final r.b worker;

        BaseObserveOnSubscriber(r.b bVar, boolean z, int i) {
            this.worker = bVar;
            this.delayError = z;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        @Override // g.b.c
        public final void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        final boolean checkTerminated(boolean z, boolean z2, g.b.b<?> bVar) {
            if (this.cancelled) {
                clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.delayError) {
                if (!z2) {
                    return false;
                }
                this.cancelled = true;
                Throwable th = this.error;
                if (th != null) {
                    bVar.onError(th);
                } else {
                    bVar.onComplete();
                }
                this.worker.dispose();
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.cancelled = true;
                clear();
                bVar.onError(th2);
                this.worker.dispose();
                return true;
            }
            if (!z2) {
                return false;
            }
            this.cancelled = true;
            bVar.onComplete();
            this.worker.dispose();
            return true;
        }

        @Override // io.reactivex.d.b.n
        public final void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.d.b.n
        public final boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // g.b.b
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            trySchedule();
        }

        @Override // g.b.b
        public final void onError(Throwable th) {
            if (this.done) {
                io.reactivex.f.a.b(th);
                return;
            }
            this.error = th;
            this.done = true;
            trySchedule();
        }

        @Override // g.b.b
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode == 2) {
                trySchedule();
                return;
            }
            if (!this.queue.offer(t)) {
                this.upstream.cancel();
                this.error = new MissingBackpressureException("Queue is full?!");
                this.done = true;
            }
            trySchedule();
        }

        @Override // g.b.c
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                trySchedule();
            }
        }

        @Override // io.reactivex.d.b.j
        public final int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.outputFused) {
                runBackfused();
            } else if (this.sourceMode == 1) {
                runSync();
            } else {
                runAsync();
            }
        }

        abstract void runAsync();

        abstract void runBackfused();

        abstract void runSync();

        final void trySchedule() {
            if (getAndIncrement() != 0) {
                return;
            }
            this.worker.a(this);
        }
    }

    /* loaded from: classes3.dex */
    static final class ObserveOnConditionalSubscriber<T> extends BaseObserveOnSubscriber<T> {
        private static final long serialVersionUID = 644624475404284533L;
        long consumed;
        final io.reactivex.d.b.a<? super T> downstream;

        ObserveOnConditionalSubscriber(io.reactivex.d.b.a<? super T> aVar, r.b bVar, boolean z, int i) {
            super(bVar, z, i);
            this.downstream = aVar;
        }

        @Override // io.reactivex.h, g.b.b
        public void onSubscribe(g.b.c cVar) {
            if (SubscriptionHelper.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                if (cVar instanceof io.reactivex.d.b.k) {
                    io.reactivex.d.b.k kVar = (io.reactivex.d.b.k) cVar;
                    int requestFusion = kVar.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = kVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = 2;
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
        public T poll() throws Exception {
            T poll = this.queue.poll();
            if (poll != null && this.sourceMode != 1) {
                long j = this.consumed + 1;
                if (j == this.limit) {
                    this.consumed = 0L;
                    this.upstream.request(j);
                } else {
                    this.consumed = j;
                }
            }
            return poll;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runAsync() {
            io.reactivex.d.b.a<? super T> aVar = this.downstream;
            n<T> nVar = this.queue;
            long j = this.produced;
            long j2 = this.consumed;
            int i = 1;
            while (true) {
                long j3 = this.requested.get();
                while (j != j3) {
                    boolean z = this.done;
                    try {
                        T poll = nVar.poll();
                        boolean z2 = poll == null;
                        if (checkTerminated(z, z2, aVar)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        if (aVar.a(poll)) {
                            j++;
                        }
                        j2++;
                        if (j2 == this.limit) {
                            this.upstream.request(j2);
                            j2 = 0;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.cancelled = true;
                        this.upstream.cancel();
                        nVar.clear();
                        aVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (j == j3 && checkTerminated(this.done, nVar.isEmpty(), aVar)) {
                    return;
                }
                int i2 = get();
                if (i == i2) {
                    this.produced = j;
                    this.consumed = j2;
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    i = i2;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runBackfused() {
            int i = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                this.downstream.onNext(null);
                if (z) {
                    this.cancelled = true;
                    Throwable th = this.error;
                    if (th != null) {
                        this.downstream.onError(th);
                    } else {
                        this.downstream.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runSync() {
            io.reactivex.d.b.a<? super T> aVar = this.downstream;
            n<T> nVar = this.queue;
            long j = this.produced;
            int i = 1;
            while (true) {
                long j2 = this.requested.get();
                while (j != j2) {
                    try {
                        T poll = nVar.poll();
                        if (this.cancelled) {
                            return;
                        }
                        if (poll == null) {
                            this.cancelled = true;
                            aVar.onComplete();
                            this.worker.dispose();
                            return;
                        } else if (aVar.a(poll)) {
                            j++;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.cancelled = true;
                        this.upstream.cancel();
                        aVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (this.cancelled) {
                    return;
                }
                if (nVar.isEmpty()) {
                    this.cancelled = true;
                    aVar.onComplete();
                    this.worker.dispose();
                    return;
                } else {
                    int i2 = get();
                    if (i == i2) {
                        this.produced = j;
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        i = i2;
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class ObserveOnSubscriber<T> extends BaseObserveOnSubscriber<T> implements io.reactivex.h<T> {
        private static final long serialVersionUID = -4547113800637756442L;
        final g.b.b<? super T> downstream;

        ObserveOnSubscriber(g.b.b<? super T> bVar, r.b bVar2, boolean z, int i) {
            super(bVar2, z, i);
            this.downstream = bVar;
        }

        @Override // io.reactivex.h, g.b.b
        public void onSubscribe(g.b.c cVar) {
            if (SubscriptionHelper.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                if (cVar instanceof io.reactivex.d.b.k) {
                    io.reactivex.d.b.k kVar = (io.reactivex.d.b.k) cVar;
                    int requestFusion = kVar.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = kVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = 2;
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
        public T poll() throws Exception {
            T poll = this.queue.poll();
            if (poll != null && this.sourceMode != 1) {
                long j = this.produced + 1;
                if (j == this.limit) {
                    this.produced = 0L;
                    this.upstream.request(j);
                } else {
                    this.produced = j;
                }
            }
            return poll;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runAsync() {
            g.b.b<? super T> bVar = this.downstream;
            n<T> nVar = this.queue;
            long j = this.produced;
            int i = 1;
            while (true) {
                long j2 = this.requested.get();
                while (j != j2) {
                    boolean z = this.done;
                    try {
                        T poll = nVar.poll();
                        boolean z2 = poll == null;
                        if (checkTerminated(z, z2, bVar)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        bVar.onNext(poll);
                        j++;
                        if (j == this.limit) {
                            if (j2 != Long.MAX_VALUE) {
                                j2 = this.requested.addAndGet(-j);
                            }
                            this.upstream.request(j);
                            j = 0;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.cancelled = true;
                        this.upstream.cancel();
                        nVar.clear();
                        bVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (j == j2 && checkTerminated(this.done, nVar.isEmpty(), bVar)) {
                    return;
                }
                int i2 = get();
                if (i == i2) {
                    this.produced = j;
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    i = i2;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runBackfused() {
            int i = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                this.downstream.onNext(null);
                if (z) {
                    this.cancelled = true;
                    Throwable th = this.error;
                    if (th != null) {
                        this.downstream.onError(th);
                    } else {
                        this.downstream.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runSync() {
            g.b.b<? super T> bVar = this.downstream;
            n<T> nVar = this.queue;
            long j = this.produced;
            int i = 1;
            while (true) {
                long j2 = this.requested.get();
                while (j != j2) {
                    try {
                        T poll = nVar.poll();
                        if (this.cancelled) {
                            return;
                        }
                        if (poll == null) {
                            this.cancelled = true;
                            bVar.onComplete();
                            this.worker.dispose();
                            return;
                        }
                        bVar.onNext(poll);
                        j++;
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.cancelled = true;
                        this.upstream.cancel();
                        bVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (this.cancelled) {
                    return;
                }
                if (nVar.isEmpty()) {
                    this.cancelled = true;
                    bVar.onComplete();
                    this.worker.dispose();
                    return;
                } else {
                    int i2 = get();
                    if (i == i2) {
                        this.produced = j;
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        i = i2;
                    }
                }
            }
        }
    }

    public FlowableObserveOn(io.reactivex.e<T> eVar, r rVar, boolean z, int i) {
        super(eVar);
        this.f28196c = rVar;
        this.f28197d = z;
        this.f28198e = i;
    }

    @Override // io.reactivex.e
    public void b(g.b.b<? super T> bVar) {
        r.b a2 = this.f28196c.a();
        if (bVar instanceof io.reactivex.d.b.a) {
            this.f28211b.a((io.reactivex.h) new ObserveOnConditionalSubscriber((io.reactivex.d.b.a) bVar, a2, this.f28197d, this.f28198e));
        } else {
            this.f28211b.a((io.reactivex.h) new ObserveOnSubscriber(bVar, a2, this.f28197d, this.f28198e));
        }
    }
}
