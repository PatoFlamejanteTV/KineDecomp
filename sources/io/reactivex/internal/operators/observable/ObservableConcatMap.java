package io.reactivex.internal.operators.observable;

import io.reactivex.d.b.n;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.p;
import io.reactivex.q;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableConcatMap<T, U> extends a<T, U> {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.c.f<? super T, ? extends p<? extends U>> f28300b;

    /* renamed from: c, reason: collision with root package name */
    final int f28301c;

    /* renamed from: d, reason: collision with root package name */
    final ErrorMode f28302d;

    /* loaded from: classes3.dex */
    static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements q<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -6951100001833242599L;
        volatile boolean active;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        final q<? super R> downstream;
        final AtomicThrowable error = new AtomicThrowable();
        final io.reactivex.c.f<? super T, ? extends p<? extends R>> mapper;
        final DelayErrorInnerObserver<R> observer;
        n<T> queue;
        int sourceMode;
        final boolean tillTheEnd;
        io.reactivex.disposables.b upstream;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static final class DelayErrorInnerObserver<R> extends AtomicReference<io.reactivex.disposables.b> implements q<R> {
            private static final long serialVersionUID = 2620149119579502636L;
            final q<? super R> downstream;
            final ConcatMapDelayErrorObserver<?, R> parent;

            DelayErrorInnerObserver(q<? super R> qVar, ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver) {
                this.downstream = qVar;
                this.parent = concatMapDelayErrorObserver;
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.q
            public void onComplete() {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.parent;
                concatMapDelayErrorObserver.active = false;
                concatMapDelayErrorObserver.drain();
            }

            @Override // io.reactivex.q
            public void onError(Throwable th) {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.parent;
                if (concatMapDelayErrorObserver.error.addThrowable(th)) {
                    if (!concatMapDelayErrorObserver.tillTheEnd) {
                        concatMapDelayErrorObserver.upstream.dispose();
                    }
                    concatMapDelayErrorObserver.active = false;
                    concatMapDelayErrorObserver.drain();
                    return;
                }
                io.reactivex.f.a.b(th);
            }

            @Override // io.reactivex.q
            public void onNext(R r) {
                this.downstream.onNext(r);
            }

            @Override // io.reactivex.q
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.replace(this, bVar);
            }
        }

        ConcatMapDelayErrorObserver(q<? super R> qVar, io.reactivex.c.f<? super T, ? extends p<? extends R>> fVar, int i, boolean z) {
            this.downstream = qVar;
            this.mapper = fVar;
            this.bufferSize = i;
            this.tillTheEnd = z;
            this.observer = new DelayErrorInnerObserver<>(qVar, this);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.observer.dispose();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            q<? super R> qVar = this.downstream;
            n<T> nVar = this.queue;
            AtomicThrowable atomicThrowable = this.error;
            while (true) {
                if (!this.active) {
                    if (this.cancelled) {
                        nVar.clear();
                        return;
                    }
                    if (!this.tillTheEnd && atomicThrowable.get() != null) {
                        nVar.clear();
                        this.cancelled = true;
                        qVar.onError(atomicThrowable.terminate());
                        return;
                    }
                    boolean z = this.done;
                    try {
                        T poll = nVar.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            this.cancelled = true;
                            Throwable terminate = atomicThrowable.terminate();
                            if (terminate != null) {
                                qVar.onError(terminate);
                                return;
                            } else {
                                qVar.onComplete();
                                return;
                            }
                        }
                        if (!z2) {
                            try {
                                p<? extends R> apply = this.mapper.apply(poll);
                                io.reactivex.d.a.b.a(apply, "The mapper returned a null ObservableSource");
                                p<? extends R> pVar = apply;
                                if (pVar instanceof Callable) {
                                    try {
                                        defpackage.a aVar = (Object) ((Callable) pVar).call();
                                        if (aVar != null && !this.cancelled) {
                                            qVar.onNext(aVar);
                                        }
                                    } catch (Throwable th) {
                                        io.reactivex.exceptions.a.b(th);
                                        atomicThrowable.addThrowable(th);
                                    }
                                } else {
                                    this.active = true;
                                    pVar.a(this.observer);
                                }
                            } catch (Throwable th2) {
                                io.reactivex.exceptions.a.b(th2);
                                this.cancelled = true;
                                this.upstream.dispose();
                                nVar.clear();
                                atomicThrowable.addThrowable(th2);
                                qVar.onError(atomicThrowable.terminate());
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        io.reactivex.exceptions.a.b(th3);
                        this.cancelled = true;
                        this.upstream.dispose();
                        atomicThrowable.addThrowable(th3);
                        qVar.onError(atomicThrowable.terminate());
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.q
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.q
        public void onError(Throwable th) {
            if (this.error.addThrowable(th)) {
                this.done = true;
                drain();
            } else {
                io.reactivex.f.a.b(th);
            }
        }

        @Override // io.reactivex.q
        public void onNext(T t) {
            if (this.sourceMode == 0) {
                this.queue.offer(t);
            }
            drain();
        }

        @Override // io.reactivex.q
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof io.reactivex.d.b.i) {
                    io.reactivex.d.b.i iVar = (io.reactivex.d.b.i) bVar;
                    int requestFusion = iVar.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = iVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = iVar;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.a(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class SourceObserver<T, U> extends AtomicInteger implements q<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 8828587559905699186L;
        volatile boolean active;
        final int bufferSize;
        volatile boolean disposed;
        volatile boolean done;
        final q<? super U> downstream;
        int fusionMode;
        final InnerObserver<U> inner;
        final io.reactivex.c.f<? super T, ? extends p<? extends U>> mapper;
        n<T> queue;
        io.reactivex.disposables.b upstream;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static final class InnerObserver<U> extends AtomicReference<io.reactivex.disposables.b> implements q<U> {
            private static final long serialVersionUID = -7449079488798789337L;
            final q<? super U> downstream;
            final SourceObserver<?, ?> parent;

            InnerObserver(q<? super U> qVar, SourceObserver<?, ?> sourceObserver) {
                this.downstream = qVar;
                this.parent = sourceObserver;
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.q
            public void onComplete() {
                this.parent.innerComplete();
            }

            @Override // io.reactivex.q
            public void onError(Throwable th) {
                this.parent.dispose();
                this.downstream.onError(th);
            }

            @Override // io.reactivex.q
            public void onNext(U u) {
                this.downstream.onNext(u);
            }

            @Override // io.reactivex.q
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.replace(this, bVar);
            }
        }

        SourceObserver(q<? super U> qVar, io.reactivex.c.f<? super T, ? extends p<? extends U>> fVar, int i) {
            this.downstream = qVar;
            this.mapper = fVar;
            this.bufferSize = i;
            this.inner = new InnerObserver<>(qVar, this);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            this.inner.dispose();
            this.upstream.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.disposed) {
                if (!this.active) {
                    boolean z = this.done;
                    try {
                        T poll = this.queue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            this.disposed = true;
                            this.downstream.onComplete();
                            return;
                        }
                        if (!z2) {
                            try {
                                p<? extends U> apply = this.mapper.apply(poll);
                                io.reactivex.d.a.b.a(apply, "The mapper returned a null ObservableSource");
                                p<? extends U> pVar = apply;
                                this.active = true;
                                pVar.a(this.inner);
                            } catch (Throwable th) {
                                io.reactivex.exceptions.a.b(th);
                                dispose();
                                this.queue.clear();
                                this.downstream.onError(th);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        dispose();
                        this.queue.clear();
                        this.downstream.onError(th2);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.queue.clear();
        }

        void innerComplete() {
            this.active = false;
            drain();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.q
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.q
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.f.a.b(th);
                return;
            }
            this.done = true;
            dispose();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.q
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.fusionMode == 0) {
                this.queue.offer(t);
            }
            drain();
        }

        @Override // io.reactivex.q
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof io.reactivex.d.b.i) {
                    io.reactivex.d.b.i iVar = (io.reactivex.d.b.i) bVar;
                    int requestFusion = iVar.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = iVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = iVar;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.a(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMap(p<T> pVar, io.reactivex.c.f<? super T, ? extends p<? extends U>> fVar, int i, ErrorMode errorMode) {
        super(pVar);
        this.f28300b = fVar;
        this.f28302d = errorMode;
        this.f28301c = Math.max(8, i);
    }

    @Override // io.reactivex.m
    public void b(q<? super U> qVar) {
        if (ObservableScalarXMap.a(this.f28315a, qVar, this.f28300b)) {
            return;
        }
        ErrorMode errorMode = this.f28302d;
        if (errorMode == ErrorMode.IMMEDIATE) {
            this.f28315a.a(new SourceObserver(new io.reactivex.e.b(qVar), this.f28300b, this.f28301c));
        } else {
            this.f28315a.a(new ConcatMapDelayErrorObserver(qVar, this.f28300b, this.f28301c, errorMode == ErrorMode.END));
        }
    }
}
