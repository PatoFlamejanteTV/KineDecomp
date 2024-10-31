package retrofit2.adapter.rxjava2;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.m;
import io.reactivex.q;
import retrofit2.D;
import retrofit2.InterfaceC2578b;
import retrofit2.InterfaceC2580d;

/* compiled from: CallEnqueueObservable.java */
/* loaded from: classes3.dex */
final class b<T> extends m<D<T>> {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC2578b<T> f29465a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InterfaceC2578b<T> interfaceC2578b) {
        this.f29465a = interfaceC2578b;
    }

    @Override // io.reactivex.m
    protected void b(q<? super D<T>> qVar) {
        InterfaceC2578b<T> clone = this.f29465a.clone();
        a aVar = new a(clone, qVar);
        qVar.onSubscribe(aVar);
        if (aVar.isDisposed()) {
            return;
        }
        clone.a(aVar);
    }

    /* compiled from: CallEnqueueObservable.java */
    /* loaded from: classes3.dex */
    private static final class a<T> implements io.reactivex.disposables.b, InterfaceC2580d<T> {

        /* renamed from: a, reason: collision with root package name */
        private final InterfaceC2578b<?> f29466a;

        /* renamed from: b, reason: collision with root package name */
        private final q<? super D<T>> f29467b;

        /* renamed from: c, reason: collision with root package name */
        private volatile boolean f29468c;

        /* renamed from: d, reason: collision with root package name */
        boolean f29469d = false;

        a(InterfaceC2578b<?> interfaceC2578b, q<? super D<T>> qVar) {
            this.f29466a = interfaceC2578b;
            this.f29467b = qVar;
        }

        @Override // retrofit2.InterfaceC2580d
        public void a(InterfaceC2578b<T> interfaceC2578b, D<T> d2) {
            if (this.f29468c) {
                return;
            }
            try {
                this.f29467b.onNext(d2);
                if (this.f29468c) {
                    return;
                }
                this.f29469d = true;
                this.f29467b.onComplete();
            } catch (Throwable th) {
                if (this.f29469d) {
                    io.reactivex.f.a.b(th);
                    return;
                }
                if (this.f29468c) {
                    return;
                }
                try {
                    this.f29467b.onError(th);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    io.reactivex.f.a.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f29468c = true;
            this.f29466a.cancel();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f29468c;
        }

        @Override // retrofit2.InterfaceC2580d
        public void a(InterfaceC2578b<T> interfaceC2578b, Throwable th) {
            if (interfaceC2578b.S()) {
                return;
            }
            try {
                this.f29467b.onError(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                io.reactivex.f.a.b(new CompositeException(th, th2));
            }
        }
    }
}
