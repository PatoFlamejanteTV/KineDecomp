package io.reactivex.internal.operators.flowable;

import io.reactivex.d.b.n;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class FlowablePublish<T> extends io.reactivex.b.a<T> implements io.reactivex.d.b.h<T> {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.e<T> f28204b;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference<PublishSubscriber<T>> f28205c;

    /* renamed from: d, reason: collision with root package name */
    final int f28206d;

    /* renamed from: e, reason: collision with root package name */
    final g.b.a<T> f28207e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class InnerSubscriber<T> extends AtomicLong implements g.b.c {
        private static final long serialVersionUID = -4453897557930727610L;
        final g.b.b<? super T> child;
        long emitted;
        volatile PublishSubscriber<T> parent;

        InnerSubscriber(g.b.b<? super T> bVar) {
            this.child = bVar;
        }

        @Override // g.b.c
        public void cancel() {
            PublishSubscriber<T> publishSubscriber;
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE || (publishSubscriber = this.parent) == null) {
                return;
            }
            publishSubscriber.remove(this);
            publishSubscriber.dispatch();
        }

        @Override // g.b.c
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.b(this, j);
                PublishSubscriber<T> publishSubscriber = this.parent;
                if (publishSubscriber != null) {
                    publishSubscriber.dispatch();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class PublishSubscriber<T> extends AtomicInteger implements io.reactivex.h<T>, io.reactivex.disposables.b {
        static final InnerSubscriber[] EMPTY = new InnerSubscriber[0];
        static final InnerSubscriber[] TERMINATED = new InnerSubscriber[0];
        private static final long serialVersionUID = -202316842419149694L;
        final int bufferSize;
        final AtomicReference<PublishSubscriber<T>> current;
        volatile n<T> queue;
        int sourceMode;
        volatile Object terminalEvent;
        final AtomicReference<g.b.c> upstream = new AtomicReference<>();
        final AtomicReference<InnerSubscriber<T>[]> subscribers = new AtomicReference<>(EMPTY);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        PublishSubscriber(AtomicReference<PublishSubscriber<T>> atomicReference, int i) {
            this.current = atomicReference;
            this.bufferSize = i;
        }

        boolean add(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber<T>[] innerSubscriberArr;
            InnerSubscriber<T>[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                if (innerSubscriberArr == TERMINATED) {
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new InnerSubscriber[length + 1];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, innerSubscriberArr2));
            return true;
        }

        boolean checkTerminated(Object obj, boolean z) {
            int i = 0;
            if (obj != null) {
                if (!NotificationLite.isComplete(obj)) {
                    Throwable error = NotificationLite.getError(obj);
                    this.current.compareAndSet(this, null);
                    InnerSubscriber<T>[] andSet = this.subscribers.getAndSet(TERMINATED);
                    if (andSet.length != 0) {
                        int length = andSet.length;
                        while (i < length) {
                            andSet[i].child.onError(error);
                            i++;
                        }
                    } else {
                        io.reactivex.f.a.b(error);
                    }
                    return true;
                }
                if (z) {
                    this.current.compareAndSet(this, null);
                    InnerSubscriber<T>[] andSet2 = this.subscribers.getAndSet(TERMINATED);
                    int length2 = andSet2.length;
                    while (i < length2) {
                        andSet2[i].child.onComplete();
                        i++;
                    }
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:85:0x013c, code lost:            if (r8 == 0) goto L83;     */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x0141, code lost:            if (r25.sourceMode == 1) goto L84;     */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x0143, code lost:            r25.upstream.get().request(r11);     */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x0154, code lost:            if (r14 == 0) goto L89;     */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x0156, code lost:            if (r0 != false) goto L89;     */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x0169, code lost:            continue;     */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void dispatch() {
            /*
                Method dump skipped, instructions count: 364
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber.dispatch():void");
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            InnerSubscriber<T>[] innerSubscriberArr = this.subscribers.get();
            InnerSubscriber<T>[] innerSubscriberArr2 = TERMINATED;
            if (innerSubscriberArr == innerSubscriberArr2 || this.subscribers.getAndSet(innerSubscriberArr2) == TERMINATED) {
                return;
            }
            this.current.compareAndSet(this, null);
            SubscriptionHelper.cancel(this.upstream);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        @Override // g.b.b
        public void onComplete() {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.complete();
                dispatch();
            }
        }

        @Override // g.b.b
        public void onError(Throwable th) {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.error(th);
                dispatch();
            } else {
                io.reactivex.f.a.b(th);
            }
        }

        @Override // g.b.b
        public void onNext(T t) {
            if (this.sourceMode == 0 && !this.queue.offer(t)) {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
            } else {
                dispatch();
            }
        }

        @Override // io.reactivex.h, g.b.b
        public void onSubscribe(g.b.c cVar) {
            if (SubscriptionHelper.setOnce(this.upstream, cVar)) {
                if (cVar instanceof io.reactivex.d.b.k) {
                    io.reactivex.d.b.k kVar = (io.reactivex.d.b.k) cVar;
                    int requestFusion = kVar.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = kVar;
                        this.terminalEvent = NotificationLite.complete();
                        dispatch();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = kVar;
                        cVar.request(this.bufferSize);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.bufferSize);
                cVar.request(this.bufferSize);
            }
        }

        void remove(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber<T>[] innerSubscriberArr;
            InnerSubscriber<T>[] innerSubscriberArr2;
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
                    if (innerSubscriberArr[i2].equals(innerSubscriber)) {
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
                    InnerSubscriber<T>[] innerSubscriberArr3 = new InnerSubscriber[length - 1];
                    System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i);
                    System.arraycopy(innerSubscriberArr, i + 1, innerSubscriberArr3, i, (length - i) - 1);
                    innerSubscriberArr2 = innerSubscriberArr3;
                }
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, innerSubscriberArr2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class a<T> implements g.b.a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicReference<PublishSubscriber<T>> f28208a;

        /* renamed from: b, reason: collision with root package name */
        private final int f28209b;

        a(AtomicReference<PublishSubscriber<T>> atomicReference, int i) {
            this.f28208a = atomicReference;
            this.f28209b = i;
        }

        @Override // g.b.a
        public void a(g.b.b<? super T> bVar) {
            PublishSubscriber<T> publishSubscriber;
            InnerSubscriber<T> innerSubscriber = new InnerSubscriber<>(bVar);
            bVar.onSubscribe(innerSubscriber);
            while (true) {
                publishSubscriber = this.f28208a.get();
                if (publishSubscriber == null || publishSubscriber.isDisposed()) {
                    PublishSubscriber<T> publishSubscriber2 = new PublishSubscriber<>(this.f28208a, this.f28209b);
                    if (this.f28208a.compareAndSet(publishSubscriber, publishSubscriber2)) {
                        publishSubscriber = publishSubscriber2;
                    } else {
                        continue;
                    }
                }
                if (publishSubscriber.add(innerSubscriber)) {
                    break;
                }
            }
            if (innerSubscriber.get() == Long.MIN_VALUE) {
                publishSubscriber.remove(innerSubscriber);
            } else {
                innerSubscriber.parent = publishSubscriber;
            }
            publishSubscriber.dispatch();
        }
    }

    private FlowablePublish(g.b.a<T> aVar, io.reactivex.e<T> eVar, AtomicReference<PublishSubscriber<T>> atomicReference, int i) {
        this.f28207e = aVar;
        this.f28204b = eVar;
        this.f28205c = atomicReference;
        this.f28206d = i;
    }

    public static <T> io.reactivex.b.a<T> a(io.reactivex.e<T> eVar, int i) {
        AtomicReference atomicReference = new AtomicReference();
        return io.reactivex.f.a.a((io.reactivex.b.a) new FlowablePublish(new a(atomicReference, i), eVar, atomicReference, i));
    }

    @Override // io.reactivex.e
    protected void b(g.b.b<? super T> bVar) {
        this.f28207e.a(bVar);
    }

    @Override // io.reactivex.b.a
    public void c(io.reactivex.c.e<? super io.reactivex.disposables.b> eVar) {
        PublishSubscriber<T> publishSubscriber;
        while (true) {
            publishSubscriber = this.f28205c.get();
            if (publishSubscriber != null && !publishSubscriber.isDisposed()) {
                break;
            }
            PublishSubscriber<T> publishSubscriber2 = new PublishSubscriber<>(this.f28205c, this.f28206d);
            if (this.f28205c.compareAndSet(publishSubscriber, publishSubscriber2)) {
                publishSubscriber = publishSubscriber2;
                break;
            }
        }
        boolean z = !publishSubscriber.shouldConnect.get() && publishSubscriber.shouldConnect.compareAndSet(false, true);
        try {
            eVar.accept(publishSubscriber);
            if (z) {
                this.f28204b.a((io.reactivex.h) publishSubscriber);
            }
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            throw ExceptionHelper.b(th);
        }
    }
}
