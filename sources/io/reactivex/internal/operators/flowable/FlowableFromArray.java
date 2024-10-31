package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* loaded from: classes3.dex */
public final class FlowableFromArray<T> extends io.reactivex.e<T> {

    /* renamed from: b, reason: collision with root package name */
    final T[] f28194b;

    /* loaded from: classes3.dex */
    static final class ArrayConditionalSubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final io.reactivex.d.b.a<? super T> downstream;

        ArrayConditionalSubscription(io.reactivex.d.b.a<? super T> aVar, T[] tArr) {
            super(tArr);
            this.downstream = aVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void fastPath() {
            T[] tArr = this.array;
            int length = tArr.length;
            io.reactivex.d.b.a<? super T> aVar = this.downstream;
            for (int i = this.index; i != length; i++) {
                if (this.cancelled) {
                    return;
                }
                T t = tArr[i];
                if (t == null) {
                    aVar.onError(new NullPointerException("array element is null"));
                    return;
                }
                aVar.a(t);
            }
            if (this.cancelled) {
                return;
            }
            aVar.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0043, code lost:            r10.index = r2;        r6 = addAndGet(-r11);     */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void slowPath(long r11) {
            /*
                r10 = this;
                T[] r0 = r10.array
                int r1 = r0.length
                int r2 = r10.index
                io.reactivex.d.b.a<? super T> r3 = r10.downstream
                r4 = 0
                r6 = r11
            La:
                r11 = r4
            Lb:
                int r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r8 == 0) goto L31
                if (r2 == r1) goto L31
                boolean r8 = r10.cancelled
                if (r8 == 0) goto L16
                return
            L16:
                r8 = r0[r2]
                if (r8 != 0) goto L25
                java.lang.NullPointerException r11 = new java.lang.NullPointerException
                java.lang.String r12 = "array element is null"
                r11.<init>(r12)
                r3.onError(r11)
                return
            L25:
                boolean r8 = r3.a(r8)
                if (r8 == 0) goto L2e
                r8 = 1
                long r11 = r11 + r8
            L2e:
                int r2 = r2 + 1
                goto Lb
            L31:
                if (r2 != r1) goto L3b
                boolean r11 = r10.cancelled
                if (r11 != 0) goto L3a
                r3.onComplete()
            L3a:
                return
            L3b:
                long r6 = r10.get()
                int r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r8 != 0) goto Lb
                r10.index = r2
                long r11 = -r11
                long r6 = r10.addAndGet(r11)
                int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r11 != 0) goto La
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFromArray.ArrayConditionalSubscription.slowPath(long):void");
        }
    }

    /* loaded from: classes3.dex */
    static final class ArraySubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final g.b.b<? super T> downstream;

        ArraySubscription(g.b.b<? super T> bVar, T[] tArr) {
            super(tArr);
            this.downstream = bVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void fastPath() {
            T[] tArr = this.array;
            int length = tArr.length;
            g.b.b<? super T> bVar = this.downstream;
            for (int i = this.index; i != length; i++) {
                if (this.cancelled) {
                    return;
                }
                T t = tArr[i];
                if (t == null) {
                    bVar.onError(new NullPointerException("array element is null"));
                    return;
                }
                bVar.onNext(t);
            }
            if (this.cancelled) {
                return;
            }
            bVar.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:            r10.index = r2;        r6 = addAndGet(-r11);     */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void slowPath(long r11) {
            /*
                r10 = this;
                T[] r0 = r10.array
                int r1 = r0.length
                int r2 = r10.index
                g.b.b<? super T> r3 = r10.downstream
                r4 = 0
                r6 = r11
            La:
                r11 = r4
            Lb:
                int r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r8 == 0) goto L2e
                if (r2 == r1) goto L2e
                boolean r8 = r10.cancelled
                if (r8 == 0) goto L16
                return
            L16:
                r8 = r0[r2]
                if (r8 != 0) goto L25
                java.lang.NullPointerException r11 = new java.lang.NullPointerException
                java.lang.String r12 = "array element is null"
                r11.<init>(r12)
                r3.onError(r11)
                return
            L25:
                r3.onNext(r8)
                r8 = 1
                long r11 = r11 + r8
                int r2 = r2 + 1
                goto Lb
            L2e:
                if (r2 != r1) goto L38
                boolean r11 = r10.cancelled
                if (r11 != 0) goto L37
                r3.onComplete()
            L37:
                return
            L38:
                long r6 = r10.get()
                int r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r8 != 0) goto Lb
                r10.index = r2
                long r11 = -r11
                long r6 = r10.addAndGet(r11)
                int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r11 != 0) goto La
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFromArray.ArraySubscription.slowPath(long):void");
        }
    }

    /* loaded from: classes3.dex */
    static abstract class BaseArraySubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        final T[] array;
        volatile boolean cancelled;
        int index;

        BaseArraySubscription(T[] tArr) {
            this.array = tArr;
        }

        @Override // g.b.c
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // io.reactivex.d.b.n
        public final void clear() {
            this.index = this.array.length;
        }

        abstract void fastPath();

        @Override // io.reactivex.d.b.n
        public final boolean isEmpty() {
            return this.index == this.array.length;
        }

        @Override // io.reactivex.d.b.n
        public final T poll() {
            int i = this.index;
            T[] tArr = this.array;
            if (i == tArr.length) {
                return null;
            }
            this.index = i + 1;
            T t = tArr[i];
            io.reactivex.d.a.b.a((Object) t, "array element is null");
            return t;
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

    public FlowableFromArray(T[] tArr) {
        this.f28194b = tArr;
    }

    @Override // io.reactivex.e
    public void b(g.b.b<? super T> bVar) {
        if (bVar instanceof io.reactivex.d.b.a) {
            bVar.onSubscribe(new ArrayConditionalSubscription((io.reactivex.d.b.a) bVar, this.f28194b));
        } else {
            bVar.onSubscribe(new ArraySubscription(bVar, this.f28194b));
        }
    }
}
