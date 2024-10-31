package io.reactivex.internal.operators.maybe;

import java.util.concurrent.Callable;

/* compiled from: MaybeFromCallable.java */
/* loaded from: classes3.dex */
public final class e<T> extends io.reactivex.i<T> implements Callable<T> {

    /* renamed from: a, reason: collision with root package name */
    final Callable<? extends T> f28275a;

    public e(Callable<? extends T> callable) {
        this.f28275a = callable;
    }

    @Override // io.reactivex.i
    protected void b(io.reactivex.j<? super T> jVar) {
        io.reactivex.disposables.b b2 = io.reactivex.disposables.c.b();
        jVar.onSubscribe(b2);
        if (b2.isDisposed()) {
            return;
        }
        try {
            T call = this.f28275a.call();
            if (b2.isDisposed()) {
                return;
            }
            if (call == null) {
                jVar.onComplete();
            } else {
                jVar.onSuccess(call);
            }
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            if (!b2.isDisposed()) {
                jVar.onError(th);
            } else {
                io.reactivex.f.a.b(th);
            }
        }
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return this.f28275a.call();
    }
}
