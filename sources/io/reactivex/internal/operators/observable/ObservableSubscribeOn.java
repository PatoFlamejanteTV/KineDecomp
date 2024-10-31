package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.q;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableSubscribeOn<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b */
    final r f28312b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class SubscribeOnObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements q<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 8094547886072529208L;
        final q<? super T> downstream;
        final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();

        SubscribeOnObserver(q<? super T> qVar) {
            this.downstream = qVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.q
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.q
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.q
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.q
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }

        void setDisposable(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    /* loaded from: classes3.dex */
    final class a implements Runnable {

        /* renamed from: a */
        private final SubscribeOnObserver<T> f28313a;

        a(SubscribeOnObserver<T> subscribeOnObserver) {
            this.f28313a = subscribeOnObserver;
        }

        @Override // java.lang.Runnable
        public void run() {
            ObservableSubscribeOn.this.f28315a.a(this.f28313a);
        }
    }

    public ObservableSubscribeOn(p<T> pVar, r rVar) {
        super(pVar);
        this.f28312b = rVar;
    }

    @Override // io.reactivex.m
    public void b(q<? super T> qVar) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(qVar);
        qVar.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.setDisposable(this.f28312b.a(new a(subscribeOnObserver)));
    }
}
