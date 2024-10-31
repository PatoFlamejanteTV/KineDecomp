package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.n;
import io.reactivex.o;
import io.reactivex.q;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableCreate<T> extends io.reactivex.m<T> {

    /* renamed from: a, reason: collision with root package name */
    final o<T> f28303a;

    /* loaded from: classes3.dex */
    static final class CreateEmitter<T> extends AtomicReference<io.reactivex.disposables.b> implements n<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -3434801548987643227L;
        final q<? super T> observer;

        CreateEmitter(q<? super T> qVar) {
            this.observer = qVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.n, io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.d
        public void onComplete() {
            if (isDisposed()) {
                return;
            }
            try {
                this.observer.onComplete();
            } finally {
                dispose();
            }
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
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                if (isDisposed()) {
                    return;
                }
                this.observer.onNext(t);
            }
        }

        public n<T> serialize() {
            return new SerializedEmitter(this);
        }

        @Override // io.reactivex.n
        public void setCancellable(io.reactivex.c.d dVar) {
            setDisposable(new CancellableDisposable(dVar));
        }

        @Override // io.reactivex.n
        public void setDisposable(io.reactivex.disposables.b bVar) {
            DisposableHelper.set(this, bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", CreateEmitter.class.getSimpleName(), super.toString());
        }

        public boolean tryOnError(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isDisposed()) {
                return false;
            }
            try {
                this.observer.onError(th);
                dispose();
                return true;
            } catch (Throwable th2) {
                dispose();
                throw th2;
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class SerializedEmitter<T> extends AtomicInteger implements n<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        volatile boolean done;
        final n<T> emitter;
        final AtomicThrowable error = new AtomicThrowable();
        final io.reactivex.internal.queue.a<T> queue = new io.reactivex.internal.queue.a<>(16);

        SerializedEmitter(n<T> nVar) {
            this.emitter = nVar;
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void drainLoop() {
            n<T> nVar = this.emitter;
            io.reactivex.internal.queue.a<T> aVar = this.queue;
            AtomicThrowable atomicThrowable = this.error;
            int i = 1;
            while (!nVar.isDisposed()) {
                if (atomicThrowable.get() != null) {
                    aVar.clear();
                    nVar.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z = this.done;
                T poll = aVar.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    nVar.onComplete();
                    return;
                } else if (z2) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    nVar.onNext(poll);
                }
            }
            aVar.clear();
        }

        @Override // io.reactivex.n, io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.emitter.isDisposed();
        }

        @Override // io.reactivex.d
        public void onComplete() {
            if (this.emitter.isDisposed() || this.done) {
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
            if (this.emitter.isDisposed() || this.done) {
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
                io.reactivex.internal.queue.a<T> aVar = this.queue;
                synchronized (aVar) {
                    aVar.offer(t);
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        public n<T> serialize() {
            return this;
        }

        @Override // io.reactivex.n
        public void setCancellable(io.reactivex.c.d dVar) {
            this.emitter.setCancellable(dVar);
        }

        @Override // io.reactivex.n
        public void setDisposable(io.reactivex.disposables.b bVar) {
            this.emitter.setDisposable(bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public String toString() {
            return this.emitter.toString();
        }

        public boolean tryOnError(Throwable th) {
            if (!this.emitter.isDisposed() && !this.done) {
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

    public ObservableCreate(o<T> oVar) {
        this.f28303a = oVar;
    }

    @Override // io.reactivex.m
    protected void b(q<? super T> qVar) {
        CreateEmitter createEmitter = new CreateEmitter(qVar);
        qVar.onSubscribe(createEmitter);
        try {
            this.f28303a.a(createEmitter);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            createEmitter.onError(th);
        }
    }
}
