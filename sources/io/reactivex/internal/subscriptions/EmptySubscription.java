package io.reactivex.internal.subscriptions;

import g.b.b;
import io.reactivex.d.b.k;

/* loaded from: classes3.dex */
public enum EmptySubscription implements k<Object> {
    INSTANCE;

    public static void complete(b<?> bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onComplete();
    }

    public static void error(Throwable th, b<?> bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onError(th);
    }

    @Override // g.b.c
    public void cancel() {
    }

    @Override // io.reactivex.d.b.n
    public void clear() {
    }

    @Override // io.reactivex.d.b.n
    public boolean isEmpty() {
        return true;
    }

    @Override // io.reactivex.d.b.n
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.d.b.n
    public Object poll() {
        return null;
    }

    @Override // g.b.c
    public void request(long j) {
        SubscriptionHelper.validate(j);
    }

    @Override // io.reactivex.d.b.j
    public int requestFusion(int i) {
        return i & 2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
