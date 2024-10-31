package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class AbstractIterator<T> extends UnmodifiableIterator<T> {

    /* renamed from: a, reason: collision with root package name */
    private State f2637a = State.NOT_READY;
    private T b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    protected abstract T a();

    /* JADX INFO: Access modifiers changed from: protected */
    public final T b() {
        this.f2637a = State.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Preconditions.b(this.f2637a != State.FAILED);
        switch (this.f2637a) {
            case DONE:
                return false;
            case READY:
                return true;
            default:
                return c();
        }
    }

    private boolean c() {
        this.f2637a = State.FAILED;
        this.b = a();
        if (this.f2637a == State.DONE) {
            return false;
        }
        this.f2637a = State.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f2637a = State.NOT_READY;
        return this.b;
    }
}
