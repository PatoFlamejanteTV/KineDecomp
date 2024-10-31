package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.q;

/* compiled from: ObservableEmpty.java */
/* loaded from: classes3.dex */
public final class c extends io.reactivex.m<Object> implements io.reactivex.d.b.l<Object> {

    /* renamed from: a, reason: collision with root package name */
    public static final io.reactivex.m<Object> f28322a = new c();

    private c() {
    }

    @Override // io.reactivex.m
    protected void b(q<? super Object> qVar) {
        EmptyDisposable.complete(qVar);
    }

    @Override // io.reactivex.d.b.l, java.util.concurrent.Callable
    public Object call() {
        return null;
    }
}
