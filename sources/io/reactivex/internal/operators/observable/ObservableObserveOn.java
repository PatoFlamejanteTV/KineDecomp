package io.reactivex.internal.operators.observable;

import io.reactivex.d.b.n;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.p;
import io.reactivex.q;
import io.reactivex.r;

/* loaded from: classes3.dex */
public final class ObservableObserveOn<T> extends a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final r f28307b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f28308c;

    /* renamed from: d, reason: collision with root package name */
    final int f28309d;

    /* loaded from: classes3.dex */
    static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements q<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        final int bufferSize;
        final boolean delayError;
        volatile boolean disposed;
        volatile boolean done;
        final q<? super T> downstream;
        Throwable error;
        boolean outputFused;
        n<T> queue;
        int sourceMode;
        io.reactivex.disposables.b upstream;
        final r.b worker;

        ObserveOnObserver(q<? super T> qVar, r.b bVar, boolean z, int i) {
            this.downstream = qVar;
            this.worker = bVar;
            this.delayError = z;
            this.bufferSize = i;
        }

        boolean checkTerminated(boolean z, boolean z2, q<? super T> qVar) {
            if (this.disposed) {
                this.queue.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.error;
            if (this.delayError) {
                if (!z2) {
                    return false;
                }
                this.disposed = true;
                if (th != null) {
                    qVar.onError(th);
                } else {
                    qVar.onComplete();
                }
                this.worker.dispose();
                return true;
            }
            if (th != null) {
                this.disposed = true;
                this.queue.clear();
                qVar.onError(th);
                this.worker.dispose();
                return true;
            }
            if (!z2) {
                return false;
            }
            this.disposed = true;
            qVar.onComplete();
            this.worker.dispose();
            return true;
        }

        @Override // io.reactivex.d.b.n
        public void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.disposed) {
                return;
            }
            this.disposed = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drainFused() {
            int i = 1;
            while (!this.disposed) {
                boolean z = this.done;
                Throwable th = this.error;
                if (!this.delayError && z && th != null) {
                    this.disposed = true;
                    this.downstream.onError(th);
                    this.worker.dispose();
                    return;
                }
                this.downstream.onNext(null);
                if (z) {
                    this.disposed = true;
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.downstream.onError(th2);
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

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:            r3 = addAndGet(-r3);     */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:            if (r3 != 0) goto L27;     */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:            return;     */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drainNormal() {
            /*
                r7 = this;
                io.reactivex.d.b.n<T> r0 = r7.queue
                io.reactivex.q<? super T> r1 = r7.downstream
                r2 = 1
                r3 = 1
            L6:
                boolean r4 = r7.done
                boolean r5 = r0.isEmpty()
                boolean r4 = r7.checkTerminated(r4, r5, r1)
                if (r4 == 0) goto L13
                return
            L13:
                boolean r4 = r7.done
                java.lang.Object r5 = r0.poll()     // Catch: java.lang.Throwable -> L33
                if (r5 != 0) goto L1d
                r6 = 1
                goto L1e
            L1d:
                r6 = 0
            L1e:
                boolean r4 = r7.checkTerminated(r4, r6, r1)
                if (r4 == 0) goto L25
                return
            L25:
                if (r6 == 0) goto L2f
                int r3 = -r3
                int r3 = r7.addAndGet(r3)
                if (r3 != 0) goto L6
                return
            L2f:
                r1.onNext(r5)
                goto L13
            L33:
                r3 = move-exception
                io.reactivex.exceptions.a.b(r3)
                r7.disposed = r2
                io.reactivex.disposables.b r2 = r7.upstream
                r2.dispose()
                r0.clear()
                r1.onError(r3)
                io.reactivex.r$b r0 = r7.worker
                r0.dispose()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableObserveOn.ObserveOnObserver.drainNormal():void");
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.d.b.n
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // io.reactivex.q
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            schedule();
        }

        @Override // io.reactivex.q
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.f.a.b(th);
                return;
            }
            this.error = th;
            this.done = true;
            schedule();
        }

        @Override // io.reactivex.q
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 2) {
                this.queue.offer(t);
            }
            schedule();
        }

        @Override // io.reactivex.q
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof io.reactivex.d.b.i) {
                    io.reactivex.d.b.i iVar = (io.reactivex.d.b.i) bVar;
                    int requestFusion = iVar.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = iVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        schedule();
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

        @Override // io.reactivex.d.b.n
        public T poll() throws Exception {
            return this.queue.poll();
        }

        @Override // io.reactivex.d.b.j
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.a(this);
            }
        }
    }

    public ObservableObserveOn(p<T> pVar, r rVar, boolean z, int i) {
        super(pVar);
        this.f28307b = rVar;
        this.f28308c = z;
        this.f28309d = i;
    }

    @Override // io.reactivex.m
    protected void b(q<? super T> qVar) {
        r rVar = this.f28307b;
        if (rVar instanceof io.reactivex.internal.schedulers.j) {
            this.f28315a.a(qVar);
        } else {
            this.f28315a.a(new ObserveOnObserver(qVar, rVar.a(), this.f28308c, this.f28309d));
        }
    }
}
