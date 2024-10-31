package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.NoSuchElementException;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class AbstractIterator<T> extends UnmodifiableIterator<T> {

    /* renamed from: a */
    private State f15288a = State.NOT_READY;

    /* renamed from: b */
    private T f15289b;

    /* loaded from: classes2.dex */
    public enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    private boolean d() {
        this.f15288a = State.FAILED;
        this.f15289b = b();
        if (this.f15288a == State.DONE) {
            return false;
        }
        this.f15288a = State.READY;
        return true;
    }

    protected abstract T b();

    @CanIgnoreReturnValue
    public final T c() {
        this.f15288a = State.DONE;
        return null;
    }

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    public final boolean hasNext() {
        Preconditions.b(this.f15288a != State.FAILED);
        int i = C1495c.f15769a[this.f15288a.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i != 2) {
            return d();
        }
        return true;
    }

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    public final T next() {
        if (hasNext()) {
            this.f15288a = State.NOT_READY;
            T t = this.f15289b;
            this.f15289b = null;
            return t;
        }
        throw new NoSuchElementException();
    }
}
