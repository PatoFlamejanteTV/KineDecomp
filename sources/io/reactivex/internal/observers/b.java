package io.reactivex.internal.observers;

import io.reactivex.d.b.i;

/* compiled from: BasicQueueDisposable.java */
/* loaded from: classes3.dex */
public abstract class b<T> implements i<T> {
    @Override // io.reactivex.d.b.n
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
