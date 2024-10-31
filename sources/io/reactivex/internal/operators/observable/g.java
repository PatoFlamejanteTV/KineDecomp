package io.reactivex.internal.operators.observable;

import io.reactivex.p;
import io.reactivex.q;

/* compiled from: ObservableIgnoreElementsCompletable.java */
/* loaded from: classes3.dex */
public final class g<T> extends io.reactivex.a implements io.reactivex.d.b.d<T> {

    /* renamed from: a, reason: collision with root package name */
    final p<T> f28333a;

    /* compiled from: ObservableIgnoreElementsCompletable.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements q<T>, io.reactivex.disposables.b {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.b f28334a;

        /* renamed from: b, reason: collision with root package name */
        io.reactivex.disposables.b f28335b;

        a(io.reactivex.b bVar) {
            this.f28334a = bVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f28335b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f28335b.isDisposed();
        }

        @Override // io.reactivex.q
        public void onComplete() {
            this.f28334a.onComplete();
        }

        @Override // io.reactivex.q
        public void onError(Throwable th) {
            this.f28334a.onError(th);
        }

        @Override // io.reactivex.q
        public void onNext(T t) {
        }

        @Override // io.reactivex.q
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f28335b = bVar;
            this.f28334a.onSubscribe(this);
        }
    }

    public g(p<T> pVar) {
        this.f28333a = pVar;
    }

    @Override // io.reactivex.a
    public void b(io.reactivex.b bVar) {
        this.f28333a.a(new a(bVar));
    }
}
