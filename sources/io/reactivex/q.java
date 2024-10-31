package io.reactivex;

/* compiled from: Observer.java */
/* loaded from: classes3.dex */
public interface q<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(io.reactivex.disposables.b bVar);
}
