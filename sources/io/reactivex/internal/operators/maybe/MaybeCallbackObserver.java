package io.reactivex.internal.operators.maybe;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class MaybeCallbackObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.j<T>, io.reactivex.disposables.b, io.reactivex.e.a {
    private static final long serialVersionUID = -6076952298809384986L;
    final io.reactivex.c.a onComplete;
    final io.reactivex.c.e<? super Throwable> onError;
    final io.reactivex.c.e<? super T> onSuccess;

    public MaybeCallbackObserver(io.reactivex.c.e<? super T> eVar, io.reactivex.c.e<? super Throwable> eVar2, io.reactivex.c.a aVar) {
        this.onSuccess = eVar;
        this.onError = eVar2;
        this.onComplete = aVar;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.onError != io.reactivex.d.a.a.f28107f;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.j
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            io.reactivex.f.a.b(th);
        }
    }

    @Override // io.reactivex.j
    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            io.reactivex.f.a.b(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.j
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // io.reactivex.j
    public void onSuccess(T t) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onSuccess.accept(t);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            io.reactivex.f.a.b(th);
        }
    }
}
