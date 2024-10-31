package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.q;

/* compiled from: ObservableSingleMaybe.java */
/* loaded from: classes3.dex */
public final class k<T> extends io.reactivex.i<T> {

    /* renamed from: a, reason: collision with root package name */
    final p<T> f28347a;

    /* compiled from: ObservableSingleMaybe.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements q<T>, io.reactivex.disposables.b {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.j<? super T> f28348a;

        /* renamed from: b, reason: collision with root package name */
        io.reactivex.disposables.b f28349b;

        /* renamed from: c, reason: collision with root package name */
        T f28350c;

        /* renamed from: d, reason: collision with root package name */
        boolean f28351d;

        a(io.reactivex.j<? super T> jVar) {
            this.f28348a = jVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f28349b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f28349b.isDisposed();
        }

        @Override // io.reactivex.q
        public void onComplete() {
            if (this.f28351d) {
                return;
            }
            this.f28351d = true;
            T t = this.f28350c;
            this.f28350c = null;
            if (t == null) {
                this.f28348a.onComplete();
            } else {
                this.f28348a.onSuccess(t);
            }
        }

        @Override // io.reactivex.q
        public void onError(Throwable th) {
            if (this.f28351d) {
                io.reactivex.f.a.b(th);
            } else {
                this.f28351d = true;
                this.f28348a.onError(th);
            }
        }

        @Override // io.reactivex.q
        public void onNext(T t) {
            if (this.f28351d) {
                return;
            }
            if (this.f28350c != null) {
                this.f28351d = true;
                this.f28349b.dispose();
                this.f28348a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.f28350c = t;
        }

        @Override // io.reactivex.q
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f28349b, bVar)) {
                this.f28349b = bVar;
                this.f28348a.onSubscribe(this);
            }
        }
    }

    public k(p<T> pVar) {
        this.f28347a = pVar;
    }

    @Override // io.reactivex.i
    public void b(io.reactivex.j<? super T> jVar) {
        this.f28347a.a(new a(jVar));
    }
}
