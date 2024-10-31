package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: MaybeFilter.java */
/* loaded from: classes3.dex */
public final class c<T> extends io.reactivex.internal.operators.maybe.a<T, T> {

    /* renamed from: b */
    final io.reactivex.c.h<? super T> f28266b;

    /* compiled from: MaybeFilter.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements io.reactivex.j<T>, io.reactivex.disposables.b {

        /* renamed from: a */
        final io.reactivex.j<? super T> f28267a;

        /* renamed from: b */
        final io.reactivex.c.h<? super T> f28268b;

        /* renamed from: c */
        io.reactivex.disposables.b f28269c;

        a(io.reactivex.j<? super T> jVar, io.reactivex.c.h<? super T> hVar) {
            this.f28267a = jVar;
            this.f28268b = hVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            io.reactivex.disposables.b bVar = this.f28269c;
            this.f28269c = DisposableHelper.DISPOSED;
            bVar.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f28269c.isDisposed();
        }

        @Override // io.reactivex.j
        public void onComplete() {
            this.f28267a.onComplete();
        }

        @Override // io.reactivex.j
        public void onError(Throwable th) {
            this.f28267a.onError(th);
        }

        @Override // io.reactivex.j
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f28269c, bVar)) {
                this.f28269c = bVar;
                this.f28267a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.j
        public void onSuccess(T t) {
            try {
                if (this.f28268b.test(t)) {
                    this.f28267a.onSuccess(t);
                } else {
                    this.f28267a.onComplete();
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f28267a.onError(th);
            }
        }
    }

    public c(io.reactivex.k<T> kVar, io.reactivex.c.h<? super T> hVar) {
        super(kVar);
        this.f28266b = hVar;
    }

    @Override // io.reactivex.i
    protected void b(io.reactivex.j<? super T> jVar) {
        this.f28264a.a(new a(jVar, this.f28266b));
    }
}
