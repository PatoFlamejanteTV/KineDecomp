package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class FlowableFromIterable<T> extends io.reactivex.e<T> {

    /* renamed from: b, reason: collision with root package name */
    final Iterable<? extends T> f28195b;

    /* loaded from: classes3.dex */
    static abstract class BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        Iterator<? extends T> it;
        boolean once;

        BaseRangeSubscription(Iterator<? extends T> it) {
            this.it = it;
        }

        @Override // g.b.c
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // io.reactivex.d.b.n
        public final void clear() {
            this.it = null;
        }

        abstract void fastPath();

        @Override // io.reactivex.d.b.n
        public final boolean isEmpty() {
            Iterator<? extends T> it = this.it;
            return it == null || !it.hasNext();
        }

        @Override // io.reactivex.d.b.n
        public final T poll() {
            Iterator<? extends T> it = this.it;
            if (it == null) {
                return null;
            }
            if (!this.once) {
                this.once = true;
            } else if (!it.hasNext()) {
                return null;
            }
            T next = this.it.next();
            io.reactivex.d.a.b.a((Object) next, "Iterator.next() returned a null value");
            return next;
        }

        @Override // g.b.c
        public final void request(long j) {
            if (SubscriptionHelper.validate(j) && io.reactivex.internal.util.b.a(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j);
                }
            }
        }

        @Override // io.reactivex.d.b.j
        public final int requestFusion(int i) {
            return i & 1;
        }

        abstract void slowPath(long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class IteratorConditionalSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final io.reactivex.d.b.a<? super T> downstream;

        IteratorConditionalSubscription(io.reactivex.d.b.a<? super T> aVar, Iterator<? extends T> it) {
            super(it);
            this.downstream = aVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        void fastPath() {
            Iterator<? extends T> it = this.it;
            io.reactivex.d.b.a<? super T> aVar = this.downstream;
            while (!this.cancelled) {
                try {
                    T next = it.next();
                    if (this.cancelled) {
                        return;
                    }
                    if (next == null) {
                        aVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    aVar.a(next);
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (this.cancelled) {
                                return;
                            }
                            aVar.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        aVar.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    aVar.onError(th2);
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x005c, code lost:            r4 = addAndGet(-r9);     */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void slowPath(long r9) {
            /*
                r8 = this;
                java.util.Iterator<? extends T> r0 = r8.it
                io.reactivex.d.b.a<? super T> r1 = r8.downstream
                r2 = 0
                r4 = r9
            L7:
                r9 = r2
            L8:
                int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r6 == 0) goto L54
                boolean r6 = r8.cancelled
                if (r6 == 0) goto L11
                return
            L11:
                java.lang.Object r6 = r0.next()     // Catch: java.lang.Throwable -> L4c
                boolean r7 = r8.cancelled
                if (r7 == 0) goto L1a
                return
            L1a:
                if (r6 != 0) goto L27
                java.lang.NullPointerException r9 = new java.lang.NullPointerException
                java.lang.String r10 = "Iterator.next() returned a null value"
                r9.<init>(r10)
                r1.onError(r9)
                return
            L27:
                boolean r6 = r1.a(r6)
                boolean r7 = r8.cancelled
                if (r7 == 0) goto L30
                return
            L30:
                boolean r7 = r0.hasNext()     // Catch: java.lang.Throwable -> L44
                if (r7 != 0) goto L3e
                boolean r9 = r8.cancelled
                if (r9 != 0) goto L3d
                r1.onComplete()
            L3d:
                return
            L3e:
                if (r6 == 0) goto L8
                r6 = 1
                long r9 = r9 + r6
                goto L8
            L44:
                r9 = move-exception
                io.reactivex.exceptions.a.b(r9)
                r1.onError(r9)
                return
            L4c:
                r9 = move-exception
                io.reactivex.exceptions.a.b(r9)
                r1.onError(r9)
                return
            L54:
                long r4 = r8.get()
                int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r6 != 0) goto L8
                long r9 = -r9
                long r4 = r8.addAndGet(r9)
                int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r9 != 0) goto L7
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFromIterable.IteratorConditionalSubscription.slowPath(long):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class IteratorSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final g.b.b<? super T> downstream;

        IteratorSubscription(g.b.b<? super T> bVar, Iterator<? extends T> it) {
            super(it);
            this.downstream = bVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        void fastPath() {
            Iterator<? extends T> it = this.it;
            g.b.b<? super T> bVar = this.downstream;
            while (!this.cancelled) {
                try {
                    T next = it.next();
                    if (this.cancelled) {
                        return;
                    }
                    if (next == null) {
                        bVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    bVar.onNext(next);
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (this.cancelled) {
                                return;
                            }
                            bVar.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        bVar.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    bVar.onError(th2);
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0059, code lost:            r4 = addAndGet(-r9);     */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void slowPath(long r9) {
            /*
                r8 = this;
                java.util.Iterator<? extends T> r0 = r8.it
                g.b.b<? super T> r1 = r8.downstream
                r2 = 0
                r4 = r9
            L7:
                r9 = r2
            L8:
                int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r6 == 0) goto L51
                boolean r6 = r8.cancelled
                if (r6 == 0) goto L11
                return
            L11:
                java.lang.Object r6 = r0.next()     // Catch: java.lang.Throwable -> L49
                boolean r7 = r8.cancelled
                if (r7 == 0) goto L1a
                return
            L1a:
                if (r6 != 0) goto L27
                java.lang.NullPointerException r9 = new java.lang.NullPointerException
                java.lang.String r10 = "Iterator.next() returned a null value"
                r9.<init>(r10)
                r1.onError(r9)
                return
            L27:
                r1.onNext(r6)
                boolean r6 = r8.cancelled
                if (r6 == 0) goto L2f
                return
            L2f:
                boolean r6 = r0.hasNext()     // Catch: java.lang.Throwable -> L41
                if (r6 != 0) goto L3d
                boolean r9 = r8.cancelled
                if (r9 != 0) goto L3c
                r1.onComplete()
            L3c:
                return
            L3d:
                r6 = 1
                long r9 = r9 + r6
                goto L8
            L41:
                r9 = move-exception
                io.reactivex.exceptions.a.b(r9)
                r1.onError(r9)
                return
            L49:
                r9 = move-exception
                io.reactivex.exceptions.a.b(r9)
                r1.onError(r9)
                return
            L51:
                long r4 = r8.get()
                int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r6 != 0) goto L8
                long r9 = -r9
                long r4 = r8.addAndGet(r9)
                int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r9 != 0) goto L7
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFromIterable.IteratorSubscription.slowPath(long):void");
        }
    }

    public FlowableFromIterable(Iterable<? extends T> iterable) {
        this.f28195b = iterable;
    }

    public static <T> void a(g.b.b<? super T> bVar, Iterator<? extends T> it) {
        try {
            if (!it.hasNext()) {
                EmptySubscription.complete(bVar);
            } else if (bVar instanceof io.reactivex.d.b.a) {
                bVar.onSubscribe(new IteratorConditionalSubscription((io.reactivex.d.b.a) bVar, it));
            } else {
                bVar.onSubscribe(new IteratorSubscription(bVar, it));
            }
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            EmptySubscription.error(th, bVar);
        }
    }

    @Override // io.reactivex.e
    public void b(g.b.b<? super T> bVar) {
        try {
            a(bVar, this.f28195b.iterator());
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            EmptySubscription.error(th, bVar);
        }
    }
}
