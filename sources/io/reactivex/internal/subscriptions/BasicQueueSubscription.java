package io.reactivex.internal.subscriptions;

import io.reactivex.d.b.k;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public abstract class BasicQueueSubscription<T> extends AtomicLong implements k<T> {
    private static final long serialVersionUID = -6671519529404341862L;

    @Override // io.reactivex.d.b.n
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
