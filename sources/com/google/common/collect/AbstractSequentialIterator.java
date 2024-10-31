package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {

    /* renamed from: a, reason: collision with root package name */
    private T f2652a;

    protected abstract T a(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractSequentialIterator(@Nullable T t) {
        this.f2652a = t;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2652a != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            return this.f2652a;
        } finally {
            this.f2652a = a(this.f2652a);
        }
    }
}
