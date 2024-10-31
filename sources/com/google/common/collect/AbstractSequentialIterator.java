package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {

    /* renamed from: a */
    private T f15330a;

    public AbstractSequentialIterator(@Nullable T t) {
        this.f15330a = t;
    }

    protected abstract T a(T t);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f15330a != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            try {
                return this.f15330a;
            } finally {
                this.f15330a = a(this.f15330a);
            }
        }
        throw new NoSuchElementException();
    }
}
