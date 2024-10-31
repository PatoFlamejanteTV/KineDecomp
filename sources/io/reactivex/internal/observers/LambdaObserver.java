package io.reactivex.internal.observers;

import io.reactivex.c.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.q;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class LambdaObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements q<T>, io.reactivex.disposables.b, io.reactivex.e.a {
    private static final long serialVersionUID = -7251123623727029452L;
    final io.reactivex.c.a onComplete;
    final e<? super Throwable> onError;
    final e<? super T> onNext;
    final e<? super io.reactivex.disposables.b> onSubscribe;

    public LambdaObserver(e<? super T> eVar, e<? super Throwable> eVar2, io.reactivex.c.a aVar, e<? super io.reactivex.disposables.b> eVar3) {
        this.onNext = eVar;
        this.onError = eVar2;
        this.onComplete = aVar;
        this.onSubscribe = eVar3;
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
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.q
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            io.reactivex.f.a.b(th);
        }
    }

    @Override // io.reactivex.q
    public void onError(Throwable th) {
        if (!isDisposed()) {
            lazySet(DisposableHelper.DISPOSED);
            try {
                this.onError.accept(th);
                return;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                io.reactivex.f.a.b(new CompositeException(th, th2));
                return;
            }
        }
        io.reactivex.f.a.b(th);
    }

    @Override // io.reactivex.q
    public void onNext(T t) {
        if (isDisposed()) {
            return;
        }
        try {
            this.onNext.accept(t);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            get().dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.q
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                bVar.dispose();
                onError(th);
            }
        }
    }
}
