package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* compiled from: FlowableElementAtMaybe.java */
/* loaded from: classes3.dex */
public final class e<T> extends io.reactivex.i<T> implements io.reactivex.d.b.b<T> {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.e<T> f28224a;

    /* renamed from: b, reason: collision with root package name */
    final long f28225b;

    /* compiled from: FlowableElementAtMaybe.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements io.reactivex.h<T>, io.reactivex.disposables.b {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.j<? super T> f28226a;

        /* renamed from: b, reason: collision with root package name */
        final long f28227b;

        /* renamed from: c, reason: collision with root package name */
        g.b.c f28228c;

        /* renamed from: d, reason: collision with root package name */
        long f28229d;

        /* renamed from: e, reason: collision with root package name */
        boolean f28230e;

        a(io.reactivex.j<? super T> jVar, long j) {
            this.f28226a = jVar;
            this.f28227b = j;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f28228c.cancel();
            this.f28228c = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f28228c == SubscriptionHelper.CANCELLED;
        }

        @Override // g.b.b
        public void onComplete() {
            this.f28228c = SubscriptionHelper.CANCELLED;
            if (this.f28230e) {
                return;
            }
            this.f28230e = true;
            this.f28226a.onComplete();
        }

        @Override // g.b.b
        public void onError(Throwable th) {
            if (this.f28230e) {
                io.reactivex.f.a.b(th);
                return;
            }
            this.f28230e = true;
            this.f28228c = SubscriptionHelper.CANCELLED;
            this.f28226a.onError(th);
        }

        @Override // g.b.b
        public void onNext(T t) {
            if (this.f28230e) {
                return;
            }
            long j = this.f28229d;
            if (j == this.f28227b) {
                this.f28230e = true;
                this.f28228c.cancel();
                this.f28228c = SubscriptionHelper.CANCELLED;
                this.f28226a.onSuccess(t);
                return;
            }
            this.f28229d = j + 1;
        }

        @Override // io.reactivex.h, g.b.b
        public void onSubscribe(g.b.c cVar) {
            if (SubscriptionHelper.validate(this.f28228c, cVar)) {
                this.f28228c = cVar;
                this.f28226a.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }
    }

    public e(io.reactivex.e<T> eVar, long j) {
        this.f28224a = eVar;
        this.f28225b = j;
    }

    @Override // io.reactivex.d.b.b
    public io.reactivex.e<T> a() {
        return io.reactivex.f.a.a(new FlowableElementAt(this.f28224a, this.f28225b, null, false));
    }

    @Override // io.reactivex.i
    protected void b(io.reactivex.j<? super T> jVar) {
        this.f28224a.a((io.reactivex.h) new a(jVar, this.f28225b));
    }
}
