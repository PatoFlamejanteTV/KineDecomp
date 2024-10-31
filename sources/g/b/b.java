package g.b;

/* compiled from: Subscriber.java */
/* loaded from: classes3.dex */
public interface b<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(c cVar);
}
