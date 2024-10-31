package io.reactivex.internal.operators.mixed;

import io.reactivex.c.f;
import io.reactivex.disposables.b;
import io.reactivex.exceptions.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.j;
import io.reactivex.k;
import io.reactivex.m;
import io.reactivex.p;
import io.reactivex.q;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class MaybeFlatMapObservable<T, R> extends m<R> {

    /* renamed from: a, reason: collision with root package name */
    final k<T> f28298a;

    /* renamed from: b, reason: collision with root package name */
    final f<? super T, ? extends p<? extends R>> f28299b;

    /* loaded from: classes3.dex */
    static final class FlatMapObserver<T, R> extends AtomicReference<b> implements q<R>, j<T>, b {
        private static final long serialVersionUID = -8948264376121066672L;
        final q<? super R> downstream;
        final f<? super T, ? extends p<? extends R>> mapper;

        FlatMapObserver(q<? super R> qVar, f<? super T, ? extends p<? extends R>> fVar) {
            this.downstream = qVar;
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

        @Override // io.reactivex.q
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.q
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.q
        public void onNext(R r) {
            this.downstream.onNext(r);
        }

        @Override // io.reactivex.q
        public void onSubscribe(b bVar) {
            DisposableHelper.replace(this, bVar);
        }

        @Override // io.reactivex.j
        public void onSuccess(T t) {
            try {
                p<? extends R> apply = this.mapper.apply(t);
                io.reactivex.d.a.b.a(apply, "The mapper returned a null Publisher");
                apply.a(this);
            } catch (Throwable th) {
                a.b(th);
                this.downstream.onError(th);
            }
        }
    }

    public MaybeFlatMapObservable(k<T> kVar, f<? super T, ? extends p<? extends R>> fVar) {
        this.f28298a = kVar;
        this.f28299b = fVar;
    }

    @Override // io.reactivex.m
    protected void b(q<? super R> qVar) {
        FlatMapObserver flatMapObserver = new FlatMapObserver(qVar, this.f28299b);
        qVar.onSubscribe(flatMapObserver);
        this.f28298a.a(flatMapObserver);
    }
}
