package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: MaybeMap.java */
/* loaded from: classes3.dex */
public final class j<T, R> extends io.reactivex.internal.operators.maybe.a<T, R> {

    /* renamed from: b */
    final io.reactivex.c.f<? super T, ? extends R> f28285b;

    /* compiled from: MaybeMap.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> implements io.reactivex.j<T>, io.reactivex.disposables.b {

        /* renamed from: a */
        final io.reactivex.j<? super R> f28286a;

        /* renamed from: b */
        final io.reactivex.c.f<? super T, ? extends R> f28287b;

        /* renamed from: c */
        io.reactivex.disposables.b f28288c;

        a(io.reactivex.j<? super R> jVar, io.reactivex.c.f<? super T, ? extends R> fVar) {
            this.f28286a = jVar;
            this.f28287b = fVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            io.reactivex.disposables.b bVar = this.f28288c;
            this.f28288c = DisposableHelper.DISPOSED;
            bVar.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f28288c.isDisposed();
        }

        @Override // io.reactivex.j
        public void onComplete() {
            this.f28286a.onComplete();
        }

        @Override // io.reactivex.j
        public void onError(Throwable th) {
            this.f28286a.onError(th);
        }

        @Override // io.reactivex.j
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f28288c, bVar)) {
                this.f28288c = bVar;
                this.f28286a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.j
        public void onSuccess(T t) {
            try {
                R apply = this.f28287b.apply(t);
                io.reactivex.d.a.b.a(apply, "The mapper returned a null item");
                this.f28286a.onSuccess(apply);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f28286a.onError(th);
            }
        }
    }

    public j(io.reactivex.k<T> kVar, io.reactivex.c.f<? super T, ? extends R> fVar) {
        super(kVar);
        this.f28285b = fVar;
    }

    @Override // io.reactivex.i
    protected void b(io.reactivex.j<? super R> jVar) {
        this.f28264a.a(new a(jVar, this.f28285b));
    }
}
