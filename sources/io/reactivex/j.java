package io.reactivex;

/* compiled from: MaybeObserver.java */
/* loaded from: classes3.dex */
public interface j<T> {
    void onComplete();

    void onError(Throwable th);

    void onSubscribe(io.reactivex.disposables.b bVar);

    void onSuccess(T t);
}
