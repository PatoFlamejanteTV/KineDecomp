package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.d.b.m;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class FlowableCreate<T> extends io.reactivex.e<T> {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.g<T> f28180b;

    /* renamed from: c, reason: collision with root package name */
    final BackpressureStrategy f28181c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static abstract class BaseEmitter<T> extends AtomicLong implements io.reactivex.f<T>, g.b.c {
        private static final long serialVersionUID = 7326289992464377023L;
        final g.b.b<? super T> downstream;
        final SequentialDisposable serial = new SequentialDisposable();

        BaseEmitter(g.b.b<? super T> bVar) {
            this.downstream = bVar;
        }

        @Override // g.b.c
        public final void cancel() {
            this.serial.dispose();
            onUnsubscribed();
        }

        protected void complete() {
            if (isCancelled()) {
                return;
            }
            try {
                this.downstream.onComplete();
            } finally {
                this.serial.dispose();
            }
        }

        protected boolean error(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isCancelled()) {
                return false;
            }
            try {
                this.downstream.onError(th);
                this.serial.dispose();
                return true;
            } catch (Throwable th2) {
                this.serial.dispose();
                throw th2;
            }
        }

        public final boolean isCancelled() {
            return this.serial.isDisposed();
        }

        @Override // io.reactivex.d
        public void onComplete() {
            complete();
        }

        @Override // io.reactivex.d
        public final void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            io.reactivex.f.a.b(th);
        }

        void onRequested() {
        }

        void onUnsubscribed() {
        }

        @Override // g.b.c
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this, j);
                onRequested();
            }
        }

        public final long requested() {
            return get();
        }

        public final io.reactivex.f<T> serialize() {
            return new SerializedEmitter(this);
        }

        public final void setCancellable(io.reactivex.c.d dVar) {
            setDisposable(new CancellableDisposable(dVar));
        }

        public final void setDisposable(io.reactivex.disposables.b bVar) {
            this.serial.update(bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public String toString() {
            return String.format("%s{%s}", getClass().getSimpleName(), super.toString());
        }

        public boolean tryOnError(Throwable th) {
            return error(th);
        }
    }

    /* loaded from: classes3.dex */
    static final class BufferAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        volatile boolean done;
        Throwable error;
        final io.reactivex.internal.queue.a<T> queue;
        final AtomicInteger wip;

        BufferAsyncEmitter(g.b.b<? super T> bVar, int i) {
            super(bVar);
            this.queue = new io.reactivex.internal.queue.a<>(i);
            this.wip = new AtomicInteger();
        }

        void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            g.b.b<? super T> bVar = this.downstream;
            io.reactivex.internal.queue.a<T> aVar = this.queue;
            int i = 1;
            do {
                long j = get();
                long j2 = 0;
                while (j2 != j) {
                    if (isCancelled()) {
                        aVar.clear();
                        return;
                    }
                    boolean z = this.done;
                    T poll = aVar.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            error(th);
                            return;
                        } else {
                            complete();
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    bVar.onNext(poll);
                    j2++;
                }
                if (j2 == j) {
                    if (isCancelled()) {
                        aVar.clear();
                        return;
                    }
                    boolean z3 = this.done;
                    boolean isEmpty = aVar.isEmpty();
                    if (z3 && isEmpty) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            error(th2);
                            return;
                        } else {
                            complete();
                            return;
                        }
                    }
                }
                if (j2 != 0) {
                    io.reactivex.internal.util.b.c(this, j2);
                }
                i = this.wip.addAndGet(-i);
            } while (i != 0);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.d
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.d
        public void onNext(T t) {
            if (this.done || isCancelled()) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.queue.offer(t);
                drain();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onRequested() {
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        public boolean tryOnError(Throwable th) {
            if (this.done || isCancelled()) {
                return false;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.error = th;
            this.done = true;
            drain();
            return true;
        }
    }

    /* loaded from: classes3.dex */
    static final class DropAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        DropAsyncEmitter(g.b.b<? super T> bVar) {
            super(bVar);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.NoOverflowBaseAsyncEmitter
        void onOverflow() {
        }
    }

    /* loaded from: classes3.dex */
    static final class ErrorAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 338953216916120960L;

        ErrorAsyncEmitter(g.b.b<? super T> bVar) {
            super(bVar);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.NoOverflowBaseAsyncEmitter
        void onOverflow() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }

    /* loaded from: classes3.dex */
    static final class LatestAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        volatile boolean done;
        Throwable error;
        final AtomicReference<T> queue;
        final AtomicInteger wip;

        LatestAsyncEmitter(g.b.b<? super T> bVar) {
            super(bVar);
            this.queue = new AtomicReference<>();
            this.wip = new AtomicInteger();
        }

        void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            g.b.b<? super T> bVar = this.downstream;
            AtomicReference<T> atomicReference = this.queue;
            int i = 1;
            do {
                long j = get();
                long j2 = 0;
                while (true) {
                    if (j2 == j) {
                        break;
                    }
                    if (isCancelled()) {
                        atomicReference.lazySet(null);
                        return;
                    }
                    boolean z = this.done;
                    T andSet = atomicReference.getAndSet(null);
                    boolean z2 = andSet == null;
                    if (z && z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            error(th);
                            return;
                        } else {
                            complete();
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    bVar.onNext(andSet);
                    j2++;
                }
                if (j2 == j) {
                    if (isCancelled()) {
                        atomicReference.lazySet(null);
                        return;
                    }
                    boolean z3 = this.done;
                    boolean z4 = atomicReference.get() == null;
                    if (z3 && z4) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            error(th2);
                            return;
                        } else {
                            complete();
                            return;
                        }
                    }
                }
                if (j2 != 0) {
                    io.reactivex.internal.util.b.c(this, j2);
                }
                i = this.wip.addAndGet(-i);
            } while (i != 0);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.d
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.d
        public void onNext(T t) {
            if (this.done || isCancelled()) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.queue.set(t);
                drain();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onRequested() {
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet(null);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        public boolean tryOnError(Throwable th) {
            if (this.done || isCancelled()) {
                return false;
            }
            if (th == null) {
                onError(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
            this.error = th;
            this.done = true;
            drain();
            return true;
        }
    }

    /* loaded from: classes3.dex */
    static final class MissingEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        MissingEmitter(g.b.b<? super T> bVar) {
            super(bVar);
        }

        @Override // io.reactivex.d
        public void onNext(T t) {
            long j;
            if (isCancelled()) {
                return;
            }
            if (t != null) {
                this.downstream.onNext(t);
                do {
                    j = get();
                    if (j == 0) {
                        return;
                    }
                } while (!compareAndSet(j, j - 1));
                return;
            }
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        }
    }

    /* loaded from: classes3.dex */
    static abstract class NoOverflowBaseAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        NoOverflowBaseAsyncEmitter(g.b.b<? super T> bVar) {
            super(bVar);
        }

        @Override // io.reactivex.d
        public final void onNext(T t) {
            if (isCancelled()) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (get() != 0) {
                this.downstream.onNext(t);
                io.reactivex.internal.util.b.c(this, 1L);
            } else {
                onOverflow();
            }
        }

        abstract void onOverflow();
    }

    /* loaded from: classes3.dex */
    static final class SerializedEmitter<T> extends AtomicInteger implements io.reactivex.f<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        volatile boolean done;
        final BaseEmitter<T> emitter;
        final AtomicThrowable error = new AtomicThrowable();
        final m<T> queue = new io.reactivex.internal.queue.a(16);

        SerializedEmitter(BaseEmitter<T> baseEmitter) {
            this.emitter = baseEmitter;
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void drainLoop() {
            BaseEmitter<T> baseEmitter = this.emitter;
            m<T> mVar = this.queue;
            AtomicThrowable atomicThrowable = this.error;
            int i = 1;
            while (!baseEmitter.isCancelled()) {
                if (atomicThrowable.get() != null) {
                    mVar.clear();
                    baseEmitter.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z = this.done;
                T poll = mVar.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    baseEmitter.onComplete();
                    return;
                } else if (z2) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    baseEmitter.onNext(poll);
                }
            }
            mVar.clear();
        }

        public boolean isCancelled() {
            return this.emitter.isCancelled();
        }

        @Override // io.reactivex.d
        public void onComplete() {
            if (this.emitter.isCancelled() || this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.d
        public void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            io.reactivex.f.a.b(th);
        }

        @Override // io.reactivex.d
        public void onNext(T t) {
            if (this.emitter.isCancelled() || this.done) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            if (get() == 0 && compareAndSet(0, 1)) {
                this.emitter.onNext(t);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                m<T> mVar = this.queue;
                synchronized (mVar) {
                    mVar.offer(t);
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        public long requested() {
            return this.emitter.requested();
        }

        public io.reactivex.f<T> serialize() {
            return this;
        }

        public void setCancellable(io.reactivex.c.d dVar) {
            this.emitter.setCancellable(dVar);
        }

        public void setDisposable(io.reactivex.disposables.b bVar) {
            this.emitter.setDisposable(bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public String toString() {
            return this.emitter.toString();
        }

        public boolean tryOnError(Throwable th) {
            if (!this.emitter.isCancelled() && !this.done) {
                if (th == null) {
                    th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                }
                if (this.error.addThrowable(th)) {
                    this.done = true;
                    drain();
                    return true;
                }
            }
            return false;
        }
    }

    public FlowableCreate(io.reactivex.g<T> gVar, BackpressureStrategy backpressureStrategy) {
        this.f28180b = gVar;
        this.f28181c = backpressureStrategy;
    }

    @Override // io.reactivex.e
    public void b(g.b.b<? super T> bVar) {
        BaseEmitter missingEmitter;
        int i = c.f28213a[this.f28181c.ordinal()];
        if (i == 1) {
            missingEmitter = new MissingEmitter(bVar);
        } else if (i == 2) {
            missingEmitter = new ErrorAsyncEmitter(bVar);
        } else if (i == 3) {
            missingEmitter = new DropAsyncEmitter(bVar);
        } else if (i != 4) {
            missingEmitter = new BufferAsyncEmitter(bVar, io.reactivex.e.a());
        } else {
            missingEmitter = new LatestAsyncEmitter(bVar);
        }
        bVar.onSubscribe(missingEmitter);
        try {
            this.f28180b.a(missingEmitter);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            missingEmitter.onError(th);
        }
    }
}
