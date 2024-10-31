package io.reactivex.internal.operators.flowable;

import io.reactivex.m;
import io.reactivex.q;

/* compiled from: FlowableFromObservable.java */
/* loaded from: classes3.dex */
public final class h<T> extends io.reactivex.e<T> {

    /* renamed from: b, reason: collision with root package name */
    private final m<T> f28235b;

    /* compiled from: FlowableFromObservable.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements q<T>, g.b.c {

        /* renamed from: a, reason: collision with root package name */
        final g.b.b<? super T> f28236a;

        /* renamed from: b, reason: collision with root package name */
        io.reactivex.disposables.b f28237b;

        a(g.b.b<? super T> bVar) {
            this.f28236a = bVar;
        }

        @Override // g.b.c
        public void cancel() {
            this.f28237b.dispose();
        }

        @Override // io.reactivex.q
        public void onComplete() {
            this.f28236a.onComplete();
        }

        @Override // io.reactivex.q
        public void onError(Throwable th) {
            this.f28236a.onError(th);
        }

        @Override // io.reactivex.q
        public void onNext(T t) {
            this.f28236a.onNext(t);
        }

        @Override // io.reactivex.q
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f28237b = bVar;
            this.f28236a.onSubscribe(this);
        }

        @Override // g.b.c
        public void request(long j) {
        }
    }

    public h(m<T> mVar) {
        this.f28235b = mVar;
    }

    @Override // io.reactivex.e
    protected void b(g.b.b<? super T> bVar) {
        this.f28235b.a((q) new a(bVar));
    }
}
