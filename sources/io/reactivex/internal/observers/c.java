package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ResumeSingleObserver.java */
/* loaded from: classes3.dex */
public final class c<T> implements t<T> {

    /* renamed from: a */
    final AtomicReference<io.reactivex.disposables.b> f28149a;

    /* renamed from: b */
    final t<? super T> f28150b;

    public c(AtomicReference<io.reactivex.disposables.b> atomicReference, t<? super T> tVar) {
        this.f28149a = atomicReference;
        this.f28150b = tVar;
    }

    @Override // io.reactivex.t
    public void onError(Throwable th) {
        this.f28150b.onError(th);
    }

    @Override // io.reactivex.t
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        DisposableHelper.replace(this.f28149a, bVar);
    }

    @Override // io.reactivex.t
    public void onSuccess(T t) {
        this.f28150b.onSuccess(t);
    }
}
