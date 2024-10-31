package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.q;
import java.util.concurrent.Callable;

/* compiled from: ObservableError.java */
/* loaded from: classes3.dex */
public final class d<T> extends io.reactivex.m<T> {

    /* renamed from: a, reason: collision with root package name */
    final Callable<? extends Throwable> f28323a;

    public d(Callable<? extends Throwable> callable) {
        this.f28323a = callable;
    }

    @Override // io.reactivex.m
    public void b(q<? super T> qVar) {
        try {
            Throwable call = this.f28323a.call();
            io.reactivex.d.a.b.a(call, "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
            th = call;
        } catch (Throwable th) {
            th = th;
            io.reactivex.exceptions.a.b(th);
        }
        EmptyDisposable.error(th, qVar);
    }
}
