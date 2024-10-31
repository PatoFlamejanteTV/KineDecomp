package io.reactivex.internal.operators.maybe;

import io.reactivex.d.b.l;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: MaybeEmpty.java */
/* loaded from: classes3.dex */
public final class b extends io.reactivex.i<Object> implements l<Object> {

    /* renamed from: a, reason: collision with root package name */
    public static final b f28265a = new b();

    @Override // io.reactivex.i
    protected void b(io.reactivex.j<? super Object> jVar) {
        EmptyDisposable.complete(jVar);
    }

    @Override // io.reactivex.d.b.l, java.util.concurrent.Callable
    public Object call() {
        return null;
    }
}
