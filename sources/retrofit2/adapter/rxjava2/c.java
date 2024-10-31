package retrofit2.adapter.rxjava2;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.m;
import io.reactivex.q;
import retrofit2.D;
import retrofit2.InterfaceC2578b;

/* compiled from: CallExecuteObservable.java */
/* loaded from: classes3.dex */
final class c<T> extends m<D<T>> {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC2578b<T> f29470a;

    /* compiled from: CallExecuteObservable.java */
    /* loaded from: classes3.dex */
    private static final class a implements io.reactivex.disposables.b {

        /* renamed from: a, reason: collision with root package name */
        private final InterfaceC2578b<?> f29471a;

        /* renamed from: b, reason: collision with root package name */
        private volatile boolean f29472b;

        a(InterfaceC2578b<?> interfaceC2578b) {
            this.f29471a = interfaceC2578b;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f29472b = true;
            this.f29471a.cancel();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f29472b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(InterfaceC2578b<T> interfaceC2578b) {
        this.f29470a = interfaceC2578b;
    }

    @Override // io.reactivex.m
    protected void b(q<? super D<T>> qVar) {
        boolean z;
        InterfaceC2578b<T> clone = this.f29470a.clone();
        a aVar = new a(clone);
        qVar.onSubscribe(aVar);
        if (aVar.isDisposed()) {
            return;
        }
        try {
            D<T> execute = clone.execute();
            if (!aVar.isDisposed()) {
                qVar.onNext(execute);
            }
            if (aVar.isDisposed()) {
                return;
            }
            try {
                qVar.onComplete();
            } catch (Throwable th) {
                th = th;
                z = true;
                io.reactivex.exceptions.a.b(th);
                if (z) {
                    io.reactivex.f.a.b(th);
                    return;
                }
                if (aVar.isDisposed()) {
                    return;
                }
                try {
                    qVar.onError(th);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    io.reactivex.f.a.b(new CompositeException(th, th2));
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }
}
