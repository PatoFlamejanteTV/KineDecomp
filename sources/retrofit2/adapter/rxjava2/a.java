package retrofit2.adapter.rxjava2;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.m;
import io.reactivex.q;
import retrofit2.D;

/* compiled from: BodyObservable.java */
/* loaded from: classes3.dex */
final class a<T> extends m<T> {

    /* renamed from: a, reason: collision with root package name */
    private final m<D<T>> f29462a;

    /* compiled from: BodyObservable.java */
    /* renamed from: retrofit2.adapter.rxjava2.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0174a<R> implements q<D<R>> {

        /* renamed from: a, reason: collision with root package name */
        private final q<? super R> f29463a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f29464b;

        C0174a(q<? super R> qVar) {
            this.f29463a = qVar;
        }

        @Override // io.reactivex.q
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(D<R> d2) {
            if (d2.c()) {
                this.f29463a.onNext(d2.a());
                return;
            }
            this.f29464b = true;
            HttpException httpException = new HttpException(d2);
            try {
                this.f29463a.onError(httpException);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                io.reactivex.f.a.b(new CompositeException(httpException, th));
            }
        }

        @Override // io.reactivex.q
        public void onComplete() {
            if (this.f29464b) {
                return;
            }
            this.f29463a.onComplete();
        }

        @Override // io.reactivex.q
        public void onError(Throwable th) {
            if (!this.f29464b) {
                this.f29463a.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            io.reactivex.f.a.b(assertionError);
        }

        @Override // io.reactivex.q
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f29463a.onSubscribe(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(m<D<T>> mVar) {
        this.f29462a = mVar;
    }

    @Override // io.reactivex.m
    protected void b(q<? super T> qVar) {
        this.f29462a.a((q<? super D<T>>) new C0174a(qVar));
    }
}
