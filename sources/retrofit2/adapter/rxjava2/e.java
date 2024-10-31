package retrofit2.adapter.rxjava2;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.m;
import io.reactivex.q;
import retrofit2.D;

/* compiled from: ResultObservable.java */
/* loaded from: classes3.dex */
final class e<T> extends m<d<T>> {

    /* renamed from: a, reason: collision with root package name */
    private final m<D<T>> f29475a;

    /* compiled from: ResultObservable.java */
    /* loaded from: classes3.dex */
    private static class a<R> implements q<D<R>> {

        /* renamed from: a, reason: collision with root package name */
        private final q<? super d<R>> f29476a;

        a(q<? super d<R>> qVar) {
            this.f29476a = qVar;
        }

        @Override // io.reactivex.q
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(D<R> d2) {
            this.f29476a.onNext(d.a(d2));
        }

        @Override // io.reactivex.q
        public void onComplete() {
            this.f29476a.onComplete();
        }

        @Override // io.reactivex.q
        public void onError(Throwable th) {
            try {
                this.f29476a.onNext(d.a(th));
                this.f29476a.onComplete();
            } catch (Throwable th2) {
                try {
                    this.f29476a.onError(th2);
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    io.reactivex.f.a.b(new CompositeException(th2, th3));
                }
            }
        }

        @Override // io.reactivex.q
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f29476a.onSubscribe(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(m<D<T>> mVar) {
        this.f29475a = mVar;
    }

    @Override // io.reactivex.m
    protected void b(q<? super d<T>> qVar) {
        this.f29475a.a((q<? super D<T>>) new a(qVar));
    }
}
