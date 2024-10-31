package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class MaybeFlatMapCompletable<T> extends io.reactivex.a {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.k<T> f28249a;

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.c.f<? super T, ? extends io.reactivex.c> f28250b;

    /* loaded from: classes3.dex */
    static final class FlatMapCompletableObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.j<T>, io.reactivex.b, io.reactivex.disposables.b {
        private static final long serialVersionUID = -2177128922851101253L;
        final io.reactivex.b downstream;
        final io.reactivex.c.f<? super T, ? extends io.reactivex.c> mapper;

        FlatMapCompletableObserver(io.reactivex.b bVar, io.reactivex.c.f<? super T, ? extends io.reactivex.c> fVar) {
            this.downstream = bVar;
            this.mapper = fVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.j
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.j
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.j
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this, bVar);
        }

        @Override // io.reactivex.j
        public void onSuccess(T t) {
            try {
                io.reactivex.c apply = this.mapper.apply(t);
                io.reactivex.d.a.b.a(apply, "The mapper returned a null CompletableSource");
                io.reactivex.c cVar = apply;
                if (isDisposed()) {
                    return;
                }
                cVar.a(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                onError(th);
            }
        }
    }

    public MaybeFlatMapCompletable(io.reactivex.k<T> kVar, io.reactivex.c.f<? super T, ? extends io.reactivex.c> fVar) {
        this.f28249a = kVar;
        this.f28250b = fVar;
    }

    @Override // io.reactivex.a
    protected void b(io.reactivex.b bVar) {
        FlatMapCompletableObserver flatMapCompletableObserver = new FlatMapCompletableObserver(bVar, this.f28250b);
        bVar.onSubscribe(flatMapCompletableObserver);
        this.f28249a.a(flatMapCompletableObserver);
    }
}
