package io.reactivex;

/* compiled from: SingleObserver.java */
/* loaded from: classes3.dex */
public interface t<T> {
    void onError(Throwable th);

    void onSubscribe(io.reactivex.disposables.b bVar);

    void onSuccess(T t);
}
