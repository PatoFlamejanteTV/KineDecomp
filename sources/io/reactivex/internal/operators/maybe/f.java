package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: MaybeFromCompletable.java */
/* loaded from: classes3.dex */
public final class f<T> extends io.reactivex.i<T> implements io.reactivex.d.b.e {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.c f28276a;

    /* compiled from: MaybeFromCompletable.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements io.reactivex.b, io.reactivex.disposables.b {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.j<? super T> f28277a;

        /* renamed from: b, reason: collision with root package name */
        io.reactivex.disposables.b f28278b;

        a(io.reactivex.j<? super T> jVar) {
            this.f28277a = jVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f28278b.dispose();
            this.f28278b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f28278b.isDisposed();
        }

        @Override // io.reactivex.b
        public void onComplete() {
            this.f28278b = DisposableHelper.DISPOSED;
            this.f28277a.onComplete();
        }

        @Override // io.reactivex.b
        public void onError(Throwable th) {
            this.f28278b = DisposableHelper.DISPOSED;
            this.f28277a.onError(th);
        }

        @Override // io.reactivex.b
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f28278b, bVar)) {
                this.f28278b = bVar;
                this.f28277a.onSubscribe(this);
            }
        }
    }

    public f(io.reactivex.c cVar) {
        this.f28276a = cVar;
    }

    @Override // io.reactivex.i
    protected void b(io.reactivex.j<? super T> jVar) {
        this.f28276a.a(new a(jVar));
    }
}
