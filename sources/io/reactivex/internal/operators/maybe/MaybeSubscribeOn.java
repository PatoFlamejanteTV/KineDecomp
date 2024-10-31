package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class MaybeSubscribeOn<T> extends io.reactivex.internal.operators.maybe.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final r f28257b;

    /* loaded from: classes3.dex */
    static final class SubscribeOnMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.j<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 8571289934935992137L;
        final io.reactivex.j<? super T> downstream;
        final SequentialDisposable task = new SequentialDisposable();

        SubscribeOnMaybeObserver(io.reactivex.j<? super T> jVar) {
            this.downstream = jVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            this.task.dispose();
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
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // io.reactivex.j
        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }
    }

    /* loaded from: classes3.dex */
    static final class a<T> implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.j<? super T> f28258a;

        /* renamed from: b, reason: collision with root package name */
        final io.reactivex.k<T> f28259b;

        a(io.reactivex.j<? super T> jVar, io.reactivex.k<T> kVar) {
            this.f28258a = jVar;
            this.f28259b = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f28259b.a(this.f28258a);
        }
    }

    public MaybeSubscribeOn(io.reactivex.k<T> kVar, r rVar) {
        super(kVar);
        this.f28257b = rVar;
    }

    @Override // io.reactivex.i
    protected void b(io.reactivex.j<? super T> jVar) {
        SubscribeOnMaybeObserver subscribeOnMaybeObserver = new SubscribeOnMaybeObserver(jVar);
        jVar.onSubscribe(subscribeOnMaybeObserver);
        subscribeOnMaybeObserver.task.replace(this.f28257b.a(new a(subscribeOnMaybeObserver, this.f28264a)));
    }
}
