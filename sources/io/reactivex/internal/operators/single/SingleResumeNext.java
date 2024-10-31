package io.reactivex.internal.operators.single;

import io.reactivex.c.f;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.s;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class SingleResumeNext<T> extends s<T> {

    /* renamed from: a, reason: collision with root package name */
    final u<? extends T> f28364a;

    /* renamed from: b, reason: collision with root package name */
    final f<? super Throwable, ? extends u<? extends T>> f28365b;

    /* loaded from: classes3.dex */
    static final class ResumeMainSingleObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements t<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -5314538511045349925L;
        final t<? super T> downstream;
        final f<? super Throwable, ? extends u<? extends T>> nextFunction;

        ResumeMainSingleObserver(t<? super T> tVar, f<? super Throwable, ? extends u<? extends T>> fVar) {
            this.downstream = tVar;
            this.nextFunction = fVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.t
        public void onError(Throwable th) {
            try {
                u<? extends T> apply = this.nextFunction.apply(th);
                io.reactivex.d.a.b.a(apply, "The nextFunction returned a null SingleSource.");
                apply.a(new io.reactivex.internal.observers.c(this, this.downstream));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.downstream.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.t
        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }
    }

    public SingleResumeNext(u<? extends T> uVar, f<? super Throwable, ? extends u<? extends T>> fVar) {
        this.f28364a = uVar;
        this.f28365b = fVar;
    }

    @Override // io.reactivex.s
    protected void b(t<? super T> tVar) {
        this.f28364a.a(new ResumeMainSingleObserver(tVar, this.f28365b));
    }
}
