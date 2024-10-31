package io.reactivex;

/* compiled from: Emitter.java */
/* loaded from: classes3.dex */
public interface d<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);
}
