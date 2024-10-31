package io.reactivex.internal.disposables;

import io.reactivex.c.d;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class CancellableDisposable extends AtomicReference<d> implements io.reactivex.disposables.b {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(d dVar) {
        super(dVar);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        d andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        try {
            andSet.cancel();
        } catch (Exception e2) {
            io.reactivex.exceptions.a.b(e2);
            io.reactivex.f.a.b(e2);
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return get() == null;
    }
}
