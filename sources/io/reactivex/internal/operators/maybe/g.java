package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: MaybeIsEmpty.java */
/* loaded from: classes3.dex */
public final class g<T> extends io.reactivex.internal.operators.maybe.a<T, Boolean> {

    /* compiled from: MaybeIsEmpty.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements io.reactivex.j<T>, io.reactivex.disposables.b {

        /* renamed from: a */
        final io.reactivex.j<? super Boolean> f28279a;

        /* renamed from: b */
        io.reactivex.disposables.b f28280b;

        a(io.reactivex.j<? super Boolean> jVar) {
            this.f28279a = jVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f28280b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f28280b.isDisposed();
        }

        @Override // io.reactivex.j
        public void onComplete() {
            this.f28279a.onSuccess(true);
        }

        @Override // io.reactivex.j
        public void onError(Throwable th) {
            this.f28279a.onError(th);
        }

        @Override // io.reactivex.j
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f28280b, bVar)) {
                this.f28280b = bVar;
                this.f28279a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.j
        public void onSuccess(T t) {
            this.f28279a.onSuccess(false);
        }
    }

    public g(io.reactivex.k<T> kVar) {
        super(kVar);
    }

    @Override // io.reactivex.i
    protected void b(io.reactivex.j<? super Boolean> jVar) {
        this.f28264a.a(new a(jVar));
    }
}
