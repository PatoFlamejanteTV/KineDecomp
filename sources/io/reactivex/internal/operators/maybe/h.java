package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.s;
import io.reactivex.t;

/* compiled from: MaybeIsEmptySingle.java */
/* loaded from: classes3.dex */
public final class h<T> extends s<Boolean> implements io.reactivex.d.b.f<T>, io.reactivex.d.b.c<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.k<T> f28281a;

    /* compiled from: MaybeIsEmptySingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements io.reactivex.j<T>, io.reactivex.disposables.b {

        /* renamed from: a, reason: collision with root package name */
        final t<? super Boolean> f28282a;

        /* renamed from: b, reason: collision with root package name */
        io.reactivex.disposables.b f28283b;

        a(t<? super Boolean> tVar) {
            this.f28282a = tVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f28283b.dispose();
            this.f28283b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f28283b.isDisposed();
        }

        @Override // io.reactivex.j
        public void onComplete() {
            this.f28283b = DisposableHelper.DISPOSED;
            this.f28282a.onSuccess(true);
        }

        @Override // io.reactivex.j
        public void onError(Throwable th) {
            this.f28283b = DisposableHelper.DISPOSED;
            this.f28282a.onError(th);
        }

        @Override // io.reactivex.j
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f28283b, bVar)) {
                this.f28283b = bVar;
                this.f28282a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.j
        public void onSuccess(T t) {
            this.f28283b = DisposableHelper.DISPOSED;
            this.f28282a.onSuccess(false);
        }
    }

    public h(io.reactivex.k<T> kVar) {
        this.f28281a = kVar;
    }

    @Override // io.reactivex.d.b.c
    public io.reactivex.i<Boolean> b() {
        return io.reactivex.f.a.a(new g(this.f28281a));
    }

    @Override // io.reactivex.s
    protected void b(t<? super Boolean> tVar) {
        this.f28281a.a(new a(tVar));
    }
}
