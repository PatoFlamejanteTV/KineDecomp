package io.reactivex.internal.disposables;

import io.reactivex.d.b.i;
import io.reactivex.j;
import io.reactivex.q;
import io.reactivex.t;

/* loaded from: classes3.dex */
public enum EmptyDisposable implements i<Object> {
    INSTANCE,
    NEVER;

    public static void complete(q<?> qVar) {
        qVar.onSubscribe(INSTANCE);
        qVar.onComplete();
    }

    public static void error(Throwable th, q<?> qVar) {
        qVar.onSubscribe(INSTANCE);
        qVar.onError(th);
    }

    @Override // io.reactivex.d.b.n
    public void clear() {
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this == INSTANCE;
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
    public Object poll() throws Exception {
        return null;
    }

    @Override // io.reactivex.d.b.j
    public int requestFusion(int i) {
        return i & 2;
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public static void complete(j<?> jVar) {
        jVar.onSubscribe(INSTANCE);
        jVar.onComplete();
    }

    public static void error(Throwable th, io.reactivex.b bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onError(th);
    }

    public static void complete(io.reactivex.b bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onComplete();
    }

    public static void error(Throwable th, t<?> tVar) {
        tVar.onSubscribe(INSTANCE);
        tVar.onError(th);
    }

    public static void error(Throwable th, j<?> jVar) {
        jVar.onSubscribe(INSTANCE);
        jVar.onError(th);
    }
}
