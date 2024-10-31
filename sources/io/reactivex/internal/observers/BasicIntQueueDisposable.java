package io.reactivex.internal.observers;

import io.reactivex.d.b.i;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements i<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    @Override // io.reactivex.d.b.n
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }

    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
