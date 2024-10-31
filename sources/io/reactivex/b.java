package io.reactivex;

/* compiled from: CompletableObserver.java */
/* loaded from: classes3.dex */
public interface b {
    void onComplete();

    void onError(Throwable th);

    void onSubscribe(io.reactivex.disposables.b bVar);
}
