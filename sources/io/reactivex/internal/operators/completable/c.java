package io.reactivex.internal.operators.completable;

import java.util.concurrent.Callable;

/* compiled from: CompletableFromCallable.java */
/* loaded from: classes3.dex */
public final class c extends io.reactivex.a {

    /* renamed from: a, reason: collision with root package name */
    final Callable<?> f28159a;

    public c(Callable<?> callable) {
        this.f28159a = callable;
    }

    @Override // io.reactivex.a
    protected void b(io.reactivex.b bVar) {
        io.reactivex.disposables.b b2 = io.reactivex.disposables.c.b();
        bVar.onSubscribe(b2);
        try {
            this.f28159a.call();
            if (b2.isDisposed()) {
                return;
            }
            bVar.onComplete();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            if (!b2.isDisposed()) {
                bVar.onError(th);
            } else {
                io.reactivex.f.a.b(th);
            }
        }
    }
}
