package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class MaybeSwitchIfEmpty<T> extends a<T, T> {

    /* renamed from: b */
    final io.reactivex.k<? extends T> f28260b;

    /* loaded from: classes3.dex */
    static final class SwitchIfEmptyMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.j<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -2223459372976438024L;
        final io.reactivex.j<? super T> downstream;
        final io.reactivex.k<? extends T> other;

        /* loaded from: classes3.dex */
        static final class a<T> implements io.reactivex.j<T> {

            /* renamed from: a */
            final io.reactivex.j<? super T> f28261a;

            /* renamed from: b */
            final AtomicReference<io.reactivex.disposables.b> f28262b;

            a(io.reactivex.j<? super T> jVar, AtomicReference<io.reactivex.disposables.b> atomicReference) {
                this.f28261a = jVar;
                this.f28262b = atomicReference;
            }

            @Override // io.reactivex.j
            public void onComplete() {
                this.f28261a.onComplete();
            }

            @Override // io.reactivex.j
            public void onError(Throwable th) {
                this.f28261a.onError(th);
            }

            @Override // io.reactivex.j
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this.f28262b, bVar);
            }

            @Override // io.reactivex.j
            public void onSuccess(T t) {
                this.f28261a.onSuccess(t);
            }
        }

        SwitchIfEmptyMaybeObserver(io.reactivex.j<? super T> jVar, io.reactivex.k<? extends T> kVar) {
            this.downstream = jVar;
            this.other = kVar;
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
            io.reactivex.disposables.b bVar = get();
            if (bVar == DisposableHelper.DISPOSED || !compareAndSet(bVar, null)) {
                return;
            }
            this.other.a(new a(this.downstream, this));
        }

        @Override // io.reactivex.j
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.j
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.j
        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }
    }

    public MaybeSwitchIfEmpty(io.reactivex.k<T> kVar, io.reactivex.k<? extends T> kVar2) {
        super(kVar);
        this.f28260b = kVar2;
    }

    @Override // io.reactivex.i
    protected void b(io.reactivex.j<? super T> jVar) {
        this.f28264a.a(new SwitchIfEmptyMaybeObserver(jVar, this.f28260b));
    }
}
