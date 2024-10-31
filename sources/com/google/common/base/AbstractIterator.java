package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class AbstractIterator<T> implements Iterator<T> {

    /* renamed from: a */
    private State f15066a = State.NOT_READY;

    /* renamed from: b */
    private T f15067b;

    /* loaded from: classes2.dex */
    public enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    private boolean d() {
        this.f15066a = State.FAILED;
        this.f15067b = b();
        if (this.f15066a == State.DONE) {
            return false;
        }
        this.f15066a = State.READY;
        return true;
    }

    protected abstract T b();

    @CanIgnoreReturnValue
    @Nullable
    public final T c() {
        this.f15066a = State.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Preconditions.b(this.f15066a != State.FAILED);
        int i = a.f15126a[this.f15066a.ordinal()];
        if (i == 1) {
            return true;
        }
        if (i != 2) {
            return d();
        }
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.f15066a = State.NOT_READY;
            T t = this.f15067b;
            this.f15067b = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
